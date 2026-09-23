// 1.Создать класс Point с приватными полями x и y (int). Переопределить 
// equals() (сравнение по значениям полей, с проверкой на null и на тип 
// через instanceof) и hashCode() (на основе x и y, например через Objects.
// hash(x, y)). В main: создать два разных объекта Point с одинаковыми 
// координатами и сравнить их через == и через .equals() — показать разницу 
// в результате. Затем положить оба объекта в HashSet<Point> и проверить, 
// что множество считает их дубликатом (размер набора — 1), только если 
// equals/hashCode реализованы корректно.
import java.util.HashSet;
import java.util.Objects;
class First{
    static class Point{
        private int x;
        private int y;
        

        public Point(int x, int y) {
            this.x=x;
            this.y=y;
        }
        @Override
        public boolean equals(Object o){
            if(o==this){
                return true;
            }
            if (!(o instanceof Point)) {
                return false;
            }
            Point other = (Point) o;
            return this.x==other.x && this.y==other.y;

        }
        @Override
        public int hashCode(){
            return Objects.hash(x,y);
        }
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