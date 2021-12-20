package challenge14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PartOne {
    public static void main(String[] args) {
        File myFile = new File("inputs/aoc-input-14.txt");
        ArrayList<String> inputs = new ArrayList<>();
        Scanner sc;
        {
            try {
                sc = new Scanner(myFile);
                while(sc.hasNextLine()){
                    String tempStrings = sc.nextLine();
                    inputs.add(tempStrings);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        String polymerTemplate = inputs.get(0);
        // piecing the pair insertion rules together
        Map<String,String> pairInsertionRules = new HashMap<>();
        int j = 2;
        while(j<inputs.size()){
            String[] tempList = inputs.get(j).split(" -> ");
            pairInsertionRules.put(tempList[0], tempList[1]);
            j++;
        }
        for (int k = 0; k < 10; k++) {
            StringBuilder resultString = new StringBuilder();
            // adding the insertionPairRules to the string resulting in "resultString"
            for (int i = 0; i < polymerTemplate.length() - 1; i++) {
                String pair = polymerTemplate.substring(i, i + 2);
                String ruleValue = pairInsertionRules.get(pair);
                resultString.append(polymerTemplate.charAt(i));
                if (ruleValue != null) {
                    resultString.append(ruleValue);
                }
            }
            // as the last character was not added
            resultString.append(polymerTemplate.substring(polymerTemplate.length() - 1));
            polymerTemplate = resultString.toString();
        }

        // counting the sequences
        System.out.println(polymerTemplate);
        Map<String, Integer> sequenceMap = new HashMap<>();
        for (int i = 0; i < polymerTemplate.length(); i++) {
            String find = polymerTemplate.substring(i, i+1);
            if(!sequenceMap.containsKey(find)){
                sequenceMap.put(find,0);
            }
            sequenceMap.put(find, sequenceMap.get(find)+1);
        }

        for (String name: sequenceMap.keySet()) {
            String value = sequenceMap.get(name).toString();
            System.out.println(name + " " + value);
        }

        List<Integer> values = new ArrayList<>(sequenceMap.values());
        Collections.sort(values);

        System.out.println(values.get(values.size()-1) - values.get(0));
    }
}