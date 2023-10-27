package edu.austral.ingsis.math.composite.operations;

import edu.austral.ingsis.math.composite.Function;

import java.util.List;
import java.util.Map;

public class Abs implements Function {
    private final Function value;

    public Abs(Function value) {
        this.value = value;
    }
    @Override
    public double evaluate(Map<String, Double> map) {
        return Math.abs(value.evaluate(map));
    }

    @Override
    public List<String> getVariables() {
        return value.getVariables();
    }

    @Override
    public String print() {
        return "abs(" + value.print() + ")";
    }
}
