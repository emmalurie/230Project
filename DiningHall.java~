import javafoundations.*; 
public class DiningHall {
  
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
  
  public void calcScore(){
    ArrayQueue<Dish> menuClone = copyMenu(); //clone of menu
    int score = 0;
    
    for (int i = 0; i < menu.size(); i++){
      score+= menu.dequeue().getScore();
    }
    totalScore = score;
  }
  
  
}