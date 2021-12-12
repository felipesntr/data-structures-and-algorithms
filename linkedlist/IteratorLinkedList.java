package linkedlist;

public class IteratorLinkedList<T> {
    private Element<T> element;

    public IteratorLinkedList(Element<T> current) {
        this.element = current;
    }

    public boolean haveNext() {
        return element.getNext() != null ? true : false;
    }

    public Element<T> getNext() {
        element = element.getNext();
        return element;
    }
}
