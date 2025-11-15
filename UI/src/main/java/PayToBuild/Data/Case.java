package PayToBuild.Data;

import java.net.URL;

public class Case extends PCParts{
    String color;
    String type;
    int psuInWatt; //I t's empty if there is no built in PSU
    float externalVolume; //It's in liters so it's useless
    String sidePanel;
    int internal35bay;

    public Case(String name, float price, URL url, String color, String type, int psuInWatt, float externalVolume, String sidePanel, int internal35bay) {

        super(name, price, url);

        if (color == null || color.isEmpty()) {
            color = "";
        }

        if (type == null || type.isEmpty()) {
            type = "";
        }

        if (sidePanel == null || sidePanel.isEmpty()) {
            sidePanel = "";
        }

        if (psuInWatt < 0) {
            psuInWatt = 0;
        }

        if (externalVolume < 0) {
            externalVolume = 0.0f;
        }

        if (internal35bay < 0) {
            internal35bay = 0;
        }

        this.color = color;
        this.type = type;
        this.psuInWatt = psuInWatt;
        this.externalVolume = externalVolume;
        this.sidePanel = sidePanel;
        this.internal35bay = internal35bay;
    }
}
