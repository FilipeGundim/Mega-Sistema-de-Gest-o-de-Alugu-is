package node;

public class Node<T> {
	public T current;
	public Node<T> next;

	public Node(T current){
		this.current = current;
		this.next = null;
	}

}
