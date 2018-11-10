//Importing toolkits
import java.io.*;
import java.text.*;

/*
 * Programmer: Cameron Rodriguez
 * Date: July 8, 2017
 */

/** Program Description: This program will display information about the planned reduction of Canadian debt. */
public class DebtBurdenRodC {
  
  /** 
   * Generates and displays predicted debt in command line
   * 
   * @param args the command line arguments
   */
  public static void main(String[] args) throws IOException { 
    //Declaring variables
    double debt2007 = 481.5;
    double debt2008, debt2009, debt2010;
    
    //Creating decimal format
    DecimalFormat oneDigit = new DecimalFormat ("#,##0.0");
    
    /** Calculates debt for each year based on rate of decrease */
    debt2008 = 0.97 * debt2007;
    debt2009 = 0.97 * debt2008;
    debt2010 = 0.97 * debt2009;
    
    /** Displays information on debt to user in command line */
    System.out.println ("In 2007, Canada held a massive debt of $" + oneDigit.format (debt2007) + " billion. However, the");
    System.out.println ("federal government hoped to reduce this debt at a rate of 3% a year.");
    System.out.println (""); //Lines 32, 33 BEFORE calcuations
    System.out.println ("Under this plan, the debt would have been reduced to $" + oneDigit.format (debt2008) + " billion");
    System.out.println ("in 2008. In 2009, the debt burden would have been reduced again to");
    System.out.println ("$" + oneDigit.format (debt2009) + " billion. In 2010, another 3% reduction would have lowered the");
    System.out.println ("national debt to $" + oneDigit.format (debt2010) + " billion.");
  }
}
