package main;

import java.util.ArrayList;

public class PersonImperialSet extends PersonSet{
private ArrayList<Person> imperialList;
	
	public PersonImperialSet()
	{
		imperialList = new ArrayList<Person>();
	}

	@Override
	public void add(Person person)
	{
		person.convertHeight();
		person.convertWeight();
		if(!(imperialList.contains(person)))
		{
			imperialList.add(person);
			super.add(person);
		}
	}
}
