package challenge1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainPartTwo {
    public static void main(String[] args) {
        File myFile = new File("inputs/aoc-input-1.txt");
        ArrayList<Integer> inputList = new ArrayList<Integer>();
        Scanner sc;
        {
            try {
                sc = new Scanner(myFile);
                while (sc.hasNextLine()) {
                    int number = Integer.parseInt(sc.nextLine());
                    inputList.add(number);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int sizeOfInputList = inputList.size();
            int count = 0, sum1 = 0 , sum2 = 0;
            for(int i=0;i<sizeOfInputList-3;i++){
                int j = i;
                // getting the curr sum of three measurement sliding window
                sum1 = inputList.get(j) + inputList.get(j + 1) + inputList.get(j + 2);
                int k = i + 1;
                j = k;
                sum2 = inputList.get(j) + inputList.get(j + 1) + inputList.get(j + 2);
                if(sum2>sum1) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
