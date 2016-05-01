public class Dish implements Comparable<Dish>{
  
  private String name; 
  private double score; 
  
  public Dish(String name){
    this.name = name; 
    this.score = 0.0; 
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
    if (other.getScore() < this.score){
     return -1;  
    } else if(other.getScore() == this.score){
     return 0;  
    } else {
     return -1; 
    }
  }
}