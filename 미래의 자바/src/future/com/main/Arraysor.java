package future.com.main;

import java.util.Arrays;
import java.util.Scanner;

public class Arraysor {
	int [][]m=new int[2][3];
	int row=0,col=-1; 		// 
	
	public boolean isEmpty() {
		return row==0 && col==-1;
	}
	public boolean isFull() {
		return row==m.length-1 && col==m[0].length-1;
	}
	
	public void add(int data) {
		if(isFull())increment();
		if(col<m[0].length-1) {
			col++;
		}else {
			col=0;
			row++;
		}
		m[row][col]=data;
	}
	
	public void increment() {
		int [][]imsi=new int[m.length+1][m[0].length];
		System.arraycopy(m, 0, imsi, 0, m.length);
		m=imsi;
		
	}
	
	public int []search(int data) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if(m[i][j]==data)return new int[]{i,j};
			}
		}
		return null;
	}
	
	public int []search(int data,int row,int col) {
		for(int i=row;i<m.length;i++) {
			for (int j=col>(m[i].length-1)?0:col; j <m.length; j++) {
				if(m[i][j]==data)return new int[] {i,j};
			}
		}		
		return null;
	}

	public void disp() {
		for(int[]i:m) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}
	
	public void modify(int origin,int change,int row,int col) {
	      int []rs=search(origin,row,col);
	      if(rs==null)return;
	      m[rs[0]][rs[1]]=change;
	   }
	
	public void delete(int data) {
		int []rs=search(data);
		if(rs==null)return;
		for (int i =rs[0]; i<m.length; i++) {
			for (int j=rs[1]; j<m[i].length; j++) {
				if(i==m.length-1 && j== m[i].length-1) {
				m[i][j]=0; break;
				}
				if(j==m[i].length-1) { 
					m[i][j]=m[i+1][0];
					rs[1]=0;
				}else {	
					m[i][j]=m[i][j+1];
				}
			}
		} 
		if(col==0) {
			row--;
			col=m[0].length-1; 
		}else
			col--;
	}
	
	public static void main(String[] args) {
		Arraysor a=new Arraysor();
		System.out.println("ó������ ��" + a.m.length);
		System.out.println("ó������ ��" + a.m[0].length);
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("����迭����");
		a.disp();
		
		Scanner scanner=new Scanner(System.in);
		Boolean Array = true;
		while(Array) {
			System.out.println("1.�����߰� 2.���ڻ��� 3.����迭 4.���ں��� 5.����");
			int input=scanner.nextInt();
		switch(input) {
		case 1:
			System.out.println("�迭�� �߰��� ���ڸ� �Է����ּ���.");
			a.add(scanner.nextInt());
			break;
		case 2:
			System.out.println("������ ���ڸ� �Է����ּ���.");
			a.delete(scanner.nextInt());
			break;
		case 3:
			System.out.println("����迭");
			a.disp();
			break;
		case 4:
			System.out.println("�ٲܼ���,�ٲ����,ã�� ��,���� �Է����ּ���.");
			a.modify(scanner.nextInt(),scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			break;
		case 5:
			Array=false;
			System.out.println("�����մϴ�.");
				}
			}
		}
	}
