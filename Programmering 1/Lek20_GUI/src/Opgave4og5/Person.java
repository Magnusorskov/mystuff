package Opgave4og5;

public class Person {
	private String name;
	private boolean gender;

	public Person(String name, boolean gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public boolean getGender() {
		return gender;
	}

	@Override
	public String toString() {
		return name;
	}

}
