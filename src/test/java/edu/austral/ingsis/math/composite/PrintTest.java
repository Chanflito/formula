package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.Constant;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operations.*;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "1.0 + 6.0";
        Constant constant= new Constant(1);
        Constant constant2=new Constant(6);
        Sum sum=new Sum(constant,constant2);

        assertThat(sum.print(), equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "(12.0 / 2.0)";
        Constant constant=new Constant(12);
        Constant constant2=new Constant(2);
        Division division=new Division(constant,constant2);
        assertThat(division.print(), equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9.0 / 2.0) * 3.0";
        Constant constant=new Constant(9);
        Constant constant2=new Constant(2);
        Constant constant3=new Constant(3);
        Division division=new Division(constant,constant2);
        Multiplier multiplier=new Multiplier(division,constant3);
        assertThat(multiplier.print(), equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "(27.0 / 6.0) ^ 2.0";
        Constant constant=new Constant(27);
        Constant constant2=new Constant(6);
        Constant constant3=new Constant(2);
        Division division=new Division(constant,constant2);
        Power power=new Power(division,constant3);
        assertThat(power.print(), equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = "(|value| - 8.0)";
        Variable variable=new Variable("value");
        Constant constant=new Constant(8);
        Abs abs=new Abs(variable);
        Subtract substract=new Subtract(abs,constant);
        final String result = substract.print();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "(|value| - 8.0)";
        Variable variable=new Variable("value");
        Constant constant=new Constant(8); //Same as previous test.
        Abs abs=new Abs(variable);
        Subtract substract=new Subtract(abs,constant);
        final String result = substract.print();
        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "(5.0 - i) * 8.0";
        Variable variable=new Variable("i");
        Constant constant=new Constant(5);
        Constant constant2=new Constant(8);
        Subtract substract=new Subtract(constant,variable);
        Multiplier multiplier=new Multiplier(substract,constant2);
        assertThat(multiplier.print(), equalTo(expected));
    }
}
