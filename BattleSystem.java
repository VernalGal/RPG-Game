package testingproject;

public class BattleSystem {
	// where the battle will take place in
	// create a method for the game main to use that will take a reference of player
	// and monster
	public void Battle(Player player, Monster monster) {
		// code for how battle will take place here

		int number1 = generateInt(0, 1);
		// System.out.println(number1);
		switch (number1) {
		// Monster goes first
		case 0:
			System.out.println(monster.getName() + " goes first");
			while (true) {
				// monster turn
				monsterTurn(monster, player);
				if (monster.isDead() || player.isDead()) // case to break while loop/ end of battle
					break;
				// player turn
				playerTurn(monster, player);
				if (monster.isDead() || player.isDead()) // case to break while loop/ end of battle
					break;
				GameLogic.gameSleep(Events.BATTLE_DEFAULT);
				System.out.println(player.getName() + ": " + player.getCurrentHP());
				System.out.println(monster.getName() + ": " + monster.getCurrentHP());
				GameLogic.gameSleep(Events.BATTLE_DEFAULT);
				GameLogic.anythingtoContinue();

			}
			break;
		case 1: {
			// Player goes first
			System.out.println(player.getName() + " goes first");
			while (true) {

				// player turn
				playerTurn(monster, player);
				if (monster.isDead() || player.isDead()) // case to break while loop/ end of battle
					break;
				// monster turn
				monsterTurn(monster, player);
				if (monster.isDead() || player.isDead()) // case to break while loop/ end of battle
					break;
				GameLogic.gameSleep(Events.BATTLE_DEFAULT);
				System.out.println(player.getName() + ": " + player.getCurrentHP());
				System.out.println(monster.getName() + ": " + monster.getCurrentHP());
				GameLogic.gameSleep(Events.BATTLE_DEFAULT);
				GameLogic.anythingtoContinue();
			}
		}
			break;
		}

	}

	public static int generateInt(int low, int high) {
		return ((int) ((Math.random() * 1000000000) % ((high + 1) - low)) + low);
	}

	void monsterTurn(Monster monster, Player player) {
		System.out.println(monster.getName() + "'s turn...");
		GameLogic.gameSleep(Events.BATTLE_DEFAULT);
		System.out.println(monster.getName() + " tries to attack!");
		GameLogic.gameSleep(Events.BATTLE_DEFAULT);
		if (generateInt(0, 1) == 1) { // does monster hit? monster hits
			// print "Monster was successful
			System.out.println(monster.getName() + " was successful and hits for " + monster.getAttack() + "!");
			monster.monsterTurn(player); // this will damage player
		} else {
			System.out.println(monster.getName() + " has missed!");
		}
	}

	void playerTurn(Monster monster, Player player) {
		// all of players turn in this method
		int choice = 0;
		System.out.println("Your turn!"); // delete
		GameLogic.gameSleep(Events.BATTLE_DEFAULT);
		String description = "What will you do?\n1.Attack\n2.Use Item\n3.Run Away\nChoice: ";
		choice = GameLogic.intChecker(description, 3);

		switch (choice) {

		case 1:
			// This case is the player choosing to attack

			System.out.println("You chose to attack...");
			GameLogic.gameSleep(Events.BATTLE_DEFAULT);
			if (generateInt(0, 1) == 1) {
				System.out.println("You were successful and hit for " + player.getAttack() + "!");
				player.playerTurn(monster);

			} else {
				System.out.println("You missed");

			}
			break;

		case 2:
			// This is the case for when the player chooses to use an item

			if (player.inventoryEmpty()) {
				System.out.println("Inventory is empty.");
				break;
			} else {
				description = "Select the item that you want to choose:";
				GameLogic.gameSleep(Events.BATTLE_DEFAULT);
				player.displayInventory();
				choice = GameLogic.intChecker(description, player.getSize());
				player.useItem(choice);
			}
			break;
		case 3:
			// This is the case for when the player chooses to run away
			System.out.println("You ran away and failed the exam, you can try again later....");
			System.exit(0);

		}

	}

}
