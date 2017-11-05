
// This class focuses on loading the JSON file, extracting the stuff, and placing it therefore in the GUI.

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONStuff {

    public JSONStuff() {

    }

    public ArrayList<Element> extractData(File JSONfile) throws IOException, ParseException {
        ArrayList<Element> elements = new ArrayList();

        JSONParser parser = new JSONParser();
        JSONArray arr = (JSONArray) parser.parse(new FileReader(JSONfile));

        for(Object o: arr) {
            JSONObject element = (JSONObject) o;

            String inputType = (String) element.get("inputType");
            String placeholder = (String) element.get("placeholder");
            String height = (String) element.get("height");
            String width = (String) element.get("width");
            String fontSize = (String) element.get("fontSize");
            if(!fontSize.equals(""))
                fontSize = fontSize.substring(0, fontSize.length()-2);
            String leftPosition = (String) element.get("leftPosition");
            if(!leftPosition.equals(""))
                leftPosition = leftPosition.substring(0, leftPosition.length()-2);
            String topPosition = (String) element.get("topPosition");
            if(!topPosition.equals(""))
                topPosition = topPosition.substring(0, topPosition.length()-2);

            /* Checkers in case you want to check something regarding the extracted data.
            System.out.println("Input type is: " + inputType);
            System.out.println("Placeholder is: " + placeholder);
            System.out.println("Height is: " + height);
            System.out.println("Width is: " + width);
            System.out.println("Font size is: " + fontSize);
            System.out.println("Left position is: " + leftPosition);
            System.out.println("Top position is: " + topPosition);
            */
            elements.add(new Element(inputType, placeholder, height, width, fontSize, leftPosition, topPosition));
        }

        return elements;
    }
}
