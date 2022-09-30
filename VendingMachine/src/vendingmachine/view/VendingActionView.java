package vendingmachine.view;

import vendingmachine.controllor.VendingMachineActableImpl;
import vendingmachine.model.Person;
import vendingmachine.model.VendingMachine;

public class VendingActionView {
	Person user;
	VendingMachine machine;
	VendingMachineActableImpl machineAction;

	public VendingActionView() {
		this.user = new Person();
		this.machine = new VendingMachine();
		this.machineAction = new VendingMachineActableImpl();
	}

	public void putInVendingMachineCoin() {
		System.out.print("투입할 돈: ");
		int coinGiveUser = UI.getInt();
		if (user.subtractCoinCnt(coinGiveUser)) {
			machineAction.inputCoin(machine, coinGiveUser);
			System.out.println(coinGiveUser + "원 자판기에 투입!!");
		}
	}

	public void returnCoin2VendingMachine() {
		int CoinsReturn = machineAction.returnCoin(this.machine);
		if (user.addCoinCnt(CoinsReturn)) {
			System.out.println(CoinsReturn);
			System.out.println("자판기의 모든 돈을 반환합니다.!!!");
		}
	}

	public void showDrinks2user() {
		machineAction.showProducts(machine);
	}

	public static void main(String[] args) {
		VendingActionView view = new VendingActionView();
		view.putInVendingMachineCoin(); // 돈넣기
		view.returnCoin2VendingMachine(); // 돈반환
		view.putInVendingMachineCoin(); // 돈넣기
		view.showDrinks2user(); // 음료수 보여주기.
	}
}
