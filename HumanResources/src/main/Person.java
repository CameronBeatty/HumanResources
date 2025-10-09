package main;

public class Person 
{
	//instance variables
	private String name;
	private int weight;
	private int height;
	
	//Constructor
	public Person(String name, int weight, int height)
	{
		this.name = name;
		this.weight = weight;
		this.height = height;
	}
	
	@Override
	//toString
	public String toString()
	{
		return String.format("%-9s %-12d %-4d", this.name, this.weight, this.height);
	}
}


