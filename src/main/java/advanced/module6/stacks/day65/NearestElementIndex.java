package advanced.module6.stacks.day65;

import advanced.module6.stacks.CustomStack;

import java.util.ArrayList;

public class NearestElementIndex {
    CustomStack stack;
    ArrayList<Integer> result;


    public ArrayList<Integer> nearestSmallerOnLeftIndices(ArrayList<Integer> data) {
        //This stack will hold the index of the closest smaller element on the left of each element
        stack = new CustomStack();
        result = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            Integer val = data.get(i);
            while (!stack.isEmpty() && data.get(stack.peek()) >= val) {
                //Pop off the values larger than current element, as their closer smaller neighbour will be current value in such a case
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.set(i, -1);
            } else {
                result.set(i, stack.peek());
            }
            stack.push(i);
        }
        return result;
    }

    public ArrayList<Integer> nearestSmallerOnRightIndices(ArrayList<Integer> data) {
        //This stack will hold the index of the closest smaller element on the right of each element
        stack = new CustomStack();
        result = new ArrayList<>();

        for (int i = data.size() - 1; i >= 0; i--) {
            Integer val = data.get(i);
            while (!stack.isEmpty() && data.get(stack.peek()) >= val) {
                //Pop off the values larger than current element, as their closer smaller neighbour will be current value in such a case
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.set(i, -1);
            } else {
                result.set(i, stack.peek());
            }
            stack.push(i);
        }
        return result;
    }

    public ArrayList<Integer> nearestLargerOnRightIndices(ArrayList<Integer> data) {
        //This stack will hold the index of the closest larger element on the right of each element
        stack = new CustomStack();
        result = new ArrayList<>();

        for (int i = data.size() - 1; i >= 0; i--) {
            Integer val = data.get(i);
            while (!stack.isEmpty() && data.get(stack.peek()) <= val) {
                //Pop off the values larger than current element, as their closer larger neighbour will be current value in such a case
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.set(i, -1);
            } else {
                result.set(i, stack.peek());
            }
            stack.push(i);
        }
        return result;
    }

    public ArrayList<Integer> nearestLargerOnLeftIndices(ArrayList<Integer> data) {
        //This stack will hold the index of the closest larger element on the left of each element
        stack = new CustomStack();
        result = new ArrayList<>();

        for (int i = 0; i < data.size(); i++) {
            Integer val = data.get(i);
            while (!stack.isEmpty() && data.get(stack.peek()) <= val) {
                //Pop off the values larger than current element, as their closer larger neighbour will be current value in such a case
                stack.pop();
            }
            if (stack.isEmpty()) {
                result.set(i, -1);
            } else {
                result.set(i, stack.peek());
            }
            stack.push(i);
        }
        return result;
    }
}
