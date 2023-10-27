package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Multiplier implements Function {

    private final Function left;
    private final Function right;

    public Multiplier(Function left, Function right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate(Map<String, Double> map) {
        return left.evaluate(map) * right.evaluate(map);
    }

    @Override
    public List<String> getVariables() {
        List<String> variables = left.getVariables();
        variables.addAll(right.getVariables());
        return variables;
    }

    @Override
    public String print() {
        return left.print() + " * " + right.print();
    }
}
