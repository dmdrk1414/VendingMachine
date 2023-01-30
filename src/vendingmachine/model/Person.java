package vendingmachine.model;

import develoferFuc.UI;

public class Person {
    final static String COIN_NOT_POSITIVE_NUMBER = "동전의 숫자가 음수입니다.";

    private int coin;

    public Person() {
        this.coin = 2000;
    }

    public boolean addCoinCnt(int coin2Add) {
        if (UI.isPositiveNum(coin2Add)) {
            this.coin = this.coin + coin2Add;
            return true;
        } else {
            return false;
        }
    }

    // TODO: coin >= 0을 UI.isPositiveNum으로 변경
    public int getCoinOfPerson() {
        if (coin >= 0) {
            return coin;
        }
        throw new IllegalArgumentException(COIN_NOT_POSITIVE_NUMBER);
    }

    public boolean subtractCoinCnt(int coin2Add) {
        if (UI.isPositiveNum(coin2Add) && this.coin > coin2Add) {
            this.coin = this.coin - coin2Add;
            return true;
        } else {
            return false;
        }
    }
}
