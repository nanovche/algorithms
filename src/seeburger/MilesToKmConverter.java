package seeburger;

public class MilesToKmConverter {

    public final double milesToKm(double miles){
        return getMilesToKmFactor() * miles;
    }

    public double getMilesToKmFactor(){
        return 1.609;
    }

    public static void main(String[] args) {
        new NauticalMilesToKmConverter().milesToKm(1);

    }

}

class NauticalMilesToKmConverter extends MilesToKmConverter {

    @Override
    public double getMilesToKmFactor(){
        return 1.852;
    }
}
