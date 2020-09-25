/*Author: Vaibhavi Dharashivkar and Saloni Shah*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;


public class NumberCount {

    /**
     * @param fileName It is the name of the file given by the user in the command line arguments
     * @return This function returns a new unzipped file with the name file.txt
     */
    public static String zipDigitCounting(String fileName) {
        String newFile = "file.txt";


        GZIPInputStream in = null;
        OutputStream out = null;
        try {
            //unzipping a gzipped file
            in = new GZIPInputStream(new FileInputStream(fileName));
            out = new FileOutputStream(newFile);
            //creating a buffer
            byte[] buf = new byte[1024 * 4];
            int len;
            //reading from the zip file into a new file until the length of the file is reached
            while ((len = in.read(buf)) > 0) {
                //writing the content in the new file
                out.write(buf, 0, len);
            }

            // Handling exceptions under the checked IOException class such as FileNotFoundException etc.
        } catch (IOException e) {
            // Closing all the open resources in the finally block which will always execute
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException i) {
                }
            if (out != null)
                try {
                    out.flush();
                    out.close();
                } catch (IOException i) {
                }
        }
        return newFile;
    }

    /**
     * @param fileName This is the name of the file that needs to be read in order to get output
     *                 This function reads the file character by character until the end is reached. For every character,
     *                 if it is between 0 to 9, the respective hash map value of the key is incremented.
     *                 And the whole hash map is displayed at the end which contains the count of the
     *                 total occurrence of every digit in the file.
     */
    public static void digitCounting(String fileName) {
        // creating a new BufferReader resource and wrapping inside of it the FileReader which contains the filename.
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            // Creating a hash map using generics Integer,Integer
            Map<Integer, Integer> myMap = new HashMap<>();
            //initializing the hash map with 0 to 9 as all zeros.
            for (int i = 0; i < 10; i++) {
                myMap.put(i, 0);
            }
            int c = 0;
            //reading character by character until all characters are over.
            while ((c = input.read()) != -1) {
                try {
                    //getting the numeric value of the character and storing that value in an Integer variable.
                    Integer anInteger = Character.getNumericValue((char) c);
                    //If the hash map contains the key same as anInteger,
                    if (myMap.containsKey(anInteger)) {
                        Integer aCounter = 0;
                        //get the value of the respective key
                        aCounter = myMap.get(anInteger);
                        // increment the value of the respective key
                        myMap.put(anInteger, aCounter + 1);
                    }
                    // handling the case where if the character cannot be converted into an Integer. e.g. (. in 3.14)
                } catch (NumberFormatException e) {
                }
            }
            // displaying all the keys and values of the hash map
            for (Map.Entry<Integer, Integer> entry : myMap.entrySet()) {
                System.out.println(entry.getKey() + "   " + entry.getValue());
            }
            //catching all IOExceptions
        } catch (FileNotFoundException ef) {
            System.out.println("File not found1");
        } catch (IOException ef) {
            System.out.println("File not found2");
        }
    }

    public static void main(String[] args) {

        try {
            // taking the user input from command line
            String file = args[0];


        /*if (file.contains("/")){
            System.out.println("Not telling");
            System.exit(0);
        }*/
            // if the file name entered by the user ends with a .txt, then no need to unzip the file,
            // use the digitCounting function directly by passing the user input to the function.
            if (file.endsWith(".txt")) {

                digitCounting(file);

            }
            // if the file name entered by the user ends with a .gz, first unzip the file and then new file returned by
            // zipDigitCounting function is passed to the dititCounting function which gives the desired output.
            else if (file.endsWith(".gz")) {

                String newFile = zipDigitCounting(file);
                digitCounting(newFile);

            }
            //if the file name entered by the user does not end with .txt or .gz extension,
            // then the file is not a correct file, in such case exit the program with a msg on the console.
            else {
                System.out.println("You entered a wrong file");
                System.exit(0);
            }
            //If the user does not enter anything, handle this exception and exit the program.
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You did not put the file name..!");
        }


    }
}
