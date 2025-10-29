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
	//set/get right
	public Node getRight() {return this.right;}
	public void setRight(Node newRight) {this.right = newRight;}
	//set/get parent
	public Node getParent() {return this.parent;}
	public void setParent(Node newParent) {this.parent = newParent;}
	
	public String getName()
	{
		return this.person.getName();
	}
	
}
