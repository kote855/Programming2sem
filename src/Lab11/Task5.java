package Lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task5 {
    public static List<String> filterSubstring(List<String> list, String substring){
        return  list.stream().filter(s -> s.contains(substring)).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива:");
        int size = in.nextInt();
        in.nextLine();
        System.out.println();

        List<String> strings = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            System.out.println("Введите "+i+" элемент:");
            strings.add(in.nextLine());
        }
        
        System.out.println("\nВведите подстроку:");
        String substring = in.nextLine();

        System.err.println("\nОтфильтрованные элементы:\n"+filterSubstring(strings, substring));
    }
}
