import java.io.*;
import java.util.*;

public class CreateHashTable {
  
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
  
  public static void main(String[] args){
     Hashtable<String,Dish> bates = createHashtable("data/Bates_Data.tsv");
     System.out.println(bates);
     //System.out.println(bateslunch.containsKey(line));
  }
}