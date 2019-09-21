////////////////////ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Data Structures
// Files:           DS_My.java, DataStructureADTTest.java,
// Course:          CS300, Fall 2018
//
// Author:          Stephen Fan
// Email:           sfan54@wisc.edu
// Lecturer's Name: Deb Deppeler
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
//Students who get help from sources other than their partner must fully 
//acknowledge and credit those sources of help here.  Instructors and TAs do 
//not need to be credited here, but tutors, friends, relatives, room mates, 
//strangers, and others do.  If you received no outside help from either type
//of source, then please explicitly indicate NONE.
//
// Persons:         NONE
// Online Sources:  https://docs.oracle.com/javase/7/docs/api/
// used the above website for documentation in researching for the documentation in how to use some functions
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

/**
 * My Data Structure class that holds key/value pairs using parallel arrays
 * @author Stephen Fan
 *
 */
public class DS_My implements DataStructureADT {

    // TODO may wish to define an inner class 
    // for storing key and value as a pair
    // such a class and its members should be "private"

    // Private Fields of the class
	private int capacity;
	private Object[] valueArray;
	private Comparable[] keyArray;
	private int size;
    
	/**
	 * Constructor for class DS_My
	 */
    public DS_My() {
        // initialize variables
    	capacity = 500;
    	valueArray = new Object[capacity];
    	keyArray = new Comparable[capacity];
    	size = 0;
    }

    /**
     * Insert method that inserts a key/value pair
     * @param k is the key to be inserted
     * @param v is the value to be inserted
     * @throws IllegalArgumentException if key is null or duplicate
     */
    @Override
    public void insert(Comparable k, Object v) {
        // copies both arrays into new larger arrays so capacity size is increased
        if (size >= capacity - 1) {
        	capacity += 100;
        	
        	// create new arrays with larger capacity
        	Comparable[] keyArray2 = new Comparable[capacity];
    		Object[] valueArray2 = new Object[capacity];
    		
    		//copy old array to larger array
        	for (int i = 0; i < size; i++) {
        		keyArray2[i] = keyArray[i];
        		valueArray2[i] = valueArray[i];
        	}
        	
        	// set larger array to old array variable
        	keyArray = keyArray2;
        	valueArray = valueArray2;
        }
        
        // check that key is not null and throw exception if it is
        if (k == null) {
        	throw new IllegalArgumentException("Key cannot be null");
        }
        // check that key is not duplicate and throw exception if it is
        for (int i = 0; i < size; i++) {
        	if (keyArray[i].compareTo(k) == 0) {
        		throw new IllegalArgumentException("Key cannot be a duplicate of another key");
        	}
        }
        
        // inserts key and value into arrays
        keyArray[size] = k;
        valueArray[size] = v;
        
        //increment size
        size++;
    }

    /**
     * Remove method that removes a key/value pair from the arrays
     * @param k is the key to be removed
     * @throws IllegalArgumentException if key is null
     */
    @Override
    public boolean remove(Comparable k) {
        // throws exception if key is null
    	if (k == null) {
    		throw new IllegalArgumentException("Key cannot be null");
    	}
    	
    	boolean removed = false;
    	
    	for (int i = 0; i < size; i++) {
    		if (keyArray[i].compareTo(k) == 0) {
    			// removes key/value pair from list if found
    			keyArray[i] = null;
    			valueArray[i] = null;
    			
    			// shifts all other values in both arrays over
    			for (int j = i; j < size-1; j++) {
    				keyArray[j] = keyArray[j+1];
    				valueArray[j] = valueArray[j+1];
    			}
    			removed = true;
    		}
    	}
    	
    	// decrement size if something was removed
    	if (removed) {
        	size--;
    	}
    	
        return removed;
    }

    /**
     * Contains method that returns true if the key array contains the key and false if not
     * @param k is the key to be checked if it is inside the array
     */
    @Override
    public boolean contains(Comparable k) {
    	boolean found = false;
    	
    	// loops through key array and if key is found return true
    	for (int i = 0; i < size; i++) {
    		if (keyArray[i].compareTo(k) == 0) {
    			found = true;
    		}
    	}
    	
    	
        return found;
    }

    /**
     * Get method that returns the value of a key/value pair
     * @param k is the key of the value to be obtained
     * @throws IllegalArgumentException if key is null
     */
    @Override
    public Object get(Comparable k) {
        // checks if key is null and throws exception if it is
    	if (k == null) {
    		throw new IllegalArgumentException("Key cannot be null");
    	}
    	
    	// loops through list and returns the value of a key/value pair if found
    	for (int i = 0; i < size; i++) {
    		if (keyArray[i].compareTo(k) == 0) {
    			return valueArray[i];
    		}
    	}
    	
    	return null;
    }

    /**
     * Size method that returns current size of arrays
     */
    @Override
    public int size() {
        return size;
    }
}
