public class Card {
    private int value;
    private String rank;
    private String suit;

    public Card(int value, String rank, String suit) {
        this.value = value;
        this.suit = suit;
        this.rank = rank;
    }

    public int getvalue() {
        return value;
    }

    public String toString() {
        return rank + " of " + suit;
    }


}

/*
package OOPReview;

public class Polygon extends Object {
    private int sides;

    public int getSides() {
        return sides;
    }

    public Polygon(int sides) {
        this.sides = sides;
    }

    @Override
    public String toString() {
        return "OOPReview.Polygon [sides=" + sides + "]";
    }

}


 */