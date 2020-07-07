import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static final String WORD = "INTERFACE";
    public static final int TRIES = 10;

    public static void inputOutput() {

        String wordToGuess;
        List<Character> letters = new ArrayList<>();

        int countErrors = 0;
        Scanner input = new Scanner(System.in);
        while (countErrors <= TRIES) {

            System.out.println("Enter letter");
            char guess = input.nextLine().toUpperCase().charAt(0);

            if (hasLetter(guess, WORD)) {
                letters.add(guess); // add guess
            } else {
                countErrors++;
            }

//            for (int i = 0; i < wordToGuess.length(); i++) {
//                if (wordToGuess.charAt(i) == guess.charAt(0)) {
//                    System.out.println(letters);
//                } else
//                    System.out.println("The word doesn't contains this letter, try again");
//                countErrors++;
//            }

            printCurrentState(WORD, letters);

            //char currentGuess = string.charAt(0);

            //play();

        }
        input.close();
    }


    public static void printCurrentState(String word, List<Character> letters) {
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

        System.out.print("Word:  ");
        System.out.println(inputWord);
    }

    public static boolean hasLetter(char letter, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (letter == word.charAt(i)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        inputOutput();
    }
}
