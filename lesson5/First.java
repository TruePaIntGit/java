// Простая
// Считать с клавиатуры два числа (int) — делимое и делитель. 
// Попытаться выполнить деление и вывести результат. Если 
// делитель равен 0 — поймать ArithmeticException и вывести 
// "На ноль делить нельзя" вместо падения программы.
import java.util.Scanner;
public class First
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number dividend: ");
        int a = scan.nextInt();
        System.out.print("Enter number devisor: ");
        int b = scan.nextInt();
        try {
            int result = a/b;
            System.out.println("Rusult: "+result);
        } catch (ArithmeticException e) {
            System.out.println("Unexceptable divison by 0");
        }

    }
}