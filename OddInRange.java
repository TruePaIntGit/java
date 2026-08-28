// 1. Простая — «Чётные в диапазоне»
// Считать с клавиатуры два числа a и b.
// Вывести все чётные числа от a до b включительно, через пробел.
import java.util.Scanner;
public class OddInRange
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Start array: \t");
        int a = scan.nextInt();
        System.out.print("End of array: \t");
        int b = scan.nextInt();
        if (a>b){
            System.out.print("a is greater than b");
        }
        else{
            while (a!=b){
                if (a%2==0){
                    System.out.println(a);
                }
                a++;
            }
        }
        scan.close();
    }
}