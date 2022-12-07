package org.lobster1234.aoc2022;

import junit.framework.TestCase;

public class Puzzle6Test extends TestCase {

    public void testFindMarker(){
        assertEquals(new Puzzle6().findMarker("mjqjpqmgbljsphdztnvjfqwrcgsmlb",4), 7);
        assertEquals(new Puzzle6().findMarker("bvwbjplbgvbhsrlpgdmjqwftvncz",4), 5);
        assertEquals(new Puzzle6().findMarker("nppdvjthqldpwncqszvftbrmjlhg",4), 6);
        assertEquals(new Puzzle6().findMarker("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg",4), 10);
        assertEquals(new Puzzle6().findMarker("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw",4), 11);

    }
}
