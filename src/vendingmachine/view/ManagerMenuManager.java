package vendingmachine.view;

import develoferFuc.UI;
import vendingmachine.controllor.inter.InitGetInstance;
import vendingmachine.controllor.manager.ManagerControllor;
import vendingmachine.model.Manager;
import vendingmachine.model.VendingMachine;

public class ManagerMenuManager {
    final private int MENU_COUNTER_NUMBER = 5;
    final private String Manager_PRINT_FIRST = "---------------------관리자 입니까?--------------------";
    final private String Manager_SELCEK_STRING = "메인메뉴| 0.Exit 1.제품등록 2.제품삭제 3.제품업데이트 4.제품보기 |";
    private Manager manager;
    private VendingMachine machine;

    public ManagerMenuManager(Manager manager, VendingMachine machine) {
        this.manager = manager;
        this.machine = machine;
    }

    public void run() {
        ManagerControllor managerControllor = InitGetInstance.newInstenceManagerControllor(manager, machine,
                InitGetInstance.newInstenceVendingMachineActableImpl());

        int manuCounter = MENU_COUNTER_NUMBER;
        while (true) {
            System.out.println(this.Manager_PRINT_FIRST);
            int selectMenuCount = UI.returnSelectMenuNum(manuCounter, Manager_SELCEK_STRING);
            if (selectMenuCount == 0) { // menu 0.나가기
                System.out.println("MainMenu로 돌아갑니다.");
                return;
            }
            switch (selectMenuCount) {
                case 1: // menu 1.제품등록 /
                    managerControllor.registerNewDrink();
                    break;
                case 2: // menu 2.제품삭제 /
                    managerControllor.deleteExistDrink2VendingMachine();
                    break;
                case 3: // menu 3.제품업데이트 /
                    managerControllor.updateDrinkInfo2VendingMachine();
                    break;
                case 4: // menu 4.제품보기 /
                    managerControllor.showDrinks2user();
                    break;
            }
        }
    }
}
