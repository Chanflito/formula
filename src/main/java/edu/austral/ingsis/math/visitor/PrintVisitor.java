package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;

public class PrintVisitor implements Visitor<String>{
    @Override
    public String visit(Sum sum) {
        return "("+ sum.left().accept(this) + " + " + sum.right().accept(this)+ ")";
    }

    @Override
    public String visit(Division division) {
        return "("+ division.left().accept(this) + " / " + division.right().accept(this)+ ")";
    }

    @Override
    public String visit(Multiplier multiplier) {
        return "("+ multiplier.left().accept(this) + " * " + multiplier.right().accept(this)+ ")";
    }

    @Override
    public String visit(Subtract subtract) {
        return "("+ subtract.left().accept(this) + " - " + subtract.right().accept(this)+ ")";
    }

    @Override
    public String visit(Variable variable) {
        return variable.name();
    }

    @Override
    public String visit(Abs abs) {
        return "|"+ abs.left().accept(this) + "|";
    }

    @Override
    public String visit(Power power) {
        return "("+ power.left().accept(this) + " ^ " + power.right().accept(this)+ ")";
    }

    @Override
    public String visit(Root root) {
        return root.left().accept(this) + " ^ (1 / " + root.right().accept(this)+ ")";
    }

    @Override
    public String visit(Constant constant) {
        return String.valueOf(constant.value());
    }
}
