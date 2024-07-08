package screens;

import javax.swing.*;

import controllers.QuizController;
import controllers.UserController;
import dao.UserDAO;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import models.Quiz;
import models.User; // Importe corretamente models.User

public class AdminScreen extends JFrame {
	public User user;

    public AdminScreen(List<User> users) {
        setTitle("Administração - Greenway");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(235, 235, 235));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(30, 10, 0, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Para o título ocupar a largura total das 4 colunas
        gbc.anchor = GridBagConstraints.NORTH; // Alinha o título ao topo

        JLabel titleLabel = new JLabel("Greenway - Administração");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, gbc);

        // Resetar as constraints para os cards
        gbc.gridwidth = 1;
        gbc.gridy = 1; // Começa na linha seguinte ao título
        gbc.anchor = GridBagConstraints.CENTER;

        int columns = 4;

        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            JPanel userCard = createUserCard(user);
            mainPanel.add(userCard, gbc);

            gbc.gridx++;
            if ((i + 1) % columns == 0) {
                gbc.gridx = 0;
                gbc.gridy++;
            }
        }

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        add(scrollPane);
    }

    private JPanel createUserCard(User user) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(250, 150));
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(user.getName());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel quizCountLabel = new JLabel("5" + " Quizzes realizados");
        quizCountLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        quizCountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton dashboardButton = new JButton("Acessar Dashboard");
        dashboardButton.setFont(new Font("Arial", Font.PLAIN, 14));
        dashboardButton.setFocusPainted(false);
        dashboardButton.setForeground(new Color(255, 255, 255));
        dashboardButton.setBackground(new Color(79, 79, 255));
        dashboardButton.setForeground(Color.WHITE);
        dashboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        dashboardButton.addActionListener(e -> {
        	loginAsUser(user.getName(), "senha_do_usuario");
        });

        card.add(Box.createVerticalStrut(20));
        card.add(nameLabel);
        card.add(Box.createVerticalStrut(20));
        card.add(quizCountLabel);
        card.add(Box.createVerticalGlue()); // Adiciona espaço flexível
        card.add(dashboardButton);
        card.add(Box.createVerticalStrut(10)); // Adiciona um pouco de espaço abaixo do botão

        return card;
    }

    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getAllUsers(); // Obtém a lista de usuários do DAO

        SwingUtilities.invokeLater(() -> {
            new AdminScreen(users).setVisible(true);
        });
    }
    
    private void loginAsUser(String name, String adminPassword) {
        // Realiza a autenticação do usuário
        UserDAO userDAO = new UserDAO();
        String userPassword = userDAO.getPassword(name);
        
        if (userPassword != null) {
            UserController userController = new UserController();
            User user = userController.authenticate(name, userPassword);
            
            if (user != null) {
                // Se o login for bem-sucedido, abrir a tela principal e remover a mensagem
                this.openHomeScreen(user);
                // Fecha a mensagem inicial após abrir a tela principal
                JOptionPane.getRootFrame().dispose(); 
            } else {
                // Exibe mensagem de falha de login
                JOptionPane.showMessageDialog(this, "Falha ao realizar login. Usuário ou senha inválidos.");
            }
        } else {
            // Exibe mensagem de usuário não encontrado ou senha não definida
            JOptionPane.showMessageDialog(this, "Usuário não encontrado ou senha não definida.");
        }
    }

    private void openHomeScreen(User user) {
		Home home = new Home(user); 
		home.setVisible(true);
		dispose();
	}
    
    private int getAnsweredQuizzesSize(String name) {
    	QuizController quizController = new QuizController();
    	ArrayList<Quiz> quizzes = quizController.getAnsweredQuizzes(name);
    	return quizzes.size();
    }
}
