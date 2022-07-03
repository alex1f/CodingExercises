import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HW5_B_MaxSum {
    public static void main(String[] args) {
        int[] numbers = readInput();
        long maxSum = new SegmentCalculator().findLongestSegment(numbers);
        System.out.println(maxSum);
    }

    private static int[] readInput(){
        int[] numbers = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            reader.readLine(); //skip the first line with number of inputs, don't need it since using streams

            numbers = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
        } catch (IOException e){
            e.printStackTrace();
        }
        return numbers;
    }
}

class SegmentCalculator{
    private long[] prefixes;

    private long[] calculatePrefixes (int[] numbers){
        long[] prefixes = new long[numbers.length + 1];
        prefixes[0] = 0;
        for (int i = 0; i < numbers.length; i++){
            prefixes[i+1] = prefixes[i] + numbers[i];
        }
        return prefixes;
    }

    public long findLongestSegment(int[] numbers){
        prefixes = calculatePrefixes(numbers);
        long maxSum = prefixes[1];
        for (int left = 1; left < prefixes.length; left++){
            for (int right = left; right < prefixes.length; right++){
                long currentSum = calculateSegmentLength(left, right);
                if (currentSum > maxSum){
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    private long calculateSegmentLength(int left, int right){
        return prefixes[right] - prefixes[left-1];
    }
}
