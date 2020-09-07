package poker;

import java.util.List;

public class Board {
    List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public Board(List<Card> cards) throws Exception {
        if (cards.size() != 5) {
            throw new Exception("board`s length is not right");
        } else {
            this.cards = cards;
        }
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}


