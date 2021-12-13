package challenge10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PartTwo {
    public static void main(String[] args) {
        File myFile = new File("inputs/aoc-input-10.txt");
        ArrayList<String> chunks = new ArrayList<>();
        var costs = new ArrayList<Long>();
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
            int j = 0;
            while (j < chunks.size()) {
                boolean corrupted = false;
                Stack<Character> stackOfChunks = new Stack<>();
                String chunk = chunks.get(j);
                for (char c : chunk.toCharArray()) {
                    if (c == '(' || c == '{' || c == '[' || c == '<') {
                        stackOfChunks.push(c);
                    } else if (stackOfChunks.isEmpty()) {
                        break;
                    } else if (c == ')' && stackOfChunks.peek() == '('
                            || c == ']' && stackOfChunks.peek() == '['
                            || c == '}' && stackOfChunks.peek() == '{'
                            || c == '>' && stackOfChunks.peek() == '<')
                        stackOfChunks.pop();
                    else {
                        corrupted = true;
                        break;
                    }
                }
                if (!corrupted) {
                    var cost = 0L;
                    while (!stackOfChunks.isEmpty()) {
                        cost *= 5;
                        switch (stackOfChunks.pop()) {
                            case '(' -> cost += 1;
                            case '[' -> cost += 2;
                            case '{' -> cost += 3;
                            case '<' -> cost += 4;
                        }
                    }
                    costs.add(cost);
                }
                j++;
            }
        }
            costs.sort(Long::compareTo);
            System.out.println(costs.get(costs.size() / 2));
    }
}