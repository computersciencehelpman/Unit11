package com.coderscampus.lesson1;

public class CustomArrayList {

	public class CustomArrayList<T> implements CustomList<T> {
		Object[] items = new Object[10];
		int size = 0;
		
		

		public boolean add(T item) {
		   if(items.length == size) {
			   expandBackingObjectArray();
		   }

		    
		    // Add the new item to the array
		    items[size] = item;
		    
		    // Increment the size
		    size++;
		    
		   
		    
		    return true;
		}
		
		private void expandBackingObjectArray() {
			Object[] oldArray = items;
			items = new Object[size * 2];
			for (int i = 0; i < oldArray.length; i++) {
				items[i] = oldArray[i];
			}
		}
		
		public int getSize() {
			// TODO Auto-generated method stub
			
			return size;
		}


		public T get(int index) {
			
			//Return the element at the specified index
			@SuppressWarnings("unchecked")
			T item = (T) items[index];
			return item;
		}
		
	}
}