package com.m3c.wgk;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Hello world!
 *
 */
public class  App {

    private static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    private static Logger log = Logger.getLogger(App.class.getName());

    public static void main( String[] args ) {
        initialiseLogging();
        int[] elements = {7, 3, 12, 12, 12, 5, 6, 4, 18, 12, 4};
        BinaryTreeSearch tree = new BinaryTreeSearch(elements);
        tree.addElement(20);
        System.out.println("ROOT: " + tree.getRootElement());
        System.out.println("NO OF ELEMENT: " + tree.getNumberOfElements());
        System.out.println("FIND: " + tree.findElement(12));
        System.out.println("LEFT: " + tree.getLeftChild(7));
        System.out.println("RIGHT: " + tree.getRightChild(7));
        System.out.println("SORT ASC: " + tree.getSortedTreeAsc());
        System.out.println("SORT DESC: " + tree.getSortedTreeDesc());
    }

    public static void initialiseLogging() {
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.info("Logging initialised");
    }
}
