/**
 * Tuan Nguyen
 * CS 210
 * 2/10/2019
 * Lab 5
 * TupleTest.java
 */

import java.util.*;
/**
 * The TupleTest class test if the Tuple class work properly
 * @author Tuan Nguyen
 * @since 2/5/2019
 */
public class TupleTest {

    /**
     * Create an array list for the purpose of testing in the voidTest() method
     * @return the arraylist with random size and random content
     */
    public static ArrayList<Comparable> createArray() {
        ArrayList<Comparable> arr = new ArrayList<Comparable>();
        Random ran = new Random();

        for (int i = 0; i < ran.nextInt(10); i++) {                     //Random the size of arraylist
            arr.add(ran.nextInt(100));                                  //Random the content of arraylist
        }
        return arr;
    }

    /**
     * Test out how a list of Tuple can do sorting and printing.
     * Print the list of Tuple both before sorted and after sorted
     */
    public static void sortTest() {
        Tuple[] arrtest = new Tuple[3];                             //Initialize the array with the size of 3
        for (int i = 0; i < arrtest.length; i++) {                  //for each element in array, create Tuple with random size and content
            arrtest[i] = new Tuple(createArray());
        }

        System.out.println("Not sorted: " + Arrays.toString(arrtest));
        Arrays.sort(arrtest);
        System.out.println("Sorted: " + Arrays.toString(arrtest));

    }
    /**
     * The main method for the TupleTest class
     */
    public static void main(String[] args) {
        //Check first tuple constructor
        Tuple tup1 = new Tuple();
        System.out.println("Size = " + tup1.size());
        
        //Check second tuple constructor
        String[] element = new String[] {"5", "6", "7"};
        Tuple tup2 = new Tuple(element);
        System.out.println("Size = " + tup2.size());
        System.out.println("Get index at 2: " + tup2.get(1));

        //Check third tuple constructor
       ArrayList<Comparable> arr = new ArrayList<Comparable>(); 
       arr.add(5);
       arr.add(4);
       arr.add(3);
       Tuple tup3 = new Tuple(arr);
       System.out.println("Size = " + tup3.size());
       System.out.println("Get index at 2: " + tup3.get(1));

       //Check compareTo() with 2nd constructor;
       Integer[] compare1 = new Integer[] {5, 6, 3, 1};
       Integer[] compare2 = new Integer[] {5, 7, 3, 1};
       Tuple tupcom1 = new Tuple(compare1);
       Tuple tupcom2 = new Tuple(compare2);
       System.out.println("Compare: " + tupcom1.compareTo(tupcom2));

       //check compareTo() with 3rd constructor;
       ArrayList<Comparable> arr2 = new ArrayList<Comparable>();
       arr2.add(5);
       arr2.add(4);
       Tuple tup4 = new Tuple(arr2);
       System.out.println("Compare2: " + tup3.compareTo(tup4));

       sortTest();
    }
}