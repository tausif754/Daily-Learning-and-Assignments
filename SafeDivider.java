import java.util.*;

public class SafeDivider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numerator: ");
        int a = sc.nextInt();
        System.out.print("Enter denominator: ");
        int b = sc.nextInt();

        Optional<Integer> result = (b == 0) ? Optional.empty() : Optional.of(a / b);
        System.out.println(result.orElseThrow(() -> new RuntimeException("Not Allowed")));
    }
}

