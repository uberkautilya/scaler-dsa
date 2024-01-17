package advanced.module7.graphs;

public class Node {
    Integer id;
    String str;

    public Node(Integer id, String str) {
        this.id = id;
        this.str = str;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Node{" +
                "id=" + id +
                ", str='" + str + '\'' +
                '}';
    }
}
