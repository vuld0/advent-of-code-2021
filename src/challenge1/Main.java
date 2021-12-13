package challenge1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File myFile = new File("inputs/aoc-input-1.txt");
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        Scanner sc;
        {
            try {
                sc = new Scanner(myFile);
                while (sc.hasNextLine()) {
                    // parsing the string to int
                    int number = Integer.parseInt(sc.nextLine());
                    // appending the number to the list
                    inputList.add(number);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int sizeOfInputList = inputList.size();
            int count = 0;
            for(int i=1;i<sizeOfInputList;i++){
                // checking if the prev element is lesser than the cur element
                if((inputList.get(i))>(inputList.get(i-1))) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
