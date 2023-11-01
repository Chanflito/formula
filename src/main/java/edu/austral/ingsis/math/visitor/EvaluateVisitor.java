package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;

import java.util.Map;

public class EvaluateVisitor implements Visitor<Double>{
    private final Map<String,Double> variables;

    public EvaluateVisitor(Map<String, Double> variables) {
        this.variables = variables;
    }

    @Override
    public Double visit(Sum sum) {
        return sum.left().accept(this) + sum.right().accept(this);
    }

    @Override
    public Double visit(Division division) {
        return division.left().accept(this) / division.right().accept(this);
    }

    @Override
    public Double visit(Multiplier multiplier) {
        return multiplier.left().accept(this) * multiplier.right().accept(this);
    }

    @Override
    public Double visit(Subtract subtract) {
        return subtract.left().accept(this) - subtract.right().accept(this);
    }

    @Override
    public Double visit(Variable variable) {
        return variables.get(variable.name());
    }

    @Override
    public Double visit(Abs abs) {
        return Math.abs(abs.left().accept(this));
    }

    @Override
    public Double visit(Power power) {
        return Math.pow(power.left().accept(this), power.right().accept(this));
    }

    @Override
    public Double visit(Root root) {
        return Math.pow(root.left().accept(this), 1/root.right().accept(this));
    }

    @Override
    public Double visit(Constant constant) {
        return constant.value();
    }
}
