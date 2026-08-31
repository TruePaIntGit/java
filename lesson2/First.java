// Простая
// Дан массив из N вещественных чисел. Найти сумму, 
// среднее арифметическое и количество элементов больше среднего.
//import java.util.Scanner;
import java.util.random.RandomGenerator;
public class First
{
    public static void main(String[] args)
    {
        RandomGenerator g = RandomGenerator.getDefault();
        int N = g.nextInt(1,10);
        System.out.println("Array amount is: "+N);
        int[] array = new int[N];
        int sum = 0;
        float average;
        int elements_more_than_average = 0;
        for (int i = 0; i<N;i++){
            array[i]=g.nextInt(1,10);
            sum+=array[i];
            System.out.println(i+1+":\t"+array[i]);
        }
        average = (float)sum/N;
        for (int i : array) {
            if (i>average){
                elements_more_than_average++;
            }
        }
        System.out.println("Sum of elements: "+sum);
        System.out.println("Average of elements: "+average);
        System.out.println("Count elements that more than avegage: "+elements_more_than_average);
    }
}