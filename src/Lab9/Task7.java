package Lab9;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task7 {
    public static void main(String[] args) {
        Integer number_of_people = 10;

        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> linked = new LinkedList<>();
        for (int i = 0; i < number_of_people; i++) {
            array.add("Person " + i);
            linked.add("Person " + i);
        }

        long startTime = System.nanoTime();
        array = array_prog(array);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.printf("ArrayList: %,.5f ms\n", timeElapsed/1_000_000.0);

        startTime = System.nanoTime();
        linked =  linked_prog(linked);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        System.out.printf("LinkedList: %,.5f ms\n", timeElapsed/1_000_000.0);
    }

    static ArrayList<String> array_prog(ArrayList<String> array){
        while (array.size() != 1){
            for (int i = 1; i < array.size(); i+=2) {
                array.remove(i);
            }
        }
        return array;
    }
    static LinkedList<String> linked_prog(LinkedList<String> array){
        while (array.size() != 1){
            for (int i = 1; i < array.size(); i+=2) {
                array.remove(i);
            }
        }
        return array;
    }
}
