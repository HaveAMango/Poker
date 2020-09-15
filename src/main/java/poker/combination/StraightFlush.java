package poker.combination;

import poker.Card;
import poker.Player;
import poker.Value;
import poker.combination.Combination;
import poker.combination.CombinationResult;
import poker.combination.NCardsCombinationResult;
import poker.combination.Straight;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StraightFlush implements Combination {

    @Override
    public int priority() {
        return 9;
    }

    @Override
    public CombinationResult answer(Player player) {
        Map<String, List<Card>> bySuit = player.getAllCards()
                .stream()
                .collect(Collectors.groupingBy(card -> card.suit));

        Optional<List<Card>> flushCards = bySuit.values()
                .stream()
                .filter(cards -> cards.size() >= 5)
                .findAny();

        if (!flushCards.isPresent()) {
            return null;
        }

        List<Card> sortedFlushCards = flushCards.get().stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        NCardsCombinationResult answer = (NCardsCombinationResult) new Straight().answer(sortedFlushCards);
        return new NCardsCombinationResult(this, answer.isExists() ? answer.getValue() : Value.NONE, sortedFlushCards);
    }

    @Override
    public String name() {
        return "Straight Flush";
    }
}
