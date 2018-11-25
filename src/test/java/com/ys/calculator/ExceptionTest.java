package com.ys.calculator;

import com.ys.calculator.exception.InsufficientParamsException;
import com.ys.calculator.exception.OutOfRangeException;
import com.ys.calculator.exception.UnrealNumberException;
import com.ys.calculator.operator.Operator;
import com.ys.calculator.operator.OperatorUtil;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ExceptionTest {

    @Test(expected = InsufficientParamsException.class)
    public void testInsufficientParamsException() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(1);

        stackCache.putStackStatus(stack);

        Operator plusOperator = OperatorUtil.getOperator("+");
        plusOperator.operate(stackCache);
    }

    @Test(expected = OutOfRangeException.class)
    public void testOutOfRangeException() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(1);
        stack.push(0);

        stackCache.putStackStatus(stack);

        Operator divideOperator = OperatorUtil.getOperator("/");
        divideOperator.operate(stackCache);
    }

    @Test(expected = UnrealNumberException.class)
    public void testUnrealNumberException() throws OutOfRangeException, UnrealNumberException, InsufficientParamsException {
        StackCache stackCache = new StackCache();

        Stack stack = new Stack();
        stack.push(-1);

        stackCache.putStackStatus(stack);
        Operator sqrtOperator = OperatorUtil.getOperator("sqrt");
        sqrtOperator.operate(stackCache);
    }
}
