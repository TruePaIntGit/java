// 1.Создай три потока через Runnable (один через лямбду, один через отдельный класс).
//  Каждому задай имя через setName и приоритет: MIN_PRIORITY, NORM_PRIORITY, 
//  MAX_PRIORITY. Каждый печатает своё имя и приоритет 5 раз с Thread.sleep(100). 
//  В main дождись всех через join и напечатай «Все завершились»

public class First {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Task(), "MinThread");
        t1.setPriority(Thread.MIN_PRIORITY);

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " priority=" + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }, "NormThread");
        t2.setPriority(Thread.NORM_PRIORITY);

        Thread t3 = new Thread(new Task(),"MaxThread");
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("All finished");
    }
}

class Task implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " priority=" + Thread.currentThread().getPriority());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}