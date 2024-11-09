/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package placement.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Faculty extends JFrame implements ActionListener{
      JButton  addCompany,backButton,addStudent,deleteStudent,updateStudent,viewStudent,viewFaculty,updateFaculty,viewCompany,viewInterview,viewStatus;
    Faculty() {
       
        setLayout(null);  
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/stdpl.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 630, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,1120,630);
        add(image);
        
        JLabel heading = new JLabel("Placement Management System");
        heading.setBounds(200, 20, 400, 40);
        heading.setFont(new Font("Raleway", Font.BOLD, 25));
        image.add(heading);
        
        addStudent = new JButton("Add Student");
        addStudent.setBounds(200, 80, 150, 40);
        addStudent.addActionListener(this); // Fixed: updateStudent instead of update
        image.add(addStudent);
        
        deleteStudent = new JButton("Delete Student");
        deleteStudent.setBounds(580, 150, 150, 40);
        deleteStudent.addActionListener(this); // Fixed: updateStudent instead of update
        image.add(deleteStudent);

        viewStudent = new JButton("View Student");
        viewStudent.setBounds(400, 80, 150, 40);
        viewStudent.addActionListener(this); // Fixed: viewStudent instead of view
        image.add(viewStudent);
        
        addCompany = new JButton("Add Company");
        addCompany.setBounds(200, 150, 150, 40);
        addCompany.addActionListener(this); // Fixed: updateStudent instead of update
        image.add(addCompany);
        

        viewCompany = new JButton("View Company");
        viewCompany.setBounds(400, 150, 150, 40); 
        viewCompany.addActionListener(this); // Fixed: viewCompany instead of view
        image.add(viewCompany);
        /*
        viewStatus = new JButton("View Status");
        viewStatus.setBounds(230, 300, 200, 60); 
        viewStatus.addActionListener(this); // Fixed: viewCompany instead of view
        image.add(viewStatus);
        */
        viewInterview = new JButton("View Applications");
        viewInterview.setBounds(220, 300, 490, 60); 
        viewInterview.addActionListener(this); // Fixed: viewInterview instead of view
        image.add(viewInterview);
        
        viewInterview = new JButton("View Applications");
        viewInterview.setBounds(220, 300, 490, 60); 
        viewInterview.addActionListener(this); // Fixed: viewInterview instead of view
        image.add(viewInterview);
        /* viewFaculty = new JButton("View Faculty");
        viewFaculty.setBounds(395, 220, 150, 40); 
        viewFaculty.addActionListener(this); // Fixed: viewCompany instead of view
        image.add(viewFaculty);
        
        updateFaculty = new JButton("Update Faculty");
        updateFaculty.setBounds(200, 150, 150, 40); 
        updateFaculty.addActionListener(this); // Fixed: updateInterview instead of update
        image.add(updateFaculty);
        */
        

        updateStudent = new JButton("Update Student");
        updateStudent.setBounds(580, 80, 150, 40); 
        updateStudent.addActionListener(this); // Fixed: updateInterview instead of update
        image.add(updateStudent);
        
        
        backButton = new JButton("Back");
        backButton.setBounds(800, 20, 80, 30);
        backButton.addActionListener(this);
        image.add(backButton);

        

        setSize(1200,630);
        setLocation(250,100);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
         if (ae.getSource() == addStudent) {
           setVisible(false);
           new AddStudent();
         }
         else if(ae.getSource() == addCompany) {
           setVisible(false);
           new AddCompany();

        } else if (ae.getSource() == deleteStudent) {
            setVisible(false);
           new DeleteStudent();
        } else if (ae.getSource() == viewStudent) {
           setVisible(false);
           new ViewStudent();
        }else if (ae.getSource() == viewCompany) {
           setVisible(false);
           new ViewCompany();
        }else if (ae.getSource() == viewStatus) {
            setVisible(false);
           new ViewStatus();
        /*}else if (ae.getSource() == viewFaculty) {
           setVisible(false);
           new ViewFaculty();
        else if (ae.getSource() == updateFaculty) {
           setVisible(false);
           new ViewFaculty();*/
        }else if (ae.getSource() == viewInterview) {
           setVisible(false);
           new ViewInterview();
        }else if (ae.getSource() == backButton) {
            setVisible(false);
            new Login();
        }else {
           setVisible(false);
           new ViewStudent();
        }
    }

    public static void main(String[] args) {
        new Faculty();
    }
}
