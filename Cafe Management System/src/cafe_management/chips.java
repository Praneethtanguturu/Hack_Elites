
package cafe_management;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class chips extends JFrame
{
    private final int width=400;
    private final int height=500;
    
    private JPanel exitPanel;
    private JButton exitButton;
    
    private String[] chipsitems ={"Tomato Chips","Potato chips","Chilly Tomato Chips"};
    
    private JPanel chipsPanel;
    private JPanel selectedchipsPanel;
    private JList chipsList;
    private JTextField selectedchipsItems;
    private JLabel chipsLabel;
    
    public chips()
    {
        setTitle("chips Buying Window");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        buildchipsPanel();
        buildselectedpizzaPanel();
        buildexitButton();
        
        add(chipsPanel,BorderLayout.CENTER);
        add(selectedchipsPanel,BorderLayout.SOUTH);
        add(exitPanel);
        pack();
        setVisible(true);
    }
    
    public void buildexitButton()
    {
        exitButton = new JButton("Exit");
        exitPanel = new JPanel();
        exitPanel.add(exitButton);
    }
    
    public class ExitButtonListener implements ActionListener
   {
         private final JFrame specificWindow;
         
         public ExitButtonListener(JFrame specificWindow)
         {
             this.specificWindow = specificWindow;
         }
         
         public void actionPerformed(ActionEvent e)
         {
             specificWindow.dispose();
         }
   }
    
    public void buildchipsPanel()
    {
        chipsPanel = new JPanel();
        chipsList = new JList(chipsitems);
        
        chipsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        chipsList.addListSelectionListener(new chipsListener());
        
        chipsPanel.add(chipsList);
    }
    
    private class chipsListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            String selection=(String) chipsList.getSelectedValue();
            selectedchipsItems.setText(selection);
        }
    }
    
    private void buildselectedpizzaPanel()
    {
        selectedchipsPanel = new JPanel();
        
        chipsLabel = new JLabel("Your Selected Items:");
        selectedchipsItems = new JTextField(20);
        selectedchipsItems.setEditable(false);
        selectedchipsPanel.add(chipsLabel);
        selectedchipsPanel.add(selectedchipsItems);
    }
    
    public int getCost() 
    {
      String selectedItem = selectedchipsItems.getText().trim().toLowerCase();
      int cost = getchipsCost(selectedItem);
      return cost;
    }
    
    private int getchipsCost(String selectedItem) 
    {
        switch(selectedItem) 
        {
            case "Tomato Chips":
                return 10;
            case "Potato chips":
                return 10;
            case "Chilly Tomato Chips":
                return 10;
            default:
                return 0;
        }
    }
}
