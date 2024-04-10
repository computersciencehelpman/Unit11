package com.coderscampus.lesson5;
 
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.Test;

public class ReflectionApplication {

	PersonRepository personRepo = new PersonRepository();
	CatRepository catRepo = new CatRepository();
	carRepository carRepo = new carRepository();
	
	@Test
	public void reflection_test() {
		Person person = new Person();
		person.setAge(18);
		person.setName("Julie Smith");
		person.setEyeColor("Brown");
		
		Cat cat = new Cat();
		Car car = new Car();
		
		Method[] methods = person.getClass().getMethods();
		
		for(Method method :methods) {
			System.out.println(method.getName());
		}
		
		save(person, personRepo);
		save(cat, catRepo);
		save(car, carRepo);
	}
	
	public <T, R> void save (T obj, R repo) {
		Class<T> c = (Class<T>) obj.getClass();

		try {
			
			Method saveMethod =  ((Object)repo).getClass().getMethod("save", c);
			saveMethod.invoke(repo, obj);
		} catch ( NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			System.err.println("Oops There was an error getting the save method");
		}
		
	}
	
	public void save(Person person) {
		//get a Reopsitory and call the save method on the repo
		PersonRepository personRepository = new PersonRepository();
		personRepository.save(person);
	}
	
	public void save(Cat cat) {
		//get a Reopsitory and call the save method on the repo
		CatRepository catRepository = new CatRepository();
		catRepository.save(cat);
	}
	
	public void save(Car car) {
		//get a Reopsitory and call the save method on the repo
		carRepository carRepository = new carRepository();
		carRepository.save(car);
	}
	
}
