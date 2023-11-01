package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public record Power(Function left, Function right) implements Function {

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
