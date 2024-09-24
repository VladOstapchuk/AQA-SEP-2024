package org.prog.homeworks.session3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//TODO: write method that will count text file lines and print it (put it in separate method)
// (you can use ChatGPT to generate this part)
// Trasnform FileNotFoundException into RuntimeException
// Catch this exception in main method call this method once for existing file
// second time for non-existing file
// print "YAY!" after file reading is done
public class ExceptionsHomework {

    public static void main(String[] args) throws IOException {
        String truePath = "C:\\Users\\vlado\\Desktop\\Test001.txt";
        String falsePath = "C:\\Users\\vlado\\Desktop\\ADS Global site tag .txt1";

        //for existing file
        try {
            readfile(truePath);
            System.out.println(countfilelines(truePath));
        } catch (RuntimeException e) {
            System.out.println("I catch FileNotFound Exception!");
        }


        //for not existing file
        try {
            readfile(falsePath);
            System.out.println(countfilelines(falsePath));
        } catch (RuntimeException e) {
            System.out.println("I catch FileNotFound Exception!");
        }
    }

    //reading file and print line by line
    public static void readfile(String path) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("YAY! File reading is DONE!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(" Catch IO Exception!");
        }

    }

    //counting lines in file
    public static int countfilelines(String path) {
        int linecount = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.readLine() != null) {
                linecount++;
            }
            System.out.println("YAY! Lines counting is DONE!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println(" Catch IO Exception!");
        }
        return linecount;
    }
}
