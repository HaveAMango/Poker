package poker.combination;

import poker.Card;
import poker.Player;

import java.util.List;

public class Straight implements Combination {

    @Override
    public int priority() {
        return 5;
    }

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getAllCards();

//        Map<Integer, List<poker.Card>> byValue = cards
//                .stream()
//                .filter(card -> card.value )
//                .sorted(card -> Comparator.naturalOrder())
//                .collect(Collectors.groupingBy(card -> card.value));
//        return byValue.values()
//                .stream()
//                .anyMatch(list -> list.size() >= 3);
//    }
        return new CombinationResult(true, this);
    }

    @Override
    public String name() {
        return "Straight";
    }
}