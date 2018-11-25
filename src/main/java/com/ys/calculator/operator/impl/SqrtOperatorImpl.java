package com.ys.calculator.operator.impl;

import com.ys.calculator.NumberUtil;
import com.ys.calculator.Stack;
import com.ys.calculator.StackCache;
import com.ys.calculator.exception.OutOfRangeException;
import com.ys.calculator.exception.UnrealNumberException;
import com.ys.calculator.operator.Operator;

public class SqrtOperatorImpl extends Operator {
    @Override
    protected void calculate(StackCache stackCache) throws OutOfRangeException, UnrealNumberException {
        Stack stack = stackCache.getCurrentStack();
        double param = stack.pop();
        if (param <= 0) {
            stack.push(param);
            throw new UnrealNumberException();
        }
        double result = Math.sqrt(param);
        if (NumberUtil.isNumberOutOfRange(result)) {
            stack.push(param);
            throw new OutOfRangeException();
        }
        stack.push(result);
    }

    @Override
    protected int getParamsNumber() {
        return 1;
    }
}
