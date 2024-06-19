package low_level_design_two.design_pattterns.prototype;

public class Student implements Prototype<Student> {
    int id;
    String name;
    String batch;

    public Student(Student st) {
        this.id = st.id;
        this.name = st.name;
        this.batch = st.batch;
    }

    @Override
    public Student copy() {
        return new Student(this);
    }
}
