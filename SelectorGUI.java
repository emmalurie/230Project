/*SelectorGUI.java
 *Last updated: 7 May 2016
 *Author: Emma Lurie
 *About: Set up the SelectorGUI that connects three panels: InstructionsPanel, TodaysChoice, JustForYouPanel
 * Set the dimension. 
 */

import javax.swing.*; 
import java.awt.*; 

public class SelectorGUI{
  
  public static void main(String[] args){
    JFrame frame = new JFrame("Palate Tailor"); //new frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    JTabbedPane tp = new JTabbedPane(); 
  
    tp.addTab("Instructions", new InstructionsPanel()); 
    tp.addTab("Today�s Choice", new TodaysChoice()); 
    tp.addTab("Just for You", new JustForYouPanel()); 
    
    frame.getContentPane().add(tp); //add tabbed pane to frame
    frame.setPreferredSize(new Dimension(1450,800)); //set size
    frame.pack(); 
    frame.setVisible(true); 
  }
  
  
}
