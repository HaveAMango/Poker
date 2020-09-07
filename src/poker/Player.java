package poker;

import poker.combination.CombinationResult;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private Hand hand;
    private Board board;
    private CombinationResult result;

    public List<Card> getAllCards() {
        List<Card> cards = new ArrayList<>();
        cards.addAll(hand.getCards());
        cards.addAll(board.getCards());
        return cards;
    }

    public Hand getHand() {
        return hand;
    }

    public CombinationResult getResult() {
        return result;
    }

    public void setResult(CombinationResult result) {
        if (!result.isExists()) return;

        if (this.result != null) return;

        this.result = result;
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
