package examreview;

/*
 * This program calculates profits based on the price and quantity of a product sold.
 * 
 * @author Cameron Rodriguez
 * @version 1.1
 */
import java.io.*;
import java.text.*;
public class Final3 {
  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  static DecimalFormat cents = new DecimalFormat("#,##0.00");
  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    int modelNumber = 0;
    String modelName;
    double costIdv;
    int totalSold;
    double price;
    double costTotal;
    double revenue;
    double profit;
    
    introProgram();
    
    while (modelNumber < 3) {
      
      modelName = determineModelName(modelNumber);
      
      costIdv = inputCost(modelName);
    
      totalSold = inputTotalSold(modelName);
    
      price = calculatePrice(modelNumber, costIdv);
    
      costTotal = costIdv * totalSold;
      revenue = price * totalSold;
    
      profit = revenue - costTotal;
    
      displayResults(modelName, price, totalSold, revenue, profit);
      
      modelNumber++;
    }
  }
  
  public static void introProgram() {
    System.out.println("MARKUP MANAGER");
    System.out.println("==============");
    System.out.println("Welcome to the Markup Manager. This program will determine total");
    System.out.println("revenue and profits from the sale of a product at a certain quantity");
    System.out.println("markup.");
    System.out.println("");
  }
  
  public static String determineModelName(int modelNumber) {
    String modelName;
    
    if (modelNumber == 0) {
      modelName = "Value";
    }
    else if (modelNumber == 1) {
      modelName = "SOHO";
    }
    else{
      modelName = "Gamer";
    }
    return modelName;
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
  
  public static void displayResults (String modelName, double price, int totalSold,
                                     double revenue, double profits) {
    System.out.println("Monthly " + modelName + " Summary:");
    System.out.println("~~~~~~~~~~~~~~~~");
    System.out.println("Model\t\tSelling\t\t\t# of\t\trevenue\t\t\tprofits");
    System.out.println("Name\t\tPrice\t\t\tunits");
    System.out.println("~~~~~\t\t~~~~~~~\t\t\t~~~~\t\t~~~~~~~\t\t\t~~~~~~~");
    System.out.println(modelName + "\t\t$" + cents.format(price) + "\t\t"
                       + totalSold + "\t\t$" + cents.format(revenue) + "\t\t$"
                       + cents.format(profits));
      System.out.println("");
  }
}