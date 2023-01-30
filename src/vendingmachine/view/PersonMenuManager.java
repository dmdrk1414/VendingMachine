package vendingmachine.view;

import develoferFuc.UI;
import notuseclass.VendingMachineActable;
import vendingmachine.controllor.inter.InitGetInstance;
import vendingmachine.controllor.person.PersonControllor;
import vendingmachine.model.Person;
import vendingmachine.model.VendingMachine;

public class PersonMenuManager {
    final private int MENU_COUNTER_NUMBER = 5;
    final private String Person_PRINT_FIRST = "--------------------사람 입니까?--------------------";
    final private String MANU_SELCEK_STRING = "메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |";
    private Person person;
    private VendingMachine machine;

    public PersonMenuManager(Person person, VendingMachine machine) {
        this.person = person;
        this.machine = machine;
    }

    public void run() {
        PersonControllor personControllor = InitGetInstance.newInstencePersonControllor(person, machine,
                InitGetInstance.newInstenceVendingMachineActableImpl());
        VendingMachineActable vendingMachinControllor = InitGetInstance.newInstenceVendingMachineActableImpl();

        int manuCounter = MENU_COUNTER_NUMBER;
        while (true) {
            System.out.println(Person_PRINT_FIRST);
            personControllor.showCoinOfPersonAtNow();
            System.out.println("현재 자판기에 남아있는 돈:" + vendingMachinControllor.getAmountCoinOfMachine(machine));
            int selectMenuCount = UI.returnSelectMenuNum(manuCounter, MANU_SELCEK_STRING);
            if (selectMenuCount == 0) { // menu 0.나가기
                System.out.println("MainMenu로 돌아갑니다.");
                return;
            }
            switch (selectMenuCount) {
                case 1: // menu 1.동전넣기 /
                    personControllor.putInVendingMachineCoin();
                    break;
                case 2: // menu 2.동전반환 /
                    personControllor.returnCoin2VendingMachine();
                    break;
                case 3: // menu 3.제품선택
                    personControllor.chooseDrink2VendingMachine();
                    break;
                case 4: // menu 4.제품보기 /
                    personControllor.showDrinks2user();
                    break;
            }
        }
    }
}
