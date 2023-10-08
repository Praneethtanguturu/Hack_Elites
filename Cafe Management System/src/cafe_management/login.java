
package cafe_management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class login extends JFrame
{
    private final int width=400;
    private final int height=400;
    
    private JPanel passwordPanel;
    private JPanel emailPanel;
    private JPanel buttonPanel;
    private JPanel imagePanel;
    private JPanel panel;
    
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JLabel label;
    
    private JTextField passwordText;
    private JTextField emailText;
    
    private JButton button;
    private Connection conn;
    
    private ImageIcon image;
    
    public login()
    {
        setTitle("SignUp Window");
        setSize(width,height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        buildemailPanel();
        buildpasswordPanel();
        buildbuttonPanel();
        buildImageIconPanel();
        buildPanel();
        
        setLocationRelativeTo(null);
        
        add(panel,BorderLayout.EAST);
        add(imagePanel,BorderLayout.CENTER);
        pack();
        
        setVisible(true);
        setupDatabaseConnection();
    }
    
    public void buildPanel()
    {
        panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        panel.add(emailPanel);
        panel.add(passwordPanel);
        panel.add(buttonPanel);
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
    
    private void buildImageIconPanel()
    {
      imagePanel = new JPanel();
      image = new ImageIcon(ClassLoader.getSystemResource("cafe_management\\Icons\\login.png"));
      Image i2 = image.getImage().getScaledInstance(150,150,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      label = new JLabel(i3);
      
      imagePanel.add(label);
    }
    
    private void buildbuttonPanel()
    {
        buttonPanel = new JPanel();
        button = new JButton("Login");
        buttonListener b1 = new buttonListener();
        button.addActionListener(b1);
        
        buttonPanel.add(button);
    }
    
    public class buttonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String enteredEmail = emailText.getText();
            String enteredPassword = passwordText.getText();

            try 
            {
                String query = "SELECT email, password FROM signup WHERE email = ?";
                PreparedStatement preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, enteredEmail);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) 
                {
                    String dbPassword = resultSet.getString("password");
                    if (enteredPassword.equals(dbPassword)) 
                    {
                        new homeClass();
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect password");
                    }
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Email not found");
                }
            } 
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
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
    
    private void buildpasswordPanel()
    {
        passwordPanel = new JPanel();
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(40,20,100,30);
        passwordText = new JTextField(19);
        
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordText);
    }
}
