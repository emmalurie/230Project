import javafoundations.*; 
import java.util.*;

public class DiningHall{
  
  private ArrayQueue<Dish> menu; 
  private String name; 
  private int totalScore; //sum score of dishes
  //maybe specify meal booleans (lunch and dinner)
  
  public DiningHall(String name){
    ArrayQueue<Dish> menu = new ArrayQueue<Dish>(); 
    this.name = name; 
    totalScore = 0; 
  }
  
  public String getName(){
   return name;  
  }
  
  public ArrayQueue<Dish> getMenu(){
   return menu;  
  }
  //a dining hall's score for a particular meal
  public double totalScore(){
   return totalScore;  
  }
  //adds a dish to 
  public void addToMenu(Dish d){
    menu.enqueue(d);
  }
  
  private ArrayQueue<Dish> copyMenu(){
    //is there a better way to clone a queue? 
    ArrayQueue<Dish> temp = new ArrayQueue<Dish>(); 
    ArrayQueue<Dish> copy = new ArrayQueue<Dish>();
    
    
    while(!menu.isEmpty()){
    Dish element = menu.dequeue();
    temp.enqueue(element);
    copy.enqueue(element);
  }
   menu = temp; 
   return copy; 
  }
  
   /*creates a menu of Dish objects by comparing the items in today's menu to keys in the hashtable. 
    * If the hashtable contains the name of the dish, the value, is a Dish object representing that meal option.
    * That dish object is added to that dininghall's menu*/
  public void createMenu(String todaysMenuFile, String dataFile, String mealName){
    Hashtable<String, Dish> data = DiningHallSelector.createHashtable(dataFile); 
    LinkedList<String> optionsToday = DiningHallSelector.readWellesleyFresh(todaysMenuFile, mealName); 
    System.out.println(optionsToday);
    while(!optionsToday.isEmpty()){
      String dishName = optionsToday.remove();
      if(data.containsKey(dishName)){
         System.out.println(dishName);
         addToMenu(data.get(dishName));
      }else {
        System.out.println(dishName);
      }
    }
    
  }
  /*calculates the score of the menu*/
  public void calcScore(){
    ArrayQueue<Dish> menuClone = copyMenu(); //clone of menu
    int score = 0;
    
    for (int i = 0; i < menu.size(); i++){
      score+= menu.dequeue().getScore();
    }
    totalScore = score;
  }
  
  public static void main(String[] args){
    DiningHall bates = new DiningHall("Bates");
    bates.createMenu("menus/tower.txt", "data/Bates_Data.tsv", "lunch");
    System.out.println(bates.menu);
  }
  
  
}