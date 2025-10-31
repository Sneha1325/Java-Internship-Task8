import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswerIndex;

    public Question(String questionText, String[] options, int correctAnswerIndex) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public boolean checkAnswer(int answer) {
        return answer == correctAnswerIndex;
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Which programming language is used for Android development?",
                new String[]{"1. Python", "2. Java", "3. C++", "4. Kotlin"}, 4));

        questions.add(new Question("What is the size of an int in Java?",
                new String[]{"1. 4 bytes", "2. 8 bytes", "3. 2 bytes", "4. 1 byte"}, 1));

        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"1. implement", "2. extends", "3. inherits", "4. super"}, 2));

        questions.add(new Question("What does JVM stand for?",
                new String[]{"1. Java Virtual Machine", "2. Java Verified Mode", "3. Just Virtual Memory", "4. Joint Variable Method"}, 1));

        int score = 0;

        System.out.println("=== Welcome to the Online Quiz App ===\n");

        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            System.out.println("Q" + (i + 1) + ": " + q.questionText);
            for (String opt : q.options) {
                System.out.println(opt);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            if (q.checkAnswer(answer)) {
                System.out.println("✅ Correct!\n");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer: Option " + q.correctAnswerIndex + "\n");
            }
        }

        System.out.println("=== Quiz Over! ===");
        System.out.println("Your Score: " + score + "/" + questions.size());

        double percentage = (score / (double) questions.size()) * 100;
        System.out.printf("Percentage: %.2f%%\n", percentage);

        if (percentage == 100) {
            System.out.println("🏆 Excellent!");
        } else if (percentage >= 75) {
            System.out.println("👍 Good job!");
        } else if (percentage >= 50) {
            System.out.println("🙂 Keep practicing!");
        } else {
            System.out.println("😕 Better luck next time!");
        }

        sc.close();
    }
}
