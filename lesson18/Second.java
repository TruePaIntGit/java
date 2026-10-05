// 2.Возьми пример со счётчиком:
// static int counter = 0;
// void main(){
   
// }
// с 4 потоками по 100 000 инкрементов. Запусти его в цикле 10 раз и в конце выведи, 
// сколько раз результат оказался равен 400000, а также минимум и максимум.
// Затем поменяй число итераций на 100 и сравни что получилось.

public class Second {
    static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int run = 0; run < 5; run++) {
            counter = 0;
            Thread[] threads = new Thread[4];
            for (int i = 0; i < 4; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < 100000; j++) {
                        counter++;
                    }
                });
            }
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            System.out.println("Run " + (run + 1) + " (100000): counter=" + counter);
        }

        for (int run = 0; run < 5; run++) {
            counter = 0;
            Thread[] threads = new Thread[4];
            for (int i = 0; i < 4; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < 100; j++) {
                        counter++;
                    }
                });
            }
            for (Thread t : threads) {
                t.start();
            }
            for (Thread t : threads) {
                t.join();
            }
            System.out.println("Run " + (run + 1) + " (100): counter=" + counter);
        }
    }
}