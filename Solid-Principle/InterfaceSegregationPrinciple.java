import java.util.Scanner;

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Robot implements Workable {
    public void work() {
        System.out.println("Robot working...");
    }
}

class Human implements Workable, Eatable {
    public void work() {
        System.out.println("Human working...");
    }

    public void eat() {
        System.out.println("Human eating...");
    }
}

public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Who are you? (robot/human): ");
        String type = scanner.nextLine().toLowerCase();

        if (type.equals("robot")) {
            Workable r = new Robot();
            r.work();
        } else if (type.equals("human")) {
            Human h = new Human();
            h.work();
            h.eat();
        } else {
            System.out.println("Unknown type.");
        }

        scanner.close();
    }
}