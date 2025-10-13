package main;

//Name: Cameron Beatty
//Date: 10/09/2025
//Class: CSCI2260 (U01)
//Purpose:To create the first half of a
//program that reads in data from a text file,
//sorts the data, removes duplicates, converts
//the data from metric to imperial, and outputs
//that newly sorted data to a new text file.
//For the first half all that is needed is the file
//input, reading, and printing to confirm that the
//data was read in correctly.

/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following questions:

Q1: Car and Engine are related
by which, Inheritance or Composition?
Composition

Q2: Color and Red are related
by which, Inheritance or Composition?
Inheritance

Q3: Shirt and Clothing are related
by which, Inheritance or Composition?
Inheritance

Q4: Furniture and Desk are related
by which, Inheritance or Composition?
Inheritance

Q5: CellPhone and Battery are related
by which, Inheritance or Composition?
Composition

*/
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//instantiates Person and PersonSet classes
//by reading in data from a .txt file,
//and then prints out the data read in
public class Main 
{
	public static void main(String[] args) 
	{
		//tracks how many people have been
		//added to set
		System.out.println();
		
		//Test Person
		/*
		String testName = "Mario";
		double testWeight = 25;
		double testHeight = 6;
		Person testPerson = new Person(testName, testWeight, testHeight);
		System.out.println(testPerson.toString());
		*/
		
		//Instantiates a new PersonSet named set
		PersonSet set = new PersonSet();
		PersonOrderedSet orderedSet = new PersonOrderedSet();
		PersonImperialSet imperialSet = new PersonImperialSet();
		
		
		// Don't overcomplicate the data
		// reading. After skipping the
		// first row, you can use the 
		// following to read a row of
		// character info, assuming your
		// Scanner is named "fileReader"
		try
		{
			//get file from args[0]
			File dataFile = new File("hr.txt");
			Scanner fileReader = new Scanner(dataFile);
			//skip first line
			fileReader.nextLine();
			//while there still is data, keep reading
			while(fileReader.hasNext())
			{
				//Next string is name
				String name = fileReader.next();
				//the following double is height
				double height = fileReader.nextDouble();
				//the following double us weight
				//then a string will follow repeating the loop
				double weight = fileReader.nextDouble();
				//create a new instance of person with
				//the read in name, weight, and height
				Person person = new Person(name, weight, height);
				Person convertP = new Person(person);
				//add the person to the set
				orderedSet.add(person);
				imperialSet.add(convertP);
			}
			fileReader.close();
		}
		//File had compatibility issue or was not put into args[0]
		catch(IOException e) 
		{
			System.out.println("ERROR FILE CANNOT BE FOUND");
			System.exit(1);
		}
		
		orderedSet.createList();
		
		/*
		//PRINT OUT DATA SORTED
		//Header
		String header = String.format("%-9s %-12s %-12s", 
				"Name", "Height (cm)", "Weight (kg)");
		System.out.println(header);
		//Loops through each person and prints their info
		//by using set.get to get a person and then calling
		//that persons toString
		for(int i = 0; i < set.getListLength(); i++)
		{
			System.out.println(set.get(i).toString());
		}
		
		//TEST PersonSet toString()
		System.out.println(set.toString());
		*/
		
		//TEST FILE WRITING
		try
		{	
			FileWriter fileWriterOrder = new FileWriter("outputfile.txt");
			fileWriterOrder.write("testing");
			fileWriterOrder.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}
	}
}
