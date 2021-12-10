package future.com.main;

public class QuickSort {		
	public static void main(String[] args) {
	      int[] array = {1, 3, 2, 5, 4, 6, 8, 7};
	      PrintArray(array);
	      QuickSort1(array, 0, array.length - 1);
	      PrintArray(array);
	   }
	   public static void PrintArray(int[] arr) {
	      for(int i=0; i<arr.length; i++) {
	         System.out.print(arr[i] + "\t");
	      }
	      System.out.println();
	   }
	   
	   public static void QuickSort1(int[] arr, int start, int end) {
		  int start_cal = start;
		  int end_cal = end;
		  int pivot = arr[(start_cal + end_cal) / 2];
		  while (start_cal <= end_cal) {
		  while (arr[start_cal] < pivot) start_cal++;
		  while (arr[end_cal] > pivot) end_cal--;
			 if(start_cal <= end_cal) {
			  int tmp = arr[start_cal];
			            arr[start_cal] = arr[end_cal];
			            arr[end_cal] = tmp;
			            start_cal++;
			            end_cal--;
	       }
	     }
		  int part = start_cal;
		   if (start < part - 1) QuickSort1(arr, start, part - 1); 
		   if (part < end) QuickSort1(arr, part, end); 
		  }
}