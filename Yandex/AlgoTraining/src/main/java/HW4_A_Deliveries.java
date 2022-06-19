import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HW4_A_Deliveries {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int totalDeliveries = Integer.parseInt(reader.readLine());

        List<Box> boxes = new ArrayList<>();


        for (int i = 0; i < totalDeliveries; i++){
            String input = reader.readLine();
            String[] rawNumbers = input.split(" ");
            long colorCode = Long.parseLong(rawNumbers[0]);
            long colorValue = Long.parseLong(rawNumbers[1]);

            boxes.add(new Box(colorCode, colorValue));

        }

        Map<Long, Long> frequencies = calculateColorFrequencies(boxes);
        frequencies.forEach((key, value) -> System.out.println(key + " " + value));
    }

    public static Map<Long, Long> calculateColorFrequencies (List<Box> boxes){
        return boxes.stream().collect(Collectors.groupingBy(Box::getColorCode, Collectors.summingLong(Box::getColorValue)));

    }
}
