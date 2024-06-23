package low_level_design_two.design_pattterns.creational.builder.version3;

public class Builder {
    int age;
    String name;
    int gradYear;
    String batch;

    public int getAge() {
        return age;
    }

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
