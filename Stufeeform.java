
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class Stufeeform extends JFrame implements ActionListener {
    Choice erollno;
    JComboBox cbcourse,cbbranch,cbsem;
    JLabel labeltotal;
    JButton cancel,submit,back;
    Stufeeform()
    {
       setSize(900,500);
       setLocation(300,100);
       setLayout(null);
       getContentPane().setBackground(Color.WHITE);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fees.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,450,300);
        add(image);
        JLabel lblrollnumber = new JLabel("Select Roll NO");
        lblrollnumber.setBounds(40,60,150,20);
        lblrollnumber.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblrollnumber);
        erollno = new Choice();
        erollno.setBounds(200,60,150,20);
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
        JLabel labname = new JLabel("Name");
        labname.setBounds(40,100,150,20);
        labname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(labname);
        JLabel labelname = new JLabel();
        labelname.setBounds(200,100,150,20);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelname);
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(40,140,150,20);
        lblfname.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblfname);
        JLabel labelfname = new JLabel();
        labelfname.setBounds(200,140,150,20);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(labelfname);
         try
        {
          Conn c = new Conn();
          String query = "select * from student where rollno = '"+erollno.getSelectedItem()+"'";
          
          ResultSet rs = c.s.executeQuery(query);
          while(rs.next())
          {
              labelname.setText(rs.getString("name"));
              labelfname.setText(rs.getString("fname"));
              
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
         erollno.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie)
            {
           try
        {
          Conn c = new Conn();
          String query = "select * from student where rollno = '"+erollno.getSelectedItem()+"'";
          
          ResultSet rs = c.s.executeQuery(query);
          while(rs.next())
          {
              labelname.setText(rs.getString("name"));
              labelfname.setText(rs.getString("fname"));
              
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }         
            }});
         JLabel lblcourse = new JLabel("Course");
        lblcourse.setBounds(40,180,150,20);
        lblcourse.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblcourse);
        String course[] = {"B.TECH","Bsc","BBA","B.Com","M.TECH","Msc"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,180,150,20);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        JLabel lblbranch = new JLabel("Branch");
        lblbranch.setBounds(40,220,150,20);
        lblbranch.setFont(new Font("Tahoma",Font.BOLD,16));
        add(lblbranch);
        String branch[] = {"Computer Science","Information&Technology","Civil","Electronic"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(200,220,150,20);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
         JLabel lblsem = new JLabel("Select Semester");
        lblsem.setBounds(40,260,150,20);
        lblsem.setFont(new Font("Tahoma",Font.BOLD,16));
        //lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lblsem);
        String sem[] = {"Semester1","Semester2","Semester3","Semester4","Semester5","Semester6","Semester7","Semester8"};
        
        cbsem = new JComboBox(sem);
        cbsem.setBounds(200,260,150,20);
        cbsem.setBackground(Color.WHITE);
        add(cbsem);
        JLabel lbltotal = new JLabel("Total Payable");
        lbltotal.setBounds(40,300,150,20);
        lbltotal.setFont(new Font("Tahoma",Font.BOLD,16));
        //lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(lbltotal);
        labeltotal = new JLabel();
        labeltotal.setBounds(200,300,150,20);
        labeltotal.setFont(new Font("Tahoma",Font.PLAIN,16));
        //lblrollnumber.setFont(new Font("serif",Font.PLAIN,20));
        add(labeltotal);
         submit = new JButton("Update");
        submit.setBounds(30,380,100,25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
       submit.setFont(new Font("Serif",Font.BOLD,15));
        add(submit);
         cancel = new JButton("Pay Fee");
        cancel.setBounds(150,380,100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Serif",Font.BOLD,15));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        back= new JButton("Back");
        back.setBounds(270,380,100,25);
         back.setBackground(Color.BLACK);
        back.setFont(new Font("Serif",Font.BOLD,15));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== submit)
        {
          String course = (String)cbcourse.getSelectedItem();
          String semester = (String)cbsem.getSelectedItem();
          try
          {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee where course ='"+course+"' ");
            while(rs.next())
            {
                labeltotal.setText(rs.getString(semester));
            }
          }
          catch(Exception e)
          {
             e.printStackTrace();
          }
        }
        else if(ae.getSource() == cancel)
        {
            String rollno = erollno.getSelectedItem();
             String course = (String)cbcourse.getSelectedItem();
          String semester = (String)cbsem.getSelectedItem();
          String branch = (String)cbbranch.getSelectedItem();
          String total = labeltotal.getText();
          try
          {
            Conn c = new Conn();
            String query = "insert into collegefee values ('"+rollno+"', '"+course+"','"+branch+"', '"+semester+"', '"+total+"')";
            
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"College fee Submitted Successfully");
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
   public static void main(String[]args)
   {
      new Stufeeform();
   }
}
