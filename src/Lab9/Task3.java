package Lab9;

import java.util.Scanner;
public class Task3 {

    // Рекурсивный метод для ввода элементов массива
    public static void inputArray(int[] array, int index) {
        // Базовый случай: если индекс равен длине массива, завершаем рекурсию
        if (index >= array.length) {
            return;
        }
        // Запрашиваем у пользователя ввод элемента массива
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите элемент " + (index + 1) + ": ");
        array[index] = scanner.nextInt();
        // Рекурсивный вызов для следующего индекса
        inputArray(array, index + 1);
    }

    // Рекурсивный метод для вывода элементов массива
    public static void printArray(int[] array, int index) {
        // Базовый случай: если индекс равен длине массива, завершаем рекурсию
        if (index >= array.length) {
            return;
        }
        // Выводим текущий элемент массива
        System.out.print(array[index] + " ");
        // Рекурсивный вызов для следующего индекса
        printArray(array, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        // Создаем массив указанного размера
        int[] array = new int[size];

        // Вводим элементы массива
        inputArray(array, 0);

        // Выводим элементы массива
        System.out.println("Элементы массива:");
        printArray(array, 0);
    }
}
