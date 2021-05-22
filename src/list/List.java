package list;

import javax.swing.JOptionPane;

import interfaces.IGenericClassMethods;
import interfaces.ILinkedList;
import node.Node;

// T pode ser qualquer coisa (Client, Rent e  Address respectivamente);

// precisamos que todas as classes tenham um metodo getAllPropertys(), para retornar as props do mesmo, por isso  criamos IGenericClassMethods;

// Criamos a ILinkedList para facilitar a implementação de metodos durante o desenvolvimento do codigo;

// t = type

public class List<T extends IGenericClassMethods> implements ILinkedList<T> {
	private Node<T> node;

	public List() {
		this.node = null;
	}

	@Override
	public boolean isEmpty() {
		if (this.node != null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void addAtEnd(T item) {
		if (this.node == null) {
			Node<T> node = new Node<T>(item);
			this.node = node;
		} else {
			Node<T> aux = this.node;
			while (aux.next != null) {
				aux = aux.next;
			}
			Node<T> node = new Node<T>(item);
			aux.next = node;
		}
	}

	@Override
	public void addAtBeginning(T item) {
		Node<T> n = new Node<T>(item);
		n.next = this.node;
		this.node = n;
	}

	@Override
	public T removeAtEnd() {
		T itemToReturn = null;
		if (this.node == null) {
			JOptionPane.showMessageDialog(null, "Lista Vázia");
		} else {
			if (this.node.next == null) {
				itemToReturn = this.node.current;
				this.node = null;
			} else {
				Node<T> aux1 = this.node;
				Node<T> aux2 = this.node;

				while (aux1.next != null) {
					aux2 = aux1;
					aux1 = aux1.next;
				}
				itemToReturn = aux1.current;
				aux2.next = null;
			}
		}
		return itemToReturn;
	}

	@Override
	public T removeAtBeginning() {
		T itemToReturn = null;
		if (this.node == null) {
			JOptionPane.showMessageDialog(null, "Lista Vázia");
		} else {
			itemToReturn = this.node.current;
			this.node = this.node.next;
		}
		return itemToReturn;
	}

	@Override
	public void addInAnyPosition(T item, int pos) {
		Node<T> novo = new Node<T>(item);

		if (pos == 1) {
		} else {
			Node<T> aux = this.node;
			int count = 1;

			while (aux.next != null && count < pos - 1) {
				aux = aux.next;
				count++;
			}

			if (count == pos - 1) {
				novo.next = aux.next;
				aux.next = novo;
			} else {
				JOptionPane.showMessageDialog(null, "Posição Inválida!");
			}
		}
	}

	@Override
	public T removeInAnyPosition(int pos) {
		T itemToReturn = null;
		int i = 1;
		Node<T> aux = this.node;

		if (this.node == null) {
			JOptionPane.showMessageDialog(null, "Lista Vazia!");
			return itemToReturn;
		}
		if (pos == 1) {
			itemToReturn = removeAtEnd();
			return itemToReturn;
		} else {
			while (aux.next != null) {
				aux = aux.next;
				i++;
			}

			if (pos > i || pos <= 0) {
				JOptionPane.showMessageDialog(null, "Posição Invalida!");
				return itemToReturn;
			} else if (pos == i) {
				itemToReturn = removeAtEnd();
				return itemToReturn;
			} else {
				aux = this.node;
				Node<T> aux2 = aux;

				while (pos > 1) {
					aux2 = aux;
					aux = aux.next;
					pos--;
				}
				itemToReturn = aux.current;
				aux2.next = aux.next;
				return itemToReturn;
			}
		}
	}

	@Override
	public String showListValues() {
		Node<T> aux = this.node;
		int i = 0;
		String lines = "";
		while (aux != null) {
			lines += (i + 1) + ";" + aux.current.getAllPropertys();
			lines += "\n";
			aux = aux.next;
			i++;
		}
		return lines;
	}

}
