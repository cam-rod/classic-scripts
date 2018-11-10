package examreview;

/*
 * This program calculates profits based on the price and quantity of a product sold.
 * 
 * @author Cameron Rodriguez
 * @version 1.1
 */
import java.io.*;
import java.text.*;
public class Final6 {
  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  static DecimalFormat cents = new DecimalFormat("#,##0.00");
  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    int modelNumber = 0;
    String modelName[] = {"Value", "SOHO", "Gamer", "Total"};
    double costIdv;
    int totalSold[]  = new int[3];
    double price[] = new double[3];
    double costTotal;
    double revenue[] = new double[3];
    double profit[] = new double[3];
    
    introProgram();
    
    while (modelNumber < 3) {
      
      costIdv = inputCost(modelName[modelNumber]);
    
      totalSold[modelNumber] = inputTotalSold(modelName[modelNumber]);
    
      price[modelNumber] = calculatePrice(modelNumber, costIdv);
    
      costTotal= costIdv * totalSold[modelNumber];
      revenue[modelNumber] = price[modelNumber] * totalSold[modelNumber];
      profit[modelNumber] = revenue[modelNumber] - costTotal;
      
      modelNumber++;
    }
    displayResults(modelName, price, totalSold, revenue, profit);
  }
  
  public static void introProgram() {
    System.out.println("MARKUP MANAGER");
    System.out.println("==============");
    System.out.println("Welcome to the Markup Manager. This program will determine total");
    System.out.println("revenue and profits from the sale of a product at a certain quantity");
    System.out.println("markup.");
    System.out.println("");
  }
  
  public static double inputCost(String modelName) throws IOException {
    System.out.println("Please enter the cost to manufacture the " + modelName + " system:");
    
    double costIdv = Integer.parseInt(input.readLine());
    System.out.println("");
    
    return costIdv;
  }
  
  public static int inputTotalSold(String modelName) throws IOException {
    System.out.println("Please enter the quantity of " + modelName + " systems sold:");
    
    int totalSold = Integer.parseInt(input.readLine());
    System.out.println("");
    
    return totalSold;
  }
  
  public static double calculatePrice(int modelNumber, double costIdv) {
    double price;
    
    if (modelNumber == 0) {
      price = costIdv * 1.25;
    }
    else if (modelNumber == 1) {
      price = costIdv + (costIdv / 3);
    }
    else {
      price = costIdv * 1.5;
    }
    return price;
  }
  
  public static void displayResults (String[] modelName, double[] price, int[] totalSold,
                                     double[] revenue, double[] profits) {
    int e = 0;
    System.out.println("Monthly Summary:");
    System.out.println("~~~~~~~~~~~~~~~~");
    System.out.println("Model\t\tSelling\t\t\t# of\t\trevenue\t\t\tprofits");
    System.out.println("Name\t\tPrice\t\t\tunits");
    System.out.println("~~~~~\t\t~~~~~~~\t\t\t~~~~\t\t~~~~~~~\t\t\t~~~~~~~");
    while (e < price.length) {
      System.out.println(modelName[e] + "\t\t$" + cents.format(price[e]) + "\t\t"
                         + totalSold[e] + "\t\t$" + cents.format(revenue[e]) + "\t\t$"
                         + cents.format(profits[e]));
      e++;
    }
    System.out.println("Total\t\tN/A\t\t\t" + (totalSold[0] + totalSold[1] + totalSold[2])
                       + "\t\t$" + cents.format(revenue[0] + revenue[1] + revenue[2])
                       + "\t\t$" + cents.format(profits[0] + profits[1] + profits[2]));
  }
}