# 🚀 수업시간에 배운 자바 문법으로 자판기 프로그램 만들기😁

> *수업시간에 교수님께서 오늘 배운 것을 이용해서 집에서 게임을 하듯이*
>
> *공부를 하라고 하셔서 게임하듯이 놀아야겠습니다.<br>*<br>

자바를 이용해서 간단한 자판기를 만들 생각입니다. <br>

배운 문법을 사용하여 원하는 기능을 추가하여 여러대의 자판기를 만든는 것이 목표입니다.

```
저는 MVC패턴을 공부하기 위하여 프로젝트를 시작하였지만
하다보니 MVCC 패턴이네요. Controllor 가 2개인이유는 이름을 수정하다 보니 되었습니다😂 차후 수정할것 같습니다.
            Model
   view             
                Controllor(ActableImpl)    
                Controllor(Controllor)
```



💡 나중에 스프링을 이용해서 웹사이트의 자판기를 만들어 볼까 생각중입니다.

💡 할인개념, 날짜개념, 동전먹는 기능😂, 로또 (난이도 조절) 한번에 원뿔원 😍

💡 두개의 제품을 한번에 등록하는 방법. -> 제품 등록시 갯수를 고른후 확인하는 기능



# 📚 프로젝트 설명

- 여러분의 애플리케이션이 무엇을 하는지 :  자판기를 출력합니다. <br>
- 왜 그 기술을 사용했는지 : 자바를 사용합니다. 학교에서 배우는 언어가 자바이고, 재미있고, 잘하고 싶은 언어도 자바라 시작하엿습니다. <br>
- 여러분이 당면했던 문제나 나중에 추가하고 싶은 기능이 무엇인지.  <br><br>

---

:ambulance: [Fix]  유저가 제품을 선택을 하였을때 제품보기에 없는 물건을 골랐을때 제고가 없다는 오류 수정

이제 자판기에 없는 제품을 선택하였을때  제고가 없는 오류때문에 당황하셨죠🤣

이제 수정하였습니다.

```
현재 손님의 돈:2000
현재 자판기에 남아있는 돈:0
메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |
3
선택할 음료수 이름: ㄴㅇㄹ
msg: ㄴㅇㄹ:: 찾고자 하는 것이 없습니다.
```

유지보수도 참재미있는 과정입니다.ㅎㅎ 😎

---

:sparkles: 2023-01-31 이제 유저 View 로 넘어갈때 음료수 리스트가 우선 출력됩니다.

지금까지 사람입니다를 선택하였을때 제품을 바로바로 보여주는 것이 없어서 불편하셨지용😢

이제 사람 페이지로 넘어갔을때 음료수 리스트를 우선 출력합니다. 

```
--------사람입니까 관리자입니까?-------------
메인메뉴| 0.Exit 1.사람입니다. 2.관리자입니다. |
1
--------------------사람 입니까?--------------------
음료수 리스트: 사이다 콜라 환타 

현재 손님의 돈:2000
현재 자판기에 남아있는 돈:0
메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |
```

---

:ambulance: 2023-01-31  동전 넣는 액수 범위 예외처리

```
현재 손님의 돈:2000
현재 자판기에 남아있는 돈:0
메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |
1
투입할 돈: 3000
```

이전에는 위의 결과처럼 투입하는 돈이  유저가 가지고있는 돈보다 클경우 아무런 피드백이 없었습니다.😢

하지만

```
현재 손님의 돈:2000
현재 자판기에 남아있는 돈:0
메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |
1
투입할 돈: 3333
입력한 돈의 액수가 가지고있는 액수보다 커요!!
```

😎지금은 손님들이 하는 실수를 확인하는 방법이 생겼답니다...ㅎㅎ

---

:sparkles: 2023-01-30 현재 자판기가 가지고있는 돈의 액수를 표시해보겠습니다

이제 자판기의 총코인의 액수를 볼수있습니다.😊😊

변경이전

```
--------------------사람 입니까?--------------------
현재 손님의 돈:1500
메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |
```

변경이후

```
--------------------사람 입니까?--------------------
현재 손님의 돈:2000
현재 자판기에 남아있는 돈:0
메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |
1
투입할 돈: 500
500원 자판기에 투입!!

--------------------사람 입니까?--------------------
현재 손님의 돈:1500
현재 자판기에 남아있는 돈:500
메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |
```



---

###### :sparkles: 2023-01-30 사람을 선택을 하였을때 사람이 가지고있는 돈을 표시할 것입니다

여기는 오랜만에 이 프로젝트를 손대네요😂 토익이랑 학과 공부는 참 재미있습니다😊😊

사람을 선택을 하면 가지고 있는 돈의 액수를 표시하도록 해보겠습니다.

변경이전

```
--------------------사람 입니까?--------------------
메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |
1
투입할 돈: 500
500원 자판기에 투입!!
```

변경이후

```
--------------------사람 입니까?--------------------
현재 손님의 돈:2000
메인메뉴| 0.Exit 1.동전넣기 2.동전반환 3.제품선택 4.제품보기 |
1
투입할 돈: 5000
```



---

###### ✨ 2022-10-02 새로운 음료는 (new)의 이름이 붙습니다.

제친구의 의견을 수렴하여 새로운 음료는 (new)라는 키워드가 붙습니다. 

기능을 붙이는 건 참 힘든 것같습니다.😂

---

###### ✨ 2022-10-04 branch 기능 사용 test branch 생성 및 커밋

branch 라는 친구를 적응하는것이 참 힘들더라고요😂 

 4시간은 테스트를 하기위해 사용을 하였더니 머리가 아프네요😅

---

###### ✨ 2022-10-04 대규모 업데이트😏 드디어 관리자와 사람을 분리를 하여 입력 및 출력을 확인할수있습니다👏

관리자가 음료수의 등록과 삭제 업데이트를 관리 하도록 만들고 싶습니다. 

enum으로 물건(음료수의 관리)을 하고있지만 나중에 수정을 해야될꺼 같습니다. 음료수는 상수가 아니잔아요?🤣

~~enum에 대해서 교수님께 여줘봤더니 저의 생각이 적절한가에 대한 생각을 많이 해서 머리가 아프네요~~

- 관리자

1. 등록 : 가격과 자신의 재고를 넣는다
2. 제거 : 음료수를 제거하면서,  현재 관리자의 재고를 올린다.
3. 업데이트 : 이름과 가격을 변경한다. 

- 사람

1. 돈을 투입한다.
2. 돈을 반환한다.
3. 제품을 선택한다.
4.  제품을 본다.

객체의 독립성을 유지 하니 업데이트가 너무 편하네요... 수정을 할께 별로 없고 참좋은데요?

---

# 📚 참고자료

### 이번부터 README파일을 적는 것을 연습합니다.

README 을 적는 방법은 [README 가이드](https://github.com/RichardLitt/standard-readme/blob/master/spec.md#title)을 참고 하였습니다.

README파일 잘 작성하는법 [README 작성법](https://www.freecodecamp.org/korean/news/gisheobeu-peurojegteue-rideumi-paileul-jal-jagseonghaneun-bangbeob/) 연습을 해야겠어용<br>

저에게 많은 생각을 주었던 [오테코 피드백](https://blog.naver.com/dmdrk1414/222886640283)을 보면서 한번 연습해야 겠습니다.<br>

README파일 [리드미 파일 규칙](https://velog.io/@shin6403/Git-git-%EC%BB%A4%EB%B0%8B-%EC%BB%A8%EB%B2%A4%EC%85%98-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0) 을 참고하였습니다.

<br>

## 📚 REAME파일 작성법 블로그의 가이드 내용을 따라해 볼께요

- 동기가 무엇이었나요? <br>
  수업시간에 배문 자바 문법을 좀더 연습하고 싶습니다.
- 왜 이프로젝트를 기획했나요? <br>
  수업시간외 한번 프로그램을 작성해보면 좋겠다 싶어서 작성했습니다.😙
- 이 프로젝트는 어떤 문제를 해결하나요? <br>
- 이 프로젝트를 통해 무엇을 배우셨나요?  : 현제 진행형이지만 프로젝트가 참 맛있습니다.😋<br>
- 이 프로젝트의 특징은 무엇인가요? : 자바로 자판기를 만들면서 업데이트를 하며 계발의 참맛을 느낄수있습니다.<br><br>

## 📚 클래스 메서드 추가 설명

### **🎈MODEL**

#### VendingMachine 클래스 <br>

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

#### Drink 클래스

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

#### Person 클래스

변수

1. coin: 사람이 가지고 있는 코인

메서드

1. addCoinCnt, subtractCoinCnt: 코인의 갯수를 관리한다.

#### 💎Manager 클래스 추가

변수

1. DrinkManagement : Enum의 데이터를 가져와서 map처리함



---

### **🎈VIEW**

💎 MainMenu

💎 ManagerMenuManager

💎 PersonMenuManager

---

### **🎈CONTROLLOR**

#### 💎ObjectManager 클래스

#### 🚜ManagerActableImpl클래스 

#### 🚜ManagerControllor클래스

#### 💎PersonActableImpl클래스

#### 💎PersonControllor클래스

---

### **🎈develoferFunc** : 계발자가 사용을하는 함수을 모았다.

#### 🚜 UI 클래스 

**에러확인 메세지**

1. ErrPositiveCall: [출력] 양수를 입력해주세요.
2. ErrNotIntegerCall: [출력] 정수를 입력해주세요.
3. ErrNotPickValue: [출력] 찾고자하는 것이 없습니다.
4. ErrNotPickStock: [출력] 재고가 없네요.
5. ErrNotString: [출력] 문자만넣어주세요.
6. ErrNotFormReturn: [출력] 올바른 리턴값이 아닙니다.
7. ErrOutOfBoundSize : [출력] 범위의 값만 넣어주세요.
8. ErrNotStrWord : [출력] 단어만 넣어주세요.
9. tryAgainMsg : [출력] 다시입력하세요.
10. ErrNotRegisterDrink : [출력] 제품이름이 겹치는 것같아요 확인해주세요.
11. deleteCompleMsg : [출력] 제거 완료했습니다.

**메서드**

1. returnSelectMenuNum: 선택하는 메뉴의 숫자를 리턴한다.
2. isMenuSizeBoundary: 메뉴가 총메뉴의 바운더리에서 있는가 
3. isPositiveNum: 정수인지 아닌지 확인할 수있다.
4. isStrCheck: 문자열 체크를 해준다.
5. getInt: 정수를 얻는 다 (검증 가능)
6. getStrLine:  한줄의 문자열 입력을 받는 (검증 완료)
7. getStrWord: 단어의 입력을 받는 메서드 (검증환요)

---

### **🎈Main**

#### 🚜Main 클래스

1. MainMenu클래스의  run()을 해주는 메서드

---

### **:fire:notuseclass** : 사용하지 않은 클래스 모음(삭제를 하는데 아까워서 모아났습니다.)

사람과 관리자를 클래스 분할을  하여 사용이 필요없다는 판단을 하여 삭제를 하였습니다. ~~하지만 차후 쓸수있어서 저장을 하였습니다😁~~

#### :fire:VendingActionView 클래스

**변수**

1. user: Person 레퍼런스 변수
2. machine : VendingMachine 레퍼런스 변수
3. machineAction: VendingMachineActableImpl 레퍼런스 변수

**메서드**

1. putInVendingMachineCoin:  menu 1. 동전넣기
2. returnCoin2VendingMachine: menu 2. 동전반환
3. registerNewDrink: menu 3.제품등록
4. deleteExistDrink2VendingMachine: menu 4. 제품삭제
5. updateDrinkInfo2VendingMachine: menu 5. 제품업데이트
6. showDrinks2user: menu 6. 제품보기
7. chooseDrink2VendingMachine: menu 7. 제품선택

#### :fire:VendingMachineActable 인터페이스

1. inputCoin: 동전을 넣는다.
2. returnCoin: 잔돈을 반환
3. registerProduct: 제품 등록
4. deleteProduct: 제품 삭제
5. reviseProduct: 제품 수정
6. showProducts: 메뉴 보기
7. pickProduct: 메뉴 선택

#### :fire:VendingMachineActableImpl 클래스 

1. inputCoin : 코인 추가
2. returnCoin : 동전 반환
3. registerProduct : 제품 등록
4. deleteProduct : 제품 삭제
5. reviseProduct : 제품 업데이트
6. showProducts : 제품 보여주기
7. pickProduct : 제품 선택

---



## 😍일기😍

### 09/29

오늘은 자판기를 프로그래밍을 하였습니다. 메시지를 보내라, 변수명, 함수, 클래스 독립성, 함수 15줄이내 및 한가지 기능만 구현, 참 힘들다는 것을 느겼습니다. 모호한 개념들이 정리되는 기분이라 참 좋내요, run함수를 한번 만들어서 view 함수를 만들어 봐야겠어요.

### 10/02

오늘은 친척분들중 프로그래머 분이 계셨다는걸 알았습니다. 바로 전화를 해서 여줘보니 계발을 좋아한다는 것을 어필하라! 라고 말씀을 하였습니다. 라고 하셨어요 매일 커밋과 계발의 흥미를 보여달라고 하시네요. 참 감사한 조언 잘들었습니다. 

친척집을 갔다와 오늘은 README 파일을 정리를 하였습니다.

###  10/05

오늘 저의 코드를 보며 동아리원들과 저의 느낌점을 토론을 하였습니다.

1. 탭인 2번은 기능이 두개이니 분리해라
2. 생각보다 객체의 독립성과 함수의 독립성은 유지보수에 유리하다
3. 모델 클래스를 순정을 유지하라 다만 get/set을 사용하지 않을려면 더러워져도 괜찮다.(유지보수성)

좋은 토론을 토대로 좋은 코드를 만들어야겠다는 생각을 하였습니다.
