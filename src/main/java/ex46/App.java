package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class App {
    public static void main(String [] args){
        // Program Start
        // Initialize needed variables and classes
        try {
            File inputFile = new File("exercise46_input.txt");
            fileMethods fileHandler = new fileMethods();
            frequencyMethods frequencyHelper = new frequencyMethods();
            Scanner readHelper = new Scanner(inputFile);
            ArrayList<String> inputArray = new ArrayList<String>();
            Map<String, Integer> outputMap;
            // Read file method outputs arrayList
            inputArray = fileHandler.readFile(inputFile, readHelper);
            // Frequency finder calculates frequencies
            outputMap = frequencyHelper.findFrequency(inputArray);
            // Output method outputs the histogram
            frequencyHelper.printFrequencies(outputMap);
            // Close files
            readHelper.close();
        } catch (FileNotFoundException e){
            System.out.println("Error.");
            e.printStackTrace();
        }
        // Program End
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

// class frequencyMethods handles frequency finding
// and frequency output
class frequencyMethods{
    // Method findFrequency calculates the frequency of
    // each word in the strings
    public Map<String, Integer> findFrequency(ArrayList<String> inputList){
        // Initialize variables
        Map<String, Integer> outputMap = new HashMap<>();
        String [] frequencyFinder;
        int tracker = 0;
        // For loop goes through each String in the list
        // and counts word Frequency
        for(int i = 0; i < inputList.size(); i++){
            // Split string into array
            frequencyFinder = (inputList.get(i)).split(" ");
            // Nested for loop goes through each
            // string array and calculates frequency
            for(int j = 0; j < frequencyFinder.length; j++){
                // If statement checks to see if the word
                // is already in the map and adds it if it
                // isn't
                if (outputMap.containsKey(frequencyFinder[j])) {
                    tracker = outputMap.get(frequencyFinder[j]);
                    outputMap.put(frequencyFinder[j], tracker + 1);
                } else {
                    outputMap.put(frequencyFinder[j], 1);
                }
            }
        }
        // Return map
        return outputMap;
    }

    // Method printFrequencies prints the frequencies in a
    // histogram format
    public void printFrequencies(Map<String, Integer> outputMap){
        // Initialize variables
        Set<String> words = outputMap.keySet();
        // For loop goes through the map and
        // prints the names
        for(String word : words){
            // Nested for loop prints the stars for
            // the graph
            System.out.printf(word + ": ");
            for(int i = 0; i < outputMap.get(word); i++){
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}