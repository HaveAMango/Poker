package poker;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Hand hand;
    private Board board;

    public List<Card> getAllCards() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(hand.getCards());
        cards.addAll(board.getCards());
        return cards;
    }

    public Hand getHand() {
        return hand;
    }

    public Player(Board board, Hand hand) {
        this.board = board;
        this.hand = hand;
    }

    @Override
    public String toString() {
        return getAllCards().toString();
    }
}
