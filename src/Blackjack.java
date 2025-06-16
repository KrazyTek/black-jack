import java.util.*;

public class Blackjack {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand player = new Hand();
        Hand dealer = new Hand();
        Scanner input = new Scanner(System.in);

        // initial deal
        player.drawCard(deck.dealCard());
        player.drawCard(deck.dealCard());
        dealer.drawCard(deck.dealCard());
        dealer.drawCard(deck.dealCard());

        // display initial hands deals
        System.out.println("Your hand: " + player.getCards());
        System.out.println("Total: " + player.totalValue());
        System.out.println("Dealer shows: " + dealer.getCards().get(0));

        // Player's turn
        while (true) {
            System.out.print("Hit or stand? ");
            String choice = input.nextLine().trim().toLowerCase();

            if (choice.equals("hit")) {
                Card drawn = deck.dealCard();
                player.drawCard(drawn);
                System.out.println("You drew: " + drawn);
                System.out.println("Hand: " + player.getCards() + " (total " + player.totalValue() + ")");

                if (player.isBust()) {
                    System.out.println("Bust! Dealer wins.");
                    input.close();
                    return;
                }
            } else if (choice.equals("stand")) {
                break;
            } else {
                System.out.println("Invalid input. Please type 'hit' or 'stand'.");
            }
        }

        // dealer turn
        System.out.println("\nDealer's turn...");
        System.out.println("Dealer hand: " + dealer.getCards() + " (total " + dealer.totalValue() + ")");
        while (dealer.totalValue() < 17) {
            Card drawn = deck.dealCard();
            dealer.drawCard(drawn);
            System.out.println("Dealer drew: " + drawn);
            System.out.println("Dealer hand: " + dealer.getCards() + " (total " + dealer.totalValue() + ")");
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

        input.close();
    }
}
