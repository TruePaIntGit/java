// Создать ArrayList<Integer> из чисел от 1 до 10. Задача в два этапа:
// Написать код, который в цикле for-each пытается удалить из списка все чётные числа 
// через list.remove(number) прямо во время перебора — и убедиться, что программа падает 
// с ConcurrentModificationException (важно, чтобы студент реально это увидел и понял, 
// почему нельзя изменять коллекцию во время итерации по ней обычным for-each).
// Исправить это, используя Iterator<Integer> напрямую (iterator(), hasNext(), next()) 
// и его собственный метод remove(), который единственный умеет безопасно удалять 
// элемент во время итерации.

import java.util.ArrayList;
import java.util.Iterator;
class Fourth{
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        for(int i =1;i<=10;i++){
            array.add(i);
        }
        // for(Integer i:array){
        //     if(i%2==0){
        //         array.remove(i);
        //     }
        // }
        System.out.println("ListArray: "+array);
        Iterator<Integer> iterator = array.iterator();
        //System.out.println("Iterator before: "+iterator);
        while (iterator.hasNext()) {
            Integer n = iterator.next();
            if(n%2==0){
                iterator.remove();
            }
            
        }
        System.out.println("After: "+array);
    }
}