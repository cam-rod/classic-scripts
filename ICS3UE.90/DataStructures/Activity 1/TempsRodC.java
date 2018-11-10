/**
 * This program stores inputted temperatures in an array and displays it to the user
 */

import javax.swing.*;
public class TempsRodC {
  
  /** @param args the command line arguments */
  public static void main(String[] args) { 
    //DECLARING VARIABLES
    String day[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; //Days of the week
    String temp[] = new String[7]; //Stores temperature for each day of week
    String text; //Displays temperatures and days to user
    
    //Introduce program to user
    introProgram();
    
    //INPUT - populate array with temperatures
    temp = inputTemperatures(day, temp);
    
    //PROCESSING - Generate text block
    text = generateText(day, temp);
    
    //OUTPUT - Display text to user
    displayTemperatures(text);
  }
  
  /**
   * Introduces the program to the user
   */
  public static void introProgram() {
    JOptionPane.showMessageDialog(null, "This is the Temperature Compiler. Enter the high temperatures for each day,"
                                  + "\nof a week, and this program will return all of the temperatures and dates in"
                                  + "\n a format that's easy to copy and paste anywhere!", "Temperature Compiler",
                                  JOptionPane.INFORMATION_MESSAGE);
  }
  
   /**
    * User inputs temperatures on each day and method returns array of temperatures
    * 
    * @param day the array with days of the week
    * @param temp the array to hold the temperatures
    * @return the array with the temperatures
    */
  public static String[] inputTemperatures(String[] day, String[] temp) {
    int counter = 0; //Signals which array element to display or store data in
    int validInput;
    //Main data entry loop
    while (counter < 7) {
      //Input data & valid input loop
      do {
        temp[counter] = JOptionPane.showInputDialog(null, "Please enter the highest temperature on " + day[counter] + ":",
                                                    "Enter Temperature", JOptionPane.QUESTION_MESSAGE);
        validInput = checkValidInput(temp, counter);
      }
      while (validInput == JOptionPane.YES_OPTION);
      //Increase counter
      counter++;
    }
    return temp;
  }
  
  /**
   * Checks and returns if input is valid
   * 
   * @param input the data inputted in the array
   * @param element the number corresponding to the element to check
   * @return if input was valid
   */
  public static int checkValidInput(String[] input, int element) {
    int valid = 99; //Integer to return validity of input
    int continueKill; //Determines if user wants to try again or end program
    Object[] options = {"Re-enter temperature", "End this program"}; //Options for continueKill
    //Validation if structure
    if (input[element] == null || input[element].length() == 0) {
      continueKill = JOptionPane.showOptionDialog(null, "A temperature was not entered. Would you like to try again?",
                                                    "Temperature Not Entered", JOptionPane.YES_NO_OPTION,
                                                    JOptionPane.ERROR_MESSAGE, null, options, options[0]);
      //Determine if user wishes to continue or end program
      if (continueKill == JOptionPane.YES_OPTION) {
        valid = JOptionPane.YES_OPTION;
      }
      else {
        System.exit(0);
      }
    }
    else {
      valid = 99;
    }
    return valid;
  }
  
  /**
   * Generates and returns text to be displayed to user
   * 
   * @param day an array with teh days of the week
   * @param temp the array with the temperatures
   * @return the text to be dislpayed
   */
  public static String generateText(String[] day, String[] temp) {
    String text = "Here are the temperatures."
                  + "\n\nTo copy them, click and drag over the text you want. Then hold the"
                  + "\nControl key (or Command key on a Mac), and tap C. You can now paste"
                  + "\nthe data anywhere you want, using Control + V (or Command + V)." + "\n"; //The text to be returned
    int element = 0; //The integer to tell the arrays which element to display
    //Beginning text generation loop
    while (element < 7) {
      text += "\nThe daily high temperature on " + day[element] + " was " + temp[element] + ".";
      element++;
    }
   return text; 
  }
  
  /**
   * Displays temperatures to user in JTextArea
   * 
   * @param text the text to be displayed
   */
  public static void displayTemperatures(String text) {
    JOptionPane.showMessageDialog(null, new JTextArea(text), "Temperatures", JOptionPane.INFORMATION_MESSAGE);
  }
}
