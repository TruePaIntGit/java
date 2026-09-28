// 2.Бинарный файл: запись и чтение байтов
// Создай массив из 10 байтов (например, значения 10, 20, 30 ... 100).
// Запиши его в файл data.bin через FileOutputStream.
// Прочитай файл обратно через FileInputStream и выведи каждый байт на экран.
// Выведи размер файла. Должно получиться ровно 10 байтов.
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
class Second{
    public static void main(String[] args) {
        try {
            byte[] data = new byte[10];
            for (int i = 0; i < 10; i++) {
                data[i] = (byte) ((i + 1) * 10);
            }
            
            FileOutputStream fos = new FileOutputStream("data.bin");
            fos.write(data);
            fos.close();
            
            FileInputStream fis = new FileInputStream("data.bin");
            byte[] readData = new byte[10];
            fis.read(readData);
            fis.close();
            
            for (int i = 0; i < readData.length; i++) {
                System.out.println("Byte " + (i + 1) + ": " + readData[i]);
            }
            
            File file = new File("data.bin");
            System.out.println("File size: " + file.length() + " bytes");
            
        } catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
}