package Lab12;

public class Task4 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            final int threadNumber = i;
            threads[i] = new Thread(() -> {
                System.out.println("Поток номер: " + threadNumber);
            });
        }

        for (Thread thread : threads) {
            try {
                thread.start();
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Все потоки завершены.");
    }
}
