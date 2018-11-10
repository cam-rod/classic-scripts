/**
 * This program will generate a specified number of integers between 1 and 1000, with their range as well.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/18/17
 */

import javax.swing.*;
public class RandomNumbersRodC {
  
  /** @param args the commans line arguments */
  public static void main(String[] args) { 
    //Declaring variables
    int userRequest; //The requested number of integers
    int randNums[]; //The array of randomly generated numbers
    int numsRange; //The range of the numbers
    String text; //The text to be displayed
    int restart = JOptionPane.YES_OPTION; //Allows user to restart the program
    
    //Introducing program
    introProgram();
    
    //Initializing restart loop
    while (restart == JOptionPane.YES_OPTION) {
      //User inputs requested number of integers
      userRequest = inputNumberOfInt();
      
      //Ends program if requested
      if (userRequest == JOptionPane.CLOSED_OPTION) {
        break;
      }
        
      //Generate array of random integers
      randNums = generateRandInt(userRequest);
      
      //Determine range of integers
      numsRange = determineRange(randNums);
      
      //Generate block of text to be displayed
      text = generateOutputText(userRequest, randNums, numsRange);
      
      //Display information to user
      outputResults(text);
      
      //Restart program if requested
      restart = askToRestart();
    }
  }
  
  /** Introduces the program to the user. */
  public static void introProgram() {
    JOptionPane.showMessageDialog(null, "Welcome to the Random Number Generator."
                                  + "\n\nThis program will generate a specified number of integers between 1 and 1000,"
                                  + "\nand will display those numbers and their range.", "Random Number Generator",
                                  JOptionPane.INFORMATION_MESSAGE);
  }
  /**
   * Returns the user's requested number of random integers
   * 
   * @return the user's requested number of integers
   */
  public static int inputNumberOfInt() {
    String userRequestText; //Will recieve the string form of the user's request
    int userRequestInt; //Will return the requested number of integers
    
    //Initializing valid entry loop
    do {
      userRequestText = JOptionPane.showInputDialog(null, "Please enter how many random numbers you would like:",
                                                    "Enter A Number", JOptionPane.QUESTION_MESSAGE);
      userRequestInt = checkValidEntry(userRequestText); //Checks for valid input
    }
    while (userRequestInt == JOptionPane.YES_OPTION); //Indicates to retry entry
    return userRequestInt;
  }
  
  /**
   * Returns if input was valid and action to take if otherwise
   * 
   * @param input the user's input
   * @return if input was valid or how to act otherwise
   */
  public static int checkValidEntry(String input) {
    int result = 0; //Returns user input or otherwise
    if (input == null || !input.matches("[0-9]+") || Integer.parseInt(input) <= 0) { //No number above 0 inputted
      Object options[] = {"Re-enter the number", "End this program"};
      result = JOptionPane.showOptionDialog(null, "Sorry, but that was not a valid input. If you wish to try again,"
                                            + "\nplease enter a number greater than 0."
                                            + "\n\nWould you like to re-enter the number or end this program?",
                                            "Invalid Entry", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                                            null, options, options[0]);
      //Restart/end program check loop
      if (result != JOptionPane.YES_OPTION) {
        result = JOptionPane.CLOSED_OPTION; /* Will return through to main method and break program loop, ending the program
                                             * This is necessary to avoid a integer dedicated to closing the program cancelling
                                             * a valid entry. */
      }
    }
    else {
      result = Integer.parseInt(input);
    }
    return result;
  }
  
  /**
   * Returns an array of randomly generated integers between 1 and 1000.
   * 
   * @user the user's requested number of integers to be generated
   * @return the array of integers
   */
  public static int[] generateRandInt(int user) {
    int randNums[] = new int[user]; //The array to hold the randomly generated integers
    int element = 0; //The element slot to be filled
    //Initializing integer generation loop
    while (element < randNums.length) {
      randNums[element] = (int) ((Math.random() * 1000) + 1);
      element++;
    }
    return randNums;
  }
  
  /**
   * Return the range of the random integers
   * 
   * @param nums the array of the integers
   * @return the range of the integers
   */
  public static int determineRange(int[] nums) {
    int element = 0; //Indicates the element to check
    int high = 0; //The highest integer generated
    int low = 1001; //The lowest integer generated
    //Begin high number loop
    while (element < nums.length) {
      if (nums[element] > high) {
        high = nums[element];
      }
      element++;
    }
    element = 0; //Reset element for next check
    //Begin low number loop
    while (element < nums.length) {
      if (nums[element] < low) {
        low = nums[element];
      }
      element++;
    }
    return high - low;
  }
  
  /**
   * Returns the block of text to be displayed
   * 
   * @param request the user's requested number of integers
   * @param nums the array of randomly generated integers
   * @param range the range of the integers
   * @return the text containing all the data
   */
  public static String generateOutputText(int request, int[] nums, int range) {
    String text = "Here are the " + request + " numbers between 1 and 1000 that you requested." + "\n\n"; //The text to be returned
    int element = 0; //The element from the integer's range to be displayed. Also limits display to 20 integers per line.
    //Initializing integer display generation loop
    while (element < nums.length) {
      text += nums[element];
      element++;
      //Adds comma unless is last integer
      if (element < nums.length) {
        text += ", ";
      }
      //Starts new line if necessary (after 35 integers, unless it is the last integer)
      if (element % 35 == 0 && element < nums.length) {
        text += "\n";
      }
    }
    //Adding information on range
    text += "\n\nThe range of the integers is " + range + ".";
    return text;
  }
  
  /**
   * Outputs results to user
   * 
   * @param text the text to be displayed
   */
  public static void outputResults(String text) {
    JOptionPane.showMessageDialog(null, text, "Results", JOptionPane.PLAIN_MESSAGE);
  }
  
  /**
   * Return if user wants to restart program
   * 
   * @return if program should be restarted
   */
  public static int askToRestart() {
    Object options[] = {"Yes", "No"};
    return JOptionPane.showOptionDialog(null, "Would you like another set of integers?", "Restart?", JOptionPane.YES_NO_OPTION,
                                        JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
  }
}