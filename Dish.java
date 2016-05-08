/*Dish.java
 *Last updated: 1 May 2016
 *Authors: Emma Lurie
 *Notes: the Dish class creates a Dish object which represents a single menu item at any dining hall. Every dish has a name and a score. Both instance
 variables have getters and setters. The Dish class implements the Comparable interface. A Dish is considered greater than another Dish if
 it has a higher score*/

/* All the methods are commented */

public class Dish implements Comparable<Dish>{
  
  private String name; 
  private double score; 
  
  //Two constructors 
  public Dish(String name){
    this.name = name; 
    this.score = 0.0; 
  }
  
  public Dish(String name, int score){
    this.name = name; 
    this.score = score;
  }
  
  
  //getters and setters
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
  
  
  /*shortens a dish's name to the first 45 chars to put on GUI*/
  public String shortenName(){
    return (name.length() > 46 ? name.substring(0,45) + "...": name);
  }
  

  /*If a Dish's score is greater than another Dish's, a number greater than 1 is returned, 
   * if they have the same score then 0 is returend, and if a Dish's score is less another Dish's, a number less than 0 is returned*/
  public int compareTo(Dish other){
    if (this.score > other.score)  return 1;  
    if (this.score == other.score) return 0; 
    return -1;
    }
  
  
  /*toString() method returns the name and score of a dish*/
  public String toString(){
   String result = "";
   result += name + "\t" + score + "\n"; 
   return result; 
  }
  
}