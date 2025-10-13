package main;

//Each instance of Person stores one specific persons
//information from a data file containing
//a list of peoples information.
public class Person 
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
	
	@Override
	//toString
	//creates formatted row of data in name, height, weight order
	public String toString()
	{
		return String.format("%-9s %10.2f %12.2f", this.name, this.height, this.weight);
	}
}


