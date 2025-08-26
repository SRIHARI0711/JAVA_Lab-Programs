package Student_info_app;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Student_Management implements ActionListener{
    ArrayList<Student> arr = new ArrayList<Student>();
    JFrame frm, frm1;
    JLabel name1,age1,addr1,usn1,category1,details,sgp1,sgp2,sgp3,sgp4,cgp1;
    JTextField name,age,addr,usn,sgpa1,sgpa2,sgpa3,sgpa4,cgp;
    JComboBox<String> category;
    JButton compute,done,complete;
    JTextArea jt;
    float cgpa;

    public Student_Management() {
        frm = new JFrame("Enter Student Details");
        frm1 = new JFrame("Display Student Details");
        name1 = new JLabel("Enter Name:");
        age1 = new JLabel("Enter Age:");
        addr1 = new JLabel("Enter Address:");
        usn1 = new JLabel("Enter USN:");
        category1 = new JLabel("Enter Category:");
        String[] categories = {"General", "OBC", "SC", "ST", "Other"};
        category = new JComboBox<>(categories);
        details = new JLabel("Collection of Students");
        jt = new JTextArea(100,100);
        name = new JTextField(20);
        age = new JTextField(20);
        addr = new JTextField(20);
        usn = new JTextField(20);
        sgp1 = new JLabel("Enter SGPA1:");
        sgpa1 = new JTextField(20);
        sgp2 = new JLabel("Enter SGPA2:");
        sgpa2 = new JTextField(20);
        sgp3 = new JLabel("Enter SGPA3:");
        sgpa3 = new JTextField(20);
        sgp4 = new JLabel("Enter SGPA4:");
        sgpa4 = new JTextField(20);
        cgp1 = new JLabel("CGPA computed:");
        cgp = new JTextField(10);
        cgp.setEditable(false); // Make CGPA field read-only
        compute = new JButton("Compute CGPA");
        done = new JButton("Add to collection");
        complete = new JButton("Place in Text Area");
        // Add components directly to frame with GridLayout
        frm.add(name1);     frm.add(name);
        frm.add(age1);      frm.add(age);
        frm.add(addr1);     frm.add(addr);
        frm.add(usn1);      frm.add(usn);
        frm.add(category1); frm.add(category);
        frm.add(sgp1);      frm.add(sgpa1);
        frm.add(sgp2);      frm.add(sgpa2);
        frm.add(sgp3);      frm.add(sgpa3);
        frm.add(sgp4);      frm.add(sgpa4);
        frm.add(cgp1);      frm.add(cgp);
        frm.add(compute);   frm.add(done);
        frm.add(complete);
        done.setVisible(false);  complete.setVisible(false);
        compute.addActionListener(this);
        done.addActionListener(this);

        complete.addActionListener(this);
        JScrollPane scrollPane = new JScrollPane(jt);
        frm1.add(scrollPane);
        
        // Setup and show GUI
        setupAndShowGUI();
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==compute){
            try {
                // Validate SGPA fields are not empty
                if(sgpa1.getText().trim().isEmpty() || sgpa2.getText().trim().isEmpty() || 
                   sgpa3.getText().trim().isEmpty() || sgpa4.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all SGPA fields","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                float t1 = Float.parseFloat(sgpa1.getText());
                float t2 = Float.parseFloat(sgpa2.getText());
                float t3 = Float.parseFloat(sgpa3.getText());
                float t4 = Float.parseFloat(sgpa4.getText());

                if(t1 < 0 || t1 > 10.0f || t2 < 0 || t2 > 10.0f || t3 < 0 || t3 > 10.0f || t4 < 0 || t4 > 10.0f) {
                    JOptionPane.showMessageDialog(null, "Enter correct SGPA values (0-10)","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                cgpa = (t1 + t2 + t3 + t4) / 4;
                cgp.setText(String.format("%.2f", cgpa));
                done.setVisible(true);
                complete.setVisible(true);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values for SGPA","Error",JOptionPane.ERROR_MESSAGE);
            }
        } else if(ae.getSource()==done) {
            try {
                // Get data from text fields, not labels!
                String n = name.getText().trim();
                String ad = addr.getText().trim();
                String u = usn.getText().trim();
                String c = (String) category.getSelectedItem();
                
                // Validate required fields
                if(n.isEmpty() || ad.isEmpty() || u.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all required fields (Name, Address, USN)","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                if(age.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter age","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                int x = Integer.parseInt(age.getText());
                if(x < 18 || x > 100){
                    JOptionPane.showMessageDialog(null,"Enter correct age (18-100)","Error",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                float t1 = Float.parseFloat(sgpa1.getText());
                float t2 = Float.parseFloat(sgpa2.getText());
                float t3 = Float.parseFloat(sgpa3.getText());
                float t4 = Float.parseFloat(sgpa4.getText());

                Student temp = new Student(n, u, x, ad, t1, t2, t3, t4, c);
                arr.add(temp);
                JOptionPane.showMessageDialog(null, "Student added successfully!","Success",JOptionPane.INFORMATION_MESSAGE);
                
                // Clear fields after adding
                clearFields();
                
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid numeric values","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        else if(ae.getSource()==complete) {
            if(arr.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No students in collection!","Info",JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            jt.setText("");
            for(int i = 0; i < arr.size(); i++) {
                Student stud = arr.get(i);
                jt.append("Student " + (i+1) + ":\n");
                jt.append("Name: " + stud.name + "\n");
                jt.append("USN: " + stud.usn + "\n");
                jt.append("Age: " + stud.age + "\n");
                jt.append("Address: " + stud.address + "\n");
                jt.append("CGPA: " + String.format("%.2f", stud.cgpa) + "\n");
                jt.append("Category: " + stud.category + "\n");
                jt.append("------------------------\n");
            }
            frm1.setVisible(true);
        }
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
        cgp1.setText("CGPA computed:");
        category.setSelectedIndex(0);
        done.setVisible(false);
        complete.setVisible(false);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                Student_Management obj = new Student_Management();
                System.out.println("Student Management Application started successfully!");
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error starting application: " + e.getMessage());
            }
        });
    }
    
    private void setupAndShowGUI() {
        frm.setLayout(new GridLayout(13, 2, 5, 5)); // 13 rows, 2 columns with gaps
        frm.setSize(600, 700);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setLocationRelativeTo(null); // Center the window
        
        frm1.setLayout(new BorderLayout());
        frm1.setSize(600, 400);
        frm1.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frm1.setLocationRelativeTo(null);
        frm1.setVisible(false);
        
        frm.setVisible(true); // Show frame at the end
    }
}
