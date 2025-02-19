package Lab9;

import java.util.Scanner;
public class Task2 {

    // Рекурсивный метод для перевода числа в двоичную систему
    public static String decToBin(int number) {
        // Базовый случай: если число равно 0, возвращаем пустую строку
        if (number == 0) {
            return "0";
        }
        // Рекурсивный вызов, делим число на 2 и получаем остаток
        return decToBin(number / 2) + (number % 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите целое число: ");

        // Читаем целое число с клавиатуры
        int number = scanner.nextInt();

        // Проверяем, не является ли число отрицательным
        if (number < 0) {
            System.out.println("Пожалуйста, введите неотрицательное целое число.");
        } else {
            // Получаем двоичное представление числа
            String binaryRepresentation = decToBin(number);
            System.out.println("Двоичное представление числа " + number + " равно: " + binaryRepresentation);
        }
    }
}
