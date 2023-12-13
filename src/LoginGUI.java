import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 */
public class LoginGUI extends JFrame {
    private JTextField netIDField; // Changed: Field for Net ID
    private JPasswordField passwordField;

    public LoginGUI() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel netIDLabel = new JLabel("Net ID:"); // Changed: Label for Net ID
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(netIDLabel, gbc);

        netIDField = new JTextField(15); // Changed: Field for Net ID
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(netIDField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredNetID = netIDField.getText(); // Changed: Get Net ID
                char[] enteredPasswordChars = passwordField.getPassword();
                String enteredPassword = new String(enteredPasswordChars);

                boolean loginSuccess = false;
                String role = "";

                try (BufferedReader br = new BufferedReader(new FileReader("./credentials/cred.txt"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] parts = line.split(",\\s*");
                        if (parts.length == 3) {
                            String netID = parts[0]; // Changed: Read Net ID from file
                            String password = parts[1];
                            String userRole = parts[2];

                            if (enteredNetID.equals(netID) && enteredPassword.equals(password)) {
                                loginSuccess = true;
                                role = userRole;
                                break;
                            }
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

                if (loginSuccess) {
                    if ("Student".equals(role)) { // Changed: Use .equals for string comparison
                        StudentGUI s = new StudentGUI();
		                IDSetter.get().setStudentID(enteredNetID);
                        s.setVisible(true);
                        dispose();
                    } else if ("Teacher".equals(role)) { // Changed: Use .equals for string comparison
                        TeacherGUI tg = new TeacherGUI();
                        tg.setVisible(true);
                        dispose();
                    } else if ("Grader".equals(role)) { // Changed: Use .equals for string comparison
                        GraderGUI gg = new GraderGUI();
                        gg.setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed! Invalid credentials.");
                }

                // Clear fields after login attempt
                netIDField.setText("");
                passwordField.setText("");
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI();
            }
        });
    }
}
