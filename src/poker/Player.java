package poker;

import poker.combination.CombinationResult;

import java.util.ArrayList;
import java.util.List;

public class Player implements Comparable<Player> {

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
        if (this.result != null && this.result.isExists()) return;

        this.result = result;
    }

    public Player(Board board, Hand hand) {
        this.board = board;
        this.hand = hand;
    }

    @Override
    public int compareTo(Player o) {
        return result.compareTo(o.result);
    }

    @Override
    public String toString() {
        //return getHand().toString();
        return info();
    }

    private String info() {
        return "Player(" + hand + " | " + hand + board + ") - " + result;
    }
}