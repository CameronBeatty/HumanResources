package main;

import java.util.ArrayList;
import java.util.Collections;
//Essentially is one big ArrayList to store
//Person's and has methods to add and get them.
public class PersonSet implements PersonList 
{
	
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
		if(listOfPeople.contains(person) == false)
		{
			listOfPeople.add(person);
		}
	}
	
	//returns entire list of people
	public ArrayList<Person> getList()
	{
		return this.listOfPeople;
	}
	
	//Receives an index from main
	//and returns the Person at that index
	public Person getPersonAt(int index)
	{
		return listOfPeople.get(index);
	}
	
}//END of CLASS

