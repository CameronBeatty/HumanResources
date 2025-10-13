package main;

import java.util.ArrayList;
import java.util.Collections;
//class to handle converting
//metric data points to imperial and
//then putting them in a formatted table
public class PersonImperialSet extends PersonSet{
//list with imperial data
private ArrayList<Person> imperialList;
	//constructor
	public PersonImperialSet()
	{
		imperialList = new ArrayList<Person>();
	}

	@Override
	//method first converts the current
	//persons height and weight to imperial
	//and then adds them to the imperialList
	//if they are not already in the list
	public void add(Person person)
	{
		//convert height and weight
		person.convertHeight();
		person.convertWeight();
		//add to list if not already in list
		if(!(imperialList.contains(person)))
		{
			imperialList.add(person);
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
		finalList = header + super.toString(imperialList);
		System.out.println(finalList);
		return finalList;
	}
}
