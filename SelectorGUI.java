import javax.swing.*; 
import java.awt.*; 

public class SelectorGUI{
  
  public static void main(String[] args){
    JFrame frame = new JFrame("Dining Hall Selector"); //new frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    JTabbedPane tp = new JTabbedPane(); 
  
    tp.addTab("Instructions", new InstructionsPanel()); 
    tp.addTab("Today�s Choice", new TodaysChoice()); 
    tp.addTab("Just for You", new JustForYouPanel()); 
    
    frame.getContentPane().add(tp); //add tabbed pane to frame
    frame.setPreferredSize(new Dimension(1500,1500)); //set size
    frame.pack(); 
    //frame.setResizable(false); //not resizable
    frame.setVisible(true); 
  }
  
  
}
