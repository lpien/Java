/*Lauren Pien
 * lpien@u.rochester.edu
 * Project 4: Typing Up A Storm
 * Due Fri Nov 21
 * CSC 172
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class newKeyboard {
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("test.txt"));
		BufferedReader br = null;
		Queue <Character>letters = new LinkedList<Character>();		//Queue of all characters read from file
		Queue <Character>letterCopy = new LinkedList<Character>();
		Queue <String>allKeys = new LinkedList<String>();			//Queue of all possible keys to press

		ArrayList <String>Lhand = new ArrayList<String>();				//List of all left handed keys for original keyboard
		ArrayList <String>Rhand = new ArrayList<String>();				//List of all right handed keys for original keyboard

		
		double time = 0.0;
		double start = 0.0;
		double end = 0.0;
		double elapsed;
		
		//Input all possible keys in a queue
		allKeys.add("1");
		allKeys.add("!");
		allKeys.add("2");
		allKeys.add("@");
		allKeys.add("3");
		allKeys.add("#");
		allKeys.add("4");
		allKeys.add("$");
		allKeys.add("5");
		allKeys.add("%");
		allKeys.add("6");
		allKeys.add("^");
		allKeys.add("7");
		allKeys.add("&");
		allKeys.add("8");
		allKeys.add("*");
		allKeys.add("9");
		allKeys.add("(");
		allKeys.add("0");
		allKeys.add(")");
		allKeys.add("-");
		allKeys.add("_");
		allKeys.add("+");
		allKeys.add("=");
		allKeys.add("\\");
		allKeys.add("|");
		allKeys.add("}");
		allKeys.add("]");
		allKeys.add("{");
		allKeys.add("[");
		allKeys.add("p");
		allKeys.add("P");
		allKeys.add("i");
		allKeys.add("I");
		allKeys.add("u");
		allKeys.add("U");
		allKeys.add("y");
		allKeys.add("Y");
		allKeys.add("w");
		allKeys.add("W");
		allKeys.add("q");
		allKeys.add("Q");
		allKeys.add("d");
		allKeys.add("D");
		allKeys.add("f");
		allKeys.add("F");
		allKeys.add("g");
		allKeys.add("G");
		allKeys.add("j");
		allKeys.add("J");
		allKeys.add("k");
		allKeys.add("K");
		allKeys.add("l");
		allKeys.add("L");
		allKeys.add(";");
		allKeys.add(":");
		allKeys.add("'");
		allKeys.add("\"");
		allKeys.add("\n");
		allKeys.add("/");
		allKeys.add("?");
		allKeys.add(".");
		allKeys.add(">");
		allKeys.add(",");
		allKeys.add("<");
		allKeys.add("m");
		allKeys.add("M");
		allKeys.add("n");
		allKeys.add("N");
		allKeys.add("b");
		allKeys.add("B");
		allKeys.add("v");
		allKeys.add("V");
		allKeys.add("c");
		allKeys.add("C");
		allKeys.add("x");
		allKeys.add("Z");
		
		//Add specific keys for left and right side
		Lhand.add("e");
		Lhand.add("E");
		Lhand.add("s");
		Lhand.add("S");
		Lhand.add("t");
		Lhand.add("T");
		Lhand.add("A");
		Lhand.add("a");
		Lhand.add("o");
		Lhand.add("O");
		
		Rhand.add("r");
		Rhand.add("R");
		Rhand.add(" ");
		Rhand.add("h");
		Rhand.add("H");
		
		start = System.currentTimeMillis();
		try{														//Read all characters from text
			int c = 0;
			br = new BufferedReader(new FileReader("test.txt"));
			while((c = br.read()) != -1){
				char character = (char) c;
				letters.add(character);
				letterCopy.add(character);
				if((char)character == ('\r')){
					letters.remove(character);
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			try{
				if(br != null)br.close();
			}
			catch(IOException ex){
				ex.printStackTrace();
			}
		}
		scan.close();
		
		do{
			if(letters.size()<2){
				break;
			}
			char a = (char) letters.remove();								//Create diad string and add to either left or right
			char b = (char) letters.peek();									//until all possible keys are positioned
			String convertA = Character.toString(a);
			String convertB = Character.toString(b);
			if(allKeys.contains(convertA) && allKeys.contains(convertB)){
				allKeys.remove(convertA);
				allKeys.remove(convertB);
				Lhand.add(convertA);
				Rhand.add(convertB);
			}
			
		}while(!letters.isEmpty());
		
		//Sorts all remaining keys
		if(allKeys.isEmpty() == true){
			String str = allKeys.remove();
			String str2 = allKeys.remove();
			Lhand.add(str);
			Rhand.add(str2);
		}
		
		System.out.println("Keys on left side of personal keyboard: " + Lhand);
		System.out.println("Keys on right side of personal keyboard: " + Rhand);
		
		Scanner scan2 = new Scanner(new File("test.txt"));
		
		do{
			if(letterCopy.size()<2){
			break;
		}
			char one = (char) letterCopy.remove();
			char two = (char) letterCopy.peek();
			String convertOne = Character.toString(one);
			String convertTwo = Character.toString(two);
			if(Rhand.contains(convertOne) && Rhand.contains(convertTwo))			//Adding hypothetical time
				time += 1.0;
			if(Lhand.contains(convertOne) && Lhand.contains(convertTwo))
				time += 1.0;
			if(Lhand.contains(convertOne) && Rhand.contains(convertTwo))
				time += .5;
			if(Lhand.contains(convertTwo) && Rhand.contains(convertOne))
				time += .5;
		}while(scan2.hasNext());
		scan2.close();
	
		System.out.println("\nHypothetical time for own keyboard: " + time + " seconds");
		
		end = System.currentTimeMillis();
		elapsed = end - start;
		double sec = elapsed / 1000;
		System.out.println("\nTotal runtime for program was " + elapsed + " milliseconds (= " + sec + " seconds)");
	}	
}
