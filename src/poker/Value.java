package poker;

import java.util.Arrays;

public enum Value {
    ONE("1", 1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5",5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("T", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);

    private String symbol;
    private int value;

    Value(String symbol, int value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    public static Value parse(String symbol) throws Exception {
        return Arrays.stream(Value.values())
                .filter(v -> v.symbol.equals(symbol))
                .findAny()
                .orElseThrow();
    }
}
