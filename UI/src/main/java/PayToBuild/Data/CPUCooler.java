package PayToBuild.Data;

import java.util.List;

public class CPUCooler extends PCParts{
    int RPM;
    int size;
    List<Float> noiseLevel;
    String color;

    public CPUCooler(String color, List<Float> noiseLevel, int RPM, int size) {

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

        this.color = color;
        this.noiseLevel = noiseLevel;
        this.RPM = RPM;
        this.size = size;
    }
}
