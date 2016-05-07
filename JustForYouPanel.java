/*JustForYouPanel.java
 *Last updated: 7 May 2016
 *Authors: Emma Lurie and Dorothy Sun
 *About: 
 */


/* To debug: 
 * click twice, the result chanegs
 * stoneD, nullpointerexception
 * 
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;


public class JustForYouPanel extends JPanel{
  private String meal;
  private DiningHallSelector lunchSelector, dinnerSelector;
  
  private JPanel lunchPanel, dinnerPanel, entirePanel, instructionPanel;
  private JPanel topPanel, bottomPanel;
  private JPanel lunchButtonPanel, dinnerButtonPanel, lunchResultPanel, dinnerResultPanel;
  private JCheckBox ldish1, ldish2, ldish3, ldish4, ldish5;
  private JCheckBox ddish1, ddish2, ddish3, ddish4, ddish5;

  private JButton lunchButton, dinnerButton;  
  private JLabel lunchFirst, lunchSecond, lunchRec, dinnerFirst, dinnerSecond, dinnerRec,instructionLabel;
  
  public JustForYouPanel(){
    //initialize selectors
    lunchSelector = new DiningHallSelector();
    dinnerSelector = new DiningHallSelector();
    
    lunchSelector.initializeAll("lunch");
    dinnerSelector.initializeAll("dinner");
    
    //checkboxes   
    ldish1 = new JCheckBox (lunchSelector.getBates().getTop().getName());
    ldish2 = new JCheckBox (lunchSelector.getLulu().getTop().getName());
    ldish3 = new JCheckBox (lunchSelector.getPom().getTop().getName());
    
    if (!lunchSelector.isWeekend()) ldish4 = new JCheckBox (lunchSelector.getStoned().getTop().shortenName());//stone davis closed on weekends and does not have a top value 
    
    ldish5 = new JCheckBox (lunchSelector.getTower().getTop().getName());
    
    ddish1 = new JCheckBox (dinnerSelector.getBates().getTop().getName());
    ddish2 = new JCheckBox (dinnerSelector.getLulu().getTop().getName());
    ddish3 = new JCheckBox (dinnerSelector.getPom().getTop().getName());
    if (!dinnerSelector.isWeekend()) ddish4 = new JCheckBox (dinnerSelector.getStoned().getTop().shortenName());//stone davis closed on weekends and does not have a top value 
    ddish5 = new JCheckBox (dinnerSelector.getTower().getTop().getName());
    
    //panels 
    lunchPanel = new JPanel();
    dinnerPanel = new JPanel();
    entirePanel = new JPanel();
    
    lunchButtonPanel = new JPanel();
    dinnerButtonPanel = new JPanel();
    
    topPanel = new JPanel();
    bottomPanel = new JPanel();
    
    lunchResultPanel = new JPanel();
    dinnerResultPanel = new JPanel();
    
    //buttons 
    lunchButton = new JButton("See My Lunch");
    dinnerButton = new JButton("See My Dinner");
    
    //listeners
    ButtonListener listener = new ButtonListener();
    lunchButton.addActionListener(listener);
    dinnerButton.addActionListener(listener);
    
    //labels 
    instructionLabel = new JLabel("Talior Your Meal by Your Preferences!", JLabel.CENTER);
    
    lunchFirst = new JLabel();
    lunchSecond = new JLabel();
    lunchRec = new JLabel();
    
    dinnerFirst = new JLabel();
    dinnerSecond = new JLabel();
    dinnerRec = new JLabel();
    
    //fonts 
    setFonts();
    
    //layout
    setLayout (new BoxLayout (this, BoxLayout.Y_AXIS)); 
    
    lunchPanel.setLayout (new GridLayout (5, 1));
    dinnerPanel.setLayout (new GridLayout (5, 1));
    
    entirePanel.setLayout (new GridLayout (2, 1));
    
    topPanel.setLayout (new BoxLayout (topPanel, BoxLayout.Y_AXIS));
    bottomPanel.setLayout (new BoxLayout (bottomPanel, BoxLayout.Y_AXIS));
    
    lunchResultPanel.setLayout (new GridLayout (3, 1));
    dinnerResultPanel.setLayout (new GridLayout (3, 1));
    
    //center text
    lunchFirst.setHorizontalAlignment(JLabel.CENTER);
    lunchSecond.setHorizontalAlignment(JLabel.CENTER);
    lunchRec.setHorizontalAlignment(JLabel.CENTER);
    
    dinnerFirst.setHorizontalAlignment(JLabel.CENTER);
    dinnerSecond.setHorizontalAlignment(JLabel.CENTER);
    dinnerRec.setHorizontalAlignment(JLabel.CENTER);
    
   // set colors
    Color lightBlue = new Color(135, 206, 250);
    Color lightPurple = new Color(216,191,216);
    
    instructionPanel = new JPanel();
    instructionPanel.add(instructionLabel);
    instructionPanel.setPreferredSize(new Dimension(1500,100));
    
    instructionPanel.setBackground(lightBlue);
    lunchPanel.setBackground(lightPurple);
    lunchPanel.setPreferredSize(new Dimension(1500,300));
    lunchButtonPanel.setBackground(lightBlue);
    lunchButtonPanel.setPreferredSize(new Dimension(1500,100));
    lunchResultPanel.setBackground(lightPurple);
    lunchResultPanel.setPreferredSize(new Dimension(1500,300));
    
    dinnerPanel.setBackground(lightBlue);
    dinnerPanel.setPreferredSize(new Dimension(1500,300));
    dinnerButtonPanel.setBackground(lightPurple);
    dinnerButtonPanel.setPreferredSize(new Dimension(1500,100));
    dinnerResultPanel.setBackground(lightBlue);
    dinnerResultPanel.setPreferredSize(new Dimension(1500,300));

    //add buttons to button panels 
    lunchButtonPanel.add(lunchButton);
    dinnerButtonPanel.add(dinnerButton);
    
    
    //add top dishes to panels
    lunchPanel.add(ldish1);
    lunchPanel.add(ldish2);
    lunchPanel.add(ldish3);
    if(!lunchSelector.isWeekend()) lunchPanel.add(ldish4);
    lunchPanel.add(ldish5);
    
    dinnerPanel.add(ddish1);
    dinnerPanel.add(ddish2);
    dinnerPanel.add(ddish3);
    if(!dinnerSelector.isWeekend())dinnerPanel.add(ddish4);
    dinnerPanel.add(ddish5);
    
    //add best choices to panel
    lunchResultPanel.add(lunchFirst);
    lunchResultPanel.add(lunchRec);
    lunchResultPanel.add(lunchSecond);
    

    dinnerResultPanel.add(dinnerFirst);
    dinnerResultPanel.add(dinnerRec);
    dinnerResultPanel.add(dinnerSecond);
      
    //entirePanel.add(instructionLabel);
    topPanel.add(lunchPanel);
    topPanel.add(lunchButtonPanel);
    topPanel.add(lunchResultPanel);
    
    bottomPanel.add(dinnerPanel);
    bottomPanel.add(dinnerButtonPanel);
    bottomPanel.add(dinnerResultPanel);
    
    //border 
    instructionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    lunchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    lunchButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    lunchResultPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    
    dinnerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    dinnerButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    dinnerResultPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    
    entirePanel.add(topPanel);
    entirePanel.add(bottomPanel);
    
    add(instructionPanel);
    add(entirePanel);
    
  }
  
  private void setFonts(){
    Font textFont = new Font ("Marker Felt" , Font.PLAIN, 24);
    Font titleFont = new Font ("Marker Felt" , Font.BOLD, 40);
    Font buttonFont = new Font ("Marker Felt" , Font.PLAIN, 30);
    boolean isWeekend = lunchSelector.isWeekend();
    
   //check box font 
   JCheckBox [] checkBox; 
   JLabel [] labels; 
   if (isWeekend){
   checkBox = new JCheckBox[] {ldish1, ldish2, ldish3,  ldish5 ,ddish1, ddish2, ddish3, ddish5};
   } else {
      checkBox = new JCheckBox[] {ldish1, ldish2, ldish3, ldish4, ldish5 ,ddish1, ddish2, ddish3, ddish4, ddish5};
   }
   
    for (int i = 0; i < checkBox.length; i++){
     checkBox[i].setFont(textFont); 
    }
    
    instructionLabel.setFont(titleFont);
    
    //JButton font 
    lunchButton.setFont(buttonFont);
    dinnerButton.setFont(buttonFont);
    
    //Result font
    JLabel [] results; 
    results = new JLabel [] {lunchFirst, lunchSecond, lunchRec, dinnerFirst, dinnerSecond, dinnerRec};
    for (int i = 0; i < results.length; i++){
      results[i].setFont(textFont); 
    }
    
    
  }
  
  
  private class ButtonListener implements ActionListener {
    
    public void actionPerformed (ActionEvent event){

      if (event.getSource() == lunchButton){
        meal = "lunch"; 
        lunchSelector = new DiningHallSelector();
        lunchSelector.initializeAll(meal);
      }else {
        meal = "dinner";
        dinnerSelector = new DiningHallSelector();
        dinnerSelector.initializeAll(meal);
      }


      String topChoice;
      double score; 
      
      if (meal.equals("lunch")){
        if (ldish1.isSelected()){
          score = lunchSelector.getBates().getAverageScore(); 
          lunchSelector.getBates().setAverageScore(score+1.0);
        }
        
        if (ldish2.isSelected()){
          score = lunchSelector.getLulu().getAverageScore(); 
          lunchSelector.getLulu().setAverageScore(score+1.0);
        }
        
        if (ldish3.isSelected()){
          score = lunchSelector.getPom().getAverageScore();
          lunchSelector.getPom().setAverageScore(score+1.0);
        }
        
        if (!lunchSelector.isWeekend()){
        if (ldish4.isSelected()){
          score = lunchSelector.getStoned().getAverageScore();
          lunchSelector.getStoned().setAverageScore(score+1.0);
        }
        }
        
        if (ldish5.isSelected()){
          score = lunchSelector.getTower().getAverageScore(); 
          lunchSelector.getTower().setAverageScore(score+1.0); 
        }
        
        DiningHall[] topTwo = lunchSelector.getTopTwoDiningHalls();
        topChoice = topTwo[0].getName();
        
        lunchFirst.setText("The best dining hall for lunch today is " + topChoice + "!!!"); 
        lunchRec.setText("At " + topChoice + ", we recommend you try " + topTwo[0].getTop().shortenName()+ ")");
        lunchSecond.setText("If you can't make it to " + topChoice +", another great choice is " + topTwo[1].getName()+"!"); 
      }else {
        
        if (ddish1.isSelected()){
          score = dinnerSelector.getBates().getAverageScore(); 
          dinnerSelector.getBates().setAverageScore(score+1.0);
        }
        
        if (ddish2.isSelected()){
          score = dinnerSelector.getLulu().getAverageScore(); 
          dinnerSelector.getLulu().setAverageScore(score+1.0); 
        }
        
        if (ddish3.isSelected()){
          score = dinnerSelector.getPom().getAverageScore(); 
          dinnerSelector.getPom().setAverageScore(score+1.0);
        }
        
        if (!lunchSelector.isWeekend()){
        if (ddish4.isSelected()){
          score = dinnerSelector.getStoned().getAverageScore(); 
          dinnerSelector.getStoned().setAverageScore(score+1.0);
        }
        }
        
        if (ddish5.isSelected()){
          score = dinnerSelector.getTower().getAverageScore(); 
          dinnerSelector.getTower().setAverageScore(score+1.0);
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




