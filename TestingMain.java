package testingproject;

public class TestingMain {

	public static void main(String[] args) {
		Player player =GameLogic.getPlayer();
//		Monster monster = new Monster("rat", 10,2);
//		Events.giveItem(player);
//		Events.giveItem(player);
//		Events.giveItem(player);

//		Events.battle_events(player, monster);
	//	Events.wordGame(player);
//		GameLogic.anythingtoContinue();
//		Events.rest(player);
		Events.firstLevelEvents(player);
	//	GameLogic.anythingtoContinue();
		System.out.println("End of test run");
		
		
	}

}
