package task2;



import java.io.FileWriter;

import java.io.PrintWriter;

import java.util.Map;
import java.util.Map.Entry;
import org.json.simple.JSONObject;


public class JsonWriter {

  public static void JsonDemo(Map<String, Double> map) throws Exception {

    JSONObject json = new JSONObject();
    try (PrintWriter out = new PrintWriter(new FileWriter("roadAccident.json"))) {
      for (Entry<String, Double> entry : map.entrySet()) {
        json.put("type", entry.getKey());
        json.put("fine_amount", entry.getValue());
        out.write(json.toString() + ", \n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }


}
