package com.m3c.wgk;

import org.apache.log4j.Logger;

/**
 * Created by alumniCurie16 on 11/10/2017.
 */
public class Node {

    public int getData() {
        return data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    private Node left;
    private Node right;
    private final int data;
    private Logger log = Logger.getLogger(BinaryTreeSearch.class.getName());

        public Node(int data) {
            log.debug("Node Created: " + data);
            this.data = data;
        }
}
