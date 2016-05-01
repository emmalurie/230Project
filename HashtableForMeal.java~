//import 230Project.Dish;
import java.io.*;
import java.util.*;

public class HashtableForMeal {
  private Hashtable<String,Dish> lunchMeal; // size is dynamic???? 
  private Hashtable<String,Dish> dinnerMeal; 
 
  
  /**
   * @param  String dictFName  the name of the file that contains 
   * the dictionary words
   */
  public HashtableForMeal(String dictFName) {
    lunchMeal = new Hashtable<String,Dish>(100); 
    dinnerMeal = new Hashtable<String,Dish>(100); 
    
    try {   // set up file for reading meals, one per line
      Scanner reader = new Scanner(new File(dictFName));
      
      //if(reader.next() == "lunch") 
      // Q: Can we get rid of "lunch" and dinner
      
      // lunch
      while (reader.hasNext() && !reader.next().equals("\n")) {
        //read next meal, trim it 
        String ldishName  = reader.next().trim(); 
        double lscore = Double.parseDouble(reader.next().trim());  
        Dish ldish = new Dish(ldishName);
        ldish.setScore(lscore);
        //add the meal into the hash table
        lunchMeal.put(ldishName, ldish);
      }
      
      // dinner
      while(reader.hasNext()){
        String ddishName  = reader.next().trim(); 
        double dscore = Double.parseDouble(reader.next().trim());  
        Dish ddish = new Dish(ddishName);
        ddish.setScore(dscore);
        
        dinnerMeal.put(ddishName, ddish);    
      }  
      
      
      reader.close();    // close file
    }
//    catch (IOException e) {
//      System.out.println("error in reading from file");
//    }
   catch(FileNotFoundException ex){
      System.out.println("File is not found!!!");
    } 
  }
  
  
  public static void main(String[] args){
    HashtableForMeal bates = new HashtableForMeal("Test_Bates_Data1.tsv");
    System.out.println(bates.lunchMeal.containsKey("Alex’s Pizza Day! BBQ Chicken Pizza, Butternut Squash and Mushroom Pizza (V), Parmesan and Arugula Pizza (V), with Roasted Brussel Sprouts (VE), and Rainbow Chard (VE)"));
    System.out.println(bates.dinnerMeal.containsKey("Wintergreen Salad; a Custom Made Bates Only Salad with Bibb Lettuce, Fresh Mint, Grape Tomato, Goat Cheese and Golden Raisins with Raspberry Vinaigrette (V)"));
  }
  
}