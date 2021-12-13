package challenge2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartTwo {
    public static void main(String[] args) {
        File myFile = new File("inputs/aoc-input-2.txt");
        Scanner sc;
        int forward = 0;
        int depth = 0;
        int aim = 0;
        try {
            sc = new Scanner(myFile);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // getting the key and values of the commands
                String[] words = line.split(" ");
                if(words[0].equals("forward")) {
                    forward += Integer.parseInt(words[1]);
                    depth += (aim * Integer.parseInt(words[1]));
                }
                if(words[0].equals("down")) {
                    aim += Integer.parseInt(words[1]);
                }
                if(words[0].equals("up")) {
                    aim -= Integer.parseInt(words[1]);
                }
            }
            System.out.println(forward*depth);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
