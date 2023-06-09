package soandruRPG;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("*******RPG GAME*******");
		System.out.println("1. 전사");
		System.out.println("2. 마법사");
		System.out.println("3. 도적");
		System.out.printf("직업의 번호를 입력하세요. : ");
		int num = sc.nextInt();

		Hero h = null;
		String name;
		switch (num) {
		case 1:
			// 전사 생성
			System.out.println("*********************");
			System.out.println("전사가 선택되었습니다.");
			System.out.print("영웅의 이름을 입력하세요. : ");
			name = sc.next();
			h = new Warrior(name);
			break;

		case 2:
			// 마법사 생성
			System.out.println("*********************");
			System.out.println("마법사가 선택되었습니다.");
			System.out.print("영웅의 이름을 입력하세요. : ");
			name = sc.next();
			h = new Mage(name);
			break;

		case 3:
			// 도적 생성
			System.out.println("*********************");
			System.out.println("도적이 선택되었습니다.");
			System.out.print("영웅의 이름을 입력하세요. : ");
			name = sc.next();
			h = new Rogue(name);
			break;
		case 4:
			// 운영자 생성
			System.out.println("운영자가 선택되었습니다.");
			System.out.println("영웅의 이름을 입력하세요. : ");
			name = sc.next();
			h = new OperatorHero(name);
		}
		System.out.println("*********************");
		System.out.println("이름이 입력되었습니다.");
		System.out.println("게임에 입장하였습니다.");

		System.out.println("*********************");
		System.out.println("현재  Hero의 이름 : " + h.name);
		System.out.println("현재 " + h.name + "의 레벨 : " + h.level);
		System.out.println("현재 " + h.name + "의 힘 : " + h.power);
		System.out.println("현재 " + h.name + "의 방어력 : " + h.defense);
		System.out.println("현재 " + h.name + "의 HP : " + h.hp);
		System.out.println("현재 " + h.name + "의 MP : " + h.mp);
		System.out.println("현재 " + h.name + "의 경험치 : " + h.experience);
		System.out.println("현재 " + h.name + "의 돈 : " + h.money + "원");
		System.out.println("*********************");
		while (true) {
			System.out.println("*********************");
			System.out.println("1. 사냥터");
			System.out.println("2. 포션 상점");
			System.out.println("3. 수련의 방");
			System.out.println("4. 미니게임");
			System.out.println("5. 무기 상점");
			System.out.println("6. 요리실");
			System.out.println("7. 던전");
			System.out.println("*********************");
			System.out.printf("입장할 장소를 입력하세요. : ");
			num = sc.nextInt();
			if (num == 1) {
				System.out.println("*********************");
				System.out.println("사냥터에 입장하였습니다.");
				System.out.println("1. 타락한 들쥐");
				System.out.println("2. 타락한 불독");
				System.out.println("3. 타락한 늑대");
				System.out.println("4. 타락한 곰");
				System.out.println("몬스터를 선택하세요. : ");
				int monsterChoice = sc.nextInt();
				// Create Monster Based on User Input
				Monster chosenMonster;
				switch (monsterChoice) {
				case 1:
					chosenMonster = new Monster1();
					break;
				case 2:
					chosenMonster = new Monster2();
					break;
				case 3:
					chosenMonster = new Monster3();
					break;
				case 4:
					chosenMonster = new Monster4();
					break;
				default:
					chosenMonster = null;
					break;
				}
				HuntingGround hg = new HuntingGround();
				hg.battle(h, chosenMonster);

			} else if (num == 2) {
				System.out.println("****************************");
				System.out.println("포션 상점에 입장하였습니다.");
				PortionShop portionShop = new PortionShop();
				portionShop.marketShow(h);
			} else if (num == 3) {
				System.out.println("*********************");
				System.out.println("수련의 방에 입장하였습니다.");
				System.out.println("1. 몬스터 전투 훈련");
				System.out.println("2. 명상실");
				System.out.println("번호를 입력하세요. :");
				num = sc.nextInt();
				if (num == 1) {
					System.out.println("*********************");
					System.out.println("몬스터 전투 훈련을 시작합니다.");
					TrainingRoom tr = new TrainingRoom();
					Training_Monster1 trainingMonster1 = new Training_Monster1();
					tr.battle(h, trainingMonster1, 0);
				} else if (num == 2) {
					int meditationHpMp[];
					MeditationRoom s = new MeditationRoom();
					meditationHpMp = s.meditation();
					h.mp += meditationHpMp[0];
					h.mp += meditationHpMp[1];
					System.out.println("hp " + meditationHpMp[0] + " 회복");
					System.out.println("mp " + meditationHpMp[1] + " 회복");

				}
			} else if (num == 4) {
				System.out.println("****************************");
				System.out.println("미니게임에 입장하였습니다.");
				System.out.println("1. 진짜 몬스터를 찾아라!");
				System.out.println("2. 몬스터와의 가위바위보에서 이겨라!");
				System.out.printf("번호를 입력하세요. : ");
				num = sc.nextInt();
				if (num == 1) {
					System.out.println("*********************");
					System.out.println("미니 게임 1에 참가하셨습니다.");
					mini_game_1 game = new mini_game_1();
					game.playGame(h);
				} else if (num == 2) {
					mini_game_2 g2 = new mini_game_2();
					System.out.println("*********************");
					System.out.println("미니 게임 2에 참가하셨습니다.");
					mini_game_2 game = new mini_game_2();
					game.playGame2(h);
				}
			} else if (num == 5) {
				System.out.println("*********************");
				System.out.println("무기 상점에 입장하였습니다.");
				System.out.printf("%s의 현재 돈: " + h.getMoney(), h.name);
				System.out.println("\n****************************");
				WeaponShop weaponshop = new WeaponShop();
				weaponshop.displayWeapons(); // 무기 상점에 있는 무기 목록을 출력
				System.out.println("구매할 무기 이름을 입력하세요: ");
				String weaponName = sc.next();
				System.out.println("****************************");
				weaponshop.buyWeapon(h, weaponName); // 사용자가 입력한 무기 이름으로 무기를 구매
			} else if (num == 6) {
				System.out.println("****************************");
				System.out.println("요리실에 입장하였습니다.");
				cooking cooking = new cooking(h);
				cooking.makeDish(h);
			} else if (num == 7) {
				System.out.println("****************************");
				System.out.println("던전에 입장하였습니다.");
				BossMonster boss = new BossMonster();
				BossMonster1 BossMonster1 = new BossMonster1();
				boss.bossBattle(h, BossMonster1, 0);
				if (boss.clearBoss == 4) {
					break;
				}
			}
		}
	}
}
