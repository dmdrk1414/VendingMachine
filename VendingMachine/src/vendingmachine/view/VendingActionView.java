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

//		int coinGiveUser = this.user.subtractCoinCnt(0);
	}
}
