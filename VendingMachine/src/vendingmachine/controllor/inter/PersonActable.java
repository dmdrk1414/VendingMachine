package vendingmachine.controllor.inter;

import vendingmachine.model.VendingMachine;

public interface PersonActable {
    // Person이 자판기에 돈을 추가하는 메서드.
    public void inputCoin(VendingMachine vendingMachine, int CoinCnt);

    // Person이 자판기에서 돈을 반환하는 메서드.
    public int returnCoin(VendingMachine vendingMachine);

    // Person이 자판기의 제품을 보는 메서드.
    public void showProducts(VendingMachine vendingMachine);

    // Person이 자판기의 음료를 선택하는 메서드.
    public void pickProduct(VendingMachine vendingMachine, String name2Pick);

}
