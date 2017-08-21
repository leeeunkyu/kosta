package com.kosta.j0821;

public class Exam4 {
	int[][] nums = new int[3][3];
	int[][] temp = new int[3][3];
	int k=10;
	int a,b,c;
	public Exam4() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				nums[i][j]=k;
				temp[i][j]=k;
				k+=5;
			}
		}
		System.out.println("원본배열");
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n\n");
		getRotationSum(nums);
		
	}
	private void getRotationSum(int[][] nums) {
		// TODO Auto-generated method stub
		System.out.println("회전된 배열");
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(j==0)
					nums[i][j]=temp[0][2-i];
				else if(j==2)
					nums[i][j]=temp[2][2-i];
				else
					nums[i][j]=temp[1][2-i];
			}

		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if(i==0)
					a+=nums[i][j];
				else if(i==1)
					b+=nums[i][j];
				else
					c+=nums[i][j];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				System.out.print(nums[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("각행렬들 합:"+a+"  "+b+"  "+c);
	}
	public static void main(String[] args) {
		new Exam4();
	}
}
