package poker.combination;

public class HighCard extends NCards {

    @Override
    protected int cardCount() {
        return 1;
    }

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public String name() {
        return "High Card";
    }
}
