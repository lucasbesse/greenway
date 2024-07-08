package screens;

import javax.swing.*;

import models.User;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcome extends JFrame {

    public welcome() {
        // Configurar a janela principal
        setTitle("Greenway");
        setSize(1100, 650); // Aumentar o tamanho da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centralizar na tela
        setResizable(false);

        // Criar painel principal com GridBagLayout para posicionar componentes
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(new Color(235, 235, 235)); // Cor de fundo verde

        // Painel para o centro (conteúdo principal)
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(new Color(235, 235, 235)); // Cor de fundo verde
        centerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionar título
        JLabel titleLabel = new JLabel("Greenway");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 36)); // Usar fonte Arial
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Carregar e redimensionar a imagem
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/green-logo-2.png"));
        Image image = originalIcon.getImage(); // Transformar em Image
        Image resizedImage = image.getScaledInstance(340, 340, java.awt.Image.SCALE_AREA_AVERAGING); // Redimensionar a imagem
        ImageIcon resizedIcon = new ImageIcon(resizedImage); // Transformar de volta em ImageIcon

        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Adicionar subtítulo
        JLabel subtitleLabel = new JLabel("Avalie seus hábitos e práticas com relação ao meio ambiente!");
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 18)); // Usar fonte Arial
        subtitleLabel.setForeground(Color.BLACK);
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Criar botão para começar
        JButton startButton = new JButton("Começar");
        startButton.setFont(new Font("Arial", Font.PLAIN, 16));
        startButton.setFocusPainted(false);
        startButton.setBackground(new Color(3, 148, 3)); // Cor de fundo personalizada
        startButton.setForeground(new Color(255, 255, 255)); // Texto branco
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        startButton.addActionListener(e -> {
        	openLogin();
        });

        // Definir tamanho preferido para aumentar o botão
        Dimension buttonSize = new Dimension(350, 40);
        startButton.setPreferredSize(buttonSize);
        startButton.setMaximumSize(buttonSize);
        startButton.setMinimumSize(buttonSize);

        // Adicionar componentes ao painel central
        centerPanel.add(Box.createVerticalStrut(20)); // Espaçamento superior
        centerPanel.add(titleLabel);
        centerPanel.add(Box.createVerticalStrut(20)); // Espaçamento entre título e imagem
        centerPanel.add(imageLabel);
        centerPanel.add(Box.createVerticalStrut(20)); // Espaçamento entre imagem e subtítulo
        centerPanel.add(subtitleLabel);
        centerPanel.add(Box.createVerticalStrut(40)); // Espaçamento entre subtítulo e botão aumentado
        centerPanel.add(startButton);

        // Configurar constraints para o layout do GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        // Adicionar painel central ao painel principal com GridBagLayout
        mainPanel.add(centerPanel, gbc);

        // Adicionar painel principal à janela
        add(mainPanel);
    }
    
    private void openLogin() {
    	Login login = new Login();
    	login.setVisible(true);
		dispose();
	}

    // Método para criar um JLabel com uma imagem de folha verde redimensionada
    private JLabel createLeafLabel(String imagePath) {
        ImageIcon leafIcon = new ImageIcon(getClass().getResource(imagePath));
        Image leafImage = leafIcon.getImage(); // Transformar em Image
        Image resizedLeafImage = leafImage.getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Redimensionar a imagem
        ImageIcon resizedLeafIcon = new ImageIcon(resizedLeafImage); // Transformar de volta em ImageIcon
        JLabel leafLabel = new JLabel(resizedLeafIcon);
        return leafLabel;
    }

    public static void main(String[] args) {
        // Criar e exibir a tela inicial
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new welcome().setVisible(true);
            }
        });
    }
}
