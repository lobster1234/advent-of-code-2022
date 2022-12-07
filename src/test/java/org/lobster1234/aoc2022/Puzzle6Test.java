package org.lobster1234.aoc2022;

import junit.framework.TestCase;

public class Puzzle6Test extends TestCase {

    public void testFindMarker1(){
        assertEquals(Puzzle6.findMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb",4), 7);
        assertEquals(Puzzle6.findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz",4), 5);
        assertEquals(Puzzle6.findMarker("nppdvjthqldpwncqszvftbrmjlhg",4), 6);
        assertEquals(Puzzle6.findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",4), 10);
        assertEquals(Puzzle6.findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw",4), 11);
    }

    public void testFindMarker2(){
        assertEquals(Puzzle6.findMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb",14), 19);
        assertEquals(Puzzle6.findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz",14), 23);
        assertEquals(Puzzle6.findMarker("nppdvjthqldpwncqszvftbrmjlhg",14), 23);
        assertEquals(Puzzle6.findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",14), 29);
        assertEquals(Puzzle6.findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw",14), 26);
    }

}
