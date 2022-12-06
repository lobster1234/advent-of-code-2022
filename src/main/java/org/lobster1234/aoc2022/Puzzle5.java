package org.lobster1234.aoc2022;

import java.util.*;

/**
 * <a href="https://adventofcode.com/2022/day/5">Day 5</a>
 */
public class Puzzle5 {

    private final List<Stack<Character>> supplyStacks = new ArrayList<>();

    public static void main(String[] args) {
        /*
         *         [J]         [B]     [T]
         *         [M] [L]     [Q] [L] [R]
         *         [G] [Q]     [W] [S] [B] [L]
         * [D]     [D] [T]     [M] [G] [V] [P]
         * [T]     [N] [N] [N] [D] [J] [G] [N]
         * [W] [H] [H] [S] [C] [N] [R] [W] [D]
         * [N] [P] [P] [W] [H] [H] [B] [N] [G]
         * [L] [C] [W] [C] [P] [T] [M] [Z] [W]
         *  1   2   3   4   5   6   7   8   9
         */
        List<String> stackElements = new ArrayList<>();
        stackElements.add("LNWTD");
        stackElements.add("CPH");
        stackElements.add("WPHNDGMJ");
        stackElements.add("CWSNTQL");
        stackElements.add("PHCN");
        stackElements.add("THNDMWQB");
        stackElements.add("MBRJGSL");
        stackElements.add("ZNWGVBRT");
        stackElements.add("WGDNPL");
        Puzzle5 p = new Puzzle5(stackElements);
        //next we read the moves from the file
        List<String> input = Utils.readFile("puzzle5_input.txt");
        List<MoveOperation> moves = p.parseMoveOperations(input);
        p.perform9001(moves);
        System.out.println("Top of the stacks string is " + p.topsOfStacks());
    }

    public Puzzle5(List<String> supplyStacksAsStrings){
        setSupplyStacks(supplyStacksAsStrings);
    }

    public void setSupplyStacks(List<String> supplyStacksAsStrings){
        for(String string: supplyStacksAsStrings){
            Stack<Character> stack = new Stack<>();
            string.chars().forEach( c -> stack.push((char) c));
            supplyStacks.add(stack);
        }
    }

    public List<Stack<Character>> getSupplyStacks(){
        return supplyStacks;
    }

    public List<MoveOperation> parseMoveOperations(List<String> moves){
        List<MoveOperation> ops = new ArrayList<>();
        moves.forEach(line ->{
            if(line.trim().startsWith("move")){
                String[] arr = line.split(" ");
                MoveOperation op = new MoveOperation(Integer.parseInt(arr[1]),Integer.parseInt(arr[3]),Integer.parseInt(arr[5]));
                ops.add(op);
            }
        });
        return ops;
    }

    public void perform(List<MoveOperation> operations){
        operations.forEach(operation -> {
            Stack<Character> source = supplyStacks.get(operation.from()-1);
            Stack<Character> destination = supplyStacks.get(operation.to()-1);
            for(int i=0;i<operation.count();i++){
                destination.push(source.pop());
            }
        });
    }

    public void perform9001(List<MoveOperation> operations){
        operations.forEach(operation -> {
            Stack<Character> source = supplyStacks.get(operation.from()-1);
            Stack<Character> destination = supplyStacks.get(operation.to()-1);
            Deque<Character> deq = new ArrayDeque<>();
            for(int i=0;i<operation.count();i++){
                deq.addFirst(source.pop());
            }
            while(!deq.isEmpty()){
                destination.push(deq.removeFirst());
            }
        });
    }
    public String topsOfStacks(){
        StringBuilder sb = new StringBuilder();
        supplyStacks.forEach(s -> sb.append(s.peek()));
        return sb.toString();
    }
}

record MoveOperation(int count, int from, int to){}