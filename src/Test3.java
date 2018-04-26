import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Test3 {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new TreeMap<>();
        Files.lines(Paths.get("D:\\test.txt"), StandardCharsets.UTF_8)
                .forEach(s -> Arrays.stream(s.split("\\P{L}+"))
                        .forEach(s1 -> map.put(s1, map.getOrDefault(s1, 0) + 1))
                );

        map.entrySet()
                .stream()
                .sorted(Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));
    }
}
