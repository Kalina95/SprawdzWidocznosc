package PhaseIII;

public class InclinationCalculator {
    public double calculateInclination(Double kmStart, Double hStart, Double kmEnd, Double hEnd){
        double length;
        double heightDifference;
        length = kmEnd-kmStart;
        heightDifference = hEnd-hStart;

        double inclination;
        inclination=heightDifference/length*100;

        return inclination;
    }
}
