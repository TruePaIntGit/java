// 3.Переписать класс Point из первой задачи как record Point(int x, int y) {}. 
// В main показать, что equals(), hashCode() и toString() уже работают правильно 
// "из коробки", без единой написанной строчки — повторить те же проверки (сравнение 
// двух record с одинаковыми полями, добавление в HashSet) и убедиться, что результат 
// идентичен ручной реализации из первой задачи, но кода не пришлось писать вообще. 
// И попытаться написать point.x = 5; — увидеть, что не скомпилируется, и объяснить, 
// почему (все поля record неявно final).
import java.util.HashSet;
class Third{
    static record Point(int x, int y){
    }
    public static void main(String[] args) {
        Point a = new Point(1,1);
        Point b = new Point(1,1);
        System.out.println(a==b);
        System.out.println(a.equals(b));
        HashSet<Point> set = new HashSet<>();
        set.add(a);
        set.add(b);
        System.out.println("Size of HashSet" + set.size()); // 1
        System.out.println(set);
    }
}