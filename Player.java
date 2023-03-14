package testingproject;

import java.util.ArrayList;

public class Player extends Entity {

	public ArrayList<Item> inventory = new ArrayList<Item>(5);
	protected Item item;

	public Player(String name) {
		super(name, 30, 4);

	}

	public void addItem(Item item) {
		if (inventory.size() == 5) {
			System.out.println("your bag is full, item will be deleted");
		} else {
			inventory.add(item);
			System.out.println("you add " + item.getName() + " to your bag.");
		}
	}

	public void removeItem(Item item) {
		if (inventory.size() <= 0) {
			System.out.println("your bag is empty");
		} else {
			inventory.remove(item);
			System.out.println("you remove " + item.getName() + " from your bag.");
		}
	}

	public void useItem(Potions item) {
		if (inventory.contains(item) == false) {
			System.out.println("your don't have " + item.getName() + " in your bag ");
		} else {
			healed(item.getHealingValue());
			inventory.remove(item);

		}
	}
	
	public void useItem(int choice) {
		useItem((Potions) inventory.get(choice-1));
	}

	public void displayInventory() {
		int i = 1;
		if (inventory.size() <= 0) {
			System.out.println("your bag is empty");
		} else {
			for (Item item : inventory) {
				System.out.println(i++ + ": " + item.getName());
			}
		}
	}

	public int getSize() {
		return inventory.size();
	}
	
	public void playerTurn(Monster monster) {
		monster.damaged(getAttack());
	}
	
	public Boolean inventoryEmpty() {
		return inventory.isEmpty();
	}
	
	

}