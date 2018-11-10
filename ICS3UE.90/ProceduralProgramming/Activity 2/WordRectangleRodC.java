/**
 * This program creates a rectangle of characters from a given word, shifting characters left on each line
 * 
 * @author Cameron Rodriguez
 */

import javax.swing.*; //Importing Swing toolkit
public class WordRectangleRodC {
  
 /** @param args the command line arguments */
  public static void main(String[] args) { 
    //DECLARING VARIABLES
    int restart = 99; //Variable which restarts program if requested (99 for necessary initialization)
    Object[] restartOptions = {"Yes", "No"}; // Options for the restart menu
    String wordInput; //The user's inputted word
    String wordInputCaps; ///The inputted word is uppercase letters
    String rectangle = "Here is your word rectangle:"; //The outputted word rectangle
    
    //Introduce program to user
    introductionDialog();
    
    //Initializing restart do-while loop
    do {
      //USER INPUTS WORD
      wordInput = JOptionPane.showInputDialog(null, "Please enter the word you would like to use:", "Enter Word",
                                              JOptionPane.QUESTION_MESSAGE);
      //Initializing input failure if loop
      if (wordInput != null && wordInput.length() > 0) {
        //PROCESSING & OUTPUT TO USER
        wordInputCaps = wordInput.toUpperCase();
        rectangleGenerator(wordInputCaps, rectangle);
        
        //Restart option
        restart = JOptionPane.showOptionDialog(null, "Would you like to enter another word rectangle?",
                                               "Generate New Rectangle?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                                               null, restartOptions, restartOptions[0]);
      }
      else { //Input was blank or cancel was selected
        restart = JOptionPane.showOptionDialog(null, "A word was not inputted. Would you like to try again?",
                                               "Word Not Entered", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                                               null, restartOptions, restartOptions[0]);
      }
    }
    while (restart == JOptionPane.YES_OPTION);
  }
  /** This method's dialog introduces the program to the user */
  public static void introductionDialog() {
    JOptionPane.showMessageDialog(null, "Welcome to the Word Rectangle Generator. This program will allow you"
                                  + "\n to enter a word, and then the program will display a rectangle made up"
                                  + "\n of that word.", "Word Rectangle Generator", JOptionPane.INFORMATION_MESSAGE);
  }
  /**
   * Generates a rectangle from an inputted word
   * 
   * @param word the word to generate the rectangle with
   * @param rectangle the word rectangle
   */
  public static void rectangleGenerator(String word, String rectangle) {
    //Initializing rectangle generation for loop
    for (int line = 1; line <= word.length(); line++) {
      //Concantenting word to word rectangle
      rectangle += "\n" + word;
      //Adding first letter to end of substring of other letters
      word = word.substring(1) + word.charAt(0);
    }
    //OUTPUT
    displayRectangle(rectangle);
  }
  /**
   * Displays the word rectangle to the user
   * 
   * @param rectangle the word rectangle
   */
  public static void displayRectangle(String rectangle) {
    JOptionPane.showMessageDialog(null, new JTextArea(rectangle), "Word Rectangle", JOptionPane.PLAIN_MESSAGE);
  }
}