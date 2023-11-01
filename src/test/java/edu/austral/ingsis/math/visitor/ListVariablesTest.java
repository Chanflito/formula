package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.visitor.operations.*;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
public class ListVariablesTest {
    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Visitor<List<String>> visitor=new ListVariableVisitor();
        final List<String> result=visitor.visit(new Sum(new Constant(1),new Constant(6)));
        assertThat(result, containsInAnyOrder());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Visitor<List<String>> visitor=new ListVariableVisitor();
        final List<String> result=visitor.visit(new Division(new Constant(12),new Variable("div")));
        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Visitor<List<String>> visitor=new ListVariableVisitor();
        final List<String> result=visitor.visit(new Multiplier(new Division(new Constant(9),new Variable("x")),new Variable("y")));
        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Visitor<List<String>> visitor=new ListVariableVisitor();
        final List<String> result=visitor.visit(new Power(new Division(new Constant(27),new Variable("a")),new Variable("b")));
        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Visitor<List<String>> visitor=new ListVariableVisitor();
        final List<String> result=visitor.visit(new Root((new Variable("z")),new Constant(2)));
        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Visitor<List<String>> visitor=new ListVariableVisitor();
        final List<String> result=visitor.visit(new Subtract(new Abs(new Variable("value")),new Constant(8)));

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Visitor<List<String>> visitor=new ListVariableVisitor();
        final List<String> result=visitor.visit(new Subtract(new Abs(new Variable("value")),new Constant(8)));
        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Visitor<List<String>> visitor=new ListVariableVisitor();
        final List<String> result=visitor.visit(new Multiplier(new Subtract(new Constant(5),new Variable("i")),new Constant(8)));
        assertThat(result, containsInAnyOrder("i"));
    }
}
