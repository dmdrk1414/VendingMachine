import java.util.Arrays;
import java.util.Scanner;

public class Person {
	private char name[]; // 이름
	// TODO: 왜 ( )변수에 private를 했을까용? 답 :
	private int id; // identifier
	private double weight; // 체중
	private boolean married;// 결혼 여부
	private char address[]; // 주소

	public Person() {
		// TODO: Person(char[] name) 생성자를 완성하라.
		this.id = 0;
		this.weight = 0;
		this.married = false;

		this.address = new char[] {};
		this.name = new char[] {};
		System.out.print("Person():");
		this.println();
	}

	public Person(char[] name) {
		// TODO: Person(char[] name) 생성자를 완성하라.
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
		// TODO: 멤버변수를 초기화 하라.
		this.id = id;
		this.weight = weight;
		this.married = married;

		// TODO: 여기서 name과 address함수를 set함수로 구현하라.
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
		// TODO: setName 함수를 완성하라.
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
		// TODO: setAddress를 구현하라
//		System.arraycopy(address, 0, this.address, 0, address.length); // 일부 복사하기.
//		this.address = address.clone();
		this.address = Arrays.copyOf(address, address.length);
	}

	protected void printMembers() {
		// TODO: printMembers함수는 멤버변수를 출력하는 것이다. 이쁘게 구현하라.
		System.out.print(String.valueOf(name) + " " + this.id + " " + this.weight + " " + this.married + " :"
				+ String.valueOf(this.address) + ":");
	}

	void input(Scanner sc) {

	}

	// printMembers 불르는 함수.
	void print() {
		printMembers();
	}

	void println() {
		print();
		System.out.println("");
	}

	// TODO: printMembers와 비교하기
	@Override
	public String toString() {
		return "Person [name=" + Arrays.toString(name) + ", id=" + id + ", weight=" + weight + ", married=" + married
				+ ", address=" + Arrays.toString(address) + "]";
	}
}
