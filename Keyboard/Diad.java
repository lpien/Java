/*Lauren Pien
 * lpien@u.rochester.edu
 * Project 4: Typing Up A Storm
 * Due Fri Nov 21
 * CSC 172
 */

public class Diad implements Comparable<Diad>{
	int freq;
	String d;
	boolean oneHand;
	
	public Diad(int f, String diad, boolean o){
		freq = f;
		d = diad;
		oneHand = o;
	}
	
	public int getFreq(){
		return freq;
	}
	
	public String getDiad(){
		return d;
	}
	
	public String toString(){
		return "Diad " + d + " with frequency " + freq;
	}

	@Override
	/*public int compareTo(Diad arg0) {
		// TODO Auto-generated method stub
		return d.compareTo(arg0.d);
	}*/
	
	public int compareTo(Diad compareDiad){
		int compareFreq = ((Diad) compareDiad).getFreq();
		return compareFreq - freq;
	}

}
