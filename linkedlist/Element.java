package linkedlist;

public class Element<T> {
    private T value;
    private Element<T> next;

    public Element(T new_value) {
        this.value = new_value;
    }

    public T getValue() {
        return this.value;
    }

    public Element<T> getNext() {
        return this.next;
    }

    public void setValue(T v) {
        this.value = v;
    }

    public void setNext(Element<T> n) {
        this.next = n;
    }
}
