package poker;

public class Card {

    //refactor to getters
    public int value;
    public String suit;

    public Card(String card) throws Exception {
        if (card.length() == 2) {
            String[] parts = card.split("");
            value = Integer.parseInt(parts[0]);
            suit = parts[1];
        } else {
            throw new Exception("card length is not right");
        }

        if (value > 13 || value < 1) {
            throw new Exception("card value is not right");
        }

        if (!suit.equals("c") && !suit.equals("d") && !suit.equals("h") && !suit.equals("s")) {
            throw new Exception("card suit is not right");
        }
    }

    @Override
    public String toString() {
        return value + suit;
    }
}


