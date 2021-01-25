package com.dataStru.sj.sort;

import java.util.Stack;
import java.util.logging.Logger;

/**
 * @author lilibo
 * @create on 2021/1/4
 * @description
 */
public class StackSoft {
    public static Logger log = Logger.getLogger(StackSoft.class.toString());

    private static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> helper = new Stack<>();
        while (!stack.isEmpty()) {
            Integer value = stack.pop();
            while (!helper.isEmpty() && value < helper.peek()) {
                stack.push(helper.pop());
            }
            helper.push(value);
        }
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }
        log.info(String.format("%s %s", stack, stack.size()));
    }

    public static void main(String[] args) {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(8);
        integerStack.push(6);
        integerStack.push(9);
        integerStack.push(4);
        integerStack.push(12);
        sortStackByStack(integerStack);
    }
}
