package PayToBuild.Data;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Memory extends PCParts{
    //int speedInt; Possibly need it or not
    int speed;
    int ddr;
    String modules; //e.g. 2x16GB
    float pricePRgb;
    List<String> color;
    float fwLatency;
    float casLatency;

    public Memory(String name, float price, URL url, int speed, int ddr, float pricePRgb, String modules, List<String> color, float fwLatency, float casLatency) {

        super(name, price, url);

        if (modules == null || modules.isEmpty()) {
            modules = "";
        }

        if (color == null) {
            color = new ArrayList<>();
        }

        if (speed < 0) {
            speed = 0;
        }

        if (casLatency < 0) {
            casLatency = 0.0f;
        }

        if (fwLatency < 0) {
            fwLatency = 0.0f;
        }

        if (pricePRgb < 0) {
            pricePRgb = 0.0f;
        }

        if (ddr < 0) {
            ddr = 0;
        }

        this.speed = speed;
        this.ddr = ddr;
        this.pricePRgb = pricePRgb;
        this.modules = modules;
        this.color = color;
        this.fwLatency = fwLatency;
        this.casLatency = casLatency;
    }
}
