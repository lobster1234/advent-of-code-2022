package org.lobster1234.aoc2022;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://adventofcode.com/2022/day/1">Day 1</a>
 */
public class Puzzle1 {

    /**
     * 1. Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
     * 2. Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
     * We read the file sequentially and keep a max_so_far and update it if we find a new max
     */

    public static void main(String[] args) {
        try {
            int max_calories = new Puzzle1().maxCalories("puzzle1_input.txt");
            System.out.printf("Most calories carried by any elf is %d", max_calories);
            int topThree = new Puzzle1().sumTopThree("puzzle1_input.txt");
            System.out.printf("The top three elves have %d calories", topThree);

        }catch(Exception e){
            System.out.printf("Exception : %s", e.getMessage());
        }
    }

    public int maxCalories(String file) throws URISyntaxException, IOException {
        int max = Integer.MIN_VALUE;
        int localMax = Integer.MIN_VALUE;
        URL resource = Puzzle1.class.getClassLoader().getResource(file);
        if(resource == null) throw new FileNotFoundException("Could not locate file");
        BufferedReader reader = new BufferedReader(new FileReader(new File(resource.toURI())));
        while(reader.ready()){
            String data = reader.readLine();
            if(data.trim().length() == 0){
                if(localMax > max ) max = localMax;
                localMax = 0;
            }else{
                localMax += Integer.parseInt(data);
            }
        }
        return max;
    }

    public int sumTopThree(String file) throws URISyntaxException, IOException{
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        URL resource = Puzzle1.class.getClassLoader().getResource(file);
        if(resource == null) throw new FileNotFoundException("Could not locate file");
        BufferedReader reader = new BufferedReader(new FileReader(new File(resource.toURI())));
        while(reader.ready()){
            String data = reader.readLine();
            if(data.trim().length() == 0){
                list.add(sum);
                sum = 0;
            }else{
                sum += Integer.parseInt(data);
            }
        }
        Collections.sort(list);
        return list.get(list.size()-1) + list.get(list.size()-2) + list.get(list.size()-3);
    }
}
