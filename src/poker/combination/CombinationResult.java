package poker.combination;

public class CombinationResult implements Comparable<CombinationResult> {

    private boolean exists;
    protected Combination combination;

    public CombinationResult(boolean exists, Combination combination) {
        this.exists = exists;
        this.combination = combination;
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

    @Override
    public String toString() {
        if (!exists) {
            return "NoCombination";
        }
        return combination.name() + " (" + getPriority() + ")";
    }
}
