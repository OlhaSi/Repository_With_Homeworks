import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputOutput extends GameCondition {

    // method for communication with user

    public void playGame() {

        // we need List to keep letters in array saved
        List<Character> letters = new ArrayList<>();
        int countErrors = 0;

        Scanner input = new Scanner(System.in);

        while (countErrors <= TRIES) {
            System.out.println("Enter letter");
            char guess = input.nextLine().toUpperCase().charAt(0);

            if (CheckState.hasLetter(guess, WORD)) {
                if (letters.contains(guess)) {
                    System.out.println("You have already used this letter");
                    countErrors++;
                }
                letters.add(guess);
            } else {
                System.out.println("The word doesn't contains this letter, try again");
                countErrors++;
            }

            String wordToGuess = getCurrentState(WORD, letters);
            System.out.println("Word: " + wordToGuess);

            if (CheckState.checkWord(wordToGuess)) {
                System.out.println("Congrats! You win!");
                return;
            } else if (countErrors == TRIES) {
                System.out.println("Tries limit: " + TRIES + ". You lost!");
                return;
            }
        }
        input.close();
    }
}
