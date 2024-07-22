package fundamentals.custom_annotation;

import fundamentals.custom_annotation.annotation.AnnotatedField;
import fundamentals.custom_annotation.annotation.AnnotatedMethod;
import fundamentals.custom_annotation.annotation.validator.ValidMedalCount;

public class Dog extends Animal {
    @AnnotatedField(count = 5)
    //Perhaps this validator works only with spring validation framework
    @ValidMedalCount(message = "Maximum allowed medal count is 100")
    int medalCount;

    public Dog(int medalCount) {
        this.medalCount = medalCount;
    }

    public void bark() {
        System.out.println("Medal Count: " + medalCount + ", Bark.!");
    }

    @AnnotatedMethod(count = 2)
    public void sit(Integer medalCount) {
        System.out.println("Medal Count: " + medalCount + ", Sit.!");
    }
}
