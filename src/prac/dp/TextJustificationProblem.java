package prac.dp;

public class TextJustificationProblem {
	
	/*
	 * * Given a sequence of words, and a limit on the number of characters that can be put 
 * in one line (line width). Put line breaks in the given sequence such that 
 * white spaces are evenly distributed.
 * 
 * 
 * 
 * 
 * 
 * parameter of badness can be the square of the number of spaces on each line
 * 
	 * */
	
	public static void printMatrix(int[][] matrix) {
		for(int i = 0 ; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void printArray(int[] arr) {
		for(int i = 0 ; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
			
		}
		System.out.println();
	}

	public static String justify(String words[], int width) {
		
		int cost[][] = new int[words.length][words.length];
		
		for(int i = 0;i < words.length;i++) {
			cost[i][i] = width - words[i].length();
			for(int j = i+1;j < words.length; j++) {
				cost[i][j] = cost[i][j-1] - words[j].length() - 1;
			}
		}
		
		for(int i = 0 ; i < words.length;i++) {
			for(int j = i ; j < words.length ; j++) {
				if(cost[i][j] < 0)
					cost[i][j] = Integer.MAX_VALUE;
				else
					cost[i][j] = (int)Math.pow(cost[i][j], 2);
			}
		}
		printMatrix(cost);
		
		int[] mincost = new int[words.length];
		int[] order = new int[words.length];
		
		for(int i = words.length-1;i>=0;i--) {
			mincost[i] = cost[i][words.length-1];
			order[i] = words.length;
			for(int j=words.length-1;j > i;j--) {
				if(cost[i][j-1] == Integer.MAX_VALUE)
					continue;
				if(mincost[i] > mincost[j] + cost[i][j-1]) {
					mincost[i] = mincost[j] + cost[i][j-1];
					order[i] = j;
				}
			}
		}
		
		printArray(mincost);
		printArray(order);
		
		int i = 0,j=order[0];
		StringBuilder builder = new StringBuilder();
		do{
            j = order[i];
            for(int k=i; k < j; k++){
                builder.append(words[k] + " ");
            }
            builder.append("\n");
            i = j;
        }while(j < words.length);
		return builder.toString();
	}
	
	
	public static void main(String args[]){
        String words1[] = {"Udit","likes","to","write","code","at", "free", "time"};
        System.out.println(justify(words1, 12));
    }
}
