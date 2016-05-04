/*DiningHall.java
 *Last updated: 3 May 2016
 *Authors: Emma Lurie and Dorothy Sun
 *About: Each dining hall is reprented by a DiningHall object. DiningHall objects have a name (ie "Tower") a totalScore,
 *and a menu (a PriorityQueue<Dish>) that holds Dish objects that represent what is being
 *at a given meal at that dining hall. Besides the three instance variables mentioned previously the class contains getters, a createMenu() method that adds all
 *Dishes that appear in the hashtable to the menu. There is also a toString() method.
 * 
 To do: should change ArrayQueue to PriorityQueue,Dorothy
 
 "Crispy Calamari, Fried Calamari with Sweet Chili Soy Sauce, Vegetable Tempura (VE), Flash Fried Vegetables, Sweet & Sour Dipping Sauce." for Tuesday's lunch cannot be found in the hashtable...it's there. not
 srue why it is throwing an error*/

import javafoundations.*; 
import java.util.*;

public class DiningHall implements Comparable<DiningHall>{
  
  private PriorityQueue<Dish> menu; 
  private String name; 
  private double averageScore; //average score of dishes
  //maybe specify meal booleans (lunch and dinner)
  
  public DiningHall(String name){
    menu = new PriorityQueue<Dish>();  
    this.name = name; 
    averageScore = 0.0; 
  }
  
  public String getName(){
    return name;  
  }
  
  public PriorityQueue<Dish> getMenu(){
    return menu;  
  }
  
  public double getAverageScore(){
    return averageScore;  
  }

  //adds a dish to 
  private void addToMenu(Dish d){
    try {
      //the dish object is being passed, but it is not being enqueued
      menu.offer(d);
    } catch (NullPointerException n){
      System.out.println(d.getName() + " is throwing a null pointer"); 
    }
  }
  
  private PriorityQueue<Dish> copyMenu(){
    //is there a better way to clone a queue? 
    PriorityQueue<Dish> temp = new PriorityQueue<Dish>(); 
    PriorityQueue<Dish> copy = new PriorityQueue<Dish>();
    
    
    while(!menu.isEmpty()){
      Dish element = menu.poll();
      temp.offer(element);
      copy.offer(element);
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
        this.addToMenu(data.get(dishName));
      }else {
        //System.out.println(dishName.substring(0,30) + "... could not addded to menu ");
      }
    }
    
  }
  
  
  
  /*calculates the score of the menu*/
  public double calcScore(){
    PriorityQueue<Dish> menuClone = copyMenu(); //clone of menu
    int score = 0;
    try{
    for (int i = 0; i < menu.size(); i++){
      try {
      score+= menuClone.poll().getScore();
      
      }catch(Exception ex){
       System.out.println("No objects are in the menu"); 
      }
    }
    averageScore = score/menu.size();
    return averageScore;
    }catch(Exception e){
      return -1;
    }
}
  
  /*need to improve toString method to print out name and score*/
  public String toString(){
    String result = ""; 
    result += menu;
    result += "\n" + averageScore;
    
    return result; 
  }
  
  /*compareTo method compares the totalScore of dininghalls*/
  public int compareTo (DiningHall d){
    return (int)(this.averageScore - d.averageScore); 
  }
  
  public void initializeDiningHall(String todaysMenuFile, String dataFile, String mealName){
    createMenu(todaysMenuFile, dataFile, mealName);
    calcScore();
  }
 
  
  
  public static void main(String[] args){
    
    DiningHall bates = new DiningHall("Bates");
    DiningHall lulu = new DiningHall("Lulu");
    DiningHall pom  = new DiningHall("Pomeroy");
    DiningHall stoned = new DiningHall("Stone Davis");
    DiningHall tower = new DiningHall("Tower");
    


    bates.createMenu("menus/bates.txt", "data/Bates_data.tsv", "lunch");
    bates.calcScore();
    System.out.println(bates);
    System.out.println(bates.menu.size()+"\n\n");

    //bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch");
    //System.out.println(bates);    
//    bates.createMenu("menus/bates.txt", "data/Bates_data.tsv", "lunch");
//    bates.calcScore();
//    System.out.println(bates);
    
    
    lulu.createMenu("menus/bplc.txt", "data/Lulu_Data.tsv", "lunch");
    lulu.calcScore();
    System.out.println(lulu);
    System.out.println(lulu.menu.size()+"\n\n");
    
    pom.createMenu("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch");
    pom.calcScore();
    System.out.println(pom);
    System.out.println(pom.menu.size()+"\n\n");
    
    stoned.createMenu("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch");
    stoned.calcScore();
    System.out.println(stoned);
    System.out.println(stoned.menu.size()+"\n\n");
    
    tower.createMenu("menus/tower.txt", "data/Tower_Data.tsv", "lunch");
    tower.calcScore();
    System.out.println(tower);
    System.out.println(tower.menu.size()+"\n\n");

//    bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch");
//    System.out.println(bates);    
//    bates.createMenu("menus/bates.txt", "data/Bates_data.tsv", "lunch");
//    bates.calcScore();
//    System.out.println(bates);
//    
//    
//    lulu.createMenu("menus/bplc.txt", "data/Lulu_Data.tsv", "lunch");
//    lulu.calcScore();
//    System.out.println(lulu);
//    
//    pom.createMenu("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch");
//    pom.calcScore();
//    System.out.println(pom);
//    
//    stoned.createMenu("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch");
//    stoned.calcScore();
//    System.out.println(stoned);
//    
//    tower.createMenu("menus/tower.txt", "data/Tower_Data.tsv", "lunch");
//    tower.calcScore();
//    System.out.println(tower);

  }
  
  
}