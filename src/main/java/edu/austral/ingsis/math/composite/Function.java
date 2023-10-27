package edu.austral.ingsis.math.composite;

import java.util.List;
import java.util.Map;

public interface Function {
    double evaluate(Map<String,Double> map);
    List<String> getVariables();
    String print();

}
