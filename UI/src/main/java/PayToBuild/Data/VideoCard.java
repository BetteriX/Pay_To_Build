package PayToBuild.Data;

import java.util.List;

public class VideoCard extends PCParts{
    int memory; //e.g. 16GB
    List<String> color;
    int coreClock; //MHz
    int boostClock;//MHz
    int length;
    String chipset;

    public VideoCard(int memory, List<String> color, int coreClock, int boostClock, int length, String chipset) {

        if (color == null) {
            color = new ArrayList<>();
        }

        if (chipset == null || chipset.isEmpty()) {
            chipset = "";
        }

        if (memory < 0) {
            memory = 0;
        }

        if (coreClock < 0) {
            coreClock = 0;
        }

        if (boostClock < 0) {
            boostClock = 0;
        }

        if (length < 0) {
            length = 0;
        }

        this.memory = memory;
        this.color = color;
        this.coreClock = coreClock;
        this.boostClock = boostClock;
        this.length = length;
        this.chipset = chipset;
    }
}
