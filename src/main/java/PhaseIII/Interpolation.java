package PhaseIII;

public class Interpolation {

    public double interpolate(double x, double x1, double y, double y1, double v){
        double interpolatedValue;
        interpolatedValue = y+(y1-y)/(x1-x)*(v-x);
        return interpolatedValue;

    }
}
