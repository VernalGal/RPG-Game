package testingproject;

public abstract class Entity {
	protected String name;
	protected int MaxHp;
	protected int currentHp;
	private int attack;
	private boolean isDead;

	public Entity() {

	}

	public Entity(String name, int MaxHp, int attack) {
		this.name = name;
		this.MaxHp = MaxHp;
		this.currentHp = MaxHp;
		this.attack = attack;

	}

	// For player or monster takes an attack or get health
	public void damaged(int attack) {
		currentHp -= attack;
		if (currentHp <= 0) {
			System.out.println(name + " has been defeated!");
			isDead = true;
			if (currentHp < 0)
				currentHp = 0;
		}
	}

	public void healed(int heal) {
		int remainder;
		// Set's negative HP to zero
		if (currentHp < 0)
			currentHp = 0;
		// **********************

		// correctly displays how much you heal for instead of the static healing amount
		if (currentHp + heal <= MaxHp)
			System.out.println("You healed for " + heal);
		else if (currentHp + heal > MaxHp) {
			remainder = MaxHp - currentHp;
			System.out.println("You healed for " + remainder);
		}

		// *********************

		// ensures that you do not gain more health infinitely
		currentHp += heal;
		if (currentHp > MaxHp)
			currentHp = MaxHp;
		isDead = false;

	}

	// to set that to true if player or monsters HP reaches 0
	public boolean isDead() {
		return isDead;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}

	public String getName() {
		return name;
	}

	public int getCurrentHP() {
		return currentHp;
	}

	public int getMaxHP() {
		return MaxHp;
	}

	public int getAttack() {
		return attack;
	}

}