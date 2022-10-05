package vendingmachine.model;

import java.util.HashMap;

//    관리자는 많은 음료수를 가지고 있습니다. 등록, 제거, 업데이트, 
//    등록 : 가격과 자신의 재고를 넣는다
//    제거 : 음료수를 제거하면서,  현재 관리자의 재고를 올린다.
//    업데이트 : 이름과 가격을 변경한다
public class Manager {
    // TODO: 지역변수 전부 private로 변경
    // <음료수, 재고>
    public HashMap<String, Integer> DrinkManagement;

    public Manager() {
        this.DrinkManagement = new HashMap<>();
        for (DrinkType drinkType : DrinkType.values()) {
            DrinkManagement.put(drinkType.getNameDrink(), drinkType.getStuckDrink());
        }
    }

//    public static void main(String[] args) {
//        Manager manager = new Manager();
//        for (Entry<String, Integer> entrySet : manager.DrinkManagement.entrySet()) {
//            System.out.println(entrySet.getKey() + " : " + entrySet.getValue());
//        }
//    }
}
