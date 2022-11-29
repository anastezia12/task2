package pakege;

import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {

  public static void main(String[] args) throws IOException {
    Task1 task1 = new Task1();
    task1.method();
  }

  private void method() {

    try (InputStream ois =
        new FileInputStream("people.xml");
        Scanner scanner = new Scanner(ois, StandardCharsets.UTF_8).useDelimiter("\\>");
        Writer writer = new FileWriter("peopleAnswer1.xml")) {
      while (scanner.hasNext()) {
        String row = scanner.next();
        writer.write(rowCorrect(row));

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  private String rowCorrect(String row) {
    Pattern patternForName = Pattern.compile("\\Wname\\s?=\\s?\"[^\"]*\"");

    Pattern patternForSurname = Pattern.compile("\\Wsurname\\s?=\\s?\"[^\"]*\"");
    Matcher matcherName = patternForName.matcher(row);
    Matcher matcherSurname = patternForSurname.matcher(row);

    if (matcherName.find() && matcherSurname.find()) {
      String name = matcherName.group(0).trim().replaceAll("name", "")
          .replaceAll("\"", "").replaceAll("=", "").replaceAll(" ", "");
      String surname = matcherSurname.group(0).trim().replaceAll("surname", "")
          .replaceAll("\"", "").replaceAll("=", "").replaceAll(" ", "");
      return
          row.replaceAll("\\Wname\\s*=\\s*(\"[^\"]*\")", " name = \"" + name + " " + surname + "\"")
              .replaceAll("(\\Wsurname\\s*=\\s*\"[^\"]*\")", "") + ">";
    }

    // Pattern attributePattern = Pattern.compile("\\s*(\\S+)\\s*=\\s*'([^']*)'\\s*");

    return "";
  }
}
