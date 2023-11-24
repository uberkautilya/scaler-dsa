package advanced.module6.stacks;

import java.util.ArrayList;

public class CustomStack {
    ArrayList<Integer> data = new ArrayList<>();
    int index = -1;
    int size = 0;
    public boolean isEmpty() {
        return index == -1;
    }

    public void push(Integer dataInput) {
        if (index + 1 == size) {
            //Stack Overflow
            return;
        }
        data.set(++index, dataInput);
    }
    public Integer pop() {
        Integer content = data.get(index);
        index--;
        return content;
    }

    public Integer peek() {
        if (!isEmpty()) {
            return data.get(index);
        }
        return Integer.MIN_VALUE;
    }
}
