// 3.Создать класс Shape с приватным полем name (String), 
// геттером и методом area() (заглушка, возвращает 0), и 
// методом describe(), который выводит name и вызывает area() 
// (то есть describe() не переопределяется в подклассах — 
// важно показать, что даже невиртуальный метод базового 
// класса, вызывающий area() внутри себя, всё равно получит 
// нужную переопределённую версию area() благодаря полиморфизму). 
// Создать Circle и Rectangle как подклассы, переопределяющие 
// только area(). В main: массив Shape[], заполнить с клавиатуры, 
// вызвать describe() для каждого элемента, увидеть, что при одном 
// и том же коде вызова результат разный в зависимости от реального 
// типа объекта.

import java.util.Scanner;
class Third{
    static class Shape{
        private char type;
        private String name;

        public Shape(char type,String name) {
            this.type=type;
            this.name = name;
        }
        

        public char getType() {
            return type;
        }
        double area(){
            return 0;
        }
        void describe(){
            System.out.println(name);
            System.out.println(area());
        }
    }
    static class Circle extends Shape{
        private double radius;
        

        public Circle(char type, String name, double radius) {
            super(type,name);
            this.radius =radius;
        }
        @Override
        double area(){
            return Math.PI*radius*radius;
        }
    }
    static class Rectangle extends Shape{
        private double width;
        private double height;

        public Rectangle(char type, String name,double width, double height) {
            super(type,name);
            this.width = width;
            this.height = height;
        }
        @Override
        double area(){
            return width*height;
        }
        
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter N");
        int N = sc.nextInt();
        Shape[] shapes = new Shape[N];
        for(int i=0;i<N;i++){
            System.out.println("Enter C for circle or R for rectangle");
            char sh = sc.next().toCharArray()[0];
            String name;
            switch (sh) {
                case 'C':
                    System.out.println("Enter radius");
                    double r = sc.nextDouble();
                    System.out.println("Enter name");
                    name = sc.next();
                    shapes[i] = new Circle(sh,name,r);
                    break;
                case 'R':
                    System.out.println("Enter width and height: ");
                    double width = sc.nextDouble();
                    double height = sc.nextDouble();
                    System.out.println("Enter name");
                    name = sc.next();
                    shapes[i] = new Rectangle(sh,name,width,height);
                    break;
                default:
                    System.out.println("Unknow key");
                    break;
            }
        }
        for (Shape i:shapes) {
            i.describe();
            
        }
        
    }
}