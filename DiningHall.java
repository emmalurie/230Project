import javafoundations.*; 
public class DiningHall {
  
  private ArrayQueue<Dish> menu; 
  private String name; 
  private int totalScore; 
  
  public DiningHall(String name){
    ArrayQueue<Dish> menu = new ArrayQueue<Dish>(); 
    this.name = name; 
    totalScore = 0; 
  }
  
  public String getName(){
   return name;  
  }
  
  public double totalScore
  
}