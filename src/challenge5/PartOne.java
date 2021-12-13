package challenge5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {
    public static void main(String[] args){
        File myFile = new File("inputs/aoc-input-5.txt");
        ArrayList<String> lineSegments = new ArrayList<>();
        Scanner sc;
        {
            try{
                sc = new Scanner(myFile);
                while(sc.hasNextLine()){
                    String lineSegment = sc.nextLine();
                    lineSegments.add(lineSegment);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            int j = 0;
            while(j<lineSegments.size()){
                String lineSegment = lineSegments.get(j);
                String[] xyValues = lineSegment.trim().split("\\s*->\\s*");
                String[] x1y1Values = xyValues[0].split(",");
                String[] x2y2Values = xyValues[1].split(",");
                int x1 = Integer.parseInt(x1y1Values[0]);
                int y1 = Integer.parseInt(x1y1Values[1]);
                int x2 = Integer.parseInt(x2y2Values[0]);
                int y2 = Integer.parseInt(x2y2Values[1]);
                j++;
            }
        }
    }

}
