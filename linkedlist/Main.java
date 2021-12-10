package linkedlist;

public class Main {
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("AC");
		list.add("SE");
		list.add("BA");
		list.add("CE");
		list.add("DF");
		System.out.println("Size: " + list.getSize());
		System.out.println("First: " + list.getFirst().getValue());
		System.out.println("Last: " + list.getLast().getValue());

		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i).getValue());
		}

		System.out.println("Remove CE");
		list.remove("CE");
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i).getValue());
		}

		System.out.println("Remove AC");
		list.remove("AC");
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i).getValue());
		}

		System.out.println("Remove DF");
		list.remove("DF");
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i).getValue());
		}

		System.out.println("Remove BA");
		list.remove("BA");
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i).getValue());
		}

		System.out.println("Remove SE");
		list.remove("SE");
		for (int i = 0; i < list.getSize(); i++) {
			System.out.println(list.get(i).getValue());
		}

		System.out.println("Size: " + list.getSize());

		list.add("RJ");
		System.out.println("Size: " + list.getSize());
		System.out.println("First: " + list.getFirst().getValue());
		System.out.println("Last: " + list.getLast().getValue());
	}
}