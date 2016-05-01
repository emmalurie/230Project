import java.io.*;
import java.util.*;

public class CreateHashTable {
  
  public static Hashtable<String,Dish> createHashtable(String inFileName, String meal){
    
    Hashtable<String,Dish> mealData = new Hashtable<String,Dish>(100); 
    int score;
    boolean lunch; 
    
    if (meal.equals("lunch")){
     lunch = true;  
    } else {
     lunch = false;  
    }
    
    
    try {   // set up file for reading meals, one per line
      Scanner reader = new Scanner(new File(inFileName));
      while (reader.hasNext()){
        String line = reader.nextLine().trim();
        
        //System.out.println(line);
        String[] nameScore = line.split("\t");
        
        if(nameScore.length > 1){ //if contains a name and a score 
        String name = nameScore[0];
        score = Integer.parseInt(nameScore[1]);
        Dish value = new Dish (name, score);
        mealData.put(name, value);
        } else {
         //System.out.println(line); 
        }
        
        

        
      }
      reader.close();    // close file
      
      
    } catch(FileNotFoundException ex){
      System.out.println(inFileName + "is not found");
      
    }
   

    return mealData;
  }
  
  public static void main(String[] args){
     Hashtable<String,Dish> bateslunch = createHashtable("data/Bates_Data.tsv","lunch");
     System.out.println(bateslunch);
     //System.out.println(bateslunch.containsKey(line));
  }
}