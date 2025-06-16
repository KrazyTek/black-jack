// package BLACKJACK;

import java.util.*;

public class Blackjack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player = new Hand();
        Hand dealer = new Hand();
        Scanner input = new Scanner(System.in);

        boolean playAgain = true;

        while (playAgain) {

            player.clear();
            dealer.clear();


            if (deck.peek().size() < 13) {  // 13 is around 25% of Deck; might be more appropriate?
                deck.reset();
                System.out.println("Reshuffling...");
            }

            // initial deal
            player.drawCard(deck.dealCard());
            player.drawCard(deck.dealCard());
            dealer.drawCard(deck.dealCard());
            dealer.drawCard(deck.dealCard());

            // display initial hands deals
            System.out.println("Your hand: " + player.getCards());
            System.out.println("Total: " + player.totalValue());
            System.out.println("Dealer shows: " + dealer.getCards().getFirst());

            // Player's turn
            while (true) {
                System.out.print("Hit or stand? ");
                String choice = input.nextLine().trim().toLowerCase();

                if (choice.equals("hit") || choice.equals("h")) {
                    Card drawn = deck.dealCard();
                    player.drawCard(drawn);
                    System.out.println("You drew: " + drawn);
                    System.out.println("Hand: " + player.getCards() + " (Total: " + player.totalValue() + ")");

                    if (player.isBust()) {
                        System.out.println("Bust! Dealer wins.");
                        break;
                    }
                } else if (choice.equals("stand") || choice.equals("s")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please type 'hit' or 'stand'.");
                }
            }

            // dealer turn
            if (!player.isBust()) {
                System.out.println("\nDealer's turn...");
                System.out.println("Dealer hand: " + dealer.getCards() + " (Total: " + dealer.totalValue() + ")");
                while (dealer.totalValue() < 17) {  // dealer must stand if the value is 17 or more
                    Card drawn = deck.dealCard();
                    dealer.drawCard(drawn);
                    System.out.println("Dealer drew: " + drawn);
                    System.out.println("Dealer hand: " + dealer.getCards() + " (Total: " + dealer.totalValue() + ")");
                }

                if (dealer.isBust()) {
                    System.out.println("Dealer busted! You win!");
                } else {
                    int playerTotal = player.totalValue();
                    int dealerTotal = dealer.totalValue();
                    System.out.println("\nFinal Results:");
                    System.out.println("Your total: " + playerTotal);
                    System.out.println("Dealer total: " + dealerTotal);

                    if (playerTotal > dealerTotal) {
                        System.out.println("You win!");
                    } else if (dealerTotal > playerTotal) {
                        System.out.println("Dealer wins.");
                    } else {
                        System.out.println("It's a tie!");
                    }
                }
            }

            System.out.print("\nPlay again? (yes/no): ");
            String again = input.nextLine().toLowerCase();
            if (!again.equals("yes") && !again.equals("y")) {
                playAgain = false;
            }
        }

        input.close();
        System.out.println("Thanks for playing!");
    }
}
