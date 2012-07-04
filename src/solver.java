import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;


public class solver {
	
	public int numOfStd = 0;
	public int numOfRevision = 0;
	public int numOfGroup = 0;
	public int numOfTestCases = 0;
	public int [] stdIndexScore;
	public int [] groupTotal;
	public int [] scoreAwarded;

	public String ParseText() throws NumberFormatException, IOException{
		String output = "";
		String line = null;
		String [] tag = null;
		int i =0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//System.out.print(">> "); 
		numOfTestCases = Integer.valueOf(reader.readLine().trim());
		
		
		while(i < numOfTestCases){
			//System.out.print(">> "); 
			line = reader.readLine();
			
			tag = line.split("\\s");
		
			numOfStd = Integer.valueOf(tag[0]); 
			numOfRevision = Integer.valueOf(tag[1]);
			numOfGroup = Integer.valueOf(tag[2]);
			stdIndexScore = new int[numOfStd];
			scoreAwarded = new int[numOfStd];
			groupTotal = new int[numOfGroup];
		
			//System.out.print(">> "); 
			line = reader.readLine();
			
			tag = line.split("\\s");
			
			for (int j = 0; j < stdIndexScore.length; j++){
				stdIndexScore[j] = Integer.valueOf(tag[j]);
			}
			
			i = 0;
			
			//System.out.print(">> "); 
			line = reader.readLine();
			
			while(i < (numOfRevision)){
				tag = line.split("\\s");
				if (!tag[0].equals("R"))
					throw new EmptyStackException();
				if ((stdIndexScore[Integer.valueOf(tag[1])-1] + Integer.valueOf(tag[2])) <=  100){
					stdIndexScore[Integer.valueOf(tag[1])-1] += Integer.valueOf(tag[2]);
					scoreAwarded[Integer.valueOf(tag[1])-1] += Integer.valueOf(tag[2]);
				}
				i++;
				if ( i != numOfRevision){
					//System.out.print(">> "); 
					line = reader.readLine();
				}
			}
			
			i = 0;
			
			//System.out.print(">> "); 
			line = reader.readLine();
			
			while(i < numOfGroup){
				tag = line.split("\\s");
				if (!tag[0].equals("G"))
					throw new EmptyStackException();
				
				int j = Integer.valueOf(tag[1])-1;
				int limit = Integer.valueOf(tag[2]);
				
				while(j < limit){
					groupTotal[i] += stdIndexScore[j];
					j++;
				}
				
				i++;
				if (i != numOfGroup){
					//System.out.print(">> "); 
					line = reader.readLine();
				}
			}
			
			//output += this.GetMax(groupTotal) + "\n";
			// get output
			if ((i+1) == numOfTestCases)
				output += this.GetMax(groupTotal);
			else
				output += this.GetMax(groupTotal) + "\n";
			
			i++;
			
		}// End of BIG WHILE LOOP for TEST CASES
		
		
		reader.close();
		
		return output;
		
	}
	
	public int GetMax(int [] array){
		int max = array[0];
		for(int i = 1; i < array.length; i++){
			if (array[i] > max)
				max = array[i];
		}
		return max;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		solver tool = new solver();
		System.out.println(tool.ParseText());
		
		/*
		 * 1
		20 3 3
		99 98 94 1 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
		R 7 100
		R 3 45
		R 5 43
		G 1 5
		G 3 10
		G 4 19
		380
		 */

	}

}
