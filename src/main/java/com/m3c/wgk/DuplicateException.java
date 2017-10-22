package com.m3c.wgk;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by alumniCurie16 on 12/10/2017.
 */
public class DuplicateException extends Exception {

    private int element;

    public DuplicateException(int element) {
        this.element = element;
    }

    public void printError() {
        System.out.println("Duplicate element: " + element);
    }
}