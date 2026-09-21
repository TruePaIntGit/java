// 1.Создать ArrayList<String> — список покупок. В цикле считывать с клавиатуры 
// названия товаров, пока не будет введено слово "стоп" (сигнальное значение). 
// После этого вывести весь список. Затем считать с клавиатуры название товара 
// для удаления, удалить его из списка через remove() (если такого товара нет — 
// вывести "Товар не найден"), вывести итоговый список и его размер.

import java.util.ArrayList;
import java.util.Scanner;
class First{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> prodList = new ArrayList<>();
        while(true){
            System.out.println("Enter name of prodict to add or \"stop\" to exit: ");
            String prodict = scan.next();
            if(prodict.equals("stop")){
                break;
            }
            prodList.add(prodict);
        }
        System.out.println(prodList);
        while(true){
            System.out.println("Enter name of prodict to ramove or \"stop\" to exit: ");
            String prodict = scan.next();
            if(prodict.equals("stop")){
                break;
            }
            if(!prodList.remove(prodict)){
            System.out.println("No such prodict in list");
            }
        }
        System.out.println(prodList);
    }
}