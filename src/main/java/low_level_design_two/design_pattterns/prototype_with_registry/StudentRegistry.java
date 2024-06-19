package low_level_design_two.design_pattterns.prototype_with_registry;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<String, Student> studentMap = new HashMap<>();

    public void register(String key, Student student) {
        this.studentMap.put(key, student);
    }

    public Student getStudentPrototype(String key) {
        //copy() called to protect the original prototype stored in the registry
        return this.studentMap.get(key).copy();
    }

    public void populateRegistry() {
        Student academyStudent = new Student();
        academyStudent.type = "Academy";
        Student sstStudent = new Student();
        sstStudent.type = "SST";
        Student ssbStudent = new Student();
        ssbStudent.type = "SSB";

        this.studentMap.put(academyStudent.type, academyStudent);
        this.studentMap.put(ssbStudent.type, ssbStudent);
        this.studentMap.put(sstStudent.type, sstStudent);
    }
}
