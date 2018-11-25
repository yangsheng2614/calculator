package com.ys.calculator.operator.impl;

import com.ys.calculator.StackCache;
import com.ys.calculator.operator.Operator;

public class UndoOperatorImpl extends Operator {
    @Override
    protected void calculate(StackCache stackCache) {
        stackCache.undo();
    }

    @Override
    protected int getParamsNumber() {
        return 0;
    }

    @Override
    protected void saveStatus(StackCache stackCache) {

    }
}
