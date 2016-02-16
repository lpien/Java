/*
Test class -- uses regex to define a new Word and inserts into the ArrayTree.
Prints out final statistics
*/

import java.util.*;
import java.util.regex.Pattern;

public class test{
	public static void main(String [] args){
		Scanner input = new Scanner(System.in);
		ArrayTree <Word>a = new ArrayTree<Word>();
		
		System.out.println("Input your text, then press Ctrl + z");
		
		//Iterates through input and counts number of words
		int wordCount = 0;
		while(input.hasNext()){
			String point = input.next();
				if(Pattern.matches("[A-Za-z]+('a-z]+)?", point)){
				wordCount++;
				Word newWord = new Word(point, 1);
				if(a.find(newWord) == null){
					a.insert(newWord);
				}
				else{
					a.find(newWord).c++;
				}
			}
		}
		input.close();
		a.inOrder(new printConsumer<Word>(a.size()));
		System.out.println("Total number of words: " + wordCount);
		System.out.println("Number of unique words: " + a.size());
		System.out.println("Height: " + a.height());
		System.out.println("Average depth of a node: " + a.aveDepth());		
	}
}
