package Lab11;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите строки разделя их ;");
        String string = in.nextLine();

        List<String> strings = List.of(string.split(";"));
        System.out.println("\nСтроки после сплитования : ");
        for (String e : strings) {
            System.out.println(e);
        }

        List<String> stringAfter = filterStrings(strings);

        System.out.println("\nСтроки после преобразования : ");
        for (String e : stringAfter) {
            System.out.println(e);
        }
    }

    public static List<String> filterStrings(List<String> list){
        return list.stream().filter(s -> s.matches("[a-zA-Zа-яА-ЯёЁ]+")).collect(Collectors.toList());
    }
}
