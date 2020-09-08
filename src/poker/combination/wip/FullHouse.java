package poker.combination.wip;

import poker.Card;
import poker.Player;
import poker.Value;
import poker.combination.Combination;
import poker.combination.CombinationResult;
import poker.combination.TwoGroupsCombinationResult;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class FullHouse implements Combination {

    @Override
    public int priority() {
        return 7;
    }

    @Override
    public CombinationResult answer(Player player) {
        Map<Value, List<Card>> byValue = player.getAllCards()
                .stream()
                .collect(Collectors.groupingBy(card -> card.value));

        Optional<Value> pairValue = highestNValue(byValue.values(), 2);
        Optional<Value> threesValue = highestNValue(byValue.values(), 3);
        return new TwoGroupsCombinationResult(this, threesValue.orElse(Value.NONE), pairValue.orElse(Value.NONE));
    }

    private Optional<Value> highestNValue(Collection<List<Card>> cardGroups, int n) {
        return cardGroups.stream()
                .filter(list -> list.size() == n)
                .sorted((cards1, cards2) -> cards2.get(0).compareTo(cards1.get(0)))
                .findFirst()
                .map(cards -> cards.get(0).getValue());
    }

    @Override
    public String name() {
        return "Full House";
    }
}