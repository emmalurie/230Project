/*DiningHallSelector.java
 *Last updated: 3 May 2016
 *Authors: Emma Lurie and Dorothy Sun
 *About: Each time the program is run, a DiningHallSelector object is created representing the process of choosing the best dining hall at a given meal.
 * In the constructor five dining halls are created as representations the five dining halls at Wellesley. This method contains a readWellesleyFresh() method 
 that reads a weekly menu from a txt file as well as a createHashtable() method that reads data from a tsv file that holds Wellesley Fresh common dishes and their 
 student reviews. This class also creates helper methods that neaten text and help retrieve the day of the week. 
 
 To do: 
 Improve readWellelseyFresh: Pom isn't totally working
 We should create a method that finds the top 3 DiningHalls based on scores
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
  PriorityQueue<DiningHall> rankings;
  
  public DiningHallSelector(){
    bates = new DiningHall("Bates");
    lulu = new DiningHall("Lulu");
    pom = new DiningHall("Pomeroy");
    stoned = new DiningHall("Stone Davis");
    tower = new DiningHall("Tower");
    
    rankings = new PriorityQueue<DiningHall>();
    
  }
  
 public void initializeAll(String mealName){
    bates.initializeDiningHall("menus/bates.txt", "data/Bates_Data.tsv", mealName);
    lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_Data.tsv", mealName);  
    pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", mealName);    
    stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", mealName);    
    tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", mealName);    
  }
  
    
  //bugs: to fix weird spaces, home-style brunch
  
  
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
    private static String getStartDow(int day){
    String [] dow = {"Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday", "Saturday"};
    return dow[day -1];
  }
    
  /*this helper method is the same as getEndDow(), but the date is a parameter. This method makes it easier for testing, 
   * because we can test any day of the week at any time */
  private static String getEndDow(int day){
   String [] dow = {"Saturday","Sunday","Monday", "Tuesday", "Wednesday" , "Thursday", "Friday", };
       return dow[day % 7]; 
  }
  
  private static String trimLine(String line){
    //types of dishes array
    String[] startingPhrases = {"Home-style Lunch-", "Home-Style Lunch-", "Fusion Lunch-", "Global Grill Lunch-", "Home-style Brunch-", 
      "Global Grill Brunch-", "Pure, Lunch & Dinner-", "Pizza, Lunch & Dinner-","Pizza, Brunch & Dinner-","Daily Grill Brunch-", "Daily Grill Lunch-",
      "Home-style Dinner-","Pasta Station Lunch-","Pasta Station Lunch Ð", "Lunch Grill-", "Dinner Grill-", "Brunch-", "Lunch-", "Dinner -", "Dinner-"};
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
  /*returns the DiningHall with a higher score*/
    private DiningHall getMax(DiningHall a, DiningHall b){
    return (a.compareTo(b) > 0 ? a : b); 
  }
  /*returns the DiningHall with the highest score*/
  public DiningHall getBestDiningHall(){
    rankings.enqueue(bates);
    rankings.enqueue(lulu);
    rankings.enqueue(pom);
    rankings.enqueue(stoned);
    rankings.enqueue(tower);
    return rankings.first();
  }
  
  

  
  
  public static void main(String[] args){
    //System.out.println(readWellesleyFresh("menus/bplc.txt","dinner"));
    //System.out.println(readWellesleyFresh("menus/bates.txt","dinner"));
    //System.out.println(readWellesleyFresh("menus/pomeroy.txt","lunch"));
    //System.out.println(readWellesleyFresh("menus/stonedavis.txt", "lunch"));
    //System.out.println(readWellesleyFresh("menus/tower.txt", "dinner"));
    
    DiningHallSelector s = new DiningHallSelector();
    s.initializeAll("lunch");
    System.out.println(s);
    System.out.println(s.getBestDiningHall().getName());

    
    //System.out.println(s.getBestDiningHall().getName());
//    System.out.println(s.bates);
//    System.out.println(s.lulu);
//      System.out.println(s.pom);
//    System.out.println(s.stoned);
//      System.out.println(s.tower);
  }
  
  
  
  
  }