/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cafe_management;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;

public class biriyani extends JFrame
{
    private final int width=400;
    private final int height=500;
    
    private String[] biriyaniitems ={"Chicken Biriyani","Mutton Biriyani","Chicken Dum Biriyani"};
    
    
    private JPanel exitPanel;
    private JButton exitButton;
    private JPanel biriyaniPanel;
    private JPanel selectedbiriyaniPanel;
    private JList biriyaniList;
    private JTextField selectedbiriyaniItems;
    private JLabel biriyaniLabel;
    
    public biriyani()
    {
        setTitle("chips Buying Window");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        buildbiriyaniPanel();
        buildselectedbiriyaniPanel();
    }
    
    public void buildbiriyaniPanel()
    {
        biriyaniPanel = new JPanel();
        biriyaniList = new JList(biriyaniitems);
        
        biriyaniList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        biriyaniList.addListSelectionListener(new biriyaniListener());
        
        biriyaniPanel.add(biriyaniList);
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
    
    private class biriyaniListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            String selection=(String) biriyaniList.getSelectedValue();
            selectedbiriyaniItems.setText(selection);
        }
    }
    
    private void buildselectedbiriyaniPanel()
    {
        selectedbiriyaniPanel = new JPanel();
        
        biriyaniLabel = new JLabel("Your Selected Items:");
        selectedbiriyaniItems = new JTextField(20);
        selectedbiriyaniItems.setEditable(false);
        selectedbiriyaniPanel.add(biriyaniLabel);
        selectedbiriyaniPanel.add(selectedbiriyaniItems);
    }
    
    public int getCost() 
    {
      String selectedItem = selectedbiriyaniItems.getText().trim().toLowerCase();
      int cost = getbiriyaniCost(selectedItem);
      return cost;
    }
    
    private int getbiriyaniCost(String selectedItem) 
    {
        switch(selectedItem) 
        {
            case "Chicken Biriyani":
                return 10;
            case "Mutton Biriyani":
                return 10;
            case "Chicken Dum Biriyani":
                return 10;
            default:
                return 0;
        }
    }
}
