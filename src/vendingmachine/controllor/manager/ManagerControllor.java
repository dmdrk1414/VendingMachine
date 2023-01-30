package vendingmachine.controllor.manager;

import develoferFuc.UI;
import notuseclass.VendingMachineActableImpl;
import vendingmachine.model.Manager;
import vendingmachine.model.VendingMachine;

// 관리자는 많은 음료수를 가지고 있습니다. 등록, 제거, 업데이트, 
// 등록 : 가격과 자신의 재고를 넣는다
// 제거 : 음료수를 제거하면서,  현재 관리자의 재고를 올린다.
// 업데이트 : 이름과 가격을 변경한다
public class ManagerControllor {
    Manager manager;
    VendingMachine machine;
    VendingMachineActableImpl machineAction;

    public ManagerControllor() {
    }

    public ManagerControllor(Manager manager, VendingMachine machine, VendingMachineActableImpl machineAction) {
        super();
        this.manager = manager;
        this.machine = machine;
        this.machineAction = machineAction;
    }

    public void registerNewDrink() { // menu 1.제품등록
        System.out.println("제품을 추가합니다. (이름 가격 재고)을 적어주세요.");
        System.out.print("음료수 이름: ");
        String nameNewDrink = UI.getStrWord();
        System.out.print("음료수 가격: ");
        int priceNewDrink = UI.getInt();
        System.out.print("음료수 재고: ");
        int stockNewDrink = UI.getInt();
        machineAction.registerProduct(this.machine, nameNewDrink, priceNewDrink, stockNewDrink);
        this.showDrinks2user();
    }

    public void deleteExistDrink2VendingMachine() { // menu 2.제품삭제
        System.out.print("제거하고싶은 음료수를 고르세요: ");
        String pickNameDrink = UI.getStrWord();
        this.machineAction.deleteProduct(machine, pickNameDrink);
        this.showDrinks2user();
    }

    public void updateDrinkInfo2VendingMachine() { // menu 3.제품업데이트
        System.out.print("선택할 음료수 이름: ");
        String nameDrinkPick = UI.getStrWord();
        System.out.print("수정할 음료수 이름: ");
        String nameDrink2Change = UI.getStrWord();
        System.out.print("수정할 음료수 가격: ");
        int priceDrink2Change = UI.getInt();
        this.machineAction.reviseProduct(machine, nameDrinkPick, nameDrink2Change, priceDrink2Change);
        this.showDrinks2user();
    }

    public void showDrinks2user() { // menu 4.제품보기
        this.machineAction.showProducts(this.machine);
        System.out.println();
    }

}
