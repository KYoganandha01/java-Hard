import java.util.Scanner;

public class CustomerSupportChatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Customer Support Chatbot!");
        System.out.println("How can I assist you today?");

        while (true) {
            System.out.print("You: ");
            String userInput = scanner.nextLine().toLowerCase();
            if (userInput.contains("hello") || userInput.contains("hi")) {
                System.out.println("Bot: Hello! How can I help you?");
            } else if (userInput.contains("problem") || userInput.contains("issue")) {
                System.out.println("Bot: Please describe your problem in detail.");
            } else if (userInput.contains("thank")) {
                System.out.println("Bot: You're welcome! If you need further assistance, feel free to ask.");
            } else if (userInput.contains("bye") || userInput.contains("exit")) {
                System.out.println("Bot: Goodbye! Have a great day!");
                break;
            } else {
                System.out.println("Bot: I'm sorry, I didn't understand that. Could you please rephrase?");
            }
        }

        scanner.close();
    }
}
