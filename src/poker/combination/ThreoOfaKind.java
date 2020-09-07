package poker.combination;

import poker.Card;
import poker.Player;
import poker.Value;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThreoOfaKind implements Combination {

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getAllCards();

        Map<Value, List<Card>> byValue = cards
                .stream()
                //.filter(new CardPredicate())
                //.filter(card -> card.suit.equals("c") || card.suit.equals("s"))
//                .filter(card -> {
//                    return card.suit.equals("c") || card.suit.equals("s");
//                })
                //.map(word -> word.suit)
                //.map(new CardTransformator())
                //.collect(Collectors.toList());
                .collect(Collectors.groupingBy(card -> card.value));
        boolean result = byValue.values()
                .stream()
                .anyMatch(list -> list.size() >= 3);
        return new CombinationResult(result, this);
    }

    @Override
    public int priority() {
        return 4;
    }
}


