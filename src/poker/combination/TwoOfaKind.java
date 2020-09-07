package poker.combination;

import poker.Card;
import poker.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoOfaKind implements Combination {

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getAllCards();

        Map<Integer, List<Card>> byValue = cards
                .stream()
                .collect(Collectors.groupingBy(card -> card.value));
        boolean result = byValue.values()
                .stream()
                .anyMatch(list -> list.size() >= 2);
        return new CombinationResult(result);
    }

    @Override
    public int priority() {
        return 2;
    }
}