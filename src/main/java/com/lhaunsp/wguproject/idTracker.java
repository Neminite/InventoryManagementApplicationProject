package com.lhaunsp.wguproject;

/**
 * Simple Class for tracking what id to assign to new objects
 *
 * @author Lucas Haunsperger
 */
public class idTracker {
    private static int curPartID = -1;
    private static int curProdID = -1;

    /**
     * Increment and return Part ID
     *
     * @return Next Part ID
     */
    public static int getNextPartID() {
        curPartID++;
        return curPartID;
    }

    /**
     * Increment and return Product ID
     *
     * @return Next Part ID
     */
    public static int getNextProdID() {
        curProdID++;
        return curProdID;
    }
}
