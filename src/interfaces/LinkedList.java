package interfaces;

public interface LinkedList<T extends GenericClassMethods> {
	public boolean isEmpty();

	public void addAtEnd(T item);

	public void addAtBeginning(T item);

	public T removeAtEnd();

	public T removeAtBeginning();

	public void addInAnyPosition(T item, int pos);

	public T removeInAnyPosition(int pos);
	
	public String showListValues(); 
}
