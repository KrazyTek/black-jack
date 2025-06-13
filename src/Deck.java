import java.util.ArrayList;

import static java.util.Collections.shuffle;

public class Deck {
    private final String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private final String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};
    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>(52);
        create();
        shuffle(deck);
    }

    public void create() {
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                int value = i + 1;
                if (value > 10) value = 10;   // Face cards are worth 10
                if (value == 1) value = 11;   // Ace cards are worth 11
                // we can add a system later on that subtracts 10 from the hand value if there is an Ace
                deck.add(new Card(value, ranks[i], suit));
            }
        }
    }

    public void shuffleCards() {
        shuffle(deck);
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            return null;
        } else {
            return deck.removeFirst();
        }
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    public void reset() {
        deck.clear();
        create();
        shuffleCards();
    }

    public ArrayList<Card> peek() {
        return deck;
    }
}
