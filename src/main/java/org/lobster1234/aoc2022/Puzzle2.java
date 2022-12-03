package org.lobster1234.aoc2022;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://adventofcode.com/2022/day/2">Day 2</a>
 */
public class Puzzle2 {

    final int WIN = 6;
    final int LOSS = 0;
    final int DRAW = 3;
    final int ROCK = 1;
    final int PAPER = 2;
    final int SCISSORS = 3;
    Map<String, Integer> firstMoveSet =  new HashMap<>();

    Map<String, Integer> secondMoveSet = new HashMap<>();

    public Puzzle2(){
        // we populate the first moveset
        firstMoveSet.put("A X", ROCK+DRAW);
        firstMoveSet.put("B Y", PAPER+DRAW);
        firstMoveSet.put("C Z", SCISSORS+DRAW);
        firstMoveSet.put("A Y", PAPER+WIN); //paper defeats rock
        firstMoveSet.put("B Z", SCISSORS+WIN); //scissors defeats paper
        firstMoveSet.put("C X", ROCK+WIN); //rock defeats scissors
        firstMoveSet.put("A Z", SCISSORS+LOSS);
        firstMoveSet.put("B X", ROCK+LOSS);
        firstMoveSet.put("C Y", PAPER+LOSS);
        //we populate the second moveset
        secondMoveSet.put("A Y", ROCK+DRAW);
        secondMoveSet.put("B Y", PAPER+DRAW);
        secondMoveSet.put("C Y", SCISSORS+DRAW);
        secondMoveSet.put("A X", SCISSORS+LOSS);
        secondMoveSet.put("B X", ROCK+LOSS);
        secondMoveSet.put("C X", PAPER+LOSS);
        secondMoveSet.put("A Z",PAPER+WIN);
        secondMoveSet.put("B Z",SCISSORS+WIN);
        secondMoveSet.put("C Z",ROCK+WIN);
    }


    public static void main(String[] args) {
        try {
            int scorePart1 = new Puzzle2().scorePart1("puzzle2_input.txt");
            System.out.printf("Part1 Score is %d\n", scorePart1);
            int scorePart2 = new Puzzle2().scorePart2("puzzle2_input.txt");
            System.out.printf("Part2 Score is %d\n", scorePart2);
        }catch(Exception e){
            System.out.printf("Exception : %s\n", e.getMessage());
        }
    }

    public int scorePart1(String file) throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource(file);
        if(url == null) throw new IOException("File not found " + file);
        BufferedReader reader = new BufferedReader(new FileReader(new File(url.toURI())));
        int score = 0;
        while(reader.ready()){
            String data = reader.readLine();
            if(firstMoveSet.containsKey(data)){
                score += firstMoveSet.get(data);
            }
        }
        return score;
    }

    public int scorePart2(String file) throws IOException, URISyntaxException {
        URL url = this.getClass().getClassLoader().getResource(file);
        if(url == null) throw new IOException("File not found " + file);
        BufferedReader reader = new BufferedReader(new FileReader(new File(url.toURI())));
        int score = 0;
        while(reader.ready()){
            String data = reader.readLine();
            if(secondMoveSet.containsKey(data)){
                score += secondMoveSet.get(data);
            }
        }
        return score;
    }

}
