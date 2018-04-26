import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100).mapToObj(i -> {
                    StringBuilder sb = new StringBuilder();
                    if (i % 2 == 0) {
                        sb.append("Two");
                    }
                    if (i % 7 == 0) {
                        sb.append("Seven");
                    }
                    return sb.length() == 0 ? sb.append(i) : sb;
                }
        ).forEach(System.out::println);
    }
}
