// 4.Программа в цикле принимает оценки (2–5), 
// пока не введут слово «стоп»; невалидные оценки 
// отклоняет, но не прерывает работу; в конце считает 
// средний балл и выдаёт вердикт

import java.util.Scanner;
public class Fourth
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter stop, to exit");
        int count = 0;
        int sum_of_grades = 0;
        while (true) { 
            System.out.println(count+1+": ");
            String grade = scan.next();
            if(grade.equals("stop")){
                break;
            }
            if(isGradeValid(grade)){
            //scan.next();
            sum_of_grades+=Integer.parseInt(grade);
            count++;}
        }
        System.out.println("Average grade: "+sum_of_grades/count);
         
    }
    public static boolean isGradeValid(String grade){
        for (char i : grade.toLowerCase().toCharArray()) {
            if(Character.isLetter(i)){
                System.out.println("Unvalid grade, contain letters");
                return false;
            }
        }
        if(Integer.parseInt(grade)>5 || Integer.parseInt(grade)<2){
            System.out.println("Unvalid grade, out of range");
            return false;
        }
        return true;
    }
}