public class MyNode {
	public Object data;
	public MyNode next;
	  
	public MyNode(Object d, MyNode n){
	  data = d;
	  next = n;
	}
    public String toString(){
    	return data.toString();
    }
}
