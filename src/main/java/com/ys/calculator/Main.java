package com.ys.calculator;

import com.ys.calculator.exception.InsufficientParamsException;
import com.ys.calculator.exception.OutOfRangeException;
import com.ys.calculator.exception.UnrealNumberException;
import com.ys.calculator.operator.Operator;
import com.ys.calculator.operator.OperatorUtil;

import java.text.MessageFormat;
import java.util.Scanner;

public class Main {

    static String UNRECOGNIZED_VALUE_ERROR = "Unrecognized parameter(Position: {0}).";
    static String INSUFFICIENT_PARAMETERS_ERROR = "Operator {0} (Position: {1}): insufficient parameters.";
    static String OUT_OF_RANGE_ERROR = "Operator {0} (Position: {1}): Result will be out of range.";
    static String UNREAL_NUMBER_EXCEPTION = "Operator {0} (Position: {1}): Result will be unreal.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackCache stackCache = initStackCache();

        while (true) {
            String formula = scanner.nextLine();
            calculate(formula, stackCache);
            stackCache.printCurrentStack();
        }
    }

    public static StackCache initStackCache() {
        StackCache stackCache = new StackCache();
        stackCache.putStackStatus(new Stack());
        return stackCache;
    }

    public static void calculate(String formula, StackCache stackCache) {
        int location = 0;
        for (String str : formula.split(" ")) {
            location ++;
            if (str.equals("")) continue;
            if (NumberUtil.isNumber(str)) {
                stackCache.saveStatus();
                stackCache.getCurrentStack().push(NumberUtil.getNumber(str));
            } else if (OperatorUtil.isOperator(str)) {
                Operator operator = OperatorUtil.getOperator(str);
                try {
                    operator.operate(stackCache);
                } catch (InsufficientParamsException e) {
                    stackCache.getCurrentStack().setErrorMessage(MessageFormat.format(INSUFFICIENT_PARAMETERS_ERROR, str, location));
                    break;
                } catch (OutOfRangeException e) {
                    stackCache.getCurrentStack().setErrorMessage(MessageFormat.format(OUT_OF_RANGE_ERROR, str, location));
                    break;
                } catch (UnrealNumberException e) {
                    stackCache.getCurrentStack().setErrorMessage(MessageFormat.format(UNREAL_NUMBER_EXCEPTION, str, location));
                    break;
                }

            } else {
                stackCache.getCurrentStack().setErrorMessage(MessageFormat.format(UNRECOGNIZED_VALUE_ERROR, location));
                break;
            }
            location += str.length();
        }
    }

}
