package low_level_design_two.design_pattterns.creational.prototype;

public class IntelligentStudent extends Student {
    int iQ;

    public IntelligentStudent(IntelligentStudent st) {
        super(st);
        this.iQ = st.iQ;
    }

    @Override
    public IntelligentStudent copy() {
        IntelligentStudent copy = new IntelligentStudent(this);
        copy.id = this.id;
        copy.name = this.name;
        copy.batch = this.batch;
        copy.iQ = this.iQ;
        return copy;
    }
}
