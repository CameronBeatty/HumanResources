package main;

import java.util.ArrayList;
import java.util.Collections;
//Class to sort and store hr data alphabetically
public class PersonOrderedSet extends PersonSet{

	@Override
	//if the arrayList doesn't
	//already contain the current person
	//the current person is added
	public void add(Person person)
	{
		if(!(listOfPeople.contains(person)))
		{
			super.add(person);
		}
	}
	
	//creates a formatted alphabetically
	//sorted data table with all non duplicate
	//people from hr.txt
	public String createList()
	{
		//Alphabetically sort the list
		Collections.sort(listOfPeople);
		String finalList = "";
		//formatted header
		String header = String.format("%-9s %-12s %-12s\n", 
				"Name", "Height (cm)", "Weight (kg)");
		//use super.toString to add all the
		//alphabetically sorted people's data
		//to one formatted string
		finalList = header + super.toString();
		System.out.println(finalList);
		return finalList;
	}
}
