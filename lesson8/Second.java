

class Second{
    // 2. Создать класс Vehicle с приватным полем speed (int), 
    // геттером и сеттером setSpeed (сеттер должен отклонять 
    // отрицательные значения — "Скорость не может быть отрицательной"). 
    // Создать класс Car extends Vehicle, добавляющий своё приватное поле 
    // brand (String) с отдельным геттером/сеттером. В main создать Car, 
    // установить скорость и марку через сеттеры (показать, что speed 
    // меняется только через унаследованный setSpeed, а не напрямую).
    abstract class Vehicle{
        private int speed;
        int getSpeed(){
            return speed;
        }
        void setSpeed(int speed){
            if(speed<0){
                System.out.println("Speed cannot be negative");
                return;
            }
            this.speed = speed;
        }
    }
    class Car extends Vehicle{
        private String brand;
        String getBrand(){
            return brand;
        }
        void setBrand(String brand){
            this.brand = brand;
        }
    }
    void main() {
        Car shevrole = new Car();
        shevrole.setBrand("Shevrole");
        shevrole.setSpeed(5);
    }
}