/*InstructionsPanel.java
 *Last updated: 7 May 2016
 *Authors: Emma Lurie and Dorothy Sun
 *About: InstructionsPanel is the first panel that users view. 
 * It contains the general instructions of the program and lovely pictures of all the dining halls. 
 */


import java.awt.*; 
import javax.swing.*; 
import java.awt.Image;


public class InstructionsPanel extends JPanel{
  JPanel title, pics, instructions, picsAndInstructions;  
  JLabel titleText, subtitle, authorsNames; 
  JLabel bates, lulu, pom, stoned, tower, wfresh, intro, l1, l2,l3, l4,thanks, best, signed;//add open hours texts 
  
  
  public InstructionsPanel() {  
    //panels 
    title = new JPanel();
    pics = new JPanel();
    instructions = new JPanel();
    picsAndInstructions = new JPanel();

    
    //JLabels
    titleText = new JLabel("Palate Tailor");
    subtitle = new JLabel("We want to make sure you get the best meal on campus!");
    authorsNames = new JLabel("by Emma Lurie and Dorothy Sun");
    intro = new JLabel("Welcome to Palate Tailor!");
    l1 = new JLabel("If you would like to see our general recommendations of the best dining halls to eat at today," + 
                    " navigate to the 'Today’s Choice' tab.");
    l2 = new JLabel("If you would like to see our individualized recommendation of the best dining halls to eat at today based on your " + 
                    "palate, navigate to the 'Just For You' tab.");
    l3  = new JLabel("Once you have selected either the 'Today’s Choice' tab or the 'Just For You' tab,");
                       
    l4 =  new JLabel("click the 'Lunch' button to see our recommendation for lunch, or the “Dinner” button to see our recommendation for dinner.");
    thanks = new JLabel("Thanks for trying out our program.");
    best = new JLabel("Best,");
    signed = new JLabel("Emma Lurie and Dorothy Sun");
    
    
    
    
    
    
    //JLabel images
    bates = new JLabel(new ImageIcon("images/bates.png","Bates Dining Hall"));
    lulu =  new JLabel (new ImageIcon("images/lulu.png","Lulu Dining Hall"));
    pom = new JLabel (new ImageIcon("images/pom.png", "Pomeroy Dining Hall"));
    stoned = new JLabel (new ImageIcon("images/stoned.png", "Stone Davis Dining Hall"));
    tower = new JLabel (new ImageIcon("images/tower.png", "Tower Dining Hall"));
    wfresh = new JLabel (new ImageIcon("images/wellesleyfresh_logo.gif", "Wellesley Fresh Logo"));
    
    
    //setFont 
    Font titleFont = new Font ("Marker Felt" , Font.BOLD, 80);
    Font subtitleFont = new Font ("Marker Felt" , Font.PLAIN, 40);
    Font textFont = new Font ("Marker Felt" , Font.PLAIN, 30);
    Font smallText = new Font ("Marker Felt" , Font.PLAIN, 24);
    
    titleText.setFont(titleFont);
    subtitle.setFont(subtitleFont);
    authorsNames.setFont(textFont);
    
    intro.setFont(smallText);
    l1.setFont(smallText);
    l2.setFont(smallText);
    l3.setFont(smallText);
    l4.setFont(smallText);
    thanks.setFont(smallText);
    best.setFont(smallText);
    signed.setFont(textFont);
    
    //horizontal alignment
    titleText.setHorizontalAlignment(JLabel.CENTER);
    subtitle.setHorizontalAlignment(JLabel.CENTER);
    authorsNames.setHorizontalAlignment(JLabel.CENTER);
    
    //layout 
    setLayout(new BorderLayout());
    title.setLayout(new GridLayout(3,1));
    pics.setLayout(new GridLayout(1,6));
    instructions.setLayout(new GridLayout(8,1));
    picsAndInstructions.setLayout(new BorderLayout());
    
    //color    
    Color lightBlue = new Color(135, 206, 250);
    Color lightPurple = new Color(216,191,216);
    
    title.setBackground(lightPurple);
    pics.setBackground(Color.WHITE);
    instructions.setBackground(lightBlue);
    
    title.add(titleText);
    title.add(subtitle);
    title.add(authorsNames);
    
    pics.add(wfresh);
    pics.add(bates);
    pics.add(lulu);
    pics.add(pom);
    pics.add(thanks);
    pics.add(stoned);
    pics.add(tower);
    
    instructions.add(intro);
    instructions.add(l1);
    instructions.add(l2);
    instructions.add(l3);
    instructions.add(l4);
    instructions.add(thanks);
    instructions.add(best);
    instructions.add(signed);
   
    //border 
    title.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    pics.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
    instructions.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));    
    
    picsAndInstructions.add(pics,BorderLayout.NORTH );
    picsAndInstructions.add(instructions,BorderLayout.CENTER );
    add(picsAndInstructions);
    add(title,BorderLayout.NORTH);
    
    
    
  }
}