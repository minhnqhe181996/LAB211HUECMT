import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * A class to count the number of letters and characters in a string.
 */
public class CharacterCounter {

    /**
     * The main method to run the program.
     */
    public static void main(String args[]) {
        String input = Validator.getString("Enter your content:", "Must be can not empty!", "^(?!\\s*$).+");
        ContentProcessor processor = new ContentProcessor(input);
        System.out.println(processor.letterCount());
        System.out.println(processor.charCount());
    }
}

class ContentProcessor {

    private final String input;

    public ContentProcessor(String input) {
        this.input = input;
    }

    public Map letterCount() {
        Map<String, Integer> letterCounter = new LinkedHashMap<>();
        // break the input string into token
        StringTokenizer stringToken = new StringTokenizer(input);
        // loop if there is still more token
        while (stringToken.hasMoreTokens()) {
            String token = stringToken.nextToken();
            // if map didn't have token, create new
            if (!letterCounter.containsKey(token)) {
                letterCounter.put(token, 1);
            } else {
                // else the token existed, add 1 more to token counter
                letterCounter.put(token, ((int) letterCounter.get(token) + 1));
            }
        }
        return letterCounter;
    }

    public Map charCount() {
        Map<Character, Integer> charCounter = new LinkedHashMap<>();
        // convert string to new character array
        for (char ch : input.toCharArray()) {
            // if the character is space then skip it
            if (Character.isSpaceChar(ch))
                continue;
            // if map didn't have that character, create new
            if (!charCounter.containsKey(ch)) {
                charCounter.put(ch, 1);
            } else {
                // if the character existed, add 1 more to that character counter
                charCounter.put(ch, ((int) charCounter.get(ch) + 1));
            }
        }
        return charCounter;
    }
}

class Validator {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getString(String messageInfo, String messageError, final String REGEX) {
        do {
            System.out.print(messageInfo);
            String str = SCANNER.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
}