package PayToBuild.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PSU extends PCParts{
    int wattage;
    List<String> color;
    String modular;
    String efficiencyRate;

    public PSU(String name, float price, URL url, int wattage, List<String> color, String modular, String efficiencyRate) {

        super(name, price, url);

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


        this.wattage = wattage;
        this.color = color;
        this.modular = modular;
        this.efficiencyRate = efficiencyRate;
    }
}
