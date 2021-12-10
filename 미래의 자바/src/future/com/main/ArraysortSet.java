package future.com.main;

import java.util.Random;

//SelectionSort(선택정렬), InsetionSort, BulbbleSort, QuickSort

public class ArraysortSet {
	int []m= new int[10];  	// Heap에 이 변수가 만들어지는 것
	public void initArray() {
		Random random=new Random();
		for (int i = 0; i < m.length; i++) {
			m[i]=random.nextInt(100);		// 이게 난수
			
//			System.out.println(random.nextInt(100));		// 랜덤 하고 int()값이 랜덤으로 발생됨
//			System.out.println(random.nextBoolean());
		}
	}
	public void swap(int i,int j) {
		int imsi=0;								// 임시변수가 있어야함
		imsi=m[i];								// 여기부터 내용이 밑에 동일하게 들어가는거라 위로 빼서 한번만
		m[i]=m[j];
		m[j]=imsi;
	}
	
	public void selectionSort(int order) {		// oder 라는 애를 인자로줘서 얘가 0일때 오름차순 or 내림차순 확인 후 정렬
		for (int i=0; i<m.length-1; i++) {		// 계속 비교하지만 마지막은 안돌아도 되니까 m배열길이에서 -1을 넣어줘도됨
			for (int j=i+1; j<m.length; j++) {
				if(order==0) {
				if(m[i]<m[j]) {					// <(내림),>(오름) 방향에 따라 오름차순 내림차순
					swap(i,j);					// 이거를 위에 swap 에있는 내용을 어차피 반복해서 쓰는거라서 복잡하게 하지말고 따로 빼서 넣어주는걸로하면 간결해짐
				}else {
					if(m[i]>m[j]) {
						swap(i,j);
						}
					}
				}
			}
		}
	}
	
	public void swapBubble(int i,int j) {		// 버블정렬에서 swap 빼놓은 것
		int temp=0;
		temp=m[j+1];
		m[j+1]=m[j];
		m[j]=temp;
	}
	
	
	public void bubbleSort1(int order) {
		for (int i=0; i<m.length-1; i++) {
			for (int j=0; j<m.length-(i+1); j++) {
				if(m[j]<m[j+1]) {
					swapBubble(i,j);
				}
			}
		}
	}
	
	public void bubbleSort1(char state) {
		for (int i=0; i<m.length-(i+1); i++) {
			for (int j=0; j<m.length-(i+1); j++) {
				if(state=='d') {
				if(m[j]<m[j+1]) {
					swapBubble(i,j);
				}
				}else if(state=='a') {
					if(m[j]>m[j+1]) {
						swapBubble(i,j);
					}
				}
			}
		}
	}
	
	public void bubbleSort() {				//	Bubble 내가 하는중
		for (int i=0; i<m.length-1;i++) {
			int swap=0;
			for (int j=i+1; j<m.length-1-i; j++) {
				if(m[j]<m[j+1]) {
					swap=m[j+1];
					m[j+1]=m[j];
					m[j]=swap;
				}
			}
		}
	}
	
	public void InsertionSort() {		// 삽입정렬
		for (int i = 0; i < m.length; i++) {
			
		}
		
	}
	
	
	public void sortDataDisp() {
		for(int i:m) {
			System.out.printf("%3d",i);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArraysortSet a=new ArraysortSet();
		a.initArray();
//		a.selectionSort(0);
		a.sortDataDisp();
		a.bubbleSort1(0);
	}
		
	
	
}
