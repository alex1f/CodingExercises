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
                    boolean lettersMatch = currentB == distantA;
                    boolean plagiarismAtOtherSpot = distantA == distantB;
                    boolean otherLetterAlreadyUsed = (assessments[j] == codeSuspicious);

                    if (lettersMatch && !plagiarismAtOtherSpot && !otherLetterAlreadyUsed){
                        output.setCharAt(i, suspicious);
                        assessments[j] = codeSuspicious;
                        break;
                    }
                }
            }
        }
        return output.toString();
    }


    public static String findPlagiarismBrute (String original, String suspect){
        char plagiarism = 'P';
        char suspicious = 'S';
        char innocent = 'I';


        char[] lettersA = original.toCharArray();
        char[] lettersB = suspect.toCharArray();

        int[] assessments = new int[lettersA.length];

        int codePlagiarism = 2;
        int codeSuspicious = 1;
        int codeInnocent = 0;


        StringBuilder output = new StringBuilder(original);


        //scan for plagiarisms
        for (int i = 0; i < lettersA.length; i++){
            char currentA = lettersA[i];
            char currentB = lettersB[i];

            if (currentB == currentA){
                if (assessments[i] == codeInnocent)
                output.setCharAt(i, plagiarism);
                assessments[i] = codePlagiarism;
            }
        }

        //scan again to determine if the rest are suspicious or innocent
        for (int i = 0; i < lettersA.length; i++){
            char currentA = lettersA[i];
            char currentB = lettersB[i];

            if (currentB != currentA){
                for (int j = 0; j < lettersA.length; j++){
                    if (currentB == lettersA[j]
                            && assessments[j] == codeInnocent){
                        output.setCharAt(i, suspicious);
                        assessments[j] = codeSuspicious;
                        break;
                    }
                }
                if (output.charAt(i) != suspicious){
                    output.setCharAt(i, innocent);
                }

            }
        }
    return output.toString();
    }
}
