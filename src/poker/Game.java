package poker;

import poker.combination.Combination;
import poker.combination.CombinationResult;
import poker.combination.ThreoOfaKind;
import poker.combination.TwoOfaKind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    List<Player> players = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter cards");

//        String cards = scanner.nextLine();  // Read user input
        String cards = "4c5s3h8s7s 3d4s 4h4d 7s9s 8h9d 1d6d";
        //System.out.println(cards);  // Output user input
        Game game = new Game();
        game.initialize(cards);
        game.process();


    }

    private void process() {
        //check each player for two of a kind
        List<Combination> combinations = new ArrayList<>();
        combinations.add(new ThreoOfaKind());
        combinations.add(new TwoOfaKind());

        for (Combination combination : combinations) {
            for (Player player : players) {
                CombinationResult result = combination.answer(player);
                System.out.println(result);
            }
        }

        //TODO: Other combinations

        //TODO: Sort and output players based on combinations
    }

    private void initialize(String input) throws Exception {
        //TODO: Convert to constructor
        String[] cardGroups = input.split(" ");

        Board board = null;
        for (String cardGroup : cardGroups) {
            List<Card> cards = parseCardGroup(cardGroup);

            if (cards.size() > 2) {
                board = new Board(cards);
                System.out.println(board.toString());
            } else {
                Hand hand = new Hand(cards);
                Player player = new Player(board, hand);
                this.players.add(player);
                System.out.println(players);
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
