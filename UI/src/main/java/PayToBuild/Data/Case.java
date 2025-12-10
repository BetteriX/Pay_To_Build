package PayToBuild.Data;

import java.net.URL;

public class Case extends PCParts{
    String color;
    String type;
    int psu; //I t's empty if there is no built in PSU
    float external_volume; //It's in liters so it's useless
    String side_panel;
    int internal_35_bays;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPsu() {
        return psu;
    }

    public void setPsu(int psu) {
        this.psu = psu;
    }

    public float getExternal_volume() {
        return external_volume;
    }

    public void setExternal_volume(float external_volume) {
        this.external_volume = external_volume;
    }

    public String getSide_panel() {
        return side_panel;
    }

    public void setSide_panel(String side_panel) {
        this.side_panel = side_panel;
    }

    public int getInternal_35_bays() {
        return internal_35_bays;
    }

    public void setInternal_35_bays(int internal_35_bays) {
        this.internal_35_bays = internal_35_bays;
    }

    public Case(String name, float price, URL url, String color, String type, int psu, float  external_volume, String side_panel, int internal_35_bays) {

        super(name, price, url);

        if (color == null || color.isEmpty()) {
            color = "";
        }

        if (type == null || type.isEmpty()) {
            type = "";
        }

        if (side_panel == null || side_panel.isEmpty()) {
            side_panel = "";
        }

        if (psu < 0) {
            psu = 0;
        }

        if (external_volume < 0) {
            external_volume = 0.0f;
        }

        if (internal_35_bays< 0) {
            internal_35_bays = 0;
        }

        this.color = color;
        this.type = type;
        this.psu = psu;
        this.external_volume = external_volume;
        this.side_panel = side_panel;
        this.internal_35_bays = internal_35_bays;
    }

    @Override
    public String toString() {
        return "Case {" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", url=" + url +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                ", psu=" + psu +
                ", external_volume=" + external_volume + " L" +
                ", side_panel='" + side_panel + '\'' +
                ", internal_35_bays=" + internal_35_bays +
                '}';
    }


}
