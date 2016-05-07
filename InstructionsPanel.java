import java.awt.*; 
import javax.swing.*; 
import java.awt.Image;


public class InstructionsPanel extends JPanel{
  JPanel description, pics;  
  JLabel title, authors; //add more text labels/panels 
  JLabel bates, lulu, pom, tower, stoned; //add open hours texts 
  JLabel words; 
  
  
  public InstructionsPanel() {  
    description = new JPanel(); 
    pics = new JPanel();
    pics.setLayout(new GridLayout (3,2));
    
    title = new JLabel("Dining Hall Selector");
    authors = new JLabel("by Emma Lurie and Dorothy Sun");
    
    bates = new JLabel(new ImageIcon("images/bates-logo","Bates Dining Hall"));
    lulu =  new JLabel (new ImageIcon("images/lulu-logo.png","Lulu Dining Hall"));
    pom = new JLabel (new ImageIcon("images/pom-logo.png", "Pomeroy Dining Hall"));
    stoned = new JLabel (new ImageIcon("images/stoned-logo.png", "Stone Davis Dining Hall"));
    tower = new JLabel (new ImageIcon("images/tower-logo.png", "Tower Dining Hall"));
    
    
    
    description.add(title);
    description.add(authors);
    
    pics.add(bates);
    pics.add(lulu);
    pics.add(pom);
    pics.add(stoned);
    pics.add(tower);
    
    //words = new JLabel();
    
    String t1 = "Welcome to Palate Tailor!";
    String t2 = "If you would like to see our general recommendations of the best dining halls to eat at today, ";
    String t3 = "navigate to the “Today’s Choice” tab. To see our recommendation for lunch, click on the “Lunch” button.";
    String t4 = "To see our recommendation for dinner, click on the “Dinner” button.";
    String t5 = "If you would like to see our individualized recommendation of the best dining halls to eat at today based on your palate, ";
    String t6 = "navigate to the “Just For You” tab. To see our recommendation for lunch, click on the “Lunch” button.";
    String t7 = "To see our recommendation for dinner, click on the “Dinner” button.";
    String t8 = "Thanks for trying out our program.";
    String t9 = "Best,";
    String t10 = "Emma Lurie and Dorothy Sun";
    
    words = new JLabel(t1 + t2 + t3 + t4 + t5 + t6 + t7 + t8 + t9 + t10);
    
    
    add(description);
    add(pics);
    add(words);
    
  }
}