package testingproject;

import java.util.Arrays;
import java.util.Scanner;

public class Events {

	public static int DEFAULT = 0;
	public static int BATTLE_DEFAULT = 0;

	public static String firstLevelDescription = "You're brought to the entrance of this training dungeon. Steel your nerves. You wonder what you\n"
			+ "might encounter and with the instructor's signal, you head inside.";

	static void firstLevelEvents(Player player) {
		System.out.println(firstLevelDescription);
		switch (generateInt(1, 3)) {
		case 1:
			System.out.println(
					"You enter to find a room with wooden furniture and a hearth, its quite cozy in here and a bit dusty. While you\n"
							+ "search around the room curious to what might be next, you find a chest in the corner and walk up to it.");
			GameLogic.gameSleep(DEFAULT);
			treasure_chest(player);
			System.out.println(
					"You hear the door to the next room unlock. It seems like you're done here and should move along.");
			System.out.println(
					"You open the door and head down the hallway to a closed door. With bated breath you open it.");
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();
			find_Object(player, 3);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();
			GameLogic.sc.nextLine();
			wounded_Enemy(player);
			rest(player);

			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();
			break;
		case 2:
			System.out.println("This is first level events case: " + 2);
			GameLogic.gameSleep(DEFAULT);
			find_Object(player, 1);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();
			gift_Event(player);
			rest(player);

			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();
			break;
		case 3:
			System.out.println("This is first level events case: " + 3);
			GameLogic.gameSleep(DEFAULT);
			find_Object(player, 2);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();
			wondrous_Pools(player);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();
			earthquakes(player);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();
			wounded_Enemy(player);
			rest(player);

			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			break;
		default:
			System.out.println("Something went wrong with firstlevelEvents method");
			break;

		}
		secondLevelEvents(player);
	}

	static void secondLevelEvents(Player player) {
		switch (generateInt(1, 3)) {
		case 1:
			System.out.println("This is second level events case: " + 1);
			feast_Event(player);
			GameLogic.gameSleep(DEFAULT);

			wounded_Ally(player);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			wordGame(player);
			rest(player);

			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			break;
		case 2:
			System.out.println("This is second level events case: " + 2);
			GameLogic.gameSleep(DEFAULT);

			feast_Event(player);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			treasure_chest(player);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			wordGame(player);
			rest(player);

			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			break;
		case 3:
			System.out.println("This is second level events case: " + 3);
			GameLogic.gameSleep(DEFAULT);

			earthquakes(player);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			treasure_chest(player);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			feast_Event(player);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			wordGame(player);
			rest(player);
			GameLogic.gameSleep(DEFAULT);
			GameLogic.anythingtoContinue();

			break;
		default:
			System.out.println("Something went wrong with firstlevelEvents method");
			break;

		}
	}

	static void bossFight(Player player) {
		
		

	}

	// this is random chance generator
	public static int generateInt(int low, int high) {
		return ((int) ((Math.random() * 1000000000) % ((high + 1) - low)) + low);
	}

	// here create methods for Events

	public static void battle_events(Player player, Monster monster) {
		System.out.println("\nBattle Start!\n");
		BattleSystem battle = new BattleSystem();
		battle.Battle(player, monster);
		if (player.isDead()) {
			System.out.println("You lost and have been transported back to the infirmary, better luck next exam...");
			System.exit(0);
		} else {
			System.out.println("You won! Battle Over!");
			giveItem(player);
		}

	}

	public static void giveItem(Player player) {
		Potions potion = new Potions();
		player.addItem(potion);
		// System.out.println("You have been given a new item");
	}

	public static void treasure_chest(Player player) {
		System.out.println(
				"You run up to the chest and open it, hoping for for coins or loot. This might be your lucky day.");
		switch (generateInt(1, 2)) {
		case 1:
			System.out.println("You found a potion!");
			giveItem(player);
			System.out.println(
					"It was quite lucky to have not triggered a trap or found a monster, you should be more careful not to be fooled or"
							+ "\nambushed by enemies.");
			break;
		case 2:
			System.out.println(
					"As you open the chest, you find nothing. You wonder why there was no trap or teasure in this chest until you hear/n"
							+ "it start growling. You see teeth start to form and foam coming out, it looks at you and jumps at your /n"
							+ "direction to take a bite.");
			Monster monster = new Monster("Mimic", 11, 3);
			battle_events(player, monster);
			System.out.println(
					"Dangers come in many forms and you need to watch out for it, hopefully this won't affect your grade much.");
			break;
		}
	}

	public static void find_Object(Player player, int eventDescription) {

		String general_description = null;
		String event_description_case_1 = "";
		String event_description_case_2 = "";
		String event_description_case_3 = "";
		String name = null;
		int hp = 0;
		int attack = 0;
		switch (eventDescription) {
		case 1:
			name = "Goblin";
			hp = 12;
			attack = 6;
			break;
		case 2:
			name = "Giant Rat";
			hp = 13;
			attack = 6;
			break;
		case 3:
			name = "Slime";
			hp = 7;
			attack = 2;
			break;
		}
		switch (eventDescription) {
		case 1:
			general_description = "You see something shiny in the distance...";
			event_description_case_1 = "You found a potion";
			event_description_case_2 = "A Goblin jumped from behind a nearby chair and attacks!";
			event_description_case_3 = "It was garbage sadly.";
			break;
		case 2:
			general_description = "You find yourself a grassy field. It appears you came out into a ruin with broken stone walls and pillars. You wonder\n"
					+ " how they were able to accomplish this. \"Magic sure is great.\" you think as the sky starts to darken and the wind picks up. Rain \n"
					+ "start to pour and you hear a crack of thunder. Lighting flashes and hits the ground close to you. \"Okay maybe magic\n"
					+ "isn't all that great afterall.\" you scream as lightning strikes a nearby pillar, causing it to come crashing down onto a wall, crumbling part of it.\n"
					+ "and creating a small hole.  For now it seems safe, so you check the damage the pillar did. In this hole you see something.";
			event_description_case_1 = "You found a potion in the wall! Against your better judgement you stuck your hand in a random hole and were \n"
					+ "rewarded for it. ";
			event_description_case_2 = "Suddenly, a giant rat emerges from the wall. Its time to battle!";
			event_description_case_3 = "You found nothing but rubble sadly.";
			break;
		case 3:
			general_description = "You find yourself in a cave.  There is fauna clinging to the damp walls, and a small stream flowing through. It's dark, illuminated"
					+ "\nonly by a single torch on the wall. Underneath the torch, you notice an odd jelly like material. You think you see something, and decide to check.";
			event_description_case_1 = "You found a potion! It's all sticky and gross. You wonder if its even still good to drink. Along side the\n"
					+ "the potion you see a key, it might be used to unlock something.";
			event_description_case_2 = "As you put your hand in this mess to dig out the thing you saw, your hands starts burning. You\n"
					+ "check the jello again to see that it is moving and at a closer look, what was inside was a key and disolving rat carcass. \n"
					+ "It shakes angrily at you for disturbing it's meal and attacks!";
			event_description_case_3 = "You dig through the jello and start to feel your hand going numb. You grab the thing you saw and quickly pull\n"
					+ " out holding it. You see it's a key and think that it could be used to get to the next room. You also see that some skin has 'n"
					+ "disolved and starts to burn. You quickly get out of there shaking your hand to rid yourself of the jello.";
			break;
		}
		System.out.println(general_description);
		switch (generateInt(1, 3)) {
		case 1:
			System.out.println(event_description_case_1);
			GameLogic.gameSleep(DEFAULT);
			giveItem(player);
			break;
		case 2:
			System.out.println(event_description_case_2);
			GameLogic.gameSleep(DEFAULT);
			Monster monster = new Monster(name, hp, attack);
			battle_events(player, monster);
			break;
		case 3:
			System.out.println(event_description_case_3);
			GameLogic.gameSleep(DEFAULT);
			break;
		}

	}

	public static void feast_Event(Player player)

	{
		String description = "You see a feast with a bunch of meat you never seen before... Do you partake in it?\n1. Yes \n2. No\nChoice: ";
		// System.out.println("You see a feast going on... Do you partake in it?");
		// System.out.println("1. Yes \n2. No\nChoice: ");
		int choice = GameLogic.intChecker(description, 2);
		switch (choice) {
		case 1:
			// Player chooses to eat
			System.out.println("You decide to eat the \"food\"");
			GameLogic.gameSleep(DEFAULT);
			switch (generateInt(1, 3)) {
			case 1: {
				System.out.println("Despite the gross appearance, the food is tasty. You regain some health");
				player.healed(5);
				System.out.println(
						"After eating your full of the mystery meat, the host waves you on towards the next room.");
				break;
			}
			case 2: {
				System.out.println("It tastes as bad as it looks. You lose a bit of health");
				player.damaged(2);
				System.out.println("You run out of the room wanting to find a bucket to be sick in.");
				break;
			}
			case 3: {
				System.out.println("As you take a bite, the meat squirms out of you hand and looks angry."
						+ "\nIt breaks it's own bones to attack you with. FOOD FIGHT!");
				Monster monster = new Monster("Mystery Meat", 5, 1);
				battle_events(player, monster);
				System.out.println(
						"After this weird fight with the meat, you think you might want to go vegan as you leave the room.");
				break;
			}
			}
			break;
		case 2:
			// Player chose to decline food
			System.out.println("You decide to decline the food");
			GameLogic.gameSleep(DEFAULT);
			switch (generateInt(1, 2)) {
			case 1:
				System.out.println("You tell the host you ate on the way here and can't eat another bite."
						+ "\nHe nods and smiles behind his creepy muzzle mask."
						+ "\nYou can feel his gaze as you briskly walk out of the room.");
				break;
			case 2:
				System.out.println("You decline the food and offend the host, He jumps at you with a butcher's knife!");
				Monster monster = new Monster("Hannibal", 16, 2);
				battle_events(player, monster);
				System.out.println(
						"You take a deep breath after that fight and think to yourself about the odd shape of the meat,"
								+ "\n it looks almost human. You leave the room quickly wanting to forget this...");
				break;
			}
			break;

		}
		GameLogic.gameSleep(DEFAULT);

	}

	public static void gift_Event(Player player) {
		String description = "A demon holds a mysterous box and says it's a gift for you... Do you accept it?\n1. Yes \n2. No\nChoice: ";
		int choice = GameLogic.intChecker(description, 2);
		switch (choice) {
		case 1:
			// Player chooses to eat
			System.out.println("You decide to accept the gift");
			switch (generateInt(1, 3)) {
			case 1: {
				System.out.println("You open the box and find a potion, how kind!");
				giveItem(player);
				break;
			}
			case 2: {
				System.out.println("You open the box and find a bomb! It explodes taking away a bit of your health.");
				System.out.println("You look around wanting to murder that demon, but he is long gone.");
				player.damaged(2);
				break;
			}
			case 3: {
				System.out.println("You open the box and find a Giant Slime. It bounces and attacks you!");
				Monster monster = new Monster("Giant Slime", 8, 3);
				battle_events(player, monster);
				System.out.println("You search around for the demon thinking he would attack you too,\n"
						+ "but he is no where to be see, you exit the room.");
				break;
			}
			}
			break;
		case 2:
			// Player choose to decline gift
			System.out.println("You decide not to accept the gift");
			switch (generateInt(1, 2)) {
			case 1:
				System.out.println("You refuse the gift, not wanting to be tricked by the demon,. He looks at you "
						+ "\nand says \"One way or another I will get your soul\" and disappears in a puff of smoke.");
				break;
			case 2:
				System.out.println("You refuse the gift and tell the demon to go back to hell. He looks at you with\n"
						+ "glowing red eyes and says\"Fine, then I will take your soul by force!\" and charges at you.");
				Monster monster = new Monster("Demon Bob", 14, 2);
				battle_events(player, monster);
				break;
			}
			break;
		}
	}

	public static void wounded_Enemy(Player player) {
		String description = "You find a wounded Troll along your path, what do you do?\n1. Kill the enemy \n2. Save the enemy \n3. Move along";
		int choice = GameLogic.intChecker(description, 3);
		switch (choice) {
		case 1:
			// Player chooses to kill the enemy
			System.out.println("You decide to kill the wounded Troll");
			switch (generateInt(1, 3)) {
			case 1: {
				System.out.println("Not much effort was needed, the Troll slumps and stops moving.\n"
						+ "In her hand was a potion.");
				giveItem(player);

				break;
			}
			case 2: {
				System.out.println(
						"You hear a gasp behind you. As you turn around you see another troll with a shocked expression.\n"
								+ "He screams \" You killed my wife! I'll kill you!\" and jumps at you with his dagger!");
				Monster monster = new Monster("Troll Ryan", 14, 2);
				battle_events(player, monster);
				System.out.println("Beside his dead body was a healing potion, \"who was this for?\" you wonder");
				break;
			}
			case 3: {
				System.out.println(
						"You kill the wounded troll expecting something, anything, but nothing happens. You leave \n"
								+ "wondering if you did the right thing.");
				break;
			}
			}
			break;
		case 2:
			// Player decides to save the enemy
			System.out.println("You decide to save the wounded enemy");
			switch (generateInt(1, 2)) {
			case 1:
				System.out.println("You save the Troll and she  thanks you with two potion");
				giveItem(player);
				giveItem(player);
				break;
			case 2:
				System.out.println(
						"You try saving the Troll but she attacks in self defence, delirious from the blood loss.\n"
								+ "She leaves you no choice, it's you or her.");
				Monster monster = new Monster("Troll Blake", 4, 1);
				battle_events(player, monster);
				System.out.println("It didn't take much effort to end her, only thing to do now is move on.");
				break;
			}
			break;
		case 3:
			System.out.println("You decide to move along as you hear the Troll take her last breath...");
		}

	}

	public static void wounded_Ally(Player player) {
		String description = "You find a wounded ally along your path, what do you do?\n"
				+ "1. Kill the ally \n2. Save the ally \n3. Move along";
		int choice = GameLogic.intChecker(description, 3);
		switch (choice) {
		case 1:
			// Player chooses to kill the ally
			System.out.println("You decide to kill the wounded ally");
			switch (generateInt(1, 3)) {
			case 1: {
				System.out.println("You kill the ally and steal a potion from their dead body");
				giveItem(player);
				break;
			}
			case 2: {
				System.out.println("You kill the ally and their friend shows up and fights you");
				Monster monster = new Monster("Human Joe", 16, 2);
				battle_events(player, monster);
				break;
			}
			case 3: {
				System.out.println("You killed a defenseless ally for no apparent reason and find nothing of use.");
				break;
			}
			}
			break;
		case 2:
			// Player decides to save the ally
			System.out.println("You decide to save the wounded ally");
			switch (generateInt(1, 2)) {
			case 1:
				System.out.println("You save the ally and the ally thanks you with a potion");
				giveItem(player);
				break;
			case 2:
				System.out.println("You try saving the ally, but his chest bursts open and a Corpse Worm appears");
				Monster monster = new Monster("Corpse Worm", 16, 2);
				battle_events(player, monster);
				break;
			}
			break;
		case 3:
			System.out.println("You decide to move along as you hear the wounded ally take their last breath...");
		}

	}

	public static void wondrous_Pools(Player player) {
		String description = "You reach a shimmering cold body of water, Do you want to drink the water?\n"
				+ "1. Yes \n2. No ";
		int choice = GameLogic.intChecker(description, 2);
		switch (choice) {
		case 1:
			// Player chooses to drink the water
			System.out.println("You decide to drink the water");
			switch (generateInt(1, 3)) {
			case 1: {
				System.out.println("You drink the water and the water magicly heals you");
				player.healed(6);
				break;
			}
			case 2: {
				System.out.println("You drink the water and get poisoned, thus losing some health");
				player.damaged(3);
				break;
			}
			}
			break;
		case 2:
			// Player decides to not drink the water
			System.out.println("You decide to not drink the water and move along");
		}

	}

	public static void earthquakes(Player player) {
		String description = "An Earthquake strikes and everything around you is falling to crumble. What are you going to do?\n"
				+ "1. Hide under the nearest object \n2. Stay in place";
		int choice = GameLogic.intChecker(description, 2);
		switch (choice) {
		case 1:
			// Player chooses to hide under the nearest object
			System.out.println("You decide to hide under the nearest object");
			switch (generateInt(1, 2)) {
			case 1: {
				System.out.println("You hide under the nearest object and still get hit by falling debris");
				player.damaged(2);
				break;
			}
			case 2: {
				System.out.println("You hide under the nearest object and find something shiny");
				giveItem(player);
				break;
			}
			}
			break;
		case 2:
			// Player decides stay in place
			System.out.println("You decide to stay in place and try to dodge incoming damage");
			switch (generateInt(1, 2)) {
			case 1:
				System.out.println("You stay in place and get hit by falling debris");
				player.damaged(3);
				break;
			case 2:
				System.out.println("You stay in place and luckily dont get injured. You find something shiny...");
				giveItem(player);
				break;
			}
			break;

		}
	}

	public static void wordGame(Player player) {
		int rounds = 0;
		boolean playerWon = false;
		String word = wordGameWordRandomizer();
		String description = wordGameWordDescription(word);
		String wordHolder;
		char[] wordArray = word.toCharArray();
		System.out.println(
				"You see a stone carving of a figure ahead of you, beneath it are holes that seems something can be put in it.");
		System.out.println(
				"Around you are stone tablets that fit these holes, maybe if you put them in the correct order something good might happen...\n");
		System.out.println(description);
		try {
			Scanner sca = new Scanner(System.in);
			char[] wordRevealArray = new char[word.length()];
			for (int i = 0; i < wordRevealArray.length; i++)
				wordRevealArray[i] = '#';
			while (rounds < 7) {
				for (char d : wordRevealArray)
					System.out.print(d);
				System.out.println("\n\nAnswer: ");
				wordHolder = sca.next();
				wordHolder = wordHolder.toUpperCase();
				char[] wordHolderArray = wordHolder.toCharArray();
				for (int i = 0; i < wordArray.length; i++) {
					for (int j = 0; j < wordHolderArray.length; j++) {
						if (wordHolderArray[j] == (wordArray[i])) {
							wordRevealArray[i] = wordArray[i];
						}
					}
				}
				if (wordHolder.equals(word)) {
					System.out.println("Yay you did it. you got it right.");
					break;
				} else if (Arrays.equals(wordRevealArray, wordArray)) {
					System.out.println("The world was revealed! it was " + word);
					playerWon = true;
					break;
				} else {
					System.out.println("You got it wrong");
				}

			}

		} catch (Exception e) {
			System.out.println("Error in word game");
		}

		if (rounds < 7 || playerWon == true) {
			System.out.println("You get a potion");
			giveItem(player);
		} else {
			System.out.println("You sadly didn't get the puzzle in time, the stone carving breaks apart...");
		}

	}

	public static String wordGameWordDescription(String word) {
		String description = "Nothing";
		switch (word) {
		case "CHRONOS":
			description = "You see a old withered man holding an hour glass and turning the zodiac wheel.";
			break;
		case "NYX":
			description = "You see a women clad in a dress with symbols of the moon and stars around her.";
			break;
		case "HADES":
			description = "You see an old man in a cloak, holding a scythe in his hand. He is is a small raft on a river.\n"
					+ "There are hands reaching out from underneath the water.";
			break;
		case "ATHENA":
			description = "You see a woman, strong and confident clad in battle worn armor.\nShe stands on her defeated foe with a large weapon. ";
			break;
		case "ZEUS":
			description = "You see a an old man with a strong body. He is holding what looks like lightning bolts.";
			break;
		case "THOR":
			description = "You see a young man with a muscular body. He poses with his weapon in the air that is struck with lightning."
					+ "\nIt looks like a hammer.";
			break;
		case "ODIN":
			description = "You see an old man missing an eye. He sits upon a throne with a raven on his shoulder.";
			break;
		case "LOKI":
			description = "You see a young man with a mischievous smile, he seems likes a trickster. There is a cow with multiple legs behind him.";
			break;
		case "ANUBIS":
			description = "You see a tall man, but where his head should be, it is replaced with a jackal's head.\n"
					+ "In one hand he holds a heart, and in the other he holds a sickle. There are tombs behind him.";
			break;
		case "HELIOS":
			description = "You see a titan of a man in a chariot, being drawn by several horses. Behind him he drags the Sun.";
			break;
		case "SELENE":
			description = "You see a titan of a woman in a chariot, being drawn by a pair of winged steeds. Behind her is the Moon.";
			break;
		case "KRATOS":
			description = "You see a frightningly strong man, he wields bloody weapons and is surrounded by dead bodies\n"
					+ "that appear to look like a pantheon of gods...";
			break;

		default:
			System.out.println("Error in descripton for word game found");
			break;
		}
		return description;
	}

	public static String wordGameWordRandomizer() {
		String word = null;
		switch (generateInt(1, 12)) {
		case 1:
			word = "CHRONOS";
			break;
		case 2:
			word = "NYX";
			break;
		case 3:
			word = "HADES";
			break;
		case 4:
			word = "ATHENA";
			break;
		case 5:
			word = "ZEUS";
			break;
		case 6:
			word = "THOR";
			break;
		case 7:
			word = "ODIN";
			break;
		case 8:
			word = "LOKI";
			break;
		case 9:
			word = "ANUBIS";
			break;
		case 10:
			word = "HELIOS";
			break;
		case 11:
			word = "SELENE";
			break;
		case 12:
			word = "KRATOS";
			break;

		default:
			word = wordGameWordRandomizer();
			break;
		}
		return word;
	}

	public static void rest(Player player) {
		String description = "Do you want to rest for an hour?\n1. Yes\n2. No\nChoice: ";
		int choice = GameLogic.intChecker(description, 2);
		switch (choice) {
		case 1:
			System.out.println("You rest and regain your strength.");
			player.healed(3);
			break;
		case 2:
			System.out.println("You decide not to rest.");
			break;
		default:
			System.out.println("Something went wrong in Events rest method...");
			break;

		}
	}
}
