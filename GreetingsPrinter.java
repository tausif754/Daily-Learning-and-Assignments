import java.util.Scanner;

@FunctionalInterface
interface MessagePrinter {
    void print(String msg);
}

public class GreetingsPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your greeting: ");
        String msg = sc.nextLine();

        greet(msg, m -> System.out.println("Greeting: " + m));
    }

    static void greet(String msg, MessagePrinter printer) {
        printer.print(msg);
    }
}
