package org.lobster1234.aoc2022;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://adventofcode.com/2022/day/6">Day 6 : Tuning Trouble</a>
 */
public class Puzzle6 {

    public static void main(String[] args) {
        String input = Utils.readFile("puzzle6_input.txt").get(0);
        System.out.println(new Puzzle6().findMarker(input,4));
    }

    public int findMarker(String buffer, int size){
        for(int i=0;i<buffer.length()-size;i++){
            String sub = buffer.substring(i, i+size);
            Set<Character> set = new HashSet<>();
            sub.chars().forEach( c -> set.add((char) c));
            if(set.size()==4) return i+size;
        }
        return -1;
    }

}
