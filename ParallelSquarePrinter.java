import java.util.*;

public class ParallelSquarePrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        System.out.print("Squares (Parallel): ");
        numbers.parallelStream()
               .forEach(num -> System.out.print((num * num) + " "));
    }
}

