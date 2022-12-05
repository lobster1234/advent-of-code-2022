package org.lobster1234.aoc2022;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class Puzzle4Test extends TestCase {

    public void testIsOverlap(){
        Puzzle4 p = new Puzzle4();
        assertFalse(p.doesFullyOverlap(2,4,6,8));
        assertFalse(p.doesFullyOverlap(6,8,2,4));
        assertFalse(p.doesFullyOverlap(2,3,4,5));
        assertFalse(p.doesFullyOverlap(4,5,2,3));
        assertFalse(p.doesFullyOverlap(5,7,7,9));
        assertFalse(p.doesFullyOverlap(7,9,5,7));
        assertTrue(p.doesFullyOverlap(2,8,3,7));
        assertTrue(p.doesFullyOverlap(3,7,2,8));
        assertTrue(p.doesFullyOverlap(6,6,4,6));
        assertTrue(p.doesFullyOverlap(4,6,6,6));
        assertFalse(p.doesFullyOverlap(2,6,4,8));
        assertFalse(p.doesFullyOverlap(4,8,2,6));
    }

    public void testCountFullyOverlapingRanges(){
        List<String> list = new ArrayList<>();
        list.add("2-4,6-8");
        list.add("2-3,4-5");
        list.add("5-7,7-9");
        list.add("2-8,3-7");
        list.add("6-6,4-6");
        list.add("2-6,4-8");
        assertEquals(new Puzzle4().countFullyOverlapingRanges(list), 2);
    }
}
