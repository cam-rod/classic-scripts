/**
 * This prograam simulates rock-paper-scissors, where a user selects a play, the computers generates a play, and the
 * result is checked to detemine a winner, alongside a running score.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/16/17
 */

import javax.swing.*;
public class RockPaperScissorsRodC {
  
  /** @param args the command line arguments */
  public static void main(String[] args) { 
    //DECLARING VARIABLES
    int compPlay = 99; //The play the computer makes
    int userPlay = 99; //The play the user makes
    int result = 99; //The winner of the round
    int gamesTied = 0; //Number of games tied by the user
    int gamesWon = 0; //Number of games won by the user
    int gamesLost = 0; //Number of games lost by the user
    int replay = JOptionPane.YES_OPTION; //Determines if game restarts
    
    //Introducing program
    introProgram();
    
    //Initializing replay while loop
    playLoop: //Labels loop to allow braking if user ends program early
    while (replay == JOptionPane.YES_OPTION) {
      //INPUT - Get user play
      userPlay = chooseUserPlay();
      
      //End game if requested
      if (userPlay == 102) {
        break playLoop;
      }
      
      //PROCESSING
      //Generate computer play
      compPlay = generateCompPlay();
      
      //Determine winner
      result = determineResult(userPlay, compPlay);
      
      //Add score to existing totals (inpossible to return all through one method)
      gamesTied = addGamesTied(result, gamesTied);
      gamesWon = addGamesWon(result, gamesWon);
      gamesLost = addGamesLost(result, gamesLost);
      
      //OUTPUT - Display results to user
      displayResults(userPlay, compPlay, result, gamesTied, gamesWon, gamesLost);
      
      //Ask if user would like to play again
      replay = askToReplay();
    }
    JOptionPane.showMessageDialog(null, "You won " + gamesWon + " games, lost " + gamesLost + " games, and tied " + gamesTied + " games."
                                  + "\n\nThanks for playing!", "Goodbye", JOptionPane.PLAIN_MESSAGE);
  }
  
  /** Introduces the program to the user. */
  public static void introProgram() {
    JOptionPane.showMessageDialog(null, "Welcome to Rock-Paper-Scissors!"
                                  + "\n\nPlay against the computer in a classic game of rock-paper-scissors and see"
                                  + "\nhow many games you can win!", "Rock-Paper-Scissors", JOptionPane.INFORMATION_MESSAGE);
  }
  
  /**
   * Returns user's play (or ends program if requested)
   * 
   * @return the user's play (or restart request);
   */
  public static int chooseUserPlay() {
    Object[] plays = {"Rock", "Paper", "Scissors"}; //Options in the input dialog
    int userPlay = 99; //The user's play
    //Initializing retry loop
    do {
      userPlay = JOptionPane.showOptionDialog(null, "What do you play?", "Play", JOptionPane.DEFAULT_OPTION,
                                                  JOptionPane.QUESTION_MESSAGE, null, plays, plays[0]);
      //User closed window check
      userPlay = endProgramEarlyCheck(userPlay);
      //Add 1 to result to match computer play
      userPlay += 1;
    }
    while (userPlay == 101);
    //Return to main method
    return userPlay;
  }
  
  /**
   * Checks if user wants to end program early
   * 
   * @param play the user's play
   * @return if user wants to end program early
   */
  public static int endProgramEarlyCheck(int play) {
    Object[] options = {"Yes", "No"}; //Retry menu options
    //Initializing "close button selected" if statement
    if (play != 0 && play != 1 && play != 2) {
      play = JOptionPane.showOptionDialog(null, "Are you sure you would like to quit?","Quit?", JOptionPane.YES_NO_OPTION,
                                          JOptionPane.WARNING_MESSAGE, null, options, options[0]);
      //Initializing "quit" check
      if (play == JOptionPane.NO_OPTION) { //The user decided to continue to play
        play = 100; //When 1 is added in the chooseUserPlay method it will result as 10 and restart the input menu
      }
      else {
        play = 101; /* When 1 is added this becomes 102. In the main method it is intrepreted, causing the game loop
                     * to be broken and ending the game WITHOUT force closing it. */
      }
    }
    return play;
  }
  
  /**
   * Returns randomly generated computer play
   * 
   * @return the computer's play
   */
  public static int generateCompPlay() {
    int play = (int) ((Math.random()*3)+1);
    return play;
  }
   /**
    * Return result of computer and user plays
    * 
    * @param userPlay the user's play
    * @param compPlay the computer's play
    * @return the result of the round
    */
  public static int determineResult (int userPlay, int compPlay) {
    int result = 0; //The result. 1 is a tie, 2 is a user win, 3 is a user loss
    //Determine winner
    if (userPlay == compPlay) {
      result = 1;
    }
    else if (userPlay > compPlay && userPlay != compPlay + 2 || compPlay == userPlay + 2) {
      /* First part determines if user number is higher than computer (scissors beats paper, paper beats rock)
       * unless computer is 2 below user (scissors loses to rock), or if user is 2 below computer (rock beats scissors) */
      result = 2;
    }
    else {
      result = 3;
    }
    return result;
  }
  
  /**
   *  Add a tie if applicable
   * 
   * @param result the result of the last round
   * @param gamesTied the total number of games tied
   * @return the number of games ties
   */
  public static int addGamesTied(int result, int gamesTied) {
    if (result == 1) {
      gamesTied += 1;
    }
    return gamesTied;
  }
  
  /**
   * Add a win if applicable
   * 
   * @param result the result of the last round
   * @param gamesWon the total number of games won
   * @return the number of games won
   */
  public static int addGamesWon(int result, int gamesWon) {
    if (result == 2) {
      gamesWon += 1;
    }
    return gamesWon;
  }
  
  /**
   * Add a loss if applicable
   * 
   * @param result the result of the last round
   * @param gamesLost the total number of games lost
   * @return the number of games lost
   */
  public static int addGamesLost(int result, int gamesLost) {
    if (result == 3) {
      gamesLost += 1;
    }
    return gamesLost;
  }
  
  /**
   * Display results to user
   * 
   * @param userPlay the play the user made
   * @param compPlay the play the computer made
   * @param result the result of the round 
   * @param gamesTied the total number of games won
   * @param gamesWon the total number of games tied
   * @param gamesLost the total number of games los
   */
  public static void displayResults(int userPlay, int compPlay, int result, int gamesTied, int gamesWon, int gamesLost) {
    //Convert number to text
    String userPlayText = convertNumToWord(userPlay);
    String compPlayText = convertNumToWord(compPlay);
    //Display results
    if (result == 1) {
      JOptionPane.showMessageDialog(null, "The game ended in a tie! You both played " + userPlayText + "!"
                                    + "\n\nGames won: " + gamesWon + "\nGames tied: " + gamesTied + "\nGames lost: "
                                    + gamesLost, "You Tied", JOptionPane.PLAIN_MESSAGE);
    }
    else if (result == 2) {
      JOptionPane.showMessageDialog(null, "You won! Your " + userPlayText + " beat the computer's " + compPlayText + "!"
                                    + "\n\nGames won: " + gamesWon + "\nGames tied: " + gamesTied + "\nGames lost: "
                                    + gamesLost,"You Won!", JOptionPane.PLAIN_MESSAGE);
    }
    else {
      JOptionPane.showMessageDialog(null, "You lost! Your " + userPlayText + " lost to the computer's " + compPlayText + "."
                                    + "\n\nGames won: " + gamesWon + "\nGames tied: " + gamesTied + "\nGames lost: "
                                    + gamesLost, "You Lost", JOptionPane.PLAIN_MESSAGE);
    }
  }

  /**
   * Return the word/play corresponding to the number
   * 
   * @param number the number form of the play
   * @return the word
   */
  public static String convertNumToWord(int number) {
    String text; //The text to be returned
    if (number == 1) {
      text = "Rock";
    }
    else if (number == 2) {
      text = "Paper";
    }
    else {
      text = "Scissors";
    }
    return text;
  }
  
  /**
   * Return if user would like to play again
   * 
   * @return if users wants to play again
   */
  public static int askToReplay() {
    Object[] options = {"Yes", "No"}; //Options for dialog
    int replay = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Play Again?",
                                          JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                                          options[0]);
    return replay;
  }
}