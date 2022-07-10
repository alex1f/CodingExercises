import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HW5_E_SumOfThree {
    public static void main(String[] args) {
        int targetNumber = 0;
        List<int[]> numberArrays = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            targetNumber = Integer.parseInt(reader.readLine());
            for (int i = 0; i < 3; i++){
                numberArrays.add(extractNumberArrayFromInputLine(reader.readLine()));
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(findPassingIndices(targetNumber, numberArrays));
    }

    private static int[] extractNumberArrayFromInputLine(String input){
       return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).skip(1).toArray();
    }

    public static String findPassingIndices(int targetNumber, List<int[]> numberArrays){
        int[] arrayA = numberArrays.get(0);
        int[] arrayB = numberArrays.get(1);
        int[] arrayC = numberArrays.get(2);

        String result = "-1";

        Set<Integer> uselessIndicesB = findUselessIndices(targetNumber, arrayB);
        Set<Integer> uselessIndicesC = findUselessIndices(targetNumber, arrayC);

        for (int i = 0; i < arrayA.length; i++){
            int currentA = arrayA[i];
            if (currentA >= targetNumber){
                continue;
            }
            for (int j = 0; j < arrayB.length; j++){
                if (uselessIndicesB.contains(j)){
                    continue;
                }
                int currentB = arrayB[j];

                for (int k = 0; k < arrayC.length; k++){
                    if (uselessIndicesC.contains(k)){
                        continue;
                    }
                    int currentC = arrayC[k];

                    int sum = currentA + currentB + currentC;

                    if (sum == targetNumber){
                        return i + " " + j + " " + k;
                    }

                }
            }
        }
        return result;
    }

    private static Set<Integer> findUselessIndices (int targetNumber, int[] numbers){
        Set<Integer> uselessIndices = new HashSet<>();

        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] > targetNumber-2){
                uselessIndices.add(i);
            }
        }
        return uselessIndices;
    }
}
