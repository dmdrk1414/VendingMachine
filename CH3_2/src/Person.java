import java.util.Arrays;
import java.util.Scanner;

public class Person {
	private char name[]; // 이름
	private int id; // identifier
	private double weight; // 체중
	private boolean married;// 결혼 여부
	private char address[]; // 주소

	public Person() {
		this.id = 0;
		this.weight = 0;
		this.married = false;

		this.address = new char[] {};
		this.name = new char[] {};
		System.out.print("Person():");
		this.println();
	}

	public Person(char[] name) {
		this.id = 0;
		this.weight = 0;
		this.married = false;

		this.setName(name);
		this.address = new char[] {};

		System.out.printf("Person(\"%s\"):", String.valueOf(name));
		this.println();
	}

	public Person(char[] name, int id, double weight, boolean married, char[] address) {
		super();
		this.id = id;
		this.weight = weight;
		this.married = married;

		// 왜 set함수로 구현해야되는가 설명하라.
		this.setName(name);
		this.setAddress(address);

		System.out.print("Person(...):");
		this.println();
	}

	// 자바는 소멸자가 ? 있다 : 없다 https://madplay.github.io/post/java-finalize 공부

	// get set 함수를 구현하라.
	public char[] getName() {
		return name;
	}

	public void setName(char[] name) {
//		System.arraycopy(name, 0, this.name, 0, name.length); // 일부 복사하기.
		this.name = name.clone();

		// https://www.delftstack.com/ko/howto/java/copy-array-java/#java%25EC%2597%2590%25EC%2584%259Carrays.copyof%25EB%25A5%25BC-%25EC%2582%25AC%25EC%259A%25A9%25ED%2595%2598%25EC%2597%25AC-%25EB%258B%25A4%25EB%25A5%25B8-%25EB%25B0%25B0%25EC%2597%25B4%25EC%2597%2590-%25EB%25B3%25B5%25EC%2582%25AC
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	public char[] getAddress() {
		return address;
	}

	public void setAddress(char[] address) {
//		System.arraycopy(address, 0, this.address, 0, address.length); // 일부 복사하기.
//		this.address = address.clone();
		this.address = Arrays.copyOf(address, address.length);
	}

	protected void printMembers() {
		System.out.print(String.valueOf(name) + " " + this.id + " " + this.weight + " " + this.married + " :"
				+ String.valueOf(this.address) + ":");
	}

	void input(Scanner sc) {

	}

	// printMembers 불르는 함수.
	public void print() {
		printMembers();
	}

	public void println() {
		print();
		System.out.println("");
	}

	// TODO: 1. whatAreYouDoing 함수 넣기
	// 박승찬 is taking a java. 출력하기
	public void whatAreYouDoing() {
		System.out.println(String.valueOf(this.name) + " is taking a java.");
	}

	// TODO: 2. isSame 함수 구현
	// 이름을 비교할것이다 if(this.name.equals(pname) && this.id == pid)
	public boolean isSame(char[] pname, int pid) {
		if (this.name.equals(pname) && this.id == pid) {
			return true;
		} else {
			return false;
		}
	}

	// TODO: 3. equals 함수 구현
	// 이름을 비교할것이다 if(this.name.equals(pname) && this.id == pid)
	// 그냥 맘대로 구현해봐라 비교를 해서 같으면 참이 나오면된다.
	private boolean equals(char[] pname) {
		for (int index = 0; index < this.name.length; index++) {
			if (this.name[index] == pname[index]) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	// TODO: 4. set 함수를 구현
	// 이메서드는 set call을하면 각 멤버변수의 set을 call을 해주어서
	// 각 멤버변수의 값을 할당해주는 메서드이다.
	public void set(char[] pname, int pid, double pweight, boolean pmarried, char[] paddress) {
		this.id = pid;
		this.weight = pweight;
		this.married = pmarried;
		this.setName(pname);
		this.setAddress(paddress);
	}

	@Override
	public String toString() {
		return "Person [name=" + Arrays.toString(name) + ", id=" + id + ", weight=" + weight + ", married=" + married
				+ ", address=" + Arrays.toString(address) + "]";
	}

}
