package placement.management.system;

import java.awt.*;
import javax.swing.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddCompany extends JFrame implements ActionListener{
    
    JTextField tfcname,tfid,tfbranch,tfcgpa,tfaddress;//tfmail
    //JDateChooser dcdob
    JButton add,back;
    AddCompany(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Company Details");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
       
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50, 150, 150, 30);
        labelname.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelname);
        
        tfcname = new JTextField();
        tfcname.setBounds(200,150,150,30);
        add(tfcname);
        
        
        JLabel labelid = new JLabel("Companyid");
        labelid.setBounds(400, 150, 150, 30);
        labelid.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelid);
        
        tfid = new JTextField();
        tfid.setBounds(600,150,150,30);
        add(tfid);
        
        
//        JLabel labeldob =new JLabel("Date");
//        labeldob.setBounds(50,200,150,30);
//        labeldob.setFont(new Font("serif",Font.PLAIN,20));
//        add(dcdob);
//        
//        
//        JDateChooser dcdob = new JDateChooser();
//        dcdob.setBounds(200,200,150,30);
//        add(dcdob);
        
        
       /* JLabel labelmail = new JLabel("Email");
        labelmail.setBounds(50, 200, 150, 30);
        labelmail.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelmail);
        
        tfmail = new JTextField();
        tfmail.setBounds(200,200,150,30);
        add(tfmail);
        */
        
        JLabel labelcgpa = new JLabel("CGPA Cutoff");
        labelcgpa.setBounds(400, 250, 150, 30);
        labelcgpa.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelcgpa);
        
        tfcgpa = new JTextField();
        tfcgpa.setBounds(600,250,150,30);
        add(tfcgpa);
        
        
        JLabel labelbranch = new JLabel("Branch");
        labelbranch.setBounds(50, 250, 150, 30);
        labelbranch.setFont(new Font("serif", Font.PLAIN, 20));
        add(labelbranch);
        
        tfbranch = new JTextField();
        tfbranch.setBounds(200,250,150,30);
        add(tfbranch);
        
        
       JLabel labeladdress = new JLabel("Package");
        labeladdress.setBounds(300, 350, 150, 30);
        labeladdress.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(400,350,150,30);
        add(tfaddress);
        
        add= new JButton("Add Details");
        add.setBounds(250,400,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,400,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== add){
            String name=tfcname.getText();
            String id=tfid.getText();
            String branch=tfbranch.getText();
            //String Phone=tfphone.getText();
            String cgpa=tfcgpa.getText();
            String address=tfaddress.getText();
            //String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            
            try {
       //         String username=tfusername.getText();
       //       Sring password=tfpassword.getText();
                
                Conn conn = new Conn();
                String query = "insert into company values('"+id+"', '"+name+"', '"+branch+"','"+address+"','"+cgpa+"')";//'"+cgpa+"','"+Phone+"','"+address+"'
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details added successfully");
                setVisible(false);
                new Faculty();
            } catch (Exception e) {
                e.printStackTrace();
                
            }
            
        }else{
            setVisible(false);
            new Faculty();
        }
    }
    
    public static void main(String[] args){
        new AddCompany();
    }
    
}
