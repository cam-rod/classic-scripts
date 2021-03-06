package examreview;

/*
 * This program calculates profits based on the price and quantity of a product sold.
 * 
 * @author Cameron Rodriguez
 * @version 1.1
 */
import java.io.*;
import java.text.*;
public class Final2 {
  static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  static DecimalFormat cents = new DecimalFormat("#,##0.00");
  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    String modelName;
    double costIdv;
    int totalSold;
    double price;
    double costTotal;
    double revenue;
    double profit;
    
    introProgram();
    
    modelName = inputModelName();
    
    costIdv = inputCost(modelName);
    
    totalSold = inputTotalSold(modelName);
    
    price = calculatePrice(modelName, costIdv);
    
    while (price == 0) {
      modelName = inputModelName();
      price = calculatePrice(modelName, costIdv);
    }
    
    costTotal = costIdv * totalSold;
    revenue = price * totalSold;
    
    profit = revenue - costTotal;
    
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
  
  public static String inputModelName() throws IOException {
    System.out.println("Please enter the model name of the computer system (Value, SOHO");
    System.out.println("Gamer):");
    
    String modelName = input.readLine();
    System.out.println("");
    
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
  
  public static double calculatePrice(String modelName, double costIdv) {
    String modelNameCaps = modelName.toUpperCase();
    double price = 0;
    
    if ("VALUE".equals(modelNameCaps)) {
      price = costIdv * 1.25;
    }
    else if ("SOHO".equals(modelNameCaps)) {
      price = costIdv + (costIdv / 3);
    }
    else if ("GAMER".equals(modelNameCaps)) {
      price = costIdv * 1.5;
    }
    else {
      System.out.println("Sorry, that is not a valid model name. Please try again.");
      System.out.println("");
    }
    return price;
  }
  
  public static void displayResults (String modelName, double price, int totalSold,
                                     double revenue, double profits) {
    System.out.println("Monthly Summary:");
    System.out.println("~~~~~~~~~~~~~~~~");
    System.out.println("Model\tSelling\t# of\trevenue\tprofits");
    System.out.println("Name\tPrice\tunits");
    System.out.println("~~~~~\t~~~~~~~\t~~~~\t~~~~~~~\t~~~~~~~");
    System.out.println(modelName.toUpperCase() + "\t$" + cents.format(price) + "\t"
                       + totalSold + "\t$" + cents.format(revenue) + "\t$"
                       + cents.format(profits));
  }
}