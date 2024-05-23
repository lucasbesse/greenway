package screens;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Opcao;
import models.Pergunta;
import models.Quiz;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;

public class QuizScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Quiz current_quiz;

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
		
		JLabel lblNewLabel = new JLabel(this.current_quiz.getConteudo());
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(57, 45, 938, 28);
		contentPane.add(lblNewLabel);
		
		List<Pergunta> perguntas = this.current_quiz.getPerguntas();
		
		createQuestion(perguntas.get(0));
		
		
	}
	
	private void createQuestion(Pergunta pergunta) {
		List<Opcao> opcoes = pergunta.getOpcoes();
		
		JLabel lblNewLabel_1 = new JLabel(pergunta.getDescricao());
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setBounds(33, 140, 889, 64);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton(opcoes.get(0).getDescricao());
		rdbtnNewRadioButton.setBounds(33, 210, 962, 21);
		contentPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton(opcoes.get(1).getDescricao());
		rdbtnNewRadioButton_1.setBounds(33, 251, 962, 21);
		contentPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton(opcoes.get(2).getDescricao());
		rdbtnNewRadioButton_2.setBounds(33, 291, 962, 21);
		contentPane.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Próxima pergunta");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setBounds(457, 422, 153, 37);
		contentPane.add(btnNewButton);
	}
}
