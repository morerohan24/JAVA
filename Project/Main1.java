public class Main1 {
    public static void main(String[] args) {
        QuizQuestion[] questions = new QuizQuestion[]{
            new QuizQuestion("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, 2),
            new QuizQuestion("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, 1),
            new QuizQuestion("Which planet is known as the Red Planet?", new String[]{"Earth", "Mars", "Jupiter", "Venus"}, 1),
            new QuizQuestion("What is the largest ocean on Earth?", new String[]{"Atlantic", "Indian", "Arctic", "Pacific"}, 3)
        };

        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}
