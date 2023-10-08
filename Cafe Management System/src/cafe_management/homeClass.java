package cafe_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class homeClass extends JFrame
{
    private final int width=600;
    private final int height=400;
    public double cost=0.0;
    
    private JPanel menubarPanel;
    private JPanel cooldrinkPanel;
    private JPanel chipsPanel;
    private JPanel chickenPanel;
    private JPanel noodlesPanel;
    private JPanel pizzaPanel;
    private JPanel panipuriPanel;
    private JPanel dryitemPanel;
    private JPanel coffeePanel;
    private JPanel buttonPanel;
    
    private ImageIcon cooldrinkImage; 
    private ImageIcon chipsImage;
    private ImageIcon chickenImage;
    private ImageIcon panipuriImage;
    private ImageIcon pizzaImage;
    private ImageIcon dryitemImage;
    private ImageIcon noodlesImage;
    private ImageIcon coffeeImage;
    
    private JButton cooldrinkButton;
    private JButton chipsButton;
    private JButton chickenButton;
    private JButton panipuriButton;
    private JButton dryitemButton;
    private JButton pizzaButton;
    private JButton noodlesButton;
    private JButton coffeeButton;
    private JButton calculateButton;
    
    private JMenu menu;
    
    private JMenuItem profile;
    
    private JMenuBar menuBar;
    public homeClass()
    {
        setTitle("Cafteria of IIIT Trichy");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon backgroundImage = new ImageIcon("cafe_management/Icons/background.png");
        JLabel backGroundLabel = new JLabel(backgroundImage);
        getContentPane().add(backGroundLabel,BorderLayout.CENTER);
        
        setLocationRelativeTo(null);
        //buildmenubarPanel();
        buildcooldrinkPanel();
        buildchipsPanel();
        buildchickenPanel();
        builddryitemPanel();
        buildpanipuriPanel();
        buildpizzaPanel();
        buildnoodlesPanel();
        buildcoffeePanel();
        //setLayout(new GridLayout(1,4));
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new GridLayout(2, 4));
        int gapSize = 13; 
        containerPanel.setBorder(BorderFactory.createEmptyBorder(gapSize, gapSize, gapSize, gapSize));
        containerPanel.add(cooldrinkPanel);
        containerPanel.add(chipsPanel);
        containerPanel.add(chickenPanel);
        containerPanel.add(dryitemPanel);
        containerPanel.add(panipuriPanel);
        containerPanel.add(pizzaPanel);
        containerPanel.add(noodlesPanel);
        containerPanel.add(coffeePanel);
        //add(menubarPanel,BorderLayout.SOUTH);
        add(containerPanel,BorderLayout.CENTER);
        buildbuttonPanel();
        add(buttonPanel,BorderLayout.SOUTH);
        setVisible(true);
    }
    
    public void buildcoffeePanel()
    {
        coffeePanel = new JPanel();
        coffeeImage = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\coffee.png"));
        Image i2 = coffeeImage.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        coffeeButton=new JButton();
        coffeeButton.setIcon(i3);
        coffeeButton.setToolTipText("click here to buy the dry Items!!");
        coffeeListener coffee = new coffeeListener();
        coffeeButton.addActionListener(coffee);
        coffeePanel.add(coffeeButton);
        JLabel coffeeLabel = new JLabel("     coffee");
        coffeeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        coffeePanel.add(coffeeLabel);
    }
    
    public class coffeeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //JOptionPane.showMessageDialog(null,"Click here to buy coffee!!");
            new Coffee2();
        }
    }
    
    public void buildnoodlesPanel()
    {
        noodlesPanel = new JPanel();
        noodlesImage = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\noodles.png"));
        Image i2 = noodlesImage.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        noodlesButton=new JButton();
        noodlesButton.setIcon(i3);
        noodlesButton.setToolTipText("click here to buy the Noodles!!");
        noodlesListener noodles= new noodlesListener();
        noodlesButton.addActionListener(noodles);
        noodlesPanel.add(noodlesButton);
        JLabel noodlesLabel = new JLabel("     Noodles");
        noodlesLabel.setHorizontalAlignment(SwingConstants.CENTER);
        noodlesPanel.add(noodlesLabel);
    }
    
    public class noodlesListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //JOptionPane.showMessageDialog(null,"Click here to buy noodles!!");
            new noodles();
        }
    }
    
    public void buildpizzaPanel()
    {
        pizzaPanel = new JPanel();
        pizzaImage = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\pizza.png"));
        Image i2 = pizzaImage.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        pizzaButton=new JButton();
        pizzaButton.setIcon(i3);
        pizzaButton.setToolTipText("click here to buy the pizza!!");
        pizzaListener pizza= new pizzaListener();
        pizzaButton.addActionListener(pizza);
        pizzaPanel.add(pizzaButton);
        JLabel pizzaLabel = new JLabel("     Pizza");
        pizzaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pizzaPanel.add(pizzaLabel);
    }
    
    public class pizzaListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //JOptionPane.showMessageDialog(null,"Click here to buy pizza!!");
            pizza pizzaInstance = new pizza();
            cost=cost+pizzaInstance.getCost();
            //System.out.println(pizzaInstance.getCost());
            System.out.println(cost);
        }
    }
    
    public void buildpanipuriPanel()
    {
        panipuriPanel = new JPanel();
        panipuriImage = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\panipuri.png"));
        Image i2 = panipuriImage.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        panipuriButton=new JButton();
        panipuriButton.setIcon(i3);
        panipuriButton.setToolTipText("click here to buy the panipuri!!");
        panipuriListener panipuri= new panipuriListener();
        panipuriButton.addActionListener(panipuri);
        panipuriPanel.add(panipuriButton);
        JLabel panipuriLabel = new JLabel("    Pani Puri");
        panipuriLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panipuriPanel.add(panipuriLabel);
    }
    
    public class panipuriListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //JOptionPane.showMessageDialog(null,"Click here to buy panipuri!!");
            new panipuri();
        }
    }
    
    public void builddryitemPanel()
    {
        dryitemPanel = new JPanel();
        dryitemImage = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\dryItems.png"));
        Image i2 = dryitemImage.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        dryitemButton=new JButton();
        dryitemButton.setIcon(i3);
        dryitemButton.setToolTipText("click here to buy the dry items!!");
        dryitemListener cake= new dryitemListener();
        dryitemButton.addActionListener(cake);
        dryitemPanel.add(dryitemButton);
        JLabel dryitemLabel = new JLabel("    Dry Items");
        dryitemLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dryitemPanel.add(dryitemLabel);
    }
    
    public class dryitemListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //JOptionPane.showMessageDialog(null,"click here to buy the cake!!");
            new dryItems();
        }
    }
    
    public void buildchickenPanel()
    {
        chickenPanel = new JPanel();
        chickenImage = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\biriyani.png"));
        Image i2 = chickenImage.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        chickenButton=new JButton();
        chickenButton.setIcon(i3);
        chickenButton.setToolTipText("click here to buy the biriyani!!");
        chickenListener chicken= new chickenListener();
        chickenButton.addActionListener(chicken);
        chickenPanel.add(chickenButton);
        JLabel chickenLabel = new JLabel("       Chicken");
        chickenLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chickenPanel.add(chickenLabel);
    }
    
    public class chickenListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //JOptionPane.showMessageDialog(null,"click here to buy the Biriyani!!");
            new biriyani();
        }
    }
    public void buildchipsPanel()
    {
        chipsPanel = new JPanel();
        chipsImage = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\chips.png"));
        Image i2 = chipsImage.getImage().getScaledInstance(100,120,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        chipsButton=new JButton();
        chipsButton.setIcon(i3);
        chipsButton.setToolTipText("click here to buy the chips!!");
        chipsListener chip= new chipsListener();
        chipsButton.addActionListener(chip);
        chipsPanel.add(chipsButton);
        JLabel chipsLabel = new JLabel("      Chips");
        chipsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        chipsPanel.add(chipsLabel);
    }
    
    public class chipsListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            //JOptionPane.showMessageDialog(null,"fuck off1!!");
            new chips();
        }
    }
    public void buildcooldrinkPanel()
    {
        cooldrinkPanel = new JPanel();
        cooldrinkImage = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\cooldrink1.jpg"));
        Image i2 = cooldrinkImage.getImage().getScaledInstance(100,121,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        cooldrinkButton=new JButton();
        cooldrinkButton.setIcon(i3);
        cooldrinkButton.setToolTipText("click here to buy the Cool Drinks!!");
        cooldrinkListener cool= new cooldrinkListener();
        cooldrinkButton.addActionListener(cool);
        cooldrinkPanel.setLayout(new BoxLayout(cooldrinkPanel, BoxLayout.Y_AXIS));
        cooldrinkPanel.add(cooldrinkButton);
        JLabel cooldrinkLabel = new JLabel("        Cool Drink");
        cooldrinkLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cooldrinkPanel.add(cooldrinkLabel);
    }
    
    public class cooldrinkListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //JOptionPane.showMessageDialog(null,"Clicked on Cool Drinks button!!");
            cooldrink c = new cooldrink();
            int k=c.getcooldrinkCost();
            cost=cost+k;
            System.out.println(cost);
        }
    }
    
    public void buildbuttonPanel()
    {
        calculateButton = new JButton("Calculate");
        buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.add(calculateButton,BorderLayout.CENTER);
    }
    
    /*private void buildmenubarPanel()
    {
        menubarPanel = new JPanel();
        menuBar = new JMenuBar();
        
        buildmenu();
        menubarPanel.add(menuBar);
    }
    
    private void buildmenu()
    {
        menu = new JMenu("Menu");
        menubarPanel.add(menu);
    }*/
}


