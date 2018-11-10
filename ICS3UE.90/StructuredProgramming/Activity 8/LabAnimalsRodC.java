/**
 * "Animal Population Survival Calculator
 * 
 * This program calculates the availablity of food based on the animal population.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/11/17
 */
//Importing toolkits
import javax.swing.*;

public class LabAnimalsRodC {
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    for (int restart = 0; restart == 0;) { //Restarts program if user selects yes
      /* TEACHER NOTES: all variables outside loop, more clear
       * add 1 to restart each time, do math <restart = restart[1] + 
       */
      //Introducing variables
      int hour = 0;
      int popS, foodS, foodAdd; //User input on initial population and food values, and food rate of increase
      int popE; //Population at end of hour
      int foodE = 0; //Food supply at end of hour preset to 0
      String table = "Hour\tAnimals At Start\t\tFood At Start\t\tFood At End\t\tAnimals At End"; /* Output of calculations is displayed
                                                                                                  * to user with this variable */
    
      //Introducing program
      JOptionPane.showMessageDialog(null, "The population of a animal starts at a certain number. Every hour, the"
                                    + "\npopulation doubles. Additionally, the animals are given a certain amount"
                                    + "\nof food to start with, which increases by another amount every hour. Each"
                                    + "\nanimal eats one food item every hour."
                                    + "\n\nThis program will determine the point at which the population outgrows its"
                                    + "\nfood supply.", "Animal Population Survival Calculator",
                                    JOptionPane.INFORMATION_MESSAGE);
    
      /* TEACHER NOTE: Cancel button crashes program: intercept with <if (popStartHour == null) {
       * System.exit(0);
       * }
       * BEFORE INTEGER IS PARSED
       * ----OR----
       * Label the first loop [ex. hey: \n for () {] and break there [ex. break hey]
       */
      //Get initial population from user
      String popStartHour = JOptionPane.showInputDialog(null, "Please enter the size of the initial animal population:",
                                                        "Enter Starting Population", JOptionPane.QUESTION_MESSAGE);
      popS = Integer.parseInt(popStartHour);
      
      //Get initial food supply from user
      String foodStartHour = JOptionPane.showInputDialog(null, "Please enter the initial food supply:", "Enter Food Supply",
                                                         JOptionPane.QUESTION_MESSAGE);
      foodS = Integer.parseInt(foodStartHour);
      
      //Get rate of food supply from user
      String foodIncrease = JOptionPane.showInputDialog(null, "Please enter the amount of food to be replenished each hour:",
                                                        "Enter Food Supply Rate", JOptionPane.QUESTION_MESSAGE);
      foodAdd = Integer.parseInt(foodIncrease);
      
      // Calculate population growth and food growth/consumption
      for (popE = 0; popE <= foodE;) {
        hour++;
        popE = popS * 2; //TEACHER NOTE: THIS should be in the <for> bracket
        foodE = foodS + foodAdd - popS;
        table = table + "\n" + hour + "\t" + popS + "\t\t" + foodS + "\t\t" + foodE + "\t\t" + popE;
        popS = popE;
        foodS = foodE;
      }
      
      //Display results to user
      JOptionPane.showMessageDialog(null, new JTextArea("Here are the results:" + "\n" + table
                                    + "\n\nBy the end of hour " + hour + ", the population will outgrow its food supply."
                                    + "\nBy this point, the environment becomes survival of the fittest."), "Results",
                                    JOptionPane.PLAIN_MESSAGE);
      
      //Restart program dialog
      Object[] restartOptions = {"Yes", "No"};
      restart = JOptionPane.showOptionDialog(null, "Would you like to run the program again?", "Restart program?",
                                             JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                             restartOptions, restartOptions[0]);
    }
    System.exit(0); //TEACHER NOTE: remove this line
  }
}
