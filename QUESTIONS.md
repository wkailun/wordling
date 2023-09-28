# Reflection Questions

Answer these questions thoroughly after completing the assignment, using examples from your code. Good answers will be 1-2 paragraphs that cite specific code examples and show a meaningful reflection on how your development went, and how it could be improved in the future.

## Question 1

 In the Black-Box testing for GameState.submitGuess() portion of the assignment, list the partitions of inputs and fields that you used for your test plan. Cite specific tests by name and line number that cover each partition. A bulleted list is acceptable here. You should include all of your tests covering at least one partition. Additionally, for each partition, label it is equivalence, boundary, or exception.

## Answer

The testing for submitGuess() portion of the assignment include: 
* test_submitGuess_correctGameStatus_PLAYING(), test_submitGuess_WIN(), and test_submitGuess_LOSS(), which are all equivalence partitions,
  are testing if submitGuess() is updating the gameStatus correctly in each different scenarios (WIN, LOSS, PLAYING). 
  *  test_submitGuess_correctGameStatus_PLAYING() (line 61) checks that the status remains to be PLAYING when the user has not given a guess that matches
  the answer and the guessesRemaining does not equal to 0.
  * test_submitGuess_WIN() (line 67) checks that the gameStatus is WIN when the user has given a guess that matches the 
  answer
  * test_submitGuess_LOSS() (line 75) checks that the gameStatus is LOSS by exhausting all 6 of guessesRemaining with guesses that does not 
  match the answer, leaving guessesRemaining to be 0. 
* test_submitGuess_decrementCorrectly() (line 46) is a boundary partition that test and checks to see if guessesRemaining was being decremented 
correctly each time the user inputs a guess. 
* test_submitGuess_notInDictionary() and test_submitGuess_submitAfterGameEnded() are exception partitions that ensure that the 
correct exceptions are thrown when the user inserts an invalid input. 
  * test_submitGuess_notInDictionary() (line 88) checks that IllegalWordException is being thrown when input guess is not a word in the guess dictionary
  * test_submitGuess_submitAfterGameEnded() (line 95) checks that GameAlreadyOverException is being thrown when the user attempts to input a guess
    after the game has ended, in either win or lose situations. 

## Question 2

The function submitGuess(String) in WordleGameState can throw two different Exceptions. Why would we as developers intentionally design our program to throw Exceptions? What is the benefit?

## Answer

Developers intentionally design program to throw Exceptions as it is an essential part of handling errors. 
It allows developers to separate error handling code from the main code. This separation can make the 
code cleaner and more maintainable, and they can focus on writing code to handle specific errors in one place. 
Furthermore, by throwing exceptions when specific error conditions are met, developers can understand that something unexpected
has happened. This could help debug and handle errors better.
