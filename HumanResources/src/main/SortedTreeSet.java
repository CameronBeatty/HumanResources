package main;

import java.util.ArrayList;

//Sorted Tree Set stores and organizes alphabetically
//Nodes containing Nintendo characters HR data and
//formats all of it to a data sheet written out to file
public class SortedTreeSet extends PersonSet implements SortedTreeSetInterface 
{
	private Node head;
	//tester
	private String totalTree;
	//Constructor
	public SortedTreeSet()
	{
		head = null;
		totalTree = "";
		//for purpose of excluding duplicates
		listOfPeople = new ArrayList<Person>();
	}
	//add a person to the list
	//if they are not already on the list
	public void addToList(Person person)
	{
		super.add(person);
	}
	//return the list
	public ArrayList<Person> getList()
	{
		return super.getList();
	}
	
	//Tester
	public String listTest()
	{
		return this.totalTree;
	}

	//=================================================
	//ADD
	//=================================================
	@Override
	//Adds a new person to the tree set in an
	//alphabetically sorted position
	public void add(Person p) 
	{
		//new person
		Node newPerson = new Node(p);
		//System.out.println("\n=========\nNew Person: " + newPerson.getName() + "\n==========");
		//if the list is empty, first 
		//item becomes head of tree
		if(head == null)
		{
			//System.out.println("==============\nadded " + newPerson.getName() + "to head\n==============");
			head = newPerson;
			totalTree += (newPerson.getName() + "\n");
		}
		//Else the new person is not the first and must 
		//be compared alphabetically to the other items in the list
		else 
		{
			Node current = head;
			//While we have not added the new person
			while(current != newPerson)
			{
				//TEST
				//System.out.println("Adding Person, while(current != newPerson)");
				//System.out.println("Current: " + current.getName() + " \n" + "New Person: "
				//				+ newPerson.getName());
				//If the new person is further in the alphabet then
				//the current person in the list being checked
				if(newPerson.getName().charAt(0) > current.getName().charAt(0))
				{
					//System.out.println(newPerson.getName() + " should go to right");
					//if the next right branch is empty
					//the newPerson takes that position
					if(current.getRight() == null)
					{
						current.setRight(newPerson);
						newPerson.setParent(current);
						current = current.getRight();
						//tester
						//System.out.println("Added " + current.getName() + " to right\n");
						//System.out.println(current.getName() + "'s parent is " + current.getParent().getName());
						totalTree += (newPerson.getName() + "\n");
					}
					//Else there is another person to the right who must
					//be checked, so they become current, and the loop repeats
					else {current = current.getRight();}
				}//END right branch
				//ELSE The new person goes  alphabetically
				//before the current person being checked
				else
				{
					//System.out.println(newPerson.getName() + " should go to left");
					//if the next left branch is empty
					//the new person takes that position
					if(current.getLeft() == null)
					{
						current.setLeft(newPerson);
						newPerson.setParent(current);
						current = current.getLeft();
						//System.out.println("Added " + current.getName() + " to left\n");
						//System.out.println(current.getName() + "'s parent is " + current.getParent().getName());
						totalTree += (newPerson.getName() + "\n");
					}
					//Else there is another person to the left who must
					//be checked, they become current and the loop repeats
					else {current = current.getLeft();}
				}//END of left branch else
			}//END while(current != newPerson) 
		}//END else NOT first person in list
	}//End of add()
	
	//===================================================================== 
    //toString()
	//=====================================================================
	@Override
	//Produces a formatted data sheet of all
	//Nintendo characters in the tree set sorted
	//alphabetically by taversing the tree set
	//using an In-Order traversal
	//"Learn Tree traversal in 3 minutes" Bro Code
	//https://www.youtube.com/watch?v=b_NjndniOqY&t=80s
	public String toString()
	{
		String header = String.format("%-9s %-12s %-12s\n", 
				"Name", "Height (cm)", "Weight (kg)");
		String toReturn = header;
		Node current = head;
		//left
		//While there is still a further left branch
		//keep searching
		while(current.getLeft() != null)
		{
			current = current.getLeft();
		}
		//The farthest left branch is assigned
		//to farLeft
		Node farLeft = current;
		//We then search up the tree from 
		//the farLeft until we reach the head
		//again
		while(farLeft != head)
		{
			//This adds to the entire to string
			//, in order, farLeft, farLeft's parent.
			//and farLeft's parnet's right branch.
			//This being the In-Order traversal order
			//of left, root, right
			toReturn += farLeft.toString() + "\n";
			toReturn += farLeft.getParent().toString() + "\n";
			if (farLeft.getParent().hasRight() == true)
			{
				toReturn += farLeft.getParent().getRight().toString() + "\n";
			}
			//Once added to the string farLeft's
			//parent's parent becomes the new
			//left branch, and the process of
			//left, root, right continues
			//until the head is reached.
			farLeft = farLeft.getParent().getParent();
		}
		//Once we've reached the head, we add it
		//to toReturn
		if(farLeft == head)
		{
			toReturn += farLeft.toString() + "\n";
		}
		//Now we search for the left branch
		//of the farthest root node to the
		//right of the head
		Node farRight = head.getRight();
		//While the current node has
		//either a left or right branch
		//keep going deeper down the tree
		while(farRight.hasNext())
		{
			//if there is another right branch
			//keep going right
			if(farRight.hasRight() == true)
			{
				farRight = farRight.getRight();
			}
			//else we go left
			else
			{
				farRight = farRight.getLeft();
			}
		} 
		//Once there are no further branches to traverse
		//we work our way back up to the head following
		//the same left, root, right order
		while (farRight != head)
		{
			//Add the left, root, and right to the
			//toReturn
			toReturn += farRight.toString() + "\n";
			toReturn += farRight.getParent().toString() + "\n";
			if (farRight.getParent().hasRight() == true)
			{
				toReturn += farRight.getParent().getRight().toString() + "\n";
			}
			//Get the next parent of the parent
			//i.e work our way up to the head
			farRight = farRight.getParent().getParent();
		}
		//once everything has been added return toReturn
		return toReturn;
	}//END toString()
}//END SortedTreeSet
