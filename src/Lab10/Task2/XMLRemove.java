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
import java.util.stream.*;
import java.util.List;

public class XMLRemove {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/Lab10/Task1/example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            System.out.println("Корневой элемент = " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("book");

            List<Element> books = IntStream.range(0, nodeList.getLength())
                    .mapToObj(nodeList::item)
                    .filter(node -> node.getNodeType() == Node.ELEMENT_NODE)
                    .map(node -> (Element) node)
                    .filter(element -> {
                        String author = element.getElementsByTagName("author").item(0).getTextContent();
                        String year = element.getElementsByTagName("year").item(0).getTextContent();
                        return author.equalsIgnoreCase("Лев Толстой") && year.equals("1869");
                    })
                    .collect(Collectors.toList());

            for (Element book : books) {
                System.out.println("\nТекущий элемент = " + book.getNodeName());
                if (book.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) book;
                    Node parentNode = element.getParentNode();
                    parentNode.removeChild(element);
                    System.out.println("Название книги: " + element.getElementsByTagName("title").item(0).getTextContent());
                    System.out.println("Автор: " + element.getElementsByTagName("author").item(0).getTextContent());
                    System.out.println("Год издания: " + element.getElementsByTagName("year").item(0).getTextContent());
                }
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/Lab10/Task1/example.xml"));
            transformer.transform(source, result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
