package testingproject;

public class Potions extends Item {

	private int healingValue = 5;

	public Potions() {
		super("Basic Healing Potion", "glass vial with red liquid in it");

	}

	public int getHealingValue() {
		return healingValue;
	}

}
