package totaldays;

/**
 * This program will take two dates and calculate how long someone has been working
 *
 * @author Cameron Rodriguez
 * @version 1.0.1
 */

import java.util.Scanner;
public class TotalDays_v1_0_1 {
  static Scanner dateInput = new Scanner(System.in);
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    int startYear, startMonth, startDay; //The starting date
    int endYear, endMonth, endDay; //The ending date
    int totalYears, totalMonths, totalDays; //The time elasped
    
    //Introduce program
    System.out.println("How long have I been ___?");
    System.out.println("=========================");
    System.out.println("This program will determine how long you've been");
    System.out.println("doing something.");
    System.out.println("Firstly, the program will ask when you started. \n");
    
    //Request starting date
    startDay = requestDate(1, 1);
    startMonth = requestDate(1, 2);
    startYear = requestDate(1, 3);
    
    System.out.println("Now, the program will ask when you finished. \n");
    
    //Request ending date
    endDay = requestDate(2, 1);
    endMonth = requestDate(2, 2);
    endYear = requestDate(2, 3);
    
    //Calculating time elasped
    totalYears = calculateYears(startYear, startMonth, startDay, endYear,
                                endMonth, endDay);
    totalMonths = calculateMonths(startMonth, startDay, endMonth, endDay);
    totalDays = calculateDays(startMonth, startDay, endYear, endMonth, endDay);
    
    //Display time elasped to user
    System.out.println("\nThe total time elasped has been " + totalYears + " year(s),");
    System.out.println(totalMonths + " month(s), and " + totalDays + " day(s). \n");
    
    //Outro
    System.out.println("Thanks for using this program. Goodbye! \n");
    System.out.print("Designed by Cameron Rodriguez");
  }
  
  /**
   * Returns the date inputted by the user.
   * @param startEnd
   * @param unit
   * @return the date inputted
   */
  public static int requestDate (int startEnd, int unit) {
    String unitText; //The words relating to each date unit
    int date; //The date the user enters
    //Return unit text
    switch (unit) {
      case 1:  unitText = "(number) date";
               break;
      case 2:  unitText = "month";
               break;
      default: unitText = "year";
    }
    //Request date from user
    switch (startEnd) {
      case 1:  System.out.print("Please enter the " + unitText + " you started: ");
               date = dateInput.nextInt();
               break;
      default: System.out.print("Please enter the " + unitText + " you ended: ");
               date = dateInput.nextInt();
    }
    System.out.println("");
    return date; //Returns inputted date
  }
  
  /**
   * Return the number of years elapsed
   * @param startYear the year the user started
   * @param startMonth the month the user started
   * @param startDay the day the user started
   * @param endYear they year the user ended
   * @param endMonth the month the user ended
   * @param endDay the day the user ended
   * @return the number of years elapsed
   */
  public static int calculateYears (int startYear, int startMonth, int startDay,
                                    int endYear, int endMonth, int endDay) {
    int totalYears; //The number of years elasped
    
    //Calculate years elapsed
    if (endMonth > startMonth || (endMonth == startMonth && endDay >= startDay)) {
      totalYears = endYear - startYear; //Months in same year as starting month or most recent anniversary
    } else {
      totalYears = endYear - startYear - 1;
    }
    return totalYears; //Return total years elasped
  }
  
  /**
   * Return the number of months elapsed
   * @param startMonth the month the user started
   * @param startDay the day the user started
   * @param endMonth the month the user ended
   * @param endDay the day the user ended
   * @return the number of months elapsed
   */
  public static int calculateMonths (int startMonth, int startDay, int endMonth,
                                     int endDay) {
    int totalMonths; //The total months elasped
    //Calculate total months
    if (endMonth < startMonth) { //Months before annual anniversary, not starting year
      if (endDay < startDay) { //Before monthly anniversary
        totalMonths = 11 - (startMonth - endMonth);
      } else { //On or after monthly anniversary
        totalMonths = 12 - (startMonth - endMonth);
      }
    } else { //Months in same year as starting month or most recent anniversary
      if (endDay < startDay) { //Before monthly anniversary
        totalMonths = endMonth - startMonth - 1;
      } else { //On or after monthly anniversary
        totalMonths = endMonth - startMonth;
      }
    }
    return totalMonths; //Return total months elasped
  }
  
  /**
   * Return the number of days elapsed
   * @param startMonth the month the user started
   * @param startDay the day the user started
   * @param endYear they year the user ended
   * @param endMonth the month the user ended
   * @param endDay the day the user ended
   * @return the number of days elapsed
   */
  public static int calculateDays (int startMonth, int startDay,
                                    int endYear, int endMonth, int endDay) {
    int totalDays; //The total number of days elasped
    if (endDay >= startDay) {
      totalDays = endDay - startDay; //End day is in same month as start AND after it
    } else {
      if (startDay >= daysInMonth((endMonth - 1), endYear)) {
        totalDays = endDay; //Start day is on/after last day of penultimate month in end year
      } else { //All other cases
        totalDays = (daysInMonth((endMonth - 1), endYear) - startDay) + endDay;
      }
    }
    return totalDays; //Return the total number of days elasped
  }
  
  /**
   * Returns the number of days in a certain month
   * @param month the month being requested
   * @param year the year being requested
   * @return the number of days in the month
   */
  public static int daysInMonth (int month, int year) {
    int days; //The number of days in the given month
    //Calculate the number of days in the month
    switch (month) {
      case 1: case 3: case 5: case 7: case 8: case 10: case 12:
        days = 31; //Months with 31 days
        break;
      case 4: case 6: case 9: case 11:
        days = 30; //Months with 30 days,except February
        break;
      default:
        if ((year % 4 == 0 && year % 100 != 0)|| year % 400 == 0) {
          days = 29; //February in leap years
        } else {
          days = 28; //February in mo
        }
    }
    return days; //Returns the number of days in the month
  }
}