package com.ys.calculator;

public class Stack implements Cloneable {

    private double[] nums = new double[100];

    private int index = -1;

    public int getSize() {
        return index + 1;
    }

    private String errorMessage = null;


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void push(double num) {
        index++;
        nums[index] = num;
    }

    public double pop() {
        index--;
        return nums[index+1];
    }

    public void print() {
        if (errorMessage != null && !errorMessage.isEmpty()) {
            System.out.println(errorMessage);
            errorMessage = null;
        }
        System.out.print("stack:");
        for (int i = 0; i <= index; i++) {
            System.out.print(" " + NumberUtil.formatNumber(nums[i]));
        }
        System.out.println();
    }

    public double peek() {
        return nums[index];
    }

    public void clear() {
        nums = new double[100];
        index = -1;
    }

    @Override
    public Stack clone() throws CloneNotSupportedException {
        Stack stack = (Stack) super.clone();
        stack.nums = nums.clone();
        return stack;
    }
}
