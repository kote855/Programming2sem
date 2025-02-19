package Lab13.Task2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите размер массива");
            int size = in.nextInt();
            System.out.println();

            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.println("Введите "+i+" элемент:");
                arr[i] = in.nextInt();
            }

            System.out.println("\nМассив arr : ");
            System.out.println(Arrays.toString(arr));
            
            System.out.println("\nСреднее : ");
            System.out.println(avgNum(arr));
        } catch (InputMismatchException e) {
            System.out.println("Введено не целое число!");
        } catch (NoSuchElementException e) {
            System.out.println("Нет положительных элементов!");
        }
    }

    public static double avgNum(int[] arr){
        arr = Arrays.stream(arr).filter(x -> x >= 0).toArray();
        double res = Arrays.stream(arr).average().getAsDouble();
        return res;
    }
}
