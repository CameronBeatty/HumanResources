package main;

public class Node 
{
	private Person person;
	private Node left;
	private Node right;
	private Node parent;
	
	public Node(Person newPerson) 
	{
		this.person = newPerson;
		this.left = null;
		this.right = null;
	}
	
	public Person getPerson() {return this.person;}
	//set/get left
	public Node getLeft() {return this.left;}
	public void setLeft(Node newLeft) {this.left = newLeft;}
	public boolean hasLeft()
	{
		if (this.left == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	//set/get right
	public Node getRight() {return this.right;}
	public void setRight(Node newRight) {this.right = newRight;}
	public boolean hasRight()
	{
		if (this.right == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	//set/get parent
	public Node getParent() {return this.parent;}
	public void setParent(Node newParent) {this.parent = newParent;}
	
	public String getName()
	{
		return this.person.getName();
	}
	
	public boolean hasNext()
	{
		if(this.right == null && this.left == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
}
