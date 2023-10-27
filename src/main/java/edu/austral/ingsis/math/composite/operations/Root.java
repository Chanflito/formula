package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Root implements Function {

    private final Function left;
    private final Function right;

    public Root(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.pow(left.evaluate(map), 1 / right.evaluate(map));
    }

    @Override
    public List<String> getVariables() {
        List<String> variables = left.getVariables();
        variables.addAll(right.getVariables());
        return variables;
    }

    @Override
    public String print() {
        return left.print() + " ^ (1 / " + right.print() + ")";
    }
}
