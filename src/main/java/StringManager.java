import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringManager {
    public long returnLastValue(String result) {
        List<String> list = new ArrayList<String>(Arrays.asList(result.replace("[", ",")
                .replace("]", ",").split(",")));
        return Long.parseLong(list.get(list.size() - 1).trim());
    }
}