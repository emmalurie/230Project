/*DiningHallSelector.java
 *Last updated: 3 May 2016
 *Authors: Emma Lurie and Dorothy Sun
 *About: Each time the program is run, a DiningHallSelector object is created representing the process of choosing the best dining hall at a given meal.
 * In the constructor five dining halls are created as representations the five dining halls at Wellesley. This method contains a readWellesleyFresh() method 
 that reads a weekly menu from a txt file as well as a createHashtable() method that reads data from a tsv file that holds Wellesley Fresh common dishes and their 
 student reviews. This class also creates helper methods that neaten text and help retrieve the day of the week. 
 
 To do: 
 Improve readWellelseyFresh: Pom isn't totally working
 We should create a testing method that allows us to manually put in the day of the week. -Done by Emma 
 */
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
   * @param mealName is either "lunch" or "dinner" and represents the meal the user would like to find the best dining hall for*/
  public void initializeAll(String mealName){
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_Data.tsv", mealName);
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_Data.tsv", mealName);  
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", mealName);    
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", mealName);    
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", mealName);    
  }
  
  
  //bugs: to fix weird spaces, home-style brunch
  /**/
 
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

  /*creates a hashtable of all of the dishes on record being served at a specific dining hall*/
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
  
  
  
  /*uses java Calendar API return an int representing the days of the week*/ 
  private static int getDOW(){
    Calendar c = Calendar.getInstance();
    int i = c.get(Calendar.DAY_OF_WEEK);
    return i;
    
  }
  /*returns the day of the week */
  private static String getStartDow(){
    String [] dow = {"Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday", "Saturday"};
    int date = getDOW();   
    return dow[date - 1]; 
  }
  
  
  /*returns tomorrow's day of the week */
  private static String getEndDow(){
    String [] dow = {"Saturday","Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday", };
    int date = getDOW() + 1 ;   
    return dow[date % 7]; 
  }
  
  /*this helper method is the same as getStartDow(), but the date is a parameter. This method makes it easier for testing, 
   * because we can test any day of the week at any time */
  public static String getStartDow(int day){
    String [] dow = {"Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday", "Saturday"};
    return dow[day -1];
  }
  
  /*this helper method is the same as getEndDow(), but the date is a parameter. This method makes it easier for testing, 
   * because we can test any day of the week at any time */
  public static String getEndDow(int day){
    String [] dow = {"Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday","Saturday" };
    return dow[day % 7]; 
  }
  
  private static String trimLine(String line){
    //types of dishes array
    String[] startingPhrases = {"Home-style Lunch-", "Home-Style Lunch-", "Fusion Lunch-", "Global Grill Lunch-", "Home-style Brunch-", 
      "Global Grill Brunch-", "Pure, Lunch & Dinner-", "Pizza, Lunch & Dinner-","Pizza, Brunch & Dinner-","Daily Grill Brunch-","Daily Grill Lunch-", "Daily Grill Lunch-",
      "Home-style Dinner-","Pasta Station Lunch-","Pasta Station Lunch-", "Pasta Station Lunch �", "Pasta Station Brunch", "Lunch Grill-", "Dinner Grill-", "Brunch-", "Lunch-", "Dinner -", "Dinner-"};
    int size; 
    for (int i = 0; i < startingPhrases.length; i++){
      if (line.contains(startingPhrases[i])){
        size = startingPhrases[i].length();
        line = line.substring(size + 1);
      }
    }
    return line; 
  }
  
  public String toString(){
    //new lines aren't really working
    String result = "";
    result += "Bates \n" + bates + "\n"; 
    result += "Lulu \n" + lulu+ "\n";
    result += "Pomeroy \n" + pom+ "\n";
    result += "Stone Davis \n" + stoned + "\n";
    result += "Tower \n" + tower + "\n";
    
    return result;
    
  }
  
  /*returns the top three dining halls in an array of DiningHalls*/
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
  
  /*testing method*/
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
   
   public boolean isWeekend(){
    String d = getStartDow();
    return ( d.equals("Saturday") || d.equals("Sunday")); 
   }
 
  
  public static void main(String[] args){
    //System.out.println(readWellesleyFresh("menus/bplc.txt","dinner"));
    //System.out.println(readWellesleyFresh("menus/bates.txt","dinner"));
    //System.out.println(readWellesleyFresh("menus/pomeroy.txt","lunch"));
    //System.out.println(readWellesleyFresh("menus/stonedavis.txt", "lunch"));
    //System.out.println(readWellesleyFresh("menus/tower.txt", "dinner"));
    
   
    DiningHallSelector s = new DiningHallSelector();
   //s.initializeAll("lunch");
    s.initializeAll("dinner");
    
    
    System.out.println(s.bates.getName()+"\t"+ s.bates.getTop().toString() +"\t"+ s.bates.getAverageScore()+"\n");
     System.out.println(s.lulu.getName()+"\t"+s.lulu.getTop().toString()+"\t" +s.lulu.getAverageScore()+"\n");
     System.out.println(s.pom.getName()+"\t"+s.pom.getTop().toString() +"\t" + s.pom.getAverageScore()+"\n");
     //System.out.println(s.stoned.getTop().toString()+"\t" + s.stoned.getAverageScore()+"\n");
     System.out.println(s.tower.getName()+"\t"+s.tower.getTop().toString()+"\t" + s.tower.getAverageScore()+"\n");
     
     System.out.println("\n\n");
    DiningHall [] test1 = s.getTopTwoDiningHalls();
    for (int i = 0; i < test1.length; i++){
      System.out.println(test1[i].getName()+ "\t"+ test1[i].getAverageScore()); 
    }
    
    
    System.out.println("\n\n\nClick on Bates and lulu (should give us Lulu and Pom)");
    double score1 = s.bates.getAverageScore();
    s.bates.setAverageScore(score1+1);
    
    double score2 = s.lulu.getAverageScore();
    s.lulu.setAverageScore(score2+1);
    
    
    System.out.println(s.bates.getName()+"\t"+ s.bates.getTop().toString() +"\t"+ s.bates.getAverageScore()+"\n");
    System.out.println(s.lulu.getName()+"\t"+s.lulu.getTop().toString()+"\t" +s.lulu.getAverageScore()+"\n");
    System.out.println(s.pom.getName()+"\t"+s.pom.getTop().toString() +"\t" + s.pom.getAverageScore()+"\n");
    //System.out.println(s.stoned.getTop().toString()+"\t" + s.stoned.getAverageScore()+"\n");
    System.out.println(s.tower.getName()+"\t"+s.tower.getTop().toString()+"\t" + s.tower.getAverageScore()+"\n");
    
    
    DiningHall [] test2 = s.getTopTwoDiningHalls();
    for (int i = 0; i < test2.length; i++){
      System.out.println(test2[i].getName()+  "\t"+ test2[i].getAverageScore()+  "\t"+ test2[i].getMenu().size()); 
    }
    
    
     System.out.println("\n\n\nClick on lulu (should give us Lulu and Pom)");
     double score3 = s.lulu.getAverageScore();
     s.lulu.setAverageScore(score3+1);
     
     System.out.println(s.bates.getName()+"\t"+ s.bates.getTop().toString() +"\t"+ s.bates.getAverageScore()+"\n");
     System.out.println(s.lulu.getName()+"\t"+s.lulu.getTop().toString()+"\t" +s.lulu.getAverageScore()+"\n");
     System.out.println(s.pom.getName()+"\t"+s.pom.getTop().toString() +"\t" + s.pom.getAverageScore()+"\n");
     //System.out.println(s.stoned.getTop().toString()+"\t" + s.stoned.getAverageScore()+"\n");
     System.out.println(s.tower.getName()+"\t"+s.tower.getTop().toString()+"\t" + s.tower.getAverageScore()+"\n");
     
     DiningHall [] test3 = s.getTopTwoDiningHalls();
     for (int i = 0; i < test3.length; i++){
       System.out.println(test3[i].getName()+ "\t"+ test3[i].getAverageScore()+ "\t"+ test3[i].getMenu().size()); 
     }
    
    
//                System.out.println(s.getTopThreeDiningHalls()[1].getName());
//                        System.out.println(s.getTopThreeDiningHalls()[2].getName());
//System.out.println(s.getFirst().getName());
    //System.out.println(s.getSecond().getName());
    
    
    //System.out.println(s.getBestDiningHall().getName());
//    System.out.println(s.bates);
//    System.out.println(s.lulu);
//      System.out.println(s.pom);
//    System.out.println(s.stoned);
//      System.out.println(s.tower);
  }
  
  
  
  
}