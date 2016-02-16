public class testList {
	public static void main(String [] args){
	    LinkedList List = new LinkedList();
	    
	    String s1 = "water";
	    String s2 = "juice";
	    String s3 = "milk";
	    String s4 = "coffee";
	    int n1 = 4;
	    
	    //Inserts four strings into list then prints
	    List.insert(s1);
	    List.insert(s2);
	    List.insert(s3);
	    List.insert(s4);
	    List.printList();
	    
	    //Looks up if n1 ans s2 are in the list
	    System.out.println(List.lookup(n1));
	    System.out.println(List.lookup(s2));
	    
	    //Deletes s3 from list then prints
	    List.delete(s3);
	    List.printList();
	  }

}
