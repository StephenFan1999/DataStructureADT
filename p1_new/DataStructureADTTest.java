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

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Data Structure Test class to run tests
 * @author Stephen Fan
 *
 * @param <T> 
 */
abstract class DataStructureADTTest<T extends DataStructureADT<String,String>> {
	
	// declare variables
	private T dataStructureInstance;
	
	protected abstract T createInstance();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		dataStructureInstance = createInstance();
	}

	@AfterEach
	void tearDown() throws Exception {
		dataStructureInstance = null;
	}

	/**
	 * tests if the size is 0 if nothing is added
	 */
	@Test
	void test00_empty_ds_size() {
		if (dataStructureInstance.size() != 0) {
			fail("data structure should be empty, with size=0, but size="+dataStructureInstance.size());
		}
	}
	
	// TODO: implement tests 01 - 04

	// test01_after_insert_one_size_is_one
	
	// test02_after_insert_one_remove_one_size_is_0
	
	// test03_duplicate_exception_is_thrown
	
	// test04_remove_returns_false_when_key_not_present
	
	/**
	 * tests if the size is 1 after inserting a key/value pair
	 */
	@Test
	void test01_after_insert_one_size_is_one() {
		dataStructureInstance.insert("0","100");
		if (dataStructureInstance.size() != 1) {
			fail("data structure should have one key/value pair and size should =1, but size="+dataStructureInstance.size());
		}
	}
	
	/**
	 * tests if the size is zero after inserting and removing a key/value pair
	 */
	@Test
	void test02_after_insert_one_remove_one_size_is_zero() {
		//dataStructureInstance.insert("0","100");
		//boolean success = dataStructureInstance.remove("0");
		//if (dataStructureInstance.size() != 0 && success != true) {
		//	fail("data structure should be empty, with size=0, but size="+dataStructureInstance.size());
		//}
		
		try {
			dataStructureInstance.insert("one", "inserting");
		}
		catch (RuntimeException e) {
			
		}
		
		dataStructureInstance.remove("one");
		assertEquals(0, dataStructureInstance.size());
	}

	/**
	 * tests if the duplicate exception is thrown after inserting a duplicate key
	 */
	@Test
	void test03_duplicate_exception_is_thrown() {
		dataStructureInstance.insert("0","100");
		dataStructureInstance.insert("1","101");
		dataStructureInstance.insert("5","105");
		dataStructureInstance.insert("10","110");
		try {
			dataStructureInstance.insert("5","105");
			fail("inserting a duplicate key should have thrown a RuntimeException but no such exception was thrown");
		}
		catch (IllegalArgumentException e) {}
	}
	
	/**
	 * tests that remove returns false when the key is not there
	 */
	@Test
	void test04_remove_returns_false_when_key_not_present() {
		dataStructureInstance.insert("0","100");
		dataStructureInstance.insert("1","101");
		dataStructureInstance.insert("5","105");
		boolean success = dataStructureInstance.remove("2");
		if (success != false) {
			fail("the remove method should return false because a key of 2 was not inserted into the data structure");
		}
	}
	
	/**
	 * tests that inserting 6 key/value pairs and removing 3 will result in a size of 3
	 */
	@Test
	void test05_insert_6_remove_3_check_size() {
		dataStructureInstance.insert("0","100");
		dataStructureInstance.insert("1","101");
		dataStructureInstance.insert("2","102");
		dataStructureInstance.insert("3","103");
		dataStructureInstance.insert("4","104");
		dataStructureInstance.insert("5","105");
		
		dataStructureInstance.remove("3");
		dataStructureInstance.remove("5");
		dataStructureInstance.remove("4");
		
		if (dataStructureInstance.size() != 3) {
			fail("after inserting 6 key/value pairs and removing 3 key/value pairs the size should be 3 but it is " + dataStructureInstance.size());
		}
	}
	
	/**
	 * tests that inserting a null key will throw and exception
	 */
	@Test
	void test06_insert_null_key_throw_exception() {
		try {
			dataStructureInstance.insert(null,"100");
			fail("IllegalArgumentException should have been thrown after inserting null key");
		}
		catch (IllegalArgumentException e) {}
	}
	
	/**
	 * tests that removing a null key will throw an exception
	 */
	@Test
	void test07_remove_null_key_throw_exception() {
		try {
			dataStructureInstance.remove(null);
			fail("IllegalArgumentException should have been thrown after removing null key");
		}
		catch (IllegalArgumentException e) {}
	}
	
	/**
	 * tests that getting a null key will throw an exception
	 */
	@Test
	void test08_get_null_key_throw_exception() {
		try {
			dataStructureInstance.get(null);
			fail("IllegalArgumentException should have been thrown after getting null key");
		}
		catch (IllegalArgumentException e) {}
	}
	
	/**
	 * tests that removing from an empty list will return false
	 */
	@Test
	void test09_remove_from_empty_list() {
		if (dataStructureInstance.remove("5") != false) {
			fail("remove should return false when removing from an empty list");
		}
	}
	
	/**
	 * tests that inserting key/value pairs and getting a value will return the correct value
	 */
	@Test
	void test10_insert_and_get_value() {
		dataStructureInstance.insert("0","100");
		dataStructureInstance.insert("1","101");
		dataStructureInstance.insert("2","102");
		dataStructureInstance.insert("5", "105");
		if (dataStructureInstance.get("2") != "102") {
			fail("get method should return 102 which corresponds with key 2");
		}
	}
	
	/**
	 * tests that getting a value from an empty list will return null
	 */
	@Test
	void test11_get_value_from_empty_list() {
		if (dataStructureInstance.get("8") != null) {
			fail("getting a value from an empty list should return null");
	    }
	}
	
	/**
	 * tests that inserting a key/value pair and checking contains will return true if it is there
	 */
	@Test
	void test12_insert_value_check_contains() {
		dataStructureInstance.insert("0","100");
		dataStructureInstance.insert("1","101");
		dataStructureInstance.insert("2","102");
		if (dataStructureInstance.contains("1") != true) {
			fail("array should contain key of 1");
		}
	}
	
	/**
	 * tests that an exception is not thrown for a null value
	 */
	@Test
	void test13_insert_null_value() {
		try {
			dataStructureInstance.insert("0",null);
			dataStructureInstance.insert("1","101");
			dataStructureInstance.insert("2","102");
		}
		catch (Exception e) {
			fail("no exception should be thrown for null values, only for null keys");
		}
	}
	
	/**
	 * tests if the removed key is not in the array, that false is returned
	 */
	@Test
	void test14_removed_key_not_in_list() {
		dataStructureInstance.insert("0","100");
		dataStructureInstance.insert("1","101");
		dataStructureInstance.insert("2","102");
		
		if (dataStructureInstance.remove("3") != false) {
			fail("removing a key not in the array should return false");
		}
	}
	
	
	
	// TODO: add tests to ensure that you can detect implementation that fail
	
	// Tip: consider different numbers of inserts and removes and how different combinations of insert and removes


}
