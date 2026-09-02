// 3.Метод считает количество гласных букв в строке, перебирая символы через charAt.

import java.util.Scanner;
public class Third
{
    public static void main(String[] args)
    {
        System.out.println("Enter your text: ");
        Scanner scan = new Scanner(System.in);
        String text = scan.next();
        System.out.println("Count Vowel in text: "+ VowelCount(text));

    }
    public static int VowelCount(String text){
        int count = 0;
        char[] Vowels = "aeiouy".toCharArray();

        for(char i:text.toLowerCase().toCharArray()){
            for(char j:Vowels){
                if(i==j){
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}