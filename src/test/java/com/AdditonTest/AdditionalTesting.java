package com.AdditonTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.addition.Additional;

class AdditionalTesting {

	@Test
	void test() {
	Additional add=new Additional();
	int result=add.add(3, 2);
	assertEquals(5, result);
	
	}
    @Test
    void sevenPlusTenEqualsSeventeen() {
	Additional add=new Additional();
	int result=add.add(7, 10);
	assertEquals(17,result);
}
}
