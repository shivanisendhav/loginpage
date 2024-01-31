package loginpage;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;
import java.awt.event.*;

public class login_page extends JFrame implements ActionListener {
//	forgetpassword f=new forgetpassword();
    JTextField usernameField;
    private JPasswordField passwordField;

    public login_page() {
        setTitle("Login Page");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(36, 189, 66, 16);
        usernameLabel.setToolTipText("");
        usernameLabel.setForeground(Color.WHITE);
        panel.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(28, 205, 443, 31);
        panel.add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(36, 253, 63, 16);
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(28, 270, 443, 31);
        panel.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(21, 375, 450, 31);
        panel.add(loginButton);
        loginButton.addActionListener(this);

        JButton btnNewButton = new JButton("Log In with Google");
        btnNewButton.setIgnoreRepaint(true);
        btnNewButton.setBounds(135, 130, 250, 29);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        panel.add(btnNewButton);

        JCheckBox rememberCheckBox = new JCheckBox("Remember Me");
        rememberCheckBox.setBounds(38, 304, 128, 23);
        rememberCheckBox.setForeground(Color.WHITE);
        panel.add(rememberCheckBox);

        JButton forgetPasswordButton = new JButton("Forgot Password?");
        forgetPasswordButton.setBounds(320, 302, 147, 31);
        forgetPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                // Open a dialog for password reset
                JOptionPane.showMessageDialog(null, "Please contact support for password reset.");
            }
        });
        panel.add(forgetPasswordButton);

        getContentPane().add(panel);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(6, 6, 0, 0);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setAutoscrolls(true);
        lblNewLabel_1.setBounds(-3, -7, 505, 568);
        lblNewLabel_1.setIcon(new ImageIcon("/Users/apple/Downloads/WhatsApp Image 2024-01-31 at 10.07.59.jpeg"));
        panel.add(lblNewLabel_1);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
    	
    	// }
//        String username = usernameField.getText();
//        String password = new String(passwordField.getPassword());
//
//        // Check if the username and password match
//        if (username.equals("shivani") && password.equals("123")) {
//            JOptionPane.showMessageDialog(this, "Login Successful!");
//            // You can add code here to open the main application window
//        } else {
//            JOptionPane.showMessageDialog(this, "Invalid Username or Password");
//        }
    try {
   	 Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Swing_project","root","root12345");
   	 String quary="insert into information values(?,?)";
   	 PreparedStatement p = con.prepareStatement(quary);
   	 p.setString(1, usernameField.getText());
   	 p.setString(2, passwordField.getText());
   	 int rs=p.executeUpdate();
   	 if(rs>0) {
   	 JOptionPane.showMessageDialog(null, "connection suceesfully");
   	 }
   	else {
   	 JOptionPane.showMessageDialog(null, "connection not suceesfully");
   	 }
   	 }catch(Exception s) {
   	 s.printStackTrace();

    }}

    public static void main(String[] args) {
        new login_page();
    }
}
