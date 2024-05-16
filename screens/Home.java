package screens;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import models.Pergunta;
import models.Quiz;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

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

	/**
	 * Create the frame.
	 */
	public Home() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 700);
		setResizable(true);
		contentPane = new JPanel();
		contentPane.setToolTipText("true");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lucas G Bessegato");
		lblNewLabel.setBounds(120, 39, 262, 34);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		Font font_1 = new Font(lblNewLabel.getFont().getName(), Font.PLAIN, 18);
        lblNewLabel.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JLabel divLike = new JLabel("3 Quizes finalizados", SwingConstants.CENTER);
        divLike.setBounds(592, 44, 200, 30); // Ajuste as coordenadas e o tamanho conforme necessário
        divLike.setBackground(Color.BLUE); // Define a cor de fundo como azul
        divLike.setForeground(Color.WHITE); // Define a cor do texto como branco
        divLike.setOpaque(true); // Necessário para tornar o fundo visível
        divLike.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // Borda opcional
        contentPane.add(divLike);
        
        JLabel divLike_1 = new JLabel("3 Quizes pendentes", SwingConstants.CENTER);
        divLike_1.setOpaque(true);
        divLike_1.setForeground(Color.WHITE);
        divLike_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        divLike_1.setBackground(Color.RED);
        divLike_1.setBounds(363, 44, 200, 30);
        contentPane.add(divLike_1);
        
        List<Quiz> quizzes = dummyQuizes();
        List<Quiz> quizzesRealizados = new ArrayList<Quiz>();
        List<Quiz> quizzesPendentes = new ArrayList<Quiz>();
        
        for (int i = 0; i < quizzes.size(); i++) {
            if(quizzes.get(i).isConcluido()) {
            	quizzesRealizados.add(quizzes.get(i));
            }
            else {
            	quizzesPendentes.add(quizzes.get(i));
            }
        }
        
        JLabel lblNewLabel_2 = new JLabel("Realizados:");
        lblNewLabel_2.setBounds(45, 122, 138, 13);
        Font font_3 = new Font(lblNewLabel_2.getFont().getName(), Font.PLAIN, 16);
        lblNewLabel_2.setFont(font_3);
        contentPane.add(lblNewLabel_2);
        
        for(int i = 0; i < quizzesRealizados.size(); i++) {
        	criarPainelQuizRealizado(i, quizzesRealizados.get(i));
        }
        
        JLabel lblNewLabel_1 = new JLabel("Pendentes:");
        lblNewLabel_1.setBounds(45, 382, 138, 13);
        Font font_2 = new Font(lblNewLabel_1.getFont().getName(), Font.PLAIN, 16);
        lblNewLabel_1.setFont(font_2);
        contentPane.add(lblNewLabel_1);
        
        for(int i = 0; i < quizzesPendentes.size(); i++) {
        	criarPainelQuizPendente(i, quizzesPendentes.get(i));
        }
        
        
        
	}
	
	private void criarPainelQuizRealizado(int numero, Quiz quiz) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setForeground(new Color(255, 255, 255));

        // Define a posição e tamanho do painel com base no número
        int x = 345 + ((numero - 1) % 3) * 307;
        int y = 420 + ((numero - 1) / 3) * 260;
        panel.setBounds(x, y, 267, 158);
        panel.setBackground(new Color(198, 198, 255));
        contentPane.add(panel);

        JButton btnNewButton = new JButton("Ver resultado");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(243, 243, 255));
        btnNewButton.setBounds(38, 122, 192, 26);
        panel.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel(quiz.getConteudo() + numero);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_2.setBounds(10, 10, 247, 13);
        panel.add(lblNewLabel_2);

        JTextArea textArea = new JTextArea("is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled");
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
        textArea.setWrapStyleWord(true); // Quebra apenas em espaços
        textArea.setBounds(22, 33, 220, 79);
        textArea.setEditable(false); // Impede que o usuário edite o texto
        textArea.setBackground(new Color(198, 198, 255));
        panel.add(textArea);   
        
    }
	
	private void criarPainelQuizPendente(int numero, Quiz quiz) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setForeground(new Color(255, 255, 255));

        // Define a posição e tamanho do painel com base no número
        int x = 345 + ((numero - 1) % 3) * 307;
        int y = 157 + ((numero - 1) / 3) * 260;
        panel.setBounds(x, y, 267, 158);
        panel.setBackground(new Color(198, 198, 255));
        contentPane.add(panel);

        JButton btnNewButton = new JButton("Ver resultado");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setBackground(new Color(243, 243, 255));
        btnNewButton.setBounds(38, 122, 192, 26);
        panel.add(btnNewButton);

        JLabel lblNewLabel_2 = new JLabel(quiz.getConteudo() + numero);
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
        lblNewLabel_2.setBounds(10, 10, 247, 13);
        panel.add(lblNewLabel_2);

        JTextArea textArea = new JTextArea("is simply dummy text of the printing and typesetting industry. " +
                "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, " +
                "when an unknown printer took a galley of type and scrambled");
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
        textArea.setWrapStyleWord(true); // Quebra apenas em espaços
        textArea.setBounds(22, 33, 220, 79);
        textArea.setEditable(false); // Impede que o usuário edite o texto
        textArea.setBackground(new Color(198, 198, 255));
        panel.add(textArea);
    }
	
	private List<Quiz> dummyQuizes() {
		Pergunta pergunta1 = new Pergunta();
        pergunta1.setId(1);
        pergunta1.setDescricao("Qual é a capital do Brasil?");

        Pergunta pergunta2 = new Pergunta();
        pergunta2.setId(2);
        pergunta2.setDescricao("Quem escreveu 'Dom Quixote'?");

        // Criando instâncias de Quiz
        Quiz quiz1 = new Quiz();
        quiz1.setId(1);
        quiz1.setConteudo("Geografia e Literatura");
        quiz1.setPerguntas(new ArrayList<>());
        quiz1.getPerguntas().add(pergunta1);
        quiz1.getPerguntas().add(pergunta2);
        quiz1.setResultado("Você é um expert em Geografia e Literatura!");
        quiz1.setConcluido(false);

        Quiz quiz2 = new Quiz();
        quiz2.setId(2);
        quiz2.setConteudo("Matemática");
        quiz2.setPerguntas(new ArrayList<>());
        quiz2.setResultado("Você é um gênio da Matemática!");
        quiz2.setConcluido(true);

        Quiz quiz3 = new Quiz();
        quiz3.setId(3);
        quiz3.setConteudo("História");
        quiz3.setPerguntas(new ArrayList<>());
        quiz3.setResultado("Você é um mestre da História!");
        quiz3.setConcluido(false);

        Quiz quiz4 = new Quiz();
        quiz4.setId(4);
        quiz4.setConteudo("Ciências");
        quiz4.setPerguntas(new ArrayList<>());
        quiz4.setResultado("Você é um cientista talentoso!");
        quiz4.setConcluido(true);

        Quiz quiz5 = new Quiz();
        quiz5.setId(5);
        quiz5.setConteudo("Artes");
        quiz5.setPerguntas(new ArrayList<>());
        quiz5.setResultado("Você é um artista de coração!");
        quiz5.setConcluido(false);

        Quiz quiz6 = new Quiz();
        quiz6.setId(6);
        quiz6.setConteudo("Esportes");
        quiz6.setPerguntas(new ArrayList<>());
        quiz6.setResultado("Você é um campeão dos esportes!");
        quiz6.setConcluido(true);

        // Criando o ArrayList com os quizzes
        List<Quiz> quizzes = new ArrayList<>();
        quizzes.add(quiz1);
        quizzes.add(quiz2);
        quizzes.add(quiz3);
        quizzes.add(quiz4);
        quizzes.add(quiz5);
        quizzes.add(quiz6);
        
        return quizzes;
	}
}