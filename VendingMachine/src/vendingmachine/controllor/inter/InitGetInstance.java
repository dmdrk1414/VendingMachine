package vendingmachine.controllor.inter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class InitGetInstance {
    private InitGetInstance() {
    }

    public static Object getInstance(Object object) {
        try {
            Class<?> c = object.getClass();
            Constructor<?> constructor = c.getConstructor(null);
            object = constructor.newInstance(null);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
                | IllegalArgumentException | InvocationTargetException e) {
            System.out.println("인스턴스 가져오기 실패");
        }
        return object;
    }

    public static void main(String[] args) {
        Object test = InitGetInstance.getInstance(new Test());
        Test sdf = (Test) test;
        System.out.println(sdf.getE());
    }
}

class Test {
    int e;

    public Test() {
        super();
        this.e = 3;
    }

    public int getE() {
        return e;
    }
}
