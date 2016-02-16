/*
Class Word.java creates a new Word object defined by a string (the word itself)
and an integer (the number of occurrences)
*/

import java.util.*;

public class Word implements Comparable<Word>{
	String s;
	int c;
	
	public Word(String str, int count){
		s = str;
		c = count;
	}
	
	//toString prints number of occurrences and word
	public String toString(){
		String cString = String.format("%06d", c);
		String wordString = cString + "  " + s.toString();
		return wordString;
	}
	
	public int compareTo(Word arg0) {
		return s.compareToIgnoreCase(arg0.s);
	}
}
