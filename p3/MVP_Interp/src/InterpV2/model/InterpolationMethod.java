package InterpV2.model;

import java.util.Vector;

/**
 * Created by atempa on 13/07/16.
 */
public interface InterpolationMethod {
    double calculateResult(double t, Vector<Double> xx, Vector<Double> yy);
}