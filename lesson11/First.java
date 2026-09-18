

// Простая
 
// Создай record Temperature(double celsius).
// Требования:
// Компактный конструктор должен бросать IllegalArgumentException, если 
// celsius < -273.15 (абсолютный ноль — ниже физически невозможно).
// Добавь обычный метод toFahrenheit(), который возвращает температуру в 
// Фаренгейтах (celsius * 9/5 + 32).
// Проверить: new Temperature(-300) должен падать с исключением, new 
// Temperature(25).toFahrenheit() — возвращать 77.0.

class First{
    record Temperature(double celsius){
        Temperature{
            if(celsius<-273.15){ throw new IllegalArgumentException("");}
        }
        double toFahrenheit(){
            return celsius*(9/5)+32;
        }
    }
    public static void main(String[] args) {
        Temperature t1 = new Temperature(-300);
        Temperature t2 = new Temperature(25);
        System.out.println(t2.toFahrenheit());
    }
}