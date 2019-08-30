
public class Node
{
	// instance variables
	private Words data;
	private Node next;
	private Node previous;

	// costructor
	// Node takes in a Words object as the parameter
	public Node(Words d)
	{
		data = d;
	}

	// Accessor method:
	// returns current value of data
	public Words getData()
	{
		return data;
	}

	// Mutator method:
	// allows user to set data
	public void setData(Words newData)
	{
		data = newData;
	}

	// Accessor method:
	// returns current value of next
	public Node getNext()
	{
		return next;
	}

	// Mutator method:
	// allows user to set next reference
	public void setNext(Node newNext)
	{
		next = newNext;
	}

	// Accessor method:
	// returns current value of previous
	public Node getPrevious()
	{
		return previous;
	}

	// Mutator method:
	// allows user to set previous reference
	public void setPrevious(Node newPrevious)
	{
		previous = newPrevious;
	}

	// toString: return a string representation of data of Node
	public String toString()
	{
		return data.toString();
	}
}
