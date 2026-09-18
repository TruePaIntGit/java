// Средняя
// Дан интерфейс:
 
// interface Shape {
//     double area();
//     double perimeter();
// }
 
// Создай record Rectangle(double width, double height) implements Shape.
// Требования:
// Компактный конструктор проверяет, что width > 0 и height > 0, иначе — 
// IllegalArgumentException.
// Реализуй area() и perimeter().
// Напиши статический метод Rectangle square(double side), создающий квадрат 
// (вызывает канонический конструктор с одинаковыми сторонами).
// Проверить полиморфизм: создать Shape s = new Rectangle(3, 4); и вызвать s.area().
class Second{
    interface Shape {
        public double area();
        public double perimeter();
    }
    record Rectangle(double width, double height) implements Shape{
        Rectangle{
            if(width<=0 || height<=0){
                throw new IllegalArgumentException("");
            }
        }
        public double perimeter(){
            return (width+height)*2;
        }
        public double area(){
            return width*height;
        }
        static Rectangle square(double side){
            return new Rectangle(side,side);
        }
    }
    public static void main(String[] args) {
        Shape s = new Rectangle(3, 4);
        System.out.println(s.area());
    }
}