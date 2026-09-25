// 2.Дан список строк — имена студентов (List<String>, с разным регистром букв, например 
// "иван", "Мария", "ПЁТР"). С помощью Stream API привести все имена к виду с заглавной 
// первой буквой и остальными строчными, отсортировать по алфавиту и вывести результат 
// (map + sorted + forEach). Метод приведения к нужному регистру можно оформить как обычный 
// статический метод и передать в map через ссылку на метод.
import java.util.Arrays;
import java.util.List;
class Second{
    public static void main(String[] args) {
        List<String> names = Arrays.asList("ivan", "Maria", "PETR");
        names.stream()
            .map(Second::CapWord)
            .sorted()
            .forEach(System.out::println);
    }
    public static String CapWord(String word){
        //String out = word.toLowerCase();
        char[] out = word.toLowerCase().toCharArray();
        out[0] = Character.toUpperCase(out[0]);
        return new String(out);
    }
}