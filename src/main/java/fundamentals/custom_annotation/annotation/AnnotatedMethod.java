package fundamentals.custom_annotation.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented //So the generated documentation will have this custom annotation information
public @interface AnnotatedMethod {
    int count();
}
