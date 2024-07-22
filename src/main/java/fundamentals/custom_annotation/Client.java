package fundamentals.custom_annotation;

import fundamentals.custom_annotation.annotation.AnnotatedClass;
import fundamentals.custom_annotation.annotation.AnnotatedField;
import fundamentals.custom_annotation.annotation.AnnotatedMethod;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        Dog dog = new Dog(101);
        animals.add(dog);

        for (Animal animal : animals) {
            if (animal.getClass().isAnnotationPresent(AnnotatedClass.class)) {
                System.out.println(animal.getClass() + " is annotated with AnnotationClass");
            } else {
                System.out.println(animal.getClass() + " is not annotated with AnnotationClass");
            }
            for (Method method : animal.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(AnnotatedMethod.class)) {
                    AnnotatedMethod annotatedMethod = method.getAnnotation(AnnotatedMethod.class);
                    for (int i = 0; i < annotatedMethod.count(); i++) {
                        if ("SIT".equalsIgnoreCase(method.getName())) {
                            method.invoke(animal, 101);
                        } else {
                            method.invoke(animal);
                        }
                    }
                } else {
                    System.out.println(method.getName() + " is not annotated with AnnotationMethod");
                }
            }
            for (Field declaredField : animal.getClass().getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(AnnotatedField.class)) {
                    AnnotatedField annotation = declaredField.getAnnotation(AnnotatedField.class);
                    System.out.println("Annotation Count: " + annotation.count());
                } else {
                    System.out.println(declaredField.getName() + " is not annotated with AnnotationField");
                }
            }
        }
    }
}
