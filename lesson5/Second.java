// Средняя
// Считать с клавиатуры строку. Попытаться преобразовать 
// её в число через Integer.parseInt. Если преобразование 
// не удалось — поймать то NumberFormatException и 
// вывести "Введено не число", а не дать программе 
// упасть. Обернуть это в цикл: повторять запрос ввода, 
// пока пользователь не введёт корректное число

import java.util.Scanner;
public class Second
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        String number_str = "";
        int number;
        while (true) {  
            try{
                number_str = scanner.next();
                number = Integer.parseInt(number_str);
                break;
            }
            catch(NumberFormatException e){
                System.out.println(number_str+" isn't a number");
                System.out.println("enter correct number: ");
            }
        }
        System.out.println("number was entered");
    }
}