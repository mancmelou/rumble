package org.roshambo.example;

/**
 * Import the package so you can use the match class and run different AIs
 * here in your main method.
 */
import org.roshambo.*;

/**
 * Importing example AIs
 */
import org.roshambo.example.competitors.DumbAI;
import org.roshambo.example.competitors.RandomAI;

public class Main {
    public static void main(String[] args) {
        /**
         * Instantiate competitors
         */
        Competitor player1 = new DumbAI();
        Competitor player2 = new RandomAI();

        /**
         * Setup a new match and pass in the competitors and the number of rounds
         */
        Match match = new Match(player1, player2, 10);

        /**
         * This is kinda convenience method. There's also another method "fightNextRound()"
         * where you can iterate through rounds one by one.
         *
         * IMPORTANT: After each round, the match instance will send feedback to the both
         * competitors so they can adjust their strategy based on previous actions.
         */
        match.fightUntilFinish();

        /**
         * Output helper method. If you want the results table as a hash just call "match.getResults()".
         */
        Helpers.printResults(match);

        /**
         * "match.getResults" will return a hash map that looks like this HashMap<Integer,HashMap<String, String>>
         *
         * or to say in JSON, it would look something like this:
         *
         * {
         *   1: {"player_1": "ROCK",  "player_2": "PAPER", "WINNER": "player_2"},
         *   2: {"player_1": "PAPER", "player_2": "PAPER", "WINNER": "Tie"},
         *   3: {"player_1": "PAPER", "player_2": "SCISSORS", "WINNER": "player_2"},
         * }
         */
    }
}
