/**
 * This program will continuously generate math questions until 3 mistakes are 
 * made, and it also display the top scores in the current run of the game.
 * 
 * @author Cameron Rodriguez
 * @version 1.0 07/24/17
 */
import java.io.*;

public class MadMathRodC {
  //Initializing Input Stream Reader
   static BufferedReader input = new BufferedReader (new InputStreamReader(System.in)); 
    
  /** 
   * Main method of the game
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main (String args[]) throws IOException {
    //Declaring variables
    String menuChoice = "0"; //The option the user select in the main menu
    int prevScore[] = new int[10]; //An array of the last 10 scores
    String prevScoreName[] = new String[10]; //An array of the names for the last 10 games
    int e = 0; //Used to initially populate arrays
    int points; //Total points scored in a game
    String newName; //The name of the current player
    
    //Populating arrays
    while (e < 10) {
      prevScore[e] = 0;
      prevScoreName[e] = "John Doe";
      e++;
    }
    //Display game title
    System.out.println("MAD MATH MINUTE");
    
    //Initializing menu loop
    while (menuChoice.substring(0) != "4" || menuChoice.length() < 1 && menuChoice.length() > 1) {
      //Introducing program to user
      introProgram();
      
      //Get user choice
      menuChoice = input.readLine();
      System.out.println("");
      
      //Respond to user choice
      if (menuChoice.charAt(0) == '1') {
        //Plays game, gets user's name, and update results arrays
        points = startGame();
        newName = endGame(points);
        prevScore = scoreChange(prevScore, points);
        prevScoreName = nameChange(prevScoreName, newName);
      }
      else if (menuChoice.charAt(0) == '2') {
        //Display instructions
        printInstructions();
      }
      else if (menuChoice.charAt(0) == '3') {
        //Display last 10 scores with names
        printScores(prevScore, prevScoreName);
      }
      else if (menuChoice.charAt(0) == '4' && menuChoice.length() == 1) {
        //Ends game
        break;
      }
      else if (menuChoice.charAt(0) != '4' || menuChoice.length() != 1) {
        //Display error message
        System.out.println("Sorry, that is not a valid entry. Please try again.");
        System.out.println("");
      }
    }
  }

  /**
   * Introduces the program to the user
   */
  public static void introProgram() {
    System.out.println("===============");
    System.out.println("Welcome to Mad Math Minute. Please type the number corresponding");
    System.out.println("to one of the following options.");
    System.out.println("");
    System.out.println("Type 1 to play Mad Math Minute");
    System.out.println("Type 2 to learn how to play this game and view the scoreboard");
    System.out.println("Type 3 to view the 10 most recent scores");
    System.out.println("Type 4 to quit this game");
    System.out.println("");
  }
  
  /**
   * Runs the main game program and returns the number of points scored
   * @return the points scored in the game
   * @throws IOException 
   */
  public static int startGame () throws IOException {
    int lives = 3; //The number of mistakes the user can still make
    int points = 0; //The numbr of points earned
    int currentQuestion = 1; //The number of questions asked
    int correct; //The correct answer to a question
    int userAnswer; //The user's guess
    
    //Wish luck to user
    System.out.println("The game begins now! Good luck!");
    System.out.println("");
    
    //Initializing question generation loop
    while (lives > 0) {
      System.out.println("Correct answers: " + points);
      System.out.println("Lives remaining: " + lives);
      System.out.println("");
      //Get correct answer
      correct = displayNewQuestion(currentQuestion);
      
      //Get user guess
      userAnswer = Integer.parseInt(input.readLine());
      System.out.println("");
      
      //Determine if answer is correct
      if (userAnswer == correct) {
        points++;
        System.out.println("Correct! You guessed the right answer of " + correct + "!");
        System.out.println("");
      }
      else {
        lives--;
        System.out.println("Incorrect! The right answer was " + correct + ".");
        System.out.println("");
      }
      
      //Adds to number of questions asked if still has lives remaining
      if (lives > 0) {
        currentQuestion++;
      }
    }
    //Return number of correct answers to main method
    return points;
  }
    
  /**
   * Display end of game message and returns the player's name
   * @param points the number of points scored
   * @return the player's name
   * @throws IOException 
   */
  public static String endGame (int points) throws IOException {
    String newName; //The player's name
    //Displays game over message and ask for player name
    System.out.println("GAME OVER");
    System.out.println("=========");
    System.out.println("The game has ended. You answered " + points + " of " + (points + 3)
                       + " questions correctly!");
    System.out.println("");
    System.out.println("Please enter your name to be added to the scoreboard:");
    System.out.println("");
    //Get player's name
    newName = input.readLine();
    System.out.println("");
    //Return player name
    return newName;
  } 

  /**
   * Updates the scoreboard with a new score and returns it.
   * @param prevScore the array of previous points scored
   * @param points the points scored in the last game
   * @return the updated scoreboard
   */
  public static int[] scoreChange (int prevScore[], int points) {
    int elementOld = 9; //The element from which the item will be moved
    int elementNew = 10; //The element where the item will be moved
    
    //Initializing old data move loop
    while (elementOld > 0) {
      elementOld--;
      elementNew--;
      //Move data
      prevScore[elementNew] = prevScore[elementOld];
    }
    //Move new data into first element
    prevScore[0] = points;
    //Return updated scoreboard
    return prevScore;
  }

  /**
   * Updates the array of names with the new name and returns it.
   * @param prevScoreName the array of previous players
   * @param newName the name of the last player
   * @return the updated array of names
   */
  public static String[] nameChange (String prevScoreName[], String newName) {
    int elementOld = 9; //The element from which the item will be moved
    int elementNew = 10; //The element where the item will be moved
    
    //Initializing old data move loop
    while (elementOld > 0) {
      elementOld--;
      elementNew--;
      //Move data
      prevScoreName[elementNew] = prevScoreName[elementOld];
    }
    //Move new data into first element
    prevScoreName[0] = newName;
    //Return updated scoreboard
    return prevScoreName;
  }
    
  /**
   * Displays the instructions to the user
   */
  public static void printInstructions () {
    System.out.println("In this game, you will have to answer as many math questions as");
    System.out.println("you can. The questions can be addition, subtraction, multiplication,");
    System.out.println("or division, and can involve values from -12 to 12. You must type");
    System.out.println("your answer to guess. If you guess correctly, you will gain a point.");
    System.out.println("If you guess incorrectly, you will lose on of your 3 lives. If you");
    System.out.println("lose all of your lives, the game ends.");
    System.out.println("");
    System.out.println("When the game ends, you can enter your name, and your results will");
    System.out.println("be added to the scoreboard. Typing \"3\" from the main menu will ");
    System.out.println("bring up the scoreboard, showing the 10 most recent players and their");
    System.out.println("scores.");
    System.out.println("");
  }

  /**
   * Displays the 10 most recent players and their scores
   * @param highScore the array of the last 10 scores
   * @param highScoreName the array of the last 10 players
   */
  public static void printScores (int highScore[], String highScoreName[]) {
    int element = 0; //The element which determines which element to display
    //Introoduce and place headers
    System.out.println("Here are the most recent scores:");
    System.out.println("");
    System.out.println("Player\t\t\t\t\tScore");
    
    //Initializing name/score display loop
    while (element < highScore.length) {
      System.out.print(highScoreName[element]);
      
      //Modify spacing of score based on length of name
      if (highScoreName[element].length() >= 32) {
        System.out.println("\t" + highScore[element] + " of " + (highScore[element] + 3));
      }
      else if (highScoreName[element].length() >= 24) {
        System.out.println("\t\t" + highScore[element] + " of " + (highScore[element] + 3));
      }
      else if (highScoreName[element].length() >= 16) {
        System.out.println("\t\t\t" + highScore[element] + " of " + (highScore[element] + 3));
      }
      else if (highScoreName[element].length() >= 8) {
        System.out.println("\t\t\t\t" + highScore[element] + " of " + (highScore[element] + 3));
      }
      else {
        System.out.println("\t\t\t\t\t" + highScore[element] + " of " + (highScore[element] + 3));
      }
      
      element++;
    }
    System.out.println("");
  }
    
  /**
   * Displays a math question and returns the answer to the game
   * @param currentQuestion the number question that is being asked
   * @return the answer to the question
   */
  public static int displayNewQuestion (int currentQuestion) {
    int correctAnswer; //The correct answer
    int num1 = randomWholeNumber(12, -12); //The first number in the question
    int num2 = randomWholeNumber(12, -12); //The second number in the question
    int operator = randomWholeNumber(4, 1); //The type of equation to be used
    
    //Calculating answers and displaying question based on equation type
    if (operator == 1) { //Addition statement
      System.out.println("Question " + currentQuestion + ": What is " + num1 + " + "
                         + num2 + "?");
      correctAnswer = num1 + num2;
    }
    else if (operator == 2) { //Subtraction statement
      System.out.println("Question " + currentQuestion + ": What is " + num1 + " - " + num2
                         + "?");
      correctAnswer = num1 - num2;
    }
    else if (operator == 3) { //Multiplication statement
      System.out.println("Question " + currentQuestion + ": What is " + num1 + " × " + num2
                         + "?");
      correctAnswer = num1 * num2;
    }
    else { //Division statement
      //Loops while second integer is 0
      while (num2 == 0) {
        num2 = randomWholeNumber(12, -12);
      }
      System.out.println("Question " + currentQuestion + ": What is " + num1 + " ÷ " + num2 + "?");
      System.out.println("(Round DOWN to the next lowest whole number.)");
      correctAnswer = (int) Math.floor(num1 / num2);
    }
    //Return the correct answer
    return correctAnswer;
  }
    
  /**
   * Returns a random number between two given values
   * @param u the upper end of the number range
   * @param l the lower end of the number range
   * @return the random number
   */
  public static int randomWholeNumber (int u, int l) {
    int randNum; //The random number to return
    
    //Generating random number
    randNum = (int) ((Math.random() * u) + l);
    //Return the random number
    return randNum;
  }
}