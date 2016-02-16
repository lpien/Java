
/*
 * "Provides a Binary Search Tree mechanism using an array as 
 * the underlying representation, rather than a collection of
 * linked nodes"
 */

public class ArrayTree<Data extends Comparable<? super Data>> {
	private Data [] data;
	
	public ArrayTree(){
		data = (Data []) new Comparable[2];
	}
	
	public ArrayTree(int initial){
		data = (Data []) new Comparable[initial];	
	}
	
	/**
	 * Finds the size of the tree
	 * @return int - number of nodes in tree (ones being used)
	 */
	public int size(){
		int i = 0;
		for(int x = 1; x < data.length; x++){
			if(data[x] != null){
				i++;
			}
		}
		return i;
	}
	
	/**
	 * Finds the height of the tree
	 * @return int - height of tree (longest path)
	 */
	public int height(){		//height = node to leaf
		int index = 0;
		int height = 0;
		for(int i = 0; i < data.length; i++){
			if(data[i] != null){
				index = i;
			}
		}
		while(index >= 1){
			height++;
			index = index / 2;
		}
		return height - 1;
	}
	
	/**
	 * Finds the average depth of the tree
	 * @return double - average depth of all nodes
	 */
	public double aveDepth(){		//depth = number of nodes
		int total = 0;
		for(int i = 0; i < data.length; i++){
			int d = 0;
			if(data[i] != null){
				d = depth(i);
			}
			total = total + d;
		}
		double total2 = (double)total;
		double numNode = (double)size();
		return total2/numNode;
	}
	
	/**
	 * Calculates the depth of the tree as a double
	 * then converts it to an integer.  This integer
	 * is returned to be used in the method aveDepth
	 * @param x
	 * @return
	 */
	private int depth(int x){
		double d = Math.floor(Math.log(x) / Math.log(2));
		return (int) d;
	}
	
	/**
	 * If the BST already contains a data object d' equal to the given data
	 * object d then insert() does nothing and returns false, otherwise puts the
	 * given data object d in the BST and returns true.
	 * 
	 * @param d
	 * @return
	 */
	public boolean insert(Data d){
		if(find(d) != null){
			return false;
		}
		else{
			int i = 1;
			while(true){
				if(i > data.length - 1){
					Data [] bigArray = (Data []) new Comparable[data.length * 2];
					for(int counter = 0; counter < data.length; counter++){
						bigArray[counter] = data[counter];					//copying old array into new larger array
					}
					data = (Data[]) new Comparable[bigArray.length];
					for(int counter2 = 0; counter2<bigArray.length; counter2++){
						data[counter2] = bigArray[counter2];
					}
				}
				if(data[i] == null){
					data[i] = d;
					break;
				}
				else if(data[i].compareTo(d) > 0){
					i = left(i);
				}
				else if(data[i].compareTo(d) < 0){
					i = right(i);
				}
			}
		}
		return true;
	}
	
	/**
	 * find(d) if BST contains data d equal to given object d
	 * then find returns d, otherwise returns null
	 *  
	 * @param d
	 * @return
	 */
	public Data find(Data d){	
		boolean b = false;
		int i = 1;
		while(i < data.length){
			if(data[i] == null){
				break;
			}
			if(data[i].compareTo(d) == 0){
				b = true;
				break;
			}
			else if(data[i].compareTo(d) < 0){
				i = right(i);
			}
			else if(data[i].compareTo(d) > 0){
				i = left(i);
			}
	
		}
		if(b == true)
			return data[i];
		else
			return null;
	}
	
	/**
	 * In Order traversal of BST
	 * @param worker
	 */
	public void inOrder(Consumer<Data> worker){
		inOrder(worker, 1);
	}
	
	 /**
	  * @param flag - true if AVL property should be maintained, false otherwise
	  *            You are free to make this fail if flag == true && size() > 1.
	  *            Default behavior of the ArrayBST is keepBalanced(false).
	  */
	 public void keepBalanced(boolean flag) {
	 }
	 
	 private static int left(int t) {
		 return t * 2;
	 }

	 private static int right(int t) {
		 return (t * 2) + 1;
	 }

	 private static int parent(int t) {
		 return t / 2;
	 }
		 
	 private boolean isNull(int t) {
		 return t < 1 || t >= data.length || data[t] == null;
	 }
		 
	 private boolean hasLeft(int p) {
		 return !isNull(left(p));
	 }

	 private boolean hasRight(int p) {
		 return !isNull(right(p));
	 }
		 
	 /**
	  * Recursive helper method to walk over the tree in order
	  * @param worker - the functional object that gets to accept this node's data
	  * @param node - the tree node whose data is to be accepted by the worker
	  */
	 private void inOrder(Consumer<Data> worker, int node) {
		if(isNull(node)){
			return;
		}
		else{ 
			inOrder(worker, left(node));
			worker.accept(data[node]);
			inOrder(worker, right(node));
		}
	 }
}



 
 
