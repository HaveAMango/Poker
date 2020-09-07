package poker.combination;

import poker.Card;
import poker.Player;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StraightFlush implements Combination {

    @Override
    public int priority() {
        return 9;
    }

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getAllCards();

        Map<Integer, List<Card>> byValue = cards
                .stream()
                .collect(Collectors.groupingBy(card -> card.value));

        boolean flush = byValue.values()
                .stream()
                .anyMatch(list -> list.size() >= 5);


        return new CombinationResult(flush, this);
    }
}
