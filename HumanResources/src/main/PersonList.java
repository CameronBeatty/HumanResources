package main;

//confirms that other classes have a
//get() and add() method
public interface PersonList 
{
	//Takes person as input returns void
	void add(Person person);
	
	//Takes int as input as returns a Person at
	//the corresponding index of the input
	Person get(int index);
}
