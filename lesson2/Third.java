// Сложная
// Дан двумерный массив вещественных чисел размером N×N.
//  Для каждой строки найти индекс и значение максимального
//   элемента. Затем определить, является ли матрица
//    симметричной относительно главной диагонали — сравнение
//     чисел проводить с учётом погрешности (epsilon), а не
//      через ==

import java.util.random.RandomGenerator;
public class Third
{
    public static void main(String[] args)
    {
        RandomGenerator g =RandomGenerator.getDefault();
        int N = g.nextInt(1,10);
        System.out.println("Array size is: "+N+'x'+N);
        float[][] array = new float[N][N];
        boolean is_symmetric = true;
        for (int i = 0; i<N;i++){
            for (int j = 0; j<N;j++){
                array[i][j]=g.nextFloat(1,100);
                System.out.print(array[i][j]+"\t");
            }
            System.out.println("");
        }
        for (int i = 0; i<N;i++){
            float max_value = 0;
            int index_of_max_value = 0;
            for (int j = 0; j<N;j++){
                if( array[i][j]>max_value){
                    max_value = array[i][j];
                    index_of_max_value = j;
                }
            }
            System.out.println(i+": max: "+max_value+"\t index: "+index_of_max_value);
        }
        float epsilon = 0.000001f;
        for (int i = 0; i<N;i++){
            for (int j = 0; j<N;j++){
                if(!(Math.abs(array[i][j]-array[j][i])<epsilon)){
                    is_symmetric = false;
                    break;
                }
            }
        }
        if (is_symmetric){
            System.out.println("Array is symmetric");
        }
        else{
            System.err.println("Array isn't symmetric");
        }
    }
}