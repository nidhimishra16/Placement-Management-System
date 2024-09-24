/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



/*
package placement.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Apply extends JFrame {
    private JLabel usnLabel, snameLabel, cgpaLabel, cnameLabel;
    private JTextField snameField, cgpaField;
    private JComboBox<String> usnComboBox, companyComboBox;
    private JButton proceedButton, submitButton;

    private Connection conn;
    private PreparedStatement preparedStatement;

    public Apply() {
        setTitle("Apply for Job");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        usnLabel = new JLabel("USN:");
        usnComboBox = new JComboBox<>();
        populateUSNComboBox();
        usnComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchStudentDetails();
            }
        });
        add(usnLabel);
        add(usnComboBox);

        snameLabel = new JLabel("Name:");
        snameField = new JTextField();
        snameField.setEditable(false);
        add(snameLabel);
        add(snameField);

        cgpaLabel = new JLabel("CGPA:");
        cgpaField = new JTextField();
        cgpaField.setEditable(false);
        add(cgpaLabel);
        add(cgpaField);

        cnameLabel = new JLabel("Company:");
        companyComboBox = new JComboBox<>();
        populateCompanyComboBox();
        add(cnameLabel);
        add(companyComboBox);

        proceedButton = new JButton("Proceed");
        proceedButton.setBackground(Color.BLACK);
        proceedButton.setForeground(Color.WHITE);
        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enableSubmitButton();
                JOptionPane.showMessageDialog(Apply.this, "Please review your details and proceed to submit.");
            }
        });
        add(proceedButton);

        submitButton = new JButton("Submit");
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitApplication();
            }
        });
        submitButton.setEnabled(false);
        add(submitButton);

        setVisible(true);
        connectToDatabase();
    }

    private void populateUSNComboBox() {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = "nidhi2003";

            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT usn FROM student";
            preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String usn = resultSet.getString("usn");
                usnComboBox.addItem(usn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fetchStudentDetails() {
        String selectedUSN = (String) usnComboBox.getSelectedItem();
        if (selectedUSN != null) {
            try {
                String query = "SELECT sname, cgpa FROM student WHERE usn = ?";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, selectedUSN);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String name = resultSet.getString("sname");
                    double cgpa = resultSet.getDouble("cgpa");
                    snameField.setText(name);
                    cgpaField.setText(String.valueOf(cgpa));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void populateCompanyComboBox() {
        try {
            String query = "SELECT cname FROM company";
            preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String companyName = resultSet.getString("cname");
                companyComboBox.addItem(companyName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = "nidhi2003";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void enableSubmitButton() {
        submitButton.setEnabled(true);
    }

    private void submitApplication() {
    String selectedUSN = (String) usnComboBox.getSelectedItem();
    String selectedCompanyName = (String) companyComboBox.getSelectedItem();
    if (selectedUSN != null && selectedCompanyName != null) {
        try {
            String query = "SELECT cutoffcgpa, cid FROM company WHERE cname = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, selectedCompanyName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double cutOffCgpa = resultSet.getDouble("cutoffcgpa");
                double studentCgpa = Double.parseDouble(cgpaField.getText());
                if (studentCgpa >= cutOffCgpa) {
                    String cid = resultSet.getString("cid");
                    if (cid.length() <= 10) {
                        // Generate a unique interview number (ino)
                        int ino = generateInterviewNumber();

                        // Insert into interview table
                        String insertQuery = "INSERT INTO interview (ino, cid, cname, USN, cgpa, date) VALUES (?, ?, ?, ?, ?, ?)";
                        preparedStatement = conn.prepareStatement(insertQuery);
                        preparedStatement.setInt(1, ino);
                        preparedStatement.setString(2, cid);
                        preparedStatement.setString(3, selectedCompanyName);
                        preparedStatement.setString(4, selectedUSN);
                        preparedStatement.setDouble(5, studentCgpa);
                        preparedStatement.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
                        preparedStatement.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Successful Submission!");
                    } 
                } else {
                    JOptionPane.showMessageDialog(this, "Rejected due to CGPA cutoff!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Generate a unique interview number (ino)
private int generateInterviewNumber() {
    // You can implement your logic here to generate a unique interview number
    // For simplicity, let's generate a random number between 1 and 1000
    return (int) (Math.random() * 1000) + 1;
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Apply::new);
    }
}


*/


package placement.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Apply extends JFrame {
    private JLabel usnLabel, snameLabel, cgpaLabel, cnameLabel;
    private JTextField snameField, cgpaField;
    private JComboBox<String> usnComboBox, companyComboBox;
    private JButton proceedButton, submitButton, backButton;

    private Connection conn;
    private PreparedStatement preparedStatement;

    public Apply() {
        setTitle("Apply for Job");
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // USN Label and ComboBox
        usnLabel = new JLabel("USN:");
        usnLabel.setBounds(50, 50, 150, 30);
        add(usnLabel);
        usnComboBox = new JComboBox<>();
        usnComboBox.setBounds(200, 50, 150, 30);
        populateUSNComboBox();
        usnComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fetchStudentDetails();
            }
        });
        add(usnComboBox);

        // Name Label and TextField
        snameLabel = new JLabel("Name:");
        snameLabel.setBounds(50, 100, 150, 30);
        add(snameLabel);
        snameField = new JTextField();
        snameField.setBounds(200, 100, 150, 30);
        snameField.setEditable(false);
        add(snameField);

        // CGPA Label and TextField
        cgpaLabel = new JLabel("CGPA:");
        cgpaLabel.setBounds(50, 150, 150, 30);
        add(cgpaLabel);
        cgpaField = new JTextField();
        cgpaField.setBounds(200, 150, 150, 30);
        cgpaField.setEditable(false);
        add(cgpaField);

        // Company Label and ComboBox
        cnameLabel = new JLabel("Company:");
        cnameLabel.setBounds(50, 200, 150, 30);
        add(cnameLabel);
        companyComboBox = new JComboBox<>();
        companyComboBox.setBounds(200, 200, 150, 30);
        populateCompanyComboBox();
        add(companyComboBox);

        // Proceed Button
        proceedButton = new JButton("Proceed");
        proceedButton.setBounds(200, 250, 150, 40);
        proceedButton.setBackground(Color.BLACK);
        proceedButton.setForeground(Color.WHITE);
        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                enableSubmitButton();
                JOptionPane.showMessageDialog(Apply.this, "Please review your details and proceed to submit.");
            }
        });
        add(proceedButton);

        // Submit Button
        submitButton = new JButton("Submit");
        submitButton.setBounds(200, 300, 150, 40);
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitApplication();
            }
        });
        submitButton.setEnabled(false);
        add(submitButton);

        // Back Button
        backButton = new JButton("Back");
        backButton.setBounds(750, 30, 100, 30);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current Apply window
                // Open the Student class
                new Student().setVisible(true);
                // Add the action to navigate back to the previous page (Faculty page)
            }
        });
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        add(backButton);

        setVisible(true);
        connectToDatabase();
    }

    // Method to populate the USN ComboBox
    private void populateUSNComboBox() {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = "nidhi2003";

            conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT usn FROM student";
            preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String usn = resultSet.getString("usn");
                usnComboBox.addItem(usn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch student details based on selected USN
    private void fetchStudentDetails() {
        String selectedUSN = (String) usnComboBox.getSelectedItem();
        if (selectedUSN != null) {
            try {
                String query = "SELECT sname, cgpa FROM student WHERE usn = ?";
                preparedStatement = conn.prepareStatement(query);
                preparedStatement.setString(1, selectedUSN);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    String name = resultSet.getString("sname");
                    double cgpa = resultSet.getDouble("cgpa");
                    snameField.setText(name);
                    cgpaField.setText(String.valueOf(cgpa));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to populate the Company ComboBox
    private void populateCompanyComboBox() {
        try {
            String query = "SELECT cname FROM company";
            preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String companyName = resultSet.getString("cname");
                companyComboBox.addItem(companyName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to connect to the database
    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/project";
            String user = "root";
            String password = "nidhi2003";
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to enable the Submit button
    private void enableSubmitButton() {
        submitButton.setEnabled(true);
    }

    // Method to submit the application
    private void submitApplication() {
String selectedUSN = (String) usnComboBox.getSelectedItem();
    String selectedCompanyName = (String) companyComboBox.getSelectedItem();
    if (selectedUSN != null && selectedCompanyName != null) {
        try {
            String query = "SELECT cutoffcgpa, cid FROM company WHERE cname = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, selectedCompanyName);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                double cutOffCgpa = resultSet.getDouble("cutoffcgpa");
                double studentCgpa = Double.parseDouble(cgpaField.getText());
                if (studentCgpa >= cutOffCgpa) {
                    String cid = resultSet.getString("cid");
                    if (cid.length() <= 10) {
                        // Generate a unique interview number (ino)
                        int ino = generateInterviewNumber();

                        // Insert into interview table
                        String insertQuery = "INSERT INTO interview (ino, cid, cname, USN, cgpa, date) VALUES (?, ?, ?, ?, ?, ?)";
                        preparedStatement = conn.prepareStatement(insertQuery);
                        preparedStatement.setInt(1, ino);
                        preparedStatement.setString(2, cid);
                        preparedStatement.setString(3, selectedCompanyName);
                        preparedStatement.setString(4, selectedUSN);
                        preparedStatement.setDouble(5, studentCgpa);
                        preparedStatement.setDate(6, java.sql.Date.valueOf(java.time.LocalDate.now()));
                        preparedStatement.executeUpdate();

                        JOptionPane.showMessageDialog(this, "Successful Submission!");
                    } 
                } else {
                    JOptionPane.showMessageDialog(this, "Rejected due to CGPA cutoff!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

// Generate a unique interview number (ino)
private int generateInterviewNumber() {
    // You can implement your logic here to generate a unique interview number
    // For simplicity, let's generate a random number between 1 and 1000
    return (int) (Math.random() * 1000) + 1;
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(Apply::new);
    }
}
