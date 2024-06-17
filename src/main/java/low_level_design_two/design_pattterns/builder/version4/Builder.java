package low_level_design_two.design_pattterns.builder.version4;

public class Builder {
    int age;
    String name;
    int gradYear;
    String batch;

    //Constructor functionality is now taken up by the builder
    Student build() {
        return new Student(this);
    }

    public int getAge() {
        return age;
    }

    //Helps chain setters on the builder object itself
    public Builder setAge(int age) {
        this.age = age;
        return this;
    }

    public String getName() {
        return name;
    }

    public Builder setName(String name) {
        this.name = name;
        return this;
    }

    public int getGradYear() {
        return gradYear;
    }

    public Builder setGradYear(int gradYear) {
        this.gradYear = gradYear;
        return this;
    }

    public String getBatch() {
        return batch;
    }

    public Builder setBatch(String batch) {
        this.batch = batch;
        return this;
    }
}
