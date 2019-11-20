package prac.dp;

public class LISLogn {

	int LIS(int arr[]) {
		int n = arr.length;
		int[] T = new int[n];
		int[] R = new int[n];
		for(int i = 0;i < n;i++)R[i] = -1;
		int len = 0;
		for(int i = 1;i < n;i++) {
			
			if(arr[i] < arr[T[0]]) {
				T[0] = i;
			}else if(arr[i] > arr[T[len]]) {
				T[++len] = i;
				R[T[len]] = T[len-1];
			}else {
				
				int k = search(arr,T,arr[i],0,len);
				T[k] = i;
				R[T[k]] = T[k-1];
			}
			
		}
		
		
		int index = T[len];
		while(index != -1) {
			System.out.println(arr[index]);
			index = R[index];
		}
		
		return len+1;
	}

	private int search(int[] arr,int[] t, int i, int start, int end) {
		if(start > end)return -1;
		int mid = start + (end-start)/2;
//		if(start == end)return start;
		if(arr[t[mid]] <i && arr[t[mid+1]]>=i)
			return mid+1;
		else if(arr[t[mid]] < i )
			return search(arr,t,i,mid+1,end);
		return search(arr,t,i,start,mid-1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,5,3,6,4};
		LISLogn l = new LISLogn();
		System.out.println(l.LIS(arr));
	}
}
