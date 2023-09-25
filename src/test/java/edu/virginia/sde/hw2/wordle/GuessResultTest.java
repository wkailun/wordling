package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuessResultTest {
    @Test
    public void isCorrect_matches() {
        GuessResult guessResultCorrect = new GuessResult("basic", "basic");
        GuessResult guessResultFalse = new GuessResult("basic", "brain");

        assertTrue(guessResultCorrect.isCorrect()); // returns true
        assertFalse(guessResultFalse.isCorrect()); // returns false

    }

    @Test
    public void getLetterResult_notCaseSensitive() {
        GuessResult guessResult = new GuessResult("basic", "bAsic");
        LetterResult[] results = guessResult.getLetterResults();

        assertArrayEquals(new LetterResult[]{LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN}, results);
    }
}
