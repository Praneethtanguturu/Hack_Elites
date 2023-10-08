
package cafe_management;

import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class signup extends JFrame
{
    private final int width=400;
    private final int height=400;
    
    private Connection conn;
    
    private JPanel userNamePanel;
    private JPanel passwordPanel;
    private JPanel emailPanel;
    private JPanel mobile_noPanel;
    private JPanel buttonPanel;
    private JPanel imagePanel;
    private JPanel panel;
    
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JLabel mobile_noLabel;
    private JLabel label;
    
    
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField emailText;
    private JTextField mobile_noText;
    
    private ImageIcon image;
    
    private JButton login;
    private JButton signup;
    
    public signup()
    {
        setTitle("Create New Account");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        setLocationRelativeTo(null);
        buildusernamePanel();
        buildpasswordPanel();
        buildemailPanel();
        buildmobile_noPanel();
        buildbutton();
        buildImageIconPanel();
        buildPanel();
        
        setBackground(Color.WHITE);
        add(panel,BorderLayout.EAST);
        add(imagePanel,BorderLayout.CENTER);
        pack();
        
        setVisible(true);
        setupDatabaseConnection();
    }
    
    public void buildPanel()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        panel.add(userNamePanel);
        panel.add(passwordPanel);
        panel.add(emailPanel);
        panel.add(mobile_noPanel);
        panel.add(buttonPanel);
    }
    private void buildImageIconPanel()
    {
      imagePanel = new JPanel();
      image = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\signup.png"));
      Image i2 = image.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      label = new JLabel(i3);
      
      imagePanel.add(label);
    }
    
    private void setupDatabaseConnection()
    {
        try 
        {
            String url = "jdbc:mysql://localhost:3306/cafe_management";
            String username = "root";
            String password = "root";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Database connection established");
        } 
        catch (Exception e) 
        {
            System.out.println("Cannot connect to database server: " + e);
        }
    }
    private void buildusernamePanel()
    {
        userNamePanel = new JPanel();
        userNameLabel = new JLabel("User Name:");
        userNameLabel.setBounds(40,20,100,30);
        usernameText = new JTextField(19);
        
        userNamePanel.add(userNameLabel);
        userNamePanel.add(usernameText);
    }
    
    private void buildpasswordPanel()
    {
        passwordPanel = new JPanel();
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40,20,100,30);
        passwordText = new JTextField(19);
        
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
    }
    
    private void buildemailPanel()
    {
        emailPanel = new JPanel();
        emailLabel = new JLabel("Email id:  ");
        emailLabel.setBounds(40,20,100,30);
        emailText = new JTextField(19);
        
        emailPanel.add(emailLabel);
        emailPanel.add(emailText);
    }
    
    private void buildmobile_noPanel()
    {
        mobile_noPanel = new JPanel();
        mobile_noLabel = new JLabel("Mobile No:");
        mobile_noLabel.setBounds(90,50,200,50);
        mobile_noText = new JTextField(19);
        
        mobile_noPanel.add(mobile_noLabel);
        mobile_noPanel.add(mobile_noText);
    }
    
    private void buildbutton()
    {
        buttonPanel = new JPanel();
        login = new JButton("Login");
        signup = new JButton("Sign Up");
        
        loginButtonListener button1 = new loginButtonListener();
        login.addActionListener(button1);
        
        signupButtonListener button2 = new signupButtonListener();
        signup.addActionListener(button2);
        
        buttonPanel.add(signup);
        buttonPanel.add(login);
    }   
    
    public class loginButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            new login();
            dispose();
        }
    }
    
    public class signupButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
             try 
            {
            String username = usernameText.getText();
            String password = passwordText.getText();
            String email = emailText.getText();
            String mobileNo = mobile_noText.getText();

            // Create an SQL INSERT statement and execute it
            String sql = "INSERT INTO signup (username, password, email, mobile_no) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, mobileNo);
            preparedStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Sign up successful");

           } 
           catch (SQLException ex) 
           {
             JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
           }
        }
    }
    
    public static void main(String [] args)
    {
        new signup();
    }
}
