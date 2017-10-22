package com.m3c.wgk;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by alumniCurie16 on 11/10/2017.
 */
public class BinaryTest {

    private BinaryTreeSearch tree;

    @Before
    public void init(){
        tree = new BinaryTreeSearch();
    }

    @Test
    public void testRootElement() {
        int[] test = {7, 3, 12, 5, 6, 4, 18};
        tree.addElements(test);
        int outcome;
        outcome = tree.getRootElement();
        Assert.assertEquals(7, outcome);
    }

    @Test
    public void ascTreeTest() {
        int[] test = {7, 3, 12, 5, 6, 4, 18};
        Arrays.sort(test);
        tree.addElements(test);
        List<Integer> actual = new ArrayList<Integer>(tree.getSortedTreeAsc());
        List<Integer> expected = new ArrayList<Integer>();
        for (int aTest : test) {
            expected.add(aTest);
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void descTreeTest() {
        int[] test = {7, 3, 12, 5, 6, 4, 18};
        Arrays.sort(test);
        tree.addElements(test);
        List<Integer> actual = new ArrayList<Integer>(tree.getSortedTreeDesc());
        List<Integer> expected = new ArrayList<Integer>();
        for (int aTest : test) {
            expected.add(aTest);
        }
        Collections.reverse(expected);
        System.out.println("ACTUAL: " + actual);
        System.out.println("ACTUAL: " + expected);
        Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown()
    {
        tree = null;
    }


}
