package main;
//Sorted Tree Set stores and organizes alphabetically
//Nodes containing Nintendo characters HR data and
//formats all of it to a data sheet written out to file
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
		//new person
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
		//Else the new person is not the first and must 
		//be compared alphabetically to the other items in the list
		else 
		{
			Node current = head;
			//While we have not added the new person
			while(current != newPerson)
			{
				//TEST
				System.out.println("While current != newPerson\n");
				System.out.println("Current: " + current.getName() + " \n" + "New Person: "
								+ newPerson.getName() + "\n");
				//If the new person is further in the alphabet then
				//the current person in the list being checked
				if(newPerson.getName().charAt(0) > current.getName().charAt(0))
				{
					System.out.println(newPerson.getName() + " should go to right");
					//if the next right branch is empty
					//the newPerson takes that position
					if(current.getRight() == null)
					{
						current.setRight(newPerson);
						newPerson.setParent(current);
						current = current.getRight();
						System.out.println("Added " + current.getName() + " to right\n");
						System.out.println("New's parent is " + current.getParent().getName());
						totalTree += (newPerson.getName() + "\n");
					}
					//Else there is another person to the right who must
					//be checked, so they become current, and the loop repeats
					else {current = current.getRight();}
				}//END right branch
				//The new person goes before the current person being checked
				else
				{
					System.out.println(newPerson.getName() + " should go to left");
					//if the next left branch is empty
					//the new person takes that position
					if(current.getLeft() == null)
					{
						current.setLeft(newPerson);
						newPerson.setParent(current);
						current = current.getLeft();
						System.out.println("Added " + current.getName() + " to left\n");
						System.out.println("New's parent is " + current.getParent().getName());
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
	public String toString()
	{
		String header = String.format("%-9s %-12s %-12s\n", 
				"Name", "Height (cm)", "Weight (kg)");
		String toReturn = header;
		Node current = head;
		//left
		while(current.getLeft() != null)
		{
			current = current.getLeft();
		}
		
		Node farLeft = current;
		
		while(farLeft != head)
		{
			toReturn += farLeft.toString() + "\n";
			toReturn += farLeft.getParent().toString() + "\n";
			if (farLeft.getParent().hasRight() == true)
			{
				toReturn += farLeft.getParent().getRight().toString() + "\n";
			}
			farLeft = farLeft.getParent().getParent();
		}
		if(farLeft == head)
		{
			toReturn += farLeft.toString() + "\n";
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
			toReturn += farRight.toString() + "\n";
			toReturn += farRight.getParent().toString() + "\n";
			if (farRight.getParent().hasRight() == true)
			{
				toReturn += farRight.getParent().getRight().toString() + "\n";
			}
			farRight = farRight.getParent().getParent();
		}
		return toReturn;
		
		//root
		
		//right
	}
}
