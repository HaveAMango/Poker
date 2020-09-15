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

        Value group1value = highestNValue(byValue.values(), group1size());
        byValue.values().removeIf(cards -> cards.get(0).getValue().equals(group1value));
        Value group2value = highestNValue(byValue.values(), group2size());

        List<Card> kickers = player.getAllCards()
                .stream()
                .filter(c -> !c.getValue().equals(group1value) && !c.getValue().equals(group2value))
                .collect(Collectors.toList());

        return new TwoGroupsCombinationResult(this, group1value, group2value, kickers);
    }

    private Value highestNValue(Collection<List<Card>> cardGroups, int n) {
        return cardGroups.stream()
                .filter(list -> list.size() == n)
                .sorted((cards1, cards2) -> cards2.get(0).compareTo(cards1.get(0)))
                .findFirst()
                .map(cards -> cards.get(0).getValue())
                .orElse(Value.NONE);
    }

    protected abstract int group1size();

    protected abstract int group2size();
}
