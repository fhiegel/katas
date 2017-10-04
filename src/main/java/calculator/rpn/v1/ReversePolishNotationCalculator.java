package calculator.rpn.v1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class ReversePolishNotationCalculator {

    public String evaluate(String input) {
        String[] inputAsArray = input.split(" ");
        LinkedList<String> inputAsList = new LinkedList<>(Arrays.asList(inputAsArray));
        Stack<String> result = new Stack<>();

        return String.join(" ", result);
    }

}
