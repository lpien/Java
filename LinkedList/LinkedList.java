
public class LinkedList implements MyLinkedList{
	  MyNode s;
	  public LinkedList(){
	    s = null;
	  }
	  
	  /* Expected runtime is O(1) when inserting new data
	   * 
	   * Expected runtime is O(n) when implementing the
	   * lookup method
	   */ 
	  public void insert(Object x){
		boolean t = lookup(x);
	    if(t == false){
	      if(s == null)
	        s = new MyNode(x, null);
	      else{
	        MyNode temp = s.next;
	        s.next = new MyNode(x, temp);
	      }
	    }
	    else
	      System.out.println("Item exists");
	  }
	  
	  public void delete(Object x){
	      boolean t = lookup(x);
		  if(t == true){
	        MyNode current;
	        current = s;
	    	if(s.data == x)
	        s = s.next;
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
	  
	  //returns true if object is contained in list
	  public boolean lookup(Object x){
	    boolean b = false;
	    MyNode current;
	    current = s;
	    while(current != null){
	      if(current.data == x){
	        b = true;
	      }
	      current = current.next;
	    }
	    return b;
	  }
	  
	  public boolean isEmpty(){
	    if(s == null)
	      return true;
	    else
	      return false;
	  }
	  
	  public void printList(){
	    MyNode current;
	    current = s;
	    while(current != null){
	      //System.out.println(current.data);
	      System.out.println(current);
	      current = current.next;
	    }
	  }

}
