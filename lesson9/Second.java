// 2.Создать класс BankAccount с приватными полями
// deposit/withdraw (с валидацией, как раньше) и 
// методом calculateYearlyReport(), возвращающим 
// balance без изменений. Создать SavingsAccount 
// extends BankAccount с приватным полем interestRate 
// (double), переопределяющий calculateYearlyReport() — 
// добавляет проценты к балансу. Создать CheckingAccount 
// extends BankAccount с приватным полем overdraftFee 
// (double), переопределяющий calculateYearlyReport() — 
// вычитает фиксированную комиссию. В main: массив 
// BankAccount[] из нескольких счетов разных типов, в цикле 
// вызвать calculateYearlyReport() для каждого и вывести 
// итоговый прогноз баланса.
import java.util.Scanner;
class Second{
    static class BankAccount{
        private String owner;
        private double balance;
        public BankAccount(String owner){
            this.owner = owner;
            this.balance = 0;
        }
        void deposit(double amount){
            if(amount<0){
                System.out.println("Negative amount");
                return;
            }
            balance+=amount;
        }
        void withdraw(double amount){
            if(balance<amount){
                System.out.println("Need some cash");
                return;
            }
            else if(amount<0){
                System.out.println("Negative amount");
                return;
            }
            balance-=amount;
        }

        public String getOwner(){
            return this.owner;
        }
        public double getBalance(){
            return this.balance;
        }
        public double calculateYearlyReport(){
            return this.balance;
        }
    }
    static class SavingsAccount extends BankAccount{
        private double interestRate;

        public SavingsAccount(String owner, double interestRate) {
            super(owner);
            this.interestRate = interestRate;
        }
        public SavingsAccount(BankAccount account, double interestRate) {
            super(account.getOwner());
            this.deposit(account.getBalance());
            this.interestRate = interestRate;
        }
        public double calculateYearlyReport(){
            return this.getBalance()*(1+interestRate/100);
        }

        
    }
    static class CheckingAccount extends BankAccount{
        private double overdraftFee;

        public CheckingAccount(String owner,double overdraftFee) {
            super(owner);
            this.overdraftFee = overdraftFee;
        }
        public CheckingAccount(BankAccount account, double  overdraftFee){
            super(account.getOwner());
            this.deposit(account.getBalance());
            this.overdraftFee = overdraftFee;
        }
        public double calculateYearlyReport(){
            return this.getBalance()-overdraftFee;
        }
        
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = 3;
        BankAccount[] accounts = new BankAccount[N];
        for (int i = 0; i < N; i++) {
            String owner;
            double cash;
            System.out.println("Enter B for Bank, S for Savings and C for Checking accounts");
            char type = scan.next().toCharArray()[0];
            switch (type) {
                case 'B':
                    System.out.println("Enter owner: ");
                    owner = scan.next();
                    System.out.println("Enter amount of new deposit: ");
                    cash = scan.nextDouble();
                    accounts[i] = new BankAccount(owner);
                    accounts[i].deposit(cash);
                    break;
                case 'S':
                    System.out.println("Enter owner: ");
                    owner = scan.next();
                    System.out.println("Enter amount of new deposit: ");
                    cash = scan.nextDouble();
                    System.out.println("Enter interestRate: ");
                    double interestRate = scan.nextDouble();
                    accounts[i] = new SavingsAccount(owner,interestRate);
                    accounts[i].deposit(cash);
                    break;
                case 'C':
                    System.out.println("Enter owner: ");
                    owner = scan.next();
                    System.out.println("Enter amount of new deposit: ");
                    cash = scan.nextDouble();
                    System.out.println("Enter overdraftFee: ");
                    double overdraftFee = scan.nextDouble();
                    accounts[i] = new CheckingAccount(owner,overdraftFee);
                    accounts[i].deposit(cash);
                    break;
                default:
                    System.out.println("Unkown key");
                    break;
            }
        }
        for (BankAccount i : accounts) {
            System.out.println("Yearly Report: "+i.calculateYearlyReport());
            System.out.println("");
        }
    }
}