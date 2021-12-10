package future.com.main;

import java.util.Random;

//SelectionSort(��������), InsetionSort, BulbbleSort, QuickSort

public class ArraysortSet {
	int []m= new int[10];  	// Heap�� �� ������ ��������� ��
	public void initArray() {
		Random random=new Random();
		for (int i = 0; i < m.length; i++) {
			m[i]=random.nextInt(100);		// �̰� ����
			
//			System.out.println(random.nextInt(100));		// ���� �ϰ� int()���� �������� �߻���
//			System.out.println(random.nextBoolean());
		}
	}
	public void swap(int i,int j) {
		int imsi=0;								// �ӽú����� �־����
		imsi=m[i];								// ������� ������ �ؿ� �����ϰ� ���°Ŷ� ���� ���� �ѹ���
		m[i]=m[j];
		m[j]=imsi;
	}
	
	public void selectionSort(int order) {		// oder ��� �ָ� ���ڷ��༭ �갡 0�϶� �������� or �������� Ȯ�� �� ����
		for (int i=0; i<m.length-1; i++) {		// ��� �������� �������� �ȵ��Ƶ� �Ǵϱ� m�迭���̿��� -1�� �־��൵��
			for (int j=i+1; j<m.length; j++) {
				if(order==0) {
				if(m[i]<m[j]) {					// <(����),>(����) ���⿡ ���� �������� ��������
					swap(i,j);					// �̰Ÿ� ���� swap ���ִ� ������ ������ �ݺ��ؼ� ���°Ŷ� �����ϰ� �������� ���� ���� �־��ִ°ɷ��ϸ� ��������
				}else {
					if(m[i]>m[j]) {
						swap(i,j);
						}
					}
				}
			}
		}
	}
	
	public void swapBubble(int i,int j) {		// �������Ŀ��� swap ������ ��
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
	
	public void bubbleSort() {				//	Bubble ���� �ϴ���
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
	
	public void InsertionSort() {		// ��������
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
