/**
 * This program stores inputted temperatures in an array and displays it to the user, alongside the weekly average
 * 
 * @author Cameron Rodriguez
 * @verson 1.0 07/17/17
 */

import javax.swing.*;
public class TempStatsRodC {
  
  /** @param args the command line arguments */
  public static void main(String[] args) { 
    //DECLARING VARIABLES
    String day[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; //Days of the week
    String temp[] = new String[7]; //Stores temperature for each day of week
    int exitRequest; //Determines if program will be ended early
    int restart; //Allows for program to be restarted
    String text; //Displays temperatures and days to user
    
    //Introduce program to user
    introProgram();
    
    //Initializing early exit/restart loop
    exit: //Allows for user to exit program early
    do {
      //INPUT - populate array with temperatures
      temp = inputTemperatures(day, temp);
    
      //End program if requested 
      exitRequest = checkToEndProgram(temp);
      if (exitRequest == 1) {
        restart = 99;
        break exit;
      }
      
      //PROCESSING - Generate text block
      text = generateOutputText(day, temp);
      
      //OUTPUT - Display text to user
      displayTemperatures(text);
      
      //Ask to restart
      restart = askToRestart();
    }
    while (restart == JOptionPane.YES_OPTION);
  }
  
  /**
   * Introduces the program to the user
   */
  public static void introProgram() {
    JOptionPane.showMessageDialog(null, "This is the Temperature Compiler. Enter the high temperatures for each day,"
                                  + "\nof a week, and this program will return all of the temperatures and days.",
                                  "Temperature Compiler", JOptionPane.INFORMATION_MESSAGE);
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
    exit: //Allows for program to be ended early
    while (counter < 7) {
      //Input data & valid input loop
      do {
        temp[counter] = JOptionPane.showInputDialog(null, "Please enter the highest temperature on " + day[counter] + ":",
                                                    "Enter Temperature", JOptionPane.QUESTION_MESSAGE);
        validInput = checkValidInput(temp, counter);
        //End program early check
        if (validInput == 100) {
          break exit;
        }
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
    if (input[element] == null || input[element].length() == 0 || !input[element].matches("[0-9]+")) {
      continueKill = JOptionPane.showOptionDialog(null, "A temperature was not entered. Would you like to try again?",
                                                    "Temperature Not Entered", JOptionPane.YES_NO_OPTION,
                                                    JOptionPane.ERROR_MESSAGE, null, options, options[0]);
      //Determine if user wishes to continue or end program
      if (continueKill == JOptionPane.YES_OPTION) {
        valid = JOptionPane.YES_OPTION;
      }
      else {
        valid = 100; /* When this option is selected, it is returned through the input method to the main method,
                      * causing it to be broken and ending the program. */
      }
    }
    else {
      valid = 99;
    }
    return valid;
  }
  
  /**
   * Checks if user wants to end program early
   * 
   * @param temp the array containing thepossible exit data
   * @return if program should end early
   */
  public static int checkToEndProgram(String[] temp) {
    int killProgram = 99; //Returns if program should end
    int counter = 0; //The counter to check each line
    //Checking array
    while (counter < temp.length) {
      if (temp[counter] == null) {
        killProgram = 1;
      }
      counter++;
    }
    return killProgram;
  }
  
  /**
   * Generates and returns text to be displayed to user
   * 
   * @param day an array with teh days of the week
   * @param temp the array with the temperatures
   * @return the text to be dislpayed
   */
  public static String generateOutputText(String[] day, String[] temp) {
    String text = "Here are the temperatures:" + "\n"; //The text to be returned
    int element = 0; //The integer to tell the arrays which element to display
    //Beginning text generation loop
    while (element < 7) {
      text += "\nThe daily high temperature on " + day[element] + " was " + temp[element] + ".";
      element++;
    }
    //Determine average temperature
    text += determineAvgTemp(temp);
    
    return text; 
  }
  
  /**
   * Return a text form of the average temperature
   * 
   * @param temp an array of all temperatures
   * @return the text of the average temperature
   */
  public static String determineAvgTemp(String[] temp) {
    int average = 0; //The average temperature for the week
    int element = 0; //The element to be added
    String text; //The text to be returned
    //Adding all temps
    while (element < temp.length) {
      average += Integer.parseInt(temp[element]);
      element++;
    }
    //Division to find average
    average /= temp.length;
    //Generate text
    text = "\n\nThe average temperature for the week was " + average + ".";
    //Return text with average
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
  
  /**
   * Returns if user wants program restarted
   * 
   * @return if the user wants to restart
   */
  public static int askToRestart() {
    Object options[] = {"Yes", "No"};
    int restart = JOptionPane.showOptionDialog(null, "Would you like to restart this program?", "Restart?",
                                               JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null,
                                               options, options[1]);
    return restart;
  }
}
