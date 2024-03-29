package poker.combination;

import poker.Card;
import poker.Player;
import poker.Value;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class NCards implements Combination {

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getAllCards();

        Map<Value, List<Card>> byValue = cards
                .stream()
                .collect(Collectors.groupingBy(card -> card.value));

        Value value = byValue.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() >= cardCount())
                .sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey()))
                .findFirst()
                .map(e -> e.getKey())
                .orElse(Value.NONE);

        List<Card> kickers = player.getHand().getCards().stream()
                .filter(c -> !c.getValue().equals(value))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return new NCardsCombinationResult(this, value, kickers);
    }

    protected abstract int cardCount();
}
