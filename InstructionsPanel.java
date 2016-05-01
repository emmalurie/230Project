import java.awt.*; 
import javax.swing.*; 
import java.awt.Image;


public class InstructionsPanel extends JPanel{
  JPanel description, pics;  
  JLabel title, authors; //add more text labels/panels 
  JLabel bates, lulu, pom, tower, stoned; //add open hours texts 
  
  public InstructionsPanel() {  
    description = new JPanel(); 
    pics = new JPanel();
    pics.setLayout(new GridLayout (1,5));
    
    title = new JLabel("Dining Hall Selector");
    authors = new JLabel("by Emma Lurie and Dorothy Sun");
    
    bates = new JLabel(new ImageIcon("bates.png","Bates Dining Hall"));
    lulu =  new JLabel (new ImageIcon("lulu.png","Lulu Dining Hall"));
    pom = new JLabel (new ImageIcon("pom.png", "Pomeroy Dining Hall"));
    stoned = new JLabel (new ImageIcon("stoned.png", "Stone Davis Dining Hall"));
    tower = new JLabel (new ImageIcon("tower.png", "Tower Dining Hall"));
    
    
    
    description.add(title);
    description.add(authors);
    
    pics.add(bates);
    pics.add(lulu);
    pics.add(pom);
    pics.add(stoned);
    pics.add(tower);
    
    
    add(description);
    add(pics);
    
  }
}