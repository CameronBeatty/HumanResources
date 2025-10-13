package main;

//Each instance of Person stores one specific persons
//information from a data file containing
//a list of peoples information.
//https://www.geeksforgeeks.org/java/comparable-interface-in-java-with-examples/
public class Person implements Comparable<Person> 
{
	//instance variables
	private String name;
	private double weight;
	private double height;
	
	//Constructor
	//take name height and weight from main
	//that was read in and assign it to the specific person
	public Person(String name, double weight, double height)
	{
		this.name = name;
		this.weight = weight;
		this.height = height;
	}
	
	public Person(Person person)
	{
		this.name = person.name;
		this.weight = person.weight;
		this.height = person.height;
	}
	//get name
	public String getName()
	{
		return this.name;
	}
	//get weight
	public double getWeight()
	{
		return this.weight;
	}
	//get height
	public double getHeight()
	{
		return this.height;
	}
	
	public void convertHeight()
	{
		this.height = (this.height)/2.54;
	}
	
	public void convertWeight()
	{
		this.weight = (this.weight)*2.205;
	}
	
	@Override
	//https://www.geeksforgeeks.org/java/overriding-equals-method-in-java/
	//Overridden equals() method allows for easy comparison
	//of the Person class in particular, allowing for comparison
	//of the name instance variable of Person.
	public boolean equals(Object object)
	{
		//if the object is this instance of Person,
		//they are themselves, return true
		if (object == this)
		{
			return true;
		}
		
		//if the object is not a person
		//return false
		if (!(object instanceof Person))
		{
			return false;
		}
		
		//typecast object to Person, since equals()
		//is being overridden object is a default
		//Object until specified
		Person check = (Person) object;
		
		//return true or false based on whether or not
		//another person with the same name is in the list.
		//Height and Weight are not checked since two different
		//people could be the same height or weight
		return this.name.equalsIgnoreCase(check.name);
	}

	@Override
	//toString
	//creates formatted row of data in name, height, weight order
	public String toString()
	{
		return String.format("%-9s %10.2f %12.2f", this.name, this.height, this.weight);
	}
	
	@Override
	//https://stackoverflow.com/questions/22871583/implements-comparable-to-get-alphabetical-sort-with-strings
	public int compareTo(Person other)
	{
		return this.name.compareTo(other.name);
	}
}


