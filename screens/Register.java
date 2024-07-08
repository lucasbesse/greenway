package screens;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controllers.UserController;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
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
    public Register() {
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
        JLabel lblNewLabel = new JLabel("Cadastro");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Aumenta o tamanho da fonte
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 20, 10); // Aumenta o espaço acima e abaixo do título
        contentPane.add(lblNewLabel, gbc);

        // Texto Nome de Usuário
        gbc.gridwidth = 2;
        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 10, 5, 10); // Define o espaço entre os componentes
        JLabel lblNewLabel_1 = new JLabel("Nome de usuário:");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 18)); // Aumenta o tamanho da fonte
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_1, gbc);

        // Campo de Texto
        gbc.gridy = 2;
        gbc.ipady = 4; // Aumenta a altura do campo de texto
        textField = new JTextField();
        textField.setFont(new Font("Arial", Font.PLAIN, 18)); // Aumenta o tamanho da fonte
        textField.setColumns(30); // Aumenta a largura do campo de texto
        contentPane.add(textField, gbc);
        gbc.ipady = 0; // Reseta a altura do campo de texto

        // Texto Senha
        gbc.gridy = 3;
        JLabel lblNewLabel_1_1 = new JLabel("Senha:");
        lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 18)); // Aumenta o tamanho da fonte
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel_1_1, gbc);

        // Campo de Senha
        gbc.gridy = 4;
        gbc.ipady = 4; // Aumenta a altura do campo de senha
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18)); // Aumenta o tamanho da fonte
        passwordField.setColumns(30); // Aumenta a largura do campo de senha
        contentPane.add(passwordField, gbc);
        gbc.ipady = 0; // Reseta a altura do campo de senha

        // Botão Cadastrar
        gbc.gridy = 5;
        gbc.insets = new Insets(40, 10, 10, 10); // Aumenta o espaço acima do botão "Cadastrar"
        JButton btnNewButton = new JButton("Cadastrar");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(0, 0, 255));
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 18)); // Aumenta o tamanho da fonte
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                String password = String.valueOf(passwordField.getPassword());
                registerUser(name, password);
            }
        });
        contentPane.add(btnNewButton, gbc);
    }

    private void registerUser(String name, String password) {
        UserController userController = new UserController();
        if (userController.registerUser(name, password)) {
            this.openLoginScreen();
            return;
        }
        // TODO: informar na tela que o nome já existe
    }

    private void openLoginScreen() {
        Login login = new Login();
        login.setVisible(true);
        dispose();
    }
}
