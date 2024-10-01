package fundamentals.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

class ReflectionDemonstration {
    private static String printText() {
        System.out.println("Scratch");
        return "Text";
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        for (Field declaredField : ReflectionDemonstration.class.getDeclaredFields()) {
            String name = declaredField.getName();
            System.out.println("name = " + name);
        }

        for (Method declaredMethod : ReflectionDemonstration.class.getDeclaredMethods()) {
            boolean accessible = declaredMethod.canAccess(null);
            declaredMethod.setAccessible(true);
            if (declaredMethod.getName().equals("printText")) {
                Object invoke = declaredMethod.invoke(null);
                System.out.println("invoke = " + invoke);
            } else {
                for (Parameter parameter : declaredMethod.getParameters()) {
                    System.out.println("parameter.getName() = " + parameter.getName() + ", parameterType: " + parameter.getType());
                }

            }
            declaredMethod.setAccessible(accessible);
        }

    }
}
