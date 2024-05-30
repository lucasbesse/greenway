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

import models.Option;
import models.Question;
import models.Quiz;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
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
            if(quizzes.get(i).isDone()) {
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

        JLabel lblNewLabel_2 = new JLabel(quiz.getContent() + numero);
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

        JLabel lblNewLabel_2 = new JLabel(quiz.getContent() + numero);
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
	
	private void openQuiz(Quiz quiz_reference) {
		QuizScreen quiz = new QuizScreen(quiz_reference); // Cria uma nova instância da tela de registro
		quiz.setVisible(true); 
		dispose();
	}
	
	private List<Quiz> dummyQuizes() {
	    // Perguntas e opções para o Quiz 1
	    Question pergunta1Quiz1 = new Question();
	    pergunta1Quiz1.setId(1);
	    pergunta1Quiz1.setDescription("Qual é a capital do Brasil?");
	    Option opcao1Quiz1 = new Option();
	    opcao1Quiz1.setId(1);
	    opcao1Quiz1.setDescription("Brasília");
	    opcao1Quiz1.setType("A");
	    Option opcao2Quiz1 = new Option();
	    opcao2Quiz1.setId(2);
	    opcao2Quiz1.setDescription("Rio de Janeiro");
	    opcao2Quiz1.setType("B");
	    Option opcao3Quiz1 = new Option();
	    opcao3Quiz1.setId(3);
	    opcao3Quiz1.setDescription("São Paulo");
	    opcao3Quiz1.setType("C");
	    pergunta1Quiz1.setOptions(Arrays.asList(opcao1Quiz1, opcao2Quiz1, opcao3Quiz1));

	    Question pergunta2Quiz1 = new Question();
	    pergunta2Quiz1.setId(2);
	    pergunta2Quiz1.setDescription("Qual é a língua oficial do Brasil?");
	    Option opcao1Q2Quiz1 = new Option();
	    opcao1Q2Quiz1.setId(1);
	    opcao1Q2Quiz1.setDescription("Português");
	    opcao1Q2Quiz1.setType("A");
	    Option opcao2Q2Quiz1 = new Option();
	    opcao2Q2Quiz1.setId(2);
	    opcao2Q2Quiz1.setDescription("Espanhol");
	    opcao2Q2Quiz1.setType("B");
	    Option opcao3Q2Quiz1 = new Option();
	    opcao3Q2Quiz1.setId(3);
	    opcao3Q2Quiz1.setDescription("Inglês");
	    opcao3Q2Quiz1.setType("C");
	    pergunta2Quiz1.setOptions(Arrays.asList(opcao1Q2Quiz1, opcao2Q2Quiz1, opcao3Q2Quiz1));

	    // Quiz 1
	    Quiz quiz1 = new Quiz();
	    quiz1.setId(1);
	    quiz1.setContent("Geografia do Brasil");
	    quiz1.setQuestions(Arrays.asList(pergunta1Quiz1, pergunta2Quiz1));
	    quiz1.setResult("Você é um expert em Geografia do Brasil!");
	    quiz1.setDone(false);

	    // Perguntas e opções para o Quiz 2
	    Question pergunta1Quiz2 = new Question();
	    pergunta1Quiz2.setId(3);
	    pergunta1Quiz2.setDescription("Quem escreveu 'Dom Quixote'?");
	    Option opcao1Quiz2 = new Option();
	    opcao1Quiz2.setId(4);
	    opcao1Quiz2.setDescription("Miguel de Cervantes");
	    opcao1Quiz2.setType("A");
	    Option opcao2Quiz2 = new Option();
	    opcao2Quiz2.setId(5);
	    opcao2Quiz2.setDescription("William Shakespeare");
	    opcao2Quiz2.setType("B");
	    Option opcao3Quiz2 = new Option();
	    opcao3Quiz2.setId(6);
	    opcao3Quiz2.setDescription("Gabriel García Márquez");
	    opcao3Quiz2.setType("C");
	    pergunta1Quiz2.setOptions(Arrays.asList(opcao1Quiz2, opcao2Quiz2, opcao3Quiz2));

	    Question pergunta2Quiz2 = new Question();
	    pergunta2Quiz2.setId(4);
	    pergunta2Quiz2.setDescription("Em que ano foi publicada a primeira parte de 'Dom Quixote'?");
	    Option opcao1Q2Quiz2 = new Option();
	    opcao1Q2Quiz2.setId(7);
	    opcao1Q2Quiz2.setDescription("1605");
	    opcao1Q2Quiz2.setType("A");
	    Option opcao2Q2Quiz2 = new Option();
	    opcao2Q2Quiz2.setId(8);
	    opcao2Q2Quiz2.setDescription("1615");
	    opcao2Q2Quiz2.setType("B");
	    Option opcao3Q2Quiz2 = new Option();
	    opcao3Q2Quiz2.setId(9);
	    opcao3Q2Quiz2.setDescription("1620");
	    opcao3Q2Quiz2.setType("C");
	    pergunta2Quiz2.setOptions(Arrays.asList(opcao1Q2Quiz2, opcao2Q2Quiz2, opcao3Q2Quiz2));

	    // Quiz 2
	    Quiz quiz2 = new Quiz();
	    quiz2.setId(2);
	    quiz2.setContent("Literatura Clássica");
	    quiz2.setQuestions(Arrays.asList(pergunta1Quiz2, pergunta2Quiz2));
	    quiz2.setResult("Você é um expert em Literatura Clássica!");
	    quiz2.setDone(true);

	    // Perguntas e opções para o Quiz 3
	    Question pergunta1Quiz3 = new Question();
	    pergunta1Quiz3.setId(5);
	    pergunta1Quiz3.setDescription("Qual é a fórmula química da água?");
	    Option opcao1Quiz3 = new Option();
	    opcao1Quiz3.setId(10);
	    opcao1Quiz3.setDescription("H2O");
	    opcao1Quiz3.setType("A");
	    Option opcao2Quiz3 = new Option();
	    opcao2Quiz3.setId(11);
	    opcao2Quiz3.setDescription("CO2");
	    opcao2Quiz3.setType("B");
	    Option opcao3Quiz3 = new Option();
	    opcao3Quiz3.setId(12);
	    opcao3Quiz3.setDescription("O2");
	    opcao3Quiz3.setType("C");
	    pergunta1Quiz3.setOptions(Arrays.asList(opcao1Quiz3, opcao2Quiz3, opcao3Quiz3));

	    Question pergunta2Quiz3 = new Question();
	    pergunta2Quiz3.setId(6);
	    pergunta2Quiz3.setDescription("Qual é a unidade básica da vida?");
	    Option opcao1Q2Quiz3 = new Option();
	    opcao1Q2Quiz3.setId(13);
	    opcao1Q2Quiz3.setDescription("Célula");
	    opcao1Q2Quiz3.setType("A");
	    Option opcao2Q2Quiz3 = new Option();
	    opcao2Q2Quiz3.setId(14);
	    opcao2Q2Quiz3.setDescription("Átomo");
	    opcao2Q2Quiz3.setType("B");
	    Option opcao3Q2Quiz3 = new Option();
	    opcao3Q2Quiz3.setId(15);
	    opcao3Q2Quiz3.setDescription("Molécula");
	    opcao3Q2Quiz3.setType("C");
	    pergunta2Quiz3.setOptions(Arrays.asList(opcao1Q2Quiz3, opcao2Q2Quiz3, opcao3Q2Quiz3));

	    // Quiz 3
	    Quiz quiz3 = new Quiz();
	    quiz3.setId(3);
	    quiz3.setContent("Ciências Naturais");
	    quiz3.setQuestions(Arrays.asList(pergunta1Quiz3, pergunta2Quiz3));
	    quiz3.setResult("Você é um expert em Ciências Naturais!");
	    quiz3.setDone(false);

	    // Perguntas e opções para o Quiz 4
	    Question pergunta1Quiz4 = new Question();
	    pergunta1Quiz4.setId(7);
	    pergunta1Quiz4.setDescription("Em que ano começou a Segunda Guerra Mundial?");
	    Option opcao1Quiz4 = new Option();
	    opcao1Quiz4.setId(16);
	    opcao1Quiz4.setDescription("1939");
	    opcao1Quiz4.setType("A");
	    Option opcao2Quiz4 = new Option();
	    opcao2Quiz4.setId(17);
	    opcao2Quiz4.setDescription("1941");
	    opcao2Quiz4.setType("B");
	    Option opcao3Quiz4 = new Option();
	    opcao3Quiz4.setId(18);
	    opcao3Quiz4.setDescription("1945");
	    opcao3Quiz4.setType("C");
	    pergunta1Quiz4.setOptions(Arrays.asList(opcao1Quiz4, opcao2Quiz4, opcao3Quiz4));

	    Question pergunta2Quiz4 = new Question();
	    pergunta2Quiz4.setId(8);
	    pergunta2Quiz4.setDescription("Quem foi o primeiro presidente dos Estados Unidos?");
	    Option opcao1Q2Quiz4 = new Option();
	    opcao1Q2Quiz4.setId(19);
	    opcao1Q2Quiz4.setDescription("George Washington");
	    opcao1Q2Quiz4.setType("A");
	    Option opcao2Q2Quiz4 = new Option();
	    opcao2Q2Quiz4.setId(20);
	    opcao2Q2Quiz4.setDescription("Thomas Jefferson");
	    opcao2Q2Quiz4.setType("B");
	    Option opcao3Q2Quiz4 = new Option();
	    opcao3Q2Quiz4.setId(21);
	    opcao3Q2Quiz4.setDescription("Abraham Lincoln");
	    opcao3Q2Quiz4.setType("C");
	    pergunta2Quiz4.setOptions(Arrays.asList(opcao1Q2Quiz4, opcao2Q2Quiz4,opcao3Q2Quiz4));
	    
	    Quiz quiz4 = new Quiz();
	    quiz4.setId(4);
	    quiz4.setContent("História Mundial");
	    quiz4.setQuestions(Arrays.asList(pergunta1Quiz4, pergunta2Quiz4));
	    quiz4.setResult("Você é um expert em História Mundial!");
	    quiz4.setDone(true);

	    // Perguntas e opções para o Quiz 5
	    Question pergunta1Quiz5 = new Question();
	    pergunta1Quiz5.setId(9);
	    pergunta1Quiz5.setDescription("Qual é o maior planeta do Sistema Solar?");
	    Option opcao1Quiz5 = new Option();
	    opcao1Quiz5.setId(22);
	    opcao1Quiz5.setDescription("Júpiter");
	    opcao1Quiz5.setType("A");
	    Option opcao2Quiz5 = new Option();
	    opcao2Quiz5.setId(23);
	    opcao2Quiz5.setDescription("Saturno");
	    opcao2Quiz5.setType("B");
	    Option opcao3Quiz5 = new Option();
	    opcao3Quiz5.setId(24);
	    opcao3Quiz5.setDescription("Netuno");
	    opcao3Quiz5.setType("C");
	    pergunta1Quiz5.setOptions(Arrays.asList(opcao1Quiz5, opcao2Quiz5, opcao3Quiz5));

	    Question pergunta2Quiz5 = new Question();
	    pergunta2Quiz5.setId(10);
	    pergunta2Quiz5.setDescription("Qual é o elemento químico mais abundante no universo?");
	    Option opcao1Q2Quiz5 = new Option();
	    opcao1Q2Quiz5.setId(25);
	    opcao1Q2Quiz5.setDescription("Hidrogênio");
	    opcao1Q2Quiz5.setType("A");
	    Option opcao2Q2Quiz5 = new Option();
	    opcao2Q2Quiz5.setId(26);
	    opcao2Q2Quiz5.setDescription("Oxigênio");
	    opcao2Q2Quiz5.setType("B");
	    Option opcao3Q2Quiz5 = new Option();
	    opcao3Q2Quiz5.setId(27);
	    opcao3Q2Quiz5.setDescription("Carbono");
	    opcao3Q2Quiz5.setType("C");
	    pergunta2Quiz5.setOptions(Arrays.asList(opcao1Q2Quiz5, opcao2Q2Quiz5, opcao3Q2Quiz5));

	    // Quiz 5
	    Quiz quiz5 = new Quiz();
	    quiz5.setId(5);
	    quiz5.setContent("Ciências Astronômicas");
	    quiz5.setQuestions(Arrays.asList(pergunta1Quiz5, pergunta2Quiz5));
	    quiz5.setResult("Você é um expert em Ciências Astronômicas!");
	    quiz5.setDone(false);

	    // Perguntas e opções para o Quiz 6
	    Question pergunta1Quiz6 = new Question();
	    pergunta1Quiz6.setId(11);
	    pergunta1Quiz6.setDescription("Qual é o maior órgão do corpo humano?");
	    Option opcao1Quiz6 = new Option();
	    opcao1Quiz6.setId(28);
	    opcao1Quiz6.setDescription("Pele");
	    opcao1Quiz6.setType("A");
	    Option opcao2Quiz6 = new Option();
	    opcao2Quiz6.setId(29);
	    opcao2Quiz6.setDescription("Fígado");
	    opcao2Quiz6.setType("B");
	    Option opcao3Quiz6 = new Option();
	    opcao3Quiz6.setId(30);
	    opcao3Quiz6.setDescription("Coração");
	    opcao3Quiz6.setType("C");
	    pergunta1Quiz6.setOptions(Arrays.asList(opcao1Quiz6, opcao2Quiz6, opcao3Quiz6));

	    Question pergunta2Quiz6 = new Question();
	    pergunta2Quiz6.setId(12);
	    pergunta2Quiz6.setDescription("Qual é o maior osso do corpo humano?");
	    Option opcao1Q2Quiz6 = new Option();
	    opcao1Q2Quiz6.setId(31);
	    opcao1Q2Quiz6.setDescription("Fêmur");
	    opcao1Q2Quiz6.setType("A");
	    Option opcao2Q2Quiz6 = new Option();
	    opcao2Q2Quiz6.setId(32);
	    opcao2Q2Quiz6.setDescription("Tíbia");
	    opcao2Q2Quiz6.setType("B");
	    Option opcao3Q2Quiz6 = new Option();
	    opcao3Q2Quiz6.setId(33);
	    opcao3Q2Quiz6.setDescription("Fíbula");
	    opcao3Q2Quiz6.setType("C");
	    pergunta2Quiz6.setOptions(Arrays.asList(opcao1Q2Quiz6, opcao2Q2Quiz6, opcao3Q2Quiz6));

	    // Quiz 6
	    Quiz quiz6 = new Quiz();
	    quiz6.setId(6);
	    quiz6.setContent("Anatomia Humana");
	    quiz6.setQuestions(Arrays.asList(pergunta1Quiz6, pergunta2Quiz6));
	    quiz6.setResult("Você é um expert em Anatomia Humana!");
	    quiz6.setDone(true);

	    // Retornando a lista de quizzes
	    return Arrays.asList(quiz1, quiz2, quiz3, quiz4, quiz5, quiz6);
	}

	
	}