package node;

import interfaces.IGenericClassMethods;

public class Node<T extends IGenericClassMethods> {
	public T current;
	public Node<T> next;

	public Node(T current){
		this.current = current;
		next = null;
	}

}
