package com.ys.calculator.operator.impl;

import com.ys.calculator.StackCache;
import com.ys.calculator.operator.Operator;

public class ClearOperatorImpl extends Operator {
    @Override
    protected void calculate(StackCache stackCache) {
        stackCache.getCurrentStack().clear();
    }

    @Override
    protected int getParamsNumber() {
        return 0;
    }
}
