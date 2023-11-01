package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;

import java.util.ArrayList;
import java.util.List;

public class ListVariableVisitor implements Visitor<List<String>>{

    @Override
    public List<String> visit(Sum sum) {
        return combineLists(sum.left().accept(this), sum.right().accept(this));
    }

    @Override
    public List<String> visit(Division division) {
        return combineLists(division.left().accept(this), division.right().accept(this));
    }

    @Override
    public List<String> visit(Multiplier multiplier) {
        return combineLists(multiplier.left().accept(this), multiplier.right().accept(this));
    }

    @Override
    public List<String> visit(Subtract subtract) {
        return combineLists(subtract.left().accept(this), subtract.right().accept(this));
    }

    @Override
    public List<String> visit(Variable variable) {
        List<String> variables = new ArrayList<>();
        variables.add(variable.name());
        return variables;
    }

    @Override
    public List<String> visit(Abs abs) {
        return new ArrayList<>(abs.left().accept(this));
    }

    @Override
    public List<String> visit(Power power) {
        return combineLists(power.left().accept(this), power.right().accept(this));
    }

    @Override
    public List<String> visit(Root root) {
        return combineLists(root.left().accept(this), root.right().accept(this));
    }

    @Override
    public List<String> visit(Constant constant) {
        return new ArrayList<>();
    }

    private List<String> combineLists(List<String> list1, List<String> list2) {
        List<String> variables = new ArrayList<>(list1);
        variables.addAll(list2);
        return variables;
    }
}
