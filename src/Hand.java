import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void drawCard(Card card) {
        hand.add(card);
    }

    public int totalValue() {
        int total = 0;
        int aces = 0;

        for (Card card : hand) {
            total += card.getValue();
            if (card.isAce()) {
                aces++;
            }
        }

        while (total > 21 && aces > 0) {    // Converts Aces from 11 to 1 if bust
            total -= 10;
            aces--;
        }

        return total;
    }

    public boolean isBust() {
        return totalValue() > 21;
    }

    public String toString() {
        return hand.toString();
    }

    public void clear() {
        hand.clear();
    }

    // Debug:
    public ArrayList<Card> getCards() { // Returns the card data
        return hand;
    }
}
