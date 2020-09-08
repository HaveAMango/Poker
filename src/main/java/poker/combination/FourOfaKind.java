package poker.combination;

public class FourOfaKind extends NCards {

    @Override
    public String name() {
        return "Quads";
    }

    @Override
    public int priority() {
        return 8;
    }

    @Override
    protected int cardCount() {
        return 4;
    }
}


