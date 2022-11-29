package task2;

import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Task2 {

  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    DocumentBuilder builder = factory.newDocumentBuilder();

    Document document = builder.parse(ClassLoader.getSystemResourceAsStream("roadAccident.xml"));
    Map<String, Double> empList = new HashMap<>();

    NodeList nodeList = document.getDocumentElement().getChildNodes();

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      if (node instanceof Element) {
        if (empList.containsKey(node.getAttributes().
            getNamedItem("type").getNodeValue())) {
          Double x;
          x = empList.get(node.getAttributes().
              getNamedItem("type").getNodeValue()) + Double.valueOf(node.getAttributes().
              getNamedItem("fine_amount").getNodeValue());
          empList.put(node.getAttributes().
              getNamedItem("type").getNodeValue(), x);

        } else {
          empList.put(node.getAttributes().
              getNamedItem("type").getNodeValue(), Double.valueOf(node.getAttributes().
              getNamedItem("fine_amount").getNodeValue()));
        }


      }


    }

    JsonWriter.JsonDemo(empList);
  }
}
