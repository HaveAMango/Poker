package poker;

import poker.combination.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    List<Player> players = new ArrayList<>();

    public static boolean DEBUG = false;

    Combination[] combinations = {
            new StraightFlush(),
            new FourOfaKind(),
            new FullHouse(),
            new Flush(),
            new Straight(),
            new ThreeOfaKind(),
            new TwoPairs(),
            new TwoOfaKind(),
            new HighCard()
    };

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter cards");

//        String cards = scanner.nextLine();  // Read user input
        String cards = "4cKs4h8s7s Ad4s Ac4d As9s KhKd 5d6d";
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


        printResult(players);
    }

    private void printResult(List<Player> players) {
        players = players.stream()
                .sorted()
                .collect(Collectors.toList());
        if (DEBUG) {
            players.forEach(System.out::println);
            return;
        }

        Player previous = null;
        for (int i = 0; i < players.size(); i++) {
            Player current = players.get(i);
            if (previous != null && current.handEquals(previous)) {
                System.out.print("=");
            } else if (previous != null) {
                System.out.print(" ");
            }
            System.out.print(current);

            previous = current;
        }
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
