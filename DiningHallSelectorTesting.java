public class DiningHallSelectorTesting{
  
  public static void main (String[] args){
   /**/
    System.out.println("Start date and End date testing... is a helper method to readWellesleyFresh()");
    System.out.println("getStartDow(1) (Sunday): " + DiningHallSelector.getStartDow(1));
    System.out.println("getEndDow(1) (Monday): " + DiningHallSelector.getEndDow(1) +"\n");
    
    System.out.println("getStartDow(2) (Monday): " + DiningHallSelector.getStartDow(2));
    System.out.println("getEndDow(2) (Tuesday): " + DiningHallSelector.getEndDow(2)+"\n");
    
    System.out.println("getStartDow(7) (Saturday): " + DiningHallSelector.getStartDow(7));
    System.out.println("getStartDow(7) (Sunday): " + DiningHallSelector.getEndDow(7)+"\n");
    
    
    System.out.println("Bates Menus:");
    System.out.println("Sunday Lunch :\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner :\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +DiningHallSelector.readWellesleyFresh("menus/bates.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +DiningHallSelector.readWellesleyFresh("menus/bates.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","dinner", 4) +"\n");
    
    System.out.println("Thursday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bates.txt","dinner", 7) +"\n");
   
    
    System.out.println("Lulu Menus:");
    System.out.println("Sunday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +DiningHallSelector.readWellesleyFresh("menus/bplc.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +DiningHallSelector.readWellesleyFresh("menus/bplc.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","dinner", 4) +"\n");
    
    //Thursday lunch "ken Sandwich"
    System.out.println("Thursday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/bplc.txt","dinner", 7) +"\n");
    
    
    System.out.println("Pom Menus:");
    System.out.println("Sunday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","dinner", 4) +"\n");
    
    System.out.println("Thursday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/pomeroy.txt","dinner", 7) +"\n");
   
   
    System.out.println("StoneD Menus:");
    System.out.println("Sunday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","dinner", 4) +"\n");
    
    System.out.println("Thursday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/stonedavis.txt","dinner", 7) +"\n");
    
    
    System.out.println("Tower Menus:");
    System.out.println("Sunday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","lunch", 1)+"\n");
    System.out.println("Sunday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","dinner", 1)+"\n");
    
    System.out.println("Monday Lunch:\n" +DiningHallSelector.readWellesleyFresh("menus/tower.txt","lunch", 2) +"\n");
    System.out.println("Monday Dinner:\n" +DiningHallSelector.readWellesleyFresh("menus/tower.txt","dinner", 2) +"\n");
    
    System.out.println("Tuesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","lunch", 3) +"\n");
    System.out.println("Tuesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","dinner", 3) +"\n");
    
    System.out.println("Wednesday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","lunch", 4) +"\n");
    System.out.println("Wednesday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","dinner", 4) +"\n");
    
    System.out.println("Thursday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","lunch", 5) +"\n");   
    System.out.println("Thursday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","dinner", 5) +"\n");
    
    System.out.println("Friday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","lunch", 6) +"\n");
    System.out.println("Friday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","dinner", 6) +"\n");
    
    System.out.println("Saturday Lunch:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","lunch", 7) +"\n");
    System.out.println("Saturday Dinner:\n" + DiningHallSelector.readWellesleyFresh("menus/tower.txt","dinner", 7) +"\n");
  }
  
  
}