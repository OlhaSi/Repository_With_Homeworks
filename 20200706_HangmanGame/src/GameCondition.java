import java.util.*;

public class GameCondition {

    public static final String WORD = "INTERFACE";
    public static final int TRIES = 3;

    public GameCondition() {
    }


    // method will return current word situation every time user enter a letter

    public String getCurrentState(String word, List<Character> letters) {
        char[] inputWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            inputWord[i] = '*';
        }

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < letters.size(); j++) {
                if (word.charAt(i) == letters.get(j)) {
                    inputWord[i] = letters.get(j);
                }
            }
        }
        return String.valueOf(inputWord);
    }
}
