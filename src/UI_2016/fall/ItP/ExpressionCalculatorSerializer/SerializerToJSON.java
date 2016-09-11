package UI_2016.fall.ItP.ExpressionCalculatorSerializer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SerializerToJSON {
    //http://goloburdin.blogspot.ru/2011/03/json-java.html
    //https://www.mkyong.com/java/json-simple-example-read-and-write-json/
    //http://www.tutorialspoint.com/json/json_java_example.htm
    //https://www.mkyong.com/java/jackson-2-convert-java-object-to-from-json/
    //http://json.org/json-ru.html
    public static void main(String[] args) {
        toJSON();
    }

    public static void toJSON(/*String input, ArrayList arrayList*/) {
        // Write data to file

        JSONObject obj = new JSONObject();
        obj.put("name", "mkyong.com");
        obj.put("age", new Integer(100));

        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.put("messages", list);

//        try {
//
//            FileWriter file = new FileWriter("f:\\test.json");
//            file.write(obj.toJSONString());
//            System.out.println(obj.toJSONString());
//            file.flush();
//            file.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        System.out.print(obj);
    }
}