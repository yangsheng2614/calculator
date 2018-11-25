package com.ys.calculator.operator;

import com.ys.calculator.StackCache;
import com.ys.calculator.exception.InsufficientParamsException;
import com.ys.calculator.exception.OutOfRangeException;
import com.ys.calculator.exception.UnrealNumberException;

public abstract class Operator {

    public void operate(StackCache stackCache) throws InsufficientParamsException, OutOfRangeException, UnrealNumberException {
        saveStatus(stackCache);
        try {
            sufficientParamsCheck(stackCache);
            calculate(stackCache);
        } catch (Exception e) {
            recoverStack(stackCache);
            throw e;
        }
    }

    void sufficientParamsCheck(StackCache stackCache) throws InsufficientParamsException {
        if (stackCache.getCurrentStack().getSize() < getParamsNumber()) {
            throw new InsufficientParamsException();
        }
    }

    protected abstract void calculate(StackCache stackCache) throws OutOfRangeException, UnrealNumberException;

    protected abstract int getParamsNumber();

    protected void saveStatus(StackCache stackCache) {
        stackCache.saveStatus();
    }

    protected void recoverStack(StackCache stackCache) {
        stackCache.undo();
    }
}
