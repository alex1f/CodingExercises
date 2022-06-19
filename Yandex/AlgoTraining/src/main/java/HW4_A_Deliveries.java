import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class HW4_A_Deliveries {
    public static void main(String[] args) throws IOException {
        List<Box> boxes = readBoxData();
        Map<Long, Long> frequencies = calculateColorFrequencies(boxes);
        frequencies.forEach((key, value) -> System.out.println(key + " " + value));
    }

    private static List<Box> readBoxData() throws IOException{
        List<Box> boxes = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int totalDeliveries = Integer.parseInt(reader.readLine());
        for (int i = 0; i < totalDeliveries; i++){
            String input = reader.readLine();
            String[] rawNumbers = input.split(" ");
            long colorCode = Long.parseLong(rawNumbers[0]);
            long colorValue = Long.parseLong(rawNumbers[1]);
            boxes.add(new Box(colorCode, colorValue));
        }
        return boxes;
    }

    public static Map<Long, Long> calculateColorFrequencies (List<Box> boxes){
        return boxes.stream()
                .collect(Collectors.groupingBy(
                        Box::getColorCode,
                        TreeMap::new,
                        Collectors.summingLong(Box::getColorValue))
                );
    }
}
