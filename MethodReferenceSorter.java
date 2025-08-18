import java.util.*;

public class MethodReferenceSorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> cities = new ArrayList<>();

        System.out.print("Enter number of cities: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            cities.add(sc.nextLine());
        }

        cities.sort(String::compareToIgnoreCase);
        System.out.println("Sorted Cities: " + cities);
    }
}
