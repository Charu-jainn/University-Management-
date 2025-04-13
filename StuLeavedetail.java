
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class StuLeavedetail extends JFrame implements ActionListener{
      Choice erollno; 
      JTable table;
      JButton search, print, update, add, cancel;
    StuLeavedetail()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20,20,150,20);
        add(heading);
        erollno = new Choice();
        erollno.setBounds(180,20,150,20);
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
        table = new JTable();
        try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("Select*from stuleave");
          table.setModel(DbUtils.resultSetToTableModel(rs));
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        search = new JButton("Search");
        search.addActionListener(this);
        search.setBounds(20,70,80,20);
        add(search);
         print= new JButton("Print");
        print.setBounds(120,70,80,20);
         print.addActionListener(this);
        add(print);
        
       cancel= new JButton("Cancel");
        cancel.setBounds(220,70,80,20);
         cancel.addActionListener(this);
        add(cancel);
        
       setSize(900,700);
       setLocation(300,100);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==search)
      {
        String query =  "select * from stuleave where rollno='"+erollno.getSelectedItem()+"'"; 
        try
        {
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery(query);
          table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
      }
      else if(ae.getSource()==print)
      {
          try{
            table.print();
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
    public static void main(String []args)
    {
        new StuLeavedetail();
    }
}

