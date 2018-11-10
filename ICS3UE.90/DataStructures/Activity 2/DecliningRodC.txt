/**
 * Generates an array of declining attendance to religious services and displays attendance in a given year to user.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 
 */

import javax.swing.*;
import java.text.*;
public class DecliningRodC {
  
  /** @param args the command line arguments */
  public static void main(String[] args) {
    //Declaring variables
    int year[] = new int[41]; //The array to store the years 1985-2025
    double attendance[] = new double[41]; //The array to store attendance rates in the years 1985-2025
    int userYear; //The year selected by the user
    double userAttendance; //The attendance rate for the year selected by the user
    int restart = JOptionPane.YES_OPTION; //Allows user to restart program
    
    //Generate arrays
    year = generateYearArray();
    attendance = generateAttendanceArray();
    
    //Introduce program to user
    introProgram();
    
    while (restart == JOptionPane.YES_OPTION) {
      //User inputs year
      userYear = inputYear();
      
      //End program if requested
      if (userYear == 1) {
        break;
      }
      
      //Process requested year and get attendance rate
      userAttendance = determineAttendanceRate(year, attendance, userYear);
      
      //Output data to user
      displayResults(userYear, userAttendance);
      
      restart = askToRestart();
    }
  }
  
  /**
   * Returns the array of years
   * 
   * @return the array of years
   */
  public static int[] generateYearArray() {
    int year[] = new int[41]; //Array of years from 1985 to 2025
    year[0] = 1985;
    for (int element = 0; element < year.length; element++) { //Must subtract 1 since first year is preprogrammed
      year[element] = 1985 + (element); //Adds the value of the element to the starting year (1985)
    }
    return year;
  }
  
  /**
   * Returns the array of attendance rates
   * 
   * @return the atendance rates
   */
  public static double[] generateAttendanceArray() {
    double attendance[] = new double[41]; //Array of attendance percentages
    attendance[0] = 30; //Percent attendance in element 0 (1985)
    for (int element = 0; element < attendance.length; element++) { //Must subtract  since first rate is preprogrammed
      attendance[element] = 30 - (0.35 * element); //Subtractsthe poduct of 0.35(%) and the element's value from the starting 30%
    }
    return attendance;
  }
  
  /** Introduces the program to the user */
  public static void introProgram() {
    JOptionPane.showMessageDialog(null, "In recent years, the number of people who attend a religious service on a"
                                  + "\nweekly basis has been slowly, but steadily, declining since 1985. This program will"
                                  + "\ndisplay the expected church attendance rate for any year between 1985 and 2025.",
                                  "Declining Church Attendance", JOptionPane.INFORMATION_MESSAGE);
  }
  
  /**
   * Return user-inputted year
   * 
   * @return the user's year
   */
  public static int inputYear() {
    int year = 99; //Integer which returns user's requested year
    //Initializing valid input loop
    do {
      //Enter year
      String yearText = JOptionPane.showInputDialog(null, "Please enter a year from 1985 to 2025 inclusive:", "Enter a Year",
                                                JOptionPane.QUESTION_MESSAGE);
      //Valid input/early exit check
      yearText = checkValidInput(yearText);
      //Parse as integer
      year = Integer.parseInt(yearText);
    }
    while (year == 0);
    return year;
  }
  
  /**
   * Returns if input was valid and if user wants to reenter a year.
   * 
   * @param input the user's input
   * @return if the input was valid or if to have the user re-enter their data
   */
  public static String checkValidInput(String input) {
    //Checks for blank entry field/cancel/close button, non-numeric input, and for a number not between 1985 and 2025
    if (input == null  || !input.matches("[0-9]+") || Integer.parseInt(input) < 1985 || Integer.parseInt(input) > 2025) {
      Object options[] = {"Re-enter the year", "End this program"};
      int errorMenu = JOptionPane.showOptionDialog(null, "Sorry, but that wasn't a valid entry. You must enter a year"
                                           + "\nbetween 1985 and 2025. Would you like to re-enter the year or"
                                           + "\nend this program?", "Invalid Entry", JOptionPane.YES_NO_OPTION,
                                           JOptionPane.ERROR_MESSAGE, null, options, options[0]);
      //Exit program check
      if (errorMenu == JOptionPane.YES_OPTION) {
        input = "0"; //Will cause the input menu to reappear
      }
      else {
        input = "1"; //Will return through the input to the main method where it will break the restart loop
      }
    }
    return input;
  }
  
  /**
   * Return the attendance rate for the user's selected year
   * 
   * @param year the array of years
   * @param attendance the array of attendance rates
   * @param userYear the user's selected year
   * @return the user's attendance rate
   */
  public static double determineAttendanceRate(int[] year, double[]attendance, int userYear) {
    int element = 0; //The element to be checked
    int correctYear = 0; //Tells loop if year was correct
    while (correctYear != 1) {
      if (userYear == year[element]) {
        correctYear = 1;
      }
      else {
        element++;
      }
    }
    return attendance[element];
  }
  
  /**
   * Displays results to user
   * 
   * @param year the user's selected year
   * @param attendance the attendance rate for the selected year
   */
  public static void displayResults(int year, double attendance) {
    DecimalFormat two = new DecimalFormat ("#,##0.00");
    JOptionPane.showMessageDialog(null, "In the year " + year + ", " + two.format(attendance) + "% of Canadians attended a religious"
                                    + "\nservice on a weekly basis.", "Attendance Rate", JOptionPane.PLAIN_MESSAGE);
  }
  
  /**
   * Returns if user wants to restart program
   * 
   * @return if user wants to restart program
   */
  public static int askToRestart() {
    Object options[] = {"Yes", "No"};
    int restart = JOptionPane.showOptionDialog(null, "Would you like to enter another year?", "Enter Another Year?",
                                               JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
                                               options[0]);
    return restart;
  }
}
