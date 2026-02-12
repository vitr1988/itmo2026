import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionRunner {

    public static void main(String[] args) {
        List<Integer> digits = List.of(1, 2, 4, 10, 1, 2, 101);
        Set<Integer> uniqueDigits = new HashSet<>();
        uniqueDigits.add(1);
        uniqueDigits.add(2);
        uniqueDigits.add(4);
        uniqueDigits.add(10);
        uniqueDigits.add(1);
        uniqueDigits.add(2);
//                Set.of(1, 2, 4, 10, 1, 2, 101);

        System.out.println(digits);
        System.out.println(uniqueDigits);

        int[] dig = new int[] {1, 2, 3};
    }

}
