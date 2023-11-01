package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;

//Each visitor can return a different types, evaluate should return double, print should return string, etc.
public interface Visitor<T> {
    T visit(Sum sum);
    T visit(Division division);
    T visit(Multiplier multiplier);
    T visit(Subtract subtract);
    T visit(Variable variable);
    T visit(Abs abs);
    T visit (Power power);
    T visit (Root root);
    T visit (Constant constant);
}
