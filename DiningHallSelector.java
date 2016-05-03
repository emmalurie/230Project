/*DiningHallSelector.java
 *Last updated: 3 May 2016
 *Authors: Emma Lurie and Dorothy Sun
 *About: Each time the program is run, a DiningHallSelector object is created representing the process of choosing the best dining hall at a given meal.
 * In the constructor five dining halls are created as representations the five dining halls at Wellesley. This method contains a readWellesleyFresh() method 
 that reads a weekly menu from a txt file as well as a createHashtable() method that reads data from a tsv file that holds Wellesley Fresh common dishes and their 
 student reviews. This class also creates helper methods that neaten text and help retrieve the day of the week. 
 
 To do: 
 We should create a method that finds the top 3 DiningHalls based on scores
 We should create a testing method that allows us to manually put in the day of the week.*/
import java.util.*;
import java.io.*;
import java.net.*;



public class DiningHallSelector {
  DiningHall bates, lulu, pom, stoned, tower; 
  
  public DiningHallSelector(){
    bates = new DiningHall("Bates");
    lulu = new DiningHall("Lulu");
    pom = new DiningHall("Pomeroy");
    stoned = new DiningHall("Stone Davis");
    tower = new DiningHall("Tower");
    
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
    
    Hashtable<String,Dish> mealData = new Hashtable<String,Dish>(100); 
    
    
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
  
  private static String trimLine(String line){
    //types of dishes array
    String[] startingPhrases = {"Home-style Lunch-", "Home-Style Lunch-", "Fusion Lunch-", "Global Grill Lunch-", "Home-style Brunch-", 
      "Global Grill Brunch-", "Pure, Lunch & Dinner-", "Pizza, Lunch & Dinner-","Pizza, Brunch & Dinner-","Daily Grill Brunch-", 
      "Home-style Dinner-","Pasta Station Lunch-", "Lunch Grill-", "Dinner Grill-", "Brunch-", "Lunch-", "Dinner-"};
    int size; 
    for (int i = 0; i < startingPhrases.length; i++){
      if (line.contains(startingPhrases[i])){
        size = startingPhrases[i].length();
        line = line.substring(size + 1);
      }
    }
    return line; 
  }
  
  
  
  public static void main(String[] args){
    System.out.println(readWellesleyFresh("menus/bplc.txt","dinner"));
    //System.out.println(getStartDow());


  }
  
  
  
  
  }