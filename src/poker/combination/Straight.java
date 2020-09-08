package poker.combination;

import poker.Card;
import poker.Player;
import poker.Value;
import poker.combination.Combination;
import poker.combination.CombinationResult;
import poker.combination.NCardsCombinationResult;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Straight implements Combination {

    @Override
    public int priority() {
        return 5;
    }

    public CombinationResult answer(Player player) {
        List<Card> sortedCards = player.getAllCards()
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());


        int currentStreak = 1;
        int maxStreak = 1;
        Card maxCard = null;
        for (int i = 1; i < sortedCards.size(); i++) {
            Card current = sortedCards.get(i);
            Card previous = sortedCards.get(i - 1);
            int delta = current.getValue().compareTo(previous.getValue());
            if (delta == 1) {
                currentStreak++;
                if (currentStreak >= maxStreak) {
                    maxStreak = currentStreak;
                    maxCard = current;
                }
            } else if (delta != 0) {
                currentStreak = 1;
            }
        }

        return new NCardsCombinationResult(this, maxStreak >= 5 ? maxCard.value : Value.NONE);
    }


    @Override
    public String name() {
        return "Straight";
    }
}