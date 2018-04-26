import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        Files.lines(Paths.get("C:\\test.txt"), StandardCharsets.UTF_8)
                .forEach(s -> Arrays.stream(s.split("\\P{L}+"))
                        .forEach(s1 -> {
                                    if (map.containsKey(s1)) {
                                        int c = map.get(s1);
                                        c++;
                                        map.put(s1, c);
                                    } else {
                                        map.put(s1, 1);
                                    }
                                }
                        )
                );

        map.entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList())
                .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
    }
}
