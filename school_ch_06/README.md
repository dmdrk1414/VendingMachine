# 🚀ch06과제를 하겠습니다.



```java
과제 수행기간은  다음과 같습니다.(11/07 개시~)


 과제 기간: 2022/11/07 ~ 2022/11/15  23:59분으로 되어 있습니다.

과제 지각 : 2022/11/15 24 시 ~ 2022/11/16 23:59 분 입니다. 지각 제출 허용하나 점수에서 50% 감점하고 부여됩니다. 

오타가 많네요. 죄송합니다. 고생시켜 미안합니다.
출력 결과에 오류가 있었습니다. 
-------------------------------------------------------------------------------------------------------

수정 내역입니다. 

 1) 각 출력 결과 수정: "Input Msg: " 다음 행에 입력된 문자열을 다시 출력해 줌

 2)  세번째 출력 결과 수정
      getSpeChrCount(): 특수기호의 정의 추가

3) 세번째 입력 데이타 수정
 (여러 개의 탭과 스페이스가 함께 들어가 있는 경우도 정상 처리되어야 함)
     주의: 마지막 출력결과가 "There is"가 아니고  "Thers is"이다. 
  (사실 잘못된 것인데  그래도 이렇게 출력되도록 하셔요.)
4) input 차례대로 4번 하시면 됩니다.

Hello World! Welcome to Gwangju :) / world

Java Programming (2021-2) Test problem! / C++ 

The quick brown 1 fox jumps over the 5 lazy dogs ^^ / s

exit

-------------------------------------------------------------------------------------------------------
=======================================================
[자바프로그래밍 6장 실습문제]

- 본 프로그램은 사용자로부터 텍스트와 키워드를 입력받아, 아래에서 요구하는 정보를 출력하기 위한 과정을 수행한다.

[출력 정보]
- 입력받은 텍스트에 대한 대문자 형태의 텍스트
- 입력받은 텍스트의 전체 길이
- 입력받은 텍스트의 단어 수, 문자 수, 숫자 수, 특수기호 수
- 입력받은 텍스트에 찾고자 하는 키워드의 존재 여부

[요구조건]
- 입력 텍스트(Text)와 키워드(Keyword)는 "/"로 구분하여 입력 (입력형태 -> Text / Keyword)
- 텍스트와 키워드를 구분하기 위해 사용하는 "/"은 특수기호로 처리하지 않음
- 입력받은 텍스트와 키워드는 양쪽에 불필요한 공백을 제거하여 처리
- TextProcess 객체를 print하였을 때, 출력예시와 같은 형태로 출력
- 문자의 경우 대소문자 구분하지 않음
- 입력받은 텍스트에 대한 처리결과를 출력한 뒤, 다음 텍스트 결과 출력시 1줄의 공백 필요

[출력예시]
Input Msg: Hello World! Welcome to Gwangju :) / world
Hello World! Welcome to Gwangju :) / world
Text: HELLO WORLD! WELCOME TO GWANGJU :)
Text Length: 34
Word Count: 6
Alphabet Count: 26
Number Count: 0
Special Character Count: 3
Thers is the keyword in the input text.

Input Msg: Java Programming (2021-2) Test problem! / C++ 
Text: JAVA PROGRAMMING (2021-2) TEST PROBLEM!
Text Length: 39
Word Count: 5
Alphabet Count: 26
Number Count: 5
Special Character Count: 4
Thers is no keyword in the input text.

Input Msg: The quick brown 1 fox jumps over the 5 lazy dogs ^^ / s
Text: THE QUICK BROWN 1 FOX JUMPS OVER THE 5 LAZY DOGS ^^
Text Length: 51
Word Count: 12
Alphabet Count: 36
Number Count: 2
Special Character Count: 2
Thers is the keyword in the input text.

Input Msg: exit
Good bye!

[프로그램 구성]
=======================================================================
import java.util.*;

class TextProcess {	

	public TextProcess(String input) { }  // 객체 생성 시, 입력받은 텍스트를 기반으로 생성자 함수 수행

	public int getTextLength(String input) { }  // 입력받은 텍스트의 전체 길이를 정수로 반환
	
	public int getWordCount(String input) { }  // 입력받은 텍스트의 단어 수를 정수로 반환
	
	public int getAlphabetCount(String input) { }  // 입력받은 텍스트의 문자(A~Z) 수를 정수로 반환
	
	public int getNumCount(String input) { }  // 입력받은 텍스트의 숫자(0~9) 수를 정수로 반환

	public int getSpeChrCount(String input) { }  // 입력받은 텍스트의 특수기호 수를 정수로 반환
// 위 문자, 숫자, 스페이스 글자를 제외한 모든 글자('\t','\n' 등 포함)는 특수기호로 취급한다.



	public boolean checkText() { } //입력받은 텍스트에서 찾고자 하는 키워드가 있는지 여부를 반환
	
	public String toString() { } // TextProcess 객체를 출력(println)하였을 때, 문제에서 요구하는 양식대로 출력하도록 toString() 함수를 overriding
	
}

public class Main {  // 메인 클래스
		
	public static void main(String[] args){  // 메인 함수
		Scanner s = new Scanner(System.in);  // 텍스트를 입력받기 위한 Scanner 객체 생성
		
		while(true) {  // 텍스트를 연속으로 입력받기 위한 while loop
			// 문제에서 요구하는 형태로 입력 문구 및 입력받은 텍스트 출력
			// 입력받은 텍스트의 불필요한 양쪽 공백 제거
			// exit가 입력되었을 때, 무한 루프 종료
			// TextProcess 객체 생성

			System.out.println(str); // TextProcess 객체 정보 출력
		}
		// Scanner 객체 종료
		// 종료메세지 출력
	}
}

=======================================================================
```

