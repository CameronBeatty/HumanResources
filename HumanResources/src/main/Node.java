package main;
//Node stores an individual
//Nintendo characters HR data
//by storing that instance of the
//person object. These nodes are
//used for a Tree Data Set
public class Node 
{
	private Person person;
	private Node left;
	private Node right;
	private Node parent;
	//constructor
	public Node(Person newPerson) 
	{
		this.person = newPerson;
		this.left = null;
		this.right = null;
	}
	//Get this person's current Person instance
	public Person getPerson() {return this.person;}
	//set,get,has left
	public Node getLeft() {return this.left;}
	public void setLeft(Node newLeft) {this.left = newLeft;}
	public boolean hasLeft()
	{
		if (this.left == null) {return false;}
		else{return true;}
	}
	//set,get,has right
	public Node getRight() {return this.right;}
	public void setRight(Node newRight) {this.right = newRight;}
	public boolean hasRight()
	{
		if (this.right == null) {return false;}
		else {return true;}
	}
	//set,get parent
	public Node getParent() {return this.parent;}
	public void setParent(Node newParent) {this.parent = newParent;}
	//get this persons name
	public String getName()
	{
		return this.person.getName();
	}
	//Does this person have a right or left
	//i.e are they the end of a branch?
	public boolean hasNext()
	{
		//no more branches
		if(this.right == null && this.left == null)
		{
			return false;
		}
		//yes there is another branch
		else
		{
			return true;
		}
	}
	
	@Override
	//returns the formatted
	//data line for this person
	//by calling the Person class
	//toString
	public String toString()
	{
		return this.person.toString();
	}
	
}
