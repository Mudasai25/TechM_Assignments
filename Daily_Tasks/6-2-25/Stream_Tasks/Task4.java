package Stream_Tasks;

import java.util.*;
import java.util.stream.*;

public class Task4{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 4, 5, 3, 6, 7, 4);

        List<Integer> uniqueNumbers = numbers.stream()
                                             .distinct()
                                             .collect(Collectors.toList());

        System.out.println("Unique Numbers: " + uniqueNumbers);
    }
}

