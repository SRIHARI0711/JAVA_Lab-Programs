package Student_info_app;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Student_Management_Fixed extends JFrame implements ActionListener {
    ArrayList<Student> arr = new ArrayList<Student>();
    JFrame displayFrame;
    JLabel name1, age1, addr1, usn1, category1, sgp1, sgp2, sgp3, sgp4, cgp1;
    JTextField name, age, addr, usn, sgpa1, sgpa2, sgpa3, sgpa4, cgp;
    JComboBox<String> category;
    JButton compute, done, complete;
    JTextArea jt;
    float cgpa;

    public Student_Management_Fixed() {
        super("Student Management System");
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        setupFrame();
    }

    private void initializeComponents() {
        // Labels
        name1 = new JLabel("Enter Name:");
        age1 = new JLabel("Enter Age:");
        addr1 = new JLabel("Enter Address:");
        usn1 = new JLabel("Enter USN:");
        category1 = new JLabel("Enter Category:");
        sgp1 = new JLabel("Enter SGPA1:");
        sgp2 = new JLabel("Enter SGPA2:");
        sgp3 = new JLabel("Enter SGPA3:");
        sgp4 = new JLabel("Enter SGPA4:");
        cgp1 = new JLabel("CGPA computed:");

        // Text Fields
        name = new JTextField(15);
        age = new JTextField(15);
        addr = new JTextField(15);
        usn = new JTextField(15);
        sgpa1 = new JTextField(15);
        sgpa2 = new JTextField(15);
        sgpa3 = new JTextField(15);
        sgpa4 = new JTextField(15);
        cgp = new JTextField(15);
        cgp.setEditable(false);

        // ComboBox
        String[] categories = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(categories);

        // Buttons
        compute = new JButton("Compute CGPA");
        done = new JButton("Add to collection");
        complete = new JButton("Display Collection");

        // TextArea for display
        jt = new JTextArea(20, 40);
        jt.setEditable(false);
        jt.setFont(new Font("Monospaced", Font.PLAIN, 12));

        // Initially hide done and complete buttons
        done.setVisible(false);
        complete.setVisible(false);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());

        // Main panel with form fields
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Add components to main panel
        int row = 0;
        
        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(name1, gbc);
        gbc.gridx = 1;
        mainPanel.add(name, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(age1, gbc);
        gbc.gridx = 1;
        mainPanel.add(age, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(addr1, gbc);
        gbc.gridx = 1;
        mainPanel.add(addr, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(usn1, gbc);
        gbc.gridx = 1;
        mainPanel.add(usn, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(category1, gbc);
        gbc.gridx = 1;
        mainPanel.add(category, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(sgp1, gbc);
        gbc.gridx = 1;
        mainPanel.add(sgpa1, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(sgp2, gbc);
        gbc.gridx = 1;
        mainPanel.add(sgpa2, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(sgp3, gbc);
        gbc.gridx = 1;
        mainPanel.add(sgpa3, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(sgp4, gbc);
        gbc.gridx = 1;
        mainPanel.add(sgpa4, gbc);
        row++;

        gbc.gridx = 0; gbc.gridy = row;
        mainPanel.add(cgp1, gbc);
        gbc.gridx = 1;
        mainPanel.add(cgp, gbc);
        row++;

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(compute);
        buttonPanel.add(done);
        buttonPanel.add(complete);

        // Add panels to frame
        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Setup display frame
        displayFrame = new JFrame("Student Collection");
        displayFrame.setLayout(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(jt);
        displayFrame.add(scrollPane, BorderLayout.CENTER);
        displayFrame.setSize(600, 400);
        displayFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        displayFrame.setLocationRelativeTo(this);
    }

    private void setupEventHandlers() {
        compute.addActionListener(this);
        done.addActionListener(this);
        complete.addActionListener(this);
    }

    private void setupFrame() {
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == compute) {
            computeCGPA();
        } else if (ae.getSource() == done) {
            addStudentToCollection();
        } else if (ae.getSource() == complete) {
            displayCollection();
        }
    }

    private void computeCGPA() {
        try {
            // Validate SGPA fields are not empty
            if (sgpa1.getText().trim().isEmpty() || sgpa2.getText().trim().isEmpty() ||
                sgpa3.getText().trim().isEmpty() || sgpa4.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all SGPA fields", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            float t1 = Float.parseFloat(sgpa1.getText());
            float t2 = Float.parseFloat(sgpa2.getText());
            float t3 = Float.parseFloat(sgpa3.getText());
            float t4 = Float.parseFloat(sgpa4.getText());

            if (t1 < 0 || t1 > 10.0f || t2 < 0 || t2 > 10.0f || t3 < 0 || t3 > 10.0f || t4 < 0 || t4 > 10.0f) {
                JOptionPane.showMessageDialog(this, "Enter correct SGPA values (0-10)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            cgpa = (t1 + t2 + t3 + t4) / 4;
            cgp.setText(String.format("%.2f", cgpa));
            done.setVisible(true);
            complete.setVisible(true);
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values for SGPA", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addStudentToCollection() {
        try {
            // Get data from text fields
            String n = name.getText().trim();
            String ad = addr.getText().trim();
            String u = usn.getText().trim();
            String c = (String) category.getSelectedItem();

            // Validate required fields
            if (n.isEmpty() || ad.isEmpty() || u.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all required fields (Name, Address, USN)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (age.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter age", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int x = Integer.parseInt(age.getText());
            if (x < 18 || x > 100) {
                JOptionPane.showMessageDialog(this, "Enter correct age (18-100)", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            float t1 = Float.parseFloat(sgpa1.getText());
            float t2 = Float.parseFloat(sgpa2.getText());
            float t3 = Float.parseFloat(sgpa3.getText());
            float t4 = Float.parseFloat(sgpa4.getText());

            Student temp = new Student(n, u, x, ad, t1, t2, t3, t4, c);
            arr.add(temp);
            JOptionPane.showMessageDialog(this, "Student added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Clear fields after adding
            clearFields();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numeric values", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void displayCollection() {
        if (arr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students in collection!", "Info", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        jt.setText("");
        for (int i = 0; i < arr.size(); i++) {
            Student stud = arr.get(i);
            jt.append("Student " + (i + 1) + ":\n");
            jt.append("Name: " + stud.name + "\n");
            jt.append("USN: " + stud.usn + "\n");
            jt.append("Age: " + stud.age + "\n");
            jt.append("Address: " + stud.address + "\n");
            jt.append("CGPA: " + String.format("%.2f", stud.cgpa) + "\n");
            jt.append("Category: " + stud.category + "\n");
            jt.append("------------------------\n");
        }
        displayFrame.setVisible(true);
    }

    private void clearFields() {
        name.setText("");
        age.setText("");
        addr.setText("");
        usn.setText("");
        sgpa1.setText("");
        sgpa2.setText("");
        sgpa3.setText("");
        sgpa4.setText("");
        cgp.setText("");
        category.setSelectedIndex(0);
        done.setVisible(false);
        complete.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Student_Management_Fixed app = new Student_Management_Fixed();
            app.setVisible(true);
            System.out.println("Student Management Application started successfully!");
        });
    }
}