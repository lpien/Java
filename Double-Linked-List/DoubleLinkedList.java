
public class DoubleLinkedList implements MyDoubleLinkedList{
		
		
		//Constructor of MyDoubleNode, head, and tail
		//Initialize head and tail to null
		MyDoubleNode head, tail;
		public DoubleLinkedList(){
			tail = new MyDoubleNode(null, null, null);
			head = new MyDoubleNode(null, null, null);
			
			head.next = tail;
			tail.prev = head;
		}
		
		//Method inserts data into new node
		//If head and tail do not contain data then data entered is new head
		//If tail does not contain data then data entered is new tail
		//If head and tail both contain data,
		//	new node created is inserted after head node
		public void insert(Object x){
			if (lookup(x) == false){
				if(head.data == null && tail.data == null)
					head.data = x;
				else if(tail.data == null)
					tail.data = x;
				else{
					MyDoubleNode temp = new MyDoubleNode(x, head.next, head);
					head.next = temp;
					temp.next.prev = temp;
				}
			}	
		}
		
		//Deletes node and reorganizes links
		public void delete(Object x){
			boolean b = lookup(x);
			if(b == true){
				MyDoubleNode current;
				current = head;
				if(head.data == x)
					head = head.next;
				else{
					while(current != null){
						if(current.next.data == x){
							current.next = current.next.next;
							break;
						}
						current = current.next;
					}
				}
			}
		}
		
		//Returns true if data appears in linked list
		public boolean lookup(Object x){
			boolean b = false;
			MyDoubleNode current;
			current = head;
			while(current != null){
				if(current.data == x){
					b = true;
					break;
				}
				current = current.next;
			}
			return b;
		}
		
		//Returns true if linked list is empty
		public boolean isEmpty(){
			if(head == null && tail == null)
				return true;
			else
				return false;
		}
		
		//Prints list
		public void printList(){
			MyDoubleNode current;
			current = head;
			while(current != null){
				System.out.println(current);
				current = current.next;
			}
		}
		
		//Prints list in reverse
		public void printListRev(){
			MyDoubleNode current;
			current = tail;
			while(current != null){
				System.out.println(current);
				current = current.prev;
			}
		}
}
