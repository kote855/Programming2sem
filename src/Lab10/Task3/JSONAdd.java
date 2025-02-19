package Lab10.Task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;

public class JSONAdd {
    public static void main(String[] args) {
        var path = "src/Lab10/Task1/example.json";
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray jsonArray = (JSONArray) jsonObject.get("books");
            JSONObject newBook = new JSONObject();
            newBook.put("title", "Новая книга");
            newBook.put("author", "Новый автор");
            newBook.put("year", 2023);
            jsonArray.add(newBook);

            try (FileWriter file = new FileWriter(path)){
                file.write(jsonObject.toJSONString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
