package edu.austral.ingsis.math.composite;

import edu.austral.ingsis.math.composite.Constant;
import edu.austral.ingsis.math.composite.Variable;
import edu.austral.ingsis.math.composite.operations.*;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Constant constant=new Constant(1d);
        Map<String, Double> map=Map.of("x",3d);
        Sum sum=new Sum(constant,new Variable("x"));
        final Double result = sum.evaluate(map);
        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Constant constant=new Constant(12d);
        Map<String, Double> map=Map.of("div",4d);
        Division division=new Division(constant,new Variable("div"));
        final Double result = division.evaluate(map);
        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Constant constant=new Constant(9d);
        Map<String, Double> map=Map.of("x",3d,"y",4d);
        Division division=new Division(constant,new Variable("x"));
        Multiplier multiplier=new Multiplier(division,new Variable("y"));
        final Double result = multiplier.evaluate(map);
        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Map<String,Double> map=Map.of("a",9d,"b",3d);
        Constant constant=new Constant(27d);
        Division division=new Division(constant,new Variable("a"));
        Power power=new Power(division,new Variable("b"));
        assertThat(power.evaluate(map), equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Map<String,Double> map=Map.of("z",36d);
        Root root= new Root(new Variable("z"),new Constant(2d));
        assertThat(root.evaluate(map), equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Map<String,Double> map=Map.of("value",8d);
        Subtract substract=new Subtract(new Variable("value"),new Constant(8d));
        assertThat(substract.evaluate(map), equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Map<String,Double> map=Map.of("value",8d);
        Subtract substract=new Subtract(new Variable("value"),new Constant(8d));
        assertThat(substract.evaluate(map), equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Map<String,Double> map=Map.of("i",2d);
        Subtract substract=new Subtract(new Constant(5d),new Variable("i"));
        Multiplier multiplier=new Multiplier(substract,new Constant(8d));
        assertThat(multiplier.evaluate(map), equalTo(24d));
    }
}
