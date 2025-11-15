package PayToBuild.Data;

import java.net.URL;

public class CPU extends PCParts{
    int coreCount;
    float coreClock;
    float coreBoost;
    String microArchitecture;
    int TDP;
    String graphic; //built in

    public CPU(String name, float price, URL url, int coreCount, float coreClock, float coreBoost, String microArchitecture, int TDP, String graphic) {

        super(name, price, url);

        if (microArchitecture == null || microArchitecture.isEmpty()) {
            microArchitecture = "";
        }

        if (graphic == null || graphic.isEmpty()) {
            graphic = "";
        }

        if (coreCount < 0) {
            coreCount = 0;
        }

        if (coreClock < 0) {
            coreClock = 0.0f;
        }

        if (coreBoost < 0) {
            coreBoost = 0.0f;
        }

        if (TDP < 0) {
            TDP = 0;
        }

        this.coreCount = coreCount;
        this.coreClock = coreClock;
        this.coreBoost = coreBoost;
        this.microArchitecture = microArchitecture;
        this.TDP = TDP;
        this.graphic = graphic;
    }
}
