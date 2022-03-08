import java.util.Scanner;
import java.util.Random;

public class QuizDisplay {

    public static void main (String[] args) {
        Scanner kb = new Scanner(System.in);

        int count = 0;
        String userReply;
        System.out.println("Welcome to our 5 question multiple choice quiz!");
        System.out.println("Please answer every question to the best of your ability.");
        System.out.println("First question!");
        count = MultipleChoiceQuestion(count);
        System.out.println("Next question!");
        count = FillInTheBlankQuestion(count);
        System.out.println("Next question!");
        count = MultiplePartQuestion(count);
        System.out.println("Next question!");
        count = TrueOrFalseQuestion(count);
        System.out.println("Last question!");
        count = EssayQuestion(count);
        System.out.println("\nSurprise! This quiz has an extra credit question worth 1 point.");
        System.out.println("Please let us know if you would want to attempt it or go straight to the quiz results.");
        System.out.println("\nWill you be attempting it: Yes or No?");

        do {
            userReply = kb.nextLine();
            if (!(userReply.equalsIgnoreCase("Yes") || userReply.equalsIgnoreCase("No"))) {
                System.out.println("Please respond with either 'Yes' or 'No'.");
            }
        } while (!(userReply.equalsIgnoreCase("Yes") || userReply.equalsIgnoreCase("No")));

        if (userReply.equalsIgnoreCase("Yes")) {
            count = ExtraCreditEstimateQuestion(count);
        }
        DisplayResult(count);
    }

    public static int MultipleChoiceQuestion(int count) {
        Scanner kb = new Scanner (System.in);

        System.out.println("\nQuestion 1:\nWhat is the inverse of Cos(x)? Answer with the corresponding capital letter.");
        System.out.println("\tA. Sin(x)");
        System.out.println("\tB. Tan(x)");
        System.out.println("\tC. Csc(x)");
        System.out.println("\tD. Sec(x)");
        System.out.println("\tE. Cot(x)");
        System.out.print("Answer: ");

        String answer = kb.nextLine();

        while (!(answer.equalsIgnoreCase("A") || answer.equalsIgnoreCase("B") ||
            answer.equalsIgnoreCase("C") || answer.equalsIgnoreCase("D") ||
            answer.equalsIgnoreCase("E"))) {
            System.out.println("Please select a letter from A-E.");
            answer = kb.nextLine();
        }

        if (answer.equalsIgnoreCase("D")) {
            System.out.println("You are correct! 1 point obtained.");
            count++;
        }
        else {
            System.out.println("Wrong answer. You do not get points for this question.");
        }

        return count;
    }

    public static int FillInTheBlankQuestion(int count) {
        Scanner kb = new Scanner (System.in);

        System.out.println("\nQuestion 2:\nWhen multiplying polynomials, you ___ their exponents.");
        System.out.print("Answer: ");
        String answer = kb.nextLine();

        if (answer.equalsIgnoreCase("add")) {
            System.out.println("You are correct! 1 point obtained.");
            count++;
        }
        else {
            System.out.println("Wrong answer. You do not get points for this question.");
        }

        return count;
     }

    public static int MultiplePartQuestion(int count) {
        Scanner kb = new Scanner (System.in);
        Random myRan = new Random();
        int answer;

        int randomNum = myRan.nextInt(100) + 1;

        System.out.println("\nQuestion 3:\nAnswer the following multiple part problems to receive credit.");

        for (char part = 'a'; part <= 'c'; part++) {
            System.out.printf("\n" + part + ". Simplify " + randomNum + "(ln(e))." + " Type the correct number.\n");
            System.out.print("Answer: ");
            answer = kb.nextInt();
            kb.nextLine();

            if (answer == randomNum) {
                System.out.println("You are correct! 1 point obtained.");
                count++;
            }
            else {
                System.out.println("Wrong answer. You do not get points for this part of the question.");
            }

            randomNum = myRan.nextInt(100) + 1;
        }

        return count;
    }

    public static int TrueOrFalseQuestion(int count) {
        Scanner kb = new Scanner (System.in);

        System.out.println("\nQuestion 4:\nIf y = x! and z = 5y, then z = (5x)! , true or false?");
        System.out.print("Answer: ");
        String answer = kb.nextLine();

        while (!(answer.equalsIgnoreCase("true") || answer.equalsIgnoreCase("false"))) {
            System.out.println("Please type either 'true' or 'false'.");
            answer = kb.nextLine();
        }

        if (answer.equalsIgnoreCase("false")) {
            System.out.println("You are correct! 1 point obtained.");
            count++;
        }
        else {
            System.out.println("Wrong answer. You do not get points for this question.");
        }

        return count;

    }

    public static int EssayQuestion(int count) {
        Scanner kb = new Scanner (System.in);

        System.out.println("\nQuestion:5\nIn at least 5 sentences, explain how derivatives and integrals are related" +
                "to one another. This question is worth 2 points.");
        System.out.print("Answer: ");
        String answer = kb.nextLine();

        System.out.println("\nThanks for the response. Expect to receive feedback for it in a week or less.");
        return count;
    }

    public static int ExtraCreditEstimateQuestion(int count) {
        Scanner kb = new Scanner(System.in);
        int chances = 1;
        double answer;

        System.out.println("\nExtra Credit:\nEstimate the value of the square root of 507 without using a calculator. " +
                "Round to the nearest tenth.");
        System.out.println("Your margin of error cannot exceed 0.5, or else it will be counted wrong.");

        do {
            System.out.print("\nAnswer: ");
            answer = kb.nextDouble();

            if (chances == 3) {
                System.out.println("Sorry, no more chances available. You will not get a point for this answer.");
            }
            else {
                    if (answer > 22 && answer < 23) {
                        System.out.println("You are correct! 1 point obtained. ");
                        count++;
                        chances = 3;
                    }
                    else {
                        System.out.println("Wrong answer. However, this question is not easy, so you get another chance.\n" +
                                "The maximum chances for this question are 3, of which you have used " + chances + " so far.");
                    }
                }

            chances++;

            } while (chances < 4);

        return count;
    }

    public static void DisplayResult(int count) {
        double percentage = ((double) count / 8) * 100;

        System.out.println("\nYou made it to the end! Congratulations.\nSo far, your score is " + percentage + "%!");
        System.out.println("That means you got " + count + " points out of the available 8 as it stands.\n");
        System.out.println("Please wait until your last answer is graded by your instructor to receive your full" +
                " percentage. Thank you!");
    }

}
