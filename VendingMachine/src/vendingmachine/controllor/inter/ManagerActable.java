package vendingmachine.controllor.inter;

import vendingmachine.model.VendingMachine;

//  제품등록, 제품삭제, 제품업데이트
public interface ManagerActable {

    // 제픔등록
    public void registerProduct(VendingMachine vendingMachine, String nameDrink, int priceDrink, int stockDrink);

    // 제품삭제
    public void deleteProduct(VendingMachine vendingMachine, String nameDrink);

    // 제품업데이트
    public void reviseProduct(VendingMachine vendingMachine, String nameDrink, String name2Change, int price2Change);

    // 제품보기
    public void showProducts(VendingMachine vendingMachine);
}
