package PayToBuild.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CPUCooler extends PCParts{
    int RPM;
    int size;
    List<Float> noiseLevel;
    String color;

    public CPUCooler(String name, float price, URL url, int RPM, int size, List<Float> noiseLevel, String color) {

        super(name, price, url);

        if (color == null || color.isEmpty()) {
            color = "";
        }

        if (noiseLevel == null) {
            noiseLevel = new ArrayList<>();
        }

        if (RPM < 0) {
            RPM = 0;
        }

        if (size < 0) {
            size = 0;
        }

        this.RPM = RPM;
        this.size = size;
        this.noiseLevel = noiseLevel;
        this.color = color;
    }
}
