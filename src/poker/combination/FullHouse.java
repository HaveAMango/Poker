package poker.combination;

import poker.Card;
import poker.Player;
import poker.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FullHouse implements Combination {

    @Override
    public int priority() {
        return 7;
    }

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getAllCards();

        Map<Value, List<Card>> byValue = cards
                .stream()

                .collect(Collectors.groupingBy(card -> card.value));

        boolean hasPair = byValue.values()
                .stream()
                .filter(list -> list.size() == 2)
                .count() >= 1;
        boolean hasSet = byValue.values()
                .stream()
                .filter(list -> list.size() == 3)
                .count() >= 1;
        return new CombinationResult(hasPair && hasSet, this);


    }
}