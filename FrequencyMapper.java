import java.util.*;
import java.util.stream.*;

public class FrequencyMapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();

        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            names.add(sc.nextLine());
        }

        Map<String, Long> freqMap = names.stream()
                                         .collect(Collectors.groupingBy(nm -> nm, Collectors.counting()));

        System.out.println("Frequency Map: " + freqMap);
    }
}

