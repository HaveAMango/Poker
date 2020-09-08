package poker.combination;

public class TwoOfaKind extends NCards {

    @Override
    public String name() {
        return "Pair";
    }

    @Override
    public int priority() {
        return 2;
    }

    @Override
    protected int cardCount() {
        return 2;
    }
}