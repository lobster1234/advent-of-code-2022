package org.lobster1234.aoc2022;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class Puzzle5Test extends TestCase {

    Puzzle5 p;

    @Override
    public void setUp(){
        /*
         *     [D]
         * [N] [C]
         * [Z] [M] [P]
         *  1   2   3
         */
        List<String> stackElements = new ArrayList<>();
        stackElements.add("ZN");
        stackElements.add("MCD");
        stackElements.add("P");
        p = new Puzzle5(stackElements);
    }

    public void testMoveOperations(){
        List<MoveOperation> ops = new ArrayList<>();
        MoveOperation op1 = new MoveOperation(1,2,1);
        MoveOperation op2 = new MoveOperation(3,1,3);
        MoveOperation op3 = new MoveOperation(2,2,1);
        MoveOperation op4 = new MoveOperation(1,1,2);
        ops.add(op1);
        ops.add(op2);
        ops.add(op3);
        ops.add(op4);
        p.perform(ops);
        assertEquals((char) p.getSupplyStacks().get(0).peek(),'C');
        assertEquals((char) p.getSupplyStacks().get(1).peek(),'M');
        assertEquals((char) p.getSupplyStacks().get(2).peek(),'Z');
        assertEquals(p.topsOfStacks(), "CMZ");
    }

}
