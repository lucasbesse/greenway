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
import java.util.Iterator;

import controllers.QuizController;
import models.User;
import models.DummyQuizes;
import models.Quiz;
import javax.swing.*;

public class Home extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public User user;
    private ArrayList<Quiz> quizzesPendentes;
    private ArrayList<Quiz> quizzesRealizados;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Home frame = new Home(new User());
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    List<String> lista = new ArrayList<>();

    public Home(User user) {
    	this.user = user;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1497, 700);
        setResizable(true);
        contentPane = new JPanel();
        contentPane.setToolTipText("true");
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(245, 245, 255));

        JLabel lblNewLabel = new JLabel(this.user.getName());
        lblNewLabel.setBounds(80, 39, 210, 34);
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        Font font_1 = new Font(lblNewLabel.getFont().getName(), Font.PLAIN, 18);
        lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 19));
        contentPane.add(lblNewLabel);
        
        this.refreshData();
        this.refreshContent();
    }
    
    public void refreshData() {
    	this.quizzesRealizados = new ArrayList<Quiz>();
    	this.quizzesPendentes = new ArrayList<Quiz>();
        
        quizzesPendentes.add(DummyQuizes.createQuiz(1));
        quizzesPendentes.add(DummyQuizes.createQuiz(2));
        quizzesPendentes.add(DummyQuizes.createQuiz(3));
        quizzesPendentes.add(DummyQuizes.createQuiz(4));
        quizzesPendentes.add(DummyQuizes.createQuiz(5));
        // Adicione outros quizzes conforme necessário

        // consulta quizzes ja realizados pelo usuario
        quizzesRealizados = this.getAnsweredQuizzes();
        
        // filtra os pendentes cadastrados no sistema, com os ja realizados pelo usuario
        quizzesPendentes = this.filterPendingQuizzes(quizzesPendentes, quizzesRealizados);
        
        // Verificar o estado dos quizzes adicionados
        for (Quiz quiz : quizzesPendentes) {
            System.out.println("Quiz ID: " + quiz.getId() + ", Done: " + quiz.isDone());
        }
        for (Quiz quiz : quizzesRealizados) {
            System.out.println("Quiz ID: " + quiz.getId() + ", Done: " + quiz.isDone());
        }
    }
    
    public void refreshContent() {
        JLabel divLike = new JLabel(this.quizzesRealizados.size() + " Quizes finalizados", SwingConstants.CENTER);
        divLike.setBounds(510, 44, 200, 30);
        divLike.setBackground(Color.BLUE); // Define a cor de fundo como azul
        divLike.setForeground(Color.WHITE); // Define a cor do texto como branco
        divLike.setOpaque(true); // Necessário para tornar o fundo visível
        divLike.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borda opcional
        contentPane.add(divLike);

        JLabel divLike_1 = new JLabel(this.quizzesPendentes.size() + " Quizes pendentes", SwingConstants.CENTER);
        divLike_1.setOpaque(true);
        divLike_1.setForeground(Color.WHITE);
        divLike_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        divLike_1.setBackground(Color.RED);
        divLike_1.setBounds(290, 44, 200, 30);
        contentPane.add(divLike_1);
    	
    	JLabel lblNewLabel_2 = new JLabel("Pendentes:");
    	lblNewLabel_2.setBounds(45, 122, 138, 13);
    	Font font_3 = new Font(lblNewLabel_2.getFont().getName(), Font.PLAIN, 18);
    	lblNewLabel_2.setFont(font_3);
    	contentPane.add(lblNewLabel_2);

    	for (int i = 0; i < this.quizzesPendentes.size(); i++) {
    		criarPainelQuizPendente(i, this.quizzesPendentes.get(i));
    	}
    	
    	JLabel lblNewLabel_1 = new JLabel("Realizados:");
    	lblNewLabel_1.setBounds(45, 382, 138, 13);
    	Font font_2 = new Font(lblNewLabel_1.getFont().getName(), Font.PLAIN, 18);
    	lblNewLabel_1.setFont(font_2);
    	contentPane.add(lblNewLabel_1);
    	
    	for (int i = 0; i < this.quizzesRealizados.size(); i++) {
    		criarPainelQuizRealizado(i, this.quizzesRealizados.get(i));
    	}
    }

    private void criarPainelQuizRealizado(int numero, Quiz quiz) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setForeground(new Color(255, 255, 255));
        
        int colunas = 5; // Número de colunas desejado
        int larguraPainel = 267; // Largura do painel
        int alturaPainel = 190; // Altura do painel
        int margemX = 25; // Margem horizontal entre os painéis
        int margemY = 20; // Margem vertical entre os painéis
        int y = margemY + (numero / colunas) * (alturaPainel + margemY) + 400;
        
        int x = margemX + (numero % colunas) * (larguraPainel + margemX);

        panel.setBounds(x, y, larguraPainel, alturaPainel);
        panel.setBackground(new Color(205, 205, 252));
        contentPane.add(panel);
        
        JButton btnRemakeTest = new JButton("Refazer Teste");
        btnRemakeTest.setForeground(new Color(0, 0, 0));
        btnRemakeTest.setBackground(new Color(243, 243, 255));
        btnRemakeTest.setBounds(38, 122, 192, 26);
        btnRemakeTest.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // Define o cursor como de mão
        btnRemakeTest.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remakeTest(quiz.getId());
            }
        });
        panel.add(btnRemakeTest);

        JButton btnNewButton = new JButton("Ver Resultado");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(243, 243, 255));
        btnNewButton.setBounds(38, 152, 192, 26);
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
        textArea.setBackground(new Color(205, 205, 252));
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
        panel.setBackground(new Color(180, 180, 254));
        contentPane.add(panel);

        JButton btnNewButton = new JButton("Iniciar Quiz");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(79, 79, 255));
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
        textArea.setBackground(new Color(180, 180, 254));
        panel.add(textArea);
    }

    private void openQuiz(Quiz quiz_reference) {
        QuizScreen quiz = new QuizScreen(quiz_reference, this.user); // Cria uma nova instância da tela de registro
        quiz.setVisible(true); 
        dispose();
    }
    
    private ArrayList<Quiz> getAnsweredQuizzes() {
    	QuizController quizController = new QuizController();
    	ArrayList<Quiz> quizzes = quizController.getAnsweredQuizzes(this.user.getName());
    	return quizzes;
    }
    
    private void remakeTest(int quizId) {
    	QuizController quizController = new QuizController();
    	quizController.deleteResultForRemake(quizId, this.user.getName());
    	
    	Quiz newQuiz = DummyQuizes.createQuiz(quizId);
    	QuizScreen quizScreen = new QuizScreen(newQuiz, this.user); // Cria uma nova instância da tela de registro
    	quizScreen.setVisible(true); 
        dispose();
    }
    
    private ArrayList<Quiz> filterPendingQuizzes(ArrayList<Quiz> pendingQuizzes, ArrayList<Quiz> answeredQuizzes) {
    	ArrayList<Quiz> newPengindQuizzes = new ArrayList<Quiz>();
    	
    	for (Quiz pendingQuiz : pendingQuizzes) {
    		boolean quizIsDone = false;
    		for (Quiz answeredQuiz : answeredQuizzes) {
        		if (answeredQuiz.getId() == pendingQuiz.getId()) {
        			quizIsDone = true;
        			answeredQuiz.setContent(pendingQuiz.getContent());
        			answeredQuiz.setResume(pendingQuiz.getResume());
        			
        			switch (answeredQuiz.getResult()) {
	        			case "A": 
	        				answeredQuiz.setResultTextA(pendingQuiz.getResultText("A"));
	        				break;
	        			case "B": 
	        				answeredQuiz.setResultTextB(pendingQuiz.getResultText("B"));
	        				break;
	        			case "C": 
	        				answeredQuiz.setResultTextC(pendingQuiz.getResultText("C"));
	        				break;
        			}
        			
        			break;
        		}
        	}
    		
    		if (!quizIsDone) {
        		newPengindQuizzes.add(pendingQuiz);
    		}
    	}
    	
    	return newPengindQuizzes;
    }
}
