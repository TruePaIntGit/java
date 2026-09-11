// 3. Сложная — «Проверка на простоту с подсчётом»
// Ввести n. Для всех чисел от 2 до n определить, простое
// ли число (без использования Math или готовых методов —
// только вложенный цикл + флаг). Вывести количество простых чисел
// и сумму их цифр (для каждого простого числа отдельно).

import java.util.Scanner;
public class PrimeNumber
{
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
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter end of range: ");
        int n = scan.nextInt();
        int count = 0;
        int sum = 0;
        for (int i = 2; i <= n;i++){
            if(IsPrime(i)){
                System.out.println(i+"\t Is prime");
                count++;
                sum+=i;
            }
        }
        System.out.println("Amount of prime num: \t"+count);
        System.out.println("Sum of prime num: \t"+sum);
    }
}