// 2.Класс Printer с методом printDocument(String owner): печатает 5 строк вида Иван: 
// строка 1, между строками sleep(50). Три потока (Иван, Мария, Олег) одновременно 
// печатают через один Printer.
// Без synchronized строки разных документов перемешаются.
// Добавь synchronized на метод: каждый документ должен напечататься целиком.
class Second{
    public static class Printer {
        public synchronized void printDocument(String owner) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(owner + ": line " + i);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread thread1 = new Thread(() -> printer.printDocument("Ivan"));
        Thread thread2 = new Thread(() -> printer.printDocument("Maria"));
        Thread thread3 = new Thread(() -> printer.printDocument("Oleg"));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}