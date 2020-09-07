package poker;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private List<Card> handaboard = new ArrayList<>();

    public List<Card> getHandaboard() {
        return handaboard;
    }

    public Player(Board board, Hand hand) {
        handaboard.addAll(board.getBoard());
        handaboard.addAll(hand.getHand());
    }

    @Override
    public String toString() {
        return handaboard.toString();
    }
}
