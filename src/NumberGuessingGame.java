import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    private final int lowerBound = 1;
    private final int upperBound = 100;
    private int secretNumber;
    private int numberOfGuesses;

    public NumberGuessingGame() {
        // Skapa ett slumpmässigt tal mellan lowerBound och upperBound (inklusive).
        Random random = new Random();
        secretNumber = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Gissa ett tal mellan " + lowerBound + " och " + upperBound + ".");
            numberOfGuesses = 0;

            while (true) {
                int guess = getUserGuess(scanner);

                if (guess == secretNumber) {
                    System.out.println("Rätt! Du gissade rätt på " + (numberOfGuesses + 1) + " försök.");
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Talet är större.");
                } else {
                    System.out.println("Talet är mindre.");
                }
            }

            playAgain = askToPlayAgain(scanner);
        }

        System.out.println("Tack för den här gången!");
    }

    private int getUserGuess(Scanner scanner) {
        int guess = 0;
        while (true) {
            System.out.print("Gissning " + (numberOfGuesses + 1) + ": ");
            if (scanner.hasNextInt()) {
                guess = scanner.nextInt();
                scanner.nextLine(); // Läs bort resten av raden
                if (guess >= lowerBound && guess <= upperBound) {
                    numberOfGuesses++;
                    return guess;
                } else {
                    System.out.println("Ditt tal måste vara mellan " + lowerBound + " och " + upperBound + ".");
                }
            } else {
                System.out.println("Du kan bara skriva ett tal med siffror. Försök igen!");
                scanner.nextLine(); // Läs bort felaktig inmatning
            }
        }
    }

    private boolean askToPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Vill du spela igen (Ja/Nej)? ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("ja")) {
                return true;
            } else if (response.equals("nej")) {
                return false;
            } else {
                System.out.println("Ogiltigt svar. Svara med 'Ja' eller 'Nej'.");
            }
        }
    }
}

