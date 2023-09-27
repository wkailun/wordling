package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static edu.virginia.sde.hw2.wordle.GameStatus.*;
import static edu.virginia.sde.hw2.wordle.LetterResult.*;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private static Dictionary defaultGuessesDictionary, defaultAnswersDictionary;
    @BeforeAll
    public static void initialize() {
        defaultGuessesDictionary = DefaultDictionaries.getGuessesDictionary();
        defaultAnswersDictionary = DefaultDictionaries.getAnswersDictionary();
    }
    @Test
    public void test_init_zeroArgumentConstructor() {
        var game = new Game();

        assertEquals(defaultGuessesDictionary, game.getGuessDictionary());
        assertTrue(defaultAnswersDictionary.contains(game.getAnswer()));
        assertEquals(6, game.getGuessesRemaining());
        assertEquals(PLAYING, game.getGameStatus());
    }

    @Test
    public void test_init_4ArgumentConstructor() {
        var game = new Game(defaultGuessesDictionary, "TREND", 6, PLAYING);

        assertEquals(defaultGuessesDictionary, game.getGuessDictionary());
        assertEquals("TREND", game.getAnswer());
        assertEquals(6, game.getGuessesRemaining());
        assertEquals(PLAYING, game.getGameStatus());
    }

    @Test
    public void test_isGameOver_WIN_True() {
        var game = new Game(defaultGuessesDictionary, "TREND", 5, WIN);

        assertEquals(WIN, game.getGameStatus());
        assertTrue(game.isGameOver());
    }

    @Test
    public void test_submitGuess_decrementCorrectly() {
        var gameOne = new Game(defaultGuessesDictionary, "TREND", 2, PLAYING);
        gameOne.submitGuess("TREND");
        assertEquals(1, gameOne.getGuessesRemaining());

        var gameTwo = new Game(defaultGuessesDictionary, "TREND", 6, PLAYING);
        gameTwo.submitGuess("TREND");
        assertEquals(5, gameTwo.getGuessesRemaining());

        var gameThree = new Game(defaultGuessesDictionary, "TREND", 1, PLAYING);
        gameThree.submitGuess("TREND");
        assertEquals(0, gameThree.getGuessesRemaining());
    }

    @Test
    public void test_submitGuess_correctGameStatus_PLAYING() {
        var game = new Game(defaultGuessesDictionary, "TREND", 4, PLAYING);
        assertEquals(PLAYING, game.getGameStatus());
    }

    @Test
    public void test_submitGuess_WIN() {
        var game = new Game(defaultGuessesDictionary, "TREND", 6, PLAYING);
        game.submitGuess("TREND");

        assertEquals(WIN, game.getGameStatus());
    }

    @Test
    public void test_submitGuess_LOSS() {
        var game = new Game(defaultGuessesDictionary, "TREND", 6, PLAYING);
        game.submitGuess("hello");
        game.submitGuess("apple");
        game.submitGuess("earth");
        game.submitGuess("water");
        game.submitGuess("polar");
        game.submitGuess("total");

        assertEquals(LOSS, game.getGameStatus());
    }

    @Test
    public void test_submitGuess_notInDictionary() {
        var game = new Game(defaultGuessesDictionary, "TREND", 4, PLAYING);

        assertThrows(IllegalWordException.class, () -> game.submitGuess("hjklk"));
    }

    @Test
    public void test_submitGuess_submitAfterGameEnded() {
        var gameWIN = new Game(defaultGuessesDictionary, "TREND", 0, WIN);
        var gameLOSS = new Game(defaultGuessesDictionary, "TREND", 0, LOSS);

        assertThrows(GameAlreadyOverException.class, () -> gameWIN.submitGuess("hello"));
        assertThrows(GameAlreadyOverException.class, () -> gameLOSS.submitGuess("hello"));
    }
}