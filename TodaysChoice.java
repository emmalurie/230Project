import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class TodaysChoice extends JPanel{
  
  private JButton lunchButton, dinnerButton;
  private JPanel lunchPanel, dinnerPanel, resultPanel;
  private String meal; 
  private DiningHallSelector selector;
  private JLabel resultText; 
  
  public TodaysChoice(DiningHallSelector selector){
    
    this.selector = selector;
    
    lunchPanel = new JPanel();
    dinnerPanel = new JPanel();
    resultPanel = new JPanel();
    
    lunchButton = new JButton("Lunch");
    dinnerButton = new JButton("Dinner");
    
    resultText = new JLabel();
    
    ButtonListener listener = new ButtonListener();
    
               
    lunchButton.addActionListener(listener);
    dinnerButton.addActionListener(listener);
    
    lunchPanel.add(lunchButton);
    dinnerPanel.add(dinnerButton);
    resultPanel.add(resultText);
    
    add(lunchPanel);
    add(dinnerPanel);
    add(resultPanel);
    
  }
  
  private class ButtonListener implements ActionListener {
  
  public void actionPerformed (ActionEvent event){
    if (event.getSource() == lunchButton){
      meal = "lunch"; 
    }else {
      meal = "dinner";
    }
    System.out.println(meal);
    selector.initializeAll(meal);
    resultText.setText("The result is: " + selector.getBestDiningHall().getName());


  }
}
}