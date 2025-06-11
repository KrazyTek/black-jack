import java.util.ArrayList;

public class Deck {
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private String[] suits = {"Spades", "Hearts", "Clubs", "Diamonds"};

    public void createDeck() {
        ArrayList<Object> deck = new ArrayList<>();
        deck.ensureCapacity(52);

        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                int value = i+1;
                if (value > 10) value = 10;   // Face cards are worth 10
                if (value == 1) value = 11;   // Ace cards are worth 11
                // we can add a system later on that subtracts 10 from the hand value if there is an Ace
                deck.add(new Card(value, ranks[i], suit));
            }
        }
        System.out.println(deck);
    }
}
