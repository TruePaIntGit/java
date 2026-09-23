// 2.Создать класс Person с полями name (String) и age (int), переопределить 
// equals()/hashCode() так, чтобы два человека считались равными только при 
// совпадении обоих полей. Задача-ловушка: специально переопределить только 
// equals(), не переопределяя hashCode(), и положить два "равных" объекта в 
// HashMap<Person, String> как ключи — увидеть, что несмотря на equals() == true, 
// HashMap их не считает одним и тем же ключом (потому что хэш-коды разные). 
// Задача — исправить, добавив корректный hashCode()
import java.util.HashMap;
import java.util.Objects;
class Second{
    static class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name= name;
            this.age = age;
        }
        @Override
        public boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(!(o instanceof Person)){
                return false;
            }
            Person other = (Person) o;
            return this.name.equals(other.name) && this.age==other.age;
        }
        public int hashCode(){
            return Objects.hash(name,age);
        }
    }
    public static void main(String[] args) {
        Person name1 = new Person("name", 22);
        Person name2 = new Person("name", 22);
        HashMap<Person, String> s = new HashMap<>();
        s.put(name1,"1");
        s.put(name2,"1");
        System.out.println(s.size());
    }
}