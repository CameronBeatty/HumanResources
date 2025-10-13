package main;

import java.util.ArrayList;
//Essentially is one big ArrayList to store
//Person's and has methods to add and get them.
public class PersonSet implements PersonList {
	
	//instance variable
	//an ArrayList of people(Person's), to sort all
	//instances of Person
	private ArrayList<Person> listOfPeople;
	
	//Constructor
	//instantiates the sets ArrayList
	public PersonSet()
	{
		listOfPeople = new ArrayList<Person>();
	}
	
	//Takes a Person from main
	//and add's it to the listOfPeople
	//ArrayList
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
	
}

