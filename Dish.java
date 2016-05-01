public class Dish implements Comparable<Dish>{
  
  private String name; 
  private double score; 
  
  public Dish(String name){
    this.name = name; 
    this.score = 0.0; 
  }
  
  public Dish(String name, int score){
    this.name = name; 
    this.score = score;
  }
  
  public String getName(){
   return this.name;  
  }
  
  public double getScore(){
   return this.score;  
  }
  
  public void setName(String name){
   this.name = name;  
  }
  
  public void setScore(double score){
   this.score = score;  
  }
  
  public int compareTo(Dish other){
   return (int)(this.score - other.score); 
    }
  
}