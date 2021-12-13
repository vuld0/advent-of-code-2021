package challenge3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartOne {
   public static void main(String[] args) throws IOException {
       File myFile = new File("inputs/aoc-input-3.txt");
       ArrayList<String> inputList = new ArrayList<String>();
       Scanner sc;
       {
           try{
               sc = new Scanner(myFile);
               while(sc.hasNextLine()){
                   String st1 = sc.nextLine().toString();
                   inputList.add(st1);
               }
           } catch (FileNotFoundException e){
               e.printStackTrace();
           }
           // list for the gamma rate
           ArrayList<Integer> list2 = new ArrayList<Integer>();
           // list for the epsilon rate
           ArrayList<Integer> list3 = new ArrayList<Integer>();
           int sizeOfInputList = inputList.size();
           int j = 0;
           // looping through every character of the strings in the text (vertical-wise)
           while(j < 12) {
               int countOf0 = 0;
               int countOf1 = 0;
               // looping through each inputs
               for (int i = 0; i < sizeOfInputList; i++) {
                   String inputString = inputList.get(i);
                   if(inputString.charAt(j) == '0') countOf0++;
                   if(inputString.charAt(j) == '1') countOf1++;
               }
               if(countOf0 > countOf1){
                   list2.add(0);
                   list3.add(1);
               }
               else{
                   list2.add(1);
                   list3.add(0);
               }
               j++;
               }
           // converting binary into decimal
           int list2DecValue = 0;
           int list2Base = 1;
           for(int i=list2.size()-1;i>=0;i--){
               int tempInt = list2.get(i);
               list2DecValue += tempInt * list2Base;
               list2Base *= 2;
           }
           System.out.println(list2DecValue);
           // converting binary into decimal
           int list3DecValue = 0;
           int list3Base = 1;
           for(int i=list3.size()-1;i>=0;i--){
               int tempInt = list3.get(i);
               list3DecValue += tempInt * list3Base;
               list3Base *= 2;
           }
           System.out.println("list3DecValue = " + list3DecValue);
           System.out.println(list2DecValue*list3DecValue);
           }
       }
   }
