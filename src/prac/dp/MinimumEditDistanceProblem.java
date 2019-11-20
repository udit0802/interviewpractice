package prac.dp;

public class MinimumEditDistanceProblem {
	
	private static int minwho(int a,int b,int c) {
		int min = Math.min(a, Math.min(b, c));
		if(min == a)
			return 0;
		else if(min == b)
			return 1;
		else
			return 2;
	}

	private static int mindistance(char[] str1,char[] str2) {
		int[][] matrix = new int[str1.length+1][str2.length+1];
		
		for(int i = 0;i <= str2.length;i++) {
			matrix[0][i] = i;
		}
		
		for(int i = 0;i <= str1.length;i++) {
			matrix[i][0] = i;
		}
		
		for(int i = 1;i < matrix.length;i++) {
			for(int j = 1;j < matrix[i].length;j++) {
				if(str1[i-1] != str2[j-1])
					matrix[i][j] = Math.min(matrix[i-1][j], Math.min(matrix[i-1][j-1], matrix[i][j-1])) + 1;
				else
					matrix[i][j] = matrix[i-1][j-1];
			}
		}
		
		int i = str1.length;
		int j = str2.length;
		
		while(i != 0 && j!= 0) {
			if(str1[i-1] != str2[j-1]) {
				int minwho = minwho(matrix[i][j-1], matrix[i-1][j-1], matrix[i-1][j]);
				switch(minwho) {
					case 0 : 
						System.out.println("Delete character = " + str1[i-1] + " from string 1");
						j--;
						break;
					case 1 : 
						System.out.println("Replace " + str1[i-1] + " in string 1 with " + str2[j-1] + " in string 2");
						i--;
						j--;
						break;
					case 2 :
						System.out.println("Insert character = " + str1[i-1] + " into string 2");
						i--;
						break;
				}
			}else {
				i--;
				j--;
			}
		}
		
		return matrix[str1.length][str2.length];
	}
	
	public static void main(String[] args) {
		String str1 = "abcdef";
		String str2 = "azced";
		
		System.out.println("Minimum edit distance = " + mindistance(str1.toCharArray(), str2.toCharArray()));
	}
	
}
