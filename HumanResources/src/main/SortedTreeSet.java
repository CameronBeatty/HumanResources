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

	//=================================================
	//ADD
	//=================================================
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
						System.out.println("New's parent is " + current.getParent().getName());
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
						System.out.println("New's parent is " + current.getParent().getName());
						totalTree += (newPerson.getName() + "\n");
					}
					else {current = current.getLeft();}
				}
			}//while(current != newPerson)
		}
	}//End of add()
	
	//===================================================================== 
    //toString()
	//=====================================================================
	
	@Override
	public String toString()
	{
		String toReturn = "";
		Node current = head;
		//left
		while(current.getLeft() != null)
		{
			current = current.getLeft();
		}
		
		Node farLeft = current;
		
		while(farLeft != head)
		{
			toReturn += farLeft.getName() + "\n";
			toReturn += farLeft.getParent().getName() + "\n";
			if (farLeft.getParent().hasRight() == true)
			{
				toReturn += farLeft.getParent().getRight().getName() + "\n";
			}
			farLeft = farLeft.getParent().getParent();
		}
		if(farLeft == head)
		{
			toReturn += farLeft.getName() + "\n";
		}
		
		Node farRight = head.getRight();
		while(farRight.hasNext())
		{
			if(farRight.hasRight() == true)
			{
				farRight = farRight.getRight();
			}
			else
			{
				farRight = farRight.getLeft();
			}
		} 
		while (farRight != head)
		{
			toReturn += farRight.getName() + "\n";
			toReturn += farRight.getParent().getName() + "\n";
			if (farRight.getParent().hasRight() == true)
			{
				toReturn += farRight.getParent().getRight().getName() + "\n";
			}
			farRight = farRight.getParent().getParent();
		}
		return toReturn;
		
		//root
		
		//right
	}
}
