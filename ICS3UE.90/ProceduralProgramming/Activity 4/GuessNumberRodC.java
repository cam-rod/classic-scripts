/**
 * This page randomly generates a nuumber between 2 given values and has a user guess that number,
 * assisting by tell ing the user if they have guessed too high or low.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/14/17
 */

import javax.swing.*;
public class GuessNumberRodC {
  
  /** @param args the command line arguments */
  public static void main(String[] args) {
    //DECLARING VARIABLES
    int lowRange; //The lowest value of the random number
    int highRange; //The highest value of the random number
    
    int randNum; //The random integer generated
    int restart = JOptionPane.YES_OPTION; //Restarts program if requested by user
    //Introduce program
    introProgram();
    
    //Initializing restart loop
    while (restart == JOptionPane.YES_OPTION) {
      //INPUT RANGE VALUES
      lowRange = lowNumInput();
      highRange = highNumInput(lowRange);
      
      //PROCESSING
      randNum = randNumGen(lowRange, highRange); //TEACHER NOTE: first word in method name should be action (getRandNum)
      
      //OUTPUT
      userGuesses(randNum, lowRange, highRange); //TEACHER NOTE: Split, methods should be singular in purpose
      
      //Restart program dialog
      restart = restartProgram();
    }
  }
  
  /**
   * Introduces the program to the user
   */
  public static void introProgram() { //TEACHER NOTE: new paragraph after title
    JOptionPane.showMessageDialog(null, "Welcome to the game \"Guess The Number\"! In this game, you enter a low and high"
                                  + "\nnumber, and a random number will be generated between them. You have to guess"
                                  + "\nthat number in as few tries as possible. Click the button below to begin.",
                                  "Guess The Number", JOptionPane.INFORMATION_MESSAGE);
  }
  
  /**
   * Return a valididated low number of the range
   * 
   * @return the low number of the range
   */
  public static int lowNumInput() {
    int validInput = 0; //Invalid input loop variable
    int lowNum = 0; //The low end of range to be returned (must be initialized)
    //Initializing valid input check loop
    do {    
      //Get number
      String lowNumText = JOptionPane.showInputDialog("Please enter the low number for the range:", "Enter Low Number");
      if (lowNumText != null && lowNumText.matches("[0-9]+")) {
        lowNum = Integer.parseInt(lowNumText);
        validInput = 1;
      }
      else { //Invalid input
        validInput = 0;
        JOptionPane.showMessageDialog(null, "A number was not entered. Please try again.", "Invalid Entry",
                                      JOptionPane.ERROR_MESSAGE);
      }
    }
    while (validInput == 0);
    return (lowNum);
  }
  
  /**
   * Return the high number of the range, must be higher than low end
   * 
   * @param low the low end of the range
   * @return the high end of the range
   */
  public static int highNumInput(int low) {
    int validInput = 0; //Invalid input loop variable
    int highNum = 1; //The high end of range to be returned (must be initialized)
    //Initializing valid input check loop (also checks if number higher than low number)
    do {
      //Get number
      String highNumText = JOptionPane.showInputDialog("Please enter the high number for the range. It must be higher than "
                                                     + low + ".", "Enter High Number");
      if (highNumText != null && highNumText.matches("[0-9]+") && Integer.parseInt(highNumText) > low) {
        highNum = Integer.parseInt(highNumText);
        validInput = 1;
      }
      else { //Invalid input
        validInput = 0;
        JOptionPane.showMessageDialog(null, "A number was not entered, or the number entered was not higher than the"
                                      + "\nlow number. Please try again with a number higher than " + low + ".",
                                      "Invalid Entry", JOptionPane.ERROR_MESSAGE);
      }
    }
    while (validInput == 0);
    return (highNum);
  }
  
  /**
   * Returns random number between range limits
   * 
   * @param low the low end of the allowed range
   * @param high the high end of the allowed range
   * @return the randomly generated integer
   */
  public static int randNumGen(int low, int high) {
    int rand;
    do {
      rand=(int)((Math.random()*high)+1); //Generates integer from 1 to high
    }
    while (rand<low);
    return (rand);
  }
  
  /**
   * User guesses the number generated
   * 
   * @param answer the correct number
   * @param low the low end of the range
   * @param high the high end of the range
   */
  public static void userGuesses(int answer, int low, int high) {
    String guessText; //The text of the user's guess
    int guess = 0; //The number guessed by the user (initialized as 0 as it cannot be generated)
    int attempts = 0; //The number of user attempts
    do {
      attempts++;
      //User guesses number
      guessText = JOptionPane.showInputDialog("Please enter your guess: (Remember, your range is from " + low + " to "
                                              + high + ")", "Guess Number");
      
      //Valid guess check
      if (guessText != null && guessText.matches("[0-9]+")) {
        guess = Integer.parseInt(guessText);
        extremeGuessMessage(guess, answer);
      }
      //Invalid entry or cancel selected
      else {
        JOptionPane.showMessageDialog(null, "That wasn't a number! Please enter a number when you guess. Also, that"
                                      + "\ncounted as an attempt, so don't try it again!", "Number Not Entered",
                                      JOptionPane.ERROR_MESSAGE);
      }
    }
    while (guess !=  answer);
    //Successful guess dialog
    JOptionPane.showMessageDialog(null, "Congratulations! After " + attempts + " tries, you guessed the correct number,"
                                  + "\nwhich was " + answer + ".", "Correct!", JOptionPane.PLAIN_MESSAGE);
  }
  /**
   * Delivers message if guess is too high or too low
   * 
   * @param guess the user's guess
   * @param answer the correct answer
   */
  public static void extremeGuessMessage(int guess, int answer) {
    //Guessed too high
    if (guess > answer) {
    JOptionPane.showMessageDialog(null, "That isn't the answer. Your guess was TOO HIGH, choose a number lower than "
                                  + guess + ".", "Too High!", JOptionPane.WARNING_MESSAGE);
    }
    //Guessed too low
    else if (guess < answer) {
    JOptionPane.showMessageDialog(null, "That isn't the answer. Your guess was TOO LOW, choose a number higher than "
                                  + guess + ".", "Too Low!", JOptionPane.WARNING_MESSAGE);
    }
  }
  /**
   * Returns whether user would like to restart program
   * 
   * @return the user's choice on restarting the program
   */
    public static int restartProgram() {
      Object[] options = {"Yes, please", "No, thanks"};
      int restart = JOptionPane.showOptionDialog(null, "Would you like to play again?", "Play Again?",
                                             JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
                                             options[0]);
      return (restart);
    }
}
