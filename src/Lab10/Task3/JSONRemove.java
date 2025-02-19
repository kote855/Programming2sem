package Lab10.Task3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;

public class JSONRemove {
    public static void main(String[] args) {
        var path = "src/Lab10/Task1/example.json";
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader(path));
            JSONObject jsonObject = (JSONObject) obj;

            JSONArray jsonArray = (JSONArray) jsonObject.get("books");
            String title = "Новая книга";
            Iterator iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject book = (JSONObject) iterator.next();
                if (title.equals(book.get("title"))) {
                    iterator.remove();
                }
            }

            try (FileWriter file = new FileWriter(path)){
                file.write(jsonObject.toJSONString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
