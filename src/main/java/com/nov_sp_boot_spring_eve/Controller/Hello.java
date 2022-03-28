package com.nov_sp_boot_spring_eve.Controller;

class A {
	String message;

	@Override
	public String toString() {
		return "Hello [message=" + message + "]";
	}

	public String getMessage() {
		return "hello";
	}

	public String setMessage(String message) {
		this.message = message;
		return "right";
	}

}
public class Hello {
	public static void main(String args[]) {
		A a=new A();
	String b=a.setMessage("hello");
	System.out.println(b);
		
	}
}