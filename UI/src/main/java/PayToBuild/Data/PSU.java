package PayToBuild.Data;

import java.util.List;

public class PSU extends PCParts{
    int wattage;
    List<String> color;
    String modular;
    String efficiencyRate;

    public PSU(String efficiencyRate, String modular, List<String> color, int wattage) {

        if (efficiencyRate == null || efficiencyRate.isEmpty()) {
            efficiencyRate = "";
        }

        if (modular == null || modular.isEmpty()) {
            modular = "";
        }

        if (color == null) {
            color = new ArrayList<>();
        }

        if (wattage < 0) {
            wattage = 0;
        }

        this.efficiencyRate = efficiencyRate;
        this.modular = modular;
        this.color = color;
        this.wattage = wattage;
    }
}
