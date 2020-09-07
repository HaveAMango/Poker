package poker.combination;

import poker.Card;
import poker.Player;
import poker.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TwoPairs implements Combination {

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getAllCards();

        Map<Value, List<Card>> byValue = cards
                .stream()

                .collect(Collectors.groupingBy(card -> card.value));

        boolean result = byValue.values()
                .stream()
                .filter(list -> list.size() == 2)
                .count() >= 2;
        return new CombinationResult(result, this);

    }
}