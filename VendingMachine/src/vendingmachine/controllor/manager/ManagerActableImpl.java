package vendingmachine.controllor.manager;

import vendingmachine.controllor.inter.ManagerActable;
import vendingmachine.model.VendingMachine;

public class ManagerActableImpl implements ManagerActable {

    @Override
    // 관리자가 자판기 제품 등록하는 메서드
    public void registerProduct(VendingMachine vendingMachine, String nameDrink, int priceDrink, int stockDrink) {
        vendingMachine.registerDrink(nameDrink, priceDrink, priceDrink);
    }

    @Override
    // 관리자가 자판기 제품 삭제하는 메서드
    public void deleteProduct(VendingMachine vendingMachine, String nameDrink) {
        vendingMachine.deletePickDrink(nameDrink);
    }

    @Override
    // 관리자가 자판기 제품 업데이트 메서드
    public void reviseProduct(VendingMachine vendingMachine, String nameDrink, String name2Change, int price2Change) {
        vendingMachine.isUpdateDrinkInfo(nameDrink, name2Change, price2Change);
    }

    @Override
    // 관리자가 자판기 제품을 본다 메서드
    public void showProducts(VendingMachine vendingMachine) {
        vendingMachine.showDrinkList();
    }

}
