1. 프로젝트명

# 📌 수업시간에 배운 자바 문법으로 자판기 프로그램 만들기😁

수업시간에 교수님께서 오늘 배운 것을 이용해서 집에서 게임을 하듯이

공부를 하라고 하셔서 게임하듯이 놀아야겠습니다.<br><br>

2. 프로젝트 설명

# 📌 프로젝트 설명

- 여러분의 애플리케이션이 무엇을 하는지 <br>
- 왜 그 기술을 사용했는지 <br>
- 여러분이 당면했던 문제나 나중에 추가하고 싶은 기능이 무엇인지. <br><br>

6. 팀원 및 참고 자료

# 📌 참고자료

## 이번부터 README파일을 적는 것을 연습합니다.

README 을 적는 방법은 [README 가이드](https://github.com/RichardLitt/standard-readme/blob/master/spec.md#title)을 참고 하였습니다.

REAME파일 잘 작성하는법 [README 작성법](https://www.freecodecamp.org/korean/news/gisheobeu-peurojegteue-rideumi-paileul-jal-jagseonghaneun-bangbeob/) 연습을 해야겠어용<br>

저에게 많은 생각을 주었던 [오테코 피드백](https://blog.naver.com/dmdrk1414/222886640283)을 보면서 한번 연습해야 겠습니다.<br><br>

## 📌 REAME파일 작성법 블로그의 가이드 내용을 따라해 볼께요

- 동기가 무엇이었나요? <br>
  수업시간에 배문 자바 문법을 좀더 연습하고 싶습니다.
- 왜 이프로젝트를 기획했나요? <br>
  수업시간외 한번 프로그램을 작성해보면 좋겠다 싶어서 작성했습니다.
- 이 프로젝트는 어떤 문제를 해결하나요? <br>
- 이 프로젝트를 통해 무엇을 배우셨나요? <br>
- 이 프로젝트의 특징은 무엇인가요?<br><br>

## 📌 클래스 메서드 추가 설명

**MODEL**

#### VendingMachine 클래스 추가 <br>

지역변수

1.  amountCoin : 자판기가 가지고있는 총 코인 갯수 변수
2.  productManagement 을 이용한 Drink클래스 관리
3.  namePickDrink 을 이용해 골라진 음료수 얻는다.

스태틱

1. static index : 찾은 Drink의 인덱스를 찾기위한 방법. deletePickDrink getPickDrink isPickDrinkEmpty  isNameDrink2VendingMachine 여기 메서드에서 매개변수를 이용한 값을 전달하는 방법을 몰라 static으로 변수 를 만들었다. (차후 수정가능)

메서드

1.  isCoinEmpty : 코인이 있는지 empty인지 확인하는 메서드
2.  addCoin2VendingMachine : 코인을 추가하는 메서드
3.  returnAllAmountCoin : 코인을 반환하는 메서드
4.  registerDrink : 제품등록 메서드
5.  changeOldName2Vending : 새로운 음료수가 아닌 오래된 음료수의 이름을 봐꾼다 (new)을 삭제함.
6.  deletePickDrink : 제품 삭제 메서드
7.  isUpdateDrinkInfo : Drink 데이터 업데이트 메서드
8.  showDrinkList : 제품 확인 프린트 메서드 (추후 삭제할듯...)
9.  pickDrinkType : 선택한 음료수를 this.namePickDrink변수에 저장
10.  getPickDrink : 선택한 음료이름을 이용해 Drink 객체를 얻는다.
11.  isPickDrinkEmpty : 선택한 음료가 비어있으면 true 메서드
12.  isNameDrink2VendingMachine:  선택한 Drink의 isNameDrink의 메서드를 콜을 하여 이름이 비어있는지 확인하는 메서드
13.  isProductManagementValue: 제품 메니저변수에서 값이 있는지 확인하는 메서드, 찾은후 index 반환( 추후 수정할듯. 메니저에서 값이 있는지 확인하는 지? 아직 굳이 필요한지 고민)

#### Drink 클래스 추가

변수

1. nameDrink, priceDrink, stockDrink 변수 추가 : 음료수의 정보
2. tempNameDrink (new)가 안붙은 오래된 이름,  isNameDrink 메서드에서  suppositionName 매개변수와 비교를 한다.
3. isNewDrink 새로운 음료수인지 확인하는 변수

메서드

1. addStockOfDrink, subtractStockOfDrink : 재고 관리 메서드
2. isNameDrink : 추측한 이름과 음료의 이름이 같은지 확인 (getter 이용안하기) 메서드
3. isStockEmpty : 재고가 empty면 return true 메서드
4. showNameDrink : 제품 이름 프린트 메서드
5. updateInfoDrink : 음료 info 업데이트 메서드
6. changeName: 새로운 (new)이름을 붙인다.
7. changeOldName: (new)이름을 떼고 이름을 넣는다
8. isNewDrink: 새로운 drink인지 확인을 해주는 메서드

#### Person 클래스 추가

변수

1. coin: 사람이 가지고 있는 코인

메서드

1. addCoinCnt, subtractCoinCnt: 코인의 갯수를 관리한다.

---

**VIEW**

#### UI 클래스 추가

에러확인 메세지

1. ErrPositiveCall: 양수를 입력해주세요.
2. ErrNotIntegerCall: 
3. ErrNotPickValue: 찾고자하는 것이 없습니다.
4. ErrNotPickStock: 재고가 없네요.
5. ErrNotString: 문자만넣어주세요.
6. ErrNotFormReturn: 올바른 리턴값이 아닙니다.
7. ErrOutOfBoundSize : msg: ::0~" + (menuSize - 1) + " 범위의 값만 넣어주세요.
8. ErrNotStrWord : "msg: " + msg + ":: 단어만 넣어주세요.
9. tryAgainMsg : 다시입력하세요.
10. ErrNotRegisterDrink : msg: " + msg + ":: 제품이름이 겹치는 것같아요 확인해주세요.

메서드

1. deleteCompleMsg : 제거 완료했습니다.
2. returnSelectMenuNum: 선택하는 메뉴의 숫자를 리턴한다.
3. isMenuSizeBoundary: 메뉴가 총메뉴의 바운더리에서 있는가 
4. isPositiveNum: 정수인지 확인하는 메서드
5. isStrCheck: 문자열 체크
6. getInt: 정수를 얻는 메서드
7. getStrLine:  한줄의 문자열 입력을 받는 메서드
8. getStrWord: 단어의 입력을 받는 메서드

#### MainMenu

menu run()을 해주는 메서드

#### VendingActionView

변수

1. user: Person객체의 변수
2. machine : VendingMachine의 변수
3. machineAction: VendingMachineActableImpl의 변수

메서드

1. putInVendingMachineCoin:  menu 1.동전넣기
2. returnCoin2VendingMachine: menu 2.동전반환
3. registerNewDrink: menu 3.제품등록
4. deleteExistDrink2VendingMachine: menu 4.제품삭제
5. updateDrinkInfo2VendingMachine: menu 5.제품업데이트
6. showDrinks2user: menu 6.제품보
7. chooseDrink2VendingMachine: menu 7.제품선택



---

**CONTROLLOR**

#### VendingMachineActable 인터페이스 추가

1. inputCoin: 동전을 넣는다.
2. returnCoin: 잔돈을 반환
3. registerProduct: 제품 등록
4. deleteProduct: 제품 삭제
5. reviseProduct: 제품 수정
6. showProducts: 메뉴 보기
7. pickProduct: 메뉴 선택

#### VendingMachineActableImpl 클래스 추가

1. inputCoin : 코인 추가
2. returnCoin : 동전 반환
3. registerProduct : 제품 등록
4. deleteProduct : 제품 삭제
5. reviseProduct : 제품 업데이트
6. showProducts : 제품 보여주기
7. pickProduct : 제품 선택

## 😍일기😍

### 0929

오늘은 자판기를 프로그래밍을 하였습니다. 메시지를 보내라, 변수명, 함수, 클래스 독립성, 함수 15줄이내 및 한가지 기능만 구현, 참 힘들다는 것을 느겼습니다. 모호한 개념들이 정리되는 기분이라 참 좋내요, run함수를 한번 만들어서 view 함수를 만들어 봐야겠어요.

### 10/02

오늘은 친척분들중 프로그래머 분이 계셨다는걸 알았습니다. 바로 전화를 해서 여줘보니 계발을 좋아한다는 것을 어필하라! 라고 말씀을 하였습니다. 라고 하셨어요 매일 커밋과 계발의 흥미를 보여달라고 하시네요. 참 감사한 조언 잘들었습니다. 

친척집을 갔다와 오늘은 README 파일을 정리를 하였습니다.

## 📌 디렉토리 구조
