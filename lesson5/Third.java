// Сложная
// Создать массив int размером 5. Считать с клавиатуры индекс 
// массива (int) и делитель (int). Нужно: (1) обратиться к 
// элементу массива по введённому индексу, (2) поделить его на 
// введённый делитель. Обработать оба возможных исключения 
// раздельно — ArrayIndexOutOfBoundsException (если индекс вне 
// границ массива) и ArithmeticException (если делитель 0) — 
// каждое своим отдельным catch с отдельным сообщением. 
// Добавить блок finally, который выводит "Попытка обработки 
// завершена" независимо от того, было исключение или нет.

import java.util.Scanner;
import java.util.random.RandomGenerator;
public class Third
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        RandomGenerator g = RandomGenerator.getDefault();
        short N = 5;
        int[] array = new int[N];
        for(short i=0; i<N;i++){
            array[i]=g.nextInt(0,20);
            System.out.println(i+":\t"+array[i]);
        }
        System.out.println("Enter index: ");
        int index = scan.nextInt();
        System.out.println("Enter devisor: ");
        int devisor = scan.nextInt();
        int result=0;
        try {
            result = array[index]/devisor;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Unexceptable index");
        }
        catch(ArithmeticException e){
            System.out.println("Unexceptable divison by 0");
        }
        finally{
            System.out.println("The processing attempt has been completed");
        }
        System.out.println("Result: "+result);
    }
}