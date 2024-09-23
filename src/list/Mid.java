package list;

public class Mid extends List {

	// 8
    // Negate all elements in a list
	// Make list, namely list1: 2, -5, 8, 0
    // Afterwards make list2 which is the negation of elements in list1
    // list1: 2, -5, 8, 0 --> list2 = -2, 5, -8, 0
	static List negateAll(List a) {
	    if (a.empty()) {
	        return a; // If list empty, return as it is
	    } 
	    else {
	        return List.cons(-a.head(), negateAll(a.tail())); // Negate head and recurse on tail
	    }
	}

	// 9
    // Find the index of an element in a list
	// Locate element 8 starting from 0 from list9
    // It is located at position 2
	static int find(int x, List a) {
	    if (a.empty()) {
	        return -1; // If list empty, return -1 indicating element not found
	    } 
	    else if (a.head() == x) {
	        return 0; // If head is element, return 0 indicating found at first position
	    } 
	    else {
	        int index = find(x, a.tail()); // Recurse on tail
	        if (index != -1) {
	            index++; // If element found in tail, increment the index
	        }
	        return index;
	    }
	}

	// 10
    // Check if all elements in list are positive
	static boolean allPositive(List a) {
	    if (a.empty()) {
	        return true; // If list is empty, return true as there are no negative elements
	    } 
	    else if (a.head() < 0) {
	        return false; // If head is negative, return false
	    } 
	    else {
	        return allPositive(a.tail()); // Recurse on tail
	    }
	}

	// 11
	// Locate positive elements in list
    // Return list of all positive elements
	static List positives(List a) {
	    if (a.empty()) {
	        return a; // If list is empty, return as it is
	    } 
	    else if (a.head() > 0) {
	        return List.cons(a.head(), positives(a.tail())); // If head is positive, include it in result and recurse on tail
	    } 
	    else {
	        return positives(a.tail()); // If head is not positive, recurse on tail
	    }
	}

	// 12
    // Verify if list is sorted
	static boolean sorted(List a) {
	    if (a.empty() || a.tail().empty()) {
	        return true; // If list is empty or has only one element, it is sorted
	    } 
	    else if (a.head() > a.tail().head()) {
	        return false; // If head is greater than the next element, list is not sorted
	    } 
	    else {
	        return sorted(a.tail()); // Recurse on tail
	    }
	}

	// 13
    // Merge two sorted lists into a sorted list, retain duplicate copies of elements
	static List merge(List a, List b) {
	    if (a.empty()) {
	        return b; // If list a is empty, return list b
	    } 
	    else if (b.empty()) {
	        return a; // If list b is empty, return list a
	    } 
	    else if (a.head() <= b.head()) {
	        return List.cons(a.head(), merge(a.tail(), b)); // If head of a is less than or equal to head of b, include head of a in result and recurse on tail a and list b
	    } 
	    else {
	        return List.cons(b.head(), merge(a, b.tail())); // If head of b is less than head of a, include head of b in result and recurse on list a and tail of b
	    }
	}

	 // 14
    // Remove duplicates from sorted list
	static List removeDuplicates(List a) {
	    if (a.empty() || a.tail().empty()) {
	        return a; // If list is empty or has only one element, return as it is
	    } 
	    else if (a.head() == a.tail().head()) {
	        return removeDuplicates(a.tail()); // If head is equal to next element, remove head (duplicate) and recurse on tail
	    } 
	    else {
	        return List.cons(a.head(), removeDuplicates(a.tail())); // If head is not equal to next element, include head in result and recurse on tail
	    }
	}

	// 15
    // Skip all occurrences of element in a list
	static List skip(int x, List a) {
	    if (a.empty()) {
	        return a; // If list empty, return as it is
	    } 
	    else if (a.head() == x) {
	        return skip(x, a.tail()); // If head is the element to be skipped, recurse on tail
	    } 
	    else {
	        return List.cons(a.head(), skip(x, a.tail())); // If head is not the element to be skipped, include head in result and recurse on tail
	    }
	}
}

