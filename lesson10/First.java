// Простая
 
// Создать абстрактный класс Animal с приватным полем name (String), 
// геттером, конструктором и абстрактным методом makeSound(). 
// Добавить обычный (не абстрактный) метод sleep(), выводящий "Спит". 
// Создать Dog extends Animal и Cat extends Animal, каждый реализует 
// makeSound() по-своему. В main: массив Animal[], заполнить объектами 
// обоих подклассов, в цикле вызвать makeSound() и sleep() у каждого.

class First{
    static abstract class Animal{
        private String name;
        String getName(){
            return name;
        }

        public Animal(String name) {
            this.name = name;
        }
        
        abstract void makeSound();
        void sleep(){
            System.out.println("Sleeping");
        }
    }
    static class Dog extends Animal{
        public Dog(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println("Gaff!");
        }
    }
    static class Cat extends Animal{
        public Cat(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println("Meww");
        }
    }
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0]=new Cat("Barsik");
        animals[1]=new Dog("Sharik");
        animals[2]=new Cat("Igor");
        for(Animal i:animals){
            i.makeSound();
        }
    }
}