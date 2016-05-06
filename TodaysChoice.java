import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class TodaysChoice extends JPanel{
  
  private JButton lunchButton, dinnerButton;
  private JPanel lunchButtonPanel, dinnerButtonPanel, lunchPanel, dinnerPanel, instructionsPanel, resultsPanel;
  private String meal; 
  private DiningHallSelector selector;
  private JLabel lunchFirst, lunchSecond, lunchThird, dinnerFirst, dinnerSecond, dinnerThird, instructions;
  
  public TodaysChoice(){
    setLayout(new BorderLayout());
    
    Color lightBlue = new Color(135, 206, 250);
    Color lightPurple = new Color(216,191,216);
    Color seaGreen = new Color(143,188,143);
    
    
    Font titleFont = new Font ("Marker Felt" , Font.BOLD, 48);
    Font buttonFont = new Font ("Marker Felt" , Font.PLAIN, 36);
    Font textFont = new Font ("Marker Felt" , Font.PLAIN, 30);
    this.selector = selector;
    
    instructionsPanel = new JPanel();
    resultsPanel = new JPanel();
    
    instructionsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    
    lunchButtonPanel = new JPanel();
    dinnerButtonPanel = new JPanel();
    
    lunchPanel = new JPanel();
    dinnerPanel = new JPanel();
    
    instructionsPanel.setBackground(lightBlue);
    lunchButtonPanel.setBackground(lightPurple);
    lunchPanel.setBackground(lightBlue);
    dinnerButtonPanel.setBackground(lightPurple);
    dinnerPanel.setBackground(lightBlue);
    
    
    
    lunchButton = new JButton("Lunch");
    dinnerButton = new JButton("Dinner");
    
    lunchButton.setFont(buttonFont);
    dinnerButton.setFont(buttonFont);
    
    lunchButton.setForeground(Color.BLACK);
    dinnerButton.setForeground(Color.BLACK);
    
    lunchFirst = new JLabel();
    lunchSecond = new JLabel();
    lunchThird = new JLabel();

    
    dinnerFirst = new JLabel();
    dinnerSecond = new JLabel();
    dinnerThird = new JLabel();
    
    //center text
    lunchFirst.setHorizontalAlignment(JLabel.CENTER);
    lunchSecond.setHorizontalAlignment(JLabel.CENTER);
    lunchThird.setHorizontalAlignment(JLabel.CENTER);
    
    dinnerFirst.setHorizontalAlignment(JLabel.CENTER);
    dinnerSecond.setHorizontalAlignment(JLabel.CENTER);
    dinnerThird.setHorizontalAlignment(JLabel.CENTER);
    
    //set font 
     lunchFirst.setFont(textFont);
    lunchSecond.setFont(textFont);
    lunchThird.setFont(textFont);
    
    dinnerFirst.setFont(textFont);
    dinnerSecond.setFont(textFont);
    dinnerThird.setFont(textFont);
    
    instructions = new JLabel("A good meal is just a click away!", JLabel.CENTER);
    instructions.setFont(titleFont);
    
    
    ButtonListener listener = new ButtonListener();
    
    
    lunchButton.addActionListener(listener);
    dinnerButton.addActionListener(listener);
    
    
    

    
    //add buttons and result text
    lunchButtonPanel.add(lunchButton);
    lunchButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    lunchPanel.add(lunchButtonPanel);
    
    lunchPanel.setLayout(new GridLayout(4,1));
    lunchPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    
    dinnerPanel.setLayout(new GridLayout(4,1));
    dinnerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    
    lunchPanel.add(lunchFirst);
    lunchPanel.add(lunchSecond);
    lunchPanel.add(lunchThird);

    
    dinnerButtonPanel.add(dinnerButton);
    dinnerButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    dinnerPanel.add(dinnerButtonPanel);
    
    dinnerPanel.add(dinnerFirst);
    dinnerPanel.add(dinnerSecond);
    dinnerPanel.add(dinnerThird);

    //add instructions to instruction panel
    instructionsPanel.add(instructions);
    
    
//set results panel layout and add lunch and dinner panel
    resultsPanel.setLayout(new GridLayout(2, 1));
    resultsPanel.add(lunchPanel);
    resultsPanel.add(dinnerPanel);
    
    
    
    
    add(instructionsPanel, BorderLayout.NORTH);
    add(resultsPanel, BorderLayout.CENTER);
    
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