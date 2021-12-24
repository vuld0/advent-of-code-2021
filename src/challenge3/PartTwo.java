package challenge3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class PartTwo {
    // counting elements left in the list
    public static int countFrequencies(ArrayList<String> list){
        int count = 0;
        for (String tempString: list) {
            if(tempString != null){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        File myFile = new File("inputs/aoc-input-3.txt");
        ArrayList<String> inputList = new ArrayList<>();
        Scanner sc;
        {
            try {
                sc = new Scanner(myFile);
                while (sc.hasNextLine()) {
                    String st1 = sc.nextLine();
                    inputList.add(st1);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        // for getting CO scrubber rating
        ArrayList<String> COScrubberRates = new ArrayList<>(inputList);
        int sizeOfElementInTheList = inputList.get(0).length();
        for (int i = 0; i < sizeOfElementInTheList; i++) {
            int countOf0 = 0;
            int countOf1 = 0;
            int countOf0CO = 0;
            int countOf1CO = 0;
            for (String j: inputList) {
                if(j == null) continue;
                if(j.charAt(i) == '0') countOf0++;
                if(j.charAt(i) == '1') countOf1++;
            }
            for (String j: COScrubberRates) {
                if(j == null) continue;
                if(j.charAt(i) == '0') countOf0CO++;
                if(j.charAt(i) == '1') countOf1CO++;
            }
            if(countOf0 > countOf1 && countFrequencies(inputList)!=1) {
                if(countFrequencies(inputList) == 1){
                    continue;
                }

                for (int k = 0; k < inputList.size(); k++) {
                    if (inputList.get(k) != null) {
                        if (inputList.get(k).charAt(i) == '1') {
                            inputList.set(k, null);
                        }
                    }
                }
            }
            // CO scrubber rating
            if(countOf0CO > countOf1CO && countFrequencies(COScrubberRates)!= 1) {

                for (int k = 0; k < COScrubberRates.size(); k++) {
                    if (COScrubberRates.get(k) != null) {
                        if (COScrubberRates.get(k).charAt(i) == '0') {
                            COScrubberRates.set(k, null);
                        }
                    }
                }
            }
            if(countOf1 > countOf0 && countFrequencies(inputList)!=1){
                if(countFrequencies(inputList) == 1){
                    continue;
                }

                for (int k = 0; k < inputList.size(); k++) {
                    if(inputList.get(k)!= null){
                        if (inputList.get(k).charAt(i) == '0') {
                            inputList.set(k, null);
                        }
                    }
                }
            }
            if(countOf1CO > countOf0CO && countFrequencies(COScrubberRates)!= 1){
                // CO scrubber rating
                if(countFrequencies(COScrubberRates) == 1){
                    continue;
                }

                for (int k = 0; k < COScrubberRates.size(); k++){
                    if(COScrubberRates.get(k)!=null){
                        if(COScrubberRates.get(k).charAt(i) == '1'){
                            COScrubberRates.set(k, null);
                        }
                    }
                }
            }

            if(countOf1 == countOf0 && countFrequencies(inputList)!=1){
                if(countFrequencies(inputList) == 1){
                    continue;
                }

                for (int k = 0; k < inputList.size(); k++) {
                    if(inputList.get(k)!=null){
                        if (inputList.get(k).charAt(i) == '0') {
                            inputList.set(k, null);
                        }
                    }
                }
        }
            if(countOf0CO == countOf1CO && countFrequencies(COScrubberRates)!= 1) {
                //CO scrubber rating
                if (countFrequencies(COScrubberRates) == 1) {
                    continue;
                }

                for (int k = 0; k < COScrubberRates.size(); k++) {
                    if (COScrubberRates.get(k) != null) {
                        if (COScrubberRates.get(k).charAt(i) == '1') {
                            COScrubberRates.set(k, null);
                        }
                    }
                }
            }
        }

        String binOxygenGenRating = null;
        String binCOGenRating = null;
        for (String s : inputList) {
            if (s != null) {
                binOxygenGenRating = s;
            }
        }
        
        // CO scrubber rating
        for (String coScrubberRate : COScrubberRates) {
            if (coScrubberRate != null) {
                binCOGenRating = coScrubberRate;
            }
        }
        // converting string binary to decimal
        int oxygenGenRating = 0;
        int oxygenGenRatingBase = 1;
        assert binOxygenGenRating != null;
        for(int i = binOxygenGenRating.length()-1; i>=0; i--){
            int tempInt = Integer.parseInt(String.valueOf(binOxygenGenRating.charAt(i)));
            oxygenGenRating += tempInt * oxygenGenRatingBase;
            oxygenGenRatingBase *= 2;
        }

        // converting string binary to decimal
        int COGenRating = 0;
        int COGenRatingBase = 1;
        assert binCOGenRating != null;
        for(int i = binCOGenRating.length()-1; i>=0; i--){
            int tempInt = Integer.parseInt(String.valueOf(binCOGenRating.charAt(i)));
            COGenRating += tempInt * COGenRatingBase;
            COGenRatingBase *= 2;
        }
        System.out.println("Ans = " + COGenRating * oxygenGenRating);
        

    }
}