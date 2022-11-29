package pakege;

import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import model.People;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParserXML {

  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    DocumentBuilder builder = factory.newDocumentBuilder();

    Document document = builder.parse(ClassLoader.getSystemResourceAsStream("people.xml"));

    List<People> empList = new ArrayList<>();

    NodeList nodeList = document.getDocumentElement().getChildNodes();

    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);
      if (node instanceof Element) {
        People emp = new People();
        emp.setName( node.getAttributes().
            getNamedItem("name").getNodeValue());
        emp.setSurname(node.getAttributes().
            getNamedItem("surname").getNodeValue());

        try {
          emp.setBirthData( node.getAttributes().
              getNamedItem("birthDate").getNodeValue());
        } catch (Exception exception) {
          emp.setBirthData( node.getAttributes().
              getNamedItem("birthData").getNodeValue());
        }

        emp.setNameSurname();

        empList.add(emp);


      }

      XMLWriter.xMLjdomWriter(empList);

    }


  }
}
