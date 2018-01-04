import java.util.*;

public class Dog{
	private String name;
	private int license;
	private String breed;
	private int age;
	
	public Dog(String _name, int _license, String _breed, int _age){
		name = _name;
	    license = _license;
		breed = _breed;
	    age = _age;
	}
	
	public String getBreed(){
		return this.breed;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getLicense(){
		return this.license;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public String toString(){
	    
	    return ("Name: " + this.name + "\nLicense: " + this.license + 
	            "\nBreed: " + this.breed  + "\nAge: " + this.age);
	}

}