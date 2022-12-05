package org.lobster1234.aoc2022;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

/**
 * <a href="https://adventofcode.com/2022/day/3">Day 3</a>
 */
public class Puzzle3 {

    public static void main(String[] args) {
        List<String> list = new Puzzle3().readFile("puzzle3_input.txt");
        System.out.println("Priority sum is " + new Puzzle3().getPrioritySum(list));
        System.out.println("Badge sum is " + new Puzzle3().getBadgeSum(list));
    }

    public List<String> readFile(String file){
        try(BufferedReader reader = new BufferedReader(new FileReader(new File(this.getClass().getClassLoader().getResource(file).toURI())))){
            return reader.lines().toList();
        }catch(Exception e){
            System.out.println("Exception " + e.getMessage());
            return List.of();
        }
    }

    public int getPrioritySum(List<String> strings){
        int sum = 0;
        for(String s: strings){
            //split the string right in the middle
            String part1 = s.substring(0, s.length()/2);
            String part2 = s.substring(s.length()/2);
            Set<Character> first = new HashSet<>();
            part1.chars().forEach(c -> first.add((char)c));
            char common = (char) part2.chars().filter(c-> first.contains((char) c)).findFirst().orElse(0);
            if(common!=0) {
                sum += getValueOf(common);
            }
        }
        return sum;
    }

    public int getBadgeSum(List<String> strings){
        int sum = 0;
        for(int i=0;i<strings.size();i+=3){
            List<String> sublist = strings.subList(i,i+3);
            char c = findCommon(sublist);
            if(c != ' ')
                sum+= getValueOf(c);
        }
        return sum;
    }



    public char findCommon(List<String> strings){
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        Set<Character> set3 = new HashSet<>();
        strings.get(0).chars().forEach( c -> set1.add((char) c));
        strings.get(1).chars().forEach( c -> set2.add((char) c));
        strings.get(2).chars().forEach( c -> set3.add((char) c));
        set1.retainAll(set2);
        set1.retainAll(set3);
        return set1.stream().findFirst().orElse(' ');
    }
    public int getValueOf(char c){
        if(Character.isUpperCase(c)){
            return c-'A'+27;
        }else return c -'a'+1;
    }

}
