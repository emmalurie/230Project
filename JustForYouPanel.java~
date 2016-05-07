
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JustForYouPanel extends JPanel{
  private String meal;
  private JPanel lunchPanel, dinnerPanel, entirePanel, instructionPanel;
  private JPanel leftPanel, rightPanel;
  private JLabel instructionLabel;
  private JPanel lunchButtonPanel, dinnerButtonPanel, lunchResultPanel, dinnerResultPanel;
  private JCheckBox ldish1, ldish2, ldish3, ldish4, ldish5;
  private JCheckBox ddish1, ddish2, ddish3, ddish4, ddish5;
  private DiningHallSelector lunchSelector, dinnerSelector;
  private JButton lunchButton, dinnerButton;  
  private JLabel lunchFirst, lunchSecond, lunchRec, dinnerFirst, dinnerSecond, dinnerRec;
  
  public JustForYouPanel(){
    //setLayout(new BorderLayout());
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); 
    
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
    entirePanel.setLayout (new GridLayout (3, 2));
      
    this.instructionLabel = new JLabel("Talior Your Meal by Your Preferences!", JLabel.CENTER);
    
    lunchButton = new JButton("See My Lunch");
    dinnerButton = new JButton("See My Dinner");
    
    ButtonListener listener = new ButtonListener();
    this.lunchButtonPanel = new JPanel();
    this.dinnerButtonPanel = new JPanel();
    
    lunchButton.addActionListener(listener);
    dinnerButton.addActionListener(listener);
    
    lunchButtonPanel.add(lunchButton);
    dinnerButtonPanel.add(dinnerButton);
    
    this.leftPanel = new JPanel();
    leftPanel.setLayout (new BoxLayout (leftPanel, BoxLayout.Y_AXIS));
    this.rightPanel = new JPanel();
    rightPanel.setLayout (new BoxLayout (rightPanel, BoxLayout.Y_AXIS));
//    instructionsPanel = new JPanel();
//    resultsPanel = new JPanel();
    
    ldish1 = new JCheckBox (lunchSelector.getBates().getTop().shortenName());
    ldish2 = new JCheckBox (lunchSelector.getLulu().getTop().shortenName());
    ldish3 = new JCheckBox (lunchSelector.getPom().getTop().shortenName());
    ldish4 = new JCheckBox (lunchSelector.getStoned().getTop().shortenName());
    ldish5 = new JCheckBox (lunchSelector.getTower().getTop().shortenName());
    
    ddish1 = new JCheckBox (dinnerSelector.getBates().getTop().shortenName());
    ddish2 = new JCheckBox (dinnerSelector.getLulu().getTop().shortenName());
    ddish3 = new JCheckBox (dinnerSelector.getPom().getTop().shortenName());
    ddish4 = new JCheckBox (dinnerSelector.getStoned().getTop().shortenName());
    ddish5 = new JCheckBox (dinnerSelector.getTower().getTop().shortenName());
    
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
    lunchResultPanel.setLayout (new GridLayout (3, 1));
    lunchResultPanel.add(lunchFirst);
    lunchResultPanel.add(lunchRec);
    lunchResultPanel.add(lunchSecond);
    
    this.dinnerResultPanel = new JPanel();
    dinnerResultPanel.setLayout (new GridLayout (3, 1));
    dinnerResultPanel.add(dinnerFirst);
    dinnerResultPanel.add(dinnerRec);
    dinnerResultPanel.add(dinnerSecond);
    
    
    // set colors
    Color lightBlue = new Color(135, 206, 250);
    Color lightPurple = new Color(216,191,216);
    
    instructionPanel = new JPanel();
    instructionPanel.add(instructionLabel);
    
    instructionPanel.setBackground(lightBlue);
    lunchPanel.setBackground(lightPurple);
    lunchButtonPanel.setBackground(lightBlue);
    lunchResultPanel.setBackground(lightPurple);
    
    dinnerPanel.setBackground(lightBlue);
    dinnerButtonPanel.setBackground(lightPurple);
    dinnerResultPanel.setBackground(lightBlue);
      
    //entirePanel.add(instructionLabel);
    leftPanel.add(lunchPanel);
    leftPanel.add(lunchButtonPanel);
    leftPanel.add(lunchResultPanel);
    
    rightPanel.add(dinnerPanel);
    rightPanel.add(dinnerButtonPanel);
    rightPanel.add(dinnerResultPanel);
    
    entirePanel.add(leftPanel);
    entirePanel.add(rightPanel);
    
    add(instructionPanel);
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




