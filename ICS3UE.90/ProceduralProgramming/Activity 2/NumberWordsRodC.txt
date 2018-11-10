/**
 * This program takes a number between 1 and 99 and convert it into a word.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/14/17
 */

import javax.swing.*; //Importing Swing toolkit
public class NumberWordsRodC {
  
  /** @param args the command line arguments */
  public static void main(String[] args) { 
    //DECLARING VARIABLES
    String userNum = "103"; //the number inputted by the user (left in string form for faster processing, left at 103 for initialization)
    String userWord = "blank"; //The user's number as a word
    int restart = JOptionPane.YES_OPTION; //The integer which restarts the program
    Object[] restartOptions = {"Yes", "No"}; //The restart dialog options
    
    //Introducing program to user
    programIntro();
    
    //Initializing restart while loop
    while (restart == JOptionPane.YES_OPTION) {
      //INPUT NUMBER
      userNum = JOptionPane.showInputDialog(null, "Please enter a number between 1 and 99:", "Enter Number",
                                            JOptionPane.QUESTION_MESSAGE);
      
      //PROCESSING & OUTPUT - Distributing number to correct method with double if statements
      if (userNum != null && userNum.length() > 0 && userNum.length() < 3 && userNum.charAt(0) != '0' && userNum.matches("[0-9]+")) {
        if (userNum.length() == 1) {
          onesNum(userNum, userWord);
          restart = JOptionPane.YES_OPTION;
        }
        else if (userNum.charAt(0) == '1' && userNum.length() == 2) {
          teensNum(userNum, userWord);
          restart = JOptionPane.YES_OPTION;
        }
        else {
          tensNum(userNum, userWord);
          restart = JOptionPane.YES_OPTION;
        }
      }
      else { //If valid number is not entered or user selects cancel
        restart = JOptionPane.showOptionDialog(null, "A number was not entered. Would you like to try again?",
                                               "Number Not Entered", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                                               null, restartOptions, restartOptions[1]);
      }
    }
  }
  /** Introduces the program to the user */
  public static void programIntro() {
    JOptionPane.showMessageDialog(null, "This is the Numbers to Words Calculator. It will take any whole number"
                                  + "\nfrom 1 to 99, and convert into words. For example, 73 becomes SEVENTY-THREE."
                                  + "\nThe program will keep asking for number until it is closed or an invalid"
                                  + "\nnumber is entered.", "Numbers to Words Calculator", JOptionPane.INFORMATION_MESSAGE);
  }
  /**
   * Converts user's number from 1 to 9 to word
   * 
   * @param num the user's number between 1 and 9
   * @param word the user's number as a word
   */
  public static void onesNum(String num, String word) {
    //Converting to number
    if (num.charAt(0) == '1') {
      word = "ONE";
    }
    else if (num.charAt(0) == '2') {
      word = "TWO";
    }
    else if (num.charAt(0) == '3') {
      word = "THREE";
    }
    else if (num.charAt(0) == '4') {
      word = "FOUR";
    }
    else if (num.charAt(0) == '5') {
      word = "FIVE";
    }
    else if (num.charAt(0) == '6') {
      word = "SIX";
    }
    else if (num.charAt(0) == '7') {
      word = "SEVEN";
    }
    else if (num.charAt(0) == '8') {
      word = "EIGHT";
    }
    else {
      word = "NINE";
    }
    outputDialog(num, word);
  }
  /**
   * Converts number from 10 to 19 to word
   * 
   * @param num the user's number between 10 and 19
   * @param word the user's number as a word
   */
  public static void teensNum(String num, String word) {
    //Converting number
    if (num.charAt(1) == '0') {
      word = "TEN";
    }
    else if (num.charAt(1) == '1') {
      word = "ELEVEN";
    }
    else if (num.charAt(1) =='2') {
      word = "TWELVE";
    }
    else if (num.charAt(1) == '3') {
      word = "THIRTEEN";
    }
    else if (num.charAt(1) == '4') {
      word = "FOURTEEN";
    }
    else if (num.charAt(1) == '5') {
      word = "FIFTEEN";
    }
    else if (num.charAt(1) == '6') {
      word = "SIXTEEN";
    }
    else if (num.charAt(1) == '7') {
      word = "SEVENTEEN";
    }
    else if (num.charAt(1) == '8') {
      word = "EIGHTTEEN";
    }
    else {
      word = "NINETEEN";
    }
    outputDialog(num, word);
  }
  /**
   * Converts user's number between 20 and 99 to words
   * 
   * @param num the user's number between 20 and 99
   * @param word the user's number as a word
   */
  public static void tensNum(String num, String word) {
    //Converting tens digit to word
    if (num.charAt(0) == '2') {
      word = "TWENTY-";
    }
    else if (num.charAt(0) == '3') {
      word = "THIRTY-";
    }
    else if (num.charAt(0) == '4') {
      word = "FOURTY-";
    }
    else if (num.charAt(0) == '5') {
      word = "FIFTY-";
    }
    else if (num.charAt(0) == '6') {
      word = "SIXTY-";
    }
    else if (num.charAt(0) == '7') {
      word = "SEVENTY-";
    }
    else if (num.charAt(0) == '8') {
      word = "EIGHTY-";
    }
    else {
      word = "NINETY-";
    }
    //Converting ones digit to word
    if (num.charAt(1) == '1') {
      word += "ONE";
    }
    else if (num.charAt(1) == '2') {
      word += "TWO";
    }
    else if (num.charAt(1) == '3') {
      word += "THREE";
    }
    else if (num.charAt(1) == '4') {
      word += "FOUR";
    }
    else if (num.charAt(1) == '5') {
      word += "FIVE";
    }
    else if (num.charAt(1) == '6') {
      word += "SIX";
    }
    else if (num.charAt(1) == '7') {
      word += "SEVEN";
    }
    else if (num.charAt(1) == '8') {
      word += "EIGHT";
    }
    else {
      word += "NINE";
    }
    outputDialog(num, word);
  }
  /**
   * Outputs users number as a word
   * 
   * @param num the users number in numneric characters
   * @param word the user's number in letters
   */
  public static void outputDialog(String num, String word) {
    JOptionPane.showMessageDialog(null, "Your number, " + num + ", can also be written as " + word + ".",
                                  "Result", JOptionPane.PLAIN_MESSAGE);
  }
}
