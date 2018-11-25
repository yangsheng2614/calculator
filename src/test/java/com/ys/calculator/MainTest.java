package com.ys.calculator;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class MainTest {

    @Test
    public void test() {
        String formula1 = "1 2 + 3 4 * 9 sqrt - 2 /";
        String formula2 = "clear";
        String formula3 = "undo";

        StackCache stackCache = Main.initStackCache();
        Main.calculate(formula1, stackCache);

        Stack stack1 = stackCache.getCurrentStack();
        assertTrue(stack1.getSize() == 2);
        assertTrue(stack1.peek() == 4.5);

        Main.calculate(formula2, stackCache);
        Stack stack2 = stackCache.getCurrentStack();
        assertTrue(stack2.getSize() == 0);

        Main.calculate(formula3, stackCache);
        Stack stack3 = stackCache.getCurrentStack();
        assertTrue(stack1 == stack3);
    }
}
