package low_level_design.advanced_concepts.generics;

public class Pair <V,S> {
    private V first;
    private S second;

    public Pair(V first, S second) {
        this.first = first;
        this.second = second;
    }

    public V getFirst() {
        return this.first;
    }
    public void setFirst(V first) {
        this.first = first;
    }
    public S getSecond() {
        return this.second;
    }
    public void setSecond(S second) {
        this.second = second;
    }

    public static <T> void doSomething(T temp) {
        System.out.println(temp);
    }

    //The Z type <Z> will only be revealed at the time of method call - distinct from the V and S on the class
    public <Z> Z doAnother(Z temp){
        return temp;
    }
}
