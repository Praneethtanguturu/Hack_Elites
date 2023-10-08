
package cafe_management;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import javax.swing.border.TitledBorder;

public class cooldrink extends JFrame
{
    private final int width=400;
    private final int height=500;
    
    public final int cola_200ml=20;
    public final int cola_500ml=40;
    public final int cola_1000ml=80;
        
    public final int sprite_200ml=20;
    public final int sprite_500ml=40;
    public final int sprite_1000ml=80;
    
    private JCheckBox colabutton_250ml;
    private JCheckBox colabutton_500ml;
    private JCheckBox colabutton_1000ml;
    
    private JCheckBox spritebutton_250ml;
    private JCheckBox spritebutton_500ml;
    private JCheckBox spritebutton_1000ml;
    
    private JPanel exitPanel;
    private JButton exitButton;
    
    private ButtonGroup bg;
  
    public cooldrink()
{
    setTitle("Cool Drink Buying Window");
    setSize(width, height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    setLocationRelativeTo(null);
    JPanel coolDrinkPanel = new JPanel();
    coolDrinkPanel.setBorder(BorderFactory.createTitledBorder("Cool Drinks")); 
    
    buildcooldrinkPanel();

    coolDrinkPanel.setLayout(new GridLayout(6, 1)); 
    coolDrinkPanel.add(colabutton_250ml);
    coolDrinkPanel.add(colabutton_500ml);
    coolDrinkPanel.add(colabutton_1000ml);
    
    coolDrinkPanel.add(spritebutton_250ml);
    coolDrinkPanel.add(spritebutton_500ml);
    coolDrinkPanel.add(spritebutton_1000ml);
    
    add(coolDrinkPanel); // Add the panel to the JFrame
    pack();
    setVisible(true);
}

       
    public void buildcooldrinkPanel()
    {
        colabutton_250ml = new JCheckBox("Coco-Cola 250 milli litres");
        colabutton_500ml = new JCheckBox("Coco-Cola 500 milli litres");
        colabutton_1000ml = new JCheckBox("Coco-Cola 1000 milli litres");
        
        spritebutton_250ml = new JCheckBox("Sprite 250 milli litres");
        spritebutton_500ml = new JCheckBox("Sprite 500 milli litres");
        spritebutton_1000ml = new JCheckBox("Sprite 1000 milli litres");
        
        bg = new ButtonGroup();
        bg.add(colabutton_250ml);
        bg.add(colabutton_500ml);
        bg.add(colabutton_1000ml);
        
        bg.add(spritebutton_250ml);
        bg.add(spritebutton_500ml);
        bg.add(spritebutton_1000ml);
        
    }
    
    public int getcooldrinkCost() 
    {
        int cost=0;
        if(colabutton_250ml.isSelected())
        {
            cost=20;
            return cost;
        }
        else if(colabutton_500ml.isSelected())
        {
            cost=40;
            return cost;
        }
        else if(colabutton_1000ml.isSelected())
        {
            cost=80;
            return cost;
        }
        else if(spritebutton_250ml.isSelected())
        {
            cost=20;
            return cost;
        }
        else if(spritebutton_500ml.isSelected())
        {
            cost=40;
            return cost;
        }
        else if(spritebutton_1000ml.isSelected())
        {
            cost=80;
            return cost;
        }
        else
        {
            cost=0;
            return cost;
        }
    }
}
