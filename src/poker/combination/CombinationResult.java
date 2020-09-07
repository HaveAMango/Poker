package poker.combination;

public class CombinationResult {

    private boolean exists;

    public CombinationResult(boolean exists) {
        this.exists = exists;
    }

    public boolean isExists() {
        return exists;
    }

    @Override
    public String toString() {
        return String.valueOf(exists);
    }
}
