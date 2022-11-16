# 🚀ch08과제를 하겠습니다.



```java
과제 기간: 2022/11/15 ~ 2022/11/23  23:59분으로 되어 있습니다.

과제 지각 : 2022/11/23 24 시 ~ 2022/11/24 23:59 분 입니다.

----------------------------------------------------------------------
Vocaburary Program(영영 단어장 프로그램)

1. 프로그램 설명
   이번 실습 과제의 영영 단어장 프로그램은  영영 단어 목록을 해쉬맵에 저장하고 단어 검색, 삭제, 추가 기능 등을 제공한다.

2. 프로그램 기능
	1) 해쉬맵을 사용하여 영영 단어집 생성하기
	2) 5개 정도 영영 단어 전체를 정렬하여 출력하기
	3) 특정 영영 단어 검색하기
	4) 영영 단어 추가하기
	5) 영영 단어 삭제하기

3. 코딩 분석
   영어 단어집 생성을 위해 영어 단어 문자열 배열로 부터 데이터를 읽고 HashMap 객체로 저장한다.
HashMap 컬렉션 객체를 어떤 구조로 선언해야 하는가? 텍스트 파일을 읽어들여서 HashMap에 어떻
게 저장할 수 있는가? 등 고민하여야 한다.
영어 단어집 전체를 출력한다. 이때 영어 단어를 오름차순으로 정렬하여 출력한다. HaspMap 데이터
를 오름차순으로 정렬하는 방법은?
영어 단어 검색, 신규 단어 추가 및 단어 삭제 기능은 HashMap의 메소드를 적절히 활용하여 구현한
다. containsKey(), get(), put(), remove()

4. 아래 영어단어 목록은 다음과 같다..

 private static final String[] voca = {"amazing,amaze, surprising, wonderful",
    				"chat,chatter, pratter",
    		"minimal,min, very small in quantity, value, or degree",
    		"supermarket,mart, a large shop.",
 		"wellbeing,happyiness, health and happiness"
    };


5. main 메소드
    public static void main(String[] args) {
        try {
            if(note.LoadData(voca)) {
                System.out.println("Vocabulary is loaded. (Total words : " + note.word.size() + ")");
            }
            else {
                System.out.println("Error : Vocabulary isn't loaded.");
                return;
            }
        } catch (IOException e) {
            System.out.println("Error : Can't load vocadata.");
            return;
        }
        note.operate();
        System.out.println("Good bye.");
    }
	
6. 실행결과

Vocabulary is loaded. (Total words : 5)

========= Vocabulary Menu =========
 1. Print Vocabulary
 2. Search a word
 3. Add a new word
 4. Delete a word
 0. Exit
===================================
 ==>> 1
=================== Vocabulary ===================
amazing : amaze, surprising, wonderful
chat : chatter, pratter
minimal : min, very small in quantity, value, or degree
supermarket : mart, a large shop.
wellbeing : happyiness, health and happiness
==================================================

========= Vocabulary Menu =========
 1. Print Vocabulary
 2. Search a word
 3. Add a new word
 4. Delete a word
 0. Exit
===================================
 ==>> 2
Enter a word to search : chat
chat : chatter, pratter

========= Vocabulary Menu =========
 1. Print Vocabulary
 2. Search a word
 3. Add a new word
 4. Delete a word
 0. Exit
===================================
 ==>> 3
Enter a word to append : candy
Meaning : sweet candy
Word is appended successfully.

========= Vocabulary Menu =========
 1. Print Vocabulary
 2. Search a word
 3. Add a new word
 4. Delete a word
 0. Exit
===================================
 ==>> 2
Enter a word to search : candy
candy : sweet candy

========= Vocabulary Menu =========
 1. Print Vocabulary
 2. Search a word
 3. Add a new word
 4. Delete a word
 0. Exit
===================================
 ==>> 4
Enter a word to remove : amazing
The word is removed successfully.

========= Vocabulary Menu =========
 1. Print Vocabulary
 2. Search a word
 3. Add a new word
 4. Delete a word
 0. Exit
===================================
 ==>> 2
Enter a word to search : amazing
Your entered word does not exist.

========= Vocabulary Menu =========
 1. Print Vocabulary
 2. Search a word
 3. Add a new word
 4. Delete a word
 0. Exit
===================================
 ==>> 0
Good bye.
```

