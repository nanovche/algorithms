package company1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;

public class CropRatio {
    private int totalWeight = 1;
    private HashMap<String, Integer> crops = new HashMap<String, Integer>();

/*    public void addIt(String name, int cropWeight) {
        Integer currentCropWeight = crops.get(name);

        if (currentCropWeight == null) {
            crops.put(name, currentCropWeight);
        }

        cropWeight += cropWeight;
        totalWeight++;
    }*/

    public void add(String name, int cropWeight) {
        Integer val = crops.get(name) == null ? crops.put(name, cropWeight) : crops.put(name, crops.get(name) + cropWeight);
    }

    public double proportion(String name) {
        return BigDecimal.valueOf(totalWeight).divide(BigDecimal.valueOf(crops.get(name)), RoundingMode.HALF_EVEN).doubleValue();
    }

    public static void main(String[] args) {

        CropRatio cropRatio = new CropRatio();
        cropRatio.add("Wheat", 4);
        cropRatio.add("Wheat", 5);
        cropRatio.add("Rice", 1);

        System.out.println("Fraction of wheat: " + cropRatio.proportion("Wheat"));
    }
}