package testingproject;

public class BossMonster extends Monster {

	public BossMonster(String name, int MaxHp, int attack) {
		super(name, MaxHp, attack);
	}

	@Override
	public void monsterTurn(Player player) {

		int roll = Events.generateInt(1, 20);
		if (roll == 20) {
			player.damaged(8);
		} else if (roll <= 12) {
			System.out.println(name + " Has missed.");
		} else {
			player.damaged(4);
		}
		
		if(currentHp <=5) {
			String words="YOU'LL NEVER MAKE IT OUT OF HERE ALIVE";
			char[] wordsArray=words.toCharArray();
			for(char c:wordsArray) {
				System.out.print(c);
				GameLogic.gameSleep(700);
			}
			System.out.println();
;			
		}

	}

}
