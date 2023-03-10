package notuseclass;

import vendingmachine.model.VendingMachine;

public interface VendingMachineActable {
    public int getAmountCoinOfMachine(VendingMachine vendingMachine);

    public void inputCoin(VendingMachine vendingMachine, int CoinCnt);

    public int returnCoin(VendingMachine vendingMachine);

    public void registerProduct(VendingMachine vendingMachine, String nameDrink, int priceDrink, int stockDrink);

    public void deleteProduct(VendingMachine vendingMachine, String nameDrink);

    public void reviseProduct(VendingMachine vendingMachine, String nameDrink, String name2Change, int price2Change);

    public void showProducts(VendingMachine vendingMachine);

    public void pickProduct(VendingMachine vendingMachine, String name2Pick);
}
