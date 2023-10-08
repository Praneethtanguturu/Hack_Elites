
package cafe_management;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class coffee extends JFrame 
{
    private final int width=400;
    private final int height=500;
    
    private String[] coffeeitems ={"Chicken Tikka","Mutton Tikka","Chicken Chilli"};
    
    private JPanel coffeePanel;
    private JPanel selectedcoffeePanel;
    private JList coffeeList;
    private JTextField selectedcoffeeItems;
    private JLabel coffeeLabel;
    
    public coffee()
    {
        setTitle("Coffee Buying Window");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        buildcoffeePanel();
        buildselectedcoffeePanel();
    }
    
    public void buildcoffeePanel()
    {
        coffeePanel = new JPanel();
        coffeeList = new JList(coffeeitems);
        
        coffeeList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        coffeeList.addListSelectionListener(new coffeeListener());
        
        coffeePanel.add(coffeeList);
    }
    
    private class coffeeListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            String selection=(String) coffeeList.getSelectedValue();
            selectedcoffeeItems.setText(selection);
        }
    }
    
    private void buildselectedcoffeePanel()
    {
        selectedcoffeePanel = new JPanel();
        
        coffeeLabel = new JLabel("Your Selected Items:");
        selectedcoffeeItems = new JTextField(20);
        selectedcoffeeItems.setEditable(false);
        selectedcoffeePanel.add(coffeeLabel);
        selectedcoffeePanel.add(selectedcoffeeItems);
    }
    
    public int getCost() 
    {
      String selectedItem = selectedcoffeeItems.getText().trim().toLowerCase();
      int cost = getcoffeeCost(selectedItem);
      return cost;
    }
    
    private int getcoffeeCost(String selectedItem) 
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
