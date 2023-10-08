
package cafe_management;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class dryItems extends JFrame
{
    private final int width=400;
    private final int height=500;
    
    private String[] dryitems ={"Chicken Tikka","Mutton Tikka","Chicken Chilli"};
    
    private JPanel dryPanel;
    private JPanel selecteddryPanel;
    private JPanel exitPanel;
    private JList dryList;
    private JTextField selecteddryItems;
    private JLabel dryLabel;
    private JButton exitButton;
    
    public dryItems()
    {
        setTitle("chips Buying Window");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        buildbiriyaniPanel();
        buildselectedbiriyaniPanel();
        buildexitButton();
        exitButton.addActionListener(new ExitButtonListener(this));
        
        setLayout(new GridLayout(3,1));
        add(dryPanel);
        add(selecteddryPanel);
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
    
    public void buildbiriyaniPanel()
    {
        dryPanel = new JPanel();
        dryList = new JList(dryitems);
        
        dryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        dryList.addListSelectionListener(new dryListener());
        
        dryPanel.add(dryList);
    }
    
    private class dryListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            String selection=(String) dryList.getSelectedValue();
            selecteddryItems.setText(selection);
        }
    }
    
    private void buildselectedbiriyaniPanel()
    {
        selecteddryPanel = new JPanel();
        
        dryLabel = new JLabel("Your Selected Items:");
        selecteddryItems = new JTextField(20);
        selecteddryItems.setEditable(false);
        selecteddryPanel.add(dryLabel);
        selecteddryPanel.add(selecteddryItems);
    }
    
    public int getCost() 
    {
      String selectedItem = selecteddryItems.getText().trim().toLowerCase();
      int cost = getbiriyaniCost(selectedItem);
      return cost;
    }
    
    private int getbiriyaniCost(String selectedItem) 
    {
        switch(selectedItem) 
        {
            case "Chicken Chilli":
                return 390;
            case "Mutton Tikka":
                return 440;
            case "Chicken Tikka":
                return 380;
            default:
                return 0;
        }
    }
}
