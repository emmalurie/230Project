/*DiningHall.java
 *Last updated: 3 May 2016
 *Authors: Emma Lurie 
 *About: Each dining hall is reprented by a DiningHall object. DiningHall objects have a name (ie "Tower") a totalScore,
 *and a menu (a ArrayQueue<Dish>) that holds Dish objects that represent what is being
 *at a given meal at that dining hall. Besides the three instance variables mentioned previously the class contains getters, a createMenu() method that adds all
 *Dishes that appear in the hashtable to the menu. There is also a toString() method.
 
 To do: should change ArrayQueue to PriorityQueue, change totalScore to averageScore
 should create a method that returns the top menu item (for JustForYou option)
 should create an intialize() method that createsMenu() and calcScore()... then the only public methods are initialize(), constructor, compareTo(), getters, and toString() -Emma*/
import javafoundations.*; 
import java.util.*;

public class DiningHall implements Comparable<DiningHall>{
  
  private ArrayQueue<Dish> menu; 
  private String name; 
  private int totalScore; //sum score of dishes
  //maybe specify meal booleans (lunch and dinner)
  
  public DiningHall(String name){
    menu = new ArrayQueue<Dish>(); 
    this.name = name; 
    totalScore = 0; 
  }
  
  public String getName(){
   return name;  
  }
  
  public ArrayQueue<Dish> getMenu(){
   return menu;  
  }
  
  public int getScore(){
   return totalScore;  
  }
  //a dining hall's score for a particular meal
  public double totalScore(){
   return totalScore;  
  }
  //adds a dish to 
  private void addToMenu(Dish d){
    try {
    //the dish object is being passed, but it is not being enqueued
    menu.enqueue(d);
    } catch (NullPointerException n){
     System.out.println(d.getName() + " is throwing a null pointer"); 
    }
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
    
    //System.out.println(optionsToday);
    
    while(!optionsToday.isEmpty()){
      
      String dishName = optionsToday.remove();
      
      if(data.containsKey(dishName)){
         //System.out.println(dishName);
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
  
  /*need to improve toString method to print out name and score*/
  public String toString(){
   String result = ""; 
   result += menu;
   result += "\n" + totalScore;
   
   return result; 
  }
  /*compareTo method compares the totalScore of dininghalls*/
  public int compareTo (DiningHall d){
   return (int)(this.totalScore - d.totalScore); 
  }
  
  public void initializeDiningHall(String todaysMenuFile, String dataFile, String mealName){
    createMenu(todaysMenuFile, dataFile, mealName);
    calcScore();
  }
  
  
  public static void main(String[] args){
//    DiningHall tower = new DiningHall("Tower");
//    tower.createMenu("menus/tower.txt", "data/Tower_Data.tsv", "dinner");
//    System.out.println(tower);
//    
//    DiningHall stoned = new DiningHall("Stone Davis");
//    stoned.createMenu("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner");
//    System.out.println(stoned);
//    
    //DiningHallSelector.readWellesleyFresh("menus/tower.txt","dinner");
    
    //System.out.println(tower.menu.first().getName());
    //System.out.println(tower.totalScore);
  }
  
  
}