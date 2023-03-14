package testingproject;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

public class GameLogic {
	static Scanner sc = new Scanner(System.in);

	public static Player getPlayer() {
		String name;
		int confirm;
		while (true) {
			System.out.println("\"Welcome recruit to your final examination! In this exam you'll be tested on how well you can handle yourself in\n"
					+ "situations that you may find while adventuring. This is your warning, DO NOT underestimate the dangers of these situations.\n"
					+ "It may be a test, but the dangers are real. If you take enough damage and faint, you will fail and have to retake the exam.\n"
					+ "Now what is your name?\"\n\nPlease enter your name: ");
			name = sc.nextLine();
			System.out.println("You have chosen " + name + " is that correct?\n1. Yes\n2. No\nChoice: ");
			confirm = Integer.parseInt(sc.next());
			//sc.nextLine();
			if (confirm == 1)
				break;

		}
		Player player = new Player(name);
		
		System.out.println("\"Welcome "+player.getName()+" and good luck on your Exam!\"");
		anythingtoContinue();
		return player;

	}

	public static void gameSleep(int seconds) {
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void gameSleep(long millieSeconds) {
		try {
			TimeUnit.MILLISECONDS.sleep(millieSeconds);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void gameStory() {
		// try {
		String story = "You grew up hearing stories about legendary heroes and their epic battles to protect the people\n"
				+ "and save the world. You trained hard to get accepted into the hero academy and even harder to pass\n"
				+ "your classes. Now the final exam is upon you and if you pass you'll be given your license and graduate\n"
				+ "from the academy. Your final exam is to traverse a training dungeon and beat the boss! Running away or fainting\n"
				+ "will result in a failure and you will need to retake the exam. \n\nYou will not fail!";
		System.out.println(story);
//			char[] storyArray = story.toCharArray();
//			for (char c : storyArray) {
//				System.out.print(c);
//				TimeUnit.MILLISECONDS.sleep(20);
		// }

		// } catch (Exception e) {
		// System.out.println(e);
		// }
		anythingtoContinue();

	}

	public static void anythingtoContinue() { 
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
            //sc.nextLine();
        }  
        catch(Exception e)
        {}  
        
        clearScreen();
 }

	public static int intChecker(String description, int numChoices) {
		int choice;

		do {
			System.out.println(description);
			try {
				
				choice = Integer.parseInt(sc.next());
				sc.nextLine();
				
			} catch (Exception e) {
				choice = -1;	
				System.out.println("Please enter a valid number");
			
			}

			if (choice > numChoices || choice < 0)
				System.out.println("Please choose a number within the range of choices...");

		} while (choice < 1 || choice > numChoices);

		return choice;
	}

	public static void clearScreen() {
		for (int i = 0; i < 50; i++)
			System.out.println("");
	}

}
