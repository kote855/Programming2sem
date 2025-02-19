package Lab10.Task4;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;

public class HTMLParse3 {
    public static void main(String[] args) {

        String url = "https://itlearn.ru/first-steps";
        String filePath = "src/Lab10/Task4/links.xlsx";

        int maxAttempts = 3;
        int attempt = 0;

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Товары");

        while (attempt < maxAttempts) {
            try {
                Document doc = Jsoup.connect(url).get();
                Elements links = doc.select("a[href]");
                for (int i = 0; i < links.size(); i++) {
                    Element link = links.get(i);
                    sheet.createRow(i).createCell(0).setCellValue(link.attr("abs:href"));
                }

                FileOutputStream outputStream = new FileOutputStream(filePath);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();

                break;
            }catch (HttpStatusException e){
                attempt++;
                System.out.println("Попытка " + attempt + " не удалась. Ошибка: " + e.getMessage());
                if (attempt == maxAttempts) {
                    System.out.println("Достигнуто максимальное количество попыток. Выход.");
                }
            }catch (Exception e){
                e.printStackTrace();
                break;
            }
        }
    }
}
