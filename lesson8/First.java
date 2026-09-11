class First{
    // 1. Создать класс Animal с приватным полем name 
    // (String), конструктором и геттером getName(), 
    // а также методом makeSound(), который выводит 
    // "Животное издаёт звук". Создать класс Dog extends 
    // Animal, который переопределяет makeSound(), выводя 
    // "Гав!". В main создать объект Dog, вызвать getName() 
    // (унаследованный метод) и makeSound() (переопределённый).
    static class Animal{
        private String name;

        public Animal(String name) {
            this.name = name;
        }
        public String getName(){
            return name;
        }
        public void makeSound(){
            System.out.print("animal make sound: ");
        }
    }
    static class Dog extends Animal{

        public Dog(String name) {
            super(name);
        }
        @Override
        public void makeSound(){
            System.out.println("Gaffff");
        }
    }
    public static void main(String[] args) {
        Dog puffy = new Dog("Puffy");
        System.out.println(puffy.getName());
        puffy.makeSound();
    }
}