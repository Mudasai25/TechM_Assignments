package Stream_Tasks;

import java.util.*;
import java.util.stream.*;

public class Task6 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "grape");

        List<String> sortedAsc = words.stream()
                                      .sorted()
                                      .collect(Collectors.toList());
        System.out.println("Sorted (Ascending): " + sortedAsc);

        List<String> sortedDesc = words.stream()
                                       .sorted(Comparator.reverseOrder())
                                       .collect(Collectors.toList());
        System.out.println("Sorted (Descending): " + sortedDesc);
    }
}


