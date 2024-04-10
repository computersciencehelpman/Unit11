package com.coderscampus.lesson6;

public class AnnotationApplicationTest {

	@MyTest(enabled = false)
	public void test1() {
		if (true)
			throw new RuntimeException("This won't throw an exception as the test is disabled");
	}
	
	@MyTest("This is a value assigned to this particular use of this annotation")
	public void test2() {
		if (true)
			throw new RuntimeException("This test failed");
	}
	
	@MyTest(value = "This is a value", enabled = true)
	public void test3() {
		System.out.println("This test should pass");
	}
	
}

