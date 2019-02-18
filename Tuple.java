/**
 * Tuan Nguyen
 * CS 210
 * 2/10/2019
 * Lab 5
 * Tuple.java
 */
import java.util.*;
/**
 * The tuple class implement a rough equivalent to Python's tuple structure
 * @author Tuan Nguyen
 * @since 2/5/2019
 */
public class Tuple extends AbstractList<Comparable> implements Comparable<Tuple> {

    protected Comparable[] tuple;

    /**
     * Constructor of the Tuple class with no argument
     */
    public Tuple() {
        tuple = new Comparable[] {} ;
    }

    /**
     * Constructor of the Tuple class with one argument
     * @param tuple2 Array of Comparable
     */
    public Tuple(Comparable[] tuple2) {
        if (tuple2.equals(null)) {
            throw new NullPointerException("Tuple is null");
        }
        this.tuple = tuple2.clone();
    }

    /**
     * Constructor of the Tuple class for collection constructor
     * @param collection collection constructor
     */
    public Tuple(Collection<Comparable> collection) {
        if (collection.equals(null)) {
            throw new NullPointerException("Tuple is null");
        }
        int i = 0;
        this.tuple = new Comparable[collection.size()];
        for (Comparable var : collection) {
            this.tuple[i] = var;
            i += 1;
        } 
    }
    /**
     * Implement method for finding the length of the tuple
     * @return length of the tuple
     */
    public int size() {
        return this.tuple.length;
    }
    /**
     * Get the index of the tuple at some specific position
     * @param index The position of that tuple
     * @return value of the tuple at that position
     */
    public Comparable get(int index) {
        if (index >= this.tuple.length) {
            throw new IndexOutOfBoundsException("invalid index");
        }
        return this.tuple[index];
    }
    /**
     * Check the value from the compareTo() method and return specific values
     * @param value the value from the compareTo() method
     * @return 1 or -1 if the value from the compareTo() method is positive or negative
     */
    protected int compareReturn(int value) {
        if (value > 0) {
            return 1;
        } else {
            return -1;
        }
    }
    /**
     * compare 2 Tuple and return whether the first one is greater, smaller, or equal to the second one
     * @param tuple2 the second tuple
     * @return 1 if the first one is greater, -1 if the first one is smaller, and 0 if two Tuple are equal
     */
    @Override
    public int compareTo(Tuple tuple2){
        if (this.tuple.equals(null) || tuple2.equals(null)) {                       //Either of tuple has null value
            throw new NullPointerException("One of two tuple has a null value");
        //Check if different type (String vs Integer)
        } else if((this.tuple.length != 0) && (tuple2.size() != 0)) {
            if (this.tuple[0].getClass() != tuple2.get(0).getClass()) {
                throw new ClassCastException("Not the same type");
            }
        }
          
        //Compare each character of each tuple
        if (this.tuple.length < tuple2.size()) {
            for (int i = 0; i < this.tuple.length; i++) {
                if (this.tuple[i].compareTo(tuple2.get(i)) != 0) {
                    return compareReturn(this.tuple[i].compareTo(tuple2.get(i)));
                }
            }
        } else if (this.tuple.length > tuple2.size()) {
            for (int i = 0; i < tuple2.size(); i++) {
                if (this.tuple[i].compareTo(tuple2.get(i)) != 0) {
                    return compareReturn(this.tuple[i].compareTo(tuple2.get(i)));
                }
            }
        } else {
            for (int i = 0; i < tuple2.size(); i++) {
                if (this.tuple[i].compareTo(tuple2.get(i)) != 0) {
                    return compareReturn(this.tuple[i].compareTo(tuple2.get(i)));
                }
            }
        }
        //Compare the length
        if (this.tuple.length < tuple2.size()) {
            return -1;
        } else if (this.tuple.length > tuple2.size()) {
            return 1;
        }
        
        //Two tuple are equal
        return 0;

    }
    /**
     * toString() method
     * @return the tuple with parentheses
     */
    public String toString() {
        if (this.tuple.equals(null)) {
            throw new NullPointerException("No element to print out");
        }

        //No value in the tuple
        if (this.tuple.length == 0) {
            return "()";
        }

        //has value in the tuple
        String str = "(";
        for (int i = 0; i < this.tuple.length - 1; i++) {
            str += this.tuple[i] + ", ";
        }
        str += this.tuple[this.tuple.length - 1] + ")";
        return str;
    }
}
