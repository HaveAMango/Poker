package poker.combination;

import poker.Card;
import poker.Player;
import poker.Value;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class TwoGroups implements Combination {

    @Override
    public CombinationResult answer(Player player) {
        Map<Value, List<Card>> byValue = player.getAllCards()
                .stream()
                .collect(Collectors.groupingBy(card -> card.value));

        Optional<Value> group1value = highestNValue(byValue.values(), group1size());
        byValue.values().removeIf(cards -> cards.get(0).getValue().equals(group1value.orElse(Value.NONE)));
        Optional<Value> group2value = highestNValue(byValue.values(), group2size());
        return new TwoGroupsCombinationResult(this, group1value.orElse(Value.NONE), group2value.orElse(Value.NONE));
    }

    private Optional<Value> highestNValue(Collection<List<Card>> cardGroups, int n) {
        return cardGroups.stream()
                .filter(list -> list.size() == n)
                .sorted((cards1, cards2) -> cards2.get(0).compareTo(cards1.get(0)))
                .findFirst()
                .map(cards -> cards.get(0).getValue());
    }

    protected abstract int group1size();

    protected abstract int group2size();
}
