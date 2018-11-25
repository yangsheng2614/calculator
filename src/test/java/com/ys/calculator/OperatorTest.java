package com.ys.calculator;

import com.ys.calculator.exception.InsufficientParamsException;
import com.ys.calculator.exception.OutOfRangeException;
import com.ys.calculator.exception.UnrealNumberException;
import com.ys.calculator.operator.Operator;
import com.ys.calculator.operator.OperatorUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OperatorTest {

    @Test
    public void testPlus() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);

        stackCache.putStackStatus(stack);

        Operator plusOperator = OperatorUtil.getOperator("+");
        plusOperator.operate(stackCache);

        stack = stackCache.getCurrentStack();
        assertTrue(stack.peek() == 3);
    }

    @Test
    public void testMinus() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);

        stackCache.putStackStatus(stack);

        Operator minusOperator = OperatorUtil.getOperator("-");
        minusOperator.operate(stackCache);

        stack = stackCache.getCurrentStack();
        assertTrue(stack.peek() == -1);
    }

    @Test
    public void testDivide() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);

        stackCache.putStackStatus(stack);

        Operator divideOperator = OperatorUtil.getOperator("/");
        divideOperator.operate(stackCache);

        stack = stackCache.getCurrentStack();
        assertTrue(stack.peek() == 0.5);
    }

    @Test
    public void testMultiply() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(3);
        stack.push(4);

        stackCache.putStackStatus(stack);

        Operator multiplyOperator = OperatorUtil.getOperator("*");
        multiplyOperator.operate(stackCache);

        stack = stackCache.getCurrentStack();
        assertTrue(stack.peek() == 12);
    }

    @Test
    public void testSqrt() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(4);

        stackCache.putStackStatus(stack);

        Operator sqrtOperator = OperatorUtil.getOperator("sqrt");
        sqrtOperator.operate(stackCache);

        stack = stackCache.getCurrentStack();
        assertTrue(stack.peek() == 2);
    }

    @Test
    public void testClear() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);

        stackCache.putStackStatus(stack);

        Operator clearOperator = OperatorUtil.getOperator("clear");
        clearOperator.operate(stackCache);

        stack = stackCache.getCurrentStack();
        assertTrue(stack.getSize() == 0);
    }

    @Test
    public void testUndo() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);

        stackCache.putStackStatus(stack);

        Operator plusOperator = OperatorUtil.getOperator("+");
        plusOperator.operate(stackCache);

        stack = stackCache.getCurrentStack();
        assertTrue(stack.peek() == 3);

        Operator undoOperator = OperatorUtil.getOperator("undo");
        undoOperator.operate(stackCache);

        stack = stackCache.getCurrentStack();
        assertTrue(stack.peek() == 2);
        assertTrue(stack.getSize() == 2);
    }

}
