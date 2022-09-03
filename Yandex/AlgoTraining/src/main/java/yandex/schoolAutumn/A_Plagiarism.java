package yandex.schoolAutumn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class A_Plagiarism {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //System.out.println("enter original:");
        String original = reader.readLine();

        //System.out.println("enter suspect:");
        String suspect = reader.readLine();

        PrintWriter writer = new PrintWriter(System.out);
        writer.write(findPlagiarism(original, suspect));
        writer.flush();
        writer.close();
    }

    public static String findPlagiarism (String original, String suspect){
        char plagiarism = 'P';
        char suspicious = 'S';
        char innocent = 'I';

        char[] lettersA = original.toCharArray();
        char[] lettersB = suspect.toCharArray();

        int[] assessments = new int[lettersA.length];

        int codeSuspicious = 1;

        StringBuilder output = new StringBuilder(original);


        for (int i = 0; i < lettersA.length; i++){
            char currentA = lettersA[i];
            char currentB = lettersB[i];

            if (currentB == currentA){
                output.setCharAt(i, plagiarism);

            } else {
                output.setCharAt(i, innocent);
                for (int j = 0; j < lettersA.length; j++){

                    char distantA = lettersA[j];
                    char distantB = lettersB[j];

                    if ((currentB == distantA) &&
                                    !(distantB == distantA) &&
                                    !(assessments[j] == codeSuspicious)){

                        output.setCharAt(i, suspicious);
                        assessments[j] = codeSuspicious;
                        break;
                    }
                }
            }
        }
        return output.toString();
    }
}
