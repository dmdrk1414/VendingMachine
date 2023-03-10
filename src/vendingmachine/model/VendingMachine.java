package vendingmachine.model;

import develoferFuc.UI;

import java.util.ArrayList;

public class VendingMachine {
    private static int index;

    final private String PRINT_MENU = "음료수 리스트: ";
    final static String AMOUNTCOIN_NOT_POSITIVE_NUMBER = "자판기에 있는 액수가 음수입니다.";

    private int amountCoin;
    private ArrayList<Drink> productManagement;
    private String namePickDrink;

    public VendingMachine() {
        this.productManagement = new ArrayList<>();
        this.productManagement.add(new Drink("사이다", 300, 10));
        this.productManagement.add(new Drink("콜라", 500, 10));
        this.productManagement.add(new Drink("환타", 400, 10));

        this.amountCoin = 0;
        this.namePickDrink = "";
    }

    public int getAmountCoinOfMachine() {
        if (UI.isPositiveNum(amountCoin)) {
            return amountCoin;
        }
        throw new IllegalArgumentException(AMOUNTCOIN_NOT_POSITIVE_NUMBER);
    }

    public boolean isCoinEmpty() {
        if (this.amountCoin == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addCoin2VendingMachine(int coinInsert) {
        if (UI.isPositiveNum(coinInsert)) {
            this.amountCoin = this.amountCoin + coinInsert;
        }
    }

    public int returnAllAmountCoin() {
        if (this.amountCoin != 0) {
            int getAmountCoin = this.amountCoin;
            this.amountCoin = 0;
            return getAmountCoin;
        } else {
            return 0;
        }
    }

    public void registerDrink(String nameDrink, int priceDrink, int stockDrink) {
        if (UI.isStrCheck(nameDrink) && UI.isPositiveNum(priceDrink) && UI.isPositiveNum(stockDrink)) {
            if (!this.isNameDrink2VendingMachine(nameDrink)) {
                this.changeOldName2Vending(this.productManagement);
                Drink drink = new Drink(nameDrink, priceDrink, stockDrink);
                this.productManagement.add(drink);
                if (drink.isNewDrink()) {
                    drink.changeName(nameDrink);
                }
            } else {
                UI.ErrNotRegisterDrink(nameDrink);
            }
        }
    }

    public void changeOldName2Vending(ArrayList<Drink> productManagement) {
        for (Drink drink : productManagement) {
            drink.changeOldName();
        }
    }

    public boolean deletePickDrink(String nameDrink2Delete) {
        if (isProductManagementValue(nameDrink2Delete)) {
            int deleteIndex = VendingMachine.index;
            this.productManagement.remove(deleteIndex);
            UI.deleteCompleMsg(nameDrink2Delete);
            return true;
        } else {
            UI.ErrNotPickValue("");
            return false;
        }
    }

    public void isUpdateDrinkInfo(String pickNameDrink, String nameChange, int priceChange) {
        try {
            if (this.isNameDrink2VendingMachine(pickNameDrink) && UI.isPositiveNum(priceChange)) {
                Drink drink = getPickDrink(pickNameDrink);
                drink.updateInfoDrink(nameChange, priceChange);
            } else {
                UI.ErrNotPickValue(pickNameDrink);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    public void showDrinkList() {
        System.out.print(PRINT_MENU);
        for (Drink drink : this.productManagement) {
            drink.showNameDrink();
        }
        System.out.println();
    }

    public void pickDrinkType(String pickNameDrink) {
        if (!isNameDrink2VendingMachine(pickNameDrink)) {
            UI.ErrNotPickValue(pickNameDrink);
            return;
        }
        if (!isPickDrinkEmpty(pickNameDrink)) {
            this.namePickDrink = pickNameDrink;
        }
    }

    private Drink getPickDrink(String pickNameDrink) throws NullPointerException {
        if (isProductManagementValue(pickNameDrink)) {
            int pickDrinkIndex = VendingMachine.index;
            Drink drink = this.productManagement.get(pickDrinkIndex);
            return drink;
        }
        return null;
    }

    private boolean isPickDrinkEmpty(String pickNameDrink) {
        if (isProductManagementValue(pickNameDrink)) {
            int pickDrinkIndex = VendingMachine.index;
            Drink pickDrink = this.productManagement.get(pickDrinkIndex);
            return pickDrink.isStockEmpty();
        } else {
            UI.ErrNotPickStock(pickNameDrink);
            return false;
        }
    }

    // 이름인가 ? true
    private boolean isNameDrink2VendingMachine(String pickNameDrink) {
        if (isProductManagementValue(pickNameDrink)) {
            int pickDrinkIndex = VendingMachine.index;
            Drink pickDrink = this.productManagement.get(pickDrinkIndex);
            return pickDrink.isNameDrink(pickNameDrink);
        } else {

            return false;
        }
    }

    // 제품인가?
    private boolean isProductManagementValue(String nameDrink2search) {
        int endPos = (int) this.productManagement.size();
        for (int i = 0; i < endPos; i = i + 1) {
            Drink drink = this.productManagement.get(i);

            if (drink.isNameDrink(nameDrink2search)) {
                VendingMachine.index = i;
                return true;
            }
        }
        return false;
    }
}
