package fundamentals.custom_annotation.annotation;

import java.lang.annotation.*;

/**
 * RetentionPolicy CLASS does not retain information at runtime
 * RetentionPolicy SOURCE does not preserve the annotation information beyond the compile stage
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface AnnotatedClass {
    //Fields in the custom annotations are of the below syntax - looks like a method signature
    int count();
}
