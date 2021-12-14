package challenge5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PartTwo {
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
            // byte range : -127 to 128
            byte[] graph = new byte[1000 * 1000];
            // filling the byte array with 0s.
            Arrays.fill(graph, (byte)0);
            while(j<lineSegments.size()){
                String lineSegment = lineSegments.get(j);
                String[] xyValues = lineSegment.trim().split("\\s*->\\s*");
                String[] x1y1Values = xyValues[0].split(",");
                String[] x2y2Values = xyValues[1].split(",");
                int x1 = Integer.parseInt(x1y1Values[0]);
                int y1 = Integer.parseInt(x1y1Values[1]);
                int x2 = Integer.parseInt(x2y2Values[0]);
                int y2 = Integer.parseInt(x2y2Values[1]);
                if( x1 == x2){
                    for (int i = Math.min(y1,y2); i <= Math.max(y1,y2); i++) {
                        graph[1000 * i + x1]++;
                    }
                }
                else if(y1 == y2){
                    for (int i = Math.min(x1,x2); i <= Math.max(x1,x2) ; i++) {
                        graph[1000 * y1 + i]++;
                    }
                }
                else {
                    if (y1 < y2 && x1 < x2) {
                        for (int i = 0; i <= y2 - y1; i++) {
                            graph[1000 * (y1 + i) + (x1 + i)]++;
                        }
                    } else if (y1 > y2 && x1 > x2) {
                        for (int i = 0; i <= y1 - y2; i++) {
                            graph[1000 * (y1 - i) + (x1 - i)]++;
                        }
                    } else if (y1 < y2 && x1 > x2) {
                        for (int i = 0; i <= y2 - y1; i++) {
                            graph[1000 * (y1 + i) + (x1 - i)]++;
                        }
                    } else if (y1 > y2 && x1 < x2) {
                        for (int i = 0; i <= x2 - x1; i++) {
                            graph[1000 * (y1 - i) + (x1 + i)]++;
                        }
                    }
                }
                j++;
            }
            // counting the no. of times overlap we are getting
            int count = 0;
            for(byte b: graph){
                if(b > 1){
                    count++;
                }
            }
            System.out.println("count = " + count);
        }
    }

}
