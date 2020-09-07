package poker.combination;

import poker.Board;
import poker.Card;
import poker.Hand;
import poker.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ThreoOfaKind implements Combination {

    @Override
    public CombinationResult answer(Player player) {
        List<Card> cards = player.getHandaboard();

        Map<Integer, List<Card>> byValue = cards
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
        return new CombinationResult(result);
    }

    @Override
    public int priority() {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        List<Card> boardCards = new ArrayList<>();
        boardCards.add(new Card("1c"));
        boardCards.add(new Card("2s"));
        boardCards.add(new Card("2d"));
        boardCards.add(new Card("3h"));
        boardCards.add(new Card("1c"));
        List<Card> handCards = new ArrayList<>();
        handCards.add(new Card("2s"));
        handCards.add(new Card("3h"));
        Board board = new Board(boardCards);
        Hand hand = new Hand(handCards);
        Player player = new Player(board, hand);
        System.out.println(new ThreoOfaKind().answer(player));
    }
}


