package Lab11;

import java.util.Arrays;
import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int size = in.nextInt();

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Введите "+i+" элемент:");
            arr[i] = in.nextInt();
        }

        System.out.println("\nВведите ограничение");
        int num = in.nextInt();

        System.out.println("\nМассив arr : ");
        System.out.println(Arrays.toString(arr));
        
        int[] arrResult = filterNumbers(arr, num);

        System.out.println("\nМассив arrResult : ");
        System.out.println(Arrays.toString(arrResult));
    }

    public static int[] filterNumbers(int[] arr, int num){
        return Arrays.stream(arr).filter(x -> x < num).toArray();
    }
}
