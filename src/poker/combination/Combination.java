package poker.combination;

import poker.Player;

public interface Combination {

   CombinationResult answer(Player player);

   int priority();
}
