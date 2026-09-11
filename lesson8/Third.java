import java.util.Scanner;
class Third{
    
    // 3. Создать класс Employee с приватными полями name (String) 
    // и baseSalary (double), геттерами и методом calculatePay(), 
    // возвращающим baseSalary без изменений. Создать подклассы Manager 
    // extends Employee (переопределяет calculatePay() — добавляет 
    // 20% бонуса) и Developer extends Employee (переопределяет 
    // calculatePay() — добавляет фиксированную надбавку 15000). 
    // В main: считать с клавиатуры N — количество сотрудников; в 
    // цикле для каждого — считать имя, базовую зарплату и символ 
    // типа ('M' или 'D', через switch создать нужный подкласс) в 
    // массив Employee[] размера N. Пройти по массиву в цикле, для 
    // каждого вызвать calculatePay() (полиморфизм — вызывается метод 
    // конкретного подкласса, хотя тип массива — базовый Employee) и 
    // накопить общую сумму выплат. Вывести итоговую ведомость и общую 
    // сумму.

    class Employee{
        private String name;
        private double baseSalary;

        public Employee(String name, double baseSalary) {
            this.baseSalary = baseSalary;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double getBaseSalary() {
            return baseSalary;
        }
        double calculatePay(){
            return baseSalary;
        }
           
    }
    class Manager extends Employee{

        public Manager(String name, double baseSalary) {
            super(name, baseSalary);
        }
        @Override
        double calculatePay(){
            return super.getBaseSalary()*1.2;
        }
    }
    class Developer extends Employee{
        public Developer(String name, double baseSalary){
            super(name, baseSalary);
        }
        @Override
        double calculatePay(){
            return super.getBaseSalary()+15000;
        }
    }
    void main() {
        double sum=0;
        int N;
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        Employee[] employees = new Employee[N];
        for (Employee i : employees) {
            System.out.println("Enter M for manager or D for developer: ");
            char spec = sc.next().toCharArray()[0];
            System.out.println("Enter name: ");
            String name = sc.next();
            System.out.println("Enter base salary: ");
            double salary = sc.nextDouble();
            switch (spec) {
                case 'M':
                    i = new Manager(name,salary);
                    System.out.println(i.calculatePay());
                    sum+=i.calculatePay();
                    break;
                case 'D':
                    i = new Developer(name,salary);
                    System.out.println(i.calculatePay());
                    sum+=i.calculatePay();
                    break;
                default:
                    throw new AssertionError();
                
            }
        }
        System.out.println("Summary: "+sum);
    }
}