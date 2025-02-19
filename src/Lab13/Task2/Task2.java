package Lab13.Task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            int[][] arr = new int[10][10];

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    arr[i][j] = i + j;
                }
            }

            System.out.println("Введите столбец");
            int col = in.nextInt();
            System.out.println();
            
            for (int i = 0; i < 10; i++) {
                System.out.println(arr[i][col - 1]);
            }

        } catch (InputMismatchException e) {
            System.out.println("Введено не целое число!");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Такого стоблца не существует!");
        }
    }
}
