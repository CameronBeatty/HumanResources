package main;
//Node interface to ensure implementation
//of all necessary set, get, and has methods
//associated with the node
public interface NodeInterface {
	//person
	public Person getPerson();
	//left
	public boolean hasLeft();
	public void setLeft(Node newLeft);
	public Node getLeft();
	//right
	public boolean hasRight();
	public void setRight(Node newRight);
	public Node getRight();
}
