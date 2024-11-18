package Opgave1og2;

public class Person {
	private String name;
	private String title;
	private Boolean senior;

	public Person(String name, String title, boolean senior) {
		this.name = name;
		this.title = title;
		this.senior = senior;
	}

	public String getName() {
		return name;
	}

	public String getTitle() {
		return title;
	}

	public Boolean getSenior() {
		return senior;
	}

	@Override
	public String toString() {
		String s = title + " " + name;
		if (senior) s = s + " (senior)";
		return s;
	}

}
