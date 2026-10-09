// 1.магазин с общим складом, в который параллельно лезут покупатели и поставщик. 
// Входных файлов нет, программа сама их создаёт и читает.
// Что сделать:
// Класс Product (артикул, название, цена). В main создай 8–10 товаров списком и 
// запиши их в stock.csv в формате артикул;название;количество. Количество задай 
// случайно.
// Прочитай этот же файл обратно в Warehouse. Остатки хранятся в Map<String, Integer>.
// В Warehouse сделай методы boolean reserve(String sku, int qty) и void restock
// (String sku, int qty). Оба synchronized. Если товара не хватает, reserve возвращает 
// false и ничего не списывает.
// Customer implements Runnable: в цикле из 50 итераций берёт случайный артикул и 
// количество 1–5 и пытается купить. Успешные и неуспешные покупки считает в своих 
// полях.
// Supplier extends Thread: раз в 100 мс пополняет случайный товар, пока флаг volatile 
// boolean open равен true.
// Запусти 5 покупателей. Дождись их через join(), потом поставь open = false и дождись 
// поставщика.
// Запиши report.txt: остатки по каждому товару, число успешных и неуспешных заказов, 
// выручка.
// Проверка корректности:
// Должно сходиться: начальный остаток + всего поставлено − всего продано = итоговый 
// остаток. Проверь это в коде.
// Убери synchronized и прогони 10 раз. Баланс должен поплыть.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

class First{
    static class Product {
        private final String sku;
        private final String name;
        private final double price;

        public Product(String sku, String name, double price) {
            this.sku = sku;
            this.name = name;
            this.price = price;
        }

        public String getSku() {
            return sku;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    static class Warehouse {
        private final Map<String, Integer> stock = new HashMap<>();
        private final Map<String, Double> prices = new HashMap<>();
        private final AtomicInteger successfulOrders = new AtomicInteger(0);
        private final AtomicInteger failedOrders = new AtomicInteger(0);
        private final AtomicInteger revenue = new AtomicInteger(0);

        public synchronized boolean reserve(String sku, int qty) {
            Integer current = stock.get(sku);
            if (current == null || current < qty) {
                failedOrders.incrementAndGet();
                return false;
            }
            stock.put(sku, current - qty);
            successfulOrders.incrementAndGet();
            revenue.addAndGet((int)(prices.get(sku) * qty));
            return true;
        }

        public synchronized void restock(String sku, int qty) {
            stock.merge(sku, qty, Integer::sum);
        }

        public Map<String, Integer> getStock() {
            return Collections.unmodifiableMap(stock);
        }

        public int getSuccessfulOrders() {
            return successfulOrders.get();
        }

        public int getFailedOrders() {
            return failedOrders.get();
        }

        public int getRevenue() {
            return revenue.get();
        }

        public void setPrice(String sku, double price) {
            prices.put(sku, price);
        }
    }

    static class Customer implements Runnable {
        private final Warehouse warehouse;
        private final List<Product> products;
        private final Random random = new Random();
        private int successCount = 0;
        private int failCount = 0;

        public Customer(Warehouse warehouse, List<Product> products) {
            this.warehouse = warehouse;
            this.products = products;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                Product product = products.get(random.nextInt(products.size()));
                int qty = random.nextInt(5) + 1;
                
                boolean result = warehouse.reserve(product.getSku(), qty);
                if (result) {
                    successCount++;
                } else {
                    failCount++;
                }
                
                try {
                    Thread.sleep(random.nextInt(50) + 10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        public int getSuccessCount() {
            return successCount;
        }

        public int getFailCount() {
            return failCount;
        }
    }

    static class Supplier extends Thread {
        private final Warehouse warehouse;
        private final List<Product> products;
        private volatile boolean open = true;
        private final Random random = new Random();

        public Supplier(Warehouse warehouse, List<Product> products) {
            this.warehouse = warehouse;
            this.products = products;
        }

        @Override
        public void run() {
            while (open) {
                Product product = products.get(random.nextInt(products.size()));
                int qty = random.nextInt(20) + 5;
                warehouse.restock(product.getSku(), qty);
                
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }

        public void setOpen(boolean open) {
            this.open = open;
        }
    }
    public static void main(String[] args) throws IOException {
        String currentDir = System.getProperty("user.dir");
        System.out.println("Working directory: " + currentDir);
        System.out.println("Files will be created at: " + currentDir + "/stock.csv");
        List<Product> productList = Arrays.asList(
            new Product("SKU001", "Laptop", 999.99),
            new Product("SKU002", "Mouse", 29.99),
            new Product("SKU003", "Keyboard", 79.99),
            new Product("SKU004", "Monitor", 349.99),
            new Product("SKU005", "Headphones", 149.99),
            new Product("SKU006", "Webcam", 89.99),
            new Product("SKU007", "USB Cable", 12.99),
            new Product("SKU008", "Mouse Pad", 19.99)
        );

        writeStockCSV(productList);
            
        Warehouse warehouse = readStockCSV();
            
        for (Product p : productList) {
            warehouse.setPrice(p.getSku(), p.getPrice());
        }

        List<Customer> customers = new ArrayList<>();
        List<Thread> customersThreads = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Customer customer = new Customer(warehouse, productList);
            customers.add(customer);
            customersThreads.add(new Thread(customer));
            customersThreads.get(i).start();
        }

        Supplier supplier = new Supplier(warehouse, productList);
        supplier.start();

        for (Thread customersThread : customersThreads) {
            try {
                customersThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        supplier.setOpen(false);
        try {
            supplier.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        writeReport(warehouse, customers);
            
        System.out.println("Simulation completed. Check report.txt for results.");
    }

    private static void writeStockCSV(List<Product> products) throws IOException {
        Random random = new Random();
        try (PrintWriter writer = new PrintWriter(new FileWriter("stock.csv"))) {
            for (Product product : products) {
                int quantity = random.nextInt(100) + 10;
                writer.println(product.getSku() + ";" + product.getName() + ";" + quantity);
            }
        }
    }

    private static Warehouse readStockCSV() throws IOException {
        Warehouse warehouse = new Warehouse();
        try (BufferedReader reader = new BufferedReader(new FileReader("stock.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 3) {
                    String sku = parts[0];
                    String name = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    warehouse.restock(sku, quantity);
                }
            }
        }
        return warehouse;
    }

    private static void writeReport(Warehouse warehouse, List<Customer> customers) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter("report.txt"))) {
            writer.println("=== Warehouse Report ===");
            writer.println();
            
            writer.println("Current Stock:");
            for (Map.Entry<String, Integer> entry : warehouse.getStock().entrySet()) {
                writer.println(entry.getKey() + ": " + entry.getValue());
            }
            writer.println();
                
            int totalSuccess = 0;
            int totalFail = 0;
            for (int i = 0; i < customers.size(); i++) {
                Customer c = customers.get(i);
                writer.println("Customer " + (i + 1) + ":");
                writer.println("  Successful orders: " + c.getSuccessCount());
                writer.println("  Failed orders: " + c.getFailCount());
                totalSuccess += c.getSuccessCount();
                totalFail += c.getFailCount();
            }
            writer.println();
                
            writer.println("Total Statistics:");
            writer.println("Successful orders: " + totalSuccess);
            writer.println("Failed orders: " + totalFail);
            writer.println("Revenue: $" + warehouse.getRevenue());
        }
    }
}
