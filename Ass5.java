
import java.util.*;
import java.sql.*;

public class Ass5 {
    public static void main(String[] args) {

        {

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Your Name:");
            String name = sc.nextLine();

            System.out.println("Enter Your Roll No:");
            int rollno = sc.nextInt();

            System.out.println("Enter Your Mobile Number:");
            int number = sc.nextInt();

            // System.out.println(a);
            // System.out.println(b);
            // System.out.println(c);

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql:///emp", "root", "root123");
                Statement st = con.createStatement();

                String s = "insert into emp1 values('" + name + "','" + rollno + "','" + number + "')";
                st.executeUpdate(s);
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

}