package poker.combination;

import poker.Card;
import poker.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Flush implements Combination {

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getAllCards();

        Map<String, List<Card>> bySuit = cards
                .stream()
                .collect(Collectors.groupingBy(card -> card.suit));
        boolean result = bySuit.values()
                .stream()
                .anyMatch(list -> list.size() >= 5);
        return new CombinationResult(result, this);
    }

    @Override
    public int priority() {
        return 6;
    }
}
