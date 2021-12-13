package challenge10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PartOne {
    public static void main(String[] args) {
        File myFile = new File("inputs/aoc-input-10.txt");
        ArrayList<String> chunks = new ArrayList<>();
        Scanner sc;
        {
            try {
                sc = new Scanner(myFile);
                while (sc.hasNextLine()) {
                    String chunk = sc.nextLine();
                    chunks.add(chunk);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int score = 0;
            Stack<Character> stackOfChunks = new Stack<>();
            // looping through each chunk in chunks
            int j = 0;
            while(j<chunks.size()){
                String chunk = chunks.get(j);
                for(char c: chunk.toCharArray()){
                    if(c == '(' || c == '[' || c == '{' || c == '<'){
                        stackOfChunks.push(c);
                    }
                    else if(stackOfChunks.isEmpty()){
                        break;
                    }
                    else if(c == ')' && stackOfChunks.peek() == '('
                        || c == ']' && stackOfChunks.peek() == '['
                        || c == '}' && stackOfChunks.peek() == '{'
                        || c == '>' && stackOfChunks.peek() == '<')
                        stackOfChunks.pop();
                    else {
                        switch(c){
                            case ')' -> score += 3;
                            case ']' -> score += 57;
                            case '}' -> score += 1197;
                            case '>' -> score += 25137;
                        }
                        break;
                    }
                }
            j++;
            }
            System.out.println("score = " + score);
        }
    }

}
