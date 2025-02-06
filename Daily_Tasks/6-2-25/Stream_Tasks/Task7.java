package Stream_Tasks;

import java.util.*;
import java.util.stream.*;

public class Task7{
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        OptionalInt max = numbers.stream()
                                 .mapToInt(Integer::intValue)
                                 .max();

        OptionalInt min = numbers.stream()
                                 .mapToInt(Integer::intValue)
                                 .min();

        max.ifPresent(maxVal -> System.out.println("Maximum: " + maxVal));
        min.ifPresent(minVal -> System.out.println("Minimum: " + minVal));
    }
}
