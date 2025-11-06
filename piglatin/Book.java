package piglatin;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    Book() {
        // Empty book - nothing to initialize here.
    }

    // Helper method to print a few lines (for debugging)
    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

  
    // Getters and setters
  
    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    int getLineCount() {
        return text.size();
    }

    void appendLine(String line) {
        text.add(line);
    }

    
    // Reads book contents from a string (each line separated by \n)
    
    public void readFromString(String title, String string) {
        this.title = title;

        Scanner scan = new Scanner(string);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            text.add(line);
        }
        scan.close();
    }

   
    // Reads a book from an online URL
  
    public void readFromUrl(String title, String url) {
        this.title = title;

        try {
            URL bookUrl = URI.create(url).toURL();
            Scanner scan = new Scanner(bookUrl.openStream());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                text.add(line);
            }
            scan.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

   
    // Writes this book’s text to a local file
   
    void writeToFile(String name) {
        try {
            FileWriter out = new FileWriter(name);
            for (int i = 0; i < text.size(); i++) {
                out.write(text.get(i) + "\n");
            }
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
