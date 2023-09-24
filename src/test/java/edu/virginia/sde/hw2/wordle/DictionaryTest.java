package edu.virginia.sde.hw2.wordle;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DictionaryTest {

    @Test
    void getWordSet() {
        var startingWordSet = new HashSet<>(Set.of("apple", "black", "camel"));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());

        var wordSet = dictionary.getWordSet();
        assertEquals(3, wordSet.size());
        assertTrue(wordSet.contains("apple"));
        assertTrue(wordSet.contains("black"));
        assertTrue(wordSet.contains("camel"));
    }

    @Test
    void getWordSet_initiallyEmpty() {
        var dictionary = new Dictionary();

        var wordSet = dictionary.getWordSet();
        assertTrue(wordSet.isEmpty());
    }
    @Test
    void contains_existingWord(){
        var startingWordSet = new HashSet<>(Set.of("apple", "black", "camel"));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());
        assertTrue(dictionary.contains("apple"));
    }

    @Test
    void contains_nonExistingWord(){
        var startingWordSet = new HashSet<>(Set.of("apple", "black", "camel"));
        var dictionary = new Dictionary(startingWordSet, new WordValidator());
        assertFalse(dictionary.contains("banana"));
    }
    @Test
    void size_emptyDict(){
        var dictionary = new Dictionary();
        assertEquals(0, dictionary.size());
    }
    @Test
    void size_words(){
        var dictionary = new Dictionary();
        dictionary.addWord("apple");
        dictionary.addWord("crate");
        assertEquals(2, dictionary.size());
    }

    @Test
    void addWord_valid(){
        var dictionary = new Dictionary();
        dictionary.addWord("apple");
        assertTrue(dictionary.contains("apple"));
    }
    @Test
    void addWord_invalid(){
        var dictionary = new Dictionary();
        assertFalse(dictionary.contains("12344"));
    }
}