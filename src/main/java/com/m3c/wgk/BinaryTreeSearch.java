package com.m3c.wgk;

import com.sun.org.apache.bcel.internal.generic.DUP;

import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Spliterator;

import org.apache.log4j.Logger;

/**
 * Created by alumniCurie16 on 11/10/2017.
 */
public class BinaryTreeSearch implements BinaryTree {

    private Node rootNode;
    private Node selectedNode;
    private long counter = 0;
    private List<Integer> listAsc = new ArrayList();
    private Logger log = Logger.getLogger(BinaryTreeSearch.class.getName());

    public BinaryTreeSearch() {
        this.rootNode = null;
    }

    public BinaryTreeSearch(int element) {
            addElement(element);
    }

    public BinaryTreeSearch(int[] elements)  {
            addElements(elements);
    }


    public int getRootElement() {
        return rootNode.getData();
    }

    public int getNumberOfElements() {
        return (int)counter;
    }

    public void addElement(int element) {
        log.debug("adding element: " + element + " to the list");
        Node newNode = new Node(element);
        if(rootNode == null) {
            rootNode = newNode;
            log.debug("ROOT NODE: " + rootNode);
            counter++;
            return;
        }

        Node currentNode = rootNode;
        Node parentNode = null;

        while(true){
            parentNode = currentNode;
            if(element < currentNode.getData()){
                currentNode = currentNode.getLeft();
                if(currentNode == null){
                    parentNode.setLeft(newNode);
                    counter++;
                    return;
                }
            } else if (element > currentNode.getData()){
                currentNode = currentNode.getRight();
                if(currentNode == null){
                    parentNode.setRight(newNode);
                    counter++;
                    return;
                }
            } else {
                if(findElement(element) == element) {
                    try {
                        throw new DuplicateException(element);
                    } catch (DuplicateException e) {
                        e.printError();
                        log.error("Duplicate Exception");
                    } finally {
                        break;
                    }
                }
            }
        }
    }
    
    public void addElements(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            addElement(elements[i]);
        }
    }

    public int findElement(int value) {
        log.debug("looking for element: " + value);
        selectedNode = rootNode;
        while(selectedNode != null) {
            if(selectedNode.getData() == value) {
                return value;
            }
            else if(selectedNode.getData() > value)
                selectedNode = selectedNode.getLeft();
            else {
                selectedNode = selectedNode.getRight();
            }
        }

        return selectedNode.getData();
    }

    public int getLeftChild(int element) {
        findElement(element);
        return selectedNode.getLeft().getData();
    }

    public int getRightChild(int element) {
        findElement(element);
        return selectedNode.getRight().getData();
    }

    private void sortAsc(Node node) {
        if(node != null) {
            sortAsc(node.getLeft());
            listAsc.add(node.getData());
            sortAsc(node.getRight());
        }
    }

    public List<Integer> getSortedTreeAsc() {
        sortAsc(rootNode);
        return listAsc;
    }

    public List<Integer> getSortedTreeDesc() {
       listAsc = new ArrayList();
        Collections.reverse(getSortedTreeAsc());
       return listAsc;

    }


}
