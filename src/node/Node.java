package node;

import interfaces.GenericClassMethods;

public class Node<T extends GenericClassMethods> {
	public T current;
	public Node<T> next;

	public Node(T current){
		this.current = current;
		next = null;
	}

}
