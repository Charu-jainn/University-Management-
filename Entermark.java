
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class Entermark extends JFrame implements ActionListener{
    Choice erollno;
    JComboBox cbsem;
    JTextField tfsub1,tfsub2,tfsub3,tfsub4,tfsub5;
    JTextField tfmark1,tfmark2,tfmark3,tfmark4,tfmark5;
    JButton submit,cancel;
    Entermark(){
        
      setSize(1000,500);
      setLocation(300,150);
      
      getContentPane().setBackground(Color.WHITE);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,40,400,300);
        
        add(image);
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(50,0,500,50);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        add(heading);
        JLabel lblrollnumber = new JLabel("Select Roll Number");
        lblrollnumber.setBounds(50,70,150,20);
        //lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblrollnumber);
        erollno = new Choice();
        erollno.setBounds(200,70,150,20);
        add(erollno);
        try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("Select*from student");
          while(rs.next())
          {
              erollno.add(rs.getString("rollno"));
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel lblsem = new JLabel("Select Semester");
        lblsem.setBounds(50,110,150,20);
        //lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblsem);
        String sem[] = {"1st Semester","2nd Semester","3rd Semester","4th Semester","5th Semester","6th Semester","7th Semester","8th Semester"};
        
        cbsem = new JComboBox(sem);
        cbsem.setBounds(200,110,150,20);
        cbsem.setBackground(Color.WHITE);
        add(cbsem);
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100,150,200,40);
        //lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblentersubject);
        JLabel lblentermark = new JLabel("Enter Mark");
        lblentermark.setBounds(320,150,200,40);
        //lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblentermark);
        tfsub1 = new JTextField();
        tfsub1.setBounds(50,200,200,20);
        add(tfsub1);
        tfsub2 = new JTextField();
        tfsub2.setBounds(50,230,200,20);
        add(tfsub2);
        tfsub3 = new JTextField();
        tfsub3.setBounds(50,260,200,20);
        add(tfsub3);
        tfsub4 = new JTextField();
        tfsub4.setBounds(50,290,200,20);
        add(tfsub4);
        tfsub5 = new JTextField();
        tfsub5.setBounds(50,320,200,20);
        add(tfsub5);
        tfmark1 = new JTextField();
        tfmark1.setBounds(250,200,200,20);
        add(tfmark1);
        tfmark2 = new JTextField();
        tfmark2.setBounds(250,230,200,20);
        add(tfmark2);
        tfmark3 = new JTextField();
        tfmark3.setBounds(250,260,200,20);
        add(tfmark3);
        tfmark4 = new JTextField();
        tfmark4.setBounds(250,290,200,20);
        add(tfmark4);
        tfmark5 = new JTextField();
        tfmark5.setBounds(250,320,200,20);
        add(tfmark5);
        submit = new JButton("Submit");
        submit.setBounds(70,360,150,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
       submit.setFont(new Font("Serif",Font.BOLD,15));
        add(submit);
         cancel = new JButton("Cancel");
        cancel.setBounds(280,360,150,25);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Serif",Font.BOLD,15));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
      setLayout(null);
      setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == submit)
        {
            try
            {
              Conn c = new Conn();
              String query1 = "insert into subject values('"+erollno.getSelectedItem()+"','"+cbsem.getSelectedItem()+"','"+tfsub1.getText()+"','"+tfsub2.getText()+"','"+tfsub3.getText()+"','"+tfsub4.getText()+"','"+tfsub5.getText()+"')";
             String query2 = "insert into marks values('"+erollno.getSelectedItem()+"','"+cbsem.getSelectedItem()+"','"+tfmark1.getText()+"','"+tfmark2.getText()+"','"+tfmark3.getText()+"','"+tfmark4.getText()+"','"+tfmark5.getText()+"')";
            c.s.executeUpdate(query1);
            c.s.executeUpdate(query2);
            JOptionPane.showMessageDialog(null,"Marks inserted Successfully");
            setVisible(false);
            }
            catch(Exception e)
            {
               e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
        }
    }
   public static void main(String [] args)
   {
       new Entermark();
   }
}
