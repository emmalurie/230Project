/*DiningHallSelector.java
 *Last updated: 7 May 2016
 *Authors: Emma Lurie and Dorothy Sun
 *About: Each time the program is run, a DiningHallSelector object is created representing the process of choosing the best dining hall at a given meal.
 * In the constructor five dining halls are created as representations the five dining halls at Wellesley. This method contains a readWellesleyFresh() method 
 that reads a weekly menu from a txt file as well as a createHashtable() method that reads data from a tsv file that holds Wellesley Fresh common dishes and their 
 student reviews. This class also creates helper methods that neaten text and help retrieve the day of the week. 
 
 To do: 
 Improve readWellelseyFresh: Pom isn't totally working
 We should create a testing method that allows us to manually put in the day of the week. -Done by Emma 
 */

/* All the methods are commented */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Hashtable;
import java.util.Calendar;
import java.io.*;
import java.net.*;
import javafoundations.*;


public class DiningHallSelector{
  DiningHall bates, lulu, pom, stoned, tower; 
  PriorityQueue<DiningHall> rankings; //rankings of the best dining halls
  
  //constructor 
  public DiningHallSelector(){
    bates = new DiningHall("Bates");
    lulu = new DiningHall("Lulu");
    pom = new DiningHall("Pomeroy");
    stoned = new DiningHall("Stone Davis");
    tower = new DiningHall("Tower");
    
    rankings = new PriorityQueue<DiningHall>();
  }
  
  
  //getters
  public DiningHall getBates(){
    return bates;
  }
  
  public DiningHall getLulu(){
    return lulu;
  }
  
  public DiningHall getPom(){
    return pom;
  }
  
  public DiningHall getStoned(){
    return stoned;
  }
  
  public DiningHall getTower(){
    return tower;
  }
  
  
  /*initializeAll creates a menu and calculates the score for all five of the dining halls. 
   * @param mealName is either "lunch" or "dinner" and represents the meal the user would like to find the best dining hall for that meal
   */
  public void initializeAll(String mealName){
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_Data.tsv", mealName);
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_Data.tsv", mealName);  
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", mealName);    
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", mealName);    
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", mealName);    
  }
  
  /*testing method for initializeAll- adds day of the week parameter
   *  @param mealName is either "lunch" or "dinner" and represents the meal the user would like to find the best dining hall for that meal
      @param day is an int 1-7 (1 Sunday) representing the day of the week*/
  public void initializeAll(String mealName, int day){
   bates.initializeDiningHall("menus/bates.txt", "data/Bates_Data.tsv", mealName, day);
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_Data.tsv", mealName, day);  
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", mealName, day);    
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", mealName, day);    
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", mealName, day);  
}
  
  
  /* Read the weekly menu from the given file for a given meal and add the result to a LinkedList
   * @param inFileName the name of the text file that contains the weekly menu for that dining hall
   * @param meal lunch or dinner
   * @return LinkedList<String> a LinkedList of strings read from the website
   */
  public static LinkedList<String> readWellesleyFresh (String inFileName, String meal) {
    try {
      Scanner reader = new Scanner(new File(inFileName));
      LinkedList<String>result = new LinkedList<String>();
      
      String startDate = getStartDow();
      String endDate = getEndDow();
      
      boolean canReadFile = false;
      boolean lunch = false; 
      boolean dinner = false; 
      
      if (meal.equals("lunch")) lunch = true; 
      if (meal.equals("dinner")) dinner = true; 
      
      while (reader.hasNext()) { // Continue until we reach end of input file
        String line = reader.nextLine();
        
        if (line.contains(startDate)) canReadFile = true; 
        if (line.contains(endDate)) canReadFile = false;
        
        if (canReadFile && !line.contains("Breakfast-") && !line.contains(startDate)){
          if (lunch && (line.contains("Lunch")  || line.contains("Brunch"))|| dinner && line.contains("Dinner")){
            
            result.add(trimLine(line.trim())); //helper method to format the line (removes the type of meal from the string)
            
            //System.out.println(line + "\n");
          }
        }
      }
      reader.close(); // Close the file reader
      return result; 
      
    } catch (FileNotFoundException ex) {
      System.out.println(ex); // Handle file-not-found by displaying message
      return null; // Return the empty string if file not found
      
    }
  }
  
  

  /*creates a hashtable of all of the dishes on record being served at a specific dining hall
   * @param inFileName a String that denotes a tsv file of student reviewed dishes and their scores  
   * @return Hashtable<String,Dish> that are being created
   */
  public static Hashtable<String,Dish> createHashtable(String inFileName){
    
    Hashtable<String,Dish> mealData = new Hashtable<String,Dish>(200); 
    
    try {   // set up file for reading meals, one per line
      Scanner reader = new Scanner(new File(inFileName));
      String[] nameScore;
      String line;
      String name; 
      int score;
      while (reader.hasNext()){
        line = reader.nextLine().trim();
        
        //System.out.println(line);
        nameScore = line.split("\t");
        
        
        if(nameScore.length > 1){ //if contains a name and a score 
          name = nameScore[0];
          score = Integer.parseInt(nameScore[1]);
          Dish value = new Dish (name, score);
          mealData.put(name, value);
        }
        
      }
      reader.close();    // close file
      
    } catch(FileNotFoundException ex){
      System.out.println(inFileName + "is not found");
    }
    return mealData;
  }
  
  
  
  /*uses java Calendar API return an int representing the days of the week (1 Sunday - 7 Saturday)*/ 
  private static int getDOW(){
    Calendar c = Calendar.getInstance();
    int i = c.get(Calendar.DAY_OF_WEEK);
    return i;
    
  }
  
  
  /*returns the day of the week in String form (1 becomes Sunday*/
  private static String getStartDow(){
    String [] dow = {"Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday", "Saturday"};
    int date = getDOW();   
    return dow[date - 1]; 
  }
  
  
  /*returns tomorrow's day of the week in String form*/
  private static String getEndDow(){
    String [] dow = {"Saturday","Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday", };
    int date = getDOW() + 1 ;   
    return dow[date % 7]; 
  }
  
  
  
  /*this helper method is 
   * */
  private static String trimLine(String line){
    //types of dishes array
    String[] startingPhrases = {"Home-style Lunch-", "Home-Style Lunch-", "Fusion Lunch-", "Global Grill Lunch-", "Home-style Brunch-", 
      "Global Grill Brunch-", "Pure, Lunch & Dinner-", "Pizza, Lunch & Dinner-","Pizza, Brunch & Dinner-","Daily Grill Brunch-","Daily Grill Lunch-", "Daily Grill Lunch-",
      "Home-style Dinner-","Pasta Station Lunch-","Pasta Station Lunch-", "Pasta Station Lunch Ð", "Pasta Station Brunch-", "Lunch Grill-", "Dinner Grill-", "Brunch-", "Lunch-", "Dinner -", "Dinner-"};
    int size; 
    for (int i = 0; i < startingPhrases.length; i++){
      if (line.contains(startingPhrases[i])){
        size = startingPhrases[i].length();
        line = line.substring(size + 1);
      }
    }
    return line; 
  }
  
  
  /*toString method to print out name of dishes and averageScore at a given meal
   * for 5 dinning halls */
  public String toString(){
    //new lines aren't really working
    String result = "";
    result += bates + "\n"; 
    result +=  lulu+ "\n";
    result +=  pom+ "\n";
    result +=  stoned + "\n";
    result += tower + "\n";
    result += "Top Dining Hall: " +  getTopTwoDiningHalls()[0].getName()+ " " + getTopTwoDiningHalls()[0].getAverageScore() + "\n";
    result += "Second Best Choice: " + getTopTwoDiningHalls()[1].getName() + " " +getTopTwoDiningHalls()[1].getAverageScore() + "\n";
    
    return result;   
  }
  
  
  /*returns the top two dining halls in an array of DiningHalls*/
  public DiningHall[] getTopTwoDiningHalls(){
    DiningHall [] topTwo;
    if (rankings.isEmpty()){
      rankings.enqueue(bates);
      rankings.enqueue(lulu);
      rankings.enqueue(pom);
      rankings.enqueue(stoned);
      rankings.enqueue(tower);
    }
    
    DiningHall first = rankings.dequeue();
    DiningHall second = rankings.dequeue();
    
    rankings.enqueue(first);
    rankings.enqueue(second);
    topTwo = new DiningHall[] {first, second};
    return topTwo;
  }
  
    /*Check whether today is weekend to avoid NullPointerException because StoneD is not open on weekends.*/
   public boolean isWeekend(){
    String d = getStartDow();
    return ( d.equals("Saturday") || d.equals("Sunday")); 
   }
  
  /*this helper/ testing method is the same as getStartDow(), but the date in int formis a parameter. This method makes it easier for testing, 
   * because we can test any day of the week at any time */
  public static String getStartDow(int day){
    String [] dow = {"Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday", "Saturday"};
    return dow[day -1];
  }
  
  /*this helper/testing method is the same as getEndDow(), but the date in int form is a parameter. This method makes it easier for testing, 
   * because we can test any day of the week at any time */
  public static String getEndDow(int day){
    String [] dow = {"Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday","Saturday" };
    return dow[day % 7]; 
  }
  
  
  /*testing method overloading readWellesleyFresh with a day of the week parameter for easy testing*/
   public static LinkedList<String> readWellesleyFresh (String inFileName, String meal, int day) {
    try {
      Scanner reader = new Scanner(new File(inFileName));
      LinkedList<String>result = new LinkedList<String>();
      
      String startDate = getStartDow(day);
      String endDate = getEndDow(day);
      
      boolean canReadFile = false;
      boolean lunch = false; 
      boolean dinner = false; 
      
      if (meal.equals("lunch")) lunch = true; 
      if (meal.equals("dinner")) dinner = true; 
      
      
      
      while (reader.hasNext()) { // Continue until we reach end of input file
        String line = reader.nextLine();
        
        if (line.contains(startDate)) canReadFile = true; 
        if (line.contains(endDate)) canReadFile = false;
        
        if (canReadFile && !line.contains("Breakfast-") && !line.contains(startDate)){
          if (lunch && (line.contains("Lunch")  || line.contains("Brunch"))|| dinner && line.contains("Dinner")){
            result.add(trimLine(line.trim())); //helper method to format the line (removes the type of meal from the string)
          }
        }
      }
      reader.close(); // Close the file reader
      return result; 
      
    } catch (FileNotFoundException ex) {
      System.out.println(ex); // Handle file-not-found by displaying message
      return null; // Return the empty string if file not found
      
    }
  }
   
 
  
  public static void main(String[] args){
    DiningHallSelector t = new DiningHallSelector();
//    t.initializeAll("lunch");
//    System.out.println(t);
//    System.out.println("Top" + t.getTopTwoDiningHalls()[0].getName());
//    System.out.println("Second" + t.getTopTwoDiningHalls()[1].getName());
//    
    t.initializeAll("dinner");
    System.out.println(t);
    System.out.println("Top: " + t.getTopTwoDiningHalls()[0].getName());
    System.out.println("Second: " + t.getTopTwoDiningHalls()[1].getName());
    

  }
  
  
  
  
}