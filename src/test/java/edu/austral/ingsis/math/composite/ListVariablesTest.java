package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.Constant;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operations.*;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Constant constant= new Constant(1);
        Constant constant2=new Constant(6);
        Sum sum=new Sum(constant,constant2);
        sum.getVariables();
        assertThat(sum.getVariables(), empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Variable variable=new Variable("div");
        Constant constant=new Constant(12);
        Division division= new Division(constant,variable);
        assertThat(division.getVariables(), containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Constant constant=new Constant(9);
        Variable variable=new Variable("x");
        Division division=new Division(constant,variable);
        Variable variable2=new Variable("y");
        Multiplier multiplier=new Multiplier(division,variable2);
        assertThat(multiplier.getVariables(), containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Constant constant=new Constant(27);
        Variable variable=new Variable("a");
        Division division=new Division(constant,variable);
        Variable variable2=new Variable("b");
        Power power=new Power(division,variable2);
        assertThat(power.getVariables(), containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Variable variable=new Variable("z");
        Constant constant=new Constant(2);
        Root root=new Root(variable,constant);
        assertThat(root.getVariables(), containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Variable variable=new Variable("value");
        Constant constant=new Constant(8);
        Abs abs=new Abs(variable);
        Subtract subtract=new Subtract(abs,constant);
        assertThat(subtract.getVariables(), containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Variable variable=new Variable("value");
        Constant constant=new Constant(8);
        Abs abs=new Abs(variable);
        Subtract subtract=new Subtract(abs,constant);
        assertThat(subtract.getVariables(), containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Variable variable=new Variable("i");
        Constant constant=new Constant(5);
        Constant constant2=new Constant(8);
        Subtract substract=new Subtract(constant,variable);
        Multiplier multiplier=new Multiplier(substract,constant2);
        assertThat(multiplier.getVariables(), containsInAnyOrder("i"));
    }
}
