package ex44;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
    static Scanner userInput = new Scanner(System.in);

    // Main method runs all functions
    public static void main(String [] args){
        // Initialize variables
        fileHandler fileHelper = new fileHandler();
        jsonHandler jsonHelper = new jsonHandler();
        JSONObject object = fileHelper.parser();
        JSONArray itemArray;
        String input = userStep();
        int index;
        // Parse file
        itemArray = jsonHelper.createArray(object);
        // Check for input validity
        while((index = jsonHelper.isThere(itemArray, input)) == -1){
            input = userStep();
        }
        // Output
        jsonHelper.printResults(itemArray, index);
    }

    // Method userStep takes in user input
    public static String userStep(){
        // Initialize variables
        String input;
        // Take in user input
        System.out.printf("What is the product name? ");
        input = userInput.nextLine();
        // Return user input
        return input;
    }
}

// Class fileHandler manages json file input
class fileHandler{
    // Method parser returns a usable json object
    public JSONObject parser() {
        // Initialize variables
        Object parsedFile;
        try {
            JSONParser parseHelper = new JSONParser();
            // Parse file using parse function
            FileReader file = new FileReader("exercise44_input.json");
            parsedFile = parseHelper.parse(file);
            // Create JSON object
            JSONObject parsedObject = (JSONObject) parsedFile;
            file.close();

            return parsedObject;
        } catch (IOException e){
            System.out.println("Error.");
            e.printStackTrace();
        } catch (ParseException e){
            System.out.println("Error.");
            e.printStackTrace();
        }

        return null;
    }
}

// Class jsonHandler manages json functions
class jsonHandler{
    // Method createArray creates a json array
    public JSONArray createArray(JSONObject convert){
        // Initialize variables
        JSONArray outputArray = (JSONArray) convert.get("products");
        // Return json array
        return outputArray;
    }

    // Method isThere checks to see if the inputted word is
    // in the array
    public int isThere(JSONArray input, String name){
        for (int i = 0; i < input.size(); i++) {
            JSONObject items = (JSONObject) input.get(i);
            String index = (String) items.get("name");

            if(index.equals(name)){
                return i;
            }
        }

        System.out.println("Sorry, that product was not found in our inventory.");
        return -1;
    }

    // Method printResults prints the item data
    public void printResults(JSONArray input, int i){
        // Initialize variables
        JSONObject item = (JSONObject) input.get(i);
        String name = (String) item.get("name");
        Double price = (Double) item.get("price");
        long quantity = (long) item.get("quantity");
        // Print items
        System.out.printf("Name: %s%nPrice: %.2f%nQuantity: %d", name, price, quantity);
    }
}
