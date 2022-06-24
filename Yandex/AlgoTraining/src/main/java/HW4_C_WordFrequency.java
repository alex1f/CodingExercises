import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HW4_C_WordFrequency {


    public static void main(String[] args) throws IOException {
        String fileName = "C:/input.txt";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<String> linesFromFile = new ArrayList<>();
        String line;

        while ((line = reader.readLine()) != null){
            linesFromFile.add(line);
        }

        List<String> wordsByFrequency = getWordListBasedOnFrequency(linesFromFile);
        wordsByFrequency.forEach(System.out::println);


    }

    private static List<String> getWordListBasedOnFrequency(List<String> linesFromFile){
     return linesFromFile.stream()
                .map(line -> line.split(" "))
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(customMapComparator)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList::new));
    }

   private static final Comparator<Map.Entry<String, Long>> customMapComparator = (entry1, entry2) -> {
        int i = entry2.getValue().compareTo(entry1.getValue());
        if (i == 0) {
            return entry1.getKey().compareTo(entry2.getKey());
        } else {
            return i;
        }
    };

    private static BufferedReader createReaderForFile (String fileName){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return reader;
    }


}
