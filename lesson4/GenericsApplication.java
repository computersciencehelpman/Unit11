package com.coderscampus.lesson4;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;



public class GenericsApplication {

	 @Test
		public void generics_example() {
			List<String> list = new ArrayList();
			
			list.add("first string value");
			list.add("Second string value");
			list.add("E");
			
			for(int i=0; i<list.size(); i++) {
				System.out.println((String)list.get(i));
			}
		}
	
}
