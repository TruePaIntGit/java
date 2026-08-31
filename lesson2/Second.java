// Средняя
// Дан двумерный массив char размером M×N (заполнен буквами и цифрами).
//  Посчитать отдельно количество букв, количество цифр и количество
//   остальных символов в каждой строке массива, вывести построчно.

import java.util.random.RandomGenerator;
public class Second
{
    public static void main(String[] args)
    {
        RandomGenerator g = RandomGenerator.getDefault();
        int M = g.nextInt(1,10);
        int N = g.nextInt(1,10);
        System.out.println("Array size: " + M + "x"+N);
        char[][] array = new char[M][N];
        int count_of_letters =0;
        int count_of_nums = 0;
        int count_of_symbols = 0;
        for (int i = 0; i<M;i++){
            System.out.println(i+1+":");
            for (int j = 0; j<N;j++){
                array[i][j]=(char)g.nextInt(33,120);
                System.out.println(j+1+":\t"+array[i][j]);
                if (Character.isAlphabetic(array[i][j])){
                    count_of_letters++;
                }
                else if(Character.isDigit(array[i][j])){
                    count_of_nums++;
                }
                else {
                    count_of_symbols++;
                }
            }
            System.out.println("");
        }
        System.err.println("Count of letters: "+count_of_letters);
        System.err.println("Count of numbers: "+count_of_nums);
        System.err.println("Count of symbols: "+count_of_symbols);

    }
}