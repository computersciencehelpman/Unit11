package com.coderscampus.lesson6;

import java.lang.reflect.Method;


	public class AnnotationApplication {

		public static void main(String[] args) {
			
			AnnotationApplicationTest testClass = new AnnotationApplicationTest();
			
			Method[] methods = AnnotationApplicationTest.class.getMethods();
			int testPass = 0;
			int testFailed = 0;
			int testIgnored = 0;
			for(Method method: methods) {
				MyTest myTest = method.getAnnotation(MyTest.class);
				
				if (myTest != null) {
					if (myTest.enabled()) {
						try {
							method.invoke(testClass);
							testPass++;
						} catch (Exception e) {
							testFailed++;
						}
					} else {
						testIgnored++;
					}
				}
			}
			System.out.println("Test passed: "+testPass +", test failed: "+testFailed+ " test Ignored: "+testIgnored);
		}
		
	


}
