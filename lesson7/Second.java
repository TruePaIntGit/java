// Средняя
// Создать класс Product с приватными полями name (String) 
// и price (double). Сеттер setPrice должен проверять: 
// если переданное значение отрицательное — не менять цену 
// и вывести "Цена не может быть отрицательной", иначе 
// установить новое значение. В main продемонстрировать оба 
// случая: успешную установку цены и попытку установить 
// отрицательную.

class Second{
    public static class Product{
        private String name;
        private double price;

        public Product(String name, double price) {
            this.setName(name);
            this.setPrice(price);
        }
        
        public void setName(String name){
            this.name = name;
        }
        public void setPrice(double price){
            if (price<0){
                System.out.println("Invalid price");
                return;
            }
            this.price = price;
        }

        public String getName(){
            return this.name;
        }
        public double getPrice(){
            return this.price;
        }
    }
    public static void main(String[] args) {
        Product bread = new Product("Gray Bread",20.65);
        System.out.println(bread.getName()+"\t"+bread.getPrice());
        bread.setPrice(-3);
        bread.setName("White Bread");
        bread.setPrice(19.87);
        System.out.println(bread.getName()+"\t"+bread.getPrice());
    }
}