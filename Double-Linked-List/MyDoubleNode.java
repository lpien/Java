
public class MyDoubleNode {
	public Object data;
	public MyDoubleNode next;
	public MyDoubleNode prev;
	
	public MyDoubleNode(Object d, MyDoubleNode n, MyDoubleNode p){
		data = d;
		next = n;
		prev = p;
	}
	
	public String toString(){
		return data.toString();
	}

}
