package models;

import java.util.ArrayList;
import java.util.List;

public class DummyQuizes {

    public static Quiz createQuiz(int id) {
        if (id == 1) {
            return createWaterConservationQuiz();
        }
        // Adicionar outros quizes com ids diferentes, se necessário
        return null; // Retornar null ou lançar uma exceção se o quiz com o id especificado não existir
    }

    private static Quiz createWaterConservationQuiz() {
        // Pergunta 1
        Option option1Q1 = new Option();
        option1Q1.setId(1);
        option1Q1.setDescription("10 minutos");
        option1Q1.setType("A");

        Option option2Q1 = new Option();
        option2Q1.setId(2);
        option2Q1.setDescription("15 minutos");
        option2Q1.setType("B");

        Option option3Q1 = new Option();
        option3Q1.setId(3);
        option3Q1.setDescription("20 minutos ou mais");
        option3Q1.setType("C");

        List<Option> optionsQ1 = new ArrayList<>();
        optionsQ1.add(option1Q1);
        optionsQ1.add(option2Q1);
        optionsQ1.add(option3Q1);

        Question question1 = new Question();
        question1.setId(1);
        question1.setDescription("Quanto tempo você demora para tomar banho?");
        question1.setOptions(optionsQ1);

        // Pergunta 2
        Option option1Q2 = new Option();
        option1Q2.setId(4);
        option1Q2.setDescription("Reutilizar água da chuva para jardinagem");
        option1Q2.setType("A");

        Option option2Q2 = new Option();
        option2Q2.setId(5);
        option2Q2.setDescription("Usar água potável para regar o jardim");
        option2Q2.setType("C");

        Option option3Q2 = new Option();
        option3Q2.setId(6);
        option3Q2.setDescription("Regar o jardim com água usada da máquina de lavar");
        option3Q2.setType("B");

        List<Option> optionsQ2 = new ArrayList<>();
        optionsQ2.add(option1Q2);
        optionsQ2.add(option2Q2);
        optionsQ2.add(option3Q2);

        Question question2 = new Question();
        question2.setId(2);
        question2.setDescription("Como você utiliza a água no jardim?");
        question2.setOptions(optionsQ2);

        // Pergunta 3
        Option option1Q3 = new Option();
        option1Q3.setId(7);
        option1Q3.setDescription("Desligo a torneira enquanto escovo os dentes");
        option1Q3.setType("A");

        Option option2Q3 = new Option();
        option2Q3.setId(8);
        option2Q3.setDescription("Deixo a torneira aberta enquanto escovo os dentes");
        option2Q3.setType("C");

        Option option3Q3 = new Option();
        option3Q3.setId(9);
        option3Q3.setDescription("Às vezes desligo, às vezes deixo aberta");
        option3Q3.setType("B");

        List<Option> optionsQ3 = new ArrayList<>();
        optionsQ3.add(option1Q3);
        optionsQ3.add(option2Q3);
        optionsQ3.add(option3Q3);

        Question question3 = new Question();
        question3.setId(3);
        question3.setDescription("Como você usa a água ao escovar os dentes?");
        question3.setOptions(optionsQ3);

        // Pergunta 4
        Option option1Q4 = new Option();
        option1Q4.setId(10);
        option1Q4.setDescription("Lavo o carro com balde");
        option1Q4.setType("A");

        Option option2Q4 = new Option();
        option2Q4.setId(11);
        option2Q4.setDescription("Lavo o carro com mangueira");
        option2Q4.setType("C");

        Option option3Q4 = new Option();
        option3Q4.setId(12);
        option3Q4.setDescription("Levo o carro para lavar em locais especializados");
        option3Q4.setType("B");

        List<Option> optionsQ4 = new ArrayList<>();
        optionsQ4.add(option1Q4);
        optionsQ4.add(option2Q4);
        optionsQ4.add(option3Q4);

        Question question4 = new Question();
        question4.setId(4);
        question4.setDescription("Como você lava seu carro?");
        question4.setOptions(optionsQ4);

        // Pergunta 5
        Option option1Q5 = new Option();
        option1Q5.setId(13);
        option1Q5.setDescription("Uso a máquina de lavar apenas quando está cheia");
        option1Q5.setType("A");

        Option option2Q5 = new Option();
        option2Q5.setId(14);
        option2Q5.setDescription("Uso a máquina de lavar várias vezes com pouca roupa");
        option2Q5.setType("C");

        Option option3Q5 = new Option();
        option3Q5.setId(15);
        option3Q5.setDescription("Às vezes uso cheia, às vezes com pouca roupa");
        option3Q5.setType("B");

        List<Option> optionsQ5 = new ArrayList<>();
        optionsQ5.add(option1Q5);
        optionsQ5.add(option2Q5);
        optionsQ5.add(option3Q5);

        Question question5 = new Question();
        question5.setId(5);
        question5.setDescription("Como você usa a máquina de lavar roupa?");
        question5.setOptions(optionsQ5);

        // Adicionar todas as perguntas à lista de perguntas
        List<Question> questions = new ArrayList<>();
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);
        questions.add(question5);

        // Criar o quiz
        Quiz quiz = new Quiz();
        quiz.setId(1);
        quiz.setContent("Quiz sobre Preservação de Água");
        quiz.setQuestions(questions);
        quiz.setDone(false);
        
        quiz.setResultTextA("Parabéns! Você está fazendo um ótimo trabalho na preservação da água. Continue com os hábitos sustentáveis que você já pratica. Aqui estão algumas ideias adicionais para aumentar sua eficiência no uso da água:\r\n"
        		+ "\r\n"
        		+ "Reutilizar água da chuva para regar o jardim.\r\n"
        		+ "Instalar torneiras com controle de vazão.\r\n"
        		+ "Tomar banhos mais curtos para economizar água.\"");
        
        quiz.setResultTextB("Você está no caminho certo na preservação da água, mas sempre há espaço para melhorias. Considere implementar algumas das seguintes práticas para continuar economizando água:\r\n"
        		+ "\r\n"
        		+ "Desligar a torneira enquanto escova os dentes.\r\n"
        		+ "Verificar e consertar vazamentos de água.\r\n"
        		+ "Usar a máquina de lavar roupa apenas quando estiver completamente cheia.\"");
        
        quiz.setResultTextC("É necessário um esforço significativo para melhorar na preservação da água, seus hábitos não estão legais.. Aqui estão algumas sugestões urgentes para começar a conservar melhor este recurso vital:\r\n"
        		+ "\r\n"
        		+ "Reduzir o tempo de banho para economizar água.\r\n"
        		+ "Evitar lavar o carro com mangueira.\r\n"
        		+ "Instalar dispositivos de economia de água nos chuveiros e torneiras.");

        return quiz;
    }
}
