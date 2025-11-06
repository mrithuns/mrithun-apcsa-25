package piglatin;

import java.util.Scanner;

public class PigLatinTranslator {

    // Translate an entire Book object (each page line by line)
   public static Book translate(Book input) {
    Book translatedBook = new Book();
    translatedBook.setTitle(input.getTitle());

    for (int i = 0; i < input.getLineCount(); i++) {
        String lineText = input.getLine(i);
        if (lineText == null || lineText.trim().isEmpty()) {
            translatedBook.appendLine("");  // keep blank lines
            continue;
        }

        String translatedLine = translate(lineText);
        translatedBook.appendLine(translatedLine);
    }

    return translatedBook;
}




    // Translate a line of text that might contain multiple words and punctuation
    public static String translate(String input) {
        //System.out.println("  -> translate('" + input + "')"); used for tenting

        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        Scanner scan = new Scanner(input);
        String result = "";
        int lastEnd = 0;

        // We’ll rebuild the string manually so spacing and punctuation stay intact
        while (scan.hasNext()) {
            String word = scan.next();
            int index = input.indexOf(word, lastEnd);

            // Copy everything between words exactly as it was
            if (index > lastEnd) {
                result += input.substring(lastEnd, index);
            }

            result += translateWord(word);
            lastEnd = index + word.length();
        }

        // Add any leftover spaces or punctuation after last word
        if (lastEnd < input.length()) {
            result += input.substring(lastEnd);
        }

        scan.close();
        return result;
    }

    // Translate one word of English into Pig Latin
    private static String translateWord(String word) {
       // System.out.println("  -> translateWord('" + word + "')");   used for testig

        if (word == null || word.length() == 0) {
            return word;
        }

        // Keep punctuation at the end (like "Trash!")
        String punctuation = "";
        char last = word.charAt(word.length() - 1);
        if (!Character.isLetter(last)) {
            punctuation = "" + last;
            word = word.substring(0, word.length() - 1);
        }

        // Remember if the first letter was uppercase
        boolean startsUpper = Character.isUpperCase(word.charAt(0));

        // Make everything lowercase for easier work
        String lower = word.toLowerCase();

        int split = firstVowelIndex(lower);
        String result;

        if (split == 0) {
            result = lower + "ay";                 // starts with vowel
        } else if (split > 0) {
            result = lower.substring(split) + lower.substring(0, split) + "ay"; // consonant start
        } else {
            result = lower + "ay";                 // no vowels
        }

        // Fix capitalization: first letter uppercase if original started uppercase
        if (startsUpper) {
            result = Character.toUpperCase(result.charAt(0)) + result.substring(1);
        }

        return result + punctuation;
    }

    // Find index of first vowel ('y' counts as vowel if not at start)
    private static int firstVowelIndex(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));
            if ("aeiou".indexOf(c) >= 0) {
                return i;
            }
            if (c == 'y' && i != 0) {
                return i;
            }
        }
        return -1;
    }
}
