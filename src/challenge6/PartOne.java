package challenge6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne {
    public static String[] getInputs(){
        String[] tempInputList = new String[0];
        Scanner sc = null;
        File myFile = new File("inputs/aoc-input-6.txt");
        try {
            sc = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (sc != null) {
            while(sc.hasNextLine()){
                String tempString = sc.nextLine();
                tempInputList = tempString.split(",");
            }
        }
        return tempInputList;
    }
    public static void main(String[] args){
        String[] inputList = getInputs();

        ArrayList<Integer> al = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            al.add(0);
        }


        for (String s : inputList) {
            int tempInt = Integer.parseInt(s);
            al.set(tempInt, al.get(tempInt) + 1);
        }
        // Rotating the array with the arraylist. i.e [1,2,3] -> [2,3,1]  -> [3,1,2]
        // As they have asked for 80 days
        for (int i = 0; i < 80; i++) {
            int tempFish = al.remove(0);
            al.add(tempFish);
            al.set(6, al.get(6)+tempFish);
        }

        // printing the sum of all the values in the arrayList
        int noOfFishes = 0;
        for (Integer integer : al) {
            noOfFishes += integer;
        }
        System.out.println("noOfFishes = " + noOfFishes);

    }
}
