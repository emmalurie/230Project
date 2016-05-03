import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class TodaysChoice extends JPanel{
  
  private JButton lunchButton, dinnerButton;
  private JPanel lunchPanel, dinnerPanel;
  private String meal; 
  private DiningHallSelector selector;
  
  public TodaysChoice(DiningHallSelector selector){
    
    //this.selector = selector;
    
    lunchPanel = new JPanel();
    dinnerPanel = new JPanel();
    
    lunchButton = new JButton("Lunch");
    dinnerButton = new JButton("Dinner");
    
    ButtonListener listener = new ButtonListener();
    
    lunchButton.addActionListener(listener);
    dinnerButton.addActionListener(listener);
    
    lunchPanel.add(lunchButton);
    dinnerPanel.add(dinnerButton);
    
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
    //selector.initializeAll(meal);
  }
}
}