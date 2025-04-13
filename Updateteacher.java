package university.management.system;


import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

//import com.toedter.calendar.JDateChooser;

public class Updateteacher extends JFrame implements ActionListener{
   JTextField tfbranch,tffadd,tfphone,tfemail,tfaadhar,tfcourse; 
   JLabel labelempId;
   Choice eempId;
   
   JButton submit,cancel;
   
   Updateteacher()
    {
        setSize(900,650);
        setLocation(350,50);
        setLayout(null);
        JLabel heading = new JLabel("Update Teacher Detail");
        heading.setBounds(50,10,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);
        JLabel lblrollnumber = new JLabel("Select Employee ID");
        lblrollnumber.setBounds(50,100,200,20);
        lblrollnumber.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollnumber);
        eempId = new Choice();
        eempId.setBounds(250,100,200,20);
        add(eempId);
        try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("Select*from teacher");
          while(rs.next())
          {
              eempId.add(rs.getString("empId"));
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JLabel labname = new JLabel("Name");
        labname.setBounds(50,150,100,30);
        labname.setFont(new Font("serif",Font.BOLD,20));
        add(labname);
        JLabel labelname = new JLabel();
        labelname.setBounds(200,150,150,30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelname);
        JLabel lblfname = new JLabel("Father's Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);
        JLabel labelfname = new JLabel();
        labelfname.setBounds(600,150,150,30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelfname);
        JLabel lblrollno = new JLabel("RollNo");
        lblrollno.setBounds(50,200,200,30);
        lblrollno.setFont(new Font("serif",Font.BOLD,20));
        add(lblrollno);
         labelempId = new JLabel();
        labelempId.setBounds(200,200,200,30);
        labelempId.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelempId);
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);
        JLabel lbldoc = new JLabel();
        lbldoc.setBounds(600,200,150,30);
        lbldoc.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lbldoc);
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50,250,150,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);
        tffadd = new JTextField();
        tffadd.setBounds(200,250,150,30);
        tffadd.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tffadd);
        JLabel lblphone = new JLabel("Phone number");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);
        tfphone = new JTextField();
        tfphone.setBounds(600,250,150,30);
        tfphone.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfphone);
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);
        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        tfemail.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(tfemail);
        JLabel lblx = new JLabel("Class X(%)");
        lblx.setBounds(400,300,200,30);
        lblx.setFont(new Font("serif",Font.BOLD,20));
        add(lblx);
        JLabel labelx = new JLabel();
        labelx .setBounds(600,300,150,30);
        labelx.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelx );
        JLabel lblxii = new JLabel("Class XII(%)");
        lblxii.setBounds(50,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);
        JLabel labelxii = new JLabel();
        labelxii.setBounds(200,350,150,30);
        labelxii.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelxii);
        JLabel lblaadhar = new JLabel("Aadhar Number");
        lblaadhar.setBounds(400,350,200,30);
        lblaadhar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhar);
        JLabel labelaadhar = new JLabel();
        labelaadhar.setBounds(600,350,150,30);
        labelaadhar.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(labelaadhar);
        JLabel lblcourse = new JLabel("Qualification");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);
        //String course[] = {"B.TECH","BBA","BCA","MBA","Bsc","Msc"};
        tfcourse = new JTextField();
        tfcourse.setBounds(200,400,150,30);
        tfcourse.setFont(new Font("Tahoma",Font.PLAIN,18));
        tfcourse.setBackground(Color.WHITE);
        add(tfcourse);
        JLabel lblbranch = new JLabel("Department");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);
        //String branch[] = {"Computer Science","Information&Technology","Civil","Electronic"};
        tfbranch = new JTextField();
        tfbranch.setBounds(600,400,150,30);
        tfbranch.setFont(new Font("Tahoma",Font.PLAIN,18));
        tfbranch.setBackground(Color.WHITE);
        add(tfbranch);
        try
        {
          Conn c = new Conn();
          String query = "select * from teacher where empId = '"+eempId.getSelectedItem()+"'";
          
          ResultSet rs = c.s.executeQuery(query);
          while(rs.next())
          {
              labelname.setText(rs.getString("name"));
              labelfname.setText(rs.getString("fname"));
              labelempId.setText(rs.getString("empId"));
              tffadd.setText(rs.getString("address"));
              tfphone.setText(rs.getString("phone"));
              tfemail.setText(rs.getString("email"));
              lbldoc.setText(rs.getString("dob"));
              labelx.setText(rs.getString("X"));
              labelxii.setText(rs.getString("Xii"));
              lblaadhar.setText(rs.getString("aadhar"));
              tfcourse.setText(rs.getString("Qualification"));
              tfbranch.setText(rs.getString("Department"));
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        eempId.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie)
            {
           try
        {
          Conn c = new Conn();
          String query = "select * from teacher where empId = '"+eempId.getSelectedItem()+"'";
          
          ResultSet rs = c.s.executeQuery(query);
          while(rs.next())
          {
              labelname.setText(rs.getString("name"));
              labelfname.setText(rs.getString("fname"));
              labelempId.setText(rs.getString("rollno"));
              tffadd.setText(rs.getString("address"));
              tfphone.setText(rs.getString("phone"));
              tfemail.setText(rs.getString("email"));
              lbldoc.setText(rs.getString("dob"));
              labelx.setText(rs.getString("X"));
              labelxii.setText(rs.getString("Xii"));
              lblaadhar.setText(rs.getString("aadhar"));
              tfcourse.setText(rs.getString("Qualification"));
              tfbranch.setText(rs.getString("Department"));
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }         
            }});
        
        submit = new JButton("Update");
        submit.setBounds(250,500,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
       submit.setFont(new Font("Serif",Font.BOLD,15));
        add(submit);
         cancel = new JButton("Cancel");
        cancel.setBounds(450,500,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setFont(new Font("Serif",Font.BOLD,15));
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
          
           
           //String dob = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
             String address = tffadd.getText();
             String phone = tfphone.getText();
             String email = tfemail.getText();
            String empId = labelempId.getText();
             
             String education = tfcourse.getText();
             String department =tfbranch.getText();
             
             try
             {
               String query = "update teacher set address ='"+address+"',phone = '"+phone+"',email ='"+email+"',Qualification ='"+education+"',Department = '"+department+"'where empId = '"+empId+"'";  
               Conn con = new Conn();
               con.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null,"Teacher Details Updated Successfully");
               //setVisible("false");

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
       new Updateteacher();
   }
}
