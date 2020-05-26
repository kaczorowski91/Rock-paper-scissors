package pl.kaczorowski;

import java.util.Scanner;

public class GameLoop {
    private boolean end = false;
    private boolean newgame = false;
    Scanner sc = new Scanner(System.in);
    int i = 1;
    private int playerScore = 0;
    private int computerScore = 0;
    MoveGenerator moveGenerator = new MoveGenerator();
    private int rounds;

    private void getData() {
        System.out.println("Hello, Please give your name: ");
        String name = sc.nextLine();
        System.out.println("Welcome " + name + " How many rounds do you want play to win?");
        rounds = sc.nextInt();
        sc.nextLine();
    }

    private void gameBegin() {
        System.out.println("Rules of Game: ");
        System.out.println("1 - Rock, 2 - Paper, 3 -Scissors");
        System.out.println("Rock bests Scissors, Scissors beats Paper, Paper beats Rock");
        System.out.println("X - End of Game, N - New Game");
        System.out.println("We play to " + rounds + " wins rounds");
    }

    private void showScore() {
        System.out.println("End of Round " + i + " Player Score: " + playerScore + " Computer Score: " + computerScore);
    }

    public void gameRun() {

        while (!newgame) {

            this.getData();
            this.gameBegin();

            while (!end) {
                System.out.println("Round " + i + " Choose gesture: 1 - Rock, 2 - Paper, 3 -Scissors");
                String choice = sc.nextLine();

                int computerPick = moveGenerator.moveGenerator();

                if (choice.equals("1")) {
                    System.out.println("Your choice is a Rock");

                    if (computerPick == 1) {
                        System.out.println("Computer picked Rock. It's draw.");
                        this.showScore();

                    } else if (computerPick == 2) {
                        computerScore++;
                        System.out.println("Computer picked Paper. You lose.");
                        this.showScore();

                    } else if (computerPick == 3) {
                        playerScore++;
                        System.out.println("Computer picked Scissors. You win.");
                        this.showScore();
                    }

                } else if (choice.equals("2")) {
                    System.out.println("Your choice is Paper");

                    if (computerPick == 1) {
                        playerScore++;
                        System.out.println("Computer picked Rock. You win");
                        this.showScore();

                    } else if (computerPick == 2) {
                        System.out.println("Computer picked Paper. It's draw.");
                        this.showScore();

                    } else if (computerPick == 3) {
                        System.out.println("Computer picked Scissors. You lose.");
                        computerScore++;
                        this.showScore();
                    }

                } else if (choice.equals("3")) {
                    System.out.println("Your choice is Scissors");

                    if (computerPick == 1) {
                        computerScore++;
                        System.out.println("Computer picked Rock. You lose");
                        this.showScore();

                    } else if (computerPick == 2) {
                        playerScore++;
                        System.out.println("Computer picked Paper. You win.");
                        this.showScore();
                    } else if (computerPick == 3) {
                        System.out.println("Computer picked Scissors. It's draw.");
                        this.showScore();
                    }
                } else if (choice.equals("N") || (choice.equals("n"))) {
                    System.out.println("New Game");
                    end = true;
                } else if (choice.equals("X") || (choice.equals("x"))) {
                    System.out.println("End Game");
                    end = true;
                    newgame = true;
                }
                i++;

                if (playerScore == rounds) {
                    System.out.println("You win a GAME! CONGRATULATION! ");
                    end = true;
                    newgame = true;
                }
                if (computerScore == rounds) {
                    System.out.println("You lose :( ");
                    end = true;
                    newgame = true;
                }
            }
        }
    }
}
