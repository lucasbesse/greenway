package screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllers.UserController;
import models.User;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import java.awt.Panel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

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
		setBounds(100, 100, 639, 339);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(104, 10, 416, 19);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(165, 76, 295, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome de usuário:");
		lblNewLabel_1.setBounds(165, 57, 271, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setBounds(165, 111, 271, 13);
		contentPane.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(165, 129, 295, 19);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("Não possui cadastro?");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setBounds(165, 158, 139, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cadastre-se");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_2_1.setBounds(295, 158, 103, 13);
		lblNewLabel_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Define o cursor como de mão
        lblNewLabel_2_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openRegisterScreen(); // Método para abrir a tela de registro
            }
        });
		contentPane.add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.setForeground(new Color(128, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(197, 208, 230, 29);
		contentPane.add(btnNewButton);
		
		errorLabel = new JLabel("Usuário ou senha inválidos.");
		errorLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		errorLabel.setForeground(new Color(128, 64, 0));
		errorLabel.setBounds(207, 247, 221, 13);
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);
		btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	name = textField.getText();
				String password = String.valueOf(passwordField.getPassword());
				authenticate(name, password);
            }
        });
		
	}
	
	private void openRegisterScreen() {
		Register register = new Register(); // Cria uma nova instância da tela de registro
		register.setVisible(true); // Exibe a tela de registro
		dispose(); // Fecha a tela de login
	}
	
	private void authenticate(String name, String password) {
		UserController userController = new UserController();
		User user = userController.authenticate(name, password);
		if (user != null) {
			this.openHomeScreen(user);
			return;
		}
		errorLabel.setVisible(true);
	}
	
	private void openHomeScreen(User user) {
		Home home = new Home(user); 
		home.setVisible(true);
		dispose();
	}
}