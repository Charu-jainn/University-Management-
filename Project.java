
package university.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame implements ActionListener{
    Project()
    {
        setSize(1540,800);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/six.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1540,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);
        //New Information
        JMenu newInformation = new JMenu("New Information");
        newInformation.setForeground(Color.BLUE);
        mb.add(newInformation);
        JMenuItem facultyInfo = new JMenuItem("New Faculty Information");
        facultyInfo.setBackground(Color.WHITE);
        facultyInfo.addActionListener(this);
        newInformation.add(facultyInfo);
        JMenuItem stuInfo = new JMenuItem("New Student Information");
        stuInfo.setBackground(Color.WHITE);
        stuInfo.addActionListener(this);
        newInformation.add(stuInfo);
        //Details
        JMenu details = new JMenu("View Details");
        details.setForeground(Color.RED);
        mb.add(details);
        JMenuItem facultydetails = new JMenuItem("View Faculty Details");
        facultydetails.setBackground(Color.WHITE);
        facultydetails.addActionListener(this);
        details.add(facultydetails);
        JMenuItem studetails = new JMenuItem("View Student Details");
        studetails.setBackground(Color.WHITE);
        studetails.addActionListener(this);
        details.add(studetails);
        //Leave
        JMenu leave = new JMenu("Apply Leave");
        leave.setForeground(Color.BLUE);
        mb.add(leave);
        JMenuItem facultyleave = new JMenuItem("Faculty Leave");
        facultyleave.setBackground(Color.WHITE);
        facultyleave.addActionListener(this);
        leave.add(facultyleave);
        JMenuItem stuleave = new JMenuItem("Student Leave");
        stuleave.setBackground(Color.WHITE);
        stuleave.addActionListener(this);
        leave.add(stuleave);
        //Leave Details
        JMenu leaveDetail = new JMenu("Leave Details");
        leaveDetail.setForeground(Color.RED);
        mb.add(leaveDetail);
        JMenuItem facultyleaveDetail = new JMenuItem("Faculty Leave Details");
        facultyleaveDetail.setBackground(Color.WHITE);
        facultyleaveDetail.addActionListener(this);
        leaveDetail.add(facultyleaveDetail);
        JMenuItem stuleaveDetail = new JMenuItem("Student Leave Details");
        stuleaveDetail.setBackground(Color.WHITE);
        stuleaveDetail.addActionListener(this);
        leaveDetail.add(stuleaveDetail);
        //Exams
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.BLUE);
        mb.add(exam);
        JMenuItem examdetails = new JMenuItem("Examination Results");
        examdetails.setBackground(Color.WHITE);
         examdetails.addActionListener(this);
        exam.add(examdetails);
        JMenuItem entermarks = new JMenuItem("Enter marks");
        entermarks.setBackground(Color.WHITE);
        entermarks.addActionListener(this);
        exam.add(entermarks);
        //Update Details
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo .setForeground(Color.RED);
        mb.add(updateInfo );
        JMenuItem updatefacultyinfo = new JMenuItem("Update Faculty Details");
        updatefacultyinfo.setBackground(Color.WHITE);
        updatefacultyinfo.addActionListener(this);
        updateInfo .add(updatefacultyinfo);
        JMenuItem updatestuinfo = new JMenuItem("Update Student Details");
        updatestuinfo.setBackground(Color.WHITE);
        updatestuinfo.addActionListener(this);
        updateInfo .add(updatestuinfo);
        //Workshop
        JMenu workshop = new JMenu("Workshop");
        workshop .setForeground(Color.BLUE);
        mb.add(workshop );
        JMenuItem workshopdetail = new JMenuItem("Update Workshop Details");
       workshopdetail.setBackground(Color.WHITE);
        workshop .add(workshopdetail);
        JMenuItem showworkshop = new JMenuItem("Show Available Workshop");
        showworkshop.setBackground(Color.WHITE);
        workshop .add(showworkshop);
        //Fee Details
        JMenu Fee = new JMenu("Fee Details");
        Fee .setForeground(Color.RED);
        
        mb.add(Fee );
        JMenuItem feestructure = new JMenuItem("Fee Structure");
        feestructure .setBackground(Color.WHITE);
        feestructure.addActionListener(this);
        Fee.add(feestructure );
        JMenuItem feeform = new JMenuItem("Student Fee Form");
        feeform.setBackground(Color.WHITE);
        feeform.addActionListener(this);
        Fee.add(feeform);
        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.BLUE);
        mb.add(utility );
        JMenuItem notepad = new JMenuItem("NotePad");
        notepad .setBackground(Color.WHITE);
        notepad.addActionListener(this);
        utility.add(notepad );
        JMenuItem calc = new JMenuItem("Calculator");
       calc.setBackground(Color.WHITE);
       calc.addActionListener(this);
        utility.add(calc);
        
        setVisible(true);
         JMenu About = new JMenu("About");
       About.setForeground(Color.RED);
        mb.add(About );
        JMenuItem ab = new JMenuItem("About");
       ab .setBackground(Color.WHITE);
       ab.addActionListener(this);
        About.add(ab );
        //Exit
        JMenu Exit = new JMenu("Exit");
       Exit.setForeground(Color.BLUE);
        mb.add(Exit );
        JMenuItem ex = new JMenuItem("Exit");
       ex .setBackground(Color.WHITE);
       ex.addActionListener(this);
        Exit.add(ex );
        
        
        setVisible(true);
    }
    public void actionPerformed (ActionEvent ae)
    {
        String msg = ae.getActionCommand();
        if(msg.equals("Exit"))
        {
            setVisible(false);
        }
        else if(msg.equals("Calculator"))
        {
            try{
               Runtime.getRuntime() .exec("calc.exe");
            }
            catch(Exception e)
            {
                
            }
            
        }
        else if(msg.equals("New Student Information"))
        {
            new Addstudent();
        }
        else if(msg.equals("New Faculty Information"))
                {
                    new AddTeacher();
                }
        else if(msg.equals("Student Leave"))
        {
            new StuLeave();
        }
        else if(msg.equals("Faculty Leave"))
                {
                    new TeacherLeave();
                }
        else if(msg.equals("NotePad"))
        {
            try{
               Runtime.getRuntime() .exec("notepad.exe");
            }
            catch(Exception e)
            {
                
            }
        } 
        
        else if(msg.equals("View Faculty Details"))
        {
            new TeacherDetails();
        }
        else if(msg.equals("View Student Details"))
        {
            new StudentDetails();
        }
       
        else if(msg.equals("Faculty Leave Details"))
        {
            new Teacherleavedetail();
        }
         else if(msg.equals("Student Leave Details"))
        {
            new StuLeavedetail();
        }
        else if(msg.equals("Update Faculty Details"))
        {
            new Updateteacher();
        }
        else if(msg.equals("Update Student Details"))
        {
            new Updatestu();
        }
        else if(msg.equals("Enter marks"))
        {
           new Entermark();
        }
         else if(msg.equals("Examination Results"))
        {
           new Examdetails();
        }
         else if(msg.equals("Fee Structure"))
        {
           new Feestruc();
        }
         else if(msg.equals("About"))
        {
           new About();
        }
         else if(msg.equals("Student Fee Form"))
        {
           new Stufeeform();
        }
        
        
    }
    public static void main (String[]args)
    {
        new Project();
    }
}
