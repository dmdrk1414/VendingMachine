package vendingmachine.model;

public enum DrinkType {
    사이다("사이다", 100), 콜라("콜라", 100), 환타("환타", 100), 커피("커피", 100), 아이스티("아이스티", 100);

    static int vale = 100;

//  사이다(100), 콜라(100), 환타(100);

    private String nameDrink;
    private int stuckDrink;

    DrinkType(String name, int stock) {
        this.stuckDrink = stock;
        this.nameDrink = name;
    }

    public String getNameDrink() {
        return this.nameDrink;
    }

    public int getStuckDrink() {
        return this.stuckDrink;
    }
}
