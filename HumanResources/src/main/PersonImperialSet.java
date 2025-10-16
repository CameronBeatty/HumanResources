package main;

import java.util.ArrayList;
import java.util.Collections;
//class to handle converting
//metric data points to imperial and
//then putting them in a formatted table
public class PersonImperialSet extends PersonSet{
	@Override
	//method first converts the current
	//persons height and weight to imperial
	//and then adds them to the list
	//if they are not already in the list
	public void add(Person person)
	{
		//convert height and weight
		person.convertHeight();
		person.convertWeight();
		//add to list if not already in list
		if(!(listOfPeople.contains(person)))
		{
			super.add(person);
		}
	}
	//creates formatted table with
	//the converted units using
	//PersonSet toString() method
	public String createList()
	{
		String finalList = "";
		//formatted header with "in" and "lb"
		String header = String.format("%-9s %-12s %-12s\n", 
				"Name", "Height (in)", "Weight (lb)");
		//create table
		finalList = header + super.toString();
		System.out.println(finalList);
		return finalList;
	}
}
