package screens;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controllers.QuizController;
import controllers.UserController;
import dao.UserDAO;
import models.User;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    public String name;
    private JLabel errorLabel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600); // Aumenta o tamanho da janela
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Título
        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        contentPane.add(lblNewLabel, gbc);

        // Texto Nome de Usuário
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        gbc.gridx = 0;
        JLabel lblNewLabel_1 = new JLabel("Nome de usuário:");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18)); // Aumenta o tamanho da fonte
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_1, gbc);

        // Campo de Texto
        gbc.gridy = 2;
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 18)); // Aumenta o tamanho da fonte
        textField.setColumns(30);
        contentPane.add(textField, gbc);

        // Texto Senha
        gbc.gridy = 3;
        JLabel lblNewLabel_1_1 = new JLabel("Senha:");
        lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 18)); // Aumenta o tamanho da fonte
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_1_1, gbc);

        // Campo de Senha
        gbc.gridy = 4;
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18)); // Aumenta o tamanho da fonte
        contentPane.add(passwordField, gbc);

        // Texto para cadastro
        gbc.gridy = 5;
        JLabel lblNewLabel_2 = new JLabel("Não possui cadastro?");
        lblNewLabel_2.setForeground(new Color(128, 128, 128));
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16)); // Aumenta o tamanho da fonte
        contentPane.add(lblNewLabel_2, gbc);

        // Link para cadastro
        gbc.gridy = 6;
        JLabel lblNewLabel_2_1 = new JLabel("Cadastre-se");
        lblNewLabel_2_1.setForeground(new Color(0, 0, 255));
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 16)); // Aumenta o tamanho da fonte
        lblNewLabel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        lblNewLabel_2_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openRegisterScreen();
            }
        });
        contentPane.add(lblNewLabel_2_1, gbc);

        // Botão Entrar
        gbc.gridy = 7;
        JButton btnNewButton = new JButton("Entrar");
        btnNewButton.setForeground(new Color(255, 255, 255));
        gbc.insets = new Insets(40, 10, 10, 10);
        btnNewButton.setBackground(new Color(0, 0, 255));
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 18)); // Aumenta o tamanho da fonte
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                name = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                authenticate(name, password);
            }
        });
        contentPane.add(btnNewButton, gbc);

        // Mensagem de erro
        gbc.gridy = 8;
        errorLabel = new JLabel("Usuário ou senha inválidos.");
        errorLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Aumenta o tamanho da fonte
        errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        errorLabel.setForeground(new Color(255, 0, 0));
        errorLabel.setVisible(false);
        contentPane.add(errorLabel, gbc);
    }

    private void openRegisterScreen() {
        Register register = new Register();
        register.setVisible(true);
        dispose();
    }

    private void authenticate(String name, String password) {
        if (name.equals("admin") && password.equals("123")) {
            openAdminScreen();
        } else {
            UserController userController = new UserController();
            User user = userController.authenticate(name, password);
            if (user != null) {
                openHomeScreen(user);
            } else {
                errorLabel.setVisible(true);
            }
        }
    }

    private void openAdminScreen() {
    	UserController userController = new UserController();
        List<User> users = userController.getAllUsers();
        QuizController quizController = new QuizController();
        Map<String, Integer> userQuizCounts = quizController.getAllUserQuizCounts();

        AdminScreen adminScreen = new AdminScreen(users, userQuizCounts);
        adminScreen.setVisible(true);
        dispose();
    }

    private void openHomeScreen(User user) {
        Home home = new Home(user);
        home.setVisible(true);
        dispose();
    }
}
