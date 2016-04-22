/* reads from web menu and writes menu to txt file*/
import java.util.*;
import java.io.*;
import java.net.*;

public class DiningHallSelector {
  
//  public DiningHallSelector(){
//    
//    
//  }
  
  
  public static void readWellesleyFresh (String urlName) {
    try {
      String outFileName = "TowerLunch.txt";
      URL u = new URL(urlName);
      Scanner urlScan = new Scanner( u.openStream() ); // will throw exception
      
      while (urlScan.hasNext()) {
        String line = urlScan.nextLine();
       System.out.println(line);
      }
    } catch (IOException ex) {
      System.out.println(ex);
    }
  }
  
  public static void main(String[] args){
   String base = "http://gateway-a.watsonplatform.net/calls/url/URLGetText";
   String key = "72118830908c35b643c14c099a6793e89bf4397d"; 
   String wURL = "http://www.wellesleyfresh.com/bae-pao-lu-chow.html";
   String url = base + "?apikey="+ key + "&url=" +wURL;
   readWellesleyFresh(url);
    
  }
  
  
  
  
}