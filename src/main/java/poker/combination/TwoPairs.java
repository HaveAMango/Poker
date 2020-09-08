package poker.combination;

public class TwoPairs extends TwoGroups {

    @Override
    public int priority() {
        return 3;
    }

    @Override
    protected int group1size() {
        return 2;
    }

    @Override
    protected int group2size() {
        return 2;
    }

    @Override
    public String name() {
        return "Two Pairs";
    }
}