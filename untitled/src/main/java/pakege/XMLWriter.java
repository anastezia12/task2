package pakege;

import model.People;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;


import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;

public class XMLWriter {

  public static void xMLjdomWriter(List<People> people) throws IOException {

    String fileName = "people1.xml";
    writeToXMLusingJDOM(people, fileName);
  }

  private static void writeToXMLusingJDOM(List<People> people, String fileName) throws IOException {
    Document doc = new Document();
    doc.setRootElement(new Element("persons"));
    for (People person : people) {
      Element studentElement = new Element("person");
      studentElement.setAttribute("name", String.valueOf(person.getNameSurname()));
      studentElement.setAttribute("birthData", String.valueOf(person.getBirthData()));

      doc.getRootElement().addContent(studentElement);
    }
    XMLOutputter xmlWriter = new XMLOutputter(Format.getPrettyFormat());
    xmlWriter.output(doc, new FileOutputStream(fileName));


  }
}
