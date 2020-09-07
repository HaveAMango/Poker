package poker.combination;

public class CombinationResult {

    private boolean exists;
    private Combination combination;

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
    public String toString() {
        return combination.getClass().getSimpleName() + " (" + getPriority() + ")";
    }
}
