package com.addition;

import java.util.Scanner;

class Add{
	
	int a;
	int b;
	public int getResult(int a, int b) {
		int result;
		result=a*b;
		return result;
	}
}

public class AddTwoNumber {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter first number");
		int a=sc.nextInt();
		System.out.println("Enter second number");
		int b=sc.nextInt();
		
Add result=new Add();
System.out.println();
int sum=result.getResult(a, b);

System.out.println("The result is "+ sum);
sc.close();
}
}