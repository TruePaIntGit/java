public static class BankAccount{
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