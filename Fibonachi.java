// 2. Средняя — «Числа Фибоначчи с условием»
// Ввести n. Вывести первые n чисел Фибоначчи, 
// но если число делится на 3 — вместо него вывести слово "Fizz".
import java.util.Scanner;
public class Fibonachi
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Fibonachi of: \t");
        int n = scan.nextInt();
        int fib = 1;
        int firstFibNum[] = {0,1,1};
        if (n==0){
            System.out.print("0 numbers Fibonachi was shown \t");
        }
        else if(n<=3){
            for(int i = 0; i<n;i++){
                System.out.print(i+1+":\t");
                System.out.println(firstFibNum[i]);
            }
        }
        else{
            int count = 0;
            for(int i = 0; i<=n;i++){
                System.out.print(i+1+":\t");
                System.out.println(firstFibNum[i]);
                count++;
            }
            n-=count;
            int a = 1;
            int b = 1;
            while (n>0){
                n--;
                count++;
                int cash = b;
                b+=a;
                a = cash;
                if (b%3==0){
                    System.out.print(count+":\t");
                    System.out.println("Fizz");
                }
                else{
                System.out.print(count+":\t");
                System.out.println(b);}
            }
        }

    }
}