package Lab12;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Task5 {
    public static void main(String[] args) throws Exception {
        int size = 100;
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }

        System.out.println("Максимальный элемент в массиве: " + findMaxInArray(array));
    }

    public static int findMaxInArray(int[] array) throws Exception {
        int numWorkers = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numWorkers);
        int chunkSize = array.length / numWorkers;

        Future<Integer>[] futures = new Future[numWorkers];

        for (int i = 0; i < numWorkers; i++) {
            final int start = i * chunkSize;
            final int end = (i == numWorkers - 1) ? array.length : (i + 1) * chunkSize; //остаток в последнем фрагменте
            futures[i] = executor.submit(() -> {
                int max = array[start];
                for (int j = start; j < end; j++) {
                    if (array[j] > max) {
                        max = array[j];
                    }
                }
                return max;
            });
        }

        int max = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            max = Math.max(max, future.get());
        }

        executor.shutdown();
        return max;
    }
}
