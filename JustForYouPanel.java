
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class JustForYouPanel extends JPanel{
  
  private JLabel instructions;
  
  //labels for each of the components
  private JLabel lunchlabel, dinnerlabel, reslunchlabel, resdinnerlabel;
  private JCheckBox dish1, dish2, dish3, dish4, dish5;
  private JButton seelunch, seedinner;
  
  
  
  private class ButtonListener implements ActionListener {
    public void actionPerformed (ActionEvent event){
      if (event.getSource() == seelunch){
        meal = "lunch"; 
      }else {
        meal = "dinner";
      }
      System.out.println(meal);
    }
  }
  
  
  
  
  
}