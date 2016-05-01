//import 230Project.Dish;
import java.io.*;
import java.util.*;

public class HashtableForMeal {
 
  
  /**
   * @param  String dictFName  the name of the file that contains 
   * the dictionary words
   */
  public static Hashtable<String,Dish> createHash(String dictFName, String meal) {
    Hashtable<String,Dish> lunchMeal = new Hashtable<String,Dish>(100); 
    Hashtable<String,Dish> dinnerMeal = new Hashtable<String,Dish>(100); 
    
    try {   // set up file for reading meals, one per line
      Scanner reader = new Scanner(new File(dictFName));
      //if(reader.next() == "lunch") 
      // Q: Can we get rid of "lunch" and dinner
      
      // lunch
      while (reader.hasNext() && !reader.nextLine().equals("\n")){
        //read next meal, trim it 
        String line = reader.nextLine().trim(); 
        String name = line.split("\t")[0];
        //System.out.println(name);
        int score = Integer.parseInt(line.split("\t")[1]);
        //System.out.println(score);
        
        //double lscore = Double.parseDouble(reader.next().trim());  
        Dish dish = new Dish(name);
        dish.setScore(score);
        //add the meal into the hash table
        lunchMeal.put(name, dish);
      }
      
      // dinner
      while(reader.hasNext()){
        String line = reader.nextLine().trim(); 
        String name = line.split("\t")[0];
        int score = Integer.parseInt(line.split("\t")[1]);
        Dish dish = new Dish(name);
        dish.setScore(score);
        
        dinnerMeal.put(name, dish);    
      }  
      
      
      reader.close();    // close file
    }
   catch(FileNotFoundException ex){
      System.out.println("File is not found!!!");
    } 
   
   //LinkedList<Hashtable<String,Double>> result = new LinkedList<Hashtable<String,Double>>();
   
   if(meal.equals("lunch")){
     return lunchMeal;
   }else{
     return dinnerMeal;
   }
  }
  
  
  public static void main(String[] args){
//    Hashtable<String,Dish> bateslunch = createHash("data/Bates_Data.tsv","lunch");
//    System.out.println(bateslunch.containsKey("Alex’s Pizza Day! BBQ Chicken Pizza, Butternut Squash and Mushroom Pizza (V), Parmesan and Arugula Pizza (V), with Roasted Brussel Sprouts (VE), and Rainbow Chard (VE)"));
//    Hashtable<String,Dish> batesdinner = createHash("data/Bates_Data.tsv","dinner");
//    System.out.println(batesdinner.containsKey("Wintergreen Salad; a Custom Made Bates Only Salad with Bibb Lettuce, Fresh Mint, Grape Tomato, Goat Cheese and Golden Raisins with Raspberry Vinaigrette (V)"));
    
    Hashtable<String,Dish> lululunch = createHash("data/Lulu_Data.tsv","lunch");
    System.out.println(lululunch.containsKey("Carnitas Burrito, Shredded BBQ Pork in a Flour Tortilla, With Rice (VE) Beans (VE), Fresh Salsa (VE) & Tortilla Chips (VE)"));
    System.out.println(lululunch.containsKey("BBQ Chicken Sandwich, Grilled Chicken Breast, smother in Bbq sauce and Sliced Bacon served in a Claflin Roll. BBQ Tofu (V) Sandwich with Kettle chips (VE)"));
    System.out.println(lululunch.containsKey("Turkey Burger, With Caramelized Onions (V), Garden Burger (V) Served with Fresh Cut Fries (VE)"));
    System.out.println(lululunch.containsKey("Tuna Melt, Tuna salad with Melted Swiss cheese on Toasted Marble Rye Bread Eggplant Parm Slider, Golden Crispy Eggplant, tomato Sauce Provolone on Brioche (V) served with Fresh Cut Fries (VE)"));
    System.out.println(lululunch.containsKey("The Green Monstah! Grilled Chicken Breast with pesto and Mozzarella/Provolone on Ciabatta bread, spicy Brussels sprouts (VE), Grilled Corn (VE)."));
//HashtableForMeal bates = new HashtableForMeal("Data/Lulu_Data.tsv");
    //System.out.println(lulu.lunchMeal.containsKey("BBQ Chicken Sandwich, Grilled Chicken Breast, smother in Bbq sauce and Sliced Bacon served in a Claflin Roll. BBQ Tofu (V) Sandwich with Kettle chips (VE)"));
  }
  
}