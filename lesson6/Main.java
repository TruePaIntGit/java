public class Main
{
 // Простая
// Создать класс `Book` с полями `title` (String) 
// и `pages` (int). Добавить конструктор, принимающий 
// оба поля. В `main` создать два объекта `Book` с 
// разными данными и вывести их поля через 
// `System.out.println` (например, "Книга: <title>, 
// страниц: <pages>").
    public static class Book{
        String title;
        int pages;

        public Book(String title, int pages) {
            this.title = title;
            this.pages = pages;
        }
    }

// Средняя
// Создать класс `Rectangle` с полями `width` и 
// `height` (оба double). Добавить конструктор и 
// метод `getArea()`, возвращающий площадь (`width 
// * height`), а также метод `getPerimeter()`, 
// возвращающий периметр. В `main` создать два 
// объекта с разными размерами, вывести для каждого 
// площадь и периметр, и сравнить через `if`, у 
// какого из двух прямоугольников площадь больше.

    public static class Rectangle{
        double width;
        double height;

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        public double getArea(){
            return width*height;
        }
        public  double getPerimeter(){
            return width*2+height*2;
        }
        
    }

// Сложная
// Создать класс `BankAccount` с полями `owner` 
// (String) и `balance` (double). Добавить конструктор, 
// метод `deposit(double amount)` (увеличивает баланс) 
// и метод `withdraw(double amount)` (уменьшает баланс, 
// но только если средств достаточно — иначе вывести 
// "Недостаточно средств" и не менять баланс). Добавить
//  метод `printInfo()`, который выводит владельца и 
//  текущий баланс. В `main` создать объект, выполнить 
//  несколько операций подряд (пополнение, снятие 
//  корректной суммы, попытку снять больше, чем есть на 
//  счёте) и после каждой операции вызывать `printInfo()`, 
//  чтобы показать, как меняется состояние объекта.

    public static class BankAccount{
        String owner;
        double balance;
        public BankAccount(String owner, double balance){
            this.owner = owner;
            this.balance = balance;
        }
        void deposit(double amount){
            balance+=amount;
        }
        void withdraw(double amount){
            if(balance<amount){
                System.out.println("Need some cash");
                return;
            }
            balance-=amount;
        }
        void printInfo(){
            System.out.println(owner+"\t"+balance+"$");
        }
    }

    public static void main(String[] args)
    {
        //1
        Book DonKiHot = new Book("Don Kihot",250);


        //2
        Rectangle rec1 = new Rectangle(5.3,4.7);
        System.out.println("Rec1");
        System.out.println("Area: "+rec1.getArea());
        System.out.println("Perimeter: "+rec1.getPerimeter());

        Rectangle rec2 = new Rectangle(6.2,1.8);
        System.out.println("Rec2");
        System.out.println("Area: "+rec2.getArea());
        System.out.println("Perimeter: "+rec2.getPerimeter());

        if(rec1.getArea()>rec2.getArea()){
            System.out.println("Rec1 > Rec2");
        }
        else{
            System.out.println("Rec1 < Rec2 or Rec1 == Rec2");
        }

        //3
        BankAccount acc = new BankAccount("Martin",100.50);
        acc.printInfo();
        acc.deposit(10.3);
        acc.printInfo();
        acc.withdraw(5.7);
        acc.printInfo();
        acc.withdraw(500.19);

    }
}