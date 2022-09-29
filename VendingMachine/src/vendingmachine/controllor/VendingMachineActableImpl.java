package vendingmachine.controllor;

import vendingmachine.model.VendingMachine;

public class VendingMachineActableImpl implements VendingMachineActable {
//	public static void main(String[] args) {
//		VendingMachineActableImpl test = new VendingMachineActableImpl();
//		VendingMachine e = new VendingMachine();
//
//	}

	@Override
	public void inputCoin(VendingMachine vendingMachine, int CoinCnt) {
		vendingMachine.addCoin2VendingMachine(CoinCnt);
	}

	@Override
	public int returnCoin(VendingMachine vendingMachine) {
		if (!vendingMachine.isCoinEmpty()) {
			int returnCoin = vendingMachine.returnAllAmountCoin();
			return returnCoin;
		} else {
			return 0;
		}
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
		// TODO Auto-generated method stub
	}

	@Override
	public void showProducts(VendingMachine vendingMachine) {
		vendingMachine.showDrinkList();
	}

	@Override
	public void pickProduct(VendingMachine vendingMachine, String name2Pick) {

	}

}
