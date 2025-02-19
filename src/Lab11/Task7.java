package Lab11;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите строки разделя их ;");
        String string = in.nextLine();

        System.out.println("\nВведите максимальную длину");
        int lenght = in.nextInt();

        List<String> strings = List.of(string.split(";"));
        System.out.println("\nСтроки после сплитования : ");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringAfter = filterStrings(strings, lenght);

        System.out.println("\nСтроки после преобразования : ");
        for (String e : stringAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterStrings(List<String> list, int length){
        return list.stream().filter(s -> s.length() <= length).collect(Collectors.toList());
    }
}
