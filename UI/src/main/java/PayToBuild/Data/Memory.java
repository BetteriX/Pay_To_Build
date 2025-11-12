package PayToBuild.Data;

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

    public Memory(int speed, float casLatency, float fwLatency, List<String> color, float pricePRgb, String modules, int ddr) {

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
        this.casLatency = casLatency;
        this.fwLatency = fwLatency;
        this.color = color;
        this.pricePRgb = pricePRgb;
        this.modules = modules;
        this.ddr = ddr;
    }
}
