// 1.Текстовый файл: запись и чтение
// Создай файл notes.txt и запиши в него 3 строки (например, три любимых фильма).
// Прочитай файл и выведи строки на экран с номерами: 1. Матрица, 2. ....
// Затем допиши в конец файла ещё одну строку, не стирая старые, и снова выведи содержимое.
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
class First{
    public static void main(String[] args) {
        try {
            Path path = Paths.get("notes.txt");
            List<String> films = new ArrayList<>();
            films.add("1: Matrix");
            films.add("2: Interselar");
            films.add("3:  Project Hail Mary");
            Files.write(path, films,StandardOpenOption.CREATE);
            List<String> allLines = Files.readAllLines(path);
            for(var i:allLines){
                System.out.println(i);
            }
            Files.write(path, List.of("4: The Machinist"), StandardOpenOption.APPEND);
            allLines = Files.readAllLines(path);
            for(var i:allLines){
                System.out.println(i);
            }
            
        }
        catch(IOException e){
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}