package main;

//Name: Cameron Beatty
//Date: 10/30/2025
//Class: CSCI2260 (U01)
//Purpose:To create a program that reads
//in data from a "hr.txt" file. The data
//is then added to a Tree Data Set which
//upon addition to that set it sorted 
//alphabetically. Once all data is read
//in a formatted data table if produced,
//both displayed in the command prompt and
//output to a .txt file

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

//instantiates Person PersonSet 
//and SortedTreeSet classes
//by reading in data from a .txt file,
//and then prints out the data read in
public class Main 
{
	public static void main(String[] args) 
	{
		//create a new Tree Set
		SortedTreeSet treeSet = new SortedTreeSet();
		
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
				//add the person to the treeSet's
				//listOfPeole to filter out duplicates
				treeSet.addToList(person);
			}
			fileReader.close();
		}
		//File had compatibility issue or was not put into args[0]
		catch(IOException e) 
		{
			System.out.println("ERROR FILE CANNOT BE FOUND");
			System.exit(1);
		}
        //Adds all the read in Person's from
		//treeSet's listOfPeople to the Tree Set
		for(int i = 0; i < treeSet.getList().size(); i++)
		{
			treeSet.add(treeSet.getList().get(i));
		}
		//System.out.println(treeSet.listTest());
		System.out.println(treeSet.toString());

		//FILE WRITING
		try
		{	
			//FileWriter to write out sorted data from Tree Set
			FileWriter treeSetOutputFW = new FileWriter("hr_tree_set_output.txt");
			treeSetOutputFW.write(treeSet.toString());
			treeSetOutputFW.close();
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
