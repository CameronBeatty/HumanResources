package main;

//Name: Cameron Beatty
//Date: 10/13/2025
//Class: CSCI2260 (U01)
//Purpose:To create a program that reads
//in data from a "hr.txt" file. The data
//is then separately sorted alphabetically
//and converted from metric to imperial.
//the data is then output both to the command
//line and to two separate txt files. One
//output is alphabetically sorted with
//metric units and the second is unsorted
//with imperial units.

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
		//Instantiates a new PersonSet named set
		PersonSet set = new PersonSet();
		PersonOrderedSet orderedSet = new PersonOrderedSet();
		PersonImperialSet imperialSet = new PersonImperialSet();
		
		//Try to read in data from file on arg[0]
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

		System.out.println("Alphapetically Ordered:");
		String orderedList = orderedSet.createList();
		System.out.println("Imperial Conversion:");
		String imperialList = imperialSet.createList();

		//FILE WRITING
		try
		{	
			//two file writers, one for each file
			//alphabetically sorted data and 
			//metric to imperial data
			FileWriter orderedFw = new FileWriter("hr_ordered_set_output.txt");
			FileWriter imperialFw = new FileWriter("hr_imperial_set_output.txt");
			//write the files using
			//the string from the createList
			//methods in both sets
			orderedFw.write(orderedList);
			imperialFw.write(imperialList);
			//close file writers
			orderedFw.close();
			imperialFw.close();
		}
		//catch input/output errors
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println(e);
			System.exit(1);
		}
		
	}//END main method 
}//END public class Main
