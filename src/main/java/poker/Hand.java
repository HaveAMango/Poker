package poker;

import java.util.List;
import java.util.stream.Collectors;

public class Hand {

    List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public Hand(List<Card> cards) throws Exception {
        if (cards.size() != 2) {
            throw new Exception("hand`s length is not right");
        } else {
            this.cards = cards;
        }
    }

    @Override
    public String toString() {
        return cards.stream().map(c -> c.toString()).collect(Collectors.joining(""));
    }
}
