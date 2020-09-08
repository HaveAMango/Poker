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
        int delta = result.compareTo(o.result);
        if (delta != 0) {
            return delta;
        }

        return getHand().toString().compareTo(o.getHand().toString());
    }

    public boolean handEquals(Player o) {
        return result.compareTo(o.result) == 0;
    }

    @Override
    public String toString() {
        if (Game.DEBUG) {
            return info();
        } else {
            return getHand().toString();
        }
    }

    private String info() {
        return "Player(" + hand + " | " + hand + board + ") - " + result;
    }
}