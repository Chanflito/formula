package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public class Constant implements Function{

    private final double value;

    public Constant(double value) {
        this.value = value;
    }
    @Override
    public double evaluate(Map<String, Double> map) {
        return value;
    }

    @Override
    public List<String> getVariables() {
        return List.of();
    }

    @Override
    public String print() {
        return String.valueOf(value);
    }
}
