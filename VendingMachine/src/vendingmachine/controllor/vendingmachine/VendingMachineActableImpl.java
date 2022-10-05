package vendingmachine.controllor.vendingmachine;

import vendingmachine.controllor.inter.VendingMachineActable;
import vendingmachine.model.VendingMachine;

public class VendingMachineActableImpl implements VendingMachineActable {
	@Override
	public void inputCoin(VendingMachine vendingMachine, int CoinCnt) {
		vendingMachine.addCoin2VendingMachine(CoinCnt);
	}

	@Override
	public int returnCoin(VendingMachine vendingMachine) {
		int returnCoin = vendingMachine.returnAllAmountCoin();
		return returnCoin;
	}

	@Override
	public void registerProduct(VendingMachine vendingMachine, String nameDrink, int priceDrink, int stockDrink) {
		vendingMachine.registerDrink(nameDrink, priceDrink, priceDrink);
	}

	@Override
	public void deleteProduct(VendingMachine vendingMachine, String nameDrink) {
		vendingMachine.deletePickDrink(nameDrink);
	}

	@Override
	public void reviseProduct(VendingMachine vendingMachine, String nameDrink, String name2Change, int price2Change) {
		vendingMachine.isUpdateDrinkInfo(nameDrink, name2Change, price2Change);
	}

	@Override
	public void showProducts(VendingMachine vendingMachine) {
		vendingMachine.showDrinkList();
	}

	@Override
	public void pickProduct(VendingMachine vendingMachine, String name2Pick) {
		vendingMachine.pickDrinkType(name2Pick);
	}

}
