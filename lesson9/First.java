// 1.Создать класс Person с приватными полями name 
// (String) и age (int), геттерами и методом 
// displayInfo(), выводящим имя и возраст. Создать 
// Student extends Person, добавляющий приватное 
// поле grade (double) со своим геттером/сеттером 
// (с валидацией: grade должна быть от 0 до 10, 
// иначе не устанавливать и вывести ошибку), и 
// переопределяющий displayInfo() — вывод дополняется 
// оценкой. В main создать массив Person[] из 4 
// элементов, часть — обычные Person, часть — Student, 
// заполнить с клавиатуры (включая символ-переключатель 
// типа через switch), пройти в цикле и вызвать 
// displayInfo() для каждого (полиморфизм — вызовется 
// нужная версия метода)
import java.util.Scanner;
class First{
    static class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            if (age<0){
                System.out.println("Invalid age");
                this.age=0;
                return;
            }
            this.age = age;
        }
        String getName(){
            return name;
        }
        int age(){
            return age;
        }
        void displayInfo(){
            System.out.println("Name: \t"+name);
            System.out.println("Age: \t"+age);
        }

        

    }
    static class Student extends Person{
        private double grade;

        public Student(String name, int age, double grage) {
            super(name, age);
            if(grage<0){
                System.err.println("Invalid grade");
                return;
            }
            this.grade = grage;
        }
        public Student(String name, int age) {
            super(name, age);
        }
        void setGrade(double grade){
            this.grade = grade;
        }
        double getGrade(){
            return this.grade;
        }
        void displayInfo(){
            super.displayInfo();
            System.out.println("Grade: \t"+grade);
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = 4;
        Person[] persons = new Person[N];
        for(int i=0;i<N;i++){
            System.out.println("Enter P for preson and S for student");
            char type = scan.next().toCharArray()[0];
            String name;
            int age;
            switch(type){
                case 'P':
                    System.out.println("Enter name");
                    name = scan.next();
                    System.out.println("Enter age");
                    age = scan.nextInt();
                    persons[i] = new Person(name,age);
                    
                    break;
                case 'S':
                    System.out.println("Enter name");
                    name = scan.next();
                    System.out.println("Enter age");
                    age = scan.nextInt();
                    System.out.println("Enter grade");
                    double grade = scan.nextDouble();
                    persons[i] = new Student(name, age,grade);
                    break;
                default:
                    System.out.println("Unknown key");
                    break;
            }


        }
        for(Person i:persons){
            i.displayInfo();
            System.out.println("");
        }
    }

}