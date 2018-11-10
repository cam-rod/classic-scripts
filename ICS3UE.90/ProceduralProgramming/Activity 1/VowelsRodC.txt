/**
 * "Vowel Counter"
 * 
 * This program counts voxels in an inputted and displays it to the user
 * 
 * @author Cameron Rodriguez
 * @version 1.0 
 */
//Importing Swing input
import javax.swing.*;
  
public class VowelsRodC {
  
  /**
    * @param args the command line arguments 
    */
  public static void main(String[] args) { 
    //Declaring variables
    int restart = JOptionPane.YES_OPTION; //The interger whihc restarts the program if requested
    Object[] restartOptions = {"Yes", "No"}; //The options for the restart menu
    String wordSentence; //The user's word to be checked
    String wordSentenceLower; //Conversion of phrase to lowercase for simplified processing
    int letters; //The series number of the letter to be checked for vowel
    int vowels = 0; //Number of vowels located
    
    //Introducing program to user
    JOptionPane.showMessageDialog(null, "Welcome to the Vowel Counter. This program will take a word or sentence"
                                  + "\nand determine how many vowels it contains (not including y).", "Vowel Counter",
                                  JOptionPane.INFORMATION_MESSAGE);
      
     //Initializing main program loop
    while (restart == JOptionPane.YES_OPTION) {
      //Get word or sentence from user
      wordSentence = JOptionPane.showInputDialog(null, "Please enter the word or sentence you wish to have checked:",
                                              "Input Words", JOptionPane.QUESTION_MESSAGE);
      
      //Begin vowel check
      if (wordSentence != null && wordSentence.length() > 0) { //If something was inputted or cancel wasn't selected
        
        //Converting to lowercase
        wordSentenceLower = wordSentence.toLowerCase();
        
        for (letters = 0; letters < wordSentenceLower.length(); letters++) { //Loops until letters checked is equal to length of word(s)
          //Checks all possibilities for vowels
          if (wordSentenceLower.charAt(letters) == 'a') {
            vowels++;
          }
          else if (wordSentenceLower.charAt(letters) == 'e') {
            vowels++;
          }
          else if (wordSentenceLower.charAt(letters) == 'i') {
            vowels++;
          }
          else if (wordSentenceLower.charAt(letters) == 'o') {
            vowels++;
          }
          else if (wordSentenceLower.charAt(letters) == 'u') {
            vowels++;
          }
        }
        //Displays results to user
        JOptionPane.showMessageDialog(null, "There are " + vowels + " vowels in the word or sentence you created.",
                                      "Results", JOptionPane.PLAIN_MESSAGE);
        //Asks user if they want to restart program
        restart = JOptionPane.showOptionDialog(null, "Would you like to restart the program?", "Restart?",
                                               JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, restartOptions,
                                               restartOptions[0]);
      }
      //Nothing is inputted or cancel is selected
      else {
        restart = JOptionPane.showOptionDialog(null, "You didn't enter anything into the box."
                                               + "\nWould you like to restart the program?", "Restart?",
                                               JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, restartOptions,
                                               restartOptions[0]);
      }
      vowels -= vowels;
    }
  }
}
