package testingproject;

public class Item {
	
	private String name;
	private String description;
	
	public Item(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public void print() {
		System.out.println(name + ": " + description);
	}

	public String getName() {
		return name;
	}


}
