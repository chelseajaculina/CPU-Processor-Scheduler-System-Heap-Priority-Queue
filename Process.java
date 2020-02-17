package programmingAssignment1;

import java.util.*;

import programmingAssignment1.Process;

/*
 * Chelsea Jaculina
 * CS 146 - Programming #1
 * Professor Mike Wu - Spring 2018
 * Due March 30, 2018
 */

/*
 * This class creates a Process for a CPU Process Scheduling System
 */

public class Process
{
	private String processId; // instance variable for Process Id
	private int priorityIndex; // instance variable for Priority Index
	private static int count; // count for Process Id
	

	/*
	 * No argument constructor
	 * Constructors a process
	 */
	public Process()
	{
		Random randomGen = new Random(); // generator for random number
		count = count + 1; // increase the count 1..2..3..4.5..etc.
		processId = "P" + count; // concatenate character P and the count for process id
		priorityIndex = randomGen.nextInt(Integer.MAX_VALUE) + 1;	 // generates a random integer up to the maximum integer value
	}
	
	/*
	 * 2 argument constructor
	 * @param processName name of process
	 * @param pIndex priority index of process
	 */
	public Process(String processName, int pIndex)
	{
		processId = processName; // initilaizes processId
		priorityIndex = pIndex; // initializes priorityIndex
	}
	
	/*
	 * Getter method to retrieve process id 
	 * Mainly used for printing out process id
	 */
	public String getProcessId()
	{
		return processId; // returns the processId
	}
	
	/*
	 * Getter method to retrieve priority index
	 * Mainly used for printing out priority index
	 */
	public int getPriorityIndex()
	{
		return priorityIndex; // returns the priority Index
	}
	
	

}
