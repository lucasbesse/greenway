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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Color;

public class QuizScreen extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Quiz current_quiz;
    private int current_question = 0;
    private ButtonGroup group; // Declaração do ButtonGroup a nível de classe
    private Map<JRadioButton, Option> radioButtonOptionMap; // Mapa para associar JRadioButton a Option

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Quiz quiz = new Quiz();
                    QuizScreen frame = new QuizScreen(quiz);
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
    public QuizScreen(Quiz quiz) {
        this.current_quiz = quiz;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1067, 634);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel(this.current_quiz.getContent());
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(57, 45, 938, 28);
        contentPane.add(lblNewLabel);
        
        List<Question> Questions = this.current_quiz.getQuestions();
        
        createQuestion(Questions.get(this.current_question));
    }
    
    private void createQuestion(Question Question) {
        List<Option> opcoes = Question.getOptions();
        
        group = new ButtonGroup(); // Inicialização do ButtonGroup para cada pergunta
        radioButtonOptionMap = new HashMap<>(); // Inicialização do Map
        
        List<JRadioButton> radioButtons = new ArrayList<>();
        
        JLabel lblNewLabel_1 = new JLabel(Question.getDescription());
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setBounds(33, 140, 889, 64);
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        contentPane.add(lblNewLabel_1);
        
        int yPosition = 210;
        for (Option option : opcoes) {
            JRadioButton radioButton = new JRadioButton(option.getDescription());
            radioButton.setBounds(33, yPosition, 962, 21);
            contentPane.add(radioButton);
            group.add(radioButton);
            radioButtons.add(radioButton);
            radioButtonOptionMap.put(radioButton, option); // Adiciona o JRadioButton e Option ao Map
            yPosition += 40;
        }
        
        JButton btnNewButton = new JButton("Próxima pergunta");
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setBackground(new Color(0, 128, 255));
        btnNewButton.setBounds(457, 422, 153, 37);
        btnNewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextQuestion(radioButtons);
            }
        });
        contentPane.add(btnNewButton);
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
            this.current_question = this.current_question + 1;
            List<Question> Questions = this.current_quiz.getQuestions();
            contentPane.removeAll();
            contentPane.revalidate();
            contentPane.repaint();
            JLabel lblNewLabel = new JLabel(this.current_quiz.getContent());
            lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
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
                lblEnd.setFont(new Font("Times New Roman", Font.BOLD, 18));
                lblEnd.setHorizontalAlignment(SwingConstants.CENTER);
                lblEnd.setBounds(57, 45, 938, 28);
                contentPane.add(lblEnd);
            }
        } else {
            System.out.println("Nenhuma opção selecionada");
            return;
        }
    }
}
