package com.ys.calculator.operator;

import com.ys.calculator.operator.impl.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OperatorUtil {

    public enum Operator {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        SQRT("sqrt"),
        CLEAR("clear"),
        UNDO("undo");

        Operator(String name) {
            this.name = name;
        }

        private String name;
        public String getName() {return this.name;}
    }

    static Map<String, com.ys.calculator.operator.Operator> operatorMap;

    static {
        operatorMap = new HashMap<>();
        operatorMap.put(Operator.PLUS.getName(), new PlusOperatorImpl());
        operatorMap.put(Operator.MINUS.getName(), new MinusOperatorImpl());
        operatorMap.put(Operator.DIVIDE.getName(), new DivideOperatorImpl());
        operatorMap.put(Operator.MULTIPLY.getName(), new MultiplyOperatorImpl());
        operatorMap.put(Operator.SQRT.getName(), new SqrtOperatorImpl());
        operatorMap.put(Operator.CLEAR.getName(), new ClearOperatorImpl());
        operatorMap.put(Operator.UNDO.getName(), new UndoOperatorImpl());
    }


    public static boolean isOperator(String str) {
        return Arrays.stream(Operator.values()).anyMatch(o -> o.getName().equals(str));
    }

    public static com.ys.calculator.operator.Operator getOperator(String str) {
        return operatorMap.get(str);
    }

}
