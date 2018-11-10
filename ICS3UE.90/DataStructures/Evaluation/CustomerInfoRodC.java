/**
 * This program forms a table based on inputted data for names and ages. It also determines the average age and returns
 * the names of the oldest and youngest people.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/18/17
 */

import javax.swing.*;
public class CustomerInfoRodC {
  
  /** @param args the command line arguments */
  public static void main(String[] args) {
    //Declaring variables
    int totalPeople; //The total number of people to be entered into the program
    String name[]; //The array of names
    int age[]; //The array of ages
    int element = 0; //Indicates the array element to be filled
    int avgAge; //The integer for the average age
    String oldestName; //The name of the oldest person
    String youngestName; //The name of the youngest person
    String text; //The text to be outputted
    int restart = JOptionPane.YES_OPTION; //Restarts program if requested
    
    //Introducing program
    introProgram();
    
    //Initializing restart loop
    exit: //Used to break 2 loops during main input sequence
    while (restart == JOptionPane.YES_OPTION) {
      totalPeople = inputNumberOfPeople();
      
      //End program if requested
      if (totalPeople == JOptionPane.CLOSED_OPTION) {
        break;
      }
      
      //Initializing arrays
      name = new String[totalPeople];
      age = new int[totalPeople];
      
      //Initializing name/age input loop
      while (element < totalPeople) {
        //Input name
        name[element] = inputName();
        //End program if requested
        if (name[element] == "killApp1") {
          break exit;
        }
        
        //Input age
        age[element] = inputAge(name[element]);
        //End program if requested
        if (age[element] == JOptionPane.CLOSED_OPTION) {
          break exit;
        }
        element++;
      }
      
      //Determine average user age
      avgAge = determineAvgAge(age);
      
      //Determine oldest and youngest people
      oldestName = determineOldestName(name, age);
      youngestName = determineYoungestName(name, age);
      
      //Generate text to be displayed
      text = generateOutputText(totalPeople, name, age, avgAge, oldestName, youngestName);
      
      //Display text to user
      outputData(text);
      
      //Restart program if requested
      restart = askToRestart();
      
      //Resetting element
      element = 0;
    }
    //Goodbye message
    JOptionPane.showMessageDialog(null, "Thank you for using the Customer Information Analyzer. Have a nice day.",
                                  "Thank You", JOptionPane.PLAIN_MESSAGE);
  }
  
  /** Introduces the program to the user. */
  public static void introProgram() {
    JOptionPane.showMessageDialog(null, "Welcome to the Customer Information Analyzer."
                                  + "\n\nThis program will take in information on any given number of customers, storing"
                                  + "\ntheir names and ages. It will return a table of all the given information, the"
                                  + "\naverage customer age, and the names of the oldest and youngest customers.",
                                  "Customer Information Analyzer", JOptionPane.INFORMATION_MESSAGE);
  }
  
  /**
   * Returns the number of people to be added
   * 
   * @return the number of people to be inputted
   */
  public static int inputNumberOfPeople() {
    String totalText; //The user's direct input
    int total = JOptionPane.YES_OPTION; //The number of people to be inputted into the system
    //Initializing valid input loop
    while (total == JOptionPane.YES_OPTION) {
      totalText = JOptionPane.showInputDialog(null, "How many customers are you entering today?",
                                              "How Many Customers?", JOptionPane.QUESTION_MESSAGE);
      total = checkValidNumInput(totalText);
    }
    return total;
  }
  
  /**
   * Returns if numeric input was valid and action to take if otherwise
   * 
   * @param numInput the user's input
   * @return if input was valid or how to act otherwise
   */
  public static int checkValidNumInput(String numInput) {
    int result = 0; //Returns user input or otherwise
    if (numInput == null || !numInput.matches("[0-9]+") || Integer.parseInt(numInput) <= 0) { //No number above 0 inputted
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
      result = Integer.parseInt(numInput);
    }
    return result;
  }
  
  /**
   * Returns the name of a customer
   * 
   * @return the name
   */
  public static String inputName() {
    String name = "retry1"; //Will return the name
    //Initializing valid input loop
    while (name == "retry1") {
      name = JOptionPane.showInputDialog(null, "Please enter a name:", "Input Name", JOptionPane.QUESTION_MESSAGE);
      //Check valid input
      name = checkValidTextInput(name);
    }
    return name;
  }
  
  /**
   * Returns if text input was valid or how to act otherwise
   * 
   * @param textInput the user's input
   * @return if the input was valid or how to act otherwise
   */
  public static String checkValidTextInput(String textInput) {
    int result; //Returns a result from the error message
    if (textInput == null || !textInput.matches("[a-zA-Z- ]+")) {
      Object options[] = {"Re-enter the name", "End this program"};
      result = JOptionPane.showOptionDialog(null, "Sorry, but that was not a valid input. If you wish to try again,"
                                            + "\nplease enter a name with letters only."
                                            + "\n\nWould you like to re-enter the name or end this program?",
                                            "Invalid Entry", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE,
                                            null, options, options[0]);
      //Restart/end program check loop
      if (result != JOptionPane.YES_OPTION) {
        textInput = "killApp1"; /* Will return through to main method and break program loop, ending the program
                                 * The number necessary to avoid a word dedicated to closing the program cancelling
                                 * a valid entry. */
      }
      else {
        textInput = "retry1";
      }
    }
    return textInput;
  }
  
  /**
   * Returns the age of a customer
   * 
   * @param name the customer's name
   * @return the customer's age
   */
  public static int inputAge(String name) {
    String ageText; //The user's direct input
    int age = JOptionPane.YES_OPTION; //Will return the age
    //Initializing valid input loop
    while (age == JOptionPane.YES_OPTION) {
      ageText = JOptionPane.showInputDialog(null, "Please enter " + name + "'s age:", "Input Age", JOptionPane.QUESTION_MESSAGE);
      //Check valid input
      age = checkValidNumInput(ageText);
    }
    return age;
  }
  
  /**
   * Return the average customer age
   * 
   * @param age the array of customer ages
   * @return the average age
   */
  public static int determineAvgAge(int[] age) {
    int agesAdded = 0; //Will return the average age
    int element = 0; //The element to add
    //Initializing addition loop
    while (element < age.length){
      agesAdded += age[element];
      element++;
    }
    //Return average
    return agesAdded / age.length;
  }
  
  /**
   * Returns the name of the oldest person
   * 
   * @param name the array of the customer names
   * @param age the array of customer ages
   * @return the name of the oldest person
   */
  public static String determineOldestName(String[] name, int[] age) { 
    int element = 0; //indicates the element to check
    int oldestAge = 0; //Stores the oldest age to check against other arrays
    int oldestElement = 0; //Stores the element corresponding to the oldest age
    //Initializing check
    while (element < age.length) {
      if (age[element] > oldestAge) {
        oldestAge = age[element]; //Age is stored to check against other elements
        oldestElement = element; //Element is stored to use in search for corresponding name
      }
      element++;
    }
    //Return the name of the oldest person
    return name[oldestElement];
  }
  
  /**
   * Returns the name of the youngest person
   * 
   * @param name the array of the customer names
   * @param age the array of customer ages
   * @return the name of the youngest person
   */
  public static String determineYoungestName(String[] name, int[] age) { 
    int element = 0; //indicates the element to check
    int youngestAge = 99999999; //Stores the youngest age to check against other arrays
    int youngestElement = 0; //Stores the element corresponding to the yougest age
    //Initializing check
    while (element < age.length) {
      if (age[element] < youngestAge) {
        youngestAge = age[element]; //Age is stored to check against other elements
        youngestElement = element; //Element is stored to use in search for corresponding name
      }
      element++;
    }
    //Return the name of the youngest person
    return name[youngestElement];
  }
  
  /**
   * Generate the text to be displayed
   * 
   * @param total the total number of people inputted
   * @param name the array of customer names
   * @param age the array of customer ages
   * @param avgAge the average customer age
   * @param oldest the name of the oldest customer
   * @param youngest the name of the youngest customer
   * @return the text to be displayed
   */
  public static String generateOutputText(int total, String[] name, int[] age, int avgAge, String oldest, String youngest) {
    String text = "Here is the information for " + total + " customers:" + "\n\nName\t\t\t\tAge\t"; //The text to be displayed
    int element = 0; //The element to output
    //Initializing array output loop
    while (element < name.length) {
      text += "\n" + name[element] + "\t\t\t\t" + age[element] + "\t";
      element++;
    }
    text += "\n\nThe average customer age is " + avgAge + "."
          + "\n\nThe oldest person is " + oldest + "."
          + "\nThe youngest person is " + youngest + ".";
    return text;
  }
  
  /**
   * Display the data and calculations to the user
   * 
   * @param text the text to be displayed
   */
  public static void outputData(String text) {
    JOptionPane.showMessageDialog(null, new JTextArea(text), "Data", JOptionPane.PLAIN_MESSAGE);
  }
  
   /**
   * Return if user wants to restart program
   * 
   * @return if program should be restarted
   */
  public static int askToRestart() {
    Object options[] = {"Yes", "No"};
    return JOptionPane.showOptionDialog(null, "Would you to restart the program?", "Restart?", JOptionPane.YES_NO_OPTION,
                                        JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
  }
}
