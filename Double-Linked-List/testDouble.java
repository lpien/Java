
public class testDouble {
	public static void main(String [] args){
		DoubleLinkedList L1 = new DoubleLinkedList();
		
		String s1 = "book";
		String s2 = "pencil";
		String s3 = "pen";
		String s4 = "sticky notes";
		String s5 = "computer";
		
		//inserts strings into linked list
		L1.insert(s1);
		L1.insert(s2);
		L1.insert(s3);
		L1.insert(s4);
		
		//prints list forwards and in reverse
		L1.printList();
		L1.printListRev();
		
		//prints if list is empty or not
		System.out.println(L1.isEmpty());
		
		//prints true if string exists, false if not
		System.out.println(L1.lookup(s1));
		System.out.println(L1.lookup(s5));
		
		L1.delete(s3);
		L1.printList();
	}

}
