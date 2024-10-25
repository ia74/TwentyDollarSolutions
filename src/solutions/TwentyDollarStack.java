package solutions;

import java.util.LinkedList;
import java.util.Queue;

public class TwentyDollarStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public TwentyDollarStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void add(int x) {
        push(x);
    }
    public void push(int x) {
        if(q1.isEmpty()) {
            q1.add(x);
            return;
        }
        int size = q1.size();
        for(int i = 0; i < size; i++) {
            q2.add(q1.remove());
        }
        q1.add(x);
        for(int i = 0; i < size; i++) {
            q1.add(q2.remove());
        }
    }

    public int pop() {
        if(q1.isEmpty()) return -1;
        return q1.remove();
    }

    public int peek() {
        if(q1.isEmpty()) return -1;
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}
