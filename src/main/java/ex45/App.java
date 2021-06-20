package ex45;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class App {
    static Scanner userInput = new Scanner(System.in);
    // Main method controls the main processes of the program
    public static void main(String [] args){
        // Program Start
        // Initialize needed variables and classes
        System.out.printf("What do you want to name the file? ");
        String fileName = userStep();
        try {
            File inputFile = new File("exercise45_input.txt");
            File outputFile = new File(fileName + ".txt");
            FileWriter outputHelper = new FileWriter(fileName + ".txt");
            wordMethods wordHelper = new wordMethods();
            ArrayList<String> inputArray = new ArrayList<String>();
            ArrayList<String> outputArray = new ArrayList<String>();
            fileMethods fileHandler = new fileMethods();
            Scanner readHelper = new Scanner(inputFile);
            // Read file method outputs array
            inputArray = fileHandler.readFile(inputFile, readHelper);
            // Replace method replaces utilize
            outputArray = wordHelper.replaceWord(inputArray);
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

    // Method userStep takes in user input
    public static String userStep(){
        // Initialize variables
        String input;
        // Take in user input
        input = userInput.nextLine();
        // Return user input
        return input;
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

class wordMethods{
    // Method replaceWord replaces the word
    // utilize with use
    public ArrayList<String> replaceWord(ArrayList<String> inputList){
        // Initialize variable
        ArrayList<String> outputList = new ArrayList<String>();
        // For loop replaces all occurrences of utilize
        // with use and adds it to another list
        for (int i = 0; i < inputList.size(); i++) {
            outputList.add((inputList.get(i)).replace("utilize", "use"));
        }
        // Return list
        return outputList;
    }
}

