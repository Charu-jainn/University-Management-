
package university.management.system;
import javax.swing.*;
import java.awt.*;
public class About extends JFrame{
    About()
    {
       setSize (700,500);
       setLocation(400,150);
       setLayout(null);
       getContentPane().setBackground(Color.WHITE);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,20,280,200);
        add(image);
        //add(image);
       JLabel heading = new JLabel("<html>University<br/>Management System<html>");
       heading.setBounds(70,20,500,130);
       heading.setFont(new Font("Tahoma",Font.BOLD,30));
       add(heading);
       JLabel name = new JLabel("Developed by: Group 4");
       name.setBounds(70,240,550,40);
       name.setFont(new Font("Tahoma",Font.BOLD,30));
       add(name);
       JLabel rollno = new JLabel("Roll Numbers : ");
       rollno.setBounds(70,280,550,40);
       rollno.setFont(new Font("Tahoma",Font.BOLD,30));
       add(rollno);
       JLabel rollno1 = new JLabel("0905IT211041");
       rollno1.setBounds(300,280,500,40);
       rollno1.setFont(new Font("Tahoma",Font.PLAIN,30));
       add(rollno1);
         setVisible(true);
    }
  public static void main(String[]args)
  {
      new About();
  }
}
