package examreview;

/*
 * This program calculates profits based on the price and quantity of a product sold.
 * 
 * @author Cameron Rodriguez
 * @version 1.1
 */
import java.io.*;
import java.text.*;
public class Final7 {
  //Initializing Decimal Format and Input Stream Reader
  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  static DecimalFormat cents = new DecimalFormat("#,##0.00");
  
  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    int modelNumber = 0; //Indicates which element to populate
    String modelName[] = {"Value", "SOHO", "Gamer", "Total"}; //Model names
    double costIdv; //Cost of a system
    int totalSold[]  = new int[3]; //The array of the quantities of systems sold
    double price[] = new double[3]; //The array of prices paid by customer
    double costTotal; //The cost to produce all of the systems produced
    double revenue[] = new double[3]; //The array of revenue totals from each system
    double profit[] = new double[3]; //The array of profits from each system
    
    //Introduces the program
    introProgram();
    
    //Inititalizing system arrays population loop
    while (modelNumber < 3) {
      //Get cost to produce system
      costIdv = inputCost(modelName[modelNumber]);
      //Get quantity of systems sold
      totalSold[modelNumber] = inputTotalSold(modelName[modelNumber]);
      //Determine price paid by consumer
      price[modelNumber] = calculatePrice(modelNumber, costIdv);
      
      //Calculate revenue and profits
      costTotal= costIdv * totalSold[modelNumber];
      revenue[modelNumber] = price[modelNumber] * totalSold[modelNumber];
      profit[modelNumber] = revenue[modelNumber] - costTotal;
      
      //Increase array element
      modelNumber++;
    }
    //Display monthly summary to user
    displayResults(modelName, price, totalSold, revenue, profit);
  }
  
  /**
   * Introduces the program to the user, with instructions.
   */
  public static void introProgram() {
    System.out.println("MARKUP MANAGER");
    System.out.println("==============");
    System.out.println("Welcome to the Markup Manager. This program will determine total");
    System.out.println("revenue and profits from the sale of a product at a certain quantity");
    System.out.println("markup.");
    System.out.println("");
    System.out.println("Simply input the cost to manufacture each system, and the quantity");
    System.out.println("of systems sold in the month, and this system will display a summary");
    System.out.println("of the month's revenue and profits, for each system and for all");
    System.out.println("systems combined.");
    System.out.println("");
  }
  
  /**
   * Returns the cost to build the system
   * @param modelName the name of the system to input the cost for
   * @return the cost to build the system
   * @throws IOException 
   */
  public static double inputCost(String modelName) throws IOException {
    //Ask user to input cost
    System.out.println("Please enter the cost to manufacture the " + modelName + " system:");
    
    //Get cost of system
    double costIdv = Integer.parseInt(input.readLine());
    System.out.println("");
    
    //Return system cost
    return costIdv;
  }
  
  /**
   * Returns the quantity of systems sold
   * @param modelName the name of the system to input the quantity of systems sold
   * @return the quantity of systems sold
   * @throws IOException 
   */
  public static int inputTotalSold(String modelName) throws IOException {
    //Ask user to enter quantity
    System.out.println("Please enter the quantity of " + modelName + " systems sold:");
    
    //Get number of systems sold
    int totalSold = Integer.parseInt(input.readLine());
    System.out.println("");
    
    //Return quantity of systems sold
    return totalSold;
  }
  
  /**
   * Calculates the selling price of the system
   * @param modelNumber the number designating the system the cost corresponds to
   * @param costIdv the cost to build a system
   * @return the system's selling price
   */
  public static double calculatePrice(int modelNumber, double costIdv) {
    double price; //The price of the system
    
    if (modelNumber == 0) { //Value system
      price = costIdv * 1.25;
    }
    else if (modelNumber == 1) { //SOHO system
      price = costIdv + (costIdv / 3);
    }
    else { //Gamer system
      price = costIdv * 1.5;
    }
    //Return selling price
    return price;
  }
  
  /**
   * Displays monthly statement to user
   * @param modelName the array of model names
   * @param price the array of selling prices
   * @param totalSold the array of quantities of systems sold
   * @param revenue the array of revenue made by each system
   * @param profits the array of profits made by each system
   */
  public static void displayResults (String[] modelName, double[] price, int[] totalSold,
                                     double[] revenue, double[] profits) {
    int e = 0; //Determines which element from the array to display
    System.out.println("Monthly Summary:");
    System.out.println("~~~~~~~~~~~~~~~~");
    System.out.println("Model\t\tSelling\t\t\t# of\t\trevenue\t\t\tprofits");
    System.out.println("Name\t\tPrice\t\t\tunits");
    System.out.println("~~~~~\t\t~~~~~~~\t\t\t~~~~\t\t~~~~~~~\t\t\t~~~~~~~");
    while (e < price.length) { //Display data from each system
      System.out.println(modelName[e] + "\t\t$" + cents.format(price[e]) + "\t\t"
                         + totalSold[e] + "\t\t$" + cents.format(revenue[e]) + "\t\t$"
                         + cents.format(profits[e]));
      e++;
    }
    //Add totals of each component and display overall totals
    System.out.println("Total\t\tN/A\t\t\t" + (totalSold[0] + totalSold[1] + totalSold[2])
                       + "\t\t$" + cents.format(revenue[0] + revenue[1] + revenue[2])
                       + "\t\t$" + cents.format(profits[0] + profits[1] + profits[2]));
  }
}