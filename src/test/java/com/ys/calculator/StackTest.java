package com.ys.calculator;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class StackTest {

    @Test
    public void testStack() {
        Stack stack = new Stack();
        stack.push(0);
        stack.push(1);
        stack.push(2);

        assertTrue(stack.pop() == 2);
        assertTrue(stack.peek() == 1);

        assertTrue(stack.getSize() == 2);
        stack.clear();
        assertTrue(stack.getSize() == 0);
    }

    @Test
    public void testStackCache() {
        StackCache stackCache = new StackCache();
        Stack stack1 = new Stack();
        stack1.push(1);
        stack1.push(2);

        stackCache.putStackStatus(stack1);
        stackCache.saveStatus();

        Stack stack2 = stackCache.getCurrentStack();
        stack2.push(3);

        assertTrue(stack1 != stack2);
        assertTrue(stack1.peek() == 2);

        stackCache.undo();

        stack2 = stackCache.getCurrentStack();
        assertTrue(stack1 == stack2);
    }

    @Test
    public void testPrint() {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        PrintStream console = System.out;
        System.setOut(new PrintStream(bytes));

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.setErrorMessage("error");
        stack.print();
        System.setOut(console);

        String str1 = new String("error\r\nstack: 1 2\r\n");
        String str2 = new String("error\nstack: 1 2\n");

        assertTrue(str1.equals(bytes.toString()) || str2.equals(bytes.toString()));

    }
}
