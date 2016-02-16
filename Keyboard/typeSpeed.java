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

public class typeSpeed {
		
		public static void main(String[] args) throws IOException{
			Scanner scan = new Scanner(new File("test.txt"));
			BufferedReader br = null;
			Queue <Character>letters = new LinkedList<Character>();		//Queue of all characters read from file
			
			ArrayList <String>LhandQ = new ArrayList<String>();				//List of all left handed keys for QWERTY
			ArrayList <String>RhandQ = new ArrayList<String>();				//List of all right handed keys for QWERTY
			ArrayList <String>OneHandQ = new ArrayList<String>();				//List of all one handed diads for QWERTY
			ArrayList <String>TwoHandQ = new ArrayList<String>();				//List of all two handed diads for QWERTY
			
			ArrayList<String>LhandD = new ArrayList<String>();					//List of all left handed keys for Dvorak
			ArrayList<String>RhandD = new ArrayList<String>();					//List of all right handed keys for Dvorak
			ArrayList<String>OneHandD = new ArrayList<String>();				//List of all one handed diads for Dvorak
			ArrayList<String>TwoHandD = new ArrayList<String>();				//List of all two handed diads for Dvorak
			
			//Counts total time
			double qwertyTime = 0.0;		
			double dvorakTime = 0.0;
			
			double start = 0.0;
			double end = 0.0;
			double elapsed;
			
			//Add keys to list based on QWERTY/Dvorak and L/R hand
			LhandQ.add("1");
			LhandQ.add("2");
			LhandQ.add("3");
			LhandQ.add("4");
			LhandQ.add("5");
			LhandQ.add("`");
			LhandQ.add("!");
			LhandQ.add("@");
			LhandQ.add("#");
			LhandQ.add("$");
			LhandQ.add("%");
			LhandQ.add("q");
			LhandQ.add("Q");
			LhandQ.add("w");
			LhandQ.add("W");
			LhandQ.add("e");
			LhandQ.add("E");
			LhandQ.add("r");
			LhandQ.add("R");
			LhandQ.add("t");
			LhandQ.add("T");
			LhandQ.add("a");
			LhandQ.add("A");
			LhandQ.add("s");
			LhandQ.add("S");
			LhandQ.add("d");
			LhandQ.add("D");
			LhandQ.add("f");
			LhandQ.add("F");
			LhandQ.add("g");
			LhandQ.add("G");
			LhandQ.add("z");
			LhandQ.add("Z");
			LhandQ.add("x");
			LhandQ.add("X");
			LhandQ.add("c");
			LhandQ.add("C");
			LhandQ.add("v");
			LhandQ.add("V");
			LhandQ.add("b");
			LhandQ.add("B");
			
			RhandQ.add("6");
			RhandQ.add("7");
			RhandQ.add("8");
			RhandQ.add("9");
			RhandQ.add("0");
			RhandQ.add("^");
			RhandQ.add("&");
			RhandQ.add("*");
			RhandQ.add("(");
			RhandQ.add(")");
			RhandQ.add("-");
			RhandQ.add("_");
			RhandQ.add("=");
			RhandQ.add("+");
			RhandQ.add("Y");
			RhandQ.add("y");
			RhandQ.add("u");
			RhandQ.add("U");
			RhandQ.add("i");
			RhandQ.add("I");
			RhandQ.add("o");
			RhandQ.add("O");
			RhandQ.add("p");
			RhandQ.add("P");
			RhandQ.add("[");
			RhandQ.add("{");
			RhandQ.add("]");
			RhandQ.add("}");
			RhandQ.add("h");
			RhandQ.add("H");
			RhandQ.add("j");
			RhandQ.add("J");
			RhandQ.add("k");
			RhandQ.add("K");
			RhandQ.add("l");
			RhandQ.add("L");
			RhandQ.add(";");
			RhandQ.add(":");
			RhandQ.add("'");
			RhandQ.add("\"");
			RhandQ.add("|");
			RhandQ.add("n");
			RhandQ.add("N");
			RhandQ.add("m");
			RhandQ.add("M");
			RhandQ.add(",");
			RhandQ.add("<");
			RhandQ.add(".");
			RhandQ.add(">");
			RhandQ.add("/");
			RhandQ.add("?");
			RhandQ.add("\n");
			RhandQ.add(" ");
			RhandQ.add("\\");
			
			LhandD.add("1");
			LhandD.add("2");
			LhandD.add("3");
			LhandD.add("4");
			LhandD.add("5");
			LhandD.add("!");
			LhandD.add("@");
			LhandD.add("#");
			LhandD.add("$");
			LhandD.add("%");
			LhandD.add("\"");
			LhandD.add(",");
			LhandD.add("<");
			LhandD.add("'");
			LhandD.add(">");
			LhandD.add(".");
			LhandD.add("P");
			LhandD.add("p");
			LhandD.add("Y");
			LhandD.add("y");
			LhandD.add("A");
			LhandD.add("a");
			LhandD.add("O");
			LhandD.add("o");
			LhandD.add("E");
			LhandD.add("e");
			LhandD.add("U");
			LhandD.add("u");
			LhandD.add("I");
			LhandD.add("i");
			LhandD.add(":");
			LhandD.add(";");
			LhandD.add("Q");
			LhandD.add("q");
			LhandD.add("J");
			LhandD.add("j");
			LhandD.add("K");
			LhandD.add("k");
			LhandD.add("X");
			LhandD.add("x");

			RhandD.add("F");
			RhandD.add("f");
			RhandD.add("G");
			RhandD.add("g");
			RhandD.add("C");
			RhandD.add("c");
			RhandD.add("R");
			RhandD.add("r");
			RhandD.add("L");
			RhandD.add("l");
			RhandD.add("?");
			RhandD.add("/");
			RhandD.add("+");
			RhandD.add("=");
			RhandD.add("|");
			RhandD.add("\\");
			RhandD.add("D");
			RhandD.add("d");
			RhandD.add("H");
			RhandD.add("h");
			RhandD.add("T");
			RhandD.add("t");
			RhandD.add("N");
			RhandD.add("n");
			RhandD.add("S");
			RhandD.add("s");
			RhandD.add("-");
			RhandD.add("_");
			RhandD.add("\n");
			RhandD.add(" ");
			RhandD.add("B");
			RhandD.add("b");
			RhandD.add("M");
			RhandD.add("m");
			RhandD.add("W");
			RhandD.add("w");
			RhandD.add("V");
			RhandD.add("v");
			RhandD.add("Z");
			RhandD.add("z");
			RhandD.add("6");
			RhandD.add("7");
			RhandD.add("8");
			RhandD.add("9");
			RhandD.add("0");
			RhandD.add("^");
			RhandD.add("&");
			RhandD.add("*");
			RhandD.add("(");
			RhandD.add(")");
			RhandD.add("{");
			RhandD.add("[");
			RhandD.add("]");
			RhandD.add("}");
			
			start = System.currentTimeMillis();
			try{
				int c = 0;
				br = new BufferedReader(new FileReader("test.txt"));
				
				//creates queue of all characters read from file
				while((c = br.read()) != -1){
					char character = (char) c;
					letters.add(character);
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
				if(letters.size()< 2){
					break;
				}
				char a = (char) letters.remove();
				char b = (char) letters.peek();
				String convertA = Character.toString(a);
				String convertB = Character.toString(b);
				String diadQ = convertA + convertB;						//Creates diad string for QWERTY
				
				String DvorakA = convertA;
				String DvorakB = convertB;
				String diadD = DvorakA + DvorakB;						//Creates diad string for Dvorak
				
				//Checks to see if diad is one or two handed for both QWERTY and Dvorak keyboards
				//Time is incremented based on handedness
				//Diad strings are sorted to an array list
				if(LhandQ.contains(convertA) && LhandQ.contains(convertB)){
					OneHandQ.add(diadQ);
					qwertyTime += 1.0;
				}
				if(RhandQ.contains(convertA) && RhandQ.contains(convertB)){
					OneHandQ.add(diadQ);
					qwertyTime += 1.0;
				}
				if(LhandQ.contains(convertB) && RhandQ.contains(convertA)){
					TwoHandQ.add(diadQ);
					qwertyTime = qwertyTime + .5;
				}
				if(LhandQ.contains(convertA) && RhandQ.contains(convertB)){
					TwoHandQ.add(diadQ);
					qwertyTime += .5;
				}
				if(LhandD.contains(DvorakA) && LhandD.contains(DvorakB)){
					OneHandD.add(diadD);
					dvorakTime += 1.0;
				}
				if(RhandD.contains(DvorakA) && RhandD.contains(DvorakB)){
					OneHandD.add(diadD);
					dvorakTime += 1.0;
				}
				if(LhandD.contains(DvorakB) && RhandD.contains(DvorakA)){
					TwoHandD.add(diadD);
					dvorakTime += .5;
				}
				if(LhandD.contains(DvorakA) && RhandD.contains(DvorakB)){
					TwoHandD.add(diadD);
					dvorakTime += .5;
				}
			}while(!letters.isEmpty());
			end = System.currentTimeMillis();
			elapsed = end - start;
			double sec = elapsed / 1000;
			
			System.out.println(OneHandQ.size() + " one handed diads for QWERTY");
			System.out.println(TwoHandQ.size() + " two handed diads for QWERTY");
			System.out.println("Hypothetical time for QWERTY: " + qwertyTime + " seconds");
			
			System.out.println("\n" + OneHandD.size() + " one handed diads for Dvorak");
			System.out.println(TwoHandD.size() + " two handed diads for Dvorak");
			System.out.println("Hypothetical time for Dvorak: " + dvorakTime + " seconds");
			
			System.out.println("\nTotal runtime for program: " + elapsed + " milliseconds (= " + sec + " seconds)");
		
	}
}
