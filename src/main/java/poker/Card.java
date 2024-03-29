package poker;

public class Card implements Comparable<Card> {

    //refactor to getters
    public Value value;
    public String suit;

    public Card(String card) throws Exception {
        if (card.length() == 2) {
            String[] parts = card.split("");
            value = Value.parse(parts[0]);
            suit = parts[1];
        } else {
            throw new Exception("card length is not right");
        }

        if (!suit.equals("c") && !suit.equals("d") && !suit.equals("h") && !suit.equals("s")) {
            throw new Exception("card suit is not right");
        }
    }

    public String getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.getSymbol() + suit;
    }

    @Override
    public int compareTo(Card o) {
        return value.compareTo(o.value);
    }
}


