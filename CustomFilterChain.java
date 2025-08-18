import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class CustomFilterChain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            names.add(sc.nextLine());
        }

        Predicate<String> startsWithA = name -> name.startsWith("A");
        Predicate<String> endsWithA = name -> name.endsWith("a");

        List<String> filtered = names.stream()
                                     .filter(startsWithA.and(endsWithA))
                                     .collect(Collectors.toList());

        System.out.println("Names starting with A and ending with a: " + filtered);
    }
}

