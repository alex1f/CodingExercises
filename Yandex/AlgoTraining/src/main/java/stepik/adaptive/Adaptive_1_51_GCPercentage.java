/*1.55 The percentage of G and C characters
        https://stepik.org/lesson/43170/step/1?adaptive=true&thread=solutions&unit=21234
*/

package stepik.adaptive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntPredicate;

public class Adaptive_1_51_GCPercentage {
    public static void main(String[] args) {
        String genomeSequence = readInput();
        System.out.println(analyzeSequenceForGCPercentage(genomeSequence));
    }

    private static String readInput(){
        String input = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            input = reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }

        return input;
    }

    public static double analyzeSequenceForGCPercentage(String genome){
        long numberOfGCoccurrences = genome.toLowerCase()
                .chars()
                .filter(GCFilter())
                .count();
        int totalCharacters = genome.length();

        return numberOfGCoccurrences * 100.0 / totalCharacters;
    }

    private static IntPredicate GCFilter(){
        Set<Integer> targetCharacters = new HashSet<>(Arrays.asList((int)'g', (int)'c'));
        return targetCharacters::contains;
    }
}
