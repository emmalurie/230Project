public class DiningHallSelectorTesting{
  
  public static void main (String[] args){
   /*
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
    */

     
     System.out.println("Bates Menu Scored");
     
     DiningHall bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 1);
     System.out.println("Sunday Lunch:\n" +bates +"\n");
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 1);
     System.out.println("Sunday Dinner:\n" + bates+"\n");
     
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 2);
     System.out.println("Monday Lunch:\n" +bates+"\n");
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 2);
     System.out.println("Monday Dinner:\n" + bates+"\n");
     
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 3);
     System.out.println("Tuesday Lunch:\n" +bates+"\n");
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 3);
     System.out.println("Tuesday Dinner:\n" + bates+"\n");
     
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 4);
     System.out.println("Wednesday Lunch:\n" +bates+"\n");
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 4);
     System.out.println("Wednesday Dinner:\n" + bates+"\n");
     
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 5);
     System.out.println("Thursday Lunch:\n" +bates +"\n");
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 5);
     System.out.println("Thursday Dinner:\n" + bates+"\n");
    
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 6);
     System.out.println("Friday Lunch:\n" +bates+"\n");
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 6);
     System.out.println("Friday Dinner:\n" + bates+"\n");
     
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "lunch", 7);
     System.out.println("Saturday Lunch:\n" +bates+"\n");
     bates = new DiningHall("Bates");
     bates.initializeDiningHall("menus/bates.txt", "data/Bates_data.tsv", "dinner", 7);
     System.out.println("Saturday Dinner:\n" + bates+"\n");
     
     System.out.println("Lulu Menu Scored");
     DiningHall lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 1);
     System.out.println("Sunday Lunch:\n" +lulu +"\n");
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 1);
     System.out.println("Sunday Dinner:\n" + lulu+"\n");
     

     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 2);
     System.out.println("Monday Lunch:\n" +lulu +"\n");
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 2);
     System.out.println("Monday Dinner:\n" + lulu+"\n");
     
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 3);
     System.out.println("Tuesday Lunch:\n" +lulu +"\n");
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 3);
     System.out.println("Tuesday Dinner:\n" + lulu+"\n");
     
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 4);
     System.out.println("Wednesday Lunch:\n" +lulu +"\n");
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 4);
     System.out.println("Wednesday Dinner:\n" + lulu+"\n");
     
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 5);
     System.out.println("Thursday Lunch:\n" +lulu +"\n");
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 5);
     System.out.println("Thursday Dinner:\n" + lulu+"\n");
     
      lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 4);
     System.out.println("Friday Lunch:\n" +lulu +"\n");
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 4);
     System.out.println("Friday Dinner:\n" + lulu+"\n");
     
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "lunch", 7);
     System.out.println("Saturday Lunch:\n" +lulu +"\n");
     lulu = new DiningHall("Lulu");
     lulu.initializeDiningHall("menus/bplc.txt", "data/Lulu_data.tsv", "dinner", 7);
     System.out.println("Saturday Dinner:\n" + lulu+"\n");
     
     System.out.println("Pom Menu Scored");
     DiningHall pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 1);
     System.out.println("Sunday Lunch:\n" +pom +"\n");
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 1);
     System.out.println("Sunday Dinner:\n" + pom +"\n");
     

     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 2);
     System.out.println("Monday Lunch:\n" +pom +"\n");
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 2);
     System.out.println("Monday Dinner:\n" + pom+"\n");
     
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 3);
     System.out.println("Tuesday Lunch:\n" +pom +"\n");
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 3);
     System.out.println("Tuesday Dinner:\n" + pom+"\n");
     
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 4);
     System.out.println("Wednesday Lunch:\n" +pom +"\n");
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 4);
     System.out.println("Wednesday Dinner:\n" + pom+"\n");
     
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 5);
     System.out.println("Thursday Lunch:\n" +pom +"\n");
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 5);
     System.out.println("Thursday Dinner:\n" + pom+"\n");
     
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 6);
     System.out.println("Friday Lunch:\n" +pom +"\n");
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 6);
     System.out.println("Friday Dinner:\n" + pom+"\n");
     
     pom = new DiningHall("Pomeroy");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "lunch", 7);
     System.out.println("Saturday Lunch:\n" +pom +"\n");
     pom = new DiningHall("Lulu");
     pom.initializeDiningHall("menus/pomeroy.txt", "data/Pomeroy_Data.tsv", "dinner", 7);
     System.out.println("Saturday Dinner:\n" + pom+"\n");
     /*
     System.out.println("Stone Davis Menu Scored");
     DiningHall stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 1);
     System.out.println("Sunday Lunch:\n" +stoned +"\n");
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 1);
     System.out.println("Sunday Dinner:\n" + stoned +"\n");

     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 2);
     System.out.println("Monday Lunch:\n" +stoned +"\n");
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 2);
     System.out.println("Monday Dinner:\n" + stoned+"\n");
     
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 3);
     System.out.println("Tuesday Lunch:\n" +stoned +"\n");
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 3);
     System.out.println("Tuesday Dinner:\n" + stoned+"\n");
     
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 4);
     System.out.println("Wednesday Lunch:\n" +stoned +"\n");
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 4);
     System.out.println("Wednesday Dinner:\n" + stoned+"\n");
     
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 5);
     System.out.println("Thursday Lunch:\n" +stoned +"\n");
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 5);
     System.out.println("Thursday Dinner:\n" + stoned+"\n");
     
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 4);
     System.out.println("Friday Lunch:\n" +stoned +"\n");
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 4);
     System.out.println("Friday Dinner:\n" + stoned+"\n");
     
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "lunch", 7);
     System.out.println("Saturday Lunch:\n" +stoned +"\n");
     stoned = new DiningHall("Stone Davis");
     stoned.initializeDiningHall("menus/stonedavis.txt", "data/StoneDavis_Data.tsv", "dinner", 7);
     System.out.println("Saturday Dinner:\n" + stoned+"\n");
     
     
     System.out.println("Tower Menu Scored");
     DiningHall tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 1);
     System.out.println("Sunday Lunch:\n" +tower +"\n");
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 1);
     System.out.println("Sunday Dinner:\n" + tower +"\n");

     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 2);
     System.out.println("Monday Lunch:\n" +tower +"\n");
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 2);
     System.out.println("Monday Dinner:\n" + tower+"\n");
     
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 3);
     System.out.println("Tuesday Lunch:\n" +tower +"\n");
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 3);
     System.out.println("Tuesday Dinner:\n" + tower+"\n");
     
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 4);
     System.out.println("Wednesday Lunch:\n" +tower +"\n");
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 4);
     System.out.println("Wednesday Dinner:\n" + tower+"\n");
     
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 5);
     System.out.println("Thursday Lunch:\n" +tower +"\n");
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 5);
     System.out.println("Thursday Dinner:\n" + tower+"\n");
     
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 4);
     System.out.println("Friday Lunch:\n" +tower +"\n");
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 4);
     System.out.println("Friday Dinner:\n" + tower+"\n");
     
     tower = new DiningHall("Tower");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "lunch", 7);
     System.out.println("Saturday Lunch:\n" +tower +"\n");
     tower = new DiningHall("Stone Davis");
     tower.initializeDiningHall("menus/tower.txt", "data/Tower_Data.tsv", "dinner", 7);
     System.out.println("Saturday Dinner:\n" + tower+"\n");
     */
     
     
  }
  
  
  
}