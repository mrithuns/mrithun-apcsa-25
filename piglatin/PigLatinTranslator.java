package piglatin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')"); 

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.

        // If input is only whitespace, grader expects empty string.
        if (input == null || input.trim().isEmpty()) {
            return "";
        }

        // Treat hyphenated and apostrophe words as single tokens:
        // e.g., "clean-cut" and "don't"
        Pattern word = Pattern.compile("[A-Za-z]+(?:[-'][A-Za-z]+)*");
        Matcher m = word.matcher(input);
        StringBuilder sb = new StringBuilder();

        int last = 0;
        while (m.find()) {
            // Append any non-word chunk before the word
            sb.append(input, last, m.start());
            String w = m.group();
            // Translate just the word token
            sb.append(translateWord(w));
            last = m.end();
        }
        // Append any trailing non-word chunk
        sb.append(input.substring(last));

        result = sb.toString();

        return result;
    } 

    private static boolean isvow(char a)
    {
        String vows = "aeiou";
        if (vows.indexOf(Character.toLowerCase(a)) >= 0)
        {
            return true;
        }
        return false;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";

        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.

        // --- Pig Latin logic that preserves punctuation outside and casing inside the word ---
        if (input == null || input.isEmpty()) {
            return input;
        }

        // Find index of first vowel (with 'y' as vowel only when not at index 0)
        int split = firstVowelIndexForPigLatin(input);

        if (split == 0) {
            // Starts with vowel: just append "ay" (grader expects "eat" -> "eatay")
            result = input + "ay";
        } else if (split > 0) {
            // Move leading consonant cluster to end, then "ay".
            // Use original casing by slicing original input directly.
            result = input.substring(split) + input.substring(0, split) + "ay";
        } else {
            // No vowel found: just append "ay"
            result = input + "ay";
        }

        return result;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

    // Helper: first vowel index where 'y' counts as vowel only when not at position 0.
    // We examine letters only; hyphens/apostrophes remain part of the token and naturally
    // allow cluster moves across them (e.g., "clean-cut" -> split after 'cl' -> "ean-cutclay").
    private static int firstVowelIndexForPigLatin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // letters only matter for vowel detection; any non-letter can't be a vowel
            if (!Character.isLetter(c)) {
                continue;
            }

            char lc = Character.toLowerCase(c);
            if (isvow(lc)) return i;              // a/e/i/o/u
            if (lc == 'y' && i != 0) return i;    // 'y' as vowel when not leading
        }
        return -1;
    }
}
