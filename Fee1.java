import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Fee1 extends JFrame {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/RegistrationDB";
    private static final String USER = "root"; // Replace with your database username
    private static final String PASSWORD = "tharushi2001"; // Replace with your database password

    // Declaring GUI components
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, background;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
    JTextArea area1, area2;
    JRadioButton rb1, rb2, rb3, rb4, r5, r6;
    JComboBox<String> cb, cb1, cb2;
    JButton btnReset, btnReceipt, btnPrint, btnAddMarks;

    // Font constants for uniform font size
    Font labelFont = new Font("Serif", Font.BOLD, 18);
    Font textFont = new Font("Serif", Font.PLAIN, 16);
    Font buttonFont = new Font("Serif", Font.BOLD, 18);

    // Constructor to initialize components
    public Fee1() {
        // Setting up the frame
        setTitle("Registration Management System");
        setSize(1500, 900);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load background image
        String imagePath = "C:/Users/IPK Computers/Pictures/Photo/Image.png"; // Update with the actual path
        ImageIcon bgImage = new ImageIcon(imagePath);

        if (bgImage.getImageLoadStatus() != MediaTracker.COMPLETE) {
            JOptionPane.showMessageDialog(this, "Image not found or failed to load.");
        } else {
            Image scaledImage = bgImage.getImage().getScaledInstance(1500, 900, Image.SCALE_SMOOTH);
            background = new JLabel(new ImageIcon(scaledImage));
            background.setBounds(0, 0, 1500, 900);
            background.setLayout(null);
        }

        // Initialize components
        l1 = new JLabel("Registration & Marks System");
        l1.setBounds(490, 5, 500, 100);
        l1.setFont(new Font("Serif", Font.BOLD, 36));
        l1.setForeground(Color.WHITE);

        l2 = new JLabel("Name of the Student:");
        l2.setBounds(50, 100, 300, 30);
        l2.setFont(labelFont);
        tf1 = new JTextField();
        tf1.setBounds(250, 100, 300, 30);
        tf1.setFont(textFont);

        l3 = new JLabel("Custodian's Name:");
        l3.setBounds(50, 150, 300, 30);
        l3.setFont(labelFont);
        tf2 = new JTextField();
        tf2.setBounds(250, 150, 300, 30);
        tf2.setFont(textFont);

        l4 = new JLabel("Student ID Number:");
        l4.setBounds(50, 200, 300, 30);
        l4.setFont(labelFont);
        tf3 = new JTextField();
        tf3.setBounds(250, 200, 300, 30);
        tf3.setFont(textFont);

        l5 = new JLabel("Email:");
        l5.setBounds(50, 250, 300, 30);
        l5.setFont(labelFont);
        tf4 = new JTextField();
        tf4.setBounds(250, 250, 300, 30);
        tf4.setFont(textFont);

        l6 = new JLabel("Contact Number:");
        l6.setBounds(50, 300, 300, 30);
        l6.setFont(labelFont);
        tf5 = new JTextField();
        tf5.setBounds(250, 300, 300, 30);
        tf5.setFont(textFont);

        l7 = new JLabel("Address:");
        l7.setBounds(50, 350, 300, 30);
        l7.setFont(labelFont);
        area1 = new JTextArea();
        area1.setBounds(250, 350, 300, 90);
        area1.setFont(textFont);

        l9 = new JLabel("Gender:");
        l9.setBounds(50, 450, 300, 30);
        l9.setFont(labelFont);
        r5 = new JRadioButton("Male");
        r5.setBounds(250, 450, 100, 30);
        r5.setFont(textFont);
        r6 = new JRadioButton("Female");
        r6.setBounds(350, 450, 100, 30);
        r6.setFont(textFont);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r5);
        genderGroup.add(r6);

        l10 = new JLabel("Nationality:");
        l10.setBounds(50, 500, 300, 30);
        l10.setFont(labelFont);
        tf6 = new JTextField();
        tf6.setBounds(250, 500, 300, 30);
        tf6.setFont(textFont);

        l11 = new JLabel("Year of Birth:");
        l11.setBounds(50, 550, 300, 30);
        l11.setFont(labelFont);
        cb1 = new JComboBox<>(new String[]{"1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004"});
        cb1.setBounds(250, 550, 150, 30);
        cb1.setFont(textFont);

        l12 = new JLabel("Religion:");
        l12.setBounds(50, 600, 300, 30);
        l12.setFont(labelFont);
        cb2 = new JComboBox<>(new String[]{"Buddhist", "Muslim", "Hindu", "Christian"});
        cb2.setBounds(250, 600, 150, 30);
        cb2.setFont(textFont);

        l13 = new JLabel("NIC Number:");
        l13.setBounds(50, 650, 300, 30);
        l13.setFont(labelFont);
        tf7 = new JTextField();
        tf7.setBounds(250, 650, 300, 30);
        tf7.setFont(textFont);

        l8 = new JLabel("Course Details:");
        l8.setBounds(600, 100, 300, 30);
        l8.setFont(labelFont);

        rb1 = new JRadioButton("Full Time");
        rb1.setBounds(600, 150, 150, 30);
        rb1.setFont(textFont);
        rb2 = new JRadioButton("Part Time");
        rb2.setBounds(750, 150, 150, 30);
        rb2.setFont(textFont);
        rb3 = new JRadioButton("Hosteller");
        rb3.setBounds(600, 200, 150, 30);
        rb3.setFont(textFont);
        rb4 = new JRadioButton("From Home");
        rb4.setBounds(750, 200, 150, 30);
        rb4.setFont(textFont);

        ButtonGroup groupSelection = new ButtonGroup();
        groupSelection.add(rb1);
        groupSelection.add(rb2);
        ButtonGroup accommodation = new ButtonGroup();
        accommodation.add(rb3);
        accommodation.add(rb4);

        cb = new JComboBox<>(new String[]{"HNDIT", "HNDE", "HNDAC"});
        cb.setBounds(600, 250, 200, 30);
        cb.setFont(textFont);

        btnReset = new JButton("Reset");
        btnReset.setBounds(790, 310, 100, 30);
        btnReset.setFont(buttonFont);
        btnReceipt = new JButton("Generate Details");
        btnReceipt.setBounds(600, 310, 200, 30);
        btnReceipt.setFont(buttonFont);
        btnPrint = new JButton("Print");
        btnPrint.setBounds(890, 310, 100, 30);
        btnPrint.setFont(buttonFont);

        area2 = new JTextArea();
        area2.setBounds(600, 370, 350, 320);
        area2.setFont(new Font("Serif", Font.PLAIN, 16)); // Slightly smaller for the receipt text
        area2.setEditable(false);

        // Add "Add Marks" button
        btnAddMarks = new JButton("Add Marks");
        btnAddMarks.setBounds(1100, 550, 250, 30);
        btnAddMarks.setFont(buttonFont);
        btnAddMarks.addActionListener(e -> openAddMarksWindow());

        // Add components to the background
        background.add(l1);
        background.add(l2);
        background.add(tf1);
        background.add(btnAddMarks); // Last!
        // Add all other components here (same as above)...
        // Attach all labels, text fields, buttons, and text areas
        background.add(l3);
        background.add(tf2);
        background.add(l4);
        background.add(tf3);
        background.add(l5);
        background.add(tf4);
        background.add(l6);
        background.add(tf5);
        background.add(l7);
        background.add(area1);
        background.add(l9);
        background.add(r5);
        background.add(r6);
        background.add(l10);
        background.add(tf6);
        background.add(l11);
        background.add(cb1);
        background.add(l12);
        background.add(cb2);
        background.add(l13);
        background.add(tf7);
        background.add(l8);
        background.add(rb1);
        background.add(rb2);
        background.add(rb3);
        background.add(rb4);
        background.add(cb);
        background.add(btnReset);
        background.add(btnReceipt);
        background.add(btnPrint);
        background.add(area2);

        add(background);

        // Add action listeners for buttons
        btnReceipt.addActionListener(e -> saveStudentDetails());
        btnReset.addActionListener(e -> resetFields());
        btnPrint.addActionListener(e -> printReceipt());

        setVisible(true);
    }

private void openAddMarksWindow() {
    JFrame marksFrame = new JFrame("Add Marks");
    marksFrame.setSize(900, 700);
    marksFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    // Load and set background image
    String imagePath = "C:/Users/IPK Computers/Pictures/Photo/Second.jpeg"; // Update with the correct image path
    ImageIcon bgImage = new ImageIcon(imagePath);

    if (bgImage.getImageLoadStatus() != MediaTracker.COMPLETE) {
        JOptionPane.showMessageDialog(marksFrame, "Background image not found or failed to load.");
        return;
    }

    Image scaledImage = bgImage.getImage().getScaledInstance(900, 700, Image.SCALE_SMOOTH);
    JLabel background = new JLabel(new ImageIcon(scaledImage));
    background.setBounds(0, 0, 900, 700);
    background.setLayout(null);

    // Student Name
    JLabel lblStudentName = new JLabel("Student Name:");
    lblStudentName.setBounds(150, 30, 150, 30);
    lblStudentName.setFont(new Font("Serif", Font.BOLD, 16));
    lblStudentName.setForeground(Color.BLACK);
    JTextField txtStudentName = new JTextField();
    txtStudentName.setBounds(350, 30, 250, 30);

    // Registration Number
    JLabel lblRegNumber = new JLabel("Registration No:");
    lblRegNumber.setBounds(150, 80, 150, 30);
    lblRegNumber.setFont(new Font("Serif", Font.BOLD, 16));
    lblRegNumber.setForeground(Color.BLACK);
    JTextField txtRegNumber = new JTextField();
    txtRegNumber.setBounds(350, 80, 250, 30);

    // Marks for 7 subjects
    JLabel[] lblMarks = new JLabel[7];
    JTextField[] txtMarks = new JTextField[7];
    for (int i = 0; i < 7; i++) {
        lblMarks[i] = new JLabel("Marks " + (i + 1) + ":");
        lblMarks[i].setBounds(150, 130 + (i * 40), 150, 30);
        lblMarks[i].setFont(new Font("Serif", Font.BOLD, 16));
        lblMarks[i].setForeground(Color.BLACK);
        txtMarks[i] = new JTextField();
        txtMarks[i].setBounds(350, 130 + (i * 40), 250, 30);
        background.add(lblMarks[i]);
        background.add(txtMarks[i]);
    }

    // Total Marks
    JLabel lblTotalMarks = new JLabel("Total Marks:");
    lblTotalMarks.setBounds(150, 410, 150, 30);
    lblTotalMarks.setFont(new Font("Serif", Font.BOLD, 16));
    lblTotalMarks.setForeground(Color.BLACK);
    JTextField txtTotalMarks = new JTextField();
    txtTotalMarks.setBounds(350, 410, 250, 30);
    txtTotalMarks.setEditable(false);

    // GPA
    JLabel lblGPA = new JLabel("GPA:");
    lblGPA.setBounds(150, 460, 150, 30);
    lblGPA.setFont(new Font("Serif", Font.BOLD, 16));
    lblGPA.setForeground(Color.BLACK);
    JTextField txtGPA = new JTextField();
    txtGPA.setBounds(350, 460, 250, 30);
    txtGPA.setEditable(false);

    // Calculate Button
    JButton btnCalculate = new JButton("Calculate");
    btnCalculate.setBounds(150, 510, 150, 30);
    btnCalculate.setForeground(Color.BLUE);
    btnCalculate.addActionListener(e -> {
        try {
            int totalMarks = 0;
            for (JTextField markField : txtMarks) {
                int mark = Integer.parseInt(markField.getText());
                if (mark < 0 || mark > 100) {
                    throw new NumberFormatException();
                }
                totalMarks += mark;
            }
            txtTotalMarks.setText(String.valueOf(totalMarks));

            // Calculate GPA (assuming 4.0 scale, total marks out of 700)
            double gpa = (double) totalMarks / 700 * 4.0;
            txtGPA.setText(String.format("%.2f", gpa));

            // Change text field color based on GPA value
            if (gpa < 2) {
                txtGPA.setForeground(Color.RED); // Set text color to red for GPA < 2
            } else {
                txtGPA.setForeground(Color.GREEN); // Set text color to green for GPA >= 2
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(marksFrame, "Please enter valid marks (0-100) for all subjects.");
        }
    });

    // Reset Button
    JButton btnReset = new JButton("Reset");
    btnReset.setBounds(350, 510, 150, 30);
    btnReset.setForeground(Color.BLUE);
    btnReset.addActionListener(e -> {
        txtStudentName.setText("");
        txtRegNumber.setText("");
        for (JTextField markField : txtMarks) {
            markField.setText("");
        }
        txtTotalMarks.setText("");
        txtGPA.setText("");
    });

    // Save Button
    JButton btnSaveMarks = new JButton("Save Marks");
    btnSaveMarks.setBounds(550, 510, 150, 30);
    btnSaveMarks.setForeground(Color.BLUE);
    btnSaveMarks.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String studentName = txtStudentName.getText();
            String regNumber = txtRegNumber.getText();
            int[] marks = new int[7];
            for (int i = 0; i < 7; i++) {
                marks[i] = Integer.parseInt(txtMarks[i].getText());
            }
            int totalMarks = Integer.parseInt(txtTotalMarks.getText());
            double gpa = Double.parseDouble(txtGPA.getText());

            // Insert data into the database
            try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
                String query = "INSERT INTO student_marks (student_name, registration_number, marks1, marks2, marks3, marks4, marks5, marks6, marks7, total_marks, gpa) " +
                               "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, studentName);
                statement.setString(2, regNumber);
                for (int i = 0; i < 7; i++) {
                    statement.setInt(i + 3, marks[i]);
                }
                statement.setInt(10, totalMarks);
                statement.setDouble(11, gpa);
                statement.executeUpdate();

                JOptionPane.showMessageDialog(marksFrame, "Marks saved successfully!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(marksFrame, "Database error: " + ex.getMessage());
            }
        }
    });

    // Add components to background
    background.add(lblStudentName);
    background.add(txtStudentName);
    background.add(lblRegNumber);
    background.add(txtRegNumber);
    background.add(lblTotalMarks);
    background.add(txtTotalMarks);
    background.add(lblGPA);
    background.add(txtGPA);
    background.add(btnCalculate);
    background.add(btnReset);
    background.add(btnSaveMarks);

    // Set background as the content pane of marksFrame
    marksFrame.setContentPane(background);
    marksFrame.setVisible(true);
}





    // Save student details to the database
private void saveStudentDetails() {
    String name = tf1.getText();
    String custodianName = tf2.getText();
    String studentID = tf3.getText();
    String email = tf4.getText();
    String contactNumber = tf5.getText();
    String address = area1.getText();
    String gender = r5.isSelected() ? "Male" : (r6.isSelected() ? "Female" : "");
    String nationality = tf6.getText();
    String yearOfBirth = cb1.getSelectedItem().toString();
    String religion = cb2.getSelectedItem().toString();
    String nic = tf7.getText();
    String courseMode = rb1.isSelected() ? "Full Time" : (rb2.isSelected() ? "Part Time" : "");
    String accommodation = rb3.isSelected() ? "Hosteller" : (rb4.isSelected() ? "From Home" : "");
    String course = cb.getSelectedItem().toString();

    if (name.isEmpty() || studentID.isEmpty() || email.isEmpty() || contactNumber.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in the required fields.");
        return;
    }

    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            String query = "INSERT INTO newstudents (student_name, custodian_name, student_id, email, contact_number, address, gender, nationality, year_of_birth, religion, nic_number, course_mode, accommodation,course) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, name);
            pst.setString(2, custodianName);
            pst.setString(3, studentID);
            pst.setString(4, email);
            pst.setString(5, contactNumber);
            pst.setString(6, address);
            pst.setString(7, gender);
            pst.setString(8, nationality);
            pst.setString(9, yearOfBirth);
            pst.setString(10, religion);
            pst.setString(11, nic);
            pst.setString(12, courseMode); // Set course mode
            pst.setString(13, accommodation); // Set accommodation
            pst.setString(14, course); // Set course

            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Student details saved successfully!");

             // Show the details in the receipt area
                area2.setText("Student Details\n---------------------\n" +
                        "Name: " + name + "\n" +
                        "Custodian Name: " + custodianName + "\n" +
                        "Student ID: " + studentID + "\n" +
                        "Email: " + email + "\n" +
                        "Contact Number: " + contactNumber + "\n" +
                        "Address: " + address + "\n" +
                        "Gender: " + gender + "\n" +
                        "Nationality: " + nationality + "\n" +
                        "Year of Birth: " + yearOfBirth + "\n" +
                        "Religion: " + religion + "\n" +
                        "NIC Number: " + nic + "\n" +
                        "Course: " + course + "\n" +
                        "Accommodation: " + accommodation);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage());
    }
}

    // Reset all fields
    private void resetFields() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        tf7.setText("");
        area1.setText("");
        r5.setSelected(false);
        r6.setSelected(false);
        cb1.setSelectedIndex(0);
        cb2.setSelectedIndex(0);
    }

    // Print receipt
    private void printReceipt() {
        JOptionPane.showMessageDialog(this, "Printing receipt...");
        // Add your print logic here
    }

    // Main method to run the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Fee1::new);
    }
}