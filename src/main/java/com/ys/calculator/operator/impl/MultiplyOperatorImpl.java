package com.ys.calculator.operator.impl;

import com.ys.calculator.NumberUtil;
import com.ys.calculator.Stack;
import com.ys.calculator.StackCache;
import com.ys.calculator.exception.OutOfRangeException;
import com.ys.calculator.operator.Operator;

public class MultiplyOperatorImpl extends Operator {
    @Override
    protected void calculate(StackCache stackCache) throws OutOfRangeException {
        Stack stack = stackCache.getCurrentStack();
        double param2 = stack.pop(), param1 = stack.pop();
        double result = param1 * param2;
        if (NumberUtil.isNumberOutOfRange(result)) {
            stack.push(param1);
            stack.push(param2);
            throw new OutOfRangeException();
        }
        stack.push(result);
    }

    @Override
    protected int getParamsNumber() {
        return 2;
    }
}
