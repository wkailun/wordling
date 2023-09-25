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

    @Test
    public void getLetterResult_allCorrect() {
        GuessResult result = new GuessResult("basic", "basic");
        assertArrayEquals(new LetterResult[]{LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN}, result.getLetterResults());
    }

    @Test
    public void getLetterResult_allWrong() {
        GuessResult result = new GuessResult("brain", "hello");
        assertArrayEquals(new LetterResult[]{LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY}, result.getLetterResults());
    }

    @Test
    public void getLetterResult_someCorrect() {
        GuessResult result = new GuessResult("brain", "basic");
        assertArrayEquals(new LetterResult[]{LetterResult.GREEN, LetterResult.GRAY, LetterResult.YELLOW, LetterResult.GREEN, LetterResult.GRAY}, result.getLetterResults());
    }
    @Test
    public void getLetterResult_nullInput(){
        GuessResult guessResult = new GuessResult(null, "basic");
        assertThrows(IllegalArgumentException.class, () -> guessResult.getLetterResults());
    }

    @Test
    public void getLetterResult_incorrectLetterFormat() {
        GuessResult wrongLength = new GuessResult("hundred", "hello");
        assertThrows(IllegalArgumentException.class, () -> wrongLength.getLetterResults());

        GuessResult invalidInputNumbers = new GuessResult("12345", "brain");
        assertThrows(IllegalArgumentException.class, () -> invalidInputNumbers.getLetterResults());

        GuessResult invalidInput = new GuessResult("**+=-", "brain");
        assertThrows(IllegalArgumentException.class, () -> invalidInput.getLetterResults());
    }
    @Test
    public void getLetterResult_doubleLetters() {
        GuessResult guessResult = new GuessResult("dwell", "chill");
        assertArrayEquals(new LetterResult[]{LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GREEN, LetterResult.GREEN}, guessResult.getLetterResults());
    }

    @Test
    public void getLetterResult_tripleLetters() {
        GuessResult guessResult = new GuessResult("apple", "apppo");
        assertArrayEquals(new LetterResult[]{LetterResult.GREEN, LetterResult.GREEN, LetterResult.GREEN, LetterResult.GRAY, LetterResult.GRAY}, guessResult.getLetterResults());
    }
}
