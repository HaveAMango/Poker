package poker;

import poker.combination.Combination;
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
        String cards = "4c5s3h8s7s 3d4s 2c4d 7s9s 8h9d 1d6d";
        //System.out.println(cards);  // Output user input
        Game game = new Game();
        game.initialize(cards);
        game.process();


    }

    private void process() {
        //check each player for two of a kind
        List<Combination> combinations;
        //for each poker.combination
        //  process each player
        //    if player has combinationResult, continue
        TwoOfaKind twoOfaKind = new TwoOfaKind();
        for(Player player : players){
            twoOfaKind.answer(player);
            System.out.println(twoOfaKind.answer(player));
        }
        //TODO: Other combinations

        //TODO: Sort and output players based on combinations
    }

    private void initialize(String cards) throws Exception {
        //TODO: Convert to constructor
        String[] handaboard = cards.split(" ");

        Board board = null;
        for (String n : handaboard) {
            List<Card> handCards = new ArrayList<>();
            String[] parts = n.split("");
            for (int i = 0; i < parts.length; i += 2) {
                String v = parts[i];
                String s = parts[i + 1];
                Card card = new Card(v + s);

                handCards.add(card);
            }

            if (handCards.size() > 2) {
                board = new Board(handCards);
                System.out.println(board.toString());
            } else {
                Hand hand = new Hand(handCards);
                Player player = new Player(board, hand);
                this.players.add(player);
                System.out.println(players);
            }
        }
    }
}
