package ex41;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class App {
    // Main method controls the main processes of the program
    public static void main(String [] args){
        // Program Start
        // Initialize needed variables and classes
        try {
            File inputFile = new File("exercise41_input.txt");
            File outputFile = new File("exercise41_output.txt");
            FileWriter outputHelper = new FileWriter("exercise41_output.txt");
            ArrayList<String> outputArray = new ArrayList<String>();
            fileMethods fileHandler = new fileMethods();
            Scanner readHelper = new Scanner(inputFile);
            // Read file method outputs array
            outputArray = fileHandler.readFile(inputFile, readHelper);
            // Sort strings method sorts the array
            Collections.sort(outputArray);
            // Output method outputs array into a file
            fileHandler.writeFile(outputArray, outputHelper);
            // Close files
            readHelper.close();
            outputHelper.close();
        } catch (FileNotFoundException e){
            System.out.println("Error.");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Error.");
            e.printStackTrace();
        }
            // Program End
    }
}

// class fileMethods handles file input and output methods
class fileMethods{
    // Method readFile reads through the file
    public ArrayList<String> readFile(File inputFile, Scanner readHelper){
        // Initialize variables
        ArrayList<String> returnList = new ArrayList<String>();
        // While loop reads through the file
        // and adds it to an array list
        while(readHelper.hasNextLine()){
            returnList.add(readHelper.nextLine());
        }
        // Return array list containing the file
        // contents
        return returnList;
    }

    // Method writeFile writes the array list contents to a
    // new file
    public void writeFile(ArrayList<String> outputArray, FileWriter outputHelper){
        // While loop goes through the array list
        // and writes the contents to a new file
        try {
            for (int i = 0; i < outputArray.size(); i++) {
                outputHelper.write(outputArray.get(i) + "\n");
            }
        } catch (IOException e){
            System.out.println("Error.");
            e.printStackTrace();
        }
    }
}

