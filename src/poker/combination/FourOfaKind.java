package poker.combination;

import poker.Card;
import poker.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FourOfaKind implements Combination {

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getHandaboard();

        Map<Integer, List<Card>> byValue = cards
                .stream()
                .collect(Collectors.groupingBy(card -> card.value));
        boolean result = byValue.values()
                .stream()
                .anyMatch(list -> list.size() > 3);
        return new CombinationResult(result);
    }
}