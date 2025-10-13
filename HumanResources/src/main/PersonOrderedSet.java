package main;

import java.util.ArrayList;
import java.util.Collections;

public class PersonOrderedSet extends PersonSet{

	private ArrayList<Person> orderedList;
	
	public PersonOrderedSet()
	{
		orderedList = new ArrayList<Person>();
	}
	
	@Override
	public void add(Person person)
	{
		if(!(orderedList.contains(person)))
		{
			orderedList.add(person);
			super.add(person);
		}
	}
	
	public void createList()
	{
		Collections.sort(orderedList);
		String finalList = "";
		String header = String.format("%-9s %-12s %-12s\n", 
				"Name", "Height (cm)", "Weight (kg)");
		finalList = header + super.toString(orderedList);
		System.out.println(finalList);
	}
}
