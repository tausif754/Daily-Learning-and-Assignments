import java.util.*;
import java.util.stream.*;

public class PrettyJoiner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> cities = new ArrayList<>();

        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            cities.add(sc.nextLine());
        }

        String joined = cities.stream().collect(Collectors.joining(", "));
        System.out.println("Joined Cities: " + joined);
    }
}
