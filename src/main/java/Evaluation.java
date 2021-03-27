import java.util.ArrayList;
import java.util.List;

public class Evaluation {

    public List<Long> result(int num) {
        List<Long> result = new ArrayList<>();
        long sum;
        if (num == 1 || num == 0) result.add(0L);
        if (num == 2) {
            result.add(0L);
            result.add(1L);
        }
        if (num > 2) {
            long left = 0;
            long right = 1;
            result.add(0L);
            result.add(1L);
            for (int i = 2; i < num; i++) {
                sum = left + right;
                result.add(sum);
                left = right;
                right = sum;
            }
        }
        return result;
    }
}
