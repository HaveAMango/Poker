package poker;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Card> board = new ArrayList<>();

    public List<Card> getBoard() {
        return board;
    }

    public Board(List<Card> board) throws Exception {
        if (board.size() != 5) {
            throw new Exception("board`s length is not right");
        } else {
            this.board = board;
        }
    }

    @Override
    public String toString() {
        return board.toString();
    }
}


