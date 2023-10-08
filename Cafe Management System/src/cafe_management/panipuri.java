
package cafe_management;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class panipuri extends JFrame
{
  private BagelPanel bagels;
  private ToppingPanel toppings;
  private CoffeePanel coffee;
  private GreetingPanel banner;
  private JPanel ButtonPanel;
  
  private final int width=700;
  private final int height=500;
  
  public panipuri()
  {
    setTitle("Pani Puri Shop");
    setSize(width,height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    banner= new GreetingPanel();
    bagels=new BagelPanel();
    toppings=new ToppingPanel();
    coffee=new CoffeePanel();
    
    buildButtonPanel();
    add(banner,BorderLayout.NORTH);
    add(bagels,BorderLayout.WEST);
    add(toppings,BorderLayout.CENTER);
    add(coffee,BorderLayout.EAST);
    add(ButtonPanel,BorderLayout.SOUTH);
    
    pack();
    setVisible(true);
  }
  
  public void buildButtonPanel()
  {
    ButtonPanel=new JPanel();
    
    CalcButtonListener ab=new CalcButtonListener();
    ExitButtonListener bc=new ExitButtonListener();
    
    JButton button1=new JButton("calculate");
    button1.addActionListener(ab);
    
    JButton button2=new JButton("exit");
    button2.addActionListener(bc);
    
    ButtonPanel.add(button1);
    ButtonPanel.add(button2);
  }
  
  public class CalcButtonListener implements ActionListener
  {
    public void actionPerformed(ActionEvent e)
    {
        double subTotal=bagels.getBagelCost()+toppings.getToppingsCost()+coffee.getCoffeeCost();
        double tax=0.6;
        double total=tax*subTotal+subTotal;
        JOptionPane.showMessageDialog(null,String.format("Subtotal: $%,.2f\n" +"Tax: $%,.2f\n" +"Total: $%,.2f", subTotal, tax, total));
      }
   }
   
   public class ExitButtonListener implements ActionListener
   {
     public void actionPerformed(ActionEvent e)
     {
       System.exit(0);
     }
   }
}

class BagelPanel extends JPanel
{
  public final int white_bagel=20;
  public final int wheat_bagel=19;
  
  private JRadioButton whitebagel;
  private JRadioButton wheatbagel;
  
  private ButtonGroup bg;
  
  public BagelPanel()
  {
    setLayout(new GridLayout(2,1));
    whitebagel=new JRadioButton("white",true);
    wheatbagel=new JRadioButton("wheat");
    
    //grouping the radio buttons
    bg=new ButtonGroup();
    bg.add(whitebagel);
    bg.add(wheatbagel);
    
    //adding a border
    setBorder(BorderFactory.createTitledBorder("type"));
    
    add(whitebagel);
    add(wheatbagel);
  }
  
  public double getBagelCost()
  {
    double bagelCost=0.0;
    if(whitebagel.isSelected())
    {
      bagelCost=white_bagel;
    }
    else
    {
      bagelCost=wheat_bagel;
    }
    return bagelCost;
  }
}

class ToppingPanel extends JPanel
{
  private final double creamCheese=0.50;
  private final double butter=0.25;
  private final double peachJelly=0.75;
  private final double blueberryJam=0.75;
  
  private JCheckBox check1;
  private JCheckBox check2;
  private JCheckBox check3;
  private JCheckBox check4;
  
  private ButtonGroup bg;
  
  public ToppingPanel()
  {
    setLayout(new GridLayout(4,1));
    check1=new JCheckBox("Cream Cheese");
    check2=new JCheckBox("Butter");
    check3=new JCheckBox("Peach Jelly");
    check4=new JCheckBox("Blueberry Jam");
    
    bg=new ButtonGroup();
    
    bg.add(check1);
    bg.add(check2);
    bg.add(check3);
    bg.add(check4);
    
    setBorder(BorderFactory.createTitledBorder("Toppings"));
    
    add(check1);
    add(check2);
    add(check3);
    add(check4);
  }
  double getToppingsCost()
  {
    double toppingsCost=0.0;
    if(check1.isSelected())
    {
      toppingsCost=creamCheese;
    }
    else if(check2.isSelected())
    {
      toppingsCost=butter;
    }
    else if(check3.isSelected())
    {
      toppingsCost=peachJelly;
    }
    else
    {
      toppingsCost=blueberryJam;
    }
    return toppingsCost;
  }
}


class GreetingPanel extends JPanel
{
  private JLabel greeting;
  
  public GreetingPanel()
  {
    greeting=new JLabel("welocome to Brandi's Bagel House");
    
    add(greeting);
  }
}

class CoffeePanel extends JPanel
{
  private final double RegularCoffee=1.25;
  private final double decafCoffee=1.25;
  private final double cappuccino=2.0;
  
  private JRadioButton button1;
  private JRadioButton button2;
  private JRadioButton button3;
  private JRadioButton button4;
  
  private ButtonGroup bg;
  
  public CoffeePanel()
  {
    setLayout(new GridLayout(4,1));
    button1=new JRadioButton("None");
    button2=new JRadioButton("Regular coffee",true);
    button3=new JRadioButton("Decaf Coffee");
    button4=new JRadioButton("Cappuccino");
  
    bg=new ButtonGroup();
    bg.add(button1);
    bg.add(button2);
    bg.add(button3);
    bg.add(button4);
    
    setBorder(BorderFactory.createTitledBorder("Coffee"));
    add(button1);
    add(button2);
    add(button3);
    add(button4);
  }
  public double getCoffeeCost()
  {
    double coffeeCost=0.0;
    if(button2.isSelected())
    {
      coffeeCost=1.25;
    }
    else if(button3.isSelected())
    {
      coffeeCost=decafCoffee;
    }
    else if(button4.isSelected())
    {
      coffeeCost=cappuccino;
    }
    return coffeeCost;
  }
}
