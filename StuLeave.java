package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class StuLeave extends JFrame implements ActionListener {
    Choice erollno,etime;
  JDateChooser dcdate;

    JButton submit,cancel;
    StuLeave()
    {
        setSize(500,550);
        setLocation(550,100);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        JLabel heading = new JLabel("Apply Leave(Student)");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(40,50,300,30);
        add(heading);
        JLabel lblrollno = new JLabel("Search by Roll No");
        lblrollno.setBounds(60,100,200,20);
         lblrollno.setFont(new Font("Tahoma",Font.PLAIN,18));       
        add(lblrollno);
        erollno = new Choice();
        erollno.setBounds(60,130,200,20);
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
        JLabel lbldate = new JLabel("Date");
        lbldate.setBounds(60,180,200,20);
        lbldate.setFont(new Font("Tahoma",Font.PLAIN,18));       
        add(lbldate);
        dcdate = new JDateChooser();
        dcdate.setBounds(60,210,200,25);
        add(dcdate);
        JLabel lbltime = new JLabel("Time");
        lbltime.setBounds(60,260,200,20);
         lbltime.setFont(new Font("Tahoma",Font.PLAIN,18));       
        add(lbltime);
        etime = new Choice();
        etime.setBounds(60,290,200,20);
        etime.add("FullDay");
        etime.add("HalfDay");
        
        add(etime);
        submit = new JButton("Submit");
        submit.setBounds(60,350,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Serif",Font.BOLD,15));
        add(submit);
         cancel = new JButton("Cancel");
        cancel.setBounds(200,350,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Serif",Font.BOLD,15));
        cancel.addActionListener(this);
        add(cancel);
        setVisible(true);
    }
    public  void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==submit)
       {
         String rollno = erollno.getSelectedItem();
         String date = ((JTextField)dcdate.getDateEditor().getUiComponent()).getText();
         String duration = etime.getSelectedItem();
         String query = "insert into stuleave values('"+rollno+"','"+date+"','"+duration+"')";
         try
         {
           Conn c =  new Conn();
           c.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Leave Confirmed");
           setVisible(false);
           
         }
         catch(Exception e)
         {
             
         }
       }
       else
       {
           setVisible(false);
       }
    }
   public static void main(String[]args)
   {
       new StuLeave();
   }
}
