import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class TodaysChoice extends JPanel{
  
  private JButton lunchButton, dinnerButton;
  private JPanel lunchPanel, dinnerPanel, instructionsPanel, resultsPanel;
  private String meal; 
  private DiningHallSelector selector;
  private JLabel lunchFirst, lunchSecond, lunchThird, dinnerFirst, dinnerSecond, dinnerThird, instructions;
  public TodaysChoice(){
    setLayout(new BorderLayout());
    
    Font titleFont = new Font ("Marker Felt" , Font.BOLD, 48);
    Font buttonFont = new Font ("Marker Felt" , Font.PLAIN, 36);
    Font textFont = new Font ("Marker Felt" , Font.PLAIN, 30);
    this.selector = selector;
    
    instructionsPanel = new JPanel();
    resultsPanel = new JPanel();
    
    lunchPanel = new JPanel();
    dinnerPanel = new JPanel();
    
    
    
    lunchButton = new JButton("Lunch");
    dinnerButton = new JButton("Dinner");
    
    lunchButton.setFont(buttonFont);
    dinnerButton.setFont(buttonFont);
    
    lunchButton.setForeground(Color.RED);
    dinnerButton.setForeground(Color.RED);
    
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
    lunchPanel.add(lunchButton);
    lunchPanel.setLayout(new GridLayout(4,1));
    
    dinnerPanel.setLayout(new GridLayout(4,1));
    
    lunchPanel.add(lunchFirst);
    lunchPanel.add(lunchSecond);
    lunchPanel.add(lunchThird);

    
    dinnerPanel.add(dinnerButton);
    
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
        lunchFirst.setText("1. " + topThree[0].getName()); 
        lunchSecond.setText("2. " + topThree[1].getName()); 
        lunchThird.setText("3. " +  topThree[2].getName());
      }else {
        dinnerFirst.setText("1. " +  topThree[0].getName()); 
        dinnerSecond.setText("2. " +  topThree[1].getName()); 
        dinnerThird.setText("3. " +   topThree[2].getName()); 

      
    }
  }
}
}