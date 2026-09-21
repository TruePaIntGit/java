// 3.Считать с клавиатуры предложение, разбить на слова через split(" "). Создать 
// HashMap<String, Integer> и посчитать, сколько раз встречается каждое слово 
// (проверять containsKey, если есть — увеличивать счётчик через put(word, 
// map.get(word) + 1), если нет — put(word, 1)). Вывести итоговую таблицу "слово — 
// количество" (перебор через for (String key : map.keySet()) или entrySet()).
import java.util.HashMap;
import java.util.Scanner;
class Third{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some text");
        String text=scanner.nextLine();
        String[] words = text.split(" ");
        HashMap<String,Integer> countWords = new HashMap<>();
        for(String i:words){
            if(countWords.containsKey(i)){
                countWords.put(i, countWords.get(i)+1);
            }
            else{
                countWords.put(i, 1);
            }
        }
        System.out.println("Word                Count");
        for(String key : countWords.keySet()){
            System.out.println(key+"\t\t\t\t"+countWords.get(key));
        }
    }
}