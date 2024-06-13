package screens;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.DummyQuizes;
import models.Quiz;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    List<String> lista = new ArrayList<>();

    public Home() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1497, 700);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setToolTipText("true");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        List<Quiz> quizzesRealizados = new ArrayList<Quiz>();
        List<Quiz> quizzesPendentes = new ArrayList<Quiz>();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Lucas G Bessegato");
        lblNewLabel.setBounds(120, 39, 262, 34);
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        Font font_1 = new Font(lblNewLabel.getFont().getName(), Font.PLAIN, 18);
        lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
        contentPane.add(lblNewLabel);

        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(DummyQuizes.createQuiz(1));
        quizzes.add(DummyQuizes.createQuiz(2));
        quizzes.add(DummyQuizes.createQuiz(3));
        quizzes.add(DummyQuizes.createQuiz(4));
        quizzes.add(DummyQuizes.createQuiz(5));
        // Adicione outros quizzes conforme necessário

        // Verificar o estado dos quizzes adicionados
        for (Quiz quiz : quizzes) {
            System.out.println("Quiz ID: " + quiz.getId() + ", Done: " + quiz.isDone());
        }

        for (Quiz quiz : quizzes) {
            if (quiz.isDone()) {
                quizzesRealizados.add(quiz);
            } else {
                quizzesPendentes.add(quiz);
            }
        }
        
        JLabel divLike = new JLabel(quizzesRealizados.size() + " Quizes finalizados", SwingConstants.CENTER);
        divLike.setBounds(592, 44, 200, 30); // Ajuste as coordenadas e o tamanho conforme necessário
        divLike.setBackground(Color.BLUE); // Define a cor de fundo como azul
        divLike.setForeground(Color.WHITE); // Define a cor do texto como branco
        divLike.setOpaque(true); // Necessário para tornar o fundo visível
        divLike.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borda opcional
        contentPane.add(divLike);

        JLabel divLike_1 = new JLabel(quizzesPendentes.size() + " Quizes pendentes", SwingConstants.CENTER);
        divLike_1.setOpaque(true);
        divLike_1.setForeground(Color.WHITE);
        divLike_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        divLike_1.setBackground(Color.RED);
        divLike_1.setBounds(363, 44, 200, 30);
        contentPane.add(divLike_1);

        JLabel lblNewLabel_2 = new JLabel("Pendentes:");
        lblNewLabel_2.setBounds(45, 122, 138, 13);
        Font font_3 = new Font(lblNewLabel_2.getFont().getName(), Font.PLAIN, 16);
        lblNewLabel_2.setFont(font_3);
        contentPane.add(lblNewLabel_2);

        for (int i = 0; i < quizzesRealizados.size(); i++) {
            criarPainelQuizRealizado(i, quizzesRealizados.get(i));
        }

        JLabel lblNewLabel_1 = new JLabel("Realizados:");
        lblNewLabel_1.setBounds(45, 382, 138, 13);
        Font font_2 = new Font(lblNewLabel_1.getFont().getName(), Font.PLAIN, 16);
        lblNewLabel_1.setFont(font_2);
        contentPane.add(lblNewLabel_1);

        for (int i = 0; i < quizzesPendentes.size(); i++) {
        	System.out.println(i);
            criarPainelQuizPendente(i, quizzesPendentes.get(i));
        }
    }

    private void criarPainelQuizRealizado(int numero, Quiz quiz) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setForeground(new Color(255, 255, 255));
        
        int colunas = 5; // Número de colunas desejado
        int larguraPainel = 267; // Largura do painel
        int alturaPainel = 158; // Altura do painel
        int margemX = 25; // Margem horizontal entre os painéis
        int margemY = 20; // Margem vertical entre os painéis
        int y = margemY + (numero / colunas) * (alturaPainel + margemY) + 400;
        
        int x = margemX + (numero % colunas) * (larguraPainel + margemX);

        panel.setBounds(x, y, 267, 158);
        panel.setBackground(new Color(198, 198, 255));
        contentPane.add(panel);

        JButton btnNewButton = new JButton("Ver Resultado");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(243, 243, 255));
        btnNewButton.setBounds(38, 122, 192, 26);
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Define o cursor como de mão
        btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openQuiz(quiz);
            }
        });
        panel.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel(quiz.getContent());
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_2.setBounds(10, 10, 247, 20);
        panel.add(lblNewLabel_2);

        JTextArea textArea = new JTextArea(quiz.getResume());
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));
        textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
        textArea.setWrapStyleWord(true); // Quebra apenas em espaços
        textArea.setBounds(22, 40, 240, 79);
        textArea.setEditable(false); // Impede que o usuário edite o texto
        textArea.setBackground(new Color(198, 198, 255));
        panel.add(textArea);
    }

    private void criarPainelQuizPendente(int numero, Quiz quiz) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setForeground(new Color(255, 255, 255));
        
        int colunas = 5; // Número de colunas desejado
        int larguraPainel = 267; // Largura do painel
        int alturaPainel = 158; // Altura do painel
        int margemX = 25; // Margem horizontal entre os painéis
        int margemY = 20; // Margem vertical entre os painéis
        int y = margemY + (numero / colunas) * (alturaPainel + margemY) + 140;
        
        int x = margemX + (numero % colunas) * (larguraPainel + margemX);

        panel.setBounds(x, y, 267, 158);
        panel.setBackground(new Color(198, 198, 255));
        contentPane.add(panel);

        JButton btnNewButton = new JButton("Iniciar Quiz");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(243, 243, 255));
        btnNewButton.setBounds(38, 122, 192, 26);
        btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Define o cursor como de mão
        btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openQuiz(quiz);
            }
        });
        panel.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel(quiz.getContent());
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
        lblNewLabel_2.setBounds(10, 10, 247, 20);
        panel.add(lblNewLabel_2);

        JTextArea textArea = new JTextArea(quiz.getResume());
        textArea.setFont(new Font("Arial", Font.PLAIN, 12));
        textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
        textArea.setWrapStyleWord(true); // Quebra apenas em espaços
        textArea.setBounds(22, 40, 240, 79);
        textArea.setEditable(false); // Impede que o usuário edite o texto
        textArea.setBackground(new Color(198, 198, 255));
        panel.add(textArea);
    }

    private void openQuiz(Quiz quiz_reference) {
        QuizScreen quiz = new QuizScreen(quiz_reference); // Cria uma nova instância da tela de registro
        quiz.setVisible(true); 
        dispose();
    }
}
