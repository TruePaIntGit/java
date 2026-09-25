// 1.Дан список целых чисел (List<Integer>, задать вручную, минимум 10 значений). С помощью 
// Stream API вывести на экран только чётные числа, каждое на новой строке (filter + forEach).
import java.util.Arrays;
import java.util.List;
class First{
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,2,3,5,83,41,3,6,8,0);
        a.stream()
            .filter(s->(s%2==0))
            .forEach(System.out::println);
    }
}