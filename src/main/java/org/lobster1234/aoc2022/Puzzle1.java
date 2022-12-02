package org.lobster1234.aoc2022;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * <a href="https://adventofcode.com/2022/day/1">Day 1</a>
 */
public class Puzzle1 {

    /**
     * Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
     * We read the file sequentially and keep a max_so_far and update it if we find a new max
     */

    public static void main(String[] args) {
        try {
            int max_calories = new Puzzle1().maxCalories("puzzle1_input.txt");
            System.out.printf("Most calories carried by any elf is %d", max_calories);
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
}
