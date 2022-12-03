package org.lobster1234.aoc2022;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class Puzzle3Test extends TestCase {

    public void testValues(){
        assertEquals(new Puzzle3().getValueOf('A'), 27);
        assertEquals(new Puzzle3().getValueOf('a'), 1);
        assertEquals(new Puzzle3().getValueOf('Z'), 52);
        assertEquals(new Puzzle3().getValueOf('z'), 26);
    }

    public void testSumsIndividually(){
        List<String> list = new ArrayList<>();
        list.add("vJrwpWtwJgWrhcsFMMfFFhFp");
        assertEquals(new Puzzle3().getPrioritySum(list), 16);
        list.clear();
        list.add("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        assertEquals(new Puzzle3().getPrioritySum(list), 38);
        list.clear();
        list.add("PmmdzqPrVvPwwTWBwg");
        assertEquals(new Puzzle3().getPrioritySum(list), 42);
        list.clear();
        list.add("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        assertEquals(new Puzzle3().getPrioritySum(list), 22);
        list.clear();
        list.add("ttgJtRGJQctTZtZT");
        assertEquals(new Puzzle3().getPrioritySum(list), 20);
        list.clear();
        list.add("CrZsJsPPZsGzwwsLwLmpwMDw");
        assertEquals(new Puzzle3().getPrioritySum(list), 19);
    }

    public void testSum(){
        List<String> list = new ArrayList<>();
        list.add("vJrwpWtwJgWrhcsFMMfFFhFp");
        list.add("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL");
        list.add("PmmdzqPrVvPwwTWBwg");
        list.add("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn");
        list.add("ttgJtRGJQctTZtZT");
        list.add("CrZsJsPPZsGzwwsLwLmpwMDw");
        assertEquals(new Puzzle3().getPrioritySum(list), 157);
    }
}
