// Сложная
// Создать класс BankAccount с приватными полями owner (String) 
// и balance (double) — оба поля должны быть недоступны напрямую 
// снаружи класса (никаких публичных полей и никакого сеттера 
// setBalance — баланс меняется только через методы deposit/withdraw). 
// Добавить:
// геттеры getOwner() и getBalance() (только чтение баланса, без 
// прямой записи);
// метод deposit(double amount) — отклоняет пополнение, если amount 
// <= 0 (вывести "Некорректная сумма пополнения");
// метод withdraw(double amount) — отклоняет снятие, если amount <= 0 
// или если средств недостаточно (отдельные сообщения для каждого случая).
// В main показать, что снаружи класса невозможно написать account.balance 
// = 1000000; напрямую — баланс можно изменить только через deposit/withdraw, 
// и оба метода отказывают на некорректных данных, оставляя баланс в 
// согласованном состоянии.

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
    }

class Third{
    public static void main(String[] args) {
        BankAccount kiril = new BankAccount("Kiril");
        System.out.println(kiril.getOwner()+"\t"+kiril.getBalance());
        kiril.deposit(-15);
        kiril.withdraw(-4);
        kiril.withdraw(4);
        System.out.println(kiril.getOwner()+"\t"+kiril.getBalance());
        kiril.deposit(5.99);
        System.out.println(kiril.getOwner()+"\t"+kiril.getBalance());

        kiril.balance = 100001;
        System.out.println(kiril.getOwner()+"\t"+kiril.getBalance());
    }
}