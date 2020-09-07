package poker.combination;

import poker.Card;
import poker.Player;

import java.util.List;

public class Straight implements Combination {

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getHandaboard();

//        Map<Integer, List<poker.Card>> byValue = cards
//                .stream()
//                .filter(card -> card.value )
//                .sorted(card -> Comparator.naturalOrder())
//                .collect(Collectors.groupingBy(card -> card.value));
//        return byValue.values()
//                .stream()
//                .anyMatch(list -> list.size() >= 3);
//    }
        return new CombinationResult(true);
}}