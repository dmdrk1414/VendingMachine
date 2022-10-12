# 🚀명품 자바 P. 235 | Open Challenge 문제입니다.😁

#### class WordGameApp

1. main()
2. run() : 게임을 전체적으로 진행하는 run 메소드, 선수 숫자 만큼의 Player 객체를 배열로 생성한다. 

class Player

1.  게임 참가자의 이름 필드
2.  getWordFromUser() : 사용자로부터 단어를 입력받는
3.  checkSuccess() : 끝말잇기의 성공여부와 게임을 계속하는지를 판별하는 메서드

```java
String word = "아버지";
int lastIndex = word.length() -1;
char lastChar = word.charAt(lastIndexd);
char firstChar = word.charAt(0);
```



####  예제 출력

```
끝말잇기 게임을 시작합니다...
게임에 참가하는 인원은 몇명입니까? 3(입력)
참가자의 이름을 입력하세요>>황기태 (입력)
참가자의 이름을 입력하세요>>이재문 (입력)
참가자의 이름을 입력하세요>>한원선 (입력)
시작하는 단어는 아버지입니다.
황기태>>지우개
이재문>>게다리
한원선>>리본
환기태>>본죽
이재문>>족발
이재문이 졌습니다.
```

# 알게 된점 😂



```
내가 메서드에 Scanner을 close하면 
다시 Scanner를 생성해도 이미 System.in은 닫혔기 때문에 에러를 일으킨다.
```

출처: https://nongue.tistory.com/152 [가자미의 개발이야기:티스토리]

이건 처음안 사실이다. 그래서 메서드에 sc을 매개변수로 보낸다는 사실을 알았다. 

정말 신기하다.
