// Простая
// Создать класс Person с приватными полями 
// name (String) и age (int). Добавить конструктор 
// и публичные геттеры/сеттеры для обоих полей — 
// без какой-либо валидации. В main создать объект, 
// изменить оба поля через сеттеры, вывести значения 
// через геттеры.

public class First{
    public static class Person{
        private String name;
        private int age;

        public Person(String name, int age){
            this.setName(name);
            this.setAge(age);
        }
        public Person(){}

        public void setName(String name){
            this.name = name;
        }
        public void setAge(int age){
            // if (age<0){
            //     System.out.println("Invadid age");
            //     return;
            // }
            this.age = age;
        }
        public String getName(){
            return this.name;
        }
        public int getAge(){
            return this.age;
        }
    }
    public static void main(String[] args){
        Person sanya = new Person("Genadii",34);
        System.out.println(sanya.getName()+"\t"+sanya.getAge());
        sanya.setName("Sanya");
        sanya.setAge(22);
        System.out.println(sanya.getName()+"\t"+sanya.getAge());
    }
}