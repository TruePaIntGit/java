// Задача 2: Средняя (Чек в магазине)
// Напиши программу, которая работает как простая касса. Она должна запрашивать данные о покупке и выводить итоговую стоимость.
// Что нужно сделать:
//  * Запроси название товара (String).
//  * Запроси цену за одну штуку (int).
//  * Запроси количество купленного товара (int).
//  * Создай еще одну переменную int для хранения итоговой суммы (цена умножить на количество).
//  * Выведи красивый чек.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CashRegister{
    public static void main(String[] args){
        String product="";
        int totalSum=0;
        System.out.println("\t\tWelcome to cash register!\t\t\n");
        System.out.println("Type name of product & it's price\n");
        System.out.println("To enter your check enter 0 or \"exit\" in product name");
        List<String> products = new ArrayList<String>();
        List<Integer> prices = new ArrayList<Integer>();
        List<Integer> counts = new ArrayList<Integer>();
        Scanner scanner = new Scanner(System.in);
        while(true){
            int price=0;
            int count=0;
            System.out.print("Enter product: \t");
            product = scanner.nextLine();
            if (product.contentEquals("0")){
                break;
            }
            products.add(product);

            System.out.print("Enter price: \t");
            price = Integer.parseInt(scanner.nextLine());
            prices.add(price);

            System.out.print("Enter count: \t");
            count = Integer.parseInt(scanner.nextLine());
            counts.add(count);

        }
        scanner.close();
        System.err.println("Your check:\n");
        for(int i = 0; i<counts.size();i++){
            System.out.println(products.get(i)+"\t\t"+prices.get(i).toString()+"\t\t"+counts.get(i).toString());
            totalSum+=prices.get(i)*counts.get(i);
        }
        System.out.println("Total Sum: \t"+totalSum);
    }
}