package Lab10.Task2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLAdd {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/Lab10/Task1/example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);

            Element rootElement = doc.getDocumentElement();


            Element book1 = doc.createElement("book");
            rootElement.appendChild(book1);

            Element title1 = doc.createElement("title");
            title1.appendChild(doc.createTextNode("Война"));
            book1.appendChild(title1);

            Element author1 = doc.createElement("author");
            author1.appendChild(doc.createTextNode("Лев"));
            book1.appendChild(author1);

            Element year1 = doc.createElement("year");
            year1.appendChild(doc.createTextNode("1111"));
            book1.appendChild(year1);

            /*-------------------------------------------------------------------------*/

            doc.getDocumentElement().normalize();

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/Lab10/Task1/example.xml"));
            transformer.transform(source, result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}