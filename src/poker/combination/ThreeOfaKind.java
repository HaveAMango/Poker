package poker.combination;

public class ThreeOfaKind extends NCards {

    @Override
    public String name() {
        return "Set";
    }

    @Override
    public int priority() {
        return 4;
    }

    @Override
    protected int cardCount() {
        return 3;
    }
}


