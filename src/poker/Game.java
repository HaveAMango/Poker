package poker;

import poker.combination.*;
import poker.combination.Straight;
import poker.combination.wip.FullHouse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    List<Player> players = new ArrayList<>();

    Combination[] combinations = {
            new FourOfaKind(),
            new FullHouse(),
            new Flush(),
            new Straight(),
            new ThreeOfaKind(),
            new TwoOfaKind(),
            new HighCard()
    };

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter cards");

//        String cards = scanner.nextLine();  // Read user input
        String cards = "Kc5s8h8s7s Kd4s 6h4d Ts9s 8s7d 1d6d";
        //System.out.println(cards);  // Output user input

        Game game = new Game();
        game.initialize(cards);
        game.process();


    }

    private void process() {
        for (Combination combination : combinations) {
            for (Player player : players) {
                player.setResult(combination.answer(player));
            }
        }

        List<Player> sortedPlayers = players.stream()
                .sorted()
                .collect(Collectors.toList());
        Collections.reverse(sortedPlayers);
        sortedPlayers.forEach(System.out::println);
    }

    private void initialize(String input) throws Exception {
        //TODO: Convert to constructor
        String[] cardGroups = input.split(" ");

        Board board = null;
        for (String cardGroup : cardGroups) {
            List<Card> cards = parseCardGroup(cardGroup);

            if (cards.size() > 2) {
                board = new Board(cards);
            } else {
                Hand hand = new Hand(cards);
                Player player = new Player(board, hand);
                this.players.add(player);

            }
        }
    }

    private List<Card> parseCardGroup(String cardGroup) throws Exception {
        List<Card> cards = new ArrayList<>();
        String[] parts = cardGroup.split("");
        for (int i = 0; i < parts.length; i += 2) {
            String v = parts[i];
            String s = parts[i + 1];
            Card card = new Card(v + s);

            cards.add(card);
        }
        return cards;
    }
}
