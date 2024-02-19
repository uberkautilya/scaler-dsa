package advanced.module6;

public class Pair implements Comparable<Pair> {
    public int key;
    public int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Pair o) {
        return this.key - o.key;
    }
}
