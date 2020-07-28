import java.util.List;

public class CheckState extends GameCondition {

    // check if word user trying to guess equals to word in GameCondition
    public static boolean checkWord(String wordToGuess) {
        boolean flag = true;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (!(flag && wordToGuess.charAt(i) == WORD.charAt(i))) {
                flag = false;
            }
        }
        return flag;
    }

    // check if user has already used the letter
    public static boolean hasLetter(char letter, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (letter == word.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
