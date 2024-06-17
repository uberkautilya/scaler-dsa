package low_level_design_two.design_pattterns.builder.version5;

public class Student {
    int age;
    String name;
    int gradYear;
    String batch;

    //To prevent this constructor being called outside the class, make the constructor private
    private Student(Builder builder) {
        this.name = builder.getName();
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

    public static class Builder {
        int age;
        String name;
        int gradYear;
        String batch;

        //Constructor functionality is now taken up by the builder
        Student build() {
            //Responsibility of validations can be moved here. This ensures that memory itself wouldn't be allocated
            if (age > 200) {
                throw new RuntimeException();
            }
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
}
