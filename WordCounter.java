import java.util.*;
import java.util.stream.*;

public class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            names.add(sc.nextLine());
        }

        long count = names.stream()
                          .filter(name -> name.length() > 5)
                          .count();

        System.out.println("Names longer than 5 characters: " + count);
    }
}

