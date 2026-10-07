// 1.Класс Loader implements Runnable с полем boolean running = true и методом stop(). 
// В run() поток в цикле печатает «Загружаю...» и спит 300 мс, пока running == true. 
// В main запусти поток, через 2 секунды вызови stop() и убедись, что поток завершился 
// (join()).
class First{
    public static class Loader implements Runnable {
        private boolean running = true;

        @Override
        public void run() {
            while (running) {
                System.out.println("Loading...");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        public void stop() {
            running = false;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Loader loader = new Loader();
        Thread thread = new Thread(loader);
        thread.start();
        Thread.sleep(2000);
        loader.stop();
        thread.join();
        }
}