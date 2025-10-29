package main;

public class SortedTreeSet implements SortedTreeSetInterface
{
	private Node head;
	private String totalTree;
	
	public SortedTreeSet()
	{
		head = null;
		totalTree = "";
	}

	@Override
	public Person getPerson() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLeft(SortedTreeSet left) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SortedTreeSet getLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setRight(SortedTreeSet right) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SortedTreeSet getRight() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String listTest()
	{
		return this.totalTree;
	}

	@Override
	public void add(Person p) 
	{
		Node newPerson = new Node(p);
		System.out.println("New Person: " + newPerson.getName() + "\n");
		//if the list is empty, first 
		//item becomes head of tree
		if(head == null)
		{
			System.out.println("==============\nadded " + newPerson.getName() + "to head\n==============");
			head = newPerson;
			totalTree += (newPerson.getName() + "\n");
		}
		//comes after head
		else 
		{
			Node current = head;
			while(current != newPerson)
			{
				System.out.println("While current != newPerson\n");
				System.out.println("Current: " + current.getName() + " \n" + "New Person: "
								+ newPerson.getName() + "\n");
				if(newPerson.getName().charAt(0) > current.getName().charAt(0))
				{
					System.out.println(newPerson.getName() + " should go to right");
					if(current.getRight() == null)
					{
						current.setRight(newPerson);
						newPerson.setParent(current);
						current = current.getRight();
						System.out.println("Added " + current.getName() + " to right\n");
						totalTree += (newPerson.getName() + "\n");
					}
					else {current = current.getRight();}
				}
				else
				{
					System.out.println(newPerson.getName() + " should go to left");
					if(current.getLeft() == null)
					{
						current.setLeft(newPerson);
						newPerson.setParent(current);
						current = current.getLeft();
						System.out.println("Added " + current.getName() + " to left\n");
						totalTree += (newPerson.getName() + "\n");
					}
					else {current = current.getLeft();}
				}
			}//while(current != newPerson)
		}
	}

}
