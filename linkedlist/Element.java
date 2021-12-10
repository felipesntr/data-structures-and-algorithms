package linkedlist;

public class Element {
    private String value;
    private Element next;

    public Element(String new_value) {
        this.value = new_value;
    }

    public String getValue() {
        return this.value;
    }

    public Element getNext() {
        return this.next;
    }

    public void setValue(String v) {
        this.value = v;
    }

    public void setNext(Element n) {
        this.next = n;
    }
}
