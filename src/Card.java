public class Card {
    private final int value;
    private final String rank;
    private final String suit;

    public Card(int value, String rank, String suit) {
        this.value = value;
        this.suit = suit;
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean isAce() {
        return value == 11 || value == 1;
    }

    public String getImageFilename() {
        return rank.toLowerCase() + "_of_" + suit.toLowerCase() + ".png";
    }
}
