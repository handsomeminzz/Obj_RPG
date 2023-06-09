package soandruRPG;
import java.util.ArrayList;

public class WeaponShop {
	private ArrayList<Weapon> weapons;

	public WeaponShop() {
		this.weapons = new ArrayList<>();

		// 팩토리에서 무기를 가져와 추가
		this.weapons.add(WeaponFactory.createWizardWeapon1());
		this.weapons.add(WeaponFactory.createWizardWeapon2());
		this.weapons.add(WeaponFactory.createWarriorWeapon1());
		this.weapons.add(WeaponFactory.createWarriorWeapon2());
		this.weapons.add(WeaponFactory.createRogueWeapon1());
		this.weapons.add(WeaponFactory.createRogueWeapon2());
	}

	public void buyWeapon(Hero h, String weaponName) {
		Weapon weaponToBuy = null; // 에러 방지의 일환 예외 처리
		for (Weapon weapon : weapons) {
			if (weapon.getName().equals(weaponName)) {
				weaponToBuy = weapon;
				break;
			}
		}
		if (weaponToBuy != null) {
			if (h.getMoney() >= weaponToBuy.getPrice()) {
				h.setMoney(h.getMoney() - weaponToBuy.getPrice());
				System.out.println(weaponName + " 구매 성공! 잔여 액수: " + h.getMoney());
				System.out.println("무기가 장착되었습니다.\n");
				System.out.println("****************************");
			} else {
				System.out.println("구매 실패! 잔액이 부족합니다 : " + weaponName);
				System.out.println("****************************");
			}
		} else {
			System.out.println("무기를 찾을 수 없음..");
		}
	}

	public void displayWeapons() {
		for (Weapon weapon : weapons) {
			System.out.println("무기 이름: " + weapon.getName() + ", 데미지: " + weapon.getDamage() + ", 금액: " + weapon.getPrice());
		}
	}
}
