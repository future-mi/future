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
		System.out.println("처음행의 수" + a.m.length);
		System.out.println("처음열의 수" + a.m[0].length);
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("현재배열상태");
		a.disp();
		
		Scanner scanner=new Scanner(System.in);
		Boolean Array = true;
		while(Array) {
			System.out.println("1.숫자추가 2.숫자삭제 3.현재배열 4.숫자변경 5.종료");
			int input=scanner.nextInt();
		switch(input) {
		case 1:
			System.out.println("배열에 추가할 숫자를 입력해주세요.");
			a.add(scanner.nextInt());
			break;
		case 2:
			System.out.println("삭제할 숫자를 입력해주세요.");
			a.delete(scanner.nextInt());
			break;
		case 3:
			System.out.println("현재배열");
			a.disp();
			break;
		case 4:
			System.out.println("바꿀숫자,바뀔숫자,찾을 행,열을 입력해주세요.");
			a.modify(scanner.nextInt(),scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
			break;
		case 5:
			Array=false;
			System.out.println("종료합니다.");
				}
			}
		}
	}
