import java.awt.*;
import java.awt.event.*; 
import javax.swing.*; 

public class TodaysChoice extends JPanel{
  
  private JButton lunchButton, dinnerButton;
  private JPanel lunchButtonPanel, dinnerButtonPanel, lunchPanel, dinnerPanel, instructionsPanel, resultsPanel;
  private String meal; 
  private DiningHallSelector selector;
  private JLabel lunchFirst, lunchSecond, lunchRec, dinnerFirst, dinnerSecond, dinnerRec, instructions;

  public TodaysChoice(){
    setLayout(new BorderLayout());
    
    Color lightBlue = new Color(135, 206, 250);
    Color lightPurple = new Color(216,191,216);
    Color seaGreen = new Color(143,188,143);
    
    
    Font titleFont = new Font ("Marker Felt" , Font.BOLD, 54);
    Font buttonFont = new Font ("Marker Felt" , Font.PLAIN, 48);
    Font textFont = new Font ("Marker Felt" , Font.PLAIN, 36);
    
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
    lunchRec = new JLabel();

    
    dinnerFirst = new JLabel();
    dinnerSecond = new JLabel();
    dinnerRec = new JLabel();
    
    //center text
    lunchFirst.setHorizontalAlignment(JLabel.CENTER);
    lunchSecond.setHorizontalAlignment(JLabel.CENTER);
    lunchRec.setHorizontalAlignment(JLabel.CENTER);
    
    dinnerFirst.setHorizontalAlignment(JLabel.CENTER);
    dinnerSecond.setHorizontalAlignment(JLabel.CENTER);
    dinnerRec.setHorizontalAlignment(JLabel.CENTER);
    
    //set font 
     lunchFirst.setFont(textFont);
    lunchSecond.setFont(textFont);
    lunchRec.setFont(textFont);
    
    dinnerFirst.setFont(textFont);
    dinnerSecond.setFont(textFont);
    dinnerRec.setFont(textFont);
    
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
    lunchPanel.add(lunchRec);
    lunchPanel.add(lunchSecond);


    
    dinnerButtonPanel.add(dinnerButton);
    dinnerButtonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    dinnerPanel.add(dinnerButtonPanel);
    
    dinnerPanel.add(dinnerFirst);
    dinnerPanel.add(dinnerRec);
    dinnerPanel.add(dinnerSecond);


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
       String topChoice;
      if (event.getSource() == lunchButton){
        meal = "lunch"; 
      }else {
        meal = "dinner";
      }
      System.out.println(meal);
      
      DiningHallSelector selector = new DiningHallSelector();
      
      selector.initializeAll(meal);
      DiningHall[] topTwo = selector.getTopTwoDiningHalls();
      topChoice = topTwo[0].getName();
      if (meal.equals("lunch")){
        lunchFirst.setText("The best dining hall for lunch today is " + topChoice + "!!!"); 
        lunchRec.setText("At " + topChoice + ", we recommend you try " + topTwo[0].getTop().shortenName()+ ")");
        lunchSecond.setText("If you can't make it to " + topChoice +", another great choice is " + topTwo[1].getName()+"!"); 

      }else {
        dinnerFirst.setText("The best dining hall for dinner today is " + topChoice + "!!!"); 
        dinnerRec.setText("(At " + topChoice + ", we recommend you try " + topTwo[0].getTop().shortenName()+ ")");
        dinnerSecond.setText("If you can't make it to " + topChoice +", another great choice is " + topTwo[1].getName() +"!"); 

      
    }
  }
}
}