package vendingmachine.controllor.person;

import vendingmachine.controllor.vendingmachine.VendingMachineActableImpl;
import vendingmachine.model.Person;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.UI;

public class PersonControllor {
    Person user;
    VendingMachine machine;
    VendingMachineActableImpl machineAction;

    public PersonControllor() {
        System.out.println("3");
    }

    public PersonControllor(Person user, VendingMachine machine, VendingMachineActableImpl machineAction) {
        super();
        this.user = user;
        this.machine = machine;
        this.machineAction = machineAction;
    }

    public void putInVendingMachineCoin() { // menu 1.동전넣기
        System.out.print("투입할 돈: ");
        int coinGiveUser = UI.getInt();
        if (user.subtractCoinCnt(coinGiveUser)) {
            machineAction.inputCoin(this.machine, coinGiveUser);
            System.out.println(coinGiveUser + "원 자판기에 투입!!");
        }
        System.out.println();
    }

    public void returnCoin2VendingMachine() { // menu 2.동전반환
        int CoinsReturn = machineAction.returnCoin(this.machine);
        if (user.addCoinCnt(CoinsReturn)) {
            System.out.println("자판기의 모든 돈을 반환합니다.!!!");
        }
        System.out.println();
    }

    public void chooseDrink2VendingMachine() { // menu 3.제품선택
        System.out.print("선택할 음료수 이름: ");
        String nameDrinkPick = UI.getStrWord();
        this.machineAction.pickProduct(this.machine, nameDrinkPick);
        System.out.println();
    }

    public void showDrinks2user() { // menu 4.제품보기
        this.machineAction.showProducts(this.machine);
        System.out.println();
    }
}
