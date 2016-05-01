/* reads from web menu and writes menu to txt file*/
import java.util.*;
import java.io.*;
import java.net.*;



public class DiningHallSelector {
  
//  public DiningHallSelector(){
//    
//    
//  }
  
  //need to get rid of dashes and separate through lunch and dinner
  
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
                //figure out how to get rid of heading 
                
                result.add(trimLine(line.trim())); //helper method to format the line (removes the type of meal from the string)
                
                
                System.out.println(line + "\n");
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
    String[] startingPhrases = {"Home-style Lunch-", "Fusion Lunch-", "Global Grill Lunch-", "Home-style Brunch-", 
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
    System.out.println(readWellesleyFresh("menus/tower.txt","dinner"));
    //System.out.println(getStartDow());


  }
  
  
  
  
  }