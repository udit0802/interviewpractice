package prac.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class test {

	static List<Integer> findTruckCargo(int maxCargoWeight, List<List<Integer>> cargoList) {
		

		
        int m = cargoList.size();
        int n = maxCargoWeight;
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0; i <= m;i++){
            for(int j = 0;j <= n;j++){

                if(i ==0 || j == 0)
                    dp[i][j] = 0;
                else if(cargoList.get(i-1).get(1) <= j)
                    dp[i][j] = Math.max(cargoList.get(i-1).get(2) + dp[i-1][j-cargoList.get(i-1).get(1)],dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];

            }
        } 
        int profit = dp[m][n];
        List<Integer> res = new LinkedList<>();
        int i = m;
        int j = n;
        while(dp[i][j] != 0){
            if(dp[i][j] == dp[i-1][j])
                i--;
            else{
                res.add(cargoList.get(i-1).get(0));
                j-=cargoList.get(i-1).get(1);
                i--;
            }
        }
        Collections.reverse(res);
        res.add(profit);
        return res;
    }
	
	
	
	static int noOfWaysToDrawTheGame(int totalScore) {
        if(totalScore <= 0)
            return 0;

       if(totalScore == 0 || totalScore == 1 || totalScore == 3 || totalScore == 5)
        return 0;

        if(totalScore == 2)
            return 1;
        if(totalScore == 4)
            return 2;
        if(totalScore == 6)
            return 4;
        int[] dp = new int[totalScore + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 2;
        dp[5] = 0;
        dp[6] = 4;
        for(int i=7;i <= totalScore;i++){
            dp[i] = dp[i-2] + dp[i-4] + dp[i-6];
        }
        return dp[totalScore];
    }
	
	
	public static void main(String[] args) {
		
		List<List<Integer>> cargo = new ArrayList<List<Integer>>();
		List<Integer> cargo1 = new ArrayList<>();
		cargo1.add(38);
		cargo1.add(130);
		cargo1.add(500);
		
		List<Integer> cargo2 = new ArrayList<>();
		cargo2.add(21);
		cargo2.add(280);
		cargo2.add(1800);
		
		List<Integer> cargo3 = new ArrayList<>();
		cargo3.add(13);
		cargo3.add(120);
		cargo3.add(1500);
		
		cargo.add(cargo1);
		cargo.add(cargo2);
		cargo.add(cargo3);
		
		List<Integer> ans = findTruckCargo(300,cargo);
		
		
		ans.stream().forEach(i->System.out.println(i));
		
		System.out.println(noOfWaysToDrawTheGame(5));
	}
}
