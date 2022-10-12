import java.util.Scanner;

public class Input {


    public static void print(String toPrint){
        System.out.println(toPrint);
    }
    public static String string(String question, String reminder){
        Scanner in = new Scanner(System.in);
        String answer;
        // Repeat the question to the user until they answer something
        do {
            print(question);
            answer = in.nextLine();
            // Change from outputting the original question
            // to outputting the reminder the second time we ask
            question = reminder;
        }
        while(answer.equals(""));
        // Return the answer
        return answer;
    }

    public static String string(String question){
        // Reuse the input method that has two arguments
        return string(question, question);
    }

    public static String menu(String question, String... choices){
        Scanner in = new Scanner(System.in);
        print(question);
        int number = 1;
        // loop through all choices and print them
        // with a number as a prefix
        for(String choice : choices){
            print(number + ". " + choice);
            number++;
        }
        String answer = "";
        // repeat waiting for the answer until we get a valid answer
        do {
            // we can get an error if the user
            // does not enter a number
            // or enters a number that is not in the list
            // to avoid a program crash use try
            try {
                answer = choices[Integer.parseInt(in.nextLine()) - 1];
            } catch (Exception ignore) {
                // i don't care which error i get
            }
        }
        while(answer.equals(""));

        // return the choice
        return answer;
    }

    public static int integer(String question){
        Scanner in = new Scanner(System.in);
        // Define two variables
        // one for the raw user input: answerAsString
        // and one for the input converted to int: answer
        String answerAsString = "";
        int answer = 0;
        do {
            // ask the user and wait for input
            System.out.println(question);
            answerAsString = in.nextLine();
            try {
                // try to convert to an integer
                answer = Integer.parseInt(answerAsString);
            }
            catch(Exception ignore){
                // if the conversion fails reset
                // the raw input to nothing/empty string
                answerAsString = "";
            }
        } while(answerAsString.equals(""));
        return answer;
    }

    public static int integer(String question, int min){
        int answer;
        do {
            answer = integer(question);
        } while (answer < min);
        return answer;
    }

    public static int integer(String question, int min, int max){
        int answer;
        do {
            answer = integer(question, min);
        }
        while (answer > max);
        return answer;
    }

    public static double decimal(String question){
        Scanner in = new Scanner(System.in);
        // Define two variables
        // one for the raw user input: answerAsString
        // and one for the input converted to int: answer
        String answerAsString;
        double answer = 0;
        do {
            // ask the user and wait for input
            System.out.println(question);
            answerAsString = in.nextLine();
            try {
                // try to convert to a double
                answer = Double.parseDouble(answerAsString);
            }
            catch(Exception ignore){
                // if the conversion fails reset
                // the raw input to nothing/empty string
                answerAsString = "";
            }
        } while(answerAsString.equals(""));
        return answer;
    }

    public static double decimal(String question, double min){
        double answer;
        do {
            answer = decimal(question);
        } while (answer < min);
        return answer;
    }

    public static double decimal(String question, double min, double max){
        double answer;
        do {
            answer = decimal(question, min);
        }
        while (answer > max);
        return answer;
    }

}