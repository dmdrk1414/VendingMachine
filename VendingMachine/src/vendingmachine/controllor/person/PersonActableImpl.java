package vendingmachine.controllor.person;

import vendingmachine.controllor.inter.PersonActable;
import vendingmachine.model.VendingMachine;

public class PersonActableImpl implements PersonActable {

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
    public void showProducts(VendingMachine vendingMachine) {
        vendingMachine.showDrinkList();
    }

    @Override
    public void pickProduct(VendingMachine vendingMachine, String name2Pick) {
        vendingMachine.pickDrinkType(name2Pick);
    }
}
