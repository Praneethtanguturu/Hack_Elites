package cafe_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Coffee2 extends JFrame
{
  public double subTotal;
  private BagelPanel bagels;
  private ToppingPanel toppings;
  private CoffeePanel coffee;
  private GreetingPanel banner;
  private JPanel ButtonPanel;
  
  private final int width=700;
  private final int height=500;
  
  public Coffee2()
  {
    setTitle("Order Calculator");
    setSize(width,height);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    banner= new GreetingPanel();
    bagels=new BagelPanel();
    toppings=new ToppingPanel();
    coffee=new CoffeePanel();
    setLocationRelativeTo(null);
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
    ExitButtonListener bc=new ExitButtonListener(this);
    
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
        subTotal=bagels.getBagelCost()+toppings.getToppingsCost()+coffee.getCoffeeCost();
        double tax=1.9;
        double total=tax*subTotal+subTotal;
        JOptionPane.showMessageDialog(null,String.format("Subtotal: $%,.2f\n" +"Tax: $%,.2f\n" +"Total: $%,.2f", subTotal, tax, total));
      }
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
}

class BagelPanel extends JPanel
{
  public final int white_bagel=12;
  public final int wheat_bagel=15;
  
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
    setBorder(BorderFactory.createTitledBorder("Bagel"));
    
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
  private final int creamCheese=10;
  private final int butter=12;
  private final int peachJelly=9;
  private final int blueberryJam=8;
  
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
  public double getToppingsCost()
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
    greeting=new JLabel("welcome to Brandi's Bagel House");
    
    add(greeting);
  }
}

class CoffeePanel extends JPanel
{
  private final int RegularCoffee=14;
  private final int decafCoffee=19;
  private final int cappuccino=20;
  
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
    int coffeeCost=0;
    if(button2.isSelected())
    {
      coffeeCost=19;
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
    
    
  
