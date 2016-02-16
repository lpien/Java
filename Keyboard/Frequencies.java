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
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Frequencies {
	
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File("test.txt"));
		BufferedReader br = null;
		Queue <Character>letters = new LinkedList<Character>();		//Queue of all characters read from file
		ArrayList <String>diads = new ArrayList<String>();				//Queue of all diads formed from file
		ArrayList <Diad> diFreq = new ArrayList<Diad>();				//Queue of distinct diads and their frequencies
		long startTime = 0;
		long endTime = 0;
		long elapsed = 0;
		
		int totalDiad = 0;											//total diad count
		int distinctCount = 0;										//counts total number of distinct diads
		Diad d = new Diad(0, "", false);
		startTime = System.currentTimeMillis();
		try{
			
			int c = 0;
			int count = 0;
			br = new BufferedReader(new FileReader("test.txt"));
			while((c = br.read()) != -1){
				char character = (char) c;
				letters.add(character);
				if((char)character == ('\r')){
					count--;
					letters.remove(character);
				}
				count++;
			}
			System.out.println("Total number of characters: " + count + "\n");	
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
			char a = (char) letters.remove();
			char b = (char) letters.peek();
			String convertA = Character.toString(a);
			String convertB = Character.toString(b);
			String diad = convertA + convertB;
			if(diads.contains(diad) == false){
														//checks to see if queue already contains string
				distinctCount++;						//if not, then increases count of distinct diads
			}
			diads.add(diad);
			totalDiad++;
		}while(!letters.isEmpty());
		System.out.println("Total number of diads: " + totalDiad + "\n");
		System.out.println("Distinct number of diads: " + distinctCount + "\n");
		int freq = 0;
		String temp;
		
		while(!diads.isEmpty()){
			for(int i = 0; i < diads.size(); i++){
				temp = diads.get(i);
				freq = Collections.frequency(diads, diads.get(i));
				d = new Diad(freq, temp, false);
				diFreq.add(d);
				diads.remove(i);
				while(diads.contains(temp)){
					diads.remove(temp);
				}
			}
		}
		System.out.println("Top 10 Frequent Diads:");
		Collections.sort(diFreq);
		for(int j = 0; j < 10; j++){
			if(diFreq == null){
				System.out.println("Error");
				break;
			}
			System.out.println(j+ ": " + diFreq.get(j));
		}
		endTime = System.currentTimeMillis();
		elapsed = endTime - startTime;
		double sec = elapsed / 1000.0;
		System.out.println();
		System.out.println("Runtime was " + elapsed + " milliseconds (= " + sec + " seconds)");
	}	
}
