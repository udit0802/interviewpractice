package prac.dp;

public class TowerHoppingProblem {
	
	private static int minhoppabledistanceifpossible(int[] towers) {
		boolean[] jumper = new boolean[towers.length];
		int[] jumpersteps = new int[towers.length];
		for(int i = towers.length - 1;i >= 0;i--) {
			minhopsteps(i,towers,jumper,jumpersteps);
		}
		if(jumper[0])
			return jumpersteps[0];
		return -1;
	}

	private static void minhopsteps(int i, int[] towers, boolean[] jumper, int[] jumpersteps) {
		if(i + towers[i] >= towers.length) {
			jumper[i] = true;
			jumpersteps[i] = 1;
			return;
		}
		for(int j = i + 1;j <= i + towers[i];j++) {
			if(jumper[j]) {
				if(jumper[i]) {
					jumpersteps[i] = Math.min(jumpersteps[i], jumpersteps[j]+1);
				}else {
					jumper[i] = true;
					jumpersteps[i] = jumpersteps[j] + 1;
				}
			}
		}
	}

	private static boolean ishoppable(int[] towers) {
		boolean[] jumper = new boolean[towers.length];
		for(int i = towers.length - 1;i >= 0;i--) {
			hopper(i,towers,jumper);
		}
		return jumper[0];
	}

	private static void hopper(int i, int[] towers, boolean[] jumper) {
		if(i + towers[i] >= towers.length) {
			jumper[i] = true;
			return;
		}
		for(int j = i + 1;j <= i + towers[i];j++) {
			if(jumper[j]) {
				jumper[i] = true;
				return;
			}
		}
		jumper[i] = false;
	}
	
	public static void main(String[] args) {
		int[] towers = {4,0,0,1};
		System.out.println(ishoppable(towers));
		System.out.println(minhoppabledistanceifpossible(towers));
	}
}
