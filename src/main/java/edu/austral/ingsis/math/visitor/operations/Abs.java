package edu.austral.ingsis.math.visitor.operations;

import edu.austral.ingsis.math.visitor.Function;
import edu.austral.ingsis.math.visitor.Visitor;

public record Abs(Function left) implements Function {

    @Override
    public <T> T accept(Visitor<T> visitor) {
        return visitor.visit(this);
    }
}
