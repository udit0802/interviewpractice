package prac.dp;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {
	
	public static void printMatrix(boolean[][] matrix) {
		for(int i = 0 ; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

	
	
	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<>();
		dictionary.add("I");
		dictionary.add("am");
		dictionary.add("ace");
		dictionary.add("a");
		String test = "Iamace";
		boolean breakWord = breakWord(test,dictionary);
		System.out.println(breakWord?"Yes":"No");
	}

	private static boolean breakWord(String test, Set<String> dictionary) {
		if(null == test || test.length() == 0)
			return false;
		
		boolean matrix[][] = new boolean[test.length()][test.length()];
		
		for(int l = 1;l <= test.length();l++) {
			for(int i = 0; i < test.length() - l + 1 ; i++) {
				int j = i + l - 1;
				if(dictionary.contains(test.substring(i, j+1))) {
					matrix[i][j] = true;
					continue;
				}
				for(int k = i+1;k <= j;k++) {
					if(matrix[i][k-1] && matrix[k][j]) {
						matrix[i][j] = true;
						break;
					}
				}
			}
		}
		printMatrix(matrix);
		return matrix[0][test.length()-1];
	}
}
