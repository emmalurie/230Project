
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JustForYouPanel extends JPanel{
  private String meal;
  private JPanel lunchPanel, dinnerPanel, entirePanel, instructionPanel;
  private JPanel lunchButtonPanel, dinnerButtonPanel, lunchResultPanel, dinnerResultPanel;
  private JCheckBox ldish1, ldish2, ldish3, ldish4, ldish5;
  private JCheckBox ddish1, ddish2, ddish3, ddish4, ddish5;
  private DiningHallSelector lunchSelector, dinnerSelector;
  private JButton lunchButton, dinnerButton;  
  private JLabel lunchFirst, lunchSecond, lunchRec, dinnerFirst, dinnerSecond, dinnerRec;
  
  public JustForYouPanel(){
    //setLayout(new BorderLayout());
    
    Color lightBlue = new Color(135, 206, 250);
    Color lightPurple = new Color(216,191,216);
    
    Font titleFont = new Font ("Marker Felt" , Font.BOLD, 48);
    Font buttonFont = new Font ("Marker Felt" , Font.PLAIN, 36);
    Font textFont = new Font ("Marker Felt" , Font.PLAIN, 30);
    
    lunchSelector = new DiningHallSelector();
    dinnerSelector = new DiningHallSelector();
    
    lunchFirst = new JLabel();
    lunchSecond = new JLabel();
    lunchRec = new JLabel();
    
    dinnerFirst = new JLabel();
    dinnerSecond = new JLabel();
    dinnerRec = new JLabel();
    
    this.lunchSelector.initializeAll("lunch");
    this.dinnerSelector.initializeAll("dinner");
    
    this.lunchPanel = new JPanel();
    lunchPanel.setLayout (new GridLayout (5, 1));
    this.dinnerPanel = new JPanel();
    dinnerPanel.setLayout (new GridLayout (5, 1));
    
    this.entirePanel = new JPanel();
    entirePanel.setLayout (new GridLayout (7, 1));
      
    this.instructionPanel = new JPanel();
    
    lunchButton = new JButton("See My Lunch");
    dinnerButton = new JButton("See My Dinner");
    
    ButtonListener listener = new ButtonListener();
    this.lunchButtonPanel = new JPanel();
    this.dinnerButtonPanel = new JPanel();
    
    lunchButton.addActionListener(listener);
    dinnerButton.addActionListener(listener);
    
    lunchButtonPanel.add(lunchButton);
    dinnerButtonPanel.add(dinnerButton);
    
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
    
    //center text
    lunchFirst.setHorizontalAlignment(JLabel.CENTER);
    lunchSecond.setHorizontalAlignment(JLabel.CENTER);
    lunchRec.setHorizontalAlignment(JLabel.CENTER);
    
    dinnerFirst.setHorizontalAlignment(JLabel.CENTER);
    dinnerSecond.setHorizontalAlignment(JLabel.CENTER);
    dinnerRec.setHorizontalAlignment(JLabel.CENTER);
    
    this.lunchResultPanel = new JPanel();
    lunchResultPanel.add(lunchFirst);
    lunchResultPanel.add(lunchRec);
    lunchResultPanel.add(lunchSecond);
    
    this.dinnerResultPanel = new JPanel();
    dinnerResultPanel.add(dinnerFirst);
    dinnerResultPanel.add(dinnerRec);
    dinnerResultPanel.add(dinnerSecond);
    
    
    entirePanel.add(instructionPanel);
    entirePanel.add(lunchPanel);
    entirePanel.add(lunchButtonPanel);
    entirePanel.add(lunchResultPanel);
    entirePanel.add(dinnerPanel);
    entirePanel.add(dinnerButtonPanel);
    entirePanel.add(dinnerResultPanel);
    
    add(entirePanel);
    
  }
  
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event){
      
      if (event.getSource() == lunchButton){
        meal = "lunch"; 
      }else {
        meal = "dinner";
      }
      
      String topChoice;
      
      if (meal.equals("lunch")){
        if (ldish1.isSelected()){
          double s = lunchSelector.getBates().getAverageScore(); 
          lunchSelector.getBates().setAverageScore(s+1);
        }
        
        if (ldish2.isSelected()){
          double s = lunchSelector.getLulu().getAverageScore(); 
          lunchSelector.getLulu().setAverageScore(s+1);
        }
        
        if (ldish3.isSelected()){
          double s = lunchSelector.getPom().getAverageScore();
          lunchSelector.getPom().setAverageScore(s+1);
        }
        
        if (ldish4.isSelected()){
          double s = lunchSelector.getStoned().getAverageScore();
          lunchSelector.getStoned().setAverageScore(s+1);
        }
        
        if (ldish5.isSelected()){
          double s = lunchSelector.getTower().getAverageScore(); 
          lunchSelector.getTower().setAverageScore(s+1); 
        }
        
        DiningHall[] topTwo = lunchSelector.getTopTwoDiningHalls();
        topChoice = topTwo[0].getName();
        
        lunchFirst.setText("The best dining hall for lunch today is " + topChoice + "!!!"); 
        lunchRec.setText("At " + topChoice + ", we recommend you try " + topTwo[0].getTop().shortenName()+ ")");
        lunchSecond.setText("If you can't make it to " + topChoice +", another great choice is " + topTwo[1].getName()+"!"); 
      }else {
        
        if (ddish1.isSelected()){
          double s = dinnerSelector.getBates().getAverageScore(); 
          dinnerSelector.getBates().setAverageScore(s+1);
        }
        
        if (ddish2.isSelected()){
          double s = dinnerSelector.getLulu().getAverageScore(); 
          dinnerSelector.getLulu().setAverageScore(s+1); 
        }
        
        if (ddish3.isSelected()){
          double s = dinnerSelector.getPom().getAverageScore(); 
          dinnerSelector.getPom().setAverageScore(s+1);
        }
        
        if (ddish4.isSelected()){
          double s = dinnerSelector.getStoned().getAverageScore(); 
          dinnerSelector.getStoned().setAverageScore(s+1);
        }
        
        if (ddish5.isSelected()){
          double s = dinnerSelector.getTower().getAverageScore(); 
          dinnerSelector.getTower().setAverageScore(s+1);
        }
        
        DiningHall[] topTwo = dinnerSelector.getTopTwoDiningHalls();
        topChoice = topTwo[0].getName();
        
        dinnerFirst.setText("The best dining hall for dinner today is " + topChoice + "!!!"); 
        dinnerRec.setText("(At " + topChoice + ", we recommend you try " + topTwo[0].getTop().shortenName()+ ")");
        dinnerSecond.setText("If you can't make it to " + topChoice +", another great choice is " + topTwo[1].getName() +"!"); 
        
        
      }
    }
  }
  
}




