package poker.combination;

import poker.Card;

import java.util.List;

public class CombinationResult implements Comparable<CombinationResult> {

    private boolean exists;
    protected Combination combination;
    private List<Card> kickers;

    public CombinationResult(boolean exists, Combination combination, List<Card> kickers) {
        this.exists = exists;
        this.combination = combination;
        this.kickers = kickers;
    }

    public boolean isExists() {
        return exists;
    }

    public int getPriority() {
        return combination.priority();
    }

    @Override
    public int compareTo(CombinationResult o) {
        return getPriority() - o.getPriority();
    }

    protected int compareByKickers(CombinationResult o) {
        for (int i = 0; i < kickers.size(); i++) {
            Card card = kickers.get(i);
            Card other = o.kickers.get(i);

            int delta = card.compareTo(other);
            if (delta != 0) {
                return delta;
            }
        }

        return 0;
    }

    @Override
    public String toString() {
        if (!exists) {
            return "NoCombination";
        }
        return combination.name() + " (" + getPriority() + ")";
    }
}
