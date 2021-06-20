package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class App {
    // Main method controls the main processes of the program
    public static void main(String[] args) {
        // Program Start
        // Initialize needed variables and classes
        try {
            File inputFile = new File("exercise42_input.txt");
            ArrayList<String> outputArray = new ArrayList<String>();
            Scanner readHelper = new Scanner(inputFile);
            dataHandling dataHelper = new dataHandling();
            fileMethods fileHelper = new fileMethods();
            // Read file method outputs array
            outputArray = fileHelper.readFile(inputFile, readHelper);
            // Parse method parses through the data of the array
            outputArray = dataHelper.parseData(outputArray);
            // Output method outputs the data in a tabular format
            dataHelper.printList(outputArray);
            // Close file
            readHelper.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}

// class fileMethods handles file input methods
class fileMethods {
    // Method readFile reads through the file
    public ArrayList<String> readFile(File inputFile, Scanner readHelper) {
        // Initialize variables
        ArrayList<String> returnList = new ArrayList<String>();
        // While loop reads through the file
        // and adds it to an array list
        while (readHelper.hasNextLine()) {
            returnList.add(readHelper.nextLine());
        }
        // Return array list containing the file
        // contents
        return returnList;
    }
}

// class dataHandling handles and parses
// the data of the program
class dataHandling{
    // Method parseData sorts the data into
    // a list and returns it
    public ArrayList<String> parseData(ArrayList<String> inputList){
        // Initialize variables
        ArrayList<String> parsedList = new ArrayList<String>();
        String [] placeholderString;
        // For loop continues through the list
        // and splits the strings around the , character
        for(int i = 0; i < inputList.size(); i++){
            placeholderString = (inputList.get(i)).split(",");
            for(int j = 0; j < placeholderString.length; j++){
                parsedList.add(placeholderString[j]);
            }
        }
        // Return the list
        return parsedList;
    }

    // Method printList prints the given list
    // in an table
    public void printList(ArrayList<String> parsedList){
        // Print categories and bars
        System.out.printf("Last  \t   First\t   Salary%n");
        System.out.println("------------------------------");
        // For loop prints list in table format
        for(int i = 1; i < parsedList.size() + 1; i++){
            if(i % 3 != 0 || i == 0){
                System.out.printf("%-8s\t", parsedList.get(i-1));
            } else{
                System.out.printf("%-8s\n", parsedList.get(i-1));
            }
        }
    }
}
