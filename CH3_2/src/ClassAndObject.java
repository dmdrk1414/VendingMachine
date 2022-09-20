import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassAndObject {
	char[] name_ps1 = "ps1".toCharArray();
	char[] name_ps2 = "ps2".toCharArray();
	char[] name_ps3 = "ps3".toCharArray();
	char[] ps3_address = "ps3 address".toCharArray();

	void defualConstructor() { // Menu item 1
		Person ps = new Person();
	}

	void constructor() {// Menu item 2
		Person ps1 = new Person();
		Person ps2 = new Person(name_ps2);
		Person ps3 = new Person(name_ps3, 3, 70.3, true, ps3_address);
	}

	void make_instance() {// Menu item 3
		// TODO: 여기서 당신의 정보가 있는 Person() 객체를 생성하기
//		Person(char[] name, int id, double weight, boolean married, char[] address)
		Person person = new Person("박승찬".toCharArray(), 20161822, 90, false, "지산동".toCharArray());

		// TODO: set함수를 이용해서 너의 정보를 객체에 할당하기
		person.setName("박승찬".toCharArray());
		person.setId(20161822);
		person.setWeight(90);
		person.setMarried(false);
		person.setAddress("지산동".toCharArray());

		// TODO: 너의 정보를 출력해봐
		System.out.println(
				"name:" + String.valueOf(person.getName()) + " id:" + person.getId() + " weight:" + person.getWeight()
						+ " married:" + person.isMarried() + " address:" + String.valueOf(person.getAddress()));
	}

	// 사용자가 선택한 메뉴 항목을 실행하는 멤버 함수 (func_arr[menuItem]에 등록된 함수)를 호출
	// ClassAndObject의 멤버 함수 포인터(함수 이름)들의 배열
	// 나중에 호출하기 위해 멤버 함수의 이름을 미리 배열에 저장(등록):
	// 즉, 함수의 첫번째 명령어의 주소를 저장함
	// 등록된 이 멤버 함수들은 나중에 run()에서 호출됨
	// (즉, 함수 주소로 jump 해 가서 함수를 실행함)
	public void run() {
		String[] methodNameArr = new String[] { "first", "defualConstructor", "constructor", "make_instance" };
		Method[] func_arr = new Method[methodNameArr.length];
		Class<ClassAndObject> CAOclass = ClassAndObject.class; // ClassAndObject 클래스 가져오기

		int menuCount = 0;

		for (int index = 0; index < methodNameArr.length; index++) {
			String methodName = methodNameArr[index]; // 메서드의 함수의 이름을 가져와서
			func_arr[index] = this.getMethod(methodName, CAOclass); // getMethod함수를 methodArr에 넣어라
		}
		menuCount = func_arr.length;

		// 화면에 보여 줄 메뉴
		String menuStr = "+++++++++++ Person Class And Object Menu ++++++++++++\n+ 0.Exit 1.DefualConstructor 2.Constructor          +\n+ 3.Make_instance                                   +\n+++++++++++++++++++++++++++++++++++++++++++++++++++++\n";
//		ClassAndObject target = (ClassAndObject) this.getInstance(new ClassAndObject());                                               make_instance
		ClassAndObject target = new ClassAndObject();
		
		UI ui = new UI();
		while (true) {
			int menuItem = ui.selectMenu(menuStr, menuCount);
			if (menuItem == 0) {
				return;
			}
			try {
				func_arr[menuItem].invoke(target);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
				System.out.println("ClassAndObject func_arr[menuItem].invoke(target)의 함수가 잘못됨");
			}
		}
	}

	private <T> Method getMethod(String name, Class<T> tClass) {
		// null을 다룰때는 Optional을 사용하라하여 사용하는데...Method는 아닌듯?합니다.
//		Optional<Method> optVal = Optional.<Method>empty();
//		Method method = optVal.orElseThrow(NullPointerException::new);
		Method method = null;

		try {
			method = tClass.getDeclaredMethod(name, null);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}

		return method;

	}

	// 인스턴스를 가져오는 함수
	private Object getInstance(Object object) {
		object = new Object();

		return object;
	}

	public void first() {
		System.out.println("여기는 비어있는 함수!!");
	}
}
