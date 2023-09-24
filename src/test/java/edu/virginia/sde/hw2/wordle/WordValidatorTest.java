package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WordValidatorTest {
    private static WordValidator wordValidator;

    @BeforeAll
    public static void initialize() {
        wordValidator = new WordValidator();
    }

    @Test
    public void isValidWord_false_tooLong() {
        assertFalse(wordValidator.isValidWord("DOGGIE"));
    }


    @Test
    public void isValidWord_true_tooShort() {
        assertTrue(wordValidator.isValidWord("earth"));
    }

    @Test
    public void isCorrectLength_false() {
        assertFalse(wordValidator.isCorrectLength("hey"));
    }

    @Test
    public void isCorrectLength_false_whitespace() {
        assertFalse(wordValidator.isCorrectLength("HOUSE "));

    }

    @Test
    public void isAllLetters_false() {
        assertTrue(wordValidator.isAllLetters("abcde"));
    }

    @Test
    public void isAllLetters_mixed() {
        assertTrue(wordValidator.isAllLetters("hOusE"));

    }
}