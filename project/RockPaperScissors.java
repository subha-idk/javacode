package project;

import java.util.Scanner;

// Thread for displaying the game menu
class MenuThread extends Thread {
    private int gameNumber;

    public MenuThread(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    @Override
    public void run() {
        System.out.println("\n-- Game " + gameNumber + " --");
        System.out.println("Paper    : enter 0");
        System.out.println("Rock     : enter 1");
        System.out.println("Scissors : enter 2");
        System.out.println("Exit     : enter 9");
        System.out.print("👉 Enter your choice: ");
    }
}

public class RockPaperScissors {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("🎮 Welcome to Rock Paper Scissors 🎮");
        Scanner sc = new Scanner(System.in);
        int gameCounter = 0;
        int wonCounter = 0;
        int tieCounter = 0;

        while (true) {
            // Show menu using a separate thread
            new MenuThread(++gameCounter).start();

            int userChoice = sc.nextInt();
            if (userChoice == 9) {
                System.out.println("    -----");
                System.out.println("Total Games: " + gameCounter);
                System.out.println("Total Won: " + wonCounter);
                System.out.println("Total Tie: " + tieCounter);
                System.out.println("Total Lost: " + (gameCounter-wonCounter-tieCounter));
                System.out.println("👋 Thanks for playing! Goodbye!");
                break;
            }

            // validate input
            if (userChoice < 0 || userChoice > 2) {
                System.out.println("❌ Invalid choice. Please try again.");
                continue;
            }

            // 🎭 Add suspense effect
            System.out.print("\nComputer is thinking");
            for (int i = 0; i < 3; i++) {
                Thread.sleep(600);  // 600 ms pause
                System.out.print(".");
            }
            System.out.println();

            // computer randomly picks 0–2
            int computerChoice = (int) (Math.random() * 3);
            String[] options = {"Paper", "Rock", "Scissors"};
//

            Thread.sleep(500); // slight pause before reveal
            System.out.println("🖥️ Computer chose : " + options[computerChoice]);
            Thread.sleep(500);
            System.out.println("🙋 You chose      : " + options[userChoice]);

            Thread.sleep(700); // suspense before result
            if (userChoice == computerChoice) {
                tieCounter++;
                System.out.println("🤝 It's a Tie!");
            } else if (isUserWon(userChoice, computerChoice)) {
                wonCounter++;
                System.out.println("🎉 Congratulations! You Won!");
            } else {
                System.out.println("😢 Sorry! You Lost.");
            }

            Thread.sleep(800); // pause before next round
        }

        sc.close();
    }

    public static boolean isUserWon(int userChoice, int computerChoice) {
        // Paper(0) beats Rock(1), Rock(1) beats Scissors(2), Scissors(2) beats Paper(0)
        return (userChoice + 1)% 3 == computerChoice;
    }
}
