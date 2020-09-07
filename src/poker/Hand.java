package poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {

    List<Card> hand = new ArrayList<>();

    public List<Card> getHand() {
        return hand;
    }

    public Hand(List<Card> hand)throws Exception {
        if (hand.size() !=2) {
            throw new Exception("hand`s length is not right");
        }else{
            this.hand = hand;
        }

    }

    @Override
    public String toString() {
        return hand.toString();
    }
}
