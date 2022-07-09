import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HW5_B_MaxSum {
    public static void main(String[] args) {
        int[] numbers = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            reader.readLine();
            String[] rawNumbers = reader.readLine().split(" ");
            numbers = Arrays.stream(rawNumbers).mapToInt(Integer::valueOf).toArray();

        } catch (IOException e){
            e.printStackTrace();
        }

        long maxSum = findLongestSegment(numbers);
        System.out.println(maxSum);
    }

    public static long findLongestSegment(int[] numbers){
        long maxSum = numbers[0];
        long partialSum = 0;
        for (int i = 0; i < numbers.length; i++){
            partialSum += numbers[i];

            if (partialSum > maxSum){
                maxSum = partialSum;
            }

            if (partialSum < 0){
                partialSum = 0;
            }

        }

        if (maxSum < 0) {
            Arrays.sort(numbers);
            maxSum = numbers[numbers.length-1];
        }
        return maxSum;
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
                long currentSum = prefixes[right] - prefixes[left-1];
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
