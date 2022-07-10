import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HW5_D_Brackets {
    public static void main(String[] args) {
        String input = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            input = reader.readLine();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(analyzeBrackets(input));
    }

    public static String analyzeBrackets (String input){
        if (input.length() % 2 > 0){
            return "NO";
        }

        int count = 0;
        for (char x : input.toCharArray()){
            if (x == '('){
                count++;
            } else {
                count--;
            }

            if (count < 0){
                return "NO";
            }
        }

        return count==0? "YES" : "NO";
    }
}
