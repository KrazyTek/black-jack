public class Card {
    private int value;
    private String rank;
    private String suit;

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

    public int getvalue() {
        return value;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public boolean isAce() {
        return value == 11 || value == 1;
    }


}