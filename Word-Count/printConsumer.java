/*
If the total word count is greater than 40 words, the output will only print the 
first and last 20 words with ellipses in between.
*/

public class printConsumer <AnyType> implements Consumer<AnyType>{
	public int total;
	public int count;
	
	public printConsumer(int t){
		total = t;
		count = 0;
	}
	
	public void accept(AnyType actor){
		count++;
		if(total>40){
			if(count <= 20){
				System.out.println(actor.toString());
			}
			if(count == 21){
				System.out.println("...");
			}
			if(count >= total - 20){
				System.out.println(actor.toString());
			}
		}
		else{
			System.out.println(actor.toString());
		}
	}

}
