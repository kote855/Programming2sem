package Lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Task6 {
    public static void main(String[] args) {
        HashMap<Integer, String> objects = new HashMap<>();

        for (int i = 1; i <= 10; i++) {
            objects.put(i, "String " + i);
        }

        //Строки у которых
        ArrayList<String> keySort = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : objects.entrySet()) {
            if (entry.getKey()>5){
                keySort.add(entry.getValue());
            }
        }
        System.out.println("Ключ > 5: " + keySort);

        System.out.println();

        //Если ключ = 0, вывести строки через запятую.
        System.out.print("Строки через запятую если ключ = 0: ");
        if (objects.containsKey(0)) {
            System.out.print(objects.values());
        }
        System.out.println();

        System.out.println();

        //Перемножить все ключи, где длина строки>5.
        Integer keyMult = null;
        for (Map.Entry<Integer, String> entry : objects.entrySet()) {
            if (entry.getValue().length()>5){
                try {
                    keyMult *= entry.getKey();
                }catch (NullPointerException e){
                    keyMult = entry.getKey();
                }
            }
        }
        System.out.println("Перемножение ключей: " + keyMult);

//        printHash(objects);
    }
    static void printHash(HashMap<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(String.format("%-15s", "Key: " + entry.getKey()) + " Value: " + entry.getValue());
        }
    }
}
