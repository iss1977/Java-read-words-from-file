import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;

import java.nio.file.Path;
import java.nio.file.Paths;

import java.nio.charset.StandardCharsets;


public class Hangwords {

    private static byte[] allBytes; // why if I move it into "readFileContentToArray()" it doesn't work?

    public static void main(String[] args) {

        for (String x: readFileContentToArray()) {
            System.out.print(x+" ");
        }

    }

    // read the file "dict.txt" to an array of String with unique words, all in lowercase.
    public static String[] readFileContentToArray(){

//        -- Test. Working...
//        Path currentDir = Paths.get("dict.txt");
//        System.out.println(currentDir.toAbsolutePath());
//        --

            Path inputFile     = Paths.get(".\\dict.txt");

            // display the dictionary file
            System.out.println("Reading dictionary :"+inputFile.toAbsolutePath().toString());

            try {
                long start = System.currentTimeMillis();

                allBytes = Files.readAllBytes(inputFile);

                long end = System.currentTimeMillis();
                System.out.println("File read in " + (end - start) + " ms");

            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // convert bytes[] to string :
            String s = new String(allBytes, StandardCharsets.UTF_8);
            System.out.println("\n\rContent of file : \n\r" + s);

            String[] arrWords = createWordsArray(s);

            // output the words
//            for (String x: arrWords) {
//                System.out.println(x);
//            }
        return arrWords;
    }

    // initiates the static Array arrWords. only used in the readFileContentToArray() method.
    public static String[] createWordsArray(String s){
        ArrayList<String> temp_arr = new ArrayList<>();
        System.out.println("\n\rUsable words:");
        //do a loop through the string "s" to get the words
        String currentWord="";
        for (int i = 0; i <= s.length()-1; i++) {
            char c=s.charAt(i);

            if (c>=65&&c<=122){
                // we found a usable character. add it to the current word.

                currentWord= currentWord.concat(Character.toString(c));
            } else {
                //we found an unusable character, close the current word and reinit.
                if (!currentWord.isEmpty()) { // to check if a word exist or not. if not, it could be a second unusable character ... ( avoid creating empty words)
//                  System.out.print(currentWord + ",");
                    // checking if the word already exists, if not add it to "temp_arr"
                    if (!temp_arr.contains(currentWord.toLowerCase())) temp_arr.add(currentWord.toLowerCase());
                    currentWord = "";
                }
            }
        }
        // return the array of words - conversion is ugly ...
        String[] array2Send = new String[temp_arr.size()];
        array2Send = temp_arr.toArray(array2Send);
        return array2Send;
    }
}

