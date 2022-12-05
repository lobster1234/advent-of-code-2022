package org.lobster1234.aoc2022;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * <a href="https://adventofcode.com/2022/day/4">Day 4</a>
 */
public class Puzzle4 {


    public static void main(String[] args) {
        List<String> list = new Puzzle4().readFile("puzzle4_input.txt");
        System.out.println("Fully overlaping ranges are " + new Puzzle4().countFullyOverlapingRanges(list));
    }
    public List<String> readFile(String file){
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(this.getClass().getClassLoader().getResource(file).toURI())))){
            return reader.lines().toList();
        }catch(Exception e){
            System.out.println("Exception " + e.getMessage());
            return List.of();
        }
    }

    public int countFullyOverlapingRanges(List<String> pairs){
        int count = 0;
        for(String pair : pairs){
            String[] arr = pair.trim().split(",");
            int a = Integer.parseInt(arr[0].split("-")[0]);
            int b = Integer.parseInt(arr[0].split("-")[1]);
            int c = Integer.parseInt(arr[1].split("-")[0]);
            int d = Integer.parseInt(arr[1].split("-")[1]);
            if(doesFullyOverlap(a,b,c,d)) ++count;
        }
        return count;
    }
    public boolean doesFullyOverlap(int a, int b, int c, int d){
        return (c >= a && d <=b) || (c <=a && d >=b);
    }

}
