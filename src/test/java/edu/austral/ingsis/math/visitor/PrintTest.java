package edu.austral.ingsis.math.visitor;
import edu.austral.ingsis.math.visitor.operations.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "(1.0 + 6.0)";
        Visitor<String> visitor=new PrintVisitor();
        final String result=visitor.visit(new Sum(new Constant(1),new Constant(6)));
        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "(12.0 / 2.0)";
        Visitor<String> visitor=new PrintVisitor();
        final String result=visitor.visit(new Division(new Constant(12),new Constant(2)));

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "((9.0 / 2.0) * 3.0)";
        Visitor<String> visitor=new PrintVisitor();
        final String result=visitor.visit(new Multiplier(new Division(new Constant(9),new Constant(2)),new Constant(3)));
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "((27.0 / 6.0) ^ 2.0)";
        Visitor<String> visitor=new PrintVisitor();
        final String result=visitor.visit(new Power(new Division(new Constant(27),new Constant(6)),new Constant(2)));
        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "(|value| - 8.0)";
        Visitor<String> visitor=new PrintVisitor();
        final String result=visitor.visit(new Subtract(new Abs(new Variable("value")),new Constant(8)));
        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "(|value| - 8.0)";
        Visitor<String> visitor=new PrintVisitor();
        final String result=visitor.visit(new Subtract(new Abs(new Variable("value")),new Constant(8)));
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "((5.0 - i) * 8.0)";
        Visitor<String> visitor=new PrintVisitor();
        final String result=visitor.visit(new Multiplier(new Subtract(new Constant(5),new Variable("i")),new Constant(8)));
        assertThat(result, equalTo(expected));
    }
}
