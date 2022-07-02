import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HW5_A_PrefixSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfQueries = extractNumberOfQueries(reader.readLine());
        int[] numbers = extractNumberArray(reader.readLine());

        PrefixCalculator calculator = new PrefixCalculator(numbers);

        for (int i = 0; i < numberOfQueries; i++){
            String[] pair = reader.readLine().split(" ");
            int left = Integer.parseInt(pair[0]);
            int right = Integer.parseInt(pair[1]);
            System.out.println(calculator.calculateSegmentLength(left, right));
        }
    }

    private static int extractNumberOfQueries(String line){
        return Integer.parseInt(line.split(" ")[1]);
    }

    private static int[] extractNumberArray(String rawNumbers){
        return  Arrays.stream(rawNumbers.split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}

class PrefixCalculator{
    private final long[] prefixes;

    public PrefixCalculator(int[] numbers){
        prefixes = calculatePrefixes(numbers);
    }

    private static long[] calculatePrefixes (int[] numbers){
        long[] prefixes = new long[numbers.length + 1];
        prefixes[0] = 0;
        for (int i = 0; i < numbers.length; i++){
            prefixes[i+1] = prefixes[i] + numbers[i];
        }
        return prefixes;
    }

    public long calculateSegmentLength(int left, int right){
        return prefixes[right] - prefixes[left-1];
    }
}
