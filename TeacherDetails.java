
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class TeacherDetails extends JFrame implements ActionListener{
      Choice eEmpId; 
      JTable table;
      JButton search, print, update, add, cancel;
    TeacherDetails()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel heading = new JLabel("Search by Employee Id");
        heading.setBounds(20,20,150,20);
        add(heading);
        eEmpId = new Choice();
        eEmpId.setBounds(180,20,150,20);
        add(eEmpId);
        try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("Select*from teacher");
          while(rs.next())
          {
              eEmpId.add(rs.getString("empId"));
          }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        table = new JTable();
        try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("Select*from teacher");
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
        add = new JButton("Add");
        add.setBounds(220,70,80,20);
         add.addActionListener(this);
        add(add);
        update = new JButton("Update");
        update.setBounds(320,70,80,20);
         update.addActionListener(this);
        add(update);
       cancel= new JButton("Cancel");
        cancel.setBounds(420,70,80,20);
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
        String query =  "select * from teacher where empId ='"+eEmpId.getSelectedItem()+"'"; 
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
      else if(ae.getSource()==add)
      {
          setVisible(false);
          new AddTeacher();
      }
      else if(ae.getSource()==update)
      {
          setVisible(false);
          new Updateteacher();
      }
      else
      {
          setVisible(false);
      }
    }
    public static void main(String []args)
    {
        new TeacherDetails();
    }
}
