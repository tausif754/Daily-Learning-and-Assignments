import java.util.*;
import java.util.stream.*;

public class EvenNumberCollector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        System.out.print("Enter how many numbers: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        List<Integer> evens = numbers.stream()
                                     .filter(num -> num % 2 == 0)
                                     .collect(Collectors.toList());

        System.out.println("Even Numbers: " + evens);
    }
}
