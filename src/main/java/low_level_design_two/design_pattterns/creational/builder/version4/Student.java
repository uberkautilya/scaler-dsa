package low_level_design_two.design_pattterns.creational.builder.version4;

public class Student {
    int age;
    String name;
    int gradYear;
    String batch;

    public Student(Builder builder) {
        this.name = builder.getName();
        //Validations can be performed here before creation of the object
        if (builder.getAge() > 200) {
            throw new RuntimeException();
        }
        this.age = builder.getAge();
        this.batch = builder.getBatch();
        this.gradYear = builder.getGradYear();
    }

    //Helps create the Student object - hence, needs to be static
    public static Builder getBuilder() {
        return new Builder();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGradYear(int gradYear) {
        this.gradYear = gradYear;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", gradYear=" + gradYear +
                ", batch='" + batch + '\'' +
                '}';
    }
}
