package google.commonQuestions;

/*
 * Pots of gold game: Two players A & B. There are pots of gold arranged in a
 * line, each containing some gold coins (the players can see how many coins are
 * there in each gold pot - perfect information). They get alternating turns in
 * which the player can pick a pot from one of the ends of the line. The winner
 * is the player which has a higher number of coins at the end. The objective is
 * to "maximize" the number of coins collected by A, assuming B also plays
 * optimally. A starts the game.
 * 
 * The idea is to find an optimal strategy that makes A win knowing that B is
 * playing optimally as well. How would you do that?
 */

public class PotsOfGold {

    public static int min(int i, int j) {
        return (i < j) ? i : j;
    }

    public static int max(int i, int j) {
        return (i > j) ? i : j;
    }

    public static int findMaxCoins(int[] pots) {
        int[][] memo = new int[pots.length][pots.length];
        int value = findMaxCoins(pots, 0, pots.length - 1, memo);
        return value;

    }

    public static int findMaxCoins(int[] pots, int start, int end, int[][] memo) {

        if (start > end) {

            return 0;
        }

        else if (memo[start][end] != 0) {
            return memo[start][end];
        } else {
            /*
             * If pick from start get pots[start]. Other player picks from
             * [start+1, end]. So next can get best pick from whichever interval
             * gives minimum out of [start+2, end] and [start+1, end-1]
             */
            int pickFirst = pots[start]
                    + min(findMaxCoins(pots, start + 1, end - 1, memo),
                            findMaxCoins(pots, start + 2, end, memo));
            /*
             * If pick from end, get pots[end]. Other player picks from [start,
             * end-1]. So next can get best pick from whichever interval gives
             * minimum out of [start+1, end] and [start, end-2]
             */
            int pickLast = pots[end]
                    + min(findMaxCoins(pots, start + 1, end, memo),
                            findMaxCoins(pots, start, end - 2, memo));
            memo[start][end] = max(pickFirst, pickLast);
            return memo[start][end];
        }
    }

    public static void main(String[] args) {
        int[] potsOfGold = { 5, 5, 10, 5, 9, 9, 3, 9, 5, 1 };// 10, 2, 6,
                                                             // 8, 12, 5, 9
                                                             // };
        System.out.println(findMaxCoins(potsOfGold));

    }

}
