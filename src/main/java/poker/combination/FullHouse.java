package poker.combination;

public class FullHouse extends TwoGroups {

    @Override
    public int priority() {
        return 7;
    }

    @Override
    protected int group1size() {
        return 3;
    }

    @Override
    protected int group2size() {
        return 2;
    }

    @Override
    public String name() {
        return "Full House";
    }
}