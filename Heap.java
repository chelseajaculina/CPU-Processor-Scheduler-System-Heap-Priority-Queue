package programmingAssignment1;

import java.util.*;

/*
 * Chelsea Jaculina
 * CS 146 - Programming #1
 * Professor Mike Wu - Spring 2018
 * Due March 30, 2018
 */

/*
 * This class holds all the Heap Functions that helps with creating a Max-Heap-Tree
 * Functions Include:
 * maxHeapify(). build-max-heap(), heapsort(), max-heap-insert(), heap-extract-max, 
 * heap-increase-key, heap-maximum
 * 
 */


public class Heap extends Process // extends process so that we can use the functions and retrieve the instance variables in the Process.java class
{
	private static int heapSize; // instance variable to hold the heap size capacity
	
	/**
	 * MAX HEAPIFY
	 * To modify an arraylist so that it meets the max heap property
	 * @param a input arraylist that needs to be modified so that 'i' roots a heap
	 * @param i input arraylist index
	 */
	public static void maxHeapify(ArrayList<Process> a, int i)
	{
		int left = leftChild(i);  // gets the left child node;
		int right = rightChild(i); // gets the right child node;
		int largest;  // largest variable, should end up being the root
		
		/* checks if left node is less than the array size to make sure the root has a left child or not
		* and checks if the value in the left node is greater than
		*the value of the passed input index of the array 
		*/ 
		if (left <= heapSize - 1 && a.get(left).getPriorityIndex() > a.get(i).getPriorityIndex())
		{
			largest = left; // if the value of left child is greater set it to the largest value
		}
		
		else
		{
			largest = i; // set the largest value to i (the root)
		}
		
		/* checks if right node is less than the array size to make sure the root has a right child or not
 		* and checks if the value in the right node is greater than
 		* the value of largest element in the array
		*/
		if (right <= heapSize - 1 && a.get(right).getPriorityIndex() > a.get(largest).getPriorityIndex())
		{
			largest = right; // set the largest value to r (the right child node)
		}
		
		/*
		 * if the root is not equal to largest
		 * the root should be the largest value
		 */
		if(largest != i)
		{ 
			Process temp = a.get(i); // sets the root to temp variable
			a.set(i, a.get(largest)); // sets the largest value to the root
			a.set(largest, temp); // sets the root to the largest value
			maxHeapify(a, largest); // call max heapify on the largest value position. It should either be the left or right child node.
		}
	}
		
	/*
	 * BUILD MAX HEAP
	 * Given an (unsorted) arraylist this function creates a max heap
	 * That is the parent node is > the child node at all times in the arraylist
	 * @param a - input (unsorted) arraylist
	 * 
	 */
		public static void buildMaxHeap(ArrayList<Process> a)
		{
			heapSize = a.size(); // gets the size of the arraylist
			for(int i = heapSize / 2 - 1; i >=0; i--) // start at highest index of the arraylist size and decrement
			{
				maxHeapify(a,i); // call max heapify to build a max heap
			}
		}
		
	/*
	 * HEAP SORT
	 * This function sorts an unsorted arraylist by swapping the smaller element with the largest element
	 * @param A - input unsorted arraylist
	 */
		public static void heapSort(ArrayList<Process> a)
		{
			buildMaxHeap(a); // needs the arraylist to be in max heap format
			for(int i = heapSize - 1; i >=0; i--) // start at highest index of the arraylist size and decrement
			{
				// swapping
				Process temp = a.get(0); // get the first element the root
				a.set(0, a.get(i)); // swap the root and the last element
				a.set(i, temp); // set the last element to the root
				heapSize = heapSize - 1; // decrement heapSize
				maxHeapify(a, 0); // maxheapify because you swapped the elements and the branches might not in max heap property
			}
		}
		

		/**
		 * MAX HEAP NSERT
		 * This function inserts a key at the end of the arraylist and then uses heapIncreaseKey to maintain the max-heap property
		 * @param A input arraylist
		 * @param key value to insert
		 */
		public static void maxHeapInsert(ArrayList<Process> a, Process key)
		{
			int negInfinity = Integer.MIN_VALUE; // // holds the lowest integer value, replicates the - infinity in the pseudocode
			Process processObj = new Process("...", negInfinity);// temporary value to insert to new slot
			heapSize = heapSize + 1; // gets the last element of the arraylist
			a.add(processObj); // adds -infinity at the last index
			heapIncreaseKey(a, heapSize - 1, key); // swap until it meets max heap property
		}
		
		/**
		 * HEAP EXTRACT MAX
		 * This function extracts the maximum value after it has been built to be a max heap.
		 * It removes and returns the element with highest priority
		 * @param a input arraylist
		 * @return max returns the largest element of ArrayList A
		 */
		
		public static Process heapExtractMax(ArrayList<Process> a)
		{
			if (heapSize < 1) // checks to see if the heap hasatleast 1 element in it 
			{
				System.out.println("ERROR: Heap Underflow"); // error message
			}
			
			buildMaxHeap(a); // create a max heap on arraylist a
			Process max = a.get(0); // obtain the maximum value which is at the root
			a.set(0, a.get(heapSize - 1)); 	// the root is set to the last element in the array, so swap the two positions
			a.remove(0); // remove the maximum value EXTRACT
			heapSize = heapSize - 1; // decrement the heapsize
			maxHeapify(a, 0); // invoke max heapify
			return max;	 // return the largest element (extract value)
		}
		
		/**
		 * HEAP INCREASE KEY
		 * This function increases the priority of an element at index i
		 * @param A - input arraylist
		 * @param i - input index i
		 * @param key - the increased value number
		 */
		public static void heapIncreaseKey(ArrayList<Process> a, int i, Process key)
		{
			int parentNode = i/2 - 1; // parent node
			
			if(key.getPriorityIndex() < a.get(i).getPriorityIndex()) //the value that is going to be increase should be greater than the initial value
			{
				System.out.println("ERROR - New key is smaller than current key"); // error message
			}
			
			a.set(i, key); // set the value of k to the index position of i
			
			/* while the index is greater than the node value (checks that we don't beyond the root)
			* &&
			 *the parent is less than the value at index i */
			
			while (i > 0 && a.get(parentNode).getPriorityIndex() < a.get(i).getPriorityIndex())
			{
				Process temp = a.get(i); // temp variable is set to the index variable
				a.set(i, a.get(parentNode)); // swap the parent
				a.set(parentNode, temp);  // swap the parent if the parent is less than the value at index i to maintain the max heap property
				i = parentNode; // set i to the parentNode
				parentNode = i/2 - 1; // if you see that parent node is greater than the child we can then stop, otherwise keep checking until you reach the parent
			}
		}
		
		/*
		 * HEAP MAXIMUM
		 * This function gets the maximum element which is at the root
		 * @param A - input arraylist
		 * @return root - the maximum value in the heap
		 */
		public static Process heapMaximum(ArrayList<Process> A)
		{
			Process root = A.get(0);
			return root;
		}
		
		/*
		 * LEFT CHILD NODE
		 * @param i 
		 */
		public static int leftChild(int i )
		{
			return 2 * i + 1; // get the child node
		}
		
		/*
		 * RIGHT CHILD NODE
		 * @param i
		 */
		public static int rightChild(int i)
		{
			return 2 * i + 2;
		}
		
		/**
		 * SWAPPING Helper Function
		 * This function is used to swap two elements
		 * @param data input array
		 * @param i input index to swap #1
		 * @param j input index to swap #2
		 */
		private static void swap(ArrayList<Integer> data, int i, int j)
		{
			int temp = data.get(i);
			data.set(i, data.get(j));
			data.set(j, temp);
		}

		/**
		 * GET HEAP SIZE
		 * Getter method where this function updates the heap size of the arraylist
		 * @param h - integer value, the heapsize
		 */
		public static int getHeapSize(int h)
		{
			heapSize = h;
			return heapSize;
		}

		/*
		 * SET HEAP SIZE
		 * Setter method that sets the capacity of the heap size
		 * @param arr input arraylist of processes
		 * @
		 */
		public static void setHeapSize(ArrayList<Process> arr)
	    {
	        heapSize = arr.size();
	    }

		/*
		 * PRINTS THE ARRAYLIST
		 * Public function that prints out the arraylist
		 * To print out the process id and priority index
		 */
		public static void printArray(ArrayList<Process> arr)
		{
			{
				for(Process n : arr)
				{
					System.out.println("Process ID: " + n.getProcessId() + "\t\t" + "Priority Index of " + n.getProcessId() + ": " + n.getPriorityIndex());
				}
			}

		}		
}
	


