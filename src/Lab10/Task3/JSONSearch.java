package Lab10.Task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.stream.Stream;

public class JSONSearch {
    public static void main(String[] args) {
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/Lab10/Task1/example.json"));
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("Корневой элемент: " + jsonObject.keySet().iterator().next());
            JSONArray jsonArray = (JSONArray) jsonObject.get("books");

            String author = "Лев Толстой";
            jsonArray.stream().map(book -> (JSONObject) book)
                    .filter(book -> author.equals(((JSONObject) book).get("author")))
                    .forEach(book -> {
                        System.out.println("\nТекущий элемент: book");
                        System.out.println("Название книги: " + ((JSONObject) book).get("title"));
                        System.out.println("Автор: " + ((JSONObject) book).get("author"));
                        System.out.println("Год издания: " + ((JSONObject) book).get("year"));
                    });

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
