import java.util.*;

public class NameSorter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.println("Enter 5 names:");
        for (int i = 0; i < 5; i++) {
            names.add(sc.nextLine());
        }

        names.sort((n1, n2) -> n1.compareTo(n2));
        System.out.println("Sorted Names: " + names);
    }
}
