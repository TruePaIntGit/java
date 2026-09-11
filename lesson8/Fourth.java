// 4. Создать класс Shape с приватным полем type 
// (char, например 'C' для круга, 'R' для прямоугольника), 
// геттером и методом area(), возвращающим 0 (заглушка). 
// Создать Circle extends Shape с приватным полем radius 
// (double), переопределяющий area() (Math.PI * radius * 
// radius), и Rectangle extends Shape с полями width, 
// height (double), переопределяющий area() (width * 
// height). В main: считать с клавиатуры N фигур; в 
// цикле для каждой — считать символ типа через switch, 
// в зависимости от типа считать нужные размеры (радиус 
// либо ширину/высоту) и создать соответствующий объект в 
// массив Shape[]. Пройти по массиву в цикле, вызвать area() 
// для каждой (полиморфизм), вывести площадь каждой фигуры и 
// её тип, а также найти и вывести фигуру с максимальной площадью.
import java.util.Scanner;
class Fourth{
    class Shape{
        private char type;

        public char getType() {
            return type;
        }
        double area(){
            return 0;
        }   
    }
    class Circle extends Shape{
        private double radius;
        

        public Circle(double radius) {
            super.type='C';
            this.radius =radius;
        }
        @Override
        double area(){
            return Math.PI*radius*radius;
        }
    }
    class Rectangle extends Shape{
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
            super.type='R';
        }
        @Override
        double area(){
            return width*height;
        }
        
    }
    void main() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N");
        int N = sc.nextInt();
        Shape[] shapes = new Shape[N];
        double maxArea=0;
        char shape=' ';
        for(Shape i:shapes){
            double area;
            System.out.println("Enter C for circle or R for rectangle");
            char sh = sc.next().toCharArray()[0];
            switch (sh) {
                case 'C':
                    System.out.println("Enter radius");
                    double r = sc.nextDouble();
                    i = new Circle(r);
                    area = i.area();
                    System.out.println("Area: " +area);
                    if (area>maxArea){
                        maxArea=area;
                        shape = i.getType();
                    }
                    break;
                case 'R':
                    System.out.println("Enter width and height: ");
                    double width = sc.nextDouble();
                    double height = sc.nextDouble();
                    i = new Rectangle(width,height);
                    area = i.area();
                    System.out.println("Area: " +area);
                    if (area>maxArea){
                        maxArea=area;
                        shape = i.getType();
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }
        System.out.println("Max area: "+maxArea);
        System.out.println("Shape: "+shape);
    }
}