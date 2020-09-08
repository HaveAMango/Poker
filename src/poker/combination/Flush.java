package poker.combination;

import poker.Card;
import poker.Player;
import poker.Value;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Flush implements Combination {

    @Override
    public CombinationResult answer(Player player) {

        Map<String, List<Card>> bySuit = player.getAllCards()
                .stream()
                .collect(Collectors.groupingBy(card -> card.suit));

        Optional<List<Card>> flushCards = bySuit.values()
                .stream()
                .filter(cards -> cards.size() >= 5)
                .findAny();

        if (flushCards.isEmpty()) {
            return new NCardsCombinationResult(this, Value.NONE);
        }

        Optional<Value> value = flushCards.get().stream()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .map(card -> card.getValue());

        return new NCardsCombinationResult(this, value.orElse(Value.NONE));
    }

    @Override
    public int priority() {
        return 6;
    }

    @Override
    public String name() {
        return "Flush";
    }
}
