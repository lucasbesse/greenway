package screens;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Option;
import models.Question;
import models.Quiz;
import models.User;

import controllers.QuizController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class QuizScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Quiz current_quiz;
    private Home home;
    private int current_question = 0;
    private ButtonGroup group; // Declaração do ButtonGroup a nível de classe
    private Map<JRadioButton, Option> radioButtonOptionMap; // Mapa para associar JRadioButton a Option
    public int typeA_count = 0;
    public int typeB_count = 0;
    public int typeC_count = 0;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Quiz quiz = new Quiz();
                    User user = new User();
                    Home home = new Home(user);
                    QuizScreen frame = new QuizScreen(quiz, home);
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
    public QuizScreen(Quiz quiz, Home home) {
        this.current_quiz = quiz;
        this.home = home;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1067, 634);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(new Color(235, 235, 255));
        
        JLabel lblNewLabel = new JLabel(this.current_quiz.getContent());
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(57, 45, 938, 28);
        contentPane.add(lblNewLabel);
        
        if (quiz.isDone()) {
        	System.out.println("is done Quiz ID: " + quiz.getId() + ", Done: " + quiz.isDone() + ", Result: " + quiz.getResult());
        	this.getFinishSection(quiz.getResult());
        } else {        	
        	List<Question> Questions = this.current_quiz.getQuestions();
        	
        	createQuestion(Questions.get(this.current_question));
        }
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                home.refreshData();
                home.refreshContent();
            }
        });
    }
    
    private void createQuestion(Question Question) {
        List<Option> opcoes = Question.getOptions();
        
        group = new ButtonGroup();
        radioButtonOptionMap = new HashMap<>();
        
        List<JRadioButton> radioButtons = new ArrayList<>();
        
        JLabel lblNewLabel_1 = new JLabel(Question.getDescription());
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setBounds(76, 141, 889, 64);
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel_1.setBackground(new Color(235, 235, 255));
        contentPane.add(lblNewLabel_1);
        
        
        int yPosition = 210;
        for (Option option : opcoes) {
            JRadioButton radioButton = new JRadioButton(option.getDescription());
            radioButton.setFont(new Font("Arial", 0, 16));
            radioButton.setBounds(33, yPosition, 962, 24);
            radioButton.setBackground(new Color(235, 235, 255));
            contentPane.add(radioButton);
            group.add(radioButton);
            radioButtons.add(radioButton);
            radioButtonOptionMap.put(radioButton, option); 
            yPosition += 40;
        }
        
        JButton btnNewButton = new JButton("Próxima pergunta");
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(0, 128, 255));
        btnNewButton.setBounds(457, 422, 168, 45);
        btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextQuestion(radioButtons);
            }
        });
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel_2 = new JLabel((this.current_question+1) + "/6 - ");
        lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
        lblNewLabel_2.setBounds(37, 145, 45, 13);
        contentPane.add(lblNewLabel_2);
    }
    
    private Option getSelectedOption(List<JRadioButton> radioButtons) {
        for (JRadioButton radioButton : radioButtons) {
            if (radioButton.isSelected()) {
                return radioButtonOptionMap.get(radioButton);
            }
        }
        return null; // Nenhum botão selecionado
    }
    
    private void nextQuestion(List<JRadioButton> radioButtons) {
        Option selectedOption = getSelectedOption(radioButtons);
        if (selectedOption != null) {
            System.out.println("Opção selecionada: " + selectedOption.getDescription() + " (Type: " + selectedOption.getType() + ")");
            if(selectedOption.getType() == "A") {
            	this.typeA_count++;
            }
            else if(selectedOption.getType() == "B") {
            	this.typeB_count++;
            }
            if(selectedOption.getType() == "C") {
            	this.typeC_count++;
            }
            this.current_question = this.current_question + 1;
            List<Question> Questions = this.current_quiz.getQuestions();
            contentPane.removeAll();
            contentPane.revalidate();
            contentPane.repaint();
            JLabel lblNewLabel = new JLabel(this.current_quiz.getContent());
            lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setBounds(57, 45, 938, 28);
            contentPane.add(lblNewLabel);
            if (this.current_question < Questions.size()) {
                createQuestion(Questions.get(this.current_question));
            } else {
            	contentPane.removeAll();
                contentPane.revalidate();
                contentPane.repaint();
                JLabel lblEnd = new JLabel("Fim do quiz!");
                
                if (this.typeA_count >= this.typeB_count && this.typeA_count >= this.typeC_count) {
                	JTextArea textArea = new JTextArea(this.current_quiz.getResultText("A"));
                	this.current_quiz.setResult("A");
                    textArea.setFont(new Font("Arial", Font.PLAIN, 12));
                    textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
                    textArea.setWrapStyleWord(true); // Quebra apenas em espaços
                    textArea.setBounds(40, 105, 1000, 300);
                    textArea.setEditable(false);
                    textArea.setFont(new Font("Arial", Font.BOLD, 18));
                    textArea.setBackground(new Color(235, 235, 255));
                    textArea.setForeground(new Color(6, 158, 6));
                	contentPane.add(textArea);
                } else if (this.typeB_count >= this.typeA_count && this.typeB_count >= this.typeC_count) {
                	JTextArea textArea = new JTextArea(this.current_quiz.getResultText("B"));
                	this.current_quiz.setResult("B");
                    textArea.setFont(new Font("Arial", Font.PLAIN, 12));
                    textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
                    textArea.setWrapStyleWord(true); // Quebra apenas em espaços
                    textArea.setBounds(40, 105, 1000, 300);
                    textArea.setEditable(false);
                    textArea.setFont(new Font("Arial", Font.BOLD, 18));
                    textArea.setBackground(new Color(235, 235, 255));
                    textArea.setForeground(new Color(246, 160, 0));
                	contentPane.add(textArea);
                } else {
                	JTextArea textArea = new JTextArea(this.current_quiz.getResultText("C"));
                	this.current_quiz.setResult("C");
                    textArea.setFont(new Font("Arial", Font.PLAIN, 12));
                    textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
                    textArea.setWrapStyleWord(true); // Quebra apenas em espaços
                    textArea.setBounds(40, 105, 1000, 300);
                    textArea.setEditable(false);
                    textArea.setFont(new Font("Arial", Font.BOLD, 18));
                    textArea.setBackground(new Color(235, 235, 255));
                    textArea.setForeground(Color.RED);
                	contentPane.add(textArea);
                }
                
                lblEnd.setFont(new Font("Arial", Font.BOLD, 18));
                lblEnd.setHorizontalAlignment(SwingConstants.CENTER);
                lblEnd.setBounds(57, 45, 938, 28);
                contentPane.add(lblEnd);
                
                JButton btnNewButton = new JButton("Concluir");
                btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
                btnNewButton.setForeground(Color.WHITE);
                btnNewButton.setBackground(new Color(0, 128, 255));
                btnNewButton.setBounds(457, 422, 168, 45);
                btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                    	concludeQuiz();
                    }
                });
                contentPane.add(btnNewButton);
            }
        } else {
            System.out.println("Nenhuma opção selecionada");
            return;
        }
    }
    
    private void getFinishSection(String result) {
    	if (result.equals("A")) {
        	JTextArea textArea = new JTextArea(this.current_quiz.getResultText("A"));
        	this.current_quiz.setResult("A");
            textArea.setFont(new Font("Arial", Font.PLAIN, 12));
            textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
            textArea.setWrapStyleWord(true); // Quebra apenas em espaços
            textArea.setBounds(40, 105, 1000, 300);
            textArea.setEditable(false);
            textArea.setFont(new Font("Arial", Font.BOLD, 18));
            textArea.setBackground(new Color(235, 235, 255));
            textArea.setForeground(new Color(6, 158, 6));
        	contentPane.add(textArea);
        } else if (result.equals("B")) {
        	JTextArea textArea = new JTextArea(this.current_quiz.getResultText("B"));
        	this.current_quiz.setResult("B");
            textArea.setFont(new Font("Arial", Font.PLAIN, 12));
            textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
            textArea.setWrapStyleWord(true); // Quebra apenas em espaços
            textArea.setBounds(40, 105, 1000, 300);
            textArea.setEditable(false);
            textArea.setFont(new Font("Arial", Font.BOLD, 18));
            textArea.setBackground(new Color(235, 235, 255));
            textArea.setForeground(new Color(246, 160, 0));
        	contentPane.add(textArea);
        } else {
        	JTextArea textArea = new JTextArea(this.current_quiz.getResultText("C"));
        	this.current_quiz.setResult("C");
            textArea.setFont(new Font("Arial", Font.PLAIN, 12));
            textArea.setLineWrap(true); // Permite que o texto quebre automaticamente
            textArea.setWrapStyleWord(true); // Quebra apenas em espaços
            textArea.setBounds(40, 105, 1000, 300);
            textArea.setEditable(false);
            textArea.setFont(new Font("Arial", Font.BOLD, 18));
            textArea.setBackground(new Color(235, 235, 255));
            textArea.setForeground(Color.RED);
        	contentPane.add(textArea);
        }
    	
    	JButton btnNewButton = new JButton("Voltar");
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(0, 128, 255));
        btnNewButton.setBounds(457, 422, 168, 45);
        btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            	backToHomeScreen();
            }
        });
        contentPane.add(btnNewButton);
    }
    
    private void concludeQuiz() {
    	QuizController quizController = new QuizController();
    	User user = home.user;
    	
    	String username = user.getName();
    	quizController.saveQuizResult(current_quiz, username);
        this.home.setVisible(true); 
        dispose();
    }
    
    private void backToHomeScreen() {
    	this.home.setVisible(true); 
        dispose();
    }
}
