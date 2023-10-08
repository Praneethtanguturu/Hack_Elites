package cafe_management;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class pizza extends JFrame
{
    private final int width=400;
    private final int height=500;
    
    private JPanel exitPanel;
    private JButton exitButton;
    
    private String[] pizzaitems ={"Margarita","Pasta Pizza","Mixed Veg Pizza","Capsicum Corn Pizza","Panner Corn Pizza","Double Cheesa Margarita","Chicken Pizza","Double Cheese Chicken Pizza"};
    private String[] burgeritems = {"Double Classic Burger","Veg Burger","Barbique Burger","Barbique special Burger"};
    
    private JPanel pizzaPanel;
    private JPanel selectedpizzaPanel;
    private JPanel burgerPanel;
    private JPanel selectedburgerPanel;
    
    private JList pizzaList;
    private JList burgerList;
    
    private JTextField selectedPizzaItems;
    private JTextField selectedBurgerItems;
    
    private JLabel pizzaLabel;
    private JLabel burgerLabel;
    
    public pizza()
    {
        setTitle("Pizza Buying Window");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
        buildpizzaPanel();
        buildselectedpizzaPanel();
        buildexitButton();
        setLayout(new GridLayout(3,1));
        add(pizzaPanel,BorderLayout.CENTER);
        add(selectedpizzaPanel,BorderLayout.SOUTH);
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
    
    private void buildpizzaPanel()
    {
        pizzaPanel = new JPanel();
        pizzaList = new JList(pizzaitems);
        
        pizzaList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        pizzaList.addListSelectionListener(new pizzaListener());
        
        pizzaPanel.add(pizzaList);
    }
    
    private class pizzaListener implements ListSelectionListener
    {
        public void valueChanged(ListSelectionEvent e)
        {
            String selection=(String) pizzaList.getSelectedValue();
            selectedPizzaItems.setText(selection);
        }
    }
    private void buildselectedpizzaPanel()
    {
        selectedpizzaPanel = new JPanel();
        
        pizzaLabel = new JLabel("Your Selected Items:");
        selectedPizzaItems = new JTextField(20);
        selectedPizzaItems.setEditable(false);
        selectedpizzaPanel.add(pizzaLabel);
        selectedpizzaPanel.add(selectedPizzaItems);
    }
    
    public double getCost() 
    {
      String selectedItem = selectedPizzaItems.getText().trim().toLowerCase();
      double cost = getPizzaCost(selectedItem);
      return cost;
    }
  
    private double getPizzaCost(String selectedItem) 
    {
        switch(selectedItem) 
        {
            case "Margarita":
                return 300.0;
            case "Pasta Pizza":
                return 450.0;
            case "Mixed Veg Pizza":
                return 500.0;
            case "Capsicum Corn Pizza":
                return 199.0;
            case "Paneer Corn Pizza":
                return 199.0;
            case "Double Cheese Margarita":
                return 200.0;
            case "Chicken Pizza":
                return 249.0;
            case "Double Cheese Chicken Pizza":
                return 299.0;
            default:
                return 0.0;
        }
    }
}
