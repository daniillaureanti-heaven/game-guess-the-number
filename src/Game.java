import java.util.Scanner;

public class Game {

    SavedGame savedGame = new SavedGame();

    private final int NEW_GAME = 1;
    private final int CONTINUE_GAME = 2;
    private final int EXIT = 3;

    private int randomNum;
    private int userNum;
    private static int ctnAttempts;
    private Scanner scInt = new Scanner(System.in);

    public void go() {
        initializationCtnAttempts();
        greeting();
        generateRandomNum();
        gameMode();
    }

    public void initializationCtnAttempts() {
        ctnAttempts = 10;
    }

    public static int getCtnAttempts() {
        return ctnAttempts;
    }

    public void savedGame() {
        savedGame.savedGame();
    }

    public int loadGame() {
        return savedGame.loadSavedGame();
    }

    public void greeting() {
        System.out.println("Guess the number game ver. 1.2".toUpperCase() + "\n");
        System.out.println("The game is saved automatically".toUpperCase() + "\n");
    }

    public void generateRandomNum() {
        randomNum = (int) (Math.random() * (5 - 1) + 1);
    }

    public void condition() {
        System.out.println("Guess the number from 1 to 5\n");
        System.out.println("The clue was a guessing number: " + randomNum);
    }

    public void gameMode() {
        System.out.println("1. New game");
        System.out.println("2. Continue game");
        System.out.println("3. Exit game");

        int choiceGameMode = scInt.nextInt();

        switch (choiceGameMode) {
            case NEW_GAME: {
                condition();
                newGame();
                break;
            }
            case CONTINUE_GAME: {
                condition();
                continueGame();
                break;
            }
            case EXIT: {
                System.out.println("Exit game!");
                System.exit(0);
            }
            default: {
                System.out.println("No game mode selected, re-enter the command:");
                gameMode();
            }
        }
    }

    public void newGame() {
        System.out.println("Enter your choice:");
        userNum = scInt.nextInt();
        ctnAttempts--;
        savedGame();

        if (ctnAttempts > 0) {
            System.out.println("Attempts left: " + ctnAttempts);

            if (userNum < randomNum) {
                System.out.println("The guessed number is greater, re-enter the input:");
                newGame();
            } else if (userNum > randomNum) {
                System.out.println("The guessed number is less, re-enter the input:");
                newGame();
            }

            System.out.println("The number is guessed!");
            gameMode();
        } else {
            System.out.println("Attempts ended!");
            ctnAttempts = 0;
        }
        gameMode();
    }

    public void continueGame() {
        ctnAttempts = loadGame();
        System.out.println("Remaining number of attempts: " + ctnAttempts);
        System.out.println("Enter your choice:");
        userNum = scInt.nextInt();
        ctnAttempts--;
        savedGame();

        if (ctnAttempts > 0) {
            System.out.println("Attempts left: " + ctnAttempts);

            if (userNum < randomNum) {
                System.out.println("The guessed number is greater, re-enter the input:");
                newGame();
            } else if (userNum > randomNum) {
                System.out.println("The guessed number is less, re-enter the input:");
                newGame();
            }

            System.out.println("The number is guessed!");
            gameMode();
        } else {
            System.out.println("Attempts ended!");
            ctnAttempts = 0;
        }
        gameMode();
    }
}