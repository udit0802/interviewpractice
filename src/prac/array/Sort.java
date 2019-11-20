package prac.array;

public class Sort {

	
	private int partition(int[] arr,int l,int r) {
		
		int pivot = arr[r];
		int i = l-1;
		for(int j = l;j <= r-1;j++) {
			if(arr[j] < pivot) {
				++i;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;
		return i+1;
	}
	
	public void quicksort(int arr[],int low,int high) {
		
		if(low >= high)
			return;
		int partition = partition(arr, low, high);
		quicksort(arr, low, partition-1);
		quicksort(arr, partition+1, high);
		
	}
	
	public void printArray(int arr[], int size){  
	    int i;  
	    for (i = 0; i < size; i++)  
	        System.out.print(arr[i] + " ");
	    System.out.println();
	}  
	
	public static void main(String[] args)  
	{  
	    int arr[] = {10, 7, 8, 9, 1, 5};  
	    int n = arr.length;
	    Sort s = new Sort();
	    s.quicksort(arr, 0, n - 1);  
	    s.printArray(arr, n);  
	} 
}
