import java.util.stream.IntStream;

public class Test {
    private static final String TWO = "Two";
    private static final String SEVEN = "Seven";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(1, 101).forEach(i -> {
            if (two(i) && seven(i)) {
                sb.append(TWO).append(SEVEN);
            } else if (seven(i)) {
                sb.append(SEVEN);
            } else if (two(i)) {
                sb.append(TWO);
            } else {
                sb.append(i);
            }
            sb.append(System.lineSeparator());
        });
        System.out.println(sb);
    }

    private static boolean two(int i) {
        return i % 2 == 0;
    }

    private static boolean seven(int i) {
        return i % 7 == 0;
    }
}
