/*1.Метод принимает от пользовтеля возраст, 
возвращает boolean — подходит человек под условие или нет.*/

import java.util.Scanner;
public class First
{
    public static boolean is_18(int age){
        return age>=18;
    }
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scan.nextInt();
        if(is_18(age)){
            System.out.println("You can pass, ser");
        }
        else{
            System.out.println("You can't pass");
        }


    }
}