package linkedlist;

public class LinkedList {
	private Element first;
	private Element last;
	private int size;

	public LinkedList() {
		this.size = 0;
	}

	public Element getFirst() {
		return this.first;
	}

	public Element getLast() {
		return this.last;
	}

	public int getSize() {
		return this.size;
	}

	public void setFirst(Element f) {
		this.first = f;
	}

	public void setLast(Element l) {
		this.last = l;
	}

	public void setSize(int s) {
		this.size = s;
	}

	public void add(String new_value) {
		Element newElement = new Element(new_value);
		if (this.first == null && this.last == null) {
			this.first = newElement;
			this.last = newElement;
		} else {
			this.last.setNext(newElement);
			this.last = newElement;
		}
		this.size++;
	}

	public void remove(String searching) {
		Element previous = null;
		Element current = this.first;
		for (int i = 0; i < this.getSize(); i++) {
			if (current.getValue().equalsIgnoreCase(searching)) {
				if (this.getSize() == 1) {
					this.first = null;
					this.last = null;
				} else if (current == this.first) {
					this.first = current.getNext();
					current.setNext(null);
				} else if (current == this.last) {
					this.last = previous;
					previous.setNext(null);
				} else {
					previous.setNext(current.getNext());
					current = null;
				}
				this.size--;
				break;
			}
			previous = current;
			current = current.getNext();
		}
	}

	public Element get(int pos) {
		Element current = this.first;
		for (int i = 0; i < pos; i++) {
			if (current.getNext() != null) {
				current = current.getNext();
			}
		}
		return current;
	}
}