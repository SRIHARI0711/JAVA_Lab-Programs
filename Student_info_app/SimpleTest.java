package Student_info_app;
import javax.swing.*;
import java.awt.*;

public class SimpleTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Test");
            frame.setLayout(new GridLayout(3, 2));
            frame.add(new JLabel("Name:"));
            frame.add(new JTextField(20));
            frame.add(new JLabel("Age:"));
            frame.add(new JTextField(20));
            frame.add(new JButton("Test"));
            frame.add(new JButton("Test2"));
            
            frame.setSize(400, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            
            System.out.println("Simple test GUI created successfully!");
        });
    }
}