import java.util.Scanner;

public class Person implements Cloneable {
	private String name; // 이름
	private int id; // identifier
	private double weight; // 체중
	private boolean married;// 결혼 여부
	private String address; // 주소

	public Person() {
		this.id = 0;
		this.weight = 0;
		this.married = false;

		this.address = "";
		this.name = "";
		System.out.print("Person():");
		this.println();
	}

	public Person(String name) {
		this.id = 0;
		this.weight = 0;
		this.married = false;

		this.setName(name);
		this.address = "";

		System.out.printf("Person(\"%s\"):", String.valueOf(name));
		this.println();
	}

	public Person(String name, int id, double weight, boolean married, String address) {
		super();
		this.id = id;
		this.weight = weight;
		this.married = married;

//		TODO: 1. 이름과 주소 할당하기.
		this.name = name;
		this.address = address;

		System.out.print("Person(...):");
		this.println();
	}

	// 자바는 소멸자가 ? 있다 : 없다 https://madplay.github.io/post/java-finalize 공부

	// get set 함수를 구현하라.
	public String getName() {
		return name;
	}

	public void setName(String name) {
//		System.arraycopy(name, 0, this.name, 0, name.length); // 일부 복사하기.
		this.name = name;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	protected void printMembers() {
		System.out
				.print(this.name + " " + this.id + " " + this.weight + " " + this.married + " :" + this.address + ":");
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

	// 박승찬 is taking a java. 출력하기
	public void whatAreYouDoing() {
		System.out.println(this.name + " is taking a java.");
	}

	// 이름을 비교할것이다 if(this.name.equals(pname) && this.id == pid)
	public boolean isSame(String pname, int pid) {
		if (this.name.equals(pname) && this.id == pid) {
			return true;
		} else {
			return false;
		}
	}

	// TODO: 2. equals 함수 삭제하기
	// 왜 삭제를 하는지 생각을 하라
//	// 이름을 비교할것이다 if(this.name.equals(pname) && this.id == pid)
//	// 그냥 맘대로 구현해봐라 비교를 해서 같으면 참이 나오면된다.
//	private boolean equals(String pname) {
//		for (int index = 0; index < this.name.length; index++) {
//			if (this.name[index] == pname[index]) {
//				continue;
//			} else {
//				return false;
//			}
//		}
//		return true;
//	}

	// 이메서드는 set call을하면 각 멤버변수의 set을 call을 해주어서
	// 각 멤버변수의 값을 할당해주는 메서드이다.
	public void set(String pname, int pid, double pweight, boolean pmarried, String paddress) {
		this.id = pid;
		this.weight = pweight;
		this.married = pmarried;
		this.setName(pname);
		this.setAddress(paddress);
	}

	@Override
	public String toString() {
		return "Person [name=" + this.name + ", id=" + id + ", weight=" + weight + ", married=" + married + ", address="
				+ this.address + "]";
	}

	// clone 함수를 오버라이딩함
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// 리턴할 Person객체의 clone을 생성하고
		Person clone = new Person();

		// Person.set 함수를 사용하여 객체에 할당함.
		clone.set(this.getName(), this.getId(), this.getWeight(), this.isMarried(), this.getAddress());

		// clone변수를 리턴함.
		return clone;
	}

}
