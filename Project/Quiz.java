import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private QuizQuestion[] questions;
    private int score;
    private int currentQuestionIndex;
    private boolean timeUp;

    public Quiz(QuizQuestion[] questions) {
        this.questions = questions;
        this.score = 0;
        this.currentQuestionIndex = 0;
        this.timeUp = false;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (currentQuestionIndex < questions.length) {
            QuizQuestion question = questions[currentQuestionIndex];
            displayQuestion(question);

            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    timeUp = true;
                }
            }, 10000); // 10 seconds per question

            int userAnswer = -1;
            if (!timeUp) {
                System.out.print("Enter your answer (1-4): ");
                userAnswer = scanner.nextInt();
            }

            timer.cancel();
            timeUp = false;

            if (userAnswer - 1 == question.getCorrectAnswerIndex()) {
                score++;
            }

            currentQuestionIndex++;
        }

        displayResult();
        scanner.close();
    }

    private void displayQuestion(QuizQuestion question) {
        System.out.println(question.getQuestion());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    private void displayResult() {
        System.out.println("Quiz over!");
        System.out.println("Your score: " + score + "/" + questions.length);
        for (int i = 0; i < questions.length; i++) {
            QuizQuestion question = questions[i];
            System.out.println("Q: " + question.getQuestion());
            System.out.println("Correct answer: " + question.getOptions()[question.getCorrectAnswerIndex()]);
        }
    }
}
