import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class HW4_A_Deliveries {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int totalDeliveries = Integer.parseInt(reader.readLine());

        long[] colorCodes = new long[totalDeliveries];
        long[] colorValues = new long[totalDeliveries];


        for (int i = 0; i < totalDeliveries; i++){
            String input = reader.readLine();
            String[] rawNumbers = input.split(" ");
            long colorCode = Long.parseLong(rawNumbers[0]);
            long colorValue = Long.parseLong(rawNumbers[1]);

            colorCodes[i] = colorCode;
            colorValues[i] = colorValue;

        }

        Map<Long, Long> frequencies = calculateColorFrequencies(colorCodes, colorValues);
        frequencies.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static Map<Long, Long> calculateColorFrequencies (long[] colorCodes, long[] colorValues){
        Map<Long, Long> colorFrequencies = new TreeMap<>();
        for (int i = 0; i < colorCodes.length; i++){
            long code = colorCodes[i];
            long value = colorValues[i];

            if (colorFrequencies.containsKey(code)){
                long currentValue = colorFrequencies.get(code);
                long updatedValue = currentValue + value;
                colorFrequencies.put(code, updatedValue);
            } else {
                colorFrequencies.put(code, value);
            }
        }
        return colorFrequencies;
    }
}
