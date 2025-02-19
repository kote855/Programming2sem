package Lab13.Task2;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Введите размер массива");
            int size = in.nextInt();
            System.out.println();

            byte[] arr = new byte[size];

            for (int i = 0; i < size; i++) {
                System.out.println("Введите "+i+" элемент:");
                arr[i] = in.nextByte();
            }

            System.out.println("\nМассив arr : ");
            System.out.println(Arrays.toString(arr));
            
            System.out.println("\nСумма : ");
            System.out.println(sum(arr));
        } catch (InputMismatchException e) {
            System.out.println("Введённые данные не являются byte!");
        } catch (ArithmeticException  e) {
            System.out.println("Сумма выходит за границы!");
        }
    }

    public static byte sum(byte[] arr){
        int sum = 0;
        for (byte b : arr) {
            sum += b;
        }

        if (sum < Byte.MIN_VALUE || sum > Byte.MAX_VALUE) {
            throw new ArithmeticException();
        }

        return (byte) sum;
    }
}
