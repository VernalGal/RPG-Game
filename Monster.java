package testingproject;

public class Monster extends Entity{

	public Monster(String name, int MaxHp, int attack) {
		super(name, MaxHp, attack);
		
	}

	public void monsterTurn(Player player) {
		player.damaged(getAttack());
	}
}
