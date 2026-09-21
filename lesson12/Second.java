// 2.Считать с клавиатуры N слов в цикле, добавляя каждое в ArrayList<String>. 
// Создать HashSet<String> из этого списка (new HashSet<>(list)) и вывести его 
// размер в сравнении с размером исходного списка — так наглядно видно, сколько 
// было повторов. Вывести сами уникальные слова из Set.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
class Second{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = 5;
        ArrayList<String> words = new ArrayList<>();
        HashSet<String> wordsWithoutRepeat = new HashSet<>();
        System.out.println("Enter "+N+" words");
        for(int i =0; i<N;i++){
            String word = scan.next();
            words.add(word);
            wordsWithoutRepeat.add(word);
        }
        System.out.println("Size of ArrayList: "+words.size());
        System.out.println("Size of HashList: "+wordsWithoutRepeat.size());
    }
}