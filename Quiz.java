
    import java.util.*;

    class Question {
        String question, option1, option2, option3, option4, correctOption;
    
        public Question(String question, String option1, String option2, String option3, String option4, String correctOption) {
            this.question = question;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.option4 = option4;
            this.correctOption = correctOption;
        }
    }
    
    public class Quiz {
        List<Question> questions;
        int score;
    
        public Quiz() {
            questions = new ArrayList<>();
            score = 0;
        }
    
        public void addQuestion(Question question) {
            questions.add(question);
        }
    
        public void startQuiz() {
            Scanner scanner = new Scanner(System.in);
    
            for(Question question : questions) {
                System.out.println(question.question);
                System.out.println("1. " + question.option1);
                System.out.println("2. " + question.option2);
                System.out.println("3. " + question.option3);
                System.out.println("4. " + question.option4);
                System.out.println("Enter your answer:");
    
                String answer = scanner.nextLine();
    
                if(answer.equals(question.correctOption)) {
                    score++;
                    System.out.println("Correct answer!");
                } else {
                    System.out.println("Incorrect answer. The correct answer was: " + question.correctOption);
                }
            }
    
            System.out.println("Quiz finished. Your score is: " + score);
            scanner.close();
        }
    
        public static void main(String[] args) {
            Quiz quiz = new Quiz();
    
            Question question1 = new Question("What is the name of India's President?", "Uday Ram",  "Ashish Sharma", "Droupadi Murmu","Ram Pal", "Droupadi Murmu");
            Question question2 = new Question("What is the capital of India?", "Paris", "London", "Rome", "New Delhi", "New Delhi");            
            quiz.addQuestion(question1);
            quiz.addQuestion(question2);
    
            quiz.startQuiz();
            
        }
    }
    
