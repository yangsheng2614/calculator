package com.ys.calculator;

import java.util.Deque;
import java.util.LinkedList;

public class StackCache {

    static int MAX_SIZE = 15;

    Deque<Stack> stacks = new LinkedList<>();

    public void saveStatus() {
        Stack stack = getCurrentStack();
        try {
            putStackStatus(stack.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public void putStackStatus(Stack stack) {
        stacks.push(stack);
        if (stacks.size() > MAX_SIZE) {
            stacks.removeLast();
        }
    }

    public void undo() {
        if (stacks.size() > 1) {
            stacks.pop();
        }
    }

    public Stack getCurrentStack() {
        return stacks.peek();
    }

    public void printCurrentStack() {
        stacks.peek().print();
    }
}
