package ex43;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    // Main method controls the main processes of the program
    public static void main(String [] args){
        // Program Start
        // Initialize needed variables and classes
        // and get needed user input.
        String [] userInfo = userInput();
        // File output
        try {
            fileMethods fileHandler = new fileMethods();
            // Create files and folders based on input
            fileHandler.createDir(userInfo);
            File outputFile = new File(userInfo[1], "index.html");
            BufferedWriter outputHelper = new BufferedWriter(new FileWriter(outputFile));
            fileHandler.writeFile(userInfo, outputHelper);
            outputHelper.close();
        } catch (IOException e){
            System.out.println("Error.");
            e.printStackTrace();
        }
        // Program End
    }

    // Method userInput gets user input
    static String [] userInput(){
        // Initialize variables
        String [] input = new String[5];
        Scanner userHelper = new Scanner(System.in);
        // Get website name
        System.out.printf("Site name: ");
        input[0] = userHelper.nextLine();
        input[1] = "./website/" + input[0];
        // Get author
        System.out.printf("Author: ");
        input[2] = userHelper.nextLine();
        // Get js folder
        System.out.printf("Do you want a folder for javascript? ");
        input[3] = userHelper.nextLine();
        // Get CSS folder
        System.out.printf("Do you want a folder for CSS? ");
        input[4] = userHelper.nextLine();

        return input;
    }
}

// class fileMethods handles file output methods
class fileMethods{
    // Method writeFile writes to the html file
    public void writeFile(String [] outputArray, BufferedWriter outputHelper){
        // Output to html
        String title = "<title>" + outputArray[0] + "</title>";
        String meta = "<meta name=\"author\" content=\"" + outputArray[2] + "\">";
        try {
            outputHelper.write(title);
            outputHelper.write(meta);

        } catch (IOException e){
            System.out.println("Error.");
            e.printStackTrace();
        }
    }

    // Method createDir creates directories based on userInput
    public void createDir(String [] decider){
        // Initialize variables
        String concat = "";
        // Create main folders
        File main = new File(decider[1]);
        main.mkdirs();
        // Create aux folders based on
        // index 3 and 4 of decider
        if(decider[3].equals("Y") || decider[3].equals("y")){
            concat = decider[1] + "/js/";
            File js = new File(concat);
            js.mkdir();
        }

        if(decider[4].equals("Y") || decider[4].equals("y")){
            concat = decider[1] + "/css/";
            File css = new File(concat);
            css.mkdir();
        }
    }
}