// 2.Создать метод который проверяет, простое ли число, используя цикл внутри метода.

import java.util.Scanner;
public class Second
{
    public static void main(String[] args)
    {
        System.out.println("Enter integer number: ");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        if(IsPrime(number)){
            System.out.println(number+" is prime");
        }
        else{
            System.out.println(number+" isn't prime");
        }

    }

    public static boolean IsPrime(int n){
        int i = 2;
        boolean wasDevide = false;
        while((i*i<=n) && !wasDevide){
            if(n%i==0){
                wasDevide = true;
            }
            i++;
        }
        if(wasDevide){
            return false;
        }
        return true;
    }
}