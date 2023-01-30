package vendingmachine.view;

import develoferFuc.UI;
import notuseclass.VendingActionView;
import vendingmachine.controllor.ObjectManager;

public class MainMenu {
    final private int MENU_COUNTER_NUMBER = 3;
    final private String MANU_PRINT_FIRST = "--------사람입니까 관리자입니까?-------------";
    final private String MANU_SELCEK_STRING = "메인메뉴| 0.Exit 1.사람입니다. 2.관리자입니다. |";
    private ObjectManager objectManager;

    public MainMenu() {
        this.objectManager = new ObjectManager();
    }

    public void run() {
        VendingActionView vendingActionView = new VendingActionView();
        int manuCounter = MENU_COUNTER_NUMBER;
        while (true) {
            System.out.println(MANU_PRINT_FIRST);
            int selectMenuCount = UI.returnSelectMenuNum(manuCounter, MANU_SELCEK_STRING);
            if (selectMenuCount == 0) { // menu 0.나가기
                System.out.println("잘~가세요!");
                return;
            }
            switch (selectMenuCount) {
                case 1: // menu 1.사람입니다 /
                    new PersonMenuManager(objectManager.getPerson(), objectManager.getMachine()).run();
                    break;
                case 2: // menu 2.관리자입니다 /
                    new ManagerMenuManager(objectManager.getManager(), objectManager.getMachine()).run();
                    break;
            }
        }
    }
//
//    public static void main(String[] args) {
//        MainMenu mainMenu = new MainMenu();
//        mainMenu.run();
//    }
}
