package vendingmachine.controllor.person;

import develoferFuc.UI;
import notuseclass.VendingMachineActableImpl;
import vendingmachine.model.Person;
import vendingmachine.model.VendingMachine;

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

    public void showCoinOfPersonAtNow() {
        int coinOfUser = user.getCoinOfPerson();
        System.out.println("현재 손님의 돈:" + coinOfUser);
    }

    public void putInVendingMachineCoin() { // menu 1.동전넣기
        System.out.print("투입할 돈: ");
        int coinGiveUser = UI.getInt();
        if (user.isAppropriateRangeOfMoney2User(coinGiveUser) != true) {
            System.out.println("입력한 돈의 액수가 가지고있는 액수보다 커요!!");
            return;
        }
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
