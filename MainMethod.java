package programmingAssignment1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * Chelsea Jaculina
 * CS 146 - Programming #1
 * Professor Mike Wu - Spring 2018
 * Due March 30, 2018
 */

/*
 * MainMethod 
 * This class is a tester to test the Process and Heap classes
 */

public class MainMethod extends Heap
{

	/*
	 * MAIN METHOD
	 * This is a tester class that uses Process.java and Heap.java
	 */
	public static void main (String[] args) // main method declaration statement
	{
		ArrayList<Process> processList = new ArrayList<>();
		for(int i = 0; i < 20; i++) // generate a random
		{
			Process p = new Process(); // create a new process
			processList.add(p); // add a new process to the arraylist of type Process
		}
		displayMenu(processList); // invoke the menu method
	}
	
	// ------------------------------------------------------------------------------

	
		/*
		 * Function that displays a menu to the user
		 * @param list - an arraylist to pass in to use on the menu
		 */

		public static void displayMenu(ArrayList<Process> list)
		{
			int userChoice; // char variable for user input
			boolean more = true;
			
			// do while loop 
			do 
			{	/*
				 * Print statements for the user to view
				 * *maxHeapify(). *build-max-heap(), *heapsort(), *max-heap-insert(), *heap-extract-max, 
				 * *heap-increase-key, *heap-maximum
				 */
				
				sop("---------------------------------------------------------------");
				sop("\t\t   MENU - Enter an Option Number \t\t");
				sop("---------------------------------------------------------------");
				sop("0 - Terminate");
				sop("1 - Insert a Process"); // maxHeapInsert
				sop("2 - Extract Max Process"); // extractMaxProcess
				sop("3 - Build Max Heap"); // buildMaxHeap
				sop("4 - Sort Processes"); // heapsort
				sop("5 - Max Heapify an Index"); // maxHeapify
				sop("6 - Increase Key"); // heap increase key
				sop("7 - Heap Maximum" ); // heapMaximum
				sop("8 - View Current List of Processes"); 
				sop("---------------------------------------------------------------");

				System.out.print("Option Choice: ");
				Scanner scan = new Scanner(System.in); // create a scanner object so user can input values
				userChoice = scan.nextInt();
				setHeapSize(list); // set the arraylist size
				
				/*
				 * Start user input choice using a switch statement
				 */
				
				switch (userChoice)
				{
					case 0: // terminate
					{
						more = false;
						sop("Program Terminated. Goodbye!");
						break;
					}
				
					case 1: // inserting a process
					{
						Process createProcess = new Process();
						maxHeapInsert(list, createProcess);
						sop("Process Inserted - " + "Process ID: " + createProcess.getProcessId() + "\t" + "Priority Index of " 
								+ createProcess.getProcessId() + ": "  + createProcess.getPriorityIndex());
						sop("");
						sop("----Updated List After Inserting Process---");
						printArray(list);
						break;
					}
					case 2: // extract max process
					{
						sop("Extract Max Process");
						Process extractMax = heapExtractMax(list);
						
						sop("Extracted Process - " + "Process ID: " + extractMax.getProcessId() + "\t" + "Priority Index of " 
						+ extractMax.getProcessId() + ": "  + extractMax.getPriorityIndex());
						sop("");
						sop("----Updated List After Extraction---");
						printArray(list);
						break;
					}
						
					case 3: // build max heap
					{
						sop("Build Max Heap");
						buildMaxHeap(list);
						printArray(list);
						break;
					}
					case 4: // sort processes
					{
						sop("Sorted List of Processes");
						heapSort(list);
						printArray(list);
						break;
					}
					case 5: // max heapify
					{
						sop("Enter an index number to heapify: ");
						int h = scan.nextInt();
						maxHeapify(list, h);
						printArray(list);
						break;
					}
					case 6: // increase heap key
					{
						sop("Increase Heap Key");
						sop("Enter a number to heapify: ");
						int h = scan.nextInt();
						Process increase = new Process();
						heapIncreaseKey(list, h, increase);
						printArray(list);
						break;
					}
					case 7: // view heap maximum 
					{
						sop("Heap Maximum");
						heapSort(list);
						heapMaximum(list);
						printArray(list);
						break;
					}
					case 8: // view current list
					{
						sop("Current List");
						heapSort(list);
						printArray(list);
						break;
					}
					
					default: 
					{
						sop("I'm sorry. The option choice that you entered is not valid. Select another option choice. ");
					}
				}
			} while (more);
		}
		
	
		
		/*
		 * Private shortcut function that implements the input/output System.out.println
		 */
		private static void sop(Object x)
		{
			System.out.println(x);
		}


}
