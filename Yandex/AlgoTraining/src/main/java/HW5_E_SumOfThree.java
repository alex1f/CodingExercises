import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HW5_E_SumOfThree {
    public static void main(String[] args) {

        int targetNumber = 0;
        List<String> rawNumberArrays = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            targetNumber = Integer.parseInt(reader.readLine());
            for (int i = 0; i < 3; i++){
                rawNumberArrays.add(reader.readLine());
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(findPassingIndices(targetNumber, rawNumberArrays));
    }

    public static String findPassingIndices(int targetNumber, List<String> rawNumberArrays){
        List<CustomNumber> numbersA = extractFilteredNumbersFromInput(targetNumber, rawNumberArrays.get(0));
        List<CustomNumber> numbersB = extractFilteredNumbersFromInput(targetNumber, rawNumberArrays.get(1));
        List<CustomNumber> numbersC = extractFilteredNumbersFromInput(targetNumber, rawNumberArrays.get(2));

        String result = "-1";

        if (numbersA.size() == 0 || numbersB.size() == 0 || numbersC.size() == 0){
            return result;
        }

        for (CustomNumber a : numbersA){
            for (CustomNumber b : numbersB){
                for (CustomNumber c : numbersC){
                    int sum = a.getValue() + b.getValue() + c.getValue();

                    if (sum == targetNumber){
                        return a.getIndex() + " " + b.getIndex() + " " + c.getIndex();
                    }
                }
            }
        }
        return result;
    }

    private static List<CustomNumber> extractFilteredNumbersFromInput(int targetNumber, String input){
        List<CustomNumber> prospectiveNumbers = new ArrayList<>();
        //skipping first number since it contains the length of the provided array of numbers, not necessary for stream
        int[] rawNumbers = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).skip(1).toArray();
        for (int i = 0; i < rawNumbers.length; i++){
            if (rawNumbers[i] <= targetNumber-2){
                prospectiveNumbers.add(new CustomNumber(i, rawNumbers[i]));
            }
        }
        return prospectiveNumbers;
    }

    private static int[] extractNumberArrayFromInputLine(String input){
        //skipping first number since it contains the length of the provided array of numbers, not necessary for stream
       return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).skip(1).toArray();
    }

    public static String findPassingIndicesBrute(int targetNumber, List<String> rawNumberArrays){
        int[] arrayA = extractNumberArrayFromInputLine(rawNumberArrays.get(0));
        int[] arrayB = extractNumberArrayFromInputLine(rawNumberArrays.get(1));
        int[] arrayC = extractNumberArrayFromInputLine(rawNumberArrays.get(2));

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

class CustomNumber{
    private final int index;
    private final int value;

    public CustomNumber(int index, int value) {
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public int getValue() {
        return value;
    }
}
