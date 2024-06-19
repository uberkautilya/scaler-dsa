package low_level_design_two.design_pattterns.prototype_with_registry;

public class Student implements Prototype<Student> {
    int id;
    String name;
    String batch;
    String type;

    public Student(Student st) {
        this.id = st.id;
        this.name = st.name;
        this.batch = st.batch;
        this.type = st.type;
    }

    public Student() {

    }

    @Override
    public Student copy() {
        return new Student(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "batch='" + batch + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
