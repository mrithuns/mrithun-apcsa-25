package piglatin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Current do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

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

    private static boolean isvow(char a) {
        String vows = "aeiou";
        return vows.indexOf(Character.toLowerCase(a)) >= 0;
    }

    private static String translateWord(String input) {
    System.out.println("  -> translateWord('" + input + "')");

    if (input == null || input.isEmpty()) {
        return input;
    }

    // Track which letters are uppercase
    boolean[] upper = new boolean[input.length()];
    for (int i = 0; i < input.length(); i++) {
        upper[i] = Character.isUpperCase(input.charAt(i));
    }

    String lower = input.toLowerCase();
    int split = firstVowelIndexForPigLatin(lower);

    String base;
    boolean[] newUpper;

    if (split == 0) {
        base = lower + "ay";
        newUpper = upper; // no movement
    } else if (split > 0) {
        base = lower.substring(split) + lower.substring(0, split) + "ay";
        // rotate uppercase map the same way letters move
        newUpper = new boolean[upper.length];
        for (int i = 0; i < upper.length; i++) {
            int newPos = (i - split + upper.length) % upper.length;
            newUpper[newPos] = upper[i];
        }
    } else {
        base = lower + "ay";
        newUpper = upper;
    }

    StringBuilder result = new StringBuilder(base);

    // Apply uppercase pattern to first part only (ignore "ay")
    for (int i = 0; i < input.length() && i < result.length(); i++) {
        if (newUpper[i]) {
            result.setCharAt(i, Character.toUpperCase(result.charAt(i)));
        }
    }

    return result.toString();
}


    // Helper: find first vowel index, 'y' counts as vowel only if not at index 0
    private static int firstVowelIndexForPigLatin(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetter(c)) continue;

            char lc = Character.toLowerCase(c);
            if (isvow(lc)) return i;
            if (lc == 'y' && i != 0) return i;
        }
        return -1;
    }
}
