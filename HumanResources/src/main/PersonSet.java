package main;

import java.util.ArrayList;
import java.util.Collections;
//Essentially is one big ArrayList to store
//Person's and has methods to add and get them.
public class PersonSet implements PersonList {
	
	//instance variable
	//an ArrayList of people(Person's), to sort all
	//instances of Person
	//MUST BE PROTECTED so sub-classes can use
	protected ArrayList<Person> listOfPeople;
	
	//Constructor
	//instantiates the sets ArrayList
	public PersonSet()
	{
		listOfPeople = new ArrayList<Person>();
	}
	
	//Takes a Person from main
	//and adds it to the listOfPeople
	//ArrayList if that person
	//is not yet in the list
	public void add(Person person)
	{
		listOfPeople.add(person);
	}
	
	//Receives an index from main
	//and returns the Person at that index
	public Person get(int index)
	{
		return listOfPeople.get(index);
	}
	
	//returns how man people are
	//in the list
	public int getListLength()
	{
		return listOfPeople.size();
	}
	
	@Override
	//Puts each persons data on one
	//formatted line as a string, and complies
	//all the strings to create a sheet of all
	//data in one string
	public String toString()
	{
		//entire sheet of data
		String personData = "";
		//Object and Person for typecast
		Object o;
		Person p;
		for(int i = 0; i < listOfPeople.size(); i++)
		{
			//type cast current object in list
			//to person type
			o = listOfPeople.get(i);
			p = (Person) o;
			//add the persons data to a formatted line
			//and add that line to the entire sheet
			personData = personData + 
					String.format("%-9s %10.2f %12.2f\n", 
							p.getName(), p.getHeight(), p.getWeight());
		}
		return personData;
	}
}

