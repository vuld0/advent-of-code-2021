package challenge6;

import java.math.BigInteger;
import java.util.ArrayList;


public class PartTwo {
    public static void main(String[] args){
        String[] inputList = PartOne.getInputs();
        // as we have number of bigger value, the integer won't be enough. So we would go with BigInteger
        ArrayList<BigInteger> al = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            al.add(BigInteger.ZERO);
        }


        for (String s : inputList) {
            // int tempInt = Integer.parseInt(s);
            BigInteger tempBigInt = new BigInteger(s);
            al.set(tempBigInt.intValue(), al.get(tempBigInt.intValue()).add(BigInteger.ONE));
        }
        // Rotating the array with the arraylist. i.e [1,2,3] -> [2,3,1]  -> [3,1,2]
        // As they have asked for 80 days
        for (int i = 0; i < 256; i++) {
            BigInteger tempFish = al.remove(0);
            al.add(tempFish);
            al.set(6, al.get(6).add(tempFish));
        }

        // printing the sum of all the values in the arrayList
        BigInteger noOfFish = BigInteger.ZERO;
        for (BigInteger integer : al) {
            noOfFish = noOfFish.add(integer);
        }
        System.out.println("noOfFish = " + noOfFish);
    }
}
