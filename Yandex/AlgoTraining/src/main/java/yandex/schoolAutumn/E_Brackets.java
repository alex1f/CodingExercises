package yandex.schoolAutumn;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class E_Brackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("C:/test.txt"));
        String input = reader.readLine();

        System.out.println(analyzeBrackets(input));
    }

    public static int analyzeBrackets(String input){
        char[] symbols = input.toCharArray();

        int balance = 0;
        List<Bracket> brackets = new ArrayList<>();

        for (int i = 0; i < symbols.length; i++){
            if (symbols[i] == '{'){
                balance--;
                brackets.add(new Bracket('{', i+1));
            } else if (symbols[i] == '}'){
                balance++;
                brackets.add(new Bracket('}', i+1));
            }
        }


        Deque<Bracket> matches = new LinkedList<>();
        if (balance == -1){
            for (Bracket element : brackets){
                char currentBracket = element.bracket;
                if (currentBracket == '{'){
                    matches.addFirst(element);
                } else if (currentBracket == '}'){
                    matches.removeFirst();
                }
            }
            return matches.removeFirst().index;

        } else if (balance == 1){
            for (int i = brackets.size() - 1; i >= 0; i--){
                char currentBracket = brackets.get(i).bracket;
                if (currentBracket == '}'){
                    matches.addLast(brackets.get(i));
                } else if (currentBracket == '{'){
                    matches.removeFirst();
                }
            }
            return matches.removeFirst().index;
        } else {
            return -1;
        }
    }
}

class Bracket{
    public final char bracket;
    public final int index;

    public Bracket(char bracket, int index) {
        this.bracket = bracket;
        this.index = index;
    }
}