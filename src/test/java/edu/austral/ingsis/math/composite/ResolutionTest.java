package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.Constant;
import edu.austral.ingsis.math.composite.operations.*;
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
        Constant constant= new Constant(1);
        Constant constant2=new Constant(6);
        Sum sum=new Sum(constant,constant2);
        final Double result = sum.evaluate(Map.of());
        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Constant constant=new Constant(12);
        Constant constant2=new Constant(2);
        Division division=new Division(constant,constant2);
        final Double result = division.evaluate(Map.of());
        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Constant constant=new Constant(9);
        Constant constant2=new Constant(2);
        Division division=new Division(constant,constant2);
        Constant constant3=new Constant(3);
        Multiplier multiplier=new Multiplier(division,constant3);
        final Double result=multiplier.evaluate(Map.of());
        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Constant constant=new Constant(27);
        Constant constant2=new Constant(6);
        Division division=new Division(constant,constant2);
        Constant constant3=new Constant(2);
        Power power=new Power(division,constant3);
        final Double result=power.evaluate(Map.of());
        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Constant constant=new Constant(36);
        Constant constant2=new Constant(2);
        Root root=new Root(constant,constant2);
        final Double result=root.evaluate(Map.of());
        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Constant constant=new Constant(136);
        Abs abs=new Abs(constant);
        assertThat(abs.evaluate(Map.of()), equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Constant constant=new Constant(-136);
        Abs abs=new Abs(constant);
        assertThat(abs.evaluate(Map.of()), equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Constant constant=new Constant(5);
        Constant constant2=new Constant(8);
        Subtract substraction=new Subtract(constant,constant);
        Multiplier multiplier=new Multiplier(substraction,constant2);
        assertThat(multiplier.evaluate(Map.of()), equalTo(0d));
    }
}
