
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JustForYouPanel extends JPanel{
  private String meal;
  private JPanel lunchPanel, dinnerPanel;
  private JCheckBox ldish1, ldish2, ldish3, ldish4, ldish5;
  private JCheckBox ddish1, ddish2, ddish3, ddish4, ddish5;
  private DiningHallSelector lunchSelector, dinnerSelector;
  

  
  public JustForYouPanel(){
    setLayout(new BorderLayout());
    
    Color lightBlue = new Color(135, 206, 250);
    Color lightPurple = new Color(216,191,216);
    
    Font titleFont = new Font ("Marker Felt" , Font.BOLD, 48);
    Font buttonFont = new Font ("Marker Felt" , Font.PLAIN, 36);
    Font textFont = new Font ("Marker Felt" , Font.PLAIN, 30);
    this.lunchSelector = initializeAll("lunch");
    this.dinnerSelector = initializeAll("dinner");
    this.lunchPanel = new JPanel();
    this.dinnerPanel = new JPanel();
    
//    instructionsPanel = new JPanel();
//    resultsPanel = new JPanel();
    
    ldish1 = new JCheckBox (lunchSelector.getBates().getTop().getName());
    ldish2 = new JCheckBox (lunchSelector.getLulu().getTop().getName());
    ldish3 = new JCheckBox (lunchSelector.getPom().getTop().getName());
    ldish4 = new JCheckBox (lunchSelector.getStoned().getTop().getName());
    ldish5 = new JCheckBox (lunchSelector.getTower().getTop().getName());
    
    ddish1 = new JCheckBox (dinnerSelector.getBates().getTop().getName());
    ddish2 = new JCheckBox (dinnerSelector.getLulu().getTop().getName());
    ddish3 = new JCheckBox (dinnerSelector.getPom().getTop().getName());
    ddish4 = new JCheckBox (dinnerSelector.getStoned().getTop().getName());
    ddish5 = new JCheckBox (dinnerSelector.getTower().getTop().getName());
    
    lunchPanel.add(ldish1);
    lunchPanel.add(ldish2);
    lunchPanel.add(ldish3);
    lunchPanel.add(ldish4);
    lunchPanel.add(ldish5);
    
    dinnerPanel.add(ddish1);
    dinnerPanel.add(ddish2);
    dinnerPanel.add(ddish3);
    dinnerPanel.add(ddish4);
    dinnerPanel.add(ddish5);
    
    add(lunchPanel);
    add(dinnerPanel);
    
  }
  
private class ButtonListener implements ActionListener {
  
    public void actionPerformed (ActionEvent event){
      if (event.getSource() == lunchButton){
        meal = "lunch"; 
      }else {
        meal = "dinner";
      }
      System.out.println(meal);
      
      DiningHallSelector selector = new DiningHallSelector();
      
      selector.initializeAll(meal);
      DiningHall[] topThree = selector.getTopThreeDiningHalls();
      
      
      if (meal.equals("lunch")){
        lunchFirst.setText("The best dining hall today is:  " + topThree[0].getName()); 
        lunchSecond.setText("Another great choice is " + topThree[1].getName()); 
        lunchThird.setText("At " + topThree[0].getName() + " we recommend you try " + topThree[0].getTop().getName());
      }else {
        dinnerFirst.setText("1. " +  topThree[0].getName()); 
        dinnerSecond.setText("2. " +  topThree[1].getName()); 
        dinnerThird.setText("3. " +   topThree[2].getName()); 

      
    }
  }
}
  
  
  
  
  
}