import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Registration_form extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3;
    JButton b1;
    Registration_form(){
    	setSize(500,550);
    	setLocation(400,80);
    	setTitle("Registration Form");
    	getContentPane().setBackground(Color.LIGHT_GRAY);
    	l4= new JLabel("Registration Form");
    	l4.setBounds(100, 18, 240, 60);
    	l4.setFont( new Font("serif",Font.BOLD,28));
    	add(l4);
    	
    	l1= new JLabel("Name :");
    	l1.setBounds(40, 105, 100, 50);
    	l1.setFont( new Font("Arial ",Font.PLAIN,20));
    	add(l1);
    	
    	l2= new JLabel("Roll No :");
    	l2.setBounds(40, 185, 150, 50);
    	l2.setFont( new Font("Arial",Font.PLAIN,20));
    	add(l2);
    	
    	l3= new JLabel("Mobile No :");
    	l3.setBounds(40, 265, 150, 50);
    	l3.setFont( new Font("Arial",Font.PLAIN,20));
    	add(l3);
    	
    	t1= new JTextField();
    	t1.setBounds(160, 115, 300, 30);
    	add(t1);
    	
    	t2= new JTextField();
    	t2.setBounds(160, 195, 300, 30);
    	add(t2);
    	
    	t3= new JTextField();
    	t3.setBounds(160, 275, 300, 30);
    	add(t3);
    	
    	b1 = new JButton("Submit");
    	b1.setBounds(170, 370, 120, 30);
    	b1.setFont( new Font("calibri",Font.PLAIN,25));
    	add(b1);
    	b1.addActionListener(this);
    	setLayout(null);
    	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Statement s;
		Connection c;
		String Name = t1.getText();
	       String Mobile_no = t3.getText();
	       String Roll_no = t2.getText();
		try {
			 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Registration_data","root","Root2003");
			 s=c.createStatement();
			 s.executeUpdate("insert into Details values('"+Name+"', '"+Mobile_no+"','"+Roll_no+"')");
		       JOptionPane.showMessageDialog(null, " Added Successfully");
		       setVisible(false);
		
		}catch(Exception e1) {
			System.out.print(e1);
		}
		
		
	
	
	}
     
	
   
	public static void main(String[] args) {
		new Registration_form().setVisible(true);

	}

}