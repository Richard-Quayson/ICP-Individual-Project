package ICP_Individual_Project;

/**
 * this file defines operations for the readWriteFile class
 * operations include a readFile and writeFile class
 * which read and write to a file respectively
 *
 * @author Richard Quayson
 */

import java.io.*;
import java.util.ArrayList;

/**
 * implements methods that help to read and write into a file
 */
class readWriteFile {


    /**
     * reads a given file and returns an ArrayList<String>
     * with each String[] representing information on a line
     * @param fileName the name of the file to be read
     * @return ArrayList<String[]>
     *
     * uncomment extremeCases and return it to test the printExtremeAirportCases method in createObjects class
     */
    public static ArrayList<String[]> readFile(String fileName) {
        ArrayList<String[]> stringArray = new ArrayList<>();
//        ArrayList<String[]> extremeCases = new ArrayList<>();
        try {
            File readFile = new File(fileName);
            BufferedReader read = new BufferedReader(new FileReader(readFile));
            String line;
            String[] objectAttributesArray;

            while ((line = read.readLine()) != null) {
                objectAttributesArray = line.split(",");

                /*
                this if condition applies for the airports.csv file,
                where we check for extra commas in the various columns
                 */
                if (objectAttributesArray.length > 14) {
//                    extremeCases.add(objectAttributesArray);
//                    extremeCases.add(newObject);
                    String[] newObject = createObjects.gracefullyHandleAirportObjectCreation(objectAttributesArray);
                    stringArray.add(newObject);
                } else {
                    stringArray.add(objectAttributesArray);
                }
            }
            read.close();

        } catch (FileNotFoundException fnfe) {
            System.out.println("FileNotFondException caught: " + fnfe.getMessage());
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("IOException caught: " + ioe.getMessage());
            ioe.printStackTrace();
        }
        return stringArray;
//        return extremeCases;
    }


    /**
     * write to a given file the data provided
     * @param fileName the name of the file to write into
     * @param information the data to be written to the file
     */
    public static void writeFile(String fileName, StringBuilder information) {
        String data = information.toString();
        try {
            File writeFile = new File(fileName);
            BufferedWriter write = new BufferedWriter(new FileWriter(fileName));
            String[] lines = data.split(System.lineSeparator());

            for (String line: lines) {
                write.write(line);
            }
            System.out.println("File created successfully with the information.");
            write.close();
        }
        catch (IOException ioe) {
            System.out.println("IOException caught: " + ioe.getMessage());
        }
    }
}