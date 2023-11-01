package edu.austral.ingsis.math.visitor;
import edu.austral.ingsis.math.visitor.operations.*;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Visitor<Double> visitor=new EvaluateVisitor(Map.of());
        final Double result=visitor.visit(new Sum(new Constant(1),new Constant(6)));
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Visitor<Double> visitor=new EvaluateVisitor(Map.of());
        final Double result=visitor.visit(new Division(new Constant(12),new Constant(2)));
        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Visitor<Double> visitor=new EvaluateVisitor(Map.of());
        final Double result=visitor.visit(new Multiplier(new Division(new Constant(9),new Constant(2)),new Constant(3)));
        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Visitor<Double> visitor=new EvaluateVisitor(Map.of());
        final Double result=visitor.visit(new Power(new Division(new Constant(27),new Constant(6)),new Constant(2)));
        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Visitor<Double> visitor=new EvaluateVisitor(Map.of());
        final Double result=visitor.visit(new Root((new Constant(36)),new Constant(2)));
        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Visitor<Double> visitor=new EvaluateVisitor(Map.of());
        final Double result=visitor.visit(new Abs(new Constant(136)));
        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Visitor<Double> visitor=new EvaluateVisitor(Map.of());
        final Double result=visitor.visit(new Abs(new Constant(-136)));
        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Visitor<Double> visitor=new EvaluateVisitor(Map.of());
        final Double result=visitor.visit(new Multiplier(new Subtract(new Constant(5),new Constant(5)),new Constant(8)));
        assertThat(result, equalTo(0d));
    }
}
