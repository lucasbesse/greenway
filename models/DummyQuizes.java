package models;

import java.util.ArrayList;
import java.util.List;

public class DummyQuizes {

    public static Quiz createQuiz(int id) {
        if (id == 1) {
            return createWaterConservationQuiz();
        }
        if (id == 2) {
            return createWasteSeparationQuiz();
        }
        if (id == 3) {
            return createEnergyConsumptionQuiz();
        }
        if (id == 4) {
            return createEcoTransportQuiz();
        }
        if (id == 5) {
            return createFoodWasteReductionQuiz();
        }
       
        return null;
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
        quiz.setContent("Preservação de Água");
        quiz.setQuestions(questions);
        quiz.setResume("Avalie seus hábitos diários e descubra como você pode melhorar na preservação da água.");
        quiz.setDone(true);
        
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
    
    private static Quiz createWasteSeparationQuiz() {
        // Pergunta 1
        Option option1Q1 = new Option();
        option1Q1.setId(1);
        option1Q1.setDescription("Sempre separo o lixo orgânico do reciclável.");
        option1Q1.setType("A");

        Option option2Q1 = new Option();
        option2Q1.setId(2);
        option2Q1.setDescription("Às vezes separo o lixo, mas nem sempre.");
        option2Q1.setType("B");

        Option option3Q1 = new Option();
        option3Q1.setId(3);
        option3Q1.setDescription("Nunca separo o lixo.");
        option3Q1.setType("C");

        List<Option> optionsQ1 = new ArrayList<>();
        optionsQ1.add(option1Q1);
        optionsQ1.add(option2Q1);
        optionsQ1.add(option3Q1);

        Question question1 = new Question();
        question1.setId(1);
        question1.setDescription("Como você separa seu lixo?");
        question1.setOptions(optionsQ1);

        // Pergunta 2
        Option option2Q2 = new Option();
        option2Q2.setId(5);
        option2Q2.setDescription("Lavo alguns recipientes, mas não todos.");
        option2Q2.setType("B");
        
        Option option1Q2 = new Option();
        option1Q2.setId(4);
        option1Q2.setDescription("Sempre lavo os recipientes recicláveis antes de descartá-los.");
        option1Q2.setType("A");

        Option option3Q2 = new Option();
        option3Q2.setId(6);
        option3Q2.setDescription("Nunca lavo os recipientes recicláveis.");
        option3Q2.setType("C");

        List<Option> optionsQ2 = new ArrayList<>();
        optionsQ2.add(option3Q2);
        optionsQ2.add(option2Q2);
        optionsQ2.add(option1Q2);

        Question question2 = new Question();
        question2.setId(2);
        question2.setDescription("Você lava os recipientes recicláveis antes de descartá-los?");
        question2.setOptions(optionsQ2);

        // Pergunta 3
        Option option2Q3 = new Option();
        option2Q3.setId(8);
        option2Q3.setDescription("Às vezes armazeno recicláveis, mas não tenho um local específico.");
        option2Q3.setType("B");

        Option option3Q3 = new Option();
        option3Q3.setId(9);
        option3Q3.setDescription("Não tenho nenhum local específico para recicláveis.");
        option3Q3.setType("C");
        
        Option option1Q3 = new Option();
        option1Q3.setId(7);
        option1Q3.setDescription("Tenho um local específico para armazenar recicláveis.");
        option1Q3.setType("A");

        List<Option> optionsQ3 = new ArrayList<>();
        optionsQ3.add(option2Q3);
        optionsQ3.add(option1Q3);
        optionsQ3.add(option3Q3);

        Question question3 = new Question();
        question3.setId(3);
        question3.setDescription("Como você armazena seus recicláveis?");
        question3.setOptions(optionsQ3);

        // Pergunta 4
        Option option3Q4 = new Option();
        option3Q4.setId(12);
        option3Q4.setDescription("Jogo lixos eletrônicos no lixo comum.");
        option3Q4.setType("C");
        
        Option option2Q4 = new Option();
        option2Q4.setId(11);
        option2Q4.setDescription("Às vezes separo lixos eletrônicos, mas não sempre.");
        option2Q4.setType("B");
        
        Option option1Q4 = new Option();
        option1Q4.setId(10);
        option1Q4.setDescription("Separo corretamente lixos eletrônicos e baterias.");
        option1Q4.setType("A");

        List<Option> optionsQ4 = new ArrayList<>();
        optionsQ4.add(option2Q4);
        optionsQ4.add(option3Q4);
        optionsQ4.add(option1Q4);

        Question question4 = new Question();
        question4.setId(4);
        question4.setDescription("Como você descarta lixos eletrônicos?");
        question4.setOptions(optionsQ4);

        // Pergunta 5
        Option option1Q5 = new Option();
        option1Q5.setId(13);
        option1Q5.setDescription("Levo recicláveis aos pontos de coleta regularmente.");
        option1Q5.setType("A");
        
        Option option3Q5 = new Option();
        option3Q5.setId(15);
        option3Q5.setDescription("Nunca levo recicláveis aos pontos de coleta.");
        option3Q5.setType("C");

        Option option2Q5 = new Option();
        option2Q5.setId(14);
        option2Q5.setDescription("Levo recicláveis aos pontos de coleta ocasionalmente.");
        option2Q5.setType("B");

        List<Option> optionsQ5 = new ArrayList<>();
        optionsQ5.add(option3Q5);
        optionsQ5.add(option1Q5);
        optionsQ5.add(option2Q5);

        Question question5 = new Question();
        question5.setId(5);
        question5.setDescription("Você leva recicláveis aos pontos de coleta?");
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
        quiz.setId(2);
        quiz.setContent("Separação de Lixo");
        quiz.setQuestions(questions);
        quiz.setResume("Verifique seus hábitos de reciclagem em casa e encontre formas de aprimorar suas práticas de reciclagem");
        quiz.setDone(true);
        
        quiz.setResultTextA("Parabéns! Você está fazendo um ótimo trabalho na separação de lixo e reciclagem. Continue com esses hábitos sustentáveis. Aqui estão algumas ideias adicionais para aumentar sua eficiência na reciclagem:\r\n"
                + "\r\n"
                + "Separar adequadamente lixos eletrônicos e baterias.\r\n"
                + "Participar de programas de reciclagem comunitária.\r\n"
                + "Reduzir o uso de plásticos descartáveis.\"");
        
        quiz.setResultTextB("Você está no caminho certo na separação de lixo e reciclagem, mas sempre há espaço para melhorias. Considere implementar algumas das seguintes práticas para continuar melhorando:\r\n"
                + "\r\n"
                + "Lavar os recipientes recicláveis antes de descartá-los.\r\n"
                + "Estabelecer um local específico para armazenar recicláveis.\r\n"
                + "Levar recicláveis aos pontos de coleta regularmente.\"");
        
        quiz.setResultTextC("É necessário um esforço significativo para melhorar na separação de lixo e reciclagem. Aqui estão algumas sugestões urgentes para começar a melhorar seus hábitos de reciclagem:\r\n"
                + "\r\n"
                + "Separar o lixo orgânico do reciclável.\r\n"
                + "Descartar corretamente lixos eletrônicos.\r\n"
                + "Participar de programas de reciclagem e levar recicláveis aos pontos de coleta.\"");

        return quiz;
    }
    
    private static Quiz createEnergyConsumptionQuiz() {
        // Pergunta 1
        Option option1Q1 = new Option();
        option1Q1.setId(1);
        option1Q1.setDescription("Sempre desligo os aparelhos eletrônicos quando não estão em uso.");
        option1Q1.setType("A");

        Option option2Q1 = new Option();
        option2Q1.setId(2);
        option2Q1.setDescription("Deixo alguns aparelhos em stand-by.");
        option2Q1.setType("B");

        Option option3Q1 = new Option();
        option3Q1.setId(3);
        option3Q1.setDescription("Deixo todos os aparelhos ligados o tempo todo.");
        option3Q1.setType("C");

        List<Option> optionsQ1 = new ArrayList<>();
        optionsQ1.add(option1Q1);
        optionsQ1.add(option3Q1);
        optionsQ1.add(option2Q1);

        Question question1 = new Question();
        question1.setId(1);
        question1.setDescription("Como você gerencia o uso de aparelhos eletrônicos em casa?");
        question1.setOptions(optionsQ1);

        // Pergunta 2
        Option option1Q2 = new Option();
        option1Q2.setId(4);
        option1Q2.setDescription("Uso lâmpadas de LED em toda a casa.");
        option1Q2.setType("A");

        Option option2Q2 = new Option();
        option2Q2.setId(5);
        option2Q2.setDescription("Uso lâmpadas fluorescentes.");
        option2Q2.setType("B");

        Option option3Q2 = new Option();
        option3Q2.setId(6);
        option3Q2.setDescription("Uso lâmpadas incandescentes.");
        option3Q2.setType("C");

        List<Option> optionsQ2 = new ArrayList<>();
        optionsQ2.add(option3Q2);
        optionsQ2.add(option1Q2);
        optionsQ2.add(option2Q2);

        Question question2 = new Question();
        question2.setId(2);
        question2.setDescription("Quais tipos de lâmpadas você usa em casa?");
        question2.setOptions(optionsQ2);

        // Pergunta 3
        Option option1Q3 = new Option();
        option1Q3.setId(7);
        option1Q3.setDescription("Desligo as luzes ao sair de um cômodo.");
        option1Q3.setType("A");

        Option option2Q3 = new Option();
        option2Q3.setId(8);
        option2Q3.setDescription("Deixo as luzes acesas em alguns cômodos, mesmo quando não estou lá.");
        option2Q3.setType("B");

        Option option3Q3 = new Option();
        option3Q3.setId(9);
        option3Q3.setDescription("Deixo as luzes acesas em todos os cômodos, independentemente de estar lá ou não.");
        option3Q3.setType("C");

        List<Option> optionsQ3 = new ArrayList<>();
        optionsQ3.add(option2Q3);
        optionsQ3.add(option3Q3);
        optionsQ3.add(option1Q3);

        Question question3 = new Question();
        question3.setId(3);
        question3.setDescription("Como você gerencia o uso de iluminação em casa?");
        question3.setOptions(optionsQ3);

        // Pergunta 4
        Option option1Q4 = new Option();
        option1Q4.setId(10);
        option1Q4.setDescription("Uso ar condicionado apenas quando necessário e em temperaturas moderadas.");
        option1Q4.setType("A");

        Option option2Q4 = new Option();
        option2Q4.setId(11);
        option2Q4.setDescription("Uso ventilador na maior parte do tempo.");
        option2Q4.setType("B");

        Option option3Q4 = new Option();
        option3Q4.setId(12);
        option3Q4.setDescription("Deixo o ar condicionado ligado o dia todo.");
        option3Q4.setType("C");

        List<Option> optionsQ4 = new ArrayList<>();
        optionsQ4.add(option3Q4);
        optionsQ4.add(option2Q4);
        optionsQ4.add(option1Q4);

        Question question4 = new Question();
        question4.setId(4);
        question4.setDescription("Como você usa ar condicionado e ventiladores em casa?");
        question4.setOptions(optionsQ4);

        // Pergunta 5
        Option option1Q5 = new Option();
        option1Q5.setId(13);
        option1Q5.setDescription("Uso eletrodomésticos eficientes em termos de energia.");
        option1Q5.setType("A");

        Option option2Q5 = new Option();
        option2Q5.setId(14);
        option2Q5.setDescription("Tenho alguns eletrodomésticos eficientes e outros não.");
        option2Q5.setType("B");

        Option option3Q5 = new Option();
        option3Q5.setId(15);
        option3Q5.setDescription("Não me preocupo com a eficiência energética dos eletrodomésticos.");
        option3Q5.setType("C");

        List<Option> optionsQ5 = new ArrayList<>();
        optionsQ5.add(option2Q5);
        optionsQ5.add(option3Q5);
        optionsQ5.add(option1Q5);

        Question question5 = new Question();
        question5.setId(5);
        question5.setDescription("Quão eficientes são seus eletrodomésticos em termos de consumo de energia?");
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
        quiz.setId(3);
        quiz.setContent("Consumo de Energia Elétrica");
        quiz.setQuestions(questions);
        quiz.setResume("Analise seu uso de energia elétrica e descubra maneiras de tornar seu consumo mais eficiente e sustentável");
        quiz.setDone(false);
        
        quiz.setResultTextA("Parabéns! Você está fazendo um ótimo trabalho na economia de energia elétrica. Continue com esses hábitos sustentáveis. Aqui estão algumas ideias adicionais para aumentar sua eficiência energética:\r\n"
                + "\r\n"
                + "Investir em painéis solares para gerar sua própria energia.\r\n"
                + "Usar temporizadores para controlar automaticamente o uso de eletrônicos.\r\n"
                + "Manter a manutenção regular de aparelhos para garantir sua eficiência.\"");
        
        quiz.setResultTextB("Você está no caminho certo na economia de energia elétrica, mas sempre há espaço para melhorias. Considere implementar algumas das seguintes práticas para continuar melhorando:\r\n"
                + "\r\n"
                + "Desligar todos os aparelhos quando não estão em uso.\r\n"
                + "Trocar todas as lâmpadas por LEDs.\r\n"
                + "Evitar o uso desnecessário do ar condicionado.\"");
        
        quiz.setResultTextC("É necessário um esforço significativo para melhorar na economia de energia elétrica. Aqui estão algumas sugestões urgentes para começar a melhorar seus hábitos de consumo de energia:\r\n"
                + "\r\n"
                + "Desligar aparelhos eletrônicos quando não estiverem em uso.\r\n"
                + "Reduzir o uso de lâmpadas incandescentes e adotar LEDs.\r\n"
                + "Usar o ar condicionado de forma moderada e apenas quando necessário.\"");

        return quiz;
    }
    
    private static Quiz createEcoTransportQuiz() {
        // Pergunta 1
        Option option1Q1 = new Option();
        option1Q1.setId(1);
        option1Q1.setDescription("Uso transporte público regularmente.");
        option1Q1.setType("A");

        Option option2Q1 = new Option();
        option2Q1.setId(2);
        option2Q1.setDescription("Uso carro particular para a maioria dos trajetos.");
        option2Q1.setType("C");

        Option option3Q1 = new Option();
        option3Q1.setId(3);
        option3Q1.setDescription("Faço caronas compartilhadas sempre que possível.");
        option3Q1.setType("B");

        List<Option> optionsQ1 = new ArrayList<>();
        optionsQ1.add(option1Q1);
        optionsQ1.add(option2Q1);
        optionsQ1.add(option3Q1);

        Question question1 = new Question();
        question1.setId(1);
        question1.setDescription("Como você se desloca normalmente?");
        question1.setOptions(optionsQ1);

        // Pergunta 2
        Option option1Q2 = new Option();
        option1Q2.setId(4);
        option1Q2.setDescription("Uso bicicleta para trajetos curtos.");
        option1Q2.setType("A");

        Option option2Q2 = new Option();
        option2Q2.setId(5);
        option2Q2.setDescription("Caminho quando o destino é próximo.");
        option2Q2.setType("B");

        Option option3Q2 = new Option();
        option3Q2.setId(6);
        option3Q2.setDescription("Uso carro até para trajetos curtos.");
        option3Q2.setType("C");

        List<Option> optionsQ2 = new ArrayList<>();
        optionsQ2.add(option1Q2);
        optionsQ2.add(option3Q2);
        optionsQ2.add(option2Q2);

        Question question2 = new Question();
        question2.setId(2);
        question2.setDescription("Como você se desloca para destinos curtos?");
        question2.setOptions(optionsQ2);

        // Pergunta 3
        Option option1Q3 = new Option();
        option1Q3.setId(7);
        option1Q3.setDescription("Mantenho meu carro bem conservado e revisado.");
        option1Q3.setType("A");

        Option option2Q3 = new Option();
        option2Q3.setId(8);
        option2Q3.setDescription("Faço manutenção no carro apenas quando necessário.");
        option2Q3.setType("B");

        Option option3Q3 = new Option();
        option3Q3.setId(9);
        option3Q3.setDescription("Raramente faço manutenção no carro.");
        option3Q3.setType("C");

        List<Option> optionsQ3 = new ArrayList<>();
        optionsQ3.add(option1Q3);
        optionsQ3.add(option3Q3);
        optionsQ3.add(option2Q3);

        Question question3 = new Question();
        question3.setId(3);
        question3.setDescription("Como você cuida da manutenção do seu carro?");
        question3.setOptions(optionsQ3);

        // Pergunta 4
        Option option1Q4 = new Option();
        option1Q4.setId(10);
        option1Q4.setDescription("Combino trajetos para otimizar o uso do carro.");
        option1Q4.setType("A");

        Option option2Q4 = new Option();
        option2Q4.setId(11);
        option2Q4.setDescription("Faço vários trajetos curtos e separados.");
        option2Q4.setType("C");

        Option option3Q4 = new Option();
        option3Q4.setId(12);
        option3Q4.setDescription("Uso transporte público para a maioria dos trajetos.");
        option3Q4.setType("B");

        List<Option> optionsQ4 = new ArrayList<>();
        optionsQ4.add(option2Q4);
        optionsQ4.add(option3Q4);
        optionsQ4.add(option1Q4);

        Question question4 = new Question();
        question4.setId(4);
        question4.setDescription("Como você planeja seus trajetos diários?");
        question4.setOptions(optionsQ4);

        // Pergunta 5
        Option option1Q5 = new Option();
        option1Q5.setId(13);
        option1Q5.setDescription("Uso veículos elétricos ou híbridos.");
        option1Q5.setType("A");

        Option option2Q5 = new Option();
        option2Q5.setId(14);
        option2Q5.setDescription("Uso veículos a combustão.");
        option2Q5.setType("C");

        Option option3Q5 = new Option();
        option3Q5.setId(15);
        option3Q5.setDescription("Uso transporte público como principal meio de locomoção.");
        option3Q5.setType("B");

        List<Option> optionsQ5 = new ArrayList<>();
        optionsQ5.add(option3Q5);
        optionsQ5.add(option1Q5);
        optionsQ5.add(option2Q5);

        Question question5 = new Question();
        question5.setId(5);
        question5.setDescription("Quais tipos de veículos você utiliza?");
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
        quiz.setId(4);
        quiz.setContent("Transporte Ecológico");
        quiz.setQuestions(questions);
        quiz.setResume("Avalie suas práticas de transporte e descubra maneiras de torná-las mais ecológicas e sustentáveis.");
        quiz.setDone(false);

        quiz.setResultTextA("Parabéns! Você está adotando práticas de transporte muito ecológicas. Continue assim e considere:\r\n"
                + "\r\n"
                + "Investir em um veículo elétrico.\r\n"
                + "Utilizar ainda mais o transporte público.\r\n"
                + "Incentivar outras pessoas a fazerem caronas compartilhadas.\"");

        quiz.setResultTextB("Você está no caminho certo para práticas de transporte mais ecológicas. Considere:\r\n"
                + "\r\n"
                + "Usar a bicicleta ou caminhar para trajetos curtos.\r\n"
                + "Fazer manutenção regular no seu veículo.\r\n"
                + "Planejar trajetos para reduzir o uso do carro.\"");

        quiz.setResultTextC("Você pode melhorar significativamente suas práticas de transporte para serem mais ecológicas. Sugestões:\r\n"
                + "\r\n"
                + "Usar transporte público mais frequentemente.\r\n"
                + "Considerar veículos elétricos ou híbridos.\r\n"
                + "Combinar trajetos para otimizar o uso do carro.\"");

        return quiz;
    }
    
    private static Quiz createFoodWasteReductionQuiz() {
        // Pergunta 1
        Option option1Q1 = new Option();
        option1Q1.setId(1);
        option1Q1.setDescription("Planejo minhas refeições semanalmente.");
        option1Q1.setType("A");

        Option option2Q1 = new Option();
        option2Q1.setId(2);
        option2Q1.setDescription("Compro alimentos sem planejar as refeições.");
        option2Q1.setType("C");

        Option option3Q1 = new Option();
        option3Q1.setId(3);
        option3Q1.setDescription("Às vezes planejo, às vezes compro sem planejar.");
        option3Q1.setType("B");

        List<Option> optionsQ1 = new ArrayList<>();
        optionsQ1.add(option1Q1);
        optionsQ1.add(option2Q1);
        optionsQ1.add(option3Q1);

        Question question1 = new Question();
        question1.setId(1);
        question1.setDescription("Como você planeja suas compras de alimentos?");
        question1.setOptions(optionsQ1);

        // Pergunta 2
        Option option1Q2 = new Option();
        option1Q2.setId(4);
        option1Q2.setDescription("Reutilizo sobras de refeições em novas receitas.");
        option1Q2.setType("A");

        Option option2Q2 = new Option();
        option2Q2.setId(5);
        option2Q2.setDescription("Jogo fora as sobras de refeições.");
        option2Q2.setType("C");

        Option option3Q2 = new Option();
        option3Q2.setId(6);
        option3Q2.setDescription("Às vezes reutilizo, às vezes jogo fora.");
        option3Q2.setType("B");

        List<Option> optionsQ2 = new ArrayList<>();
        optionsQ2.add(option1Q2);
        optionsQ2.add(option3Q2);
        optionsQ2.add(option2Q2);

        Question question2 = new Question();
        question2.setId(2);
        question2.setDescription("O que você faz com as sobras de refeições?");
        question2.setOptions(optionsQ2);

        // Pergunta 3
        Option option1Q3 = new Option();
        option1Q3.setId(7);
        option1Q3.setDescription("Armazeno corretamente os alimentos para durar mais.");
        option1Q3.setType("A");

        Option option2Q3 = new Option();
        option2Q3.setId(8);
        option2Q3.setDescription("Armazeno os alimentos de qualquer forma.");
        option2Q3.setType("C");

        Option option3Q3 = new Option();
        option3Q3.setId(9);
        option3Q3.setDescription("Tento armazenar corretamente, mas às vezes falho.");
        option3Q3.setType("B");

        List<Option> optionsQ3 = new ArrayList<>();
        optionsQ3.add(option1Q3);
        optionsQ3.add(option3Q3);
        optionsQ3.add(option2Q3);

        Question question3 = new Question();
        question3.setId(3);
        question3.setDescription("Como você armazena os alimentos em casa?");
        question3.setOptions(optionsQ3);

        // Pergunta 4
        Option option1Q4 = new Option();
        option1Q4.setId(10);
        option1Q4.setDescription("Compro apenas a quantidade de alimentos que preciso.");
        option1Q4.setType("A");

        Option option2Q4 = new Option();
        option2Q4.setId(11);
        option2Q4.setDescription("Compro em grandes quantidades e acabo desperdiçando.");
        option2Q4.setType("C");

        Option option3Q4 = new Option();
        option3Q4.setId(12);
        option3Q4.setDescription("Às vezes compro demais, às vezes na quantidade certa.");
        option3Q4.setType("B");

        List<Option> optionsQ4 = new ArrayList<>();
        optionsQ4.add(option1Q4);
        optionsQ4.add(option3Q4);
        optionsQ4.add(option2Q4);

        Question question4 = new Question();
        question4.setId(4);
        question4.setDescription("Como você decide a quantidade de alimentos para comprar?");
        question4.setOptions(optionsQ4);

        // Pergunta 5
        Option option1Q5 = new Option();
        option1Q5.setId(13);
        option1Q5.setDescription("Faço compostagem com resíduos orgânicos.");
        option1Q5.setType("A");

        Option option2Q5 = new Option();
        option2Q5.setId(14);
        option2Q5.setDescription("Jogo fora todos os resíduos orgânicos.");
        option2Q5.setType("C");

        Option option3Q5 = new Option();
        option3Q5.setId(15);
        option3Q5.setDescription("Às vezes faço compostagem, às vezes jogo fora.");
        option3Q5.setType("B");

        List<Option> optionsQ5 = new ArrayList<>();
        optionsQ5.add(option1Q5);
        optionsQ5.add(option3Q5);
        optionsQ5.add(option2Q5);

        Question question5 = new Question();
        question5.setId(5);
        question5.setDescription("O que você faz com os resíduos orgânicos?");
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
        quiz.setId(5);
        quiz.setContent("Redução de Desperdício de Alimentos");
        quiz.setQuestions(questions);
        quiz.setDone(true);

        quiz.setResume("Avalie suas práticas de consumo de alimentos e descubra como reduzir o desperdício de alimentos em sua casa.");

        quiz.setResultTextA("Parabéns! Você está adotando práticas excelentes para reduzir o desperdício de alimentos. Continue assim e considere:\r\n"
                + "\r\n"
                + "Compartilhar suas dicas com amigos e familiares.\r\n"
                + "Experimentar novas receitas com sobras de alimentos.\r\n"
                + "Aprofundar seus conhecimentos sobre compostagem.\"");

        quiz.setResultTextB("Você está no caminho certo para reduzir o desperdício de alimentos, mas sempre há espaço para melhorias. Considere:\r\n"
                + "\r\n"
                + "Planejar melhor suas compras de alimentos.\r\n"
                + "Armazenar os alimentos de maneira mais eficiente.\r\n"
                + "Reutilizar as sobras de alimentos em novas receitas.\"");

        quiz.setResultTextC("Há um grande espaço para melhorar suas práticas e reduzir o desperdício de alimentos. Sugestões:\r\n"
                + "\r\n"
                + "Começar a planejar suas refeições semanalmente.\r\n"
                + "Tentar compostagem para resíduos orgânicos.\r\n"
                + "Reutilizar sobras de refeições para evitar desperdício.\"");

        return quiz;
    }


}
